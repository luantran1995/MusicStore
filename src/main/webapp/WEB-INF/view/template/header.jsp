<%@page import="com.luantran.musicstore.model.CartItem"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>

<title>  Music Store</title>


<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- MaCarouselin CSS -->
<link href="<c:url value="/css/carousel.css" />"
	rel="stylesheet">

<link rel="stylesheet" href="<c:url value="/css/style.css"/>" />

<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
	<%
		int number = 0;
		if(session.getAttribute("cart") == null){
			number = 0;
		}else{
			List<CartItem> lstCartItem = (List<CartItem>)session.getAttribute("cart");
			number = lstCartItem.size();
		}
		 %>
	<div class="">
		<div class="header">

			<nav class="container">
				<div class="container">
					<div id="navbar" >
						<ul class="nav navbar-nav pull-right">
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a>Welcome:${pageContext.request.userPrincipal.name}</a></li>
								<li><a href="${pageContext.request.contextPath}/">Home</a></li>
								<c:if
									test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/viewcart" />">Cart(<%=number%>)</a></li>
								</c:if>
								<c:if
									test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/admin" />">Management</a></li>
								</c:if>
								<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="${pageContext.request.contextPath}/">Home</a></li>
								<li><a href="<c:url value="/viewcart" />">Cart(<%=number%>)</a></li>
								<li><a href="<c:url value="/registration" />">Register</a></li>
								<li><a href="<c:url value="/login" />">Login</a></li>
							</c:if>
						</ul>

					</div>
				</div>
			</nav>

		</div>
	</div>