<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>글수정</title>
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
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">글수정</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        
                        <form id="contactForm" action="<c:url value="/boardEditDo" />" method="POST" >
                            <input type="hidden" name="boardNo" value="${board.boardNo }">
                            
                            <!-- title input-->
                            <div class="mb-3">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="boardTitle" 
                                		type="text" value="${board.boardTitle }" />
                            </div>
                            <!-- content input -->
							<div class="mb-3">
								<textarea class="form-control" name="boardContent" style="height: 20rem;">${board.boardContent }</textarea>
							</div>
                            
                            <!-- Submit Button-->
                            <button class="btn btn-primary btn-xl" id="submitButton" type="submit">등록</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- Footer-->
        <%@include file="/WEB-INF/inc/footer.jsp" %>
        
    </body>
</html>

