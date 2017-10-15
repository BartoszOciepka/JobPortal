<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="jobOffer" items="${jobOffers}">
	${jobOffer} <a href="/JobPortal/offer/delete/${jobOffer.getId()}">Delete</a><br/>
</c:forEach>