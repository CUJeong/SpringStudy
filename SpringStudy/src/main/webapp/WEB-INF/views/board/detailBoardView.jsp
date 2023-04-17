<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>${board.boardTitle }</title>
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

                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        
                        <!-- title-->
                        <div class="mb-3">
                            <label for="title">제목</label>
                            <h6 id="title">${board.boardTitle }</h6>
                        </div>
                        <!-- name-->
                        <div class="mb-3">
                            <label for="memName">작성자</label>
                            <h6 id="memName">${board.memName }</h6>
                        </div>
                        <!-- date -->
                        <div class="mb-3">
                            <label for="date">작성일</label>
                            <h6 id="date">${board.boardDate }</h6>
                        </div>
                        <!-- content -->
						<div class="mb-3">
							<textarea class="form-control bg-white" readonly name="boardContent" style="height: 20rem;">${board.boardContent }</textarea>
						</div>
                    </div>
                    
	                <c:if test="${board.memId == sessionScope.login.memId }">
						<div class="d-flex justify-content-end col-lg-8 col-xl-7">
							<form action="<c:url value="/boardEditView"/>" method="POST">
								<input type="hidden" name="boardNo" value="${board.boardNo }">
								<button class="btn btn-warning me-2" type="submit">수정</button>
							</form>	
							
							<form action="<c:url value="/boardDelDo"/>" method="POST">
								<input type="hidden" name="boardNo" value="${board.boardNo }">
								<button class="btn btn-danger" type="submit">삭제</button>
							</form>	
						</div>
					</c:if>
                    
                    <div class="col-lg-8 col-xl-7">
						<form class="d-flex" action="<c:url value="/writeReplyDo" />" method="POST">
							<input type="text" class="form-control" id="replyContent" name="replyContent">
							<input type="hidden" id="boardNo" name="boardNo" value="${board.boardNo }">
							<button type="button" onclick="sendAjax()" class="btn btn-info">등록</button>
						</form>                    
                    </div>
                    
                    <div class="col-lg-8 col-xl-7">
						<table class="table" >
		                	<thead>
		                		<tr>
			                		<th style="width: 80%"></th>
			                		<th style="width: 20%"></th>
		                		</tr>
		                	</thead>
		                	<tbody id="tbody">
		                	
		                		<c:forEach items="${replyList }" var="reply">
			                		<tr>
			                			<td>${reply.replyContent }</td>
			                			<td>${reply.memName }</td>
			                		</tr>
		                		</c:forEach>
		
		                	</tbody>
		                </table>
                    
                    </div>
                    
                </div>
            </div>
        </section>
        
		<script type="text/javascript">
	      function sendAjax() {
	        var xhr = new XMLHttpRequest(); // XMLHttpRequest 객체 생성
	        var url = '<c:url value="/writeReplyDo" />'; // Ajax 요청할 URL
	        var replyContent = document.getElementById('replyContent').value;
	        var boardNo = document.getElementById('boardNo').value;
	        var data = "replyContent="+replyContent+"&boardNo="+boardNo; // Ajax 요청 시 전송할 데이터
	        xhr.open("POST", url, true); // POST 방식으로 요청을 설정
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // 데이터 형식 설정
	        xhr.onreadystatechange = function () {
	          if (xhr.readyState === 4 && xhr.status === 200) { // Ajax 요청이 성공적으로 완료되었을 때
	            console.log(xhr.responseText); // 결과 출력
	            var reply = JSON.parse(xhr.response);
	            console.log(reply.replyContent);
	            console.log(reply.memName);
	            
	            var v_html = "<tr><td>"+reply.replyContent+"</td><td>"+reply.memName+"</td></tr>";
	            
	            document.getElementById("tbody").innerHTML = v_html + document.getElementById("tbody").innerHTML;
	          }
	        };
	        xhr.send(data); // Ajax 요청 전송
	      }
	    </script>
        
        <!-- Footer-->
        <%@include file="/WEB-INF/inc/footer.jsp" %>
        
    </body>
</html>

