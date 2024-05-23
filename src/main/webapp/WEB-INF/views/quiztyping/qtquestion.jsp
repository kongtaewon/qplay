<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "../include/header.jsp" %>
</head>
<body>

<div>
<form action="qtresult" method="post">

<c:choose>
	<c:when test="${qt.qt_img eq null}">
	<img src="/img/defaultImg.png" height="200" width="200"><br>
	</c:when>
	<c:otherwise>
	<img src="<c:url value="/img/${qt.qt_img }" />" height="200" width="200"><br>
	
	</c:otherwise>
</c:choose>

<c:if test="${qt.qt_makeType != 'admin'}">
창작 회원 : ${qt.member_m_nick }<br>
</c:if>

퀴즈 유형 : ${qt.qt_quizType }<br>
퀴즈 질문 : ${qt.qt_question }<br>
퀴즈 힌트 : ${qt.qt_hint }<br>
퀴즈 정답률 : <fmt:formatNumber value="${qt.qt_winCnt / (qt.qt_winCnt + qt.qt_loseCnt)*100 }" pattern=".00"/>%<br>

답 입력
<input type="text" name="qt_answer" />
<input type="submit" value="확인">

<input type="hidden" name="qt_no" value="${qt.qt_no }" />
<input type="hidden" name="m_no" value="${member.m_no }" />
<input type="hidden" name="qt_makeType" value="${qt_makeType }" />


</form>
</div>

<script>

</script>







</body>
</html>