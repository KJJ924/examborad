<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"> 
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>댓글수정창</h2>
		<hr/>
		
		<table border="1">
			<tr>
				<th>${commentdto.comment_userId}</th>
				<td>
					<form id="updateComment">
						<input type="hidden" name ="comment_num" value ="${commentdto.comment_num }">
						<textarea rows="2" cols="70" name="commentcontent">${commentdto.comment_content}</textarea>
					</form>
				</td>
				<td>
				 <div id="btn" style="text-align:center;">
                        <p><a class="btn btn-default" onclick="update()">댓글수정</a></p>    
                    </div>
                    </td>
			</tr>
		</table>
		
	</div>
		<script type="text/javascript">
						function update() {
							var form =document.getElementById("updateComment");
							
							var content =form.commentcontent.value;
							var id =form.comment_num.value;
							
							if(!content)
								{
									alert("내용을입력해")
									return false;
								}
							else{
								
								var param="comment_num="+id+"&comment_content="+content;
								console.log(param);
								$.ajax({
									url:"commentupdate.do",
									data:param,
									type:'post'
								}).done(function(){
									 window.opener.document.location.reload(); 
				                        opener.updateForm = null;
				                        self.close();
								});
							}
							
						}

					</script>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>