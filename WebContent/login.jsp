<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css"> 
</head>
<body>
<div class="container">
 <h2 class="form-signin-heading">로그인하세요</h2>
<table class="table table table-bordered ">

		<c:if test="${ check == -1 || check == 0 }">
		<script>
			alert("아이디 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
		

      <form class="form-signin" action="login.do" method="post">
      <th>아이디</th>
       <td><input type="text" class="input-block-level" placeholder="아이디입력" value="${UserID}" name="userId">
        </td>
        
        
        <th>비밀번호</th>
        <td>
        <input type="password" class="input-block-level" placeholder="암호" name="userPw">
        	</td>
        
      
        <button class="btn btn-large btn-primary" type="submit">로그인</button>
        <a class="btn btn-large btn-primary"  href="signUpPage.jsp">회원가입</a>
        <a class="btn btn-default " href="board.do">목록</a>
      </form>
</table>
    </div> <!-- /container -->
      <script src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    


</body>
</html>