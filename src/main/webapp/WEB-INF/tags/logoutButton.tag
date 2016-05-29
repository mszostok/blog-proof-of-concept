<%@ tag %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/logout" var="logoutURL" />

<form role="form" action="${logoutURL}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button class="list-group-item" type="submit" >
        <i class="fa fa-sign-out" aria-hidden="true"></i> Log out
    </button>
</form>
