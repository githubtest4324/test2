package test2.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ServletUtils {
	public static String getRequestAttributes(HttpServletRequest request) throws IOException {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		// Show/hide stuff
		addJs(out);
		out.println("<a href='#' id='ra1' style='color: red;' onclick=\"showReqAttr('rb1', 'ra1'); return false;\">Request attributes</a>");
		out.println("<div id='rb1' onclick=\"showReqAttr('ra1', 'rb1'); return false;\" style='display:none'>");

		// Header
		out.println("<table>");
		out.println("<tr>");
		out.println(String.format("<th>%s</th>", "Name"));
		out.println(String.format("<th>%s</th>", "Value"));
		out.println("</tr>");

		// Content
		@SuppressWarnings("rawtypes")
		Enumeration reqAttrs = request.getAttributeNames();
		while (reqAttrs.hasMoreElements()) {
			String name = (String) reqAttrs.nextElement();
			String value = request.getAttribute(name).toString();
			out.println("<tr>");
			out.println(String.format("<td>%s</td>", name));
			out.println(String.format("<td>%s</td>", value));
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");

		out.close();
		return sw.toString();
	}

	public static String getSessionAttributes(HttpServletRequest request) throws IOException {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		@SuppressWarnings("rawtypes")
		Enumeration sessAttrs = request.getSession().getAttributeNames();

		// Show/hide stuff
		addJs(out);
		out.println("<a href='#' id='ra2' style='color: red;' onclick=\"showReqAttr('rb2', 'ra2'); return false;\">Session attributes</a>");
		out.println("<div id='rb2' onclick=\"showReqAttr('ra2', 'rb2'); return false;\" style='display:none'>");

		// Header
		out.println("<table>");
		out.println("<tr>");
		out.println(String.format("<th>%s</th>", "Name"));
		out.println(String.format("<th>%s</th>", "Value"));
		out.println("</tr>");

		// Content
		while (sessAttrs.hasMoreElements()) {
			String name = (String) sessAttrs.nextElement();
			String value = request.getSession().getAttribute(name).toString();
			out.println("<tr>");
			out.println(String.format("<td>%s</td>", name));
			out.println(String.format("<td>%s</td>", value));
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");

		out.close();
		return sw.toString();
	}

	public static String getRequestParameters(HttpServletRequest request) throws IOException {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		@SuppressWarnings("rawtypes")
		Enumeration reqParams = request.getParameterNames();

		// Show/hide stuff
		addJs(out);
		out.println("<a href='#' id='ra3' style='color: red;' onclick=\"showReqAttr('rb3', 'ra3'); return false;\">Request parameters</a>");
		out.println("<div id='rb3' onclick=\"showReqAttr('ra3', 'rb3'); return false;\" style='display:none'>");

		// Header
		out.println("<table>");
		out.println("<tr>");
		out.println(String.format("<th>%s</th>", "Name"));
		out.println(String.format("<th>%s</th>", "Value"));
		out.println("</tr>");

		// Content
		while (reqParams.hasMoreElements()) {
			String name = (String) reqParams.nextElement();
			String value;
			if (request.getParameterMap().get(name) instanceof String[]) {
				StringBuffer paramMsg = new StringBuffer();
				String[] params = (String[]) request.getParameterMap().get(name);
				for (int i = 0; i < params.length; i++) {
					if (i != 0) {
						paramMsg.append(", ");
					}
					paramMsg.append(params[i]);
				}
				value = paramMsg.toString();
			} else {
				value = request.getParameterMap().get(name).toString();
			}
			out.println("<tr>");
			out.println(String.format("<td>%s</td>", name));
			out.println(String.format("<td>%s</td>", value));
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</div>");

		out.close();
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

	private static void addJs(PrintWriter out) throws IOException {
		out.println("<script type='text/javascript'>");
		out.println("function showReqAttr(id1, id2) {");
		out.println("    document.getElementById(id1).style.display = 'block';");
		out.println("    document.getElementById(id2).style.display = 'none';");
		out.println("}");
		out.println("</script>");
	}

}
