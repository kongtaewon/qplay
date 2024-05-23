<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="include/header.jsp"%>
<%@ include file="include/plugin_js.jsp"%>
<script>

</script>
	
</head>
<body>

	<div align="center">
	
	<form method="post" action="login">
	
		아이디<input type="text" name="m_id"><br>
		비밀번호<input type="text" name="m_password"><br>
		<button type="submit" class="btn btn-danger">로그인</button>
		<a href="signup">회원 가입</a>

	</form>

	</div>
	
</body>
</html>