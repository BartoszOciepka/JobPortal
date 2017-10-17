
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

${jobOffer.getName()}
<br />
${jobOffer.getDescription()}
<br />
${jobOffer.getCity()}
<br />
${jobOffer.getName()}
<br />
Qualifications:
<br />
<c:forEach var="qualification" items="${jobOffer.getQualifications()}">
	${qualification}<br />
</c:forEach>
${jobOffer.getIsSponsored()}
<br />
${jobOffer.getVacancies()}
<br />
${jobOffer.getAboutUs()}
<br />
${jobOffer.getExperience()}
<br />
${jobOffer.getMinSalary()} - ${jobOffer.getMaxSalary()}
<br />
${jobOffer.getMinWorkingHours()} - ${jobOffer.getMaxWorkingHours()}
<br />
${jobOffer.company.companyEmail()}
