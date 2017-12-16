
<%@page import="com.luantran.musicstore.controller.AdminController"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns:th="http://www.thymeleaf.org">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- MaCarouselin CSS -->
<link href="<c:url value="/css/carousel.css" />"rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/common.css"/>" rel="stylesheet">


<div  class="container">
<h2>Address And Payment</h2>
  <fieldset>
        <h1>Shipping Information</h1>
      </fieldset>
        
 <form:form method="POST" commandName="cart" action="${pageContext.request.contextPath}/viewcart/checkout/submit">
      
        <div class="editor-field">
        <label>GrandTotal</label>
            <input  class="form-control"  type="text" placeholder="GrandTotal" value="${cart.grandTotal}" disabled />
            
        </div>
         <spring:bind path="name">
         <label>Name</label>
        <div  class="${status.error ? 'has-error' : ''}">
                    <form:input  class="form-control" type="text"  path="name" placeholder="Name" />
				<form:errors path="name"></form:errors>
                    
        </div>
        </spring:bind>

        <spring:bind path="phone">
        <label>Phone</label>
				<div class="${status.error ? 'has-error' : ''}">
					<form:input type="text" path="phone" class="form-control"
					placeholder="phone"></form:input> 
					<form:errors path="phone"></form:errors> 
				</div>
			</spring:bind>
			
		<spring:bind path="address">
		<label>Address</label>
         <div  class="${status.error ? 'has-error' : ''}">
                    <form:input  type="text" path="address" class="form-control" placeholder="Address" />
				<form:errors path="address"></form:errors>
                    
        </div>
        </spring:bind>
        <br/>
        
    <input  class="form-control"  type="submit" value="Submit Order" />
    </form:form>
    
   
</div>
  