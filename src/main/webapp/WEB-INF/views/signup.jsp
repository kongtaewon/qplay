<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file = "include/header.jsp" %>
</head>
<script>
$(function(){
	$("#idch").click(function(){
		var newid=$("#newid").val();
		$.ajax({
			url:"idcheck",
			data:newid,
			type:"POST"
			dataType:"json"
			success:function(data){
				if(data.idResult>0){
					alert("중복된 아이디");
				}
				else{
					alert("사용 가능한 아이디");
				}
			},
			error:function(error){
				alert(error);
			}
		});
	});
});

function check_pw(){
    var pw = document.getElementById('pw').value;

    if(pw.length < 6 || pw.length>12){
        window.alert('비밀번호 6 이상 12 이하만 가능');
        document.getElementById('pw').value='';
    }
    if(document.getElementById('pw').value !='' && document.getElementById('repw').value!=''){
        if(document.getElementById('pw').value==document.getElementById('repw').value){
            document.getElementById('check').innerHTML='비밀번호가 일치'
            document.getElementById('check').style.color='blue';
        }
        else{
            document.getElementById('check').innerHTML='비밀번호가 불일치';
            document.getElementById('check').style.color='red';
        }
    }
}
	
	
}






</script>




<body>
<div>
회원 가입
<hr>
<form method="post">
아이디<br>
<input id="newid" type="text" name="m_id" placeholder="이메일 입력." required />
<input id="idch" type="button" value="중복 확인">
<br>
<br>
닉네임<br>
<input type="text" name="m_nick" placeholder="닉네임 입력." required /><br>
<br>
암호<br>
<input id=pw type="password" name="m_password" placeholder="암호 입력" onchange="check_pw()" required /><br>
<br>
암호 재입력<br>
<input id=repw type="password" placeholder="암호 재입력" onchange="check_pw()" required /><br>
<br>


<input type="hidden" name="" value="" />

<input type="submit" value="등록" />
<a href="login">취소</a>

</form>
</div>





</body>
</html>