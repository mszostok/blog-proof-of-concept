<%@ tag %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid nav-big-font">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<spring:url value="/"/>">Home</a>
                </li>
                <li>
                    <a href="<spring:url value="/post/add-form"/>">Add new post</a>
                </li>

                <!-- Add Profile button only to/for Logged in Users  -->
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span>
                            <strong><security:authentication property="principal.user.firstName"/></strong>
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul class="dropdown-menu list-group ">
                            <li>
                                <div class="navbar-login">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-4 col-xs-4">
                                            <p class="text-center">
                                                <i class="fa fa-5x fa-user" aria-hidden="true"></i>
                                            </p>
                                        </div>
                                        <div class="col-lg-8 col-md-8 col-xs-8">
                                            <p class="text-left"><strong><security:authentication
                                                    property="principal.user.firstName"/>
                                                <security:authentication property="principal.user.lastName"/></strong>
                                            </p>
                                            <p class="text-left small"><security:authentication
                                                    property="principal.user.eMail"/></p>
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-xs-12 ">
                                            <security:authentication property="principal.authorities"
                                                                     var="authorities"/>
                                            <c:forEach var="authority" items="${authorities}">
                                                <span class="label label-default">${authority}</span>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <security:authorize access="hasAuthority('ADMIN') and isAuthenticated()">
                                <li class="divider navbar-login-session-bg"></li>
                                <li>
                                    <a href="<spring:url value='/admin' />" class="button" style="color: black !important;">
                                        <i class="fa fa-table" aria-hidden="true"></i> Admin Dashboard
                                    </a>
                                </li>

                            </security:authorize>

                            <li class="divider navbar-login-session-bg"></li>
                            <li>
                               <tag:logoutButton />
                            </li>
                        </ul>
                    </li>
                </security:authorize> <!-- End button for logged in users -->
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>