<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<%@ include file="../include/plugin_js.jsp" %>
</head>
<script>
$("#darkdark").click(function(){
	alert("로그아웃");
});
</script>

<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${contextPath }/">Qplay</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <!-- <li class="nav-item">
          <a class="nav-link active" href="/qplay/main">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" href="${contextPath }/quizselect">퀴즈풀기</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${contextPath }/quizmake">퀴즈창작</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${contextPath }/worldcup/wMain">이상형월드컵</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="${contextPath }/boardfree/list" role="button" aria-haspopup="true" aria-expanded="false">자유게시판</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="${contextPath }/boardfree/list">자유게시판</a>
            <a class="dropdown-item" href="#">Another action</a>
          </div>
        </li>
        
      </ul>


      <c:if test="${member.m_id == null }">
      <form action="${contextPath }/login" class="d-flex">
      	 <button class="btn btn-dark" type="submit">로그인</button>
      </form>
      
      </c:if>
       <c:if test="${member.m_id != null }">
      	<form action="${contextPath }/memberdetail?m_no=${member.m_no}">
      		${member.m_nick }님 환영합니다
      		<button class="btn btn-dark my-2 my-sm-0" type="submit" id="dark">회원 정보</button>
      	</form>
	  </c:if>
	  
      <c:if test="${member.m_id != null }">
      	<form action="${contextPath }/logout">
      		<button class="btn btn-dark" type="submit" id="darkdark">로그아웃</button>
      	</form>
	  </c:if>


    </div>
  </div>
</nav>