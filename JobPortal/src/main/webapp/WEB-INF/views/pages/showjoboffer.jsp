<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

${jobOffer.getName()} <br />
${jobOffer.getDescription()}<br />
${jobOffer.getCity()}<br />
${jobOffer.getName()}<br />
Qualifications:<br />
<c:forEach var="qualification" items="${jobOffer.getQualifications()}">
	${qualification}<br />
</c:forEach>