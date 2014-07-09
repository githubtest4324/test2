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

		new TableTagTemplate().renderNoFlush(out, entities);
	}

	public void setEntities(List<Serializable> entities) {
		this.entities = entities;
	}

}
