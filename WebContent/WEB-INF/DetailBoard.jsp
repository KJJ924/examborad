<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"> 
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<table class="table table table-bordered ">
			<form  method="post" action="modify.jsp">
				<input type="hidden" name="title" value="${dto.title}"> 
				<input type="hidden" name="name" value="${dto.name}">
				<input type="hidden" name="content" value="${dto.content}">
				<input type="hidden" name="id" value="${dto.id}"> 
		
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">${dto.title}
</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td class="text-align-left text-indent" colspan="3">
						<fmt:formatDate	pattern="yyyy-MM-dd hh:mm:ss" value="${dto.date}" /></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${dto.name}</td>
						<th>조회수</th>
						<td><fmt:formatNumber value="${dto.hit}" /></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3" style="text-align: left; text-indent: 10px;">
							<c:forTokens  var="fileName" items="${dto.ufileName}" delims="," varStatus="st">
							<c:set var="test" value="${fileName}"/>
								<a href="/examboard/upload/${fileName}" download="${fn:substring(test,36,fn:length(test)) }" >${fn:substring(test,36,fn:length(test)) }</a>
								<c:if test="${!st.last}">
								/
								</c:if>
							</c:forTokens>
						
						</td>
					</tr>
					<tr class="content">
						<td colspan="4">${dto.content}</td>
					</tr>
					<tr>
						<td colspan="4">
							<div class="text-center">
								<c:if test="${UserID == dto.name}">
									<a class="btn btn-default pull-right "
										href="delete.do?id=${dto.id}">삭제</a>
									<input class="btn btn-default pull-right " type="submit"
										value="수정">
									</form>
									
				<form method="post" action="replyPage.do">
						<input type="hidden" name="bGroup" value="${dto.bGroup}">
						<input type="hidden" name="bStep" value="${dto.bStep}">
						<input type="hidden" name="bIndent" value="${dto.bIndent}">
						<input class="btn btn-default pull-right" type="submit" value="답변달기">

				</form>
								</br>
								</c:if>
							
			
								<a class="btn btn-default " href="board.do">목록</a> 
							</div>
						</td>
					</tr>
				</tbody>
			
				
		</table>
		<hr>
          
       
        <table border="1" bordercolor="lightgray">
    <!-- 댓글 목록 -->    
   
        <c:forEach var="comment" items="${commentdto}">
        <form id=commentReply>
        	<input type="hidden" name="comment_num" value="${comment.comment_num}">
        	<input type="hidden" name="comment_pnum" value="${dto.id}">
        </form>
            <tr>
                <!-- 아이디, 작성날짜 -->
                <td width="150">
                    <div>
                    <c:forEach begin="1" end="${comment.comment_indent}"><img src="img/reply-arrow.png" alt="화살표"width="10" height="10"></c:forEach>
                        ${comment.comment_userId}<br>
                        <font size="2" color="lightgray">${comment.comment_date}</font>
                    </div>
                </td>
                <!-- 본문내용 -->
                <td width="550">
                    <div class="text_wrapper">
                        ${comment.comment_content}
                    </div>
                </td>
                <!-- 버튼 -->
                <td width="100">
                    <div id="btn" style="text-align:center;">
                        <a href="#" onclick="commentReply(${comment.comment_num})">[답변]</a><br>
                    <!-- 댓글 작성자만 수정, 삭제 가능하도록 -->    
                    <c:if test="${comment.comment_userId == UserID}">
                        <a href="#" onclick="modifyComment(${comment.comment_num})" >[수정]</a><br>    
                        <a href="delete.do?commentid=${comment.comment_num}&pageNum=${dto.id}">[삭제]</a>
                    </c:if>        
                    </div>
                </td>
            </tr>
        </c:forEach>
           <script>
           function commentReply(comment_num) {
        		var form =document.getElementById("commentReply");
    			
    	
    			console.log(comment_num)

        	   
          		window.name="updatefrom";
          		window.open("openCommnetReplyForm.do?comment_num="+comment_num,"updateFrom",
          				"width=570, height=350, resizable = no, scrollbars = no");
			
		}
           	function modifyComment(comment_num) {
           		console.log(comment_num);
           		window.name="updatefrom";
           		window.open("openCommnetForm.do?comment_num="+comment_num,"updateFrom",
           				"width=570, height=350, resizable = no, scrollbars = no");

           
				
			}
           </script>
        
            <c:if test="${UserID!=null}">
            <tr bgcolor="#F5F5F5">
            <form id="writeCommentForm">
                <input type="hidden" name="comment_pnum" value="${dto.id}">
                <input type="hidden" name="comment_userid" value="${UserID}">
                <!-- 아이디-->
                <td width="150">
                    <div>
                        ${UserID}
                    </div>
                </td>
                <!-- 본문 작성-->
                <td width="550">
                    <div>
                        <textarea name="comment_content" rows="4" cols="70" ></textarea>
                    </div>
                </td>
                <!-- 댓글 등록 버튼 -->
                <td width="100">
                    <div id="btn" style="text-align:center;">
                        <p><a class="btn btn-default" onclick="writeCmt()">댓글등록</a></p>    
                    </div>
                </td>
            </form>
            </tr>
            </c:if> 
    
        </table>
        </div>
	<script type="text/javascript">
		
		function writeCmt() {
			var form =document.getElementById("writeCommentForm");
			
			var board =form.comment_pnum.value
			var id =form.comment_userid.value
			var content =form.comment_content.value;
			
			if(!content)
				{
					alert("내용을입력해")
					return false;
				}
			else{
				
				var param="comment_pnum="+board+"&comment_userid="+id+"&comment_content="+content;
				console.log(param);
				$.ajax({
					url:"commentinsert.do",
					data:param,
					type:'post'
				}).done(function(){
					document.location.reload();
				});
			}
			
		}
	


	</script>



                  
    <script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>