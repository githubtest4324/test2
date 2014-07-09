package test2.tags;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.stereotype.Component;

import test2.TableTagTemplate;

@Component
public class TableTag extends SimpleTagSupport {

	private List<Serializable> entities;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		// out.append("<table style='width: 100%;'>");
		// // Header
		// out.append("<tr>");
		// out.append(String.format("<th>%s</th>", "Name"));
		// out.append(String.format("<th>%s</th>", "Username"));
		// out.append("</tr>");
		//
		// // Content
		// for (Serializable entity : entities) {
		// User user = (User) entity;
		// out.append("<tr>");
		// out.append(String.format("<td>%s</td>", user.getName()));
		// out.append(String.format("<td>%s</td>", user.getUsername()));
		// out.append("</tr>");
		// }
		// out.append("</table>");
		new TableTagTemplate().renderNoFlush(out, entities);
	}

	public void setEntities(List<Serializable> entities) {
		this.entities = entities;
	}

}
