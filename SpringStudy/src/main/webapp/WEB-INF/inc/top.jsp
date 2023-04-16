<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/" />">스프링 프로젝트</a>
        <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<c:url value="/boardView" />">회원게시판</a></li>
                
                <c:if test="${sessionScope.login == null }">
	                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<c:url value="/loginView" />">로그인</a></li>
	                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="http://localhost:8080/spring/registView">회원가입</a></li>
                </c:if>
				
				<c:if test="${sessionScope.login != null }">
					<li class="nav-item mx-0 mx-lg-1">
						<div class="dropdown">
						  <a class="nav-link py-3 px-0 px-lg-3 rounded dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
						    <span>${sessionScope.login.memName } 님</span>
						  </a>
						
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						    <li><a class="dropdown-item" href="<c:url value="/editView" />">회원수정</a></li>
						    <li><a class="dropdown-item" href="<c:url value="/logoutDo" />">로그아웃</a></li>
						  </ul>
						</div>
					</li>
				</c:if>
				                
            </ul>
        </div>
    </div>
</nav>