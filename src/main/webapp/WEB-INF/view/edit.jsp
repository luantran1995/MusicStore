<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

<link href="<c:url value="/css/common.css"/>" rel="stylesheet">
<script>
	function validateForm() {
		var x = document.forms["myForm"]["price"].value;

		if (x == "") {
			alert("Please enter price ");
			return false;
		}
	
	}

</script>
<script>
function previewFile(){
	 var fileInput = document.getElementById('file');
	
	 var filePath = fileInput.value;
	 var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
	 if(!allowedExtensions.exec(filePath)){
	        alert('Please upload file having extensions .jpeg/.jpg/.png/.gif only.');
	        fileInput.value = '';
	        return false;
	 }
	
    var preview = document.querySelector('img'); //selects the query named img
    var file    = document.querySelector('input[type=file]').files[0]; //sames as here
    var reader  = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
    }

    if (file) {
    	document.getElementById("showImage").style.display = 'block';
    	reader.readAsDataURL(file); //reads the data as a URL
    } else {
        preview.src = "";
    }
}

previewFile();  //calls the function named previewFile()
</script>

<%
	String baseURL = (String) request.getAttribute(AdminController.PARAM_BASE_URL);
	String latestPhotoUpload = (String) request.getAttribute(AdminController.PARAM_LATESTPHOTO);
%>
<style>
img {
    max-width: 50%;
    height: 80px;
 display: inline-block;
 }
</style>
<form:form action="${pageContext.request.contextPath}/admin/update"
	method="POST" commandName="albumVO" enctype="multipart/form-data"  
	
	class="" name="myForm" onsubmit="return validateForm()" >


	<div class="container">
		<div class="form-group">
			<label>Genre:</label>
		</div>
		<div class="form-group">
			<form:select class="form-control" path="idGenre" style="width: 100%">
				<c:forEach items="${genres}" var="genre">
					<form:option value="${genre.id}" label="${genre.name}" />
				</c:forEach>
			</form:select>
		</div>

		<div class="form-group">
			<label>Artist:</label>
		</div>
		<div class="form-group">
			<form:select class="form-control" path="idArtist" style="width: 100%">
				<c:forEach items="${artists}" var="artist">
					<form:option value="${artist.id}" label="${artist.name}" />
				</c:forEach>
			</form:select>
		</div>


			<div class="form-group">
				<label>Price:</label>
			</div>
			<div class="form-group ">
				<form:input type="number" step="0.001" path="price"
					class="form-control " min="0" placeholder="input Title of Price"
					style="width: 100%" />
				<form:errors path="price" cssClass="has-error"></form:errors>

			</div>

			<div class="form-group ">
				<label>Title:</label>
			</div>
			<div class="form-group ">
				<form:input type="text" path="title" class="form-control"
					placeholder="input Title of album" style="width: 100%" />
				<form:errors path="title" cssClass="has-error"></form:errors>

			</div>


		<div class="form-group ">
			<label>Image:</label>
		</div>

			<div class="form-group" >
				 <input id="file" type="file" name="file"  onchange="previewFile()" />
				 <div id="showImage" style="display: none;">
				 	<img src="<%=baseURL%>/image/<%=latestPhotoUpload%>">
				 </div>
				<form:errors name="file" cssClass="has-error"></form:errors>
			</div>

		<p>
			<button class="btn btn-success" type="submit" value="Submit">Save</button>
		</p>
	</div>
</form:form>



<div id="footer">
	<a href="https://spring.io/">built with Spring MVC </a>
</div>

<script src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>