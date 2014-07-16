package test2.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import test2.utils.TagUtils;
import test2.utils.TagUtils.FlexAlign;
import test2.utils.TagUtils.FlexDirection;
import test2.utils.TagUtils.FlexJustify;

public class Column extends SimpleTagSupport {
	private String type;
	private String style;
	private FlexAlign align;
	private FlexJustify justify;

	@Override
	public void doTag() throws JspException, IOException {
		TagUtils.flexTag(FlexDirection.COLUMN, align, justify, type, style, getJspContext().getOut(), getJspBody());
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setAlign(FlexAlign align) {
		this.align = align;
	}

	public void setJustify(FlexJustify justify) {
		this.justify = justify;
	}
}
