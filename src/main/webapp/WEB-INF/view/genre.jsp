<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
   <%
            String baseURL = (String) request.getAttribute(AdminController.PARAM_BASE_URL);
            String latestPhotoUpload = (String) request.getAttribute(AdminController.PARAM_LATESTPHOTO);
        %>
<style>
img {
    max-width: 90%;
    height: 80px;
}
</style>
<div>
	<ul id="categories">
		<c:forEach var="genre" items="${genres}">
			<li><a href="<c:url value="/genre?name=${genre.name}"/>">${genre.name}</a></li>
		</c:forEach>
	</ul>
</div>
<form action="/viewproduct" method="post">
	<div id="main">
		<div class="genre">
			<h2>Albums</h2>
			<ul id="album-list">
				<c:forEach items="${albums}" var="album">
					<li><a href="<c:url value="/viewproduct/${album.id}" />">
							<img src="<%=baseURL%>/image/${album.albumArtUrl}" class ="img" /> <span>${album.title}</span>
					</a></li>

				</c:forEach>
			</ul>
		</div>
	</div>



</form>

</body>
</html>