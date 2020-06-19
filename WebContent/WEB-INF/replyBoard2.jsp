<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css"> 
<title>Insert title here</title>
</head>
<body>
	<div class=container>
		<table class="table table table-bordered ">
          	<form action="reply.do" method="post">
          	<input type="hidden"  name="bGroup" value="${replydto.bGroup}">
          	<input type="hidden"  name="bStep" value="${replydto.bStep}">
          	<input type="hidden"  name="bIndent" value="${replydto.bIndent}">
                        <tr>
                         <th>제목</th>
                           <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                           	
                           	<input type="text" name="title">
                           </td>
                        </tr>
						<c:if test="${UserID==null || UserID==''}">
						 
				           <tr>
							 <th>작성자</th>
				               <td><input type="text" name="name" value="${UserID}"></td>
				          </tr>
						</c:if>
						<c:if test="${UserID!=null}">
						 <tr>
							 <th>작성자</th>
								<td>${UserID}</td>
				          </tr>
						</c:if>
                        <tr>
                        	<th>내용</th>
                           <td colspan="4"><textarea name ="content" rows="10"style="margin: 0px; width: 100%; "></textarea></td>
                        </tr>
                       
                     	<tr>
                     		<th colspan="2">
                        <input class="btn btn-default pull-right" type="reset" value="reset">
                        &nbsp;&nbsp;
                        <input class="btn btn-default pull-right" type="submit" value="작성"><br>
                        <a class="btn btn-default " href="board.do">목록</a>
							</th>                        
                        </tr>
              </form>
                  </table>
</div>
<script src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>