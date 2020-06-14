<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css"> 
</head>
<body>
	<nav>
		<c:choose>
		<c:when test="${UserID!=null}">
		<a class="btn btn-default pull-right"  href="logout.jsp">로그아웃</a>
		</c:when>
		<c:when test="${UserID==null || UserID==''}">
		<a class="btn btn-default pull-right"  href="login.jsp">로그인</a>
		</c:when>
		</c:choose>
	</nav>

	<table class="table table-bordered table-hover" >
	<thead>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>	
	</thead>
	<tbody>
	<c:forEach var="n" items="${list}">
		<tr>
				<td>${n.id}</td>
				<td><a href="detail.do?id=${n.id}">${n.title}
				<c:if test="${n.cmtCount!=0}">
				<${n.cmtCount}>
				</c:if></a></td>	
				<td>${n.name}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.date}"/></td>
				<td>${n.hit}</td>
		</tr>
	</c:forEach>
	</tbody>			
	</table>
	<hr>
	<a class="btn btn-default pull-right"  href="insert.do">글쓰기</a>
	
	<script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
</body>
</html>