<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="contractType" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Contract type: </label>
				<form:input class="form-control" path="type"></form:input>
				<form:errors path="type" cssclass="error">${nameError}</form:errors>
				<label id="contractTypeError">${contractTypeError}</label>
			</div>
		</div> 
	</div>
	<div class="form-group">
		<input type="submit" value="Save" class="btn btn-primary" />
	</div>
</form:form>