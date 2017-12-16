<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<%
	String baseURL = (String) request.getAttribute(AdminController.PARAM_BASE_URL);
%>
        <link href="<%=baseURL%>/css/bootstrap.min.css" rel="stylesheet" />

<style>
img {
    max-width: 50%;
    height: 80px;
}
</style>
<a class="btn btn-lg  " href="<c:url value="/admin/getList"/>">
	Create New Album </a>

<div>
	<ul id="categories">
		<c:forEach var="genre" items="${genres}">
			<li><a href="<c:url value="/genre?name=${genre.name}"/>">${genre.name}</a></li>
		</c:forEach>
	</ul>
</div>

<div class="container">
	<table class="table ">
		<tr>
			<th>Image</th>

			<th>Title</th>
			<th>Artist</th>
			<th>Genre</th>
			<th>
			<th>
		</tr>
		<c:forEach items="${albums}" var="album">
			<tr>
				<td><img src="<%=baseURL%>/image/${album.albumArtUrl}" class="img" /></td>
				<td>${album.title}</td>
				<td>${album.artist.name }</td>
				<td>${album.genre.name }</td>
				<td><a href="<c:url value ="/admin/update/${album.id}"/>">
						Edit </a>| <a href="<c:url value="/admin/detail/${album.id}"/>">Detail</a>|
					<a href="<c:url value="/admin/delete/${album.id}"/>">Delete</a>
			</tr>
		</c:forEach>
	</table>
</div>
<div>
	<a href="${pageContext.request.contextPath}">Back</a>
</div>

</body>
</html>