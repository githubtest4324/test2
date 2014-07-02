package test2.utils;

import java.io.StringWriter;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;

public class TagUtils {
	public static enum FlexDirection {
		ROW("row"), COLUMN("column"), ROW_REVERSE("row-reverse"), COLUMN_REVERSE("column-reverse");
		private String cssStyle;

		FlexDirection(String cssStyle) {
			this.cssStyle = cssStyle;
		}

		public String getCssStyle() {
			return cssStyle;
		}
	}

	public static enum FlexJustify {
		START("flex-start"), END("flex-end"), CENTER("center"), SPACE_BETWEEN("space-between"), SPACE_AROUND("space-around");
		private String cssStyle;

		FlexJustify(String cssStyle) {
			this.cssStyle = cssStyle;
		}

		public String getCssStyle() {
			return cssStyle;
		}
	}

	public static enum FlexAlign {
		START("flex-start"), END("flex-end"), CENTER("center"), STRETCH("stretch"), BASELINE("baseline");

		private String cssStyle;

		FlexAlign(String cssStyle) {
			this.cssStyle = cssStyle;
		}

		public String getCssStyle() {
			return cssStyle;
		}
	}

	public static void flexTag(FlexDirection direction, FlexAlign align, FlexJustify justify, String type, String style,
			JspWriter jspWriter, JspFragment jspBody) throws SkipPageException {
		try {
			StringWriter jspBodyContent = new StringWriter();
			StringBuffer out = new StringBuffer();

			jspBody.invoke(jspBodyContent);
			TagUtils.flexTagInternal(direction, align, justify, jspBodyContent.getBuffer().toString(), type, style, out);

			jspWriter.write(out.toString());
		} catch (Exception e) {
			e.printStackTrace();
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException(e.getMessage());
		}
	}

	/**
	 * Generates a flexbox styled html element.
	 * 
	 * @param direction
	 *            Orientation of flex box. Optional parameter.
	 * @param align
	 *            Allign offlex box. Optional parameter.
	 * @param justify
	 *            Justify of flex box. Optional parameter.
	 * @param elementType
	 *            User provided name of the html element to be styled. If null
	 *            'div' is used.
	 * @param style
	 *            User provided css style to be applied.
	 * @param body
	 *            User provided body of the html element provided.
	 */
	private static void flexTagInternal(FlexDirection direction, FlexAlign align, FlexJustify justify, String body,
			String elementType, String style, StringBuffer out) {
		String realType = elementType == null ? "div" : elementType;
		StringBuffer realStyle = new StringBuffer();

		// Build css style
		realStyle.append("style='");
		realStyle.append("display: flex;");
		if (direction != null) {
			realStyle.append(String.format("flex-direction: %s;", direction.getCssStyle()));
		}
		if (align != null) {
			realStyle.append(String.format("align-items: %s;", align.getCssStyle()));
		}
		if (justify != null) {
			realStyle.append(String.format("justify-content: %s;", justify.getCssStyle()));
		}
		if (style != null) {
			realStyle.append(style);
		}
		realStyle.append("'");

		// Build output
		out.append(String.format("<%s %s>", realType, realStyle.toString()));
		out.append(body);
		out.append(String.format("</%s>", realType));

	}
}
