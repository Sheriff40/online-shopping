<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${SITE_URL}/resources/css/cart.css" rel="stylesheet" />
<c:choose>
	<c:when test="${carts == null}">

		<div class="container">
			<div class="jumbotron">Cart is Empty</div>

		</div>
		
	</c:when>
	
	<c:otherwise>

		<div class="container">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="cartLine" items="${carts}">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${SITE_URL}/resources/images/${cartLine.product.code}.jpg"
											alt="${cartLine.product.name}" class="img-responsive" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin"></h4>
										<p>${cartLine.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377;${cartLine.product.unitPrice}
							</td>
							<td data-th="Quantity"><input type="number"
								class="form-control text-center"
								value="${cartLine.productCount }"></td>
							<td data-th="Subtotal" class="text-center">${cartLine.total}</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm">
									<i class="glyphicon glyphicon-refresh"></i>
								</button>
								<button class="btn btn-danger btn-sm">
									<i class="glyphicon glyphicon-trash"></i>
								</button>
							</td>
						</tr>

					</c:forEach>

				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total ${userModel.cart.grandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="#" class="btn btn-warning"><i
								class="glyphicon glyphicon-shopping-cart"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong> &#8377;
								${userModel.cart.grandTotal}</strong></td>
						<td><a href="${SITE_URL}/checkout"
							class="btn btn-success btn-block">Checkout <i
								class="glyphicon glyphicon-chevron-right"></i></a></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</c:otherwise>
</c:choose>



