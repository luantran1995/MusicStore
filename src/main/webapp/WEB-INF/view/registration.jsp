


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html xmlns:th="http://www.thymeleaf.org">
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/style.css"/>"  rel="stylesheet">
	<ul id="categories">
		<c:forEach var="genre" items="${genres}">
			<li><a href="<c:url value="/genre?name=${genre.name}"/>">${genre.name}</a></li>
		</c:forEach>
	</ul>
<div>
		<form:form method="POST" modelAttribute="userForm" class="form-signin"> 
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="email">
				<div class=" ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="email" class="form-control" placeholder="Email" autofocus="true"></form:input> 
					<form:errors path="email" ></form:errors>
					
				</div>
			</spring:bind>
			
			<spring:bind path="password">
				<div class="${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input> 
					<form:errors path="password"></form:errors> 
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input> 
					<form:errors path="passwordConfirm"></form:errors> 
				</div>
			</spring:bind>
								
			
			<button class="btn btn-default" type="submit">Submit</button>
			
		</form:form>
	</div>
	<script src="${contextPath}/js/bootstrap.min.js"></script>
	
