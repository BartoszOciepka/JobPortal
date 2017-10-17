<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="contractType" items="${contractTypes}">
	${contractType} <a href="/JobPortal/contracttype/delete/${contractType.getId()}">Delete</a>
	<br />
</c:forEach>