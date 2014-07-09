<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT-->
	<style type="text/css">
	.selected {
		background: lightBlue !important;
	}
</style>



<div class="box">
	<table id='tableStudent' style="width: 100%;">
		<thead>
			<tr onmousedown="RowClick(this,false);">
				<th style='display: none'>Id</th>
				<th>Name</th>
				<th>Username</th>
			</tr>
		</thead>
		<tbody>
			<tr onmousedown="RowClick(this,false);">
				<td style='display: none'>id1</td>
				<td>Liviu</td>
				<td>liviu</td>
			</tr>

			<tr onmousedown="RowClick(this,false);">
				<td style='display: none'>id2</td>
				<td>a</td>
				<td>liviu2</td>
			</tr>

			<tr onmousedown="RowClick(this,false);">
				<td style='display: none'>id3</td>
				<td>Administrator</td>
				<td>admin</td>
			</tr>

		</tbody>
	</table>

</div>

<script type="text/javascript">
var lastSelectedRow;
var trs = document.getElementById('tableStudent').tBodies[0].getElementsByTagName('tr');

// disable text selection
document.onselectstart = function() {
    return false;
}

function RowClick(currenttr, lock) {
    if (window.event.ctrlKey) {
        toggleRow(currenttr);
    }
    
    if (window.event.button === 0) {
        if (!window.event.ctrlKey && !window.event.shiftKey) {
            clearAll();
            toggleRow(currenttr);
        }
    
        if (window.event.shiftKey) {
            selectRowsBetweenIndexes([lastSelectedRow.rowIndex, currenttr.rowIndex])
        }
    }
}

function toggleRow(row) {
    row.className = row.className == 'selected' ? '' : 'selected';
    lastSelectedRow = row;
}

function selectRowsBetweenIndexes(indexes) {
    indexes.sort(function(a, b) {
        return a - b;
    });

    for (var i = indexes[0]; i <= indexes[1]; i++) {
        trs[i-1].className = 'selected';
    }
}

function clearAll() {
    for (var i = 0; i < trs.length; i++) {
        trs[i].className = '';
    }
}
</script>



<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
