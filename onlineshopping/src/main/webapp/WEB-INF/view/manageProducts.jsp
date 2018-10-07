<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<div class="col-md-12">
		<c:if test="${not empty message}">

			<div class="alert alert-danger fade in">

				<button class="pull-right close" data-dismiss="alert">
					&times;</button>
				${message}
			</div>

		</c:if>

	</div>
	<div class="col-md-offset-2 col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h1>User Details</h1>
			</div>

			<div class="panel-body ">



				<sf:form class="form-horizontal" modelAttribute="product"
					method="POST" action="${SITE_URL}/manage/products/save"
					enctype="multipart/form-data">

					<div class="form-group">

						<label class="control-label  col-md-4" for="name">Enter
							Product Name</label>

						<div class="col-md-8">
							<sf:input type="text" id="name" path="name" class="form-control "
								placeholder="Enter Product name" />
							<sf:errors path="name" cssClass="error-body" element="em"></sf:errors>
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="brandname">Enter
							the Brand Name</label>

						<div class="col-md-8">
							<sf:input type="text" id="brand-name" path="brand"
								class="form-control " placeholder="Enter Brand name" />
							<sf:errors path="brand" cssClass="error-body" element="em" />
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="productdesc">Product
							Description</label>

						<div class="col-md-8">
							<sf:textarea type="text" rows='4' id="product-desc"
								path="description" class="form-control " />
							<sf:errors path="description" cssClass="error-body" element="em" />
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="unitPrice">Enter
							Unit Price</label>

						<div class="col-lg-8">
							<sf:input type="number" id="unit-price" path="unitPrice"
								class="form-control " placeholder="Enter Unit Price" />
							<sf:errors path="unitPrice" cssClass="error-body" element="em" />
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="quantity">Quantity
							Available</label>

						<div class="col-md-8">
							<sf:input type="number" id="quantity" path="quantity"
								class="form-control " placeholder="Enter Quantity" />

						</div>


					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="file">Select
							the file: </label>
						<div class="col-md-8">
							<sf:input type="file" path="file" id="file" />
							<sf:errors path="file" cssClass="error-body" element="em" />
						</div>

					</div>

					<div class="form-group">
						<label class="control-label col-md-4" for="categoryId">Select
							the category Id: </label>
						<div class="col-md-8">
							<sf:select class="form-control" path="categoryId" id="categoryId"
								items="${category}" itemLabel="name" itemValue="id" />

						</div>
					</div>


					<sf:hidden path="id" />
					<sf:hidden path="code" />
					<sf:hidden path="active" />
					<sf:hidden path="supplierId" />
					<sf:hidden path="purchases" />
					<sf:hidden path="views" />



					<div class="col-md-offset-4 col-md-8">
						<input type="submit" value="Submit" name="submit" id="submit"
							class="btn btn-success " />
					</div>
				</sf:form>
			</div>

		</div>
	</div>



	<div class='col-md-12'>
		<table id="adminProductTable"
			class="table table-striped table-bordered">
			<thead>
				<th>Id</th>
				<th>Image</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Active</th>
				<th>Edit</th>
			</thead>

		</table>


	</div>
</div>