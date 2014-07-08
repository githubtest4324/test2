package test2.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ServletUtils {
	@SuppressWarnings("rawtypes")
	public static String getRequestAttributes(HttpServletRequest request) {
		Enumeration reqAttrs = request.getAttributeNames();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println();
		pw.println("REQUEST ATTRS");
		pw.println("-------------");
		while (reqAttrs.hasMoreElements()) {
			String atributeName = (String) reqAttrs.nextElement();
			pw.println("ATTR: " + atributeName + ", " + request.getAttribute(atributeName) + " )");
		}
		pw.close();
		return sw.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String getSessionAttributes(HttpServletRequest request) {
		Enumeration sessAttrs = request.getSession().getAttributeNames();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println();
		pw.println("SESSION ATTRS");
		pw.println("-------------");
		while (sessAttrs.hasMoreElements()) {
			String atributeName = (String) sessAttrs.nextElement();
			pw.println("ATTR: " + atributeName + ", " + request.getSession().getAttribute(atributeName) + " )");
		}
		pw.close();
		return sw.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String getRequestParameters(HttpServletRequest request) {
		Enumeration reqParams = request.getParameterNames();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println();
		pw.println("REQEST PARAMS");
		pw.println("-------------");
		while (reqParams.hasMoreElements()) {
			String atributeName = (String) reqParams.nextElement();
			if (request.getParameterMap().get(atributeName) instanceof String[]) {
				StringBuffer paramMsg = new StringBuffer();
				String[] params = (String[]) request.getParameterMap().get(atributeName);
				for (int i = 0; i < params.length; i++) {
					if (i != 0) {
						paramMsg.append(", ");
					}
					paramMsg.append(params[i]);
				}
				pw.println("ATTR: " + atributeName + ", " + paramMsg);
			} else {
				pw.println("ATTR: " + atributeName + ", " + request.getParameterMap().get(atributeName) + " )");
			}
		}
		pw.close();
		return sw.toString();
	}

	/**
	 * The following method may be used to gather request headers
	 */
	public static String getRequestHeaders(HttpServletRequest request) {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		out.println("<B>Request Method: </B>" + request.getMethod() + "<BR>\n" + "<B>Request URI: </B>" + request.getRequestURI()
				+ "<BR>\n" + "<B>Request Protocol: </B>" + request.getProtocol() + "<BR><BR>\n"
				+ "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>Header Name<TH>Header Value");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.println("<TR><TD>" + headerName);
			out.println("<TD>" + request.getHeader(headerName));
		}
		out.println("</TABLE>\n");

		return sw.toString();
	}

	/**
	 * The following method may be used to gather cgi variables.
	 */
	public static String getCgiVariables(HttpServletRequest request, ServletContext context) {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		String[][] variables = { { "AUTH_TYPE", request.getAuthType() },
				{ "CONTENT_LENGTH", String.valueOf(request.getContentLength()) }, { "CONTENT_TYPE", request.getContentType() },
				{ "DOCUMENT_ROOT", context.getRealPath("/") }, { "PATH_INFO", request.getPathInfo() },
				{ "PATH_TRANSLATED", request.getPathTranslated() }, { "QUERY_STRING", request.getQueryString() },
				{ "REMOTE_ADDR", request.getRemoteAddr() }, { "REMOTE_HOST", request.getRemoteHost() },
				{ "REMOTE_USER", request.getRemoteUser() }, { "REQUEST_METHOD", request.getMethod() },
				{ "SCRIPT_NAME", request.getServletPath() }, { "SERVER_NAME", request.getServerName() },
				{ "SERVER_PORT", String.valueOf(request.getServerPort()) }, { "SERVER_PROTOCOL", request.getProtocol() },
				{ "SERVER_SOFTWARE", context.getServerInfo() } };
		String title = "Servlet Example: Showing CGI Variables";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<CENTER>\n" + "<H1>" + title + "</H1>\n" + "<TABLE BORDER=1>\n" + " <TR BGCOLOR=\"#FFAD00\">\n"
				+ "<TH>CGI Variable Name<TH>Value");
		for (int i = 0; i < variables.length; i++) {
			String varName = variables[i][0];
			String varValue = variables[i][1];
			if (varValue == null)
				varValue = "<I>Not specified</I>";
			out.println(" <TR><TD>" + varName + "<TD>" + varValue);
		}
		out.println("</TABLE></CENTER></BODY></HTML>");
		return sw.toString();
	}
}
