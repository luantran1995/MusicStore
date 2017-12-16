
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html xmlns:th="http://www.thymeleaf.org">
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/style.css"/>"  rel="stylesheet">
<div>
	<ul id="categories">
		<c:forEach var="genre" items="${genres}">
			<li><a href="<c:url value="/genre?name=${genre.name}"/>">${genre.name}</a></li>
		</c:forEach>
	</ul>
		<form th:action="/login" method="POST">
			<h3 >Log in</h3>

			<div class="form-group " >
				<span>${message}</span> 
				<input type="text" class="form-control"name="email" placeholder="Your email" /> 
					<div class="has-error">${error}</div>
					<br>
					<input type="password" class="form-control" name="password" placeholder="Your password" /> 
					<div class="has-error">${error}</div>

					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<br>
				<button class="btn btn-default " type="submit">Login</button>
			</div>
		</form>
	</div>
	
