package test2.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FormBoxTag extends SimpleTagSupport {
	private String title;

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter jspBodyContent = new StringWriter();
		JspWriter out = getJspContext().getOut();
		JspFragment jspBody = getJspBody();
		jspBody.invoke(jspBodyContent);

		// Build output
		out.append("<div class='box'>");
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
