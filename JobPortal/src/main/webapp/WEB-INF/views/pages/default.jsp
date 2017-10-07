<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form modelAttribute="search" method="post">
	<div class="form-group">
		<div class="row">
			<div class="col">
				<label for="name">Name: </label>
				<form:input class="form-control" path="phrase"
					id="phrase"></form:input>
				<form:errors path="phrase" cssclass="error" />
			</div>
			<div class="col">
				<label for="name">City: </label>
				<form:input class="form-control" path="city"
					id="city"></form:input>
				<form:errors path="city" cssclass="error" />
			</div>
			<div class="form-group">
				<input type="submit" value="Search " class="btn btn-primary" />
			</div>
		</div>
	</div>

</form:form>

<c:forEach var="offer" items="${offers}">
${offer}<br /></c:forEach>