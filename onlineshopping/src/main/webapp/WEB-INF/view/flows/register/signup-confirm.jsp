<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="shared/flow-header.jsp"%>

<div class="container">

	<div class="col-md-6">

		<div class="panel panel-danger">
			<div class="panel-heading">
				<h1>User</h1>
			</div>
			<div class="panel-body">
				<div class="text-center">
					<h5>${registerModel.user.firstName}
						${registerModel.user.lastName}</h5>
					<h5>${registerModel.user.email}</h5>
					<h5>${registerModel.user.contactNumber}</h5>
					<h5>${registerModel.user.role}</h5>
					<h5>${registerModel.user.password}</h5>
				</div>
			</div>
			<div class="panel-footer">
				<a href="${flowExecutionUrl}&_eventId_personal">Edit</a>

			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h1>Address</h1>
			</div>
			<div class="panel-body">
				<div class="text-center">
					<h5>${address.addressLineOne}</h5>
					<h5>${address.addressLineTwo}</h5>
					<h5>${address.city}</h5>
					<h5>${address.country}</h5>
					<h5>${address.postalCode}</h5>

				</div>
			</div>
			<div class="panel-footer">
				<a href="${flowExecutionUrl}&_eventId_billing">Edit</a>
			</div>
		</div>
	</div>
	<div class="text-center">
		<a type="submit" href="${flowExecutionUrl}&_eventId_submit"
			class="btn btn-success">Confirm</a>
	</div>
</div>


<%@include file="shared/flow-footer.jsp"%>