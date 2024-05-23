<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "../include/header.jsp" %>
</head>
<style>
tr, td {
	padding: 10px;
    }
</style>
<body>
<table>
	<tr>
		<td> <button type="button" class="btn btn-warning" onclick="location.href='/qplay/worldcup/wAdd'">월드컵 추가하기</button> </td>
		<td> <button type="button" class="btn btn-danger" onclick="location.href='/qplay/worldcup/wMain'">월드컵 메인으로</button> </td>
	</tr>
</table>

<table>
	<tr>
		<c:forEach var="wList" items="${wList}">
		<td ><a href="/qplay/worldcup/choice?w_no=${wList.w_no}&round=${wList.w_round}"><img src="${contextPath}/resources/worldcup/${wList.w_contents}.jpg" width="250" height="300" /></a></td>
		</c:forEach>
	</tr>
	<tr>
		<c:forEach var="wList" items="${wList}">
		<td align="center" ><button type="button" class="btn btn-primary" onclick="location.href='/qplay/worldcup/choice?w_no=${wList.w_no}&round=${wList.w_round}'" >${wList.w_title}</button></td>
		</c:forEach>
	</tr>
	<tr>
		<c:forEach var="wList" items="${wList}">
		<td align="center" style="padding:0 20px;" ><button type="button" class="btn btn-info">조회수 : ${wList.w_viewCnt} &nbsp;/&nbsp; 완료횟수 : ${wList.w_endCnt}</button></td>
		</c:forEach>
	</tr>
	<tr>
		<c:forEach var="wList" items="${wList}">
			<form action="/qplay/worldcup/wDel" method="post">
			<input type="hidden" name="w_no" value="${wList.w_no}">
			<td align="center"><button type="submit" class="btn btn-danger"> 삭제하기 </button></td>
			</form>
		</c:forEach>
	</tr>
</table>

</body>
</html>