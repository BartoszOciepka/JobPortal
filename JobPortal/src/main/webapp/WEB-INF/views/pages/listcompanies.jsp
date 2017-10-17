<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="company" items="${companies}">
	${company} <a href="/JobPortal/company/delete/${company.getId()}">Delete</a>
	<br />
</c:forEach>