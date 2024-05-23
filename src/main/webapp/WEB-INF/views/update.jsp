<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "include/header.jsp" %>
</head>
<body>

	  <!-- Main content -->
    <section class="content container-fluid">
		<div class="box-header">
			<h3 class="box-title">게시판 글수정</h3>
		</div>
		<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label>제목</label> <input type="text"
					name='bf_title' class="form-control"  value="${board.bf_title}">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="bf_contents" rows="3">${board.bf_contents}</textarea>
			</div>

			<div class="form-group">
				<label>작성자</label> <input type="text"
					name="member_m_nick " class="form-control"  
					readonly="readonly"  value="${board.member_m_nick}">
			</div>
			<!-- 수정에 사용할 글번호 -->
			<input type="hidden" name="bf_no" value="${board.bf_no }" />
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">수정완료</button>
			<button class="btn btn-success" type="button" onclick="location.href='/qplay/boardfree/read?bf_no=${board.bf_no}'">취소하기</button>
			<button class="btn btn-success" type="button" onclick="location.href='/qplay/boardfree/list'">목록보기</button>	
		</div>
	</form>
		
    </section>
    <!-- /.content -->

</body>
</html>