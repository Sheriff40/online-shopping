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

    <title> onlineshopping - Sign Up</title>
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
	
	
	 <!-- Toggle -->
	<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
    
   
    
	

  </head>

  <body>
  <%@include file="flow-navbar.jsp" %>