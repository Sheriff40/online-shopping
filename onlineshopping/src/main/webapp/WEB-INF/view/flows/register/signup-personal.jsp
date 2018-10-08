<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="shared/flow-header.jsp"%>



<div class="container">

	<div class="col-md-offset-2 col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h1>User Details</h1>
			</div>

			<div class="panel-body ">

				<sf:form modelAttribute="user" class="form-horizontal" method="POST">
					<div class="form-group">

						<label class="control-label  col-md-4" for="fname">Enter
							first Name</label>

						<div class="col-md-8">
							<sf:input type="text" id="fname" path="firstName"
								class="form-control " placeholder="Enter first name" />
							<sf:errors path="firstName" cssClass="error-body" element="em"></sf:errors>
						</div>

					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="lname">Enter
							last Name</label>

						<div class="col-md-8">
							<sf:input type="text" id="lname" path="lastName"
								class="form-control " placeholder="Enter last name" />
							<sf:errors path="lastName" cssClass="error-body" element="em"></sf:errors>
						</div>

					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="upassword">Enter
							password</label>

						<div class="col-md-8">
							<sf:input type="password" id="upassword" path="password"
								class="form-control " placeholder="XXXXXXXXX" />
							<sf:errors path="password" cssClass="error-body" element="em"></sf:errors>
						</div>

					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="ucpassword">Confirm
							password</label>

						<div class="col-md-8">
							<sf:input type="password" id="ucpassword" path="confirmpassword"
								class="form-control " placeholder="XXXXXXXXX" />
							<sf:errors path="confirmpassword" cssClass="error-body" element="em"></sf:errors>
						</div>

					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="email">Enter
							email</label>

						<div class="col-md-8">
							<sf:input type="email" id="uemail" path="email"
								class="form-control " placeholder="Enter email" />
								<sf:errors path="email" cssClass="error-body" element="em"></sf:errors>
						</div>

					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="contactNo">Enter
							contact no</label>

						<div class="col-md-8">
							<sf:input type="number" id="contactNo" path="contactNumber"
								class="form-control " placeholder="Enter Contact Number" />
							<sf:errors path="contactNumber" cssClass="error-body" element="em"></sf:errors>
						</div>

					</div>
					<div class="form-group">
						<label class="control-label  col-md-4" for="role">Role: </label>
						<div class="col-md-8">
							<label class="radio-inline">
								<sf:radiobutton path="role" value="USER" checked="checked"/> User
							</label>
							<label class="radio-inline">
								<sf:radiobutton path="role" value="ADMIN" /> Admin
							</label>
						</div>
					</div>
					<div class="col-md-offset-4 col-md-8">
						<button type="submit" name="_eventId_billing" class="btn btn-success ">Confirm
							<span class="glyphicon glyphicon-chevron-right"></span>
						</button>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>
<%@include file="shared/flow-footer.jsp"%>