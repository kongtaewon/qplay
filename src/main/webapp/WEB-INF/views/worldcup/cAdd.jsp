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
<form action="/qplay/worldcup/cAdd" method="post">
  <fieldset>
    <legend>월드컵 추가하기</legend>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 1 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 2 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 3 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 4 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 5 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 6 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 7 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>
   	<div class="form-group">
		<label class="form-label mt-4">선택지 8 </label>
 		<input type="text" class="form-control" size="10" name="wc_contents">
   	</div>	
   		<input type="hidden" name="w_no" value="${w_no}"> 	
	<br>
	
    <button type="submit" class="btn btn-primary">등록</button>
  </fieldset>
</form>
</body>
</html>