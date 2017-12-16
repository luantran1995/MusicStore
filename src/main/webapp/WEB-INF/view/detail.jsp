<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<%
	String baseURL = (String) request.getAttribute(AdminController.PARAM_BASE_URL);
%>
<div class="container">
	<table class="table table-striped">
		<tr>
			<th></th>
			<th>Title</th>
			<th>Artist</th>
			<th>Genre</th>
			<th>Price</th>
		</tr>
		<tr>
			<td><img src="<%=baseURL%>/image/${album.albumArtUrl}" /></td>
			<td>${album.title}</td>
			<td>${album.artist.name }</td>
			<td>${album.genre.name }</td>
			<td>${album.price}</td>
		</tr>
	</table>
</div>

<a href="${pageContext.request.contextPath}/admin">Back</a>

</html>