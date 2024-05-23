<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "include/header.jsp" %>
</head>
<body>


${msDTO.member_m_nick } 님의 활동<br>
<br>
보유 포인트 : ${msDTO.ms_point }<br>
총 획득 포인트 : ${msDTO.ms_pointTotal }<br>
<br>
퀴즈 도전 수 : ${msDTO.ms_winCnt + msDTO.ms_loseCnt}<br>
퀴즈 맞춘 수 : ${msDTO.ms_winCnt }<br>
퀴즈 틀린 수 : ${msDTO.ms_loseCnt }<br>
퀴즈 승률 : <fmt:formatNumber value="${msDTO.ms_winCnt / (msDTO.ms_winCnt + msDTO.ms_loseCnt)*100 }" pattern=".00"/>%<br>
<br>
창작 퀴즈 수 : ${msDTO.ms_makeCnt }<br>


</body>
</html>