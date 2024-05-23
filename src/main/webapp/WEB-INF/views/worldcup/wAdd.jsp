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
<form action="/qplay/worldcup/wAdd" method="post">
  <fieldset>
    <legend>월드컵 추가하기</legend>
   	<div class="form-group">
		<label class="form-label mt-4">월드컵 제목 </label>
 		<input type="text" class="form-control" size="10" name="w_title">
 		<small id="ex" class="form-text text-muted">ex) 음식 월드컵, 음료수 월드컵...</small>
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">월드컵 내용 </label>
 		<input type="text" class="form-control" name="w_contents">
 		<small id="ex" class="form-text text-muted">ex) 음식, 음료수...</small>
   	</div>
   		<input type="hidden" name="w_round" value="8"> 	
	<br>
    <button type="submit" class="btn btn-primary">다음</button>
    <button type="button" class="btn btn-danger" onclick="location.href='/qplay/worldcup/wMain'">돌아가기</button>
  </fieldset>
</form>
</body>
</html>