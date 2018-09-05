


<div class="container">
	<div class="row">


		<div class="col-md-3">

			<!-- Included Sidebar -->
			<%@ include file="sidebar.jsp"%>
		</div>

		<c:if test="${UserClickShowAll == true}">
			<div class="col-md-9">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${SITE_URL}/home ">Home</a></li>
						<li class="active breadcrumb-item ">All products</li>
					</ol>
				</nav>
			</div>
		</c:if>


		<c:if test="${UserClickIdProduct == true}">
			<div class="col-md-9">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${SITE_URL}/home">Home</a></li>
						<li class="breadcrumb-item active">Category </li>
						<li class="breadcrumb-item active">${category.name}</li>
					</ol>
				</nav>
			</div>
		</c:if>


	</div>
</div>