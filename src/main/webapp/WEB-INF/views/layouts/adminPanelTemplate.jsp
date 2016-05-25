<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tagsAdmin" tagdir="/WEB-INF/tags/admin" %>

<t:head />
<tagsAdmin:dashboardSystemInfo />

<main class="container">
    <div class="row">
        <div class="col-md-9 col-sm-8 col-xs-12">
            <jsp:include page="/WEB-INF/views/${pageContentPath}.jsp" />
        </div>
        <tagsAdmin:adminSidebar />
    </div>
</main>
<t:footer />