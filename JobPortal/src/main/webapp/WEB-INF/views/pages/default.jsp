<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="search" method="post">

 <form:input path="phrase" id="phrase"></form:input>
 <form:errors path="phrase" cssclass="error" />
 
 <form:input path="city" id="city"></form:input>
 <form:errors path="city" cssclass="error" />
 
 <input type="submit" value="Search" />
</form:form>