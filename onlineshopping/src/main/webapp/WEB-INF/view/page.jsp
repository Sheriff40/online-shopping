<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var ="css" value="/resources/css"></spring:url>
<spring:url var ="js" value="/resources/js"></spring:url>
<spring:url var ="images" value="/resources/images"></spring:url>

<c:set var ="SITE_URL" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> onlineshopping - ${title}</title>
	<style>
		#navbarResponsive li a:active
		{
			background:black;
		}
	</style>
	<script>
		window.menu = '${title}';
		window.siteURL = '${SITE_URL}';
	</script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

	<!-- Bootstrap-sketchy-theme -->
	<link href="${css}/bootstrap-sketchy-theme.css" rel="stylesheet">
	
	<link href="${css}/jquery.dataTables.css" rel="stylesheet" >
	
    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <%@ include file="./shared/navbar.jsp" %>
    
    <!-- Page Content -->
    
    <!-- Loading Home Content -->
   	<c:if test="${UserClickHome == true}">
   			<%@ include file="home.jsp" %>
   	</c:if>
   	
   	<!-- Loading About Content -->
   	<c:if test="${UserClickAbout == true}">
   			<%@ include file="about.jsp" %>
   	</c:if>
   	
   	<!-- Loading Contact Content -->
   	<c:if test="${UserClickContact == true}">
   			<%@ include file="contact.jsp" %>
   	</c:if>
   
   <!-- Loading Products --->
  	<c:if test="${UserClickShowAll == true or UserClickIdProduct == true}">
  		<%@ include file="showProduct.jsp" %>
  	</c:if>
   
   <!-- Loading Single Products --->
  	<c:if test="${UserClickSingleProduct == true}">
  		<%@ include file="showSingleProduct.jsp" %>
  	</c:if>
  
   

    <!-- Footer -->
    <%@ include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js }/bootstrap.bundle.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    
	<script src="${js}/active.js"></script>
  </body>

</html>
