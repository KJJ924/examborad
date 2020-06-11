<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="dto" class="com.testboard.entity.ExamBoardDto"></jsp:useBean>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:setProperty property="*" name="dto"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"> 
<title>Insert title here</title>
</head>
<body>
	<table class="table table table-bordered ">
		<form method="post" action="modify.do">
		<input type="hidden" name="id" value="${dto.id}">
          <tbody>
                     <tr>
                         <th>제목</th>
                           <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                           <input type="text" name="title" value="${dto.title}">
                           </td>
                        </tr>
                  
                        <tr>
                           <th>작성자</th>
                           <td>${dto.name}</td>
                       
                        </tr>
                        <tr>
                           <th>첨부파일</th>
                           <td colspan="3" style="text-align:left; text-indent:10px;">
 
                           </td>
                        </tr>
                        <tr class="content">
                           <td colspan="4"><input type="text" name="content" value="${dto.content}"></td>
                        </tr>
              <tr>
              	<td colspan="4">
                      <div class="text-center">
                 
                  		<input class="btn btn-default pull-right " type="submit" value="수정"></br>
                  		<a class="btn btn-default " href="detail.do?id=${dto.id}">취소</a>
                     </div>
                  </td>
              </tr>       
                            </tbody>
                     </form>
                  </table>
                 
                  
    <script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>