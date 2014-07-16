package test2.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Logical section in a form with vertically aligned columns.
 * 
 */
public class FormSection extends SimpleTagSupport {
	private String title;

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter jspBodyContent = new StringWriter();
		JspWriter out = getJspContext().getOut();
		JspFragment jspBody = getJspBody();
		jspBody.invoke(jspBodyContent);

		// Build output
		out.append("<div style='display: flex;flex-direction: column;align-items: stretch;padding: 10px;'>");
		if (title != null) {
			out.append(String.format("<div style='text-align: left;'><span>%s</span></div><hr/>", title));
		}
		out.append(jspBodyContent.toString());
		out.append("</div>");
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
