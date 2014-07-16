package test2.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Logical field formed by a label (optional) and a form element, horizontally aligned.
 */
public class FormField extends SimpleTagSupport {
	private String label;

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter jspBodyContent = new StringWriter();
		JspWriter out = getJspContext().getOut();
		JspFragment jspBody = getJspBody();
		jspBody.invoke(jspBodyContent);

		// Build output
		out.append("<div style='display: flex;flex-direction: row;align-items: center;'>");
		if (label != null) {
			out.append(String.format("<span>%s</span>", label));
		}
		out.append(jspBodyContent.toString());
		out.append("</div>");
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
