<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "../include/header.jsp" %>
</head>
<body>
<hr>


<c:if test="${result == '1'}">
<h4>정답입니다.</h4>
</c:if>

<c:if test="${result == '-1'}">
<h4>오답입니다.</h4><br>
<h4>정답 : ${answer }</h4>
</c:if>
<br>

<a href="qtquestion?qt_makeType=admin">계속 풀기</a>&nbsp;&nbsp;
<a href="quizselect">퀴즈 선택으로</a>



</body>
</html>