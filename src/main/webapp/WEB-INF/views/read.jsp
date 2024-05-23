<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "include/header.jsp" %>

<script type="text/javascript">

// ajax를 통한댓글쓰기
	$(document).ready(function() {
		console.log("ajax test");
		
		// 댓글 목록 불러오기
		replylist();
		
		// 댓글 쓰기
		//$("#btnReplySave").click(function(){
		$("#btnReplySave").on('click',function(){
			var bfr_contents = $("#bfr_contents").val();
			var member_m_nick = $("#member_m_nick").val();
			
			var url ="${pageContext.request.contextPath}/boardfree/reply"
			var paramData ={
					"member_m_nick" : member_m_nick,
					"bfr_contents" : bfr_contents,
					"board_free_bf_no" : "${board.bf_no}"
					
			
			};// 추가 데이터
			
			$.ajax({
				type : 'POST',
				url : url,
				data : paramData,
				dataType : 'json',
				success:function(result){
					replylist();
					$("#bfr_contents").val('');
					$("#member_m_nick").val('');
					
					},
				error : function(data){
					alert("실패");
				}
				
					
				});
			
		});
		
		
	});
	
		// 댓글 목록 불러오기 : ajax 컨트롤에서 board_free_bf_no로 보냈으니 이름으로 받아야한다.
		function replylist() {
			var url ="${pageContext.request.contextPath}/boardfree/replylist"
			var paramData ={"board_free_bf_no":"${board.bf_no}"}
			
			$.ajax({
				url : url,
				data : paramData,
				dataType :'json',
				type : 'POST',
				
				success : function(result){
					//alert("성공");
					var htmls = "";
					
					if(result.length <1){
						htmls+="<h3>등록된 댓글이 없습니다.</h3>"
						htmls+="<h4>댓글을 입력하시려면 로그인해주세요.</h4>"
						
					}else{
						$(result).each(function() {
							htmls = htmls + '<div class="" id="bfr_no' +this.bfr_no + '">';
                            //<div id="reno12"> <div id="reno13">
				           htmls += '<span class="d-block">';
				           htmls += this.bfr_no + ' - ';
				           htmls += '<strong class="text-gray-dark">' + this.member_m_nick + '</strong>';
				           htmls += '<span style="padding-left: 7px; font-size: 9pt">';
				           htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.bfr_no + ', \'' + this.member_m_nick + '\', \'' + this.bfr_contents + '\' )" style="padding-right:5px">수정</a>';
				           htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.bfr_no + ')" >삭제</a>';
				           htmls += '</span>';
				           htmls += '</span><br>';
				           htmls += this.bfr_contents;
				           htmls += '</p>';
				           htmls += '</div>';   
						}); //each END
					}
					$("#replylist").html(htmls);
					
					
					
					
				},
				
				error : function(data){
					//alert("실패");
				}
				
				
			});
		}
		
	// 댓글 수정하기(form)
	function fn_editReply(bfr_no,member_m_nick,bfr_contents) {
		var htmls = "";
	   htmls = htmls + '<div class="" id="bfr_no' +bfr_no+ '">';
       htmls += '<span class="d-block">';
       htmls += bfr_no + ' - ';
       htmls += '<strong class="text-gray-dark">' + member_m_nick + '</strong>';
       htmls += '<span style="padding-left: 7px; font-size: 9pt">';
       htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' +bfr_no + ', \'' +member_m_nick + '\', \'' +bfr_contents + '\' )" style="padding-right:5px">저장</a>';
       htmls += '<a href="javascript:void(0)" onclick="replylist()">취소</a>';
       htmls += '</span>';
       htmls += '</span><br>';
       htmls +='<textarea name="editmemo" id="editmemo" class="form-control" rows="3">';
       htmls +=  bfr_contents;
       htmls +='</textarea>';
       htmls += '</p>';
       htmls += '</div>'; 
       
       //선택한 요소를 다른것으로 바꿉니다(변경)
       $('#bfr_no'+bfr_no).replaceWith(htmls);
       $('#bfr_no'+bfr_no+'#editmemo').focus();
	}
	
	//댓글 수정 ajax / rememo ->editmemo변경되어있으므로 필요없다
	function fn_updateReply(bfr_no, member_m_nick) {
		var url ="${pageContext.request.contextPath}/boardfree/replyupdate"
		var editmemo =$('#editmemo').val();
		var parmData ={
			"bfr_no" : bfr_no,
			"member_m_nick" : member_m_nick,
			"bfr_contents" : editmemo
		};
		
		
		
		$.ajax({
			url : url,
			data: parmData,
			dataType : 'json',
			type : 'POST',
			success : function(result) {
				console.log(result);
				replylist();
			},
			eror : function(data) {
				alert("에러가 발생했습니다.")
			}
		});
		
	}
	
	// 댓글 삭제
	function fn_deleteReply(bfr_no) {
		var url ="${pageContext.request.contextPath}/boardfree/replyDelete"
		var parmData ={
			"bfr_no" : bfr_no
		};
		
		
		
		$.ajax({
			url : url,
			data: parmData,
			dataType : 'json',
			type : 'POST',
			success : function(result) {
				console.log(result);
				replylist();
			},
			eror : function(data) {
				alert("에러가 발생했습니다.")
			}
		});
		
	}
	
	// 추천 	
	var bf_no = ${board.bf_no};
	var member_m_nick = "${board.member_m_nick}";
	
	 function updateLike(){ 
	     $.ajax({
	            type : "POST",  
	            url : "updateLike",       
	            dataType : "json",   
	            data : {'bf_no' : bf_no, 'member_m_nick' : member_m_nick},
	            error : function(){
	               alert("통신 에러");
	            },
	            success : function(likeCheck) {
	                
	                    if(likeCheck == 0){
	                    	alert("좋아요!완료.");
	                    	location.reload();
	                    }
	                    else if (likeCheck == 1){
	                     alert("좋아요취소");
	                    	location.reload();

	                    
	                }
	            }
	        });
	 }
	 
	//  비추천
	var bf_no = ${board.bf_no};
	var member_m_nick = "${board.member_m_nick}";
	
	 function downlike(){ 
	     $.ajax({
	            type : "POST",  
	            url : "downlike",       
	            dataType : "json",   
	            data : {'bf_no' : bf_no, 'member_m_nick' : member_m_nick},
	            error : function(){
	               alert("통신 에러");
	            },
	            success : function(downCheck) {
	                
	                    if(downCheck == 0){
	                    	alert("싫어요ㅠㅠ완료.");
	                    	location.reload();
	                    }
	                    else if (downCheck == 1){
	                     alert("싫어요취소");
	                    	location.reload();

	                    
	                }
	            }
	        });
	 }
	
	
	
</script>
</head>
<body>

 <!-- Main content -->
	<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>
			<div class="box-body">
				<div class="f	orm-group">
					<label>제목</label> <input type="text" name="bf_title"
						class="form-control" value="${board.bf_title}" readonly="readonly" />
				</div>

				<div class="form-group">
					<label>내용</label>
					<textarea name="bf_contents" rows="5" readonly="readonly"
						class="form-control">${board.bf_contents}</textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input type="text" name="member_m_nick "
						class="form-control" value="${board.member_m_nick}" readonly="readonly" />
				</div>
			</div>

		</div>
		<div class="box-footer">
			<button class="btn btn-success" type="button" onclick="location.href='/qplay/'">메인으로</button>
			<button class="btn btn-success" type="button" onclick="location.href='/qplay/boardfree/list'">뒤로가기</button>	
		</div>
		
		<!-- 추천 비추천 -->
		<div  style="margin-right:1px;">
			<button type="button" class="btn btn-warning " id="like_btn" onclick="updateLike();">좋아요! ${board.bf_upCnt}</button>
			<button type="button" class="btn btn-danger" id="hate_btn "  onclick="downlike();">싫어요ㅠㅠ ${board.bf_downCnt}</button>
					
		</div>
		
		<!-- 수정 삭제 로그인하고 작성자랑 같아야 수정,삭제 가능-->
		<c:choose>  
			<c:when test="${board.member_m_nick eq member.m_nick}"> 
			<button class="btn btn-success" type="button" onclick="location.href='/qplay/boardfree/update?bf_no=${board.bf_no}">수정</button>	
			<button class="btn btn-success" type="button" onclick="location.href='/qplay/boardfree/delete?bf_no=${board.bf_no}'">삭제</button>	
			</c:when> 
		</c:choose>  
			
		<!-- 로그인이 되어 있어야 댓글 작성이 보임 -->	
		<c:choose>
			<c:when test="${member.m_id !=null}">
   			<div>
			<div class="box-body">
				<table>
					<tr>
						<td rowspan="2" width="70%"><textarea class="form-control"
								name="bfr_contents" id="bfr_contents" placeholder="댓글을 입력하세요"></textarea></td>
						<td><input type="text" name="member_m_nick" id="member_m_nick"
							placeholder="댓글작성자"></td>
					</tr>
					<tr>
						<td><button type="button" id="btnReplySave">저장</button></td>
					</tr>
				</table>

			</div>
		</div>
		</c:when>
		</c:choose>

		<div id="replylist">
		</div>
	
</body>
</html>