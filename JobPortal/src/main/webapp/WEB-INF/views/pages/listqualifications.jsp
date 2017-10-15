<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="qualification" items="${qualifications}">
	${qualification} <a href="/JobPortal/qualification/delete/${qualification.getId()}">Delete</a><br/>
</c:forEach>