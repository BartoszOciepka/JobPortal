<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="add" modelAttribute="qualification" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Qualification: </label>
				<form:input class="form-control" path="name" id="name"></form:input>
				<form:errors path="name" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Save " class="btn btn-primary" />
	</div>
</form:form>