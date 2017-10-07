<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="jobOffer" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="name" id="name"></form:input>
				<form:errors path="name" cssclass="error" />
			</div>
			<div class="col">
				<label for="description">Description: </label>
				<form:input class="form-control" path="description" id="description"></form:input>
				<form:errors path="description" cssclass="error" />
			</div>
			<div class="col">
				<label for="city">City: </label>
				<form:input class="form-control" path="city" id="city"></form:input>
				<form:errors path="city" cssclass="error" />
			</div>
			<div class="col">
				<label for="surname">Qualifications: </label>
				<form:select path="qualifications" items="${qualifications}"
					multiple="true" itemValue="id" itemLabel="name" />
				<form:errors path="qualifications" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Save " class="btn btn-primary" />
	</div>
</form:form>