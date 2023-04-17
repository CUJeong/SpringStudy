<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>로그인</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
       
        <!-- Navigation -->
        <%@include file="/WEB-INF/inc/top.jsp" %>
       
        <!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container mt-5">
            	<div>
            		<form class="d-flex justify-content-end" action="<c:url value="/searchBoard" />" style="height: 34px" method="GET">
						<select name="option" style="width: 100px" class="form-select form-select-sm" aria-label=".form-select-sm example">
						  <option value="title" selected>제목</option>
						  <option value="content">내용</option>
						  <option value="name">작성자</option>
						</select>
	            		<input class="form-control" type="text" name="keyword" style="width: 200px">
	            		<button class="btn btn-primary" type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
						</svg></button>
            		</form>
            	</div>
            
                <table class="table table-hover" >
                	<thead>
                		<tr>
	                		<th>글번호</th>
	                		<th>제목</th>
	                		<th>작성자</th>
	                		<th>날짜</th>
                		</tr>
                	</thead>
                	<tbody>
                	
                		<c:forEach items="${boardList }" var="board">
	                		<tr>
	                			<td>${board.boardNo }</td>
	                			<td><a href="<c:url value="/detailBoardView?boardNo=${board.boardNo }" />">${board.boardTitle }</a></td>
	                			<td>${board.memName }</td>
	                			<td>${board.boardDate }</td>
	                		</tr>
                		</c:forEach>

                	</tbody>
                </table>
                <a href="<c:url value="/writeBoardView" />">
                	<button class="btn btn-primary">글쓰기</button>
                </a>
                
                
            </div>
        </section>
        <!-- Footer-->
        <%@include file="/WEB-INF/inc/footer.jsp" %>
        
    </body>
</html>

