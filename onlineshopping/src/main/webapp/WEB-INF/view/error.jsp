<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var ="css" value="/resources/css"></spring:url>

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
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${SITE_URL}/home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
      </div>
    </nav>
		<div class="container">
			<h1>${errorTitle}</h1>
			<div class="jumbotron">
				<blockquote>
					${errorDescription}
				</blockquote>
				
			</div>
			<a href = "${SITE_URL}/home" class="btn btn-success"> Back</a>
		</div>
  </body>

</html>
