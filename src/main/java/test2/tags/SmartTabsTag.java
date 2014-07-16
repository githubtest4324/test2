package test2.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

import javax.persistence.metamodel.SetAttribute;
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

		// Hold a reference to current context info. Just in case this tab widget is situated within another tab widget.
		@SuppressWarnings("unchecked")
		List<TabInfo> oldTabInfo = (List<TabInfo>) getJspContext().getAttribute(TAB_INFO);

		// Evaluate content
		JspFragment jspBody = getJspBody();
		getJspContext().setAttribute(TAB_INFO, null); // Will be filled during invoke()
		jspBody.invoke(jspBodyContent);
		@SuppressWarnings("unchecked")
		List<TabInfo> tabInfo = (List<TabInfo>) getJspContext().getAttribute(TAB_INFO);
		String tabsUuid = UUID.randomUUID().toString();

		// If no tab is active, set the first one
		boolean hasActiveTab = false;
		for (TabInfo t : tabInfo) {
			if (t.active) {
				hasActiveTab = true;
				break;
			}
		}
		if (!hasActiveTab && tabInfo.size() > 0) {
			tabInfo.get(0).active = true;
		}

		// Build output
		new SmartTabsTagTemplate().renderNoFlush(out, tabsUuid, tabInfo, jspBodyContent.toString());

		getJspContext().setAttribute(TAB_INFO, oldTabInfo);
	}
}
