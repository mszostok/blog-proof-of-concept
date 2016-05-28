<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="tagsAdmin" tagdir="/WEB-INF/tags/admin" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head />
<tagsAdmin:dashboardSystemInfo />

<!-- Main Content -->
<main class="container">
    <div class="row">
        <div class="col-md-9 col-sm-8 col-xs-12">
            <jsp:include page="/WEB-INF/views/${pageContentPath}.jsp" />
        </div>
        <tagsAdmin:adminSidebar />
    </div>
</main>

<tags:footer />