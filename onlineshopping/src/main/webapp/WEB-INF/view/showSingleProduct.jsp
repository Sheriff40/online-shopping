<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${SITE_URL}/home">Home</a></li>
				<li><a href="${SITE_URL}/show/all/products">All products</a> </li>
				<li class="active">${product.name} </li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<div class="thumbnail">
				<img src = "${images}/${product.code}.jpg" class="img-responsive"/>
			</div>
		</div>
		
		
		<div class="col-xs-8">
			<hr/>
			<h1>${product.name }</h1>
			<hr/>
			<p> ${product.description} </p>
			<hr/>
			<h3>Price : ${product.unitPrice} </h3>
			<hr/>
			<h4>Quantity Available : 
			<c:choose>
				<c:when test="${product.quantity > 1}" >
					${product.quantity}	
				</c:when>
				<c:otherwise >
					<span style="color:red">Out of Stock</span>
				</c:otherwise>
			</c:choose> </h4>
			<hr/>
			<h6> Views  : ${product.views} </h6>
			
			<c:choose>
				<c:when test="${product.quantity > 1}" >
					<a href = "${SITE_URL}/add/cart/${product.id}/product" class="btn btn-success"> <span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart </a> &nbsp;
				</c:when>
				<c:otherwise >
					<a href = "javascript:void(0)" class="btn btn-success disabled">
					
					<span class="glyphicon glyphicon-shopping-cart"></span>
					<strike>Add to Cart </strike></a> &nbsp;
				</c:otherwise>
			</c:choose>
			
			<a href = "${SITE_URL}/show/all/products" class="btn btn-primary ">Back</a>
		</div>
		
	</div>
</div>