<%@ tag %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="jumbotron" >
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <c:choose>
                        <c:when test="${empty headerTitle}">
                            <h1><a href="<spring:url value="/"/>" >Blog Proof of Concept</a> </h1>
                        </c:when>
                        <c:otherwise>
                            <h1>${headerTitle}</h1>
                        </c:otherwise>
                    </c:choose>
                    <hr class="small">
                    <span class="subheading">Nunc lobortis sit amet tortor a molestie</span>
                </div>
            </div>
        </div>
    </div>
</header>

