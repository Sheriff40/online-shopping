


<div class="container">
	<div class="row">


		<div class="col-md-3">

			<!-- Included Sidebar -->
			<%@ include file="sidebar.jsp"%>
		</div>


		<c:if test="${UserClickShowAll == true}">
			<script>
				window.categoryId = '';
			</script>
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-12">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${SITE_URL}/home ">Home</a></li>
								<li class="active breadcrumb-item ">All products</li>
							</ol>
						</nav>
					</div>

				</div>
				<div class="row">
					<div class='col-xs-12'>
						<table id="listProductTable"
							class="table table-striped table-bordered">
							<thead>
								<th>Image</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Active</th>
								<th>Actions</th>
							</thead>
						</table>
					</div>
				</div>


			</div>


		</c:if>


		<c:if test="${UserClickIdProduct == true}">
			<script>
				window.categoryId = '${category.id}';
			</script>
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-12">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${SITE_URL}/home">Home</a></li>
								<li class="breadcrumb-item active">Category</li>
								<li class="breadcrumb-item active">${category.name}</li>
							</ol>
						</nav>
					</div>

				</div>
				<div class="row">
					<div class="col-md-12">
						<table id="listProductTable"
							class="table table-striped table-bordered">
							<thead>
								<th>Image</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Active</th>
								<th>Actions</th>
							</thead>
						</table>
					</div>

				</div>
			</div>
		</c:if>


	</div>



</div>