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
		<div>${msg}</div>
		<div class="table-responsive">
		  <table class="table">
		  <tr>
		  	<td>글번호</td>
		  	<td>제목</td>
		  	<td>작성자</td>
		  	<td>작성일</td>
		  	<td>조회수</td>
		  	<td>추천수</td>
		  	<td>비추천수</td>
		  </tr>
		<c:forEach var="board" items="${list }">
		 	<tr>
		 	<td>${board.bf_no}</td>
		 	<td><a href="/qplay/boardfree/read${pageMaker.makeSearch(pageMaker.cri.page)}&bf_no=${board.bf_no}"> ${board.bf_title} </a></td>
		 	<td>${board.member_m_nick}</td>
		 	<td>${board.bf_regDate}</td>
		 	<td><span class="black">${board.bf_viewCnt}</span></td>
		 	<td>${board.bf_upCnt}</td>
		 	<td>${board.bf_downCnt}</td>
		 	</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<button class="btn btn-success" type="button" onclick="location.href='${contextPath}/'">메인으로</button>	
				<button class="btn btn-success" type="button" onclick="location.href='/qplay/write?m_nick=${member.m_nick}'">글 작성</button>
			</td>
		</tr>
		  </table>
		</div>
		<!-- 페이징 -->
		<div class="text-center">
			<ul class="pagination">
			
			<c:if test="${pageMaker.prev}">
				<li><a 
				href="list${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage }"
			  end="${pageMaker.endPage }" var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?'class =active':'' }"/>>
			<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>&nbsp;
			</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a 
					href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
			</ul>
		</div>
		<!-- 페이징 끝 -->
			<!-- 검색 -->
	<!-- n : 검색조건이 없음, t : 제목으로 검색, c : 내용으로 검색, w :작성자로 검색
	,tc : 제목이나 내용으로 검색 , cw : 내용이나 작성자로 검색 , tcw : 제목이나 내용 혹은 작성자로 검색 -->
	<div class='box-body'>
		<select name="searchType">
			<option value="n"
			 <c:out value="${cri.searchType == null?'selected':''}"/>>
			---</option>
			<option value="t"
			 <c:out value="${cri.searchType eq 't'?'selected':'' }"/>>
			제목</option>
			<option value="c"
			 <c:out value="${cri.searchType eq 'c'?'selected':'' }"/>>
			내용</option>
			<option value="w"
			 <c:out value="${cri.searchType eq 'w'?'selected':'' }"/>>
			작성자</option>
			<option value="tc"
			 <c:out value="${cri.searchType eq 'tc'?'selected':'' }"/>>
			제목 또는 내용</option>
			<option value="cw"
			 <c:out value="${cri.searchType eq 'cw'?'selected':'' }"/>>
			내용 또는 작성자</option>
			<option value="tcw"
			 <c:out value="${cri.searchType eq 'tcw'?'selected':'' }"/>>
			제목 또는 내용 혹은 작성자</option>
		</select>
	</div>
	<input type="text" name='keyword' id="keywordInput"
		value='${cri.keyword}'>
		<button id='searchBtn'>검색</button>
		<!-- 검색 끝 -->
		<!-- 검색 버튼 -->
		<script>
			$(document).ready(
					function() {
						
				$('#searchBtn').on("click", 
						function(event) {
					
					self.location = "list"
					+'${pageMaker.makeQuery(1)}'
					+"&searchType="
					+$("select option:selected").val()
					+"&keyword="+encodeURIComponent($('#keywordInput').val());
				});
				$('#newBtn').on("click", function(evt) {
					self.location = "register";
				});
				
			});
		</script>
		<!-- 검색 버튼 끝 -->
    </section>

</body>
</html>