<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT-->
	<div id="main">
		<nav>
			<ul>
				<li><a href="http://localhost:8081/test2Artifact/home">Home</a></li>
				<li><a href="http://localhost:8081/test2Artifact/security/users/list#">Orders</a>
					<ul>
						<li><a href="http://localhost:8081/test2Artifact/orders/orders/list/main">Orders</a></li>
						<li><a href="http://localhost:8081/test2Artifact/security/users/list#">Employees</a>
							<ul>
								<li><a href="http://localhost:8081/test2Artifact/employees/list/main">Test</a></li>
							</ul>
						</li>
					</ul>
				</li>
				
					
					
						<li><a href="http://localhost:8081/test2Artifact/security/users/list#">Security</a>
							<ul>
								
										<li><a href="http://localhost:8081/test2Artifact/security/users">Users</a></li>
								
								<li><a href="http://localhost:8081/test2Artifact/login/logout">Logout</a></li>
							</ul>
						</li>
					
				
			</ul>
		</nav>

<!-- CONTENT -->

<div style="display: flex;flex-direction: column;">
	<!-- CRITERIA -->
	<div class="box">
		<form id="criteria" action="./Users_files/Users.htm" method="POST">
			<div style="display: flex;flex-direction: row;align-items: center;"><span>Name</span><input id="name" name="name" type="text" value=""></div>
			<div style="display: flex;flex-direction: row;align-items: center;"><span>Username</span><input id="username" name="username" type="text" value=""></div>
		</form>
	</div>
	<div style="display: flex;flex-direction: row;justify-content: flex-start;">
		<form id="command" action="http://localhost:8081/test2Artifact/security/users/addAction" method="POST">
			<input type="submit" value="Add user">
		</form>
	</div>
	
	<!-- 	CONTENT -->
	<div class="box">
		<table><tbody><tr><th>Name</th><th>Username</th></tr><tr><td>Liviu</td><td>liviu</td></tr><tr><td>a</td><td>liviu2</td></tr><tr><td>Administrator</td><td>admin</td></tr></tbody></table>
	</div>
</div>



<script type='text/javascript'>
function showReqAttr(id1, id2) {
    document.getElementById(id1).style.display = 'block';
    // hide the lorem ipsum text
    document.getElementById(id2).style.display = 'none';
}
</script>

<a href='#' id='reqparamslink' style='color: red;' onclick="showReqAttr('reqparams', 'reqparamslink'); return false;">Request attributes</a>
<div id='reqparams' onclick="showReqAttr('reqparamslink', 'reqparams'); return false;" style="display:none">
	<table>
	<tbody>
		<tr>
			<th>Name</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>javax.servlet.forward.request_uri</td>
			<td>/test2Artifact/security/users/list</td>
		</tr>
		<tr>
			<td>javax.servlet.forward.context_path</td>
			<td>/test2Artifact</td>
		</tr>
		<tr>
			<td>javax.servlet.forward.servlet_path</td>
			<td>/security/users/list</td>
		</tr>
	</tbody>
	</table>
</div>




<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
