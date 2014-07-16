package test2.tags;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import test2.SmartTableTemplate;

@Component
public class SmartTable extends SimpleTagSupport {

	private List<Serializable> entities;
	private String tableId;
	private String selectedIds;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (StringUtils.isEmpty(tableId)) {
			tableId = new Integer((int) (Math.random() * 1000)).toString();
		}
		new SmartTableTemplate().renderNoFlush(out, entities, tableId, selectedIds);
	}

	public void setEntities(List<Serializable> entities) {
		this.entities = entities;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}

}
