<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="m" uri="menu" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<c:set var="baseURL" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<aside class="col-md-3 col-sm-4 col-xs-12 sidebar">
    <div class="row">
        <div class="col-xs-12">
            <div class="user-welcome-info">
                <h3 class="headline">Welcome, <security:authentication property="principal.user.firstName"/></h3>
                <p>
                    <security:authentication property="principal.username"/>
                    <security:authentication property="principal.authorities" var="authorities"/>
                    <c:forEach var="authority" items="${authorities}">
                        <span class="label label-default">${authority}</span>
                    </c:forEach>
                </p>
            </div>
            <m:listGroupItem icon="fa-table" name="Dashboard" path="/admin"
                             active="${baseURL}"/>
            <m:listGroupItem icon="fa-home" name="Home page" path="/"
                             active="${baseURL}"/>
            <m:listGroupItem icon="fa-users" name="Users" path="#"
                             active="${baseURL}"/>
            <m:listGroupItem icon="fa-sticky-note" name="Posts" path="#"
                             active="${baseURL}"/>


            <form role="form" action="<t:url value='/logout' />" method="post">


                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="list-group-item" type="submit">
                    <i class="fa fa-sign-out" aria-hidden="true"></i> Log out
                </button>
            </form>
        </div>
    </div>
</aside>