<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/plugin_js.jsp"%>
<script>

$(function(){
	$(".btn-warning").click(function(){
		
	  	var qm_quizType = document.getElementById("qm_quizType");
	  	var qm_question = document.getElementById("qm_question");
	 	var content1 = document.getElementById("qmc_contents");
	  	var content2 = document.getElementById("qmc_contents2");
	  	var qm_hint = document.getElementById("qm_hint");
		
	  	console.log(qm_quizType.value);
	  	console.log(qm_question.value);
	  	console.log(content1.value);
	  	console.log(content2.value);
	  	console.log(qm_hint.value);
	  	
		  if (qm_quizType.value == "") {
			alert("타입을 입력해주세요");
			qm_quizType.focus();
			return false;
		}
		  if (qm_question.value == "") {
			alert("질문을 입력해주세요");
			qm_question.focus();
			return false;
		}
		  if (content1.value == "") {
			alert("보기를 입력해주세요");
			content1.focus();
			return false;
		}
		  if (content2.value == "") {
			alert("보기2를 입력해주세요");
			content2.focus();
			return false;
		}
		  if (qm_hint.value == "") {
			alert("힌트를 입력해주세요");
			qm_hint.focus();
			return false;
		}

		alert("완성!");
		return true;
			
		
	});
	
	$(".btn-danger").click(function(){
		
		location.href="${contextPath}/quizselect";
		alert("돌아가기");
		
	});
	
})

</script>



</head>
<body>

	<div align="center">
	
	<form action="${contextPath}/complete" method="post" name="cf" enctype="multipart/form-data">
		<h1>Quiz</h1><br>
		<h5>★${member.m_nick }★ 님 다양한 퀴즈를 만들어보시기 바랍니다</h5><br>
		<br>
		이미지 선택 : <input type="file" name="file" accept=".gif, .jpeg, .png, .jpg"/>
		<br>
		
		<br>
		퀴즈 타입 <input type="text" id="qm_quizType" name="qm_quizType" placeholder="예) 사서성어, 넌센스, 속담" style="width:200px"><br>
		<br>
		질문 <input type="text" id="qm_question" name="qm_question" placeholder=" 예) 가는 말이 고와야 OO OO 곱다 " style="width:300px"><br>
		<br>
		보기 (필수적으로 2개 이상 적기)<br>
		첫번째의 선택지에 답을 넣어주세요<br>
		1.<input type="text" name="qmc_contents" id="qmc_contents"><br>
		2.<input type="text" name="qmc_contents" id="qmc_contents2"><br>
		3.<input type="text" name="qmc_contents"><br>
		4.<input type="text" name="qmc_contents"><br>
		<br>
		힌트<br>
		<input type="text" id="qm_hint" name="qm_hint"><br>
		<br>
		<button type="submit" class="btn btn-warning">퀴즈 만들기</button>
	</form>
		<button class="btn btn-danger">취소</button>
	
	</div>
	
</body>
</html>