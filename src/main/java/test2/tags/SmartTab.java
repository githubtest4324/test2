package test2.tags;

import static test2.tags.SmartTabs.TAB_INFO;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import test2.SmartTabTemplate;

public class SmartTab extends SimpleTagSupport {
	public class TabInfo {
		public String title;
		public String uuid;
		public Boolean active;
	}

	private String title;
	private boolean active;

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
		ti.active = active;
		info.add(ti);

		// Build output
		new SmartTabTemplate().renderNoFlush(out, ti.uuid, jspBodyContent.toString());
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
