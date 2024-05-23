<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "../include/header.jsp" %>
<%@ include file="../include/plugin_js.jsp" %>

	<script>
	$(function() {
		$(".btn-primary").click(function(){
			
			var tmp_value = $("input[type=radio][name=choice]:checked").val();
			console.log(tmp_value);
			if (tmp_value == null) {
				alert("답을 입력해주세요");
				return false;
			}
			return true;
		});
		
		
		
		$(".btn-info").click(function(){
			
			if(!confirm("5포인트를 사용하여 확인하시겠습니까?")) {
				alert("취소");
				return false;
				
			} else {
				
				const btn = document.getElementById("btnhint");
				
				var url = "${pageContext.request.contextPath}/quizrandom2";
				var paramData = {"qm_no":"${ra.qm_no}"};
				var htmls = "";
				
				$.ajax({
					url : url,
					type : "POST",
					dataType : 'JSON',
					data : paramData,
					success:function(result){
						console.log(result);
						btn.disabled = true;
						alert("포인트를 사용했습니다");
				        htmls += "힌트 : " + result + "<br>";			        
				        htmls += "남은 포인트 : " + ${listpoint };
			        	$("#t").html(htmls);
			        
			         },
			         error : function(data){
			            console.log(data);
			            htmls += "힌트가 없습니다";			            
			            $("#t").html(htmls);
			         }
				})
				
			}
			
			return true;
			
		});
		
	})


	</script>

</head>
<body>
	
	<div align="center">
		<form action="${contextPath}/quizmultiple/memberresult" method="get">
		<h4>${title }</h4> <br>
		<br>
		<c:if test="${null ne ra.qm_img }">
		<img height="200" width="200" alt="사진" src="<c:url value="/img/${ra.qm_img }" />"> <br>
		</c:if>
		<br>
		문제<br>
		${ra.qm_question }<br>
		<br>
		<c:forEach var="name" items="${rb}" varStatus="status">
    	<p><input type="radio" name="choice" value="${name}"> ${status.count} : <c:out value="${name}" /></p>
		</c:forEach>
		<c:if test="${null ne member }">
		<p>포인트를 이용해서 힌트를 얻어보세요!</p>
		<div id="t"></div>
		<button type="button" class="btn btn-info" id="btnhint">힌트 확인</button>
		</c:if>
		<button type="submit" class="btn btn-primary">정답 확인</button>
		</form>
	</div>
	
</body>
</html>