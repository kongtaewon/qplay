<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "include/header.jsp" %>
</head>
<script>
	function delConfirm() {
		if (window.confirm("회원을 탈퇴하겠습니까?")) {
			location.href="deletemember?m_no=${member.m_no }";
		}
	}
</script>
<body>
(회원)<br>
닉네임 ${member.m_nick}<br>
아이디 ${member.m_id}<br>
<button type="button" onclick="delConfirm()">탈퇴</button>
<br>
<br>
<a href="myscore?m_no=${member.m_no }">내 전적</a>
<br>
<a>내 창작</a>
<br>
<a>내 글</a>
<br>
<br>
(관리자)<br>
<a>회원 관리</a>
<br>
<a>퀴즈 관리</a>
</body>
</html>