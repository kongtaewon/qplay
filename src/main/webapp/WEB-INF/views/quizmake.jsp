<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "include/header.jsp" %>
<%@ include file="include/plugin_js.jsp" %>
<script>

$(function() {
	
	$(".btn-primary").click(function() {
		if (${member == null}) {
			alert("로그인 해주세요");
			location.href="${contextPath}/login";			
		} else if(${member != null}){
			location.href="${contextPath}/quizmultiple/quizinsert";
		}
		
	});
	
	$(".btn-secondary").click(function() {
		if (${member == null}) {
			alert("로그인 해주세요");
			location.href="${contextPath}/login";			
		} else if(${member != null}){
			location.href="${contextPath}/qtmake";
		}
		
	});
	
})

</script>

</head>
<body>
	
	<div align="center">

		<h3> 퀴즈 만들기 </h3><br>
		<p>퀴즈 만들시 100포인트가 감소됩니다</p>
		<button type="button" class="btn btn-primary">객관식</button><br>
		<br>
		<button type="button" class="btn btn-secondary">주관식</button>

	</div>
	
</body>
</html>