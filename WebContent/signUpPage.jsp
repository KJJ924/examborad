<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css"> 
</head>
<body>
<div class="container">
<table>
      <form class="form-signin" action="singup.do" method="post">
        <h2 class="form-signin-heading">회원가입</h2>
        <input type="text" class="input-block-level" placeholder="아이디" name="userId"><br/>
        <input type="password" class="input-block-level" placeholder="암호" name="userPw">
<hr/>
        <button class="btn btn-large btn-primary" type="submit">가입</button>
      </form>
</table>
    </div> <!-- /container -->
      <script src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    


</body>
</html>