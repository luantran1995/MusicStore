<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

<%
	String baseURL = (String) request.getAttribute(AdminController.PARAM_BASE_URL);
	String latestPhotoUpload = (String) request.getAttribute(AdminController.PARAM_LATESTPHOTO);
%>

				<div class="col-md-5">
			<img src="<%=baseURL%>/image/${album.albumArtUrl}" alt="image"
						style="width: 70%" />
				</div>
				<div >
					<p>
						<strong>Title:</strong>: ${album.title}
					</p>
					<p>
						<strong>Genre:</strong>: ${album.genre.name}
					</p>
					<p>
						<strong>Artist:</strong>:${album.artist.name}
					</p>
					<p>
						<strong>Price:</strong>: ${album.price}
					</p>
					<br />
					<p>
						<a href="<c:url value = "/genre?name=${album.genre.name}"/>"class="btn btn-default">Back</a> 
						<a href="<c:url value = "/viewcart/buy/${album.id}"/>"class="btn btn-default">Add Cart</a> 
						<a href="<spring:url value="/viewcart" />" class="btn btn-default"> View Cart</a>
					</p>
				</div>
		<div id="footer">
			<a href="https://spring.io/">built with Spring MVC </a>
		</div>


<!-- My -->
<script src="<c:url value="/resources/js/controller.js?v3" /> "></script>

