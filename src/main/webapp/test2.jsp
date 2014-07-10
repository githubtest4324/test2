<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT-->
<div class="box">
	<table id ='xx' style="width: 100%;" class='smartTableUnselectable'>
		<thead>
			<tr onmousedown="rowClick(this,false);">
				<th style='display: none'>Id</th>
				<th>Name</th>
				<th>Username</th>
			</tr>
		</thead>
		<tbody>
			<tr smtId='id1' onmousedown="rowClick(this,false);">
				<td id='key' style='display: none'>id1</td>
				<td>Liviu</td>
				<td>liviu</td>
			</tr>

			<tr smtId='id2' onmousedown="rowClick(this,false);">
				<td id='key' style='display: none'>id2</td>
				<td>a</td>
				<td>liviu2</td>
			</tr>

			<tr smtId='id3' onmousedown="rowClick(this,false);">
				<td id='key' style='display: none'>id3</td>
				<td>Administrator</td>
				<td>admin</td>
			</tr>

		</tbody>
	</table>
	<a href="#" onclick="alert(getSelectedRecords('xx'));">aaa</a>
</div>


<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
