<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="jobOffer" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="name"></form:input>
				<form:errors path="name" cssclass="error" />
			</div>
			<div class="col">
				<label for="description">Description: </label>
				<form:input class="form-control" path="description"></form:input>
				<form:errors path="description" cssclass="error" />
			</div>
			<div class="col">
				<label for="city">City: </label>
				<form:input class="form-control" path="city"></form:input>
				<form:errors path="city" cssclass="error" />
			</div>
			<div class="col">
				<label for="surname">Qualifications: </label>
				<form:select path="qualifications" items="${qualifications}"
					multiple="true" itemValue="id" itemLabel="name" />
				<form:errors path="qualifications" cssclass="error" />
			</div>
			<div class="col">
				<label for="isSponsored">Is sponsored?: </label>
				<form:checkbox path="isSponsored" />
				<form:errors path="isSponsored" cssclass="error" />
			</div>
			<div class="col">
				<label for="vacancies">Number of vacancies: </label>
				<form:input class="form-control" path="vacancies" />
				<form:errors path="vacancies" cssclass="error" />
			</div>
			<div class="col">
				<label for="aboutUs">About Us: </label>
				<form:input class="form-control" path="aboutUs" />
				<form:errors path="aboutUs" cssclass="error" />
			</div>
			<div class="col">
				<label for="experience">Years of experience: </label>
				<form:input class="form-control" path="experience" />
				<form:errors path="experience" cssclass="error" />
			</div>
			<div class="col">
				<label for="contractTypes">Contract Types: </label>
				<form:select path="contractType" items="${contractTypes}"
					multiple="false" itemValue="id" itemLabel="type" />
				<form:errors path="contractType" cssclass="error" />
			</div>
			<div class="col">
				<label for="minSalary">Minimal salary: </label>
				<form:input class="form-control" path="minSalary" />
				<form:errors path="minSalary" cssclass="error" />
			</div>
			<div class="col">
				<label for="maxSalary">Maximal salary: </label>
				<form:input class="form-control" path="maxSalary" />
				<form:errors path="maxSalary" cssclass="error" />
			</div>
			<div class="col">
				<label for="minWorkingHours">Min working hours: </label>
				<form:input class="form-control" path="minWorkingHours" />
				<form:errors path="minWorkingHours" cssclass="error" />
			</div>
			<div class="col">
				<label for="maxWorkingHours">Max working hours: </label>
				<form:input class="form-control" path="maxWorkingHours" />
				<form:errors path="maxWorkingHours" cssclass="error" />
			</div>
			<div class="col">
				<label for="company">Contract Types: </label>
				<form:select path="company" items="${companies}" multiple="false"
					itemValue="id" itemLabel="name" />
				<form:errors path="company" cssclass="error" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="Save" class="btn btn-primary" />
	</div>
</form:form>