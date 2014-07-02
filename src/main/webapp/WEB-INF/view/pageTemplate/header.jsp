<%@page import="java.io.IOException"%>
<%@include file="preLoginHeader.jsp"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<body>
	<div id="main">
		<nav>
			<ul>
				<li><a href="${root}/home"><spring:message code="nav.home" /></a></li>
				<li><a href="#">Orders</a>
					<ul>
						<li><a href="${root}/orders/orders/list/main"><spring:message code="nav.orders"/></a></li>
						<li><a href="#">Employees</a>
							<ul>
								<li><a href="${root}/employees/list/main">Test</a></li>
							</ul>
						</li>
					</ul>
				</li>
				<c:choose>
					<c:when test="${principal.name == 'guest'}">
						<li><a href="${root}/login"><spring:message code="nav.login"/></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#"><spring:message code="nav.security" /></a>
							<ul>
								<t:allowed roles="admin">
										<li><a href="${root}/security/users"><spring:message code="nav.users"/></a></li>
								</t:allowed>
								<li><a href="${root}/login/logout"><spring:message code="nav.logout"/></a></li>
							</ul>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>