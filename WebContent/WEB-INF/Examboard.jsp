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

	<table class="table table-bordered table-hover" >
	<thead>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>	
	</thead>
	<tbody>
	<c:forEach var="n" items="${list}">
		<tr>
				<td>${n.id}</td>
				<td><a href="detail?id=?" >${n.title}</a></td>
				<td>${n.date}</td>
				<td>${n.hit}</td>
		</tr>
	</c:forEach>
	</tbody>			
	</table>
	<hr>
	<a class="btn btn-default pull-right" >글쓰기</a>
	
	<script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
</body>
</html>