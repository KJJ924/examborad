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
		<table class="table table table-bordered ">
          	<form action="write.do" method="post">
                        <tr>
                         <th>제목</th>
                           <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                           	
                           	<input type="text" name="title">
                           </td>
                        </tr>
                        <tr>
                           <th>작성자</th>
                           <td><input type="text" name="name"></td>
                        </tr>
              
                        <tr>
                        	<th>내용</th>
                           <td colspan="4"><textarea name ="content" rows="10"></textarea></td>
                        </tr>
                       
                     	<tr>
                     		<th colspan="2">
                        <input class="pull-right" type="reset" value="reset">
                        &nbsp;&nbsp;
                        <input class="pull-right" type="submit" value="작성"><br>
                        <a class="btn btn-default " href="board.do">목록</a>
							</th>                        
                        </tr>
              </form>
                  </table>

<script src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>