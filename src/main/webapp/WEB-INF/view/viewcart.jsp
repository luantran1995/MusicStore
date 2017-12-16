<%@page import="java.util.List"%>
<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>
<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div class="body">
			
				<table class=" table">
					<tr>
						<th>Album name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="item" items="${cartItem}">
					<tr >
						<td>${item.album.title}</td>
						<td>${item.album.price}</td>
						<td>${item.quantity}</td>
						<td>${item.quantity * item.album.price}</td>
						<td><a href="<c:url value = "/viewcart/removeitem/${item.album.id}"/>"class="btn btn-default">Remove</a> </td>
					</tr>
					</c:forEach>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total:</th>
						<th>${grandTotal}</th>
						<th></th>
						<th></th>
					</tr>
				</table>
				<a href="<c:url value = "/genre?name=${genre}"/>"class="btn btn-default">Back</a>
				<a href="<c:url value = "/viewcart/checkout"/>" class="btn  btn-success">Check out</a>
				<a href="<c:url value = "/viewcart/removeall"/>" class="btn-default btn">Clear Cart</a>
				
					
			</div>
	


