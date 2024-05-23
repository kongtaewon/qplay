<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file ="include/header.jsp" %>
<%@ include file="include/plugin_js.jsp" %>
<script>

$(function() {
	$(".btn-primary").click(function() {
		location.href="quizmultiple/quizrandom?qt_makeType=admin";
	});
	$(".btn-secondary").click(function() {
		location.href="quizmultiple/quizmemberrandom?qt_makeType=member";
	});
	
	$(".btn-success").click(function() {
		location.href="qtquestion?qt_makeType=admin";
	});
	$(".btn-info").click(function() {
		location.href="qtquestion?qt_makeType=member";
	});
	
})
	
</script>
</head>
<body>
	
	<div align="center">
	
		<table class="table">
			
			<tr>
			<td> <button type="button" class="btn btn-primary">공식 객관식퀴즈</button> </td>
			<td> <button type="button" class="btn btn-success">공식 주관식퀴즈</button> </td>
			</tr>
			<tr>
			<td> <button type="button" class="btn btn-secondary">회원 창작 객관식퀴즈</button> </td>
			<td> <button type="button" class="btn btn-info">회원 창작 주관식퀴즈</button> </td>
			</tr>
			
		</table>
		
	</div>

</body>
</html>