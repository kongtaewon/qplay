<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "../include/header.jsp" %>
<%@ include file="../include/plugin_js.jsp" %>

<%	
	
	String result = (String) request.getParameter("choice");
	
%>

<script>

$(function(){
	$(".btn-primary").click(function() {
		location.href="${contextPath}/quizmultiple/quizrandom";
	});
	$(".btn-secondary").click(function() {
		location.href="${contextPath}/quizselect";
	});
	
})

</script>
</head>
<body>
	
	<div align="center">
	
	선택하신 답은 <font color="red" size=5><%=result %></font>입니다 <br>
	${wa }
	${wb }
	<button type="submit" class="btn btn-primary">다시 풀기</button>
	<button type="button" class="btn btn-secondary">돌아가기</button>
	
	</div>
	
</body>
</html>