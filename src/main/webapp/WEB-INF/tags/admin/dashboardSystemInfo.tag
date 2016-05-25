<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-inverse" >
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <p style="color: white"><strong>AdminPanel</strong> 1.0 <span class="label label-primary">Alfa</span></p>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        <span class="glyphicon glyphicon-user"></span>
                        <strong ><security:authentication property="principal.user.firstName"/></strong>
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
                        <li class="divider navbar-login-session-bg"></li>
                        <li>
                            <a href="<t:url value='/admin' />" class="button">
                                <i class="fa fa-table" aria-hidden="true"></i> Admin Dashboard
                            </a>
                        </li>
                        <li class="divider navbar-login-session-bg"></li>
                        <li>
                            <form role="form" action="<t:url value='/logout' />" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit">
                                    <i class="fa fa-sign-out" aria-hidden="true"></i> Log out
                                </button>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
