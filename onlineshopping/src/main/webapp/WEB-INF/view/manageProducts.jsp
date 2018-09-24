<div class="container">

	<div class="col-md-offset-2 col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h1>Manage Products</h1>
			</div>

			<div class="panel-body ">
				<form class="form-horizontal">

					<div class="form-group">

						<label class="control-label  col-md-4" for="name">Enter
							Product Name</label>

						<div class="col-md-8">
							<input type="text" id="name" name="name" class="form-control "
								placeholder="Enter Product name" /> <em class="help-block">*
								Enter the product Name</em>
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="brandname">Enter
							Product Name</label>

						<div class="col-md-8">
							<input type="text" id="brand-name" name="brand"
								class="form-control " placeholder="Enter Brand name" /> <em
								class="help-block">* Enter the Brand Name</em>
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="productdesc">Product
							Description</label>

						<div class="col-md-8">
							<textarea type="text" rows='4' id="product-desc"
								name="description" class="form-control ">
							
							</textarea>

						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="unitPrice">Enter
							Unit Price</label>

						<div class="col-md-8">
							<input type="number" id="unit-price" name="unitPrice"
								class="form-control " placeholder="Enter Unit Price" /> <em
								class="help-block">* Enter the Unit Price</em>
						</div>


					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="quantity">Quantity
							Available</label>

						<div class="col-md-8">
							<input type="number" id="quantity" name="quantity"
								class="form-control " placeholder="Enter Quantity" /> <em
								class="help-block">* Enter the Quantity</em>
						</div>


					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="categoryId">Select the category Id: </label>
						<div class="col-md-8">
							<select class="form-control" name="categoryId" id="categoryId">
								<option value="1">Category One</option>
								<option value="2">Category Two</option>
								<option value="3">Category Three</option>
							</select>
						</div>
	
					</div>
					<div class="col-md-offset-4 col-md-8">
						<input type = "submit" value = "Submit" name = "submit" id = "submit" class="btn btn-success "/>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>