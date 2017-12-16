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
			<p>
				<img alt="image" src="<c:url value="${album.albumArtUrl}"/>" />
			</p>
			<div id="album-details">
				<p>
					<em>Genre:</em> <span>${album.genre.name}</span>
				</p>
				<p>
					<em>Artist:</em> <span>${album.artist.name}</span>
				</p>
				<p>
					<em>Price:</em> <span>${album.price}</span>
				</p>
				<button class="button">Add Cart</button>
			</div>
		</div>

		<div id="footer">
			<a href="https://spring.io/">built with Spring MVC </a>
		</div>
</body>
</html>