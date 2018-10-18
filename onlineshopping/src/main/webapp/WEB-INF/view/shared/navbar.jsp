<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${SITE_URL}/home">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<li class="nav-item" id="home"><a class="nav-link"
					href="${SITE_URL}/home">Home</a></li>

				<li class="nav-item" id="about"><a class="nav-link"
					href="${SITE_URL}/about">About</a></li>

				<li class="nav-item" id="contact"><a class="nav-link"
					href="${SITE_URL}/contact">Contact</a></li>
				<li class="nav-item" id="listproducts"><a class="nav-link"
					href="${SITE_URL}/show/all/products">View Products</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item" id="manageproducts"><a class="nav-link"
						href="${SITE_URL}/manage/products">Manage Products</a></li>
				</security:authorize>
			</ul>
			<ul class="navbar-nav ml-auto navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="register" class="nav-item"><a
						href="${SITE_URL}/register" class="nav-link">Sign Up</a></li>
					<li class="nav-item"><a href="${SITE_URL}/login"
						class="nav-link">Login</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li  id= "fullnamedrop" class="nav-item dropdown " ><a href="javascript:void(0)"
							class="dropdown-toggle nav-link"  data-toggle="dropdown" >${userModel.fullName}</a><span
							class="glyphicon glyphicon-caret"></span>
							<ul class="dropdown-menu ">
								<security:authorize access="hasAuthority('USER')">
									<li class="dropdown-item"><a href="${SITE_URL}/cart/show"><span
										class="glyphicon glyphicon-shopping-cart glyphicon-sm"><span class="badge">${userModel.cart.cartLine} </span>  &#8377;-${userModel.cart.grandTotal}</span></a></li>
									<li class="divider" for="seperator"></li>
								</security:authorize>
								
								
								<li class="dropdown-item"><a href="${SITE_URL}/logout-user">Logout</a></li>
							</ul></li>
					</security:authorize>
			</ul>
		</div>
	</div>
</nav>
