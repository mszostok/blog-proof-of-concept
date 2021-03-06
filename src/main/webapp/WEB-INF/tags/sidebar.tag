<%@ tag %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="menu" uri="menu" %>

<c:set var="baseURL" value="${requestScope['javax.servlet.forward.request_uri']}"/>


<aside class="col-md-2 col-sm-4 col-xs-12 sidebar">
    <div class="row">
        <div class="col-xs-12">

            <!-- Add login form only for not logged in users  -->
            <security:authorize access="isAnonymous()">
                <spring:url value="/login" var="loginURL" />
                <form role="form" action="${loginURL}" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <h3 class="headline">Login</h3>
                    <p>
                        Sign up or sign in to add posts and comments. It's free and always will be !
                    </p>
                    <c:if test="${not empty error}">
                        <label class="form-control-label">Oops! Wrong email or password</label>
                    </c:if>

                    <div class="form-group ${ empty error ? '' : 'has-error'}">
                        <input type="text" name="email" class="form-control" placeholder="Login" required>
                    </div>
                    <div class="form-group ${empty error ? '' : 'has-error'}">
                        <input type="password" class="form-control" name="password" placeholder="Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                    <a href="#" class="pull-right register-link">Register</a>
                </form>
            </security:authorize>
            <br/>


            <h3>Search by Tag</h3>
            <spring:url value="/post" var="searchByTag" />
            <form:form action="${searchByTag}" method="GET">
                <div class="input-group">
                    <div class="input-group-addon">#</div>
                    <input type="text" class="form-control" name="tag" placeholder="Search for tag...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Search</button>
                    </span>
                </div>
            </form:form>
            <br/>


            <h3>Archives</h3>
            <ul class="list-group">
                <c:forEach var="position" items="${archivesList}">
                    <spring:url var="path" value="${position.archivePageUrl}" />
                    <menu:listGroupItem name="${position.displayName}" path="${path}"
                                     activeUrlPattern="${baseURL}"/>
                </c:forEach>
            </ul>

        </div>
    </div>
</aside>