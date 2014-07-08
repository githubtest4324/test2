package test2.tags;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DebutRequestAttributesTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		HttpServletRequest request = ((HttpServletRequest) ((PageContext) getJspContext()).getRequest());
		out.append("Request attributes");
		out.append("<table>");
		// Header
		out.append("<tr>");
		out.append(String.format("<th>%s</th>", "Name"));
		out.append(String.format("<th>%s</th>", "Value"));
		out.append("</tr>");

		// Content
		Enumeration reqAttrs = request.getAttributeNames();
		while (reqAttrs.hasMoreElements()) {
			String name = (String) reqAttrs.nextElement();
			String value = request.getAttribute(name).toString();
			out.append("<tr>");
			out.append(String.format("<td>%s</td>", name));
			out.append(String.format("<td>%s</td>", value));
			out.append("</tr>");
		}
		out.append("</table>");
	}
}
