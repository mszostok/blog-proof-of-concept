<%@ tag %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="menu" uri="menu" %>

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
            </div> <!-- /.user-welcome-info -->

            <!-- display admin navigation panel -->
            <menu:listGroupItem icon="fa-table" name="Dashboard" path="/admin"
                             activeUrlPattern="${baseURL}"/>
            <menu:listGroupItem icon="fa-home" name="Home page" path="/"
                             activeUrlPattern="${baseURL}"/>
            <menu:listGroupItem icon="fa-users" name="Users" path="/admin/manage-users"
                             activeUrlPattern="${baseURL}"/>
            <menu:listGroupItem icon="fa-sticky-note" name="Posts" path="/admin/manage-posts"
                             activeUrlPattern="${baseURL}"/>

            <!-- logout button -->
            <tag:logoutButton />

        </div>
    </div>
</aside>