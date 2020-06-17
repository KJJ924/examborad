<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<nav class="container">
		<c:choose>
			<c:when test="${UserID!=null}">
				<span><strong>${UserID} 님 어서오세요</strong></span>
				<a class="btn btn-default pull-right" href="logout.jsp">로그아웃</a>
			</c:when>
			<c:when test="${UserID==null || UserID==''}">
				<a class="btn btn-default pull-right" href="login.jsp">로그인</a>
			</c:when>
		</c:choose>
			<form class="table-form">
			<fieldset>
				<select name="f">
					<option ${param.f== "title"?"selected":""} value="title">제목</option>
					<option ${param.f=="name"?"selected":""} value="name">작성자</option>
				</select> <label class="hidden">검색어</label> <input type="text" name="q"
					value="${param.q}" /> <input class="btn btn-search" type="submit"
					value="검색" />
			</fieldset>
		</form>
	</nav>
	

	<div class="container">
	<table class="table table-bordered table-hover">
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
					<td><a href="detail.do?id=${n.id}">${n.title} <c:if	test="${n.cmtCount!=0}">(${n.cmtCount})</c:if></a></td>
					<td>${n.name}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.date}" /></td>
					<td>${n.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<hr>
	<c:if test="${UserID!=null}">
	<a class="btn btn-default pull-right" href="InsertBoard.jsp">글쓰기</a>
	</c:if>
	<c:set var="page"     value="${(empty param.p)?1:param.p}" />
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum"  value="${fn:substringBefore(Math.ceil(count/10),'.') }" />

	<ul class="pager">
		<c:if test="${startNum-1>0}">
			<li class="page-item"><a href="?p=${startNum-1}&t=&q=" class="btn btn-prev">이전</a></li>
		</c:if>
		<c:if test="${startNum-1<=1}">
			<li class="page-item"><span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span></li>
		</c:if>
	
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${(i+startNum) <=lastNum }">
			<li><a href="?p=${i+startNum}&f=${param.f}&q=${param.q}">${i+startNum}</a></li>
			</c:if>
		</c:forEach>

		<c:if test="${startNum+4 <lastNum}">
			<li class="page-item"><a href="?p=${startNum+5}&f=${param.f}&q=${param.q}" class="btn btn-next">다음</a></li>
		</c:if>
		<c:if test="${startNum+4>=lastNum}">
			<li class="page-item"><span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span></li>
		</c:if>
	</ul>






	<script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>