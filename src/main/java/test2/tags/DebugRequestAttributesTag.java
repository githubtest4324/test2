package test2.tags;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import test2.utils.ServletUtils;

public class DebugRequestAttributesTag extends SimpleTagSupport {
	Boolean showRequestAttributes = false;
	Boolean showSessionAttributes = false;
	Boolean showRequestParameters = false;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		HttpServletRequest request = ((HttpServletRequest) ((PageContext) getJspContext()).getRequest());

		if (showRequestAttributes) {
			out.append(ServletUtils.getRequestAttributes(request));
		}
		if (showSessionAttributes) {
			out.append(ServletUtils.getSessionAttributes(request));
		}
		if (showRequestParameters) {
			out.append(ServletUtils.getRequestParameters(request));
		}
	}

	public void setShowRequestAttributes(Boolean showRequestAttributes) {
		this.showRequestAttributes = showRequestAttributes;
	}

	public void setShowSessionAttributes(Boolean showSessionAttributes) {
		this.showSessionAttributes = showSessionAttributes;
	}

	public void setShowRequestParameters(Boolean showRequestParameters) {
		this.showRequestParameters = showRequestParameters;
	}

}
