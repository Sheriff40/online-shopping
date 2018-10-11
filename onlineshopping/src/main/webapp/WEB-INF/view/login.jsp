<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="SITE_URL" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>onlineshopping - ${title}</title>
<style>
#navbarResponsive li a:active {
	background: black;
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

<link href="${css}/jquery.dataTables.css" rel="stylesheet">


<!-- Toggle -->
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">




</head>

<body>


	<c:if test="${not empty logoutMsg}">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item" id="home"><a class="nav-link"
						href="${SITE_URL}/home">Home</a></li>
				</ul>
			</div>
		</nav>
	</c:if>


	<div class="container">


		<c:if test="${not empty message}">
			<div class=" col-md-offset-1 col-md-10">
				<div class="alert alert-danger alert-dismissible fade in">
					<button class="pull-right close" data-dismiss="alert">
						&times;</button>
					${message }
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h1>Login</h1>
				</div>
				<div class="panel-body">
					<form method="POST" id="loginForm" action="${SITE_URL}/login">
						<div class="form-group">
							<label for="email" class="control-label">Username/Email</label> <input
								type="email" name="email" class="form-control" id="email" />
						</div>
						<div class="form-group">
							<label for="password" class="control-label">Password</label> <input
								type="password" name="password" class="form-control"
								id="password" />
						</div>
						<div class="form-group text-center">
							<button type="submit" name="submit" value="submit"
								class="btn btn-success">Submit</button>
						</div>
						<hr>
							<p>Wanna explore as a guest: <a href="${SITE_URL}/">Guest</a><p>
						
					</form>
				</div>
			</div>
		</div>

	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>

	<script src="${js}/jquery.validate.js"></script>
	<script src="${js }/bootstrap.bundle.min.js"></script>

	<script src="${js}/active.js"></script>
</body>

</html>
