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
		<h2>답변등록창</h2>
		<hr/>
		
		<table border="1">
			<tr>
				<th>${commentdto.comment_userId}</th>
				<td>
					<form id="updateComment">
						<input type="hidden" name ="comment_pnum" value ="${dto.comment_pnum }">
						<input type="hidden" name ="comment_group" value ="${dto.comment_group }">
						<input type="hidden" name ="comment_step" value ="${dto.comment_step }">
						<input type="hidden" name ="comment_indent" value ="${dto.comment_indent }">
						<textarea rows="2" cols="70" name="commentcontent"></textarea>
					</form>
				</td>
				<td>
				 <div id="btn" style="text-align:center;">
                        <p><a class="btn btn-default" onclick="update()">답변등록</a></p>    
                    </div>
                    </td>
			</tr>
		</table>
		
	</div>
		<script type="text/javascript">
						function update() {
							var form =document.getElementById("updateComment");
							
							var content =form.commentcontent.value;
							var comment_pnum =form.comment_pnum.value;
							var comment_group =form.comment_group.value;
							var comment_step =form.comment_step.value;
							var comment_indent =form.comment_indent.value;
							
							
							if(!content)
								{
									alert("내용을입력해")
									return false;
								}
							else{
								
								var param="content="+content+"&comment_pnum="+comment_pnum+"&comment_group="+
								comment_group+"&comment_step="+comment_step+"&comment_indent="+comment_indent;
								console.log(param);
								$.ajax({
									url:"commentreply.do",
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