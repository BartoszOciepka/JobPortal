<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="company" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="name"></form:input>
				<form:errors path="name" cssclass="error"></form:errors>
			</div>
			<div class="col">
				<label for="companyEmail">Name: </label>
				<form:input class="form-control" path="companyEmail"></form:input>
				<form:errors path="companyEmail" cssclass="error"></form:errors>
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value ="Save" class="btn btn-primary" />
	</div>
</form:form>