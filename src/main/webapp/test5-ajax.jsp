<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body ng-controller="MyCtrl">

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/headerNg.jsp"%>


<!-- CONTENT-->
<button id='a1' autofocus="autofocus">Click</button>


<script type="text/javascript">
	$('#a1').click(function(){
		$.getJSON("${root}/ajax/getUsers", function(user){
			console.log(user);
			alert(JSON.stringify(user, undefined, 4));
		});
	});
	
	

</script>

<!-- FOOTER -->
</body>
<%@include file="/WEB-INF/view/pageTemplate/footerNg.jsp"%>
