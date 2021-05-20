<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-light bg-primary custom-navbar">
	<div class="container">
		<a class="navbar-brand text-light" href="${root }/">HappyHouse</a> 
		<div class="d-flex justify-content-end pt-1 pb-2">
  			<c:if test="${userinfo == null}">
          		<a class="text-light mx-3" href="${root}/user/login">로그인</a>
				<a class="text-light"  href="${root}/user/join">회원가입</a>
			</c:if>
			<c:if test="${userinfo != null}">
				<a class="text-light mx-3">${userinfo.username}님 환영합니다.</a>
				<a class="text-light mx-1" href="${root}/user/mypage">마이페이지</a><br>
				<a class="text-light mx-1" href="${root}/user/userList">회원 목록</a><br>
				<a class="text-light" href="${root}/user/logout">로그아웃</a>
			</c:if>
		</div>
	</div>
</nav>

