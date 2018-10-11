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
				<li class="nav-item" id="manageproducts"><a class="nav-link"
					href="${SITE_URL}/manage/products">Manage Products</a></li>
			</ul>
			<ul class="navbar-nav ml-auto navbar-right">
				<li id="register" class="nav-item"><a
					href="${SITE_URL}/register" class="nav-link">Sign Up</a></li>
				<li class="nav-item"><a href="${SITE_URL}/login"
					class="nav-link">Login</a></li>
				<li class="nav-item dropdown " > <a href="javascript:void(0)"
					class="dropdown-toggle nav-link" data-toggle="dropdown">Full Name </a><span
					class="glyphicon glyphicon-caret"></span>
					<ul class="dropdown-menu ">
						<li class="dropdown-item">
							<a ><span class="badge">0</span><span class="glyphicon glyphicon-shopping-cart glyphicon-sm"></span></a></li>
						<li class="dropdown-item"> &#8377; - 0.000</li>
						<li class="divider" for="seperator"></li>
						<li class="dropdown-item"><a href="${SITE_URL}/logout" >Logout</a></li>
					</ul></li>


			</ul>
		</div>
	</div>
</nav>
