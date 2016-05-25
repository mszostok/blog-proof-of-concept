<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="active" value="/manager" scope="request" />
<div class="row">
    <div class="col-xs-12">
        <h1>Admin Dashboard</h1>
        <p>What you want to do?</p>
        <div class="row">

            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="tile">
                <a href="<t:url value="/admin/manage-users/"/>">
                    <div class="text-center"><i class="fa fa-3x fa-users"></i>
                        <h3>Users<div class="small">Manage users</div></h3>
                    </div>
                </a>
                    </div>
            </div>

            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="tile">
                    <a href="/admin/manage-posts">
                        <div class="text-center"><i class="fa fa-3x  fa-sticky-note"></i>
                            <h3>Post<div class="small">Manage post</div></h3>
                        </div>
                    </a>
                </div>
            </div>

        </div>

    </div>
</div>
