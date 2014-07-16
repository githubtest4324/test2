package test2.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import test2.SmartTabsTagTemplate;
import test2.tags.SmartTabTag.TabInfo;

public class SmartTabsTag extends SimpleTagSupport {
	public static final String TAB_INFO = "tabInfo";

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter jspBodyContent = new StringWriter();
		JspWriter out = getJspContext().getOut();
		JspFragment jspBody = getJspBody();
		jspBody.invoke(jspBodyContent);

		@SuppressWarnings("unchecked")
		List<TabInfo> ti = (List<TabInfo>) getJspContext().getAttribute(TAB_INFO);
		String tabsUuid = UUID.randomUUID().toString();

		// Build output
		new SmartTabsTagTemplate().renderNoFlush(out, tabsUuid, ti, jspBodyContent.toString());

		getJspContext().setAttribute(TAB_INFO, null);
	}
}
