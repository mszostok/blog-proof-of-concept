<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:head/>
<t:nav/>
<t:header/>

<!-- Main Content -->
<div class="container-fluid site">
    <div class="row">
            <jsp:include page="/WEB-INF/views/${pageContentPath}.jsp"/>
    </div>
</div>

<t:footer/>


