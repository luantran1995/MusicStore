<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>
		<div>
			<ul id="categories">
				<c:forEach var="genre" items="${genres}">
					<li><a href="<c:url value="/genre?name=${genre.name}"/>">${genre.name}</a></li>
				</c:forEach>
			</ul>
		</div>

		<div>
			<table>
				<tr>
					<th>Image</th>
					<th>Title</th>
					<th>Artist</th>
					<th>Genre</th>
					<th></th>
					
				</tr>
				<c:forEach items="${albums}" var="album">
					<tr>
						<td><img src="<c:url value="${album.albumArtUrl}" />" /></td>
						<td>${album.title}</td>
						<td>${album.artist.name }</td>
						<td>${album.genre.name }</td>
						<td>
						<button class="button" type="submit">Add Cart</button> <br />
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>		
		<a href="${pageContext.request.contextPath}">Back</a>
		</div>

</body>
</html>