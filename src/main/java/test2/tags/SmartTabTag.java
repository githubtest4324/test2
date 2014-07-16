package test2.tags;

import static test2.tags.SmartTabsTag.TAB_INFO;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import test2.SmartTabTagTemplate;

public class SmartTabTag extends SimpleTagSupport {
	public class TabInfo {
		public String title;
		public String uuid;
	}

	private String title;

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter jspBodyContent = new StringWriter();
		JspWriter out = getJspContext().getOut();
		JspFragment jspBody = getJspBody();
		jspBody.invoke(jspBodyContent);

		// Add tab to info, to be referenced later by SmartTabsTag
		@SuppressWarnings("unchecked")
		List<TabInfo> info = (List<TabInfo>) getJspContext().getAttribute(TAB_INFO);
		if (info == null) {
			info = new ArrayList<TabInfo>();
			getJspContext().setAttribute(TAB_INFO, info);
		}
		TabInfo ti = new TabInfo();
		ti.title = title;
		ti.uuid = UUID.randomUUID().toString();
		info.add(ti);

		// Build output
		new SmartTabTagTemplate().renderNoFlush(out, ti.uuid, jspBodyContent.toString());
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
