<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>회원가입</title>
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
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">회원가입</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        
                        <form id="contactForm" action="<c:url value="/registDo" />" method="POST" >
                            <!-- Id input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="id" name="id" type="text" placeholder="Enter your id..." />
                                <label for="id">ID</label>
                            </div>
                            <!-- password input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="pw" name="pw" type="password" placeholder="아무말" />
                                <label for="pw">Password</label>
                            </div>
                            <!-- re:password input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="repw" type="password" placeholder="아무말" />
                                <label for="repw">Re:Password</label>
                            </div>
                            <!-- name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="name" name="name" type="text" placeholder="이름 입력" />
                                <label for="name">이름</label>
                            </div>
                            
                            <!-- Submit Button-->
                            <button class="btn btn-primary btn-xl" id="submitButton" type="button" onclick="f_regist()">가입하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        
        <%@include file="/WEB-INF/inc/footer.jsp" %>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
        <script type="text/javascript">
			function f_regist(){
				const v_id = document.getElementById('id').value;
				const v_pw = document.getElementById('pw').value;
				const v_repw = document.getElementById('repw').value;
				const v_name = document.getElementById('name').value;
				
				// 공백을 포함하고 있는지 체크
				if(v_id.includes(' ')){
					alert('아이디에 공백이 포함되어 있습니다.');
					return;  // 실행시 메소드가 즉시 종료된다.
				}
				if(v_pw.includes(' ')){
					alert('비밀번호에 공백이 포함되어 있습니다.');
					return;
				}
				if(v_name.includes(' ')){
					alert('이름에 공백이 포함되어 있습니다.');
					return;
				}
				
				// 비밀번호와 비밀번호 재입력 값이 같은지 확인
				if(v_pw != v_repw){
					alert('비밀번호를 확인해주세요.');
					return;
				}
				
				// 아이디에 한글이 입력되었는지 확인
				const rexp = /^[0-9a-zA-Z]+$/g;  // 정규표현식
				if(!rexp.test(v_id)){
					alert('아이디는 영어 및 숫자로 작성해주세요');
					return;
				}
				
				
				// 서버에 요청 (form태그의 action을 실행)
				document.getElementById('contactForm').submit();
			}        
        
        </script>
        
    </body>
</html>

