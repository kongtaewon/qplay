<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "../include/header.jsp" %>
</head>
<body>
<style>
tr, td {
	padding: 10px;
    }
</style>
<c:if test="${round>=4}">
<h3>${wTitle} ${round}강</h3><br>
</c:if> 
<c:if test="${round==2}">
<h3>${wTitle} 결승</h3><br>
</c:if> 
<table>
<tr>
	<td><img src="${contextPath}/resources/worldcup/${exam1}.jpg" width="250" height="300" /></a></td>
	<td><img src="${contextPath}/resources/worldcup/${exam2}.jpg" width="250" height="300"  /></td>
</tr>
<tr>
	<td align ="center">
		<form action="/qplay/worldcup/choice" method="post">
			<input type="hidden" name="w_no" value="${w_no}">
			<input type="hidden" name="round" value="${round}">
			<button type="submit" class="btn btn-primary" name="win" value="${exam1}">${exam1}</button>
			<input type="hidden" name="lose" value="${exam2}">				
		</form>
	</td>
	<td align ="center">
		<form action="/qplay/worldcup/choice" method="post">
			<input type="hidden" name="w_no" value="${w_no}">
			<input type="hidden" name="round" value="${round}">
			<button type="submit" class="btn btn-primary" name="win" value="${exam2}">${exam2}</button>
			<input type="hidden" name="lose" value="${exam1}">
		</form>
	</td>
</tr>
</table>
	
</body>
</html>