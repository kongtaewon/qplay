<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "include/header.jsp" %>
<script type="text/javascript">
	$(function(){
	
		$(".btn-success").click(function(){
		location.href="boardfree/list";
		});
	})
</script>
</head>
<body>

    <!-- Main content -->
    <section class="content container-fluid">
		<div class="box-header">
			<h3 class="box-title">게시판 글쓰기</h3>
		</div>
	
		<form action="${contextPath }/write" method="post">
			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text"
						name='bf_title' class="form-control" placeholder="제목을 입력하세요">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" name="bf_contents" rows="3"
						placeholder="내용을 입력하세요"></textarea>
				</div>
	
				<div class="form-group">
					<label>작성자</label> <input type="text" name="member_m_nick" class="form-control"  
						value="${member.m_nick}" readonly>
				</div> 
			</div>
	
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">작성완료</button>
				<button class="btn btn-success" type="button">돌아가기</button>
			</div>
		</form>
    </section>

</body>
</html>