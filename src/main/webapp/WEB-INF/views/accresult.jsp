<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "include/header.jsp" %>
</head>

<body>

<div>

<c:if test="${upResult == '1'}">
<script>
	window.onload = function() {
		alert("회원 가입 완료")
		location.href="${contextPath }/";
	};
</script>
</c:if>

<c:if test="${delResult == '1'}">
<script>
	window.onload = function() {
		alert("회원 탈퇴 완료")
		location.href="logout";
	};
</script>
</c:if>

</div>


</body>
</html>