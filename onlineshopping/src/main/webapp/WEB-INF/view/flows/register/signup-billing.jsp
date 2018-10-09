<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="shared/flow-header.jsp"%>

<div class="container">
	<div class="col-md-offset-2 col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h1>User Details</h1>
			</div>

			<div class="panel-body ">

				<sf:form modelAttribute="address" class="form-horizontal">
					<div class="form-group">

						<label class="control-label  col-md-4" for="addressLine1">Enter
							Address Line One</label>

						<div class="col-md-8">
							<sf:input type="text" id="addressLine1" path="addressLineOne"
								class="form-control " placeholder="Enter address line one name" />
						</div>
						<sf:errors path="addressLineOne" cssClass="error-body" element="em"></sf:errors>
					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="addressLineTwo">Enter
							address line two</label>

						<div class="col-md-8">
							<sf:input type="text" id="addressLineTwo" path="addressLineTwo"
								class="form-control " placeholder="Enter address line two name" />
						</div>
						<sf:errors path="addressLineTwo" cssClass="error-body" element="em"></sf:errors>
					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="city">Enter
							your city</label>

						<div class="col-md-8">
							<sf:input type="text" id="city" path="city"
								class="form-control " placeholder="Enter your city" />
						</div>
						<sf:errors path="city" cssClass="error-body" element="em"></sf:errors>
					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="country">Enter
							your country</label>

						<div class="col-md-8">
							<sf:input type="text" id="country" path="country"
								class="form-control " placeholder="Enter your country" />
						</div>
						<sf:errors path="country" cssClass="error-body" element="em"></sf:errors>
					</div>
					<div class="form-group">

						<label class="control-label  col-md-4" for="postalCode">Enter
							postal code</label>

						<div class="col-md-8">
							<sf:input type="text" id="postalCode" path="postalCode"
								class="form-control " placeholder="Enter Contact Number" />
						</div>
						<sf:errors path="postalCode" cssClass="error-body" element="em"></sf:errors>
					</div>
					<div class="col-md-offset-4 col-md-8">
						<button type="submit" name="_eventId_confirm" class="btn btn-success ">Confirm
							<span class="glyphicon glyphicon-chevron-right"></span></button>
						
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>

<%@include file="shared/flow-footer.jsp"%>