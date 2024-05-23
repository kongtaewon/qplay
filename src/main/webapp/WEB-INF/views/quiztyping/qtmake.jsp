<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "../include/header.jsp" %>
</head>
<body>
<div>
퀴즈 창작
<hr>
<form method="post" encType="multipart/form-data">
퀴즈 유형을 입력해주세요.<br>
<input type="text" name="qt_quizType" required /><br>
<br>
퀴즈 질문을 입력해주세요.<br>
<textarea name="qt_question" required></textarea><br>
<br>
퀴즈 답을 입력해주세요.<br>
<input type="text" name="qt_answer" required /><br>
<br>
퀴즈 힌트를 입력해주세요.<br>
<input type="text" name="qt_hint" required /><br>
<br>
퀴즈 이미지를 등록해주세요. (선택)<br>
<input type="file" name="file" id="img" accept=".jpg, .jpeg, .png">
<br>
<br>
<input type="hidden" name="member_m_no" value="${member.m_no }" />
<input type="hidden" name="member_m_id" value="${member.m_id }" />
<input type="hidden" name="member_m_nick" value="${member.m_nick }" />
<input type="hidden" name="qt_makeType" value="${member.m_roll }" />
<input type="submit" value="등록" />


<a href="quizmake">취소</a>
</form>
</div>

<script>

                                                                                                                                                                                                                                                                                                                                          



</script>






</body>
</html>