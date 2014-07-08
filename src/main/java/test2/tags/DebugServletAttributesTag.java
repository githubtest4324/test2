package test2.tags;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import test2.utils.ServletUtils;

public class DebugServletAttributesTag extends SimpleTagSupport {
	Boolean showRequestAttributes = false;
	Boolean showSessionAttributes = false;
	Boolean showRequestParameters = false;
	Boolean showRequestHeaders = false;
	Boolean showCgiVariables = false;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		HttpServletRequest request = ((HttpServletRequest) ((PageContext) getJspContext()).getRequest());
		ServletContext context = ((PageContext) getJspContext()).getServletContext();

		if (showCgiVariables) { // Seems this must not the last to be shown, otherwise it is not visible
			out.append(ServletUtils.getCgiVariables(request, context));
		}
		if (showRequestAttributes) {
			out.append(ServletUtils.getRequestAttributes(request));
		}
		if (showSessionAttributes) {
			out.append(ServletUtils.getSessionAttributes(request));
		}
		if (showRequestParameters) {
			out.append(ServletUtils.getRequestParameters(request));
		}
		if (showRequestHeaders) {
			out.append(ServletUtils.getRequestHeaders(request));
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

	public void setShowRequestHeaders(Boolean showRequestHeaders) {
		this.showRequestHeaders = showRequestHeaders;
	}

	public void setShowCgiVariables(Boolean showCgiVariables) {
		this.showCgiVariables = showCgiVariables;
	}

}
