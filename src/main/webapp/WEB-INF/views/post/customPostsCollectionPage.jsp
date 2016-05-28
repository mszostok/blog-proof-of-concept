<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setLocale value="en_US" scope="session"/> <!-- Fix locale due to the fact that other stuff are not translated yet-->

<div class="col-md-7 col-sm-8 col-xs-12   col-md-offset-2 col-sm-offset-2 home-page">

    <br/>

    <c:choose>
        <c:when test="${empty posts}">
            <div class="alert alert-info">
                <strong>Sorry</strong>,
                    ${not empty message ? message : ' no posts matched your criteria.'}
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach var="post" items="${posts}">
                <div class="post-preview">
                    <a href="<spring:url value='/post/${post.idPost}/${post.url}'/>">
                        <h2 class="post-title">
                                ${post.title}
                        </h2>

                        <h3 class="post-subtitle">
                                ${post.content}
                        </h3>
                    </a>
                    <p class="post-meta">Posted on <fmt:formatDate pattern="dd MMMM yyyy" value="${post.postDate}"  />
                        by ${post.userFullName}
                    <span class="tags" style="margin-left: 10px; font-size: 15px;">
                        <i class="fa fa-tags" aria-hidden="true"></i>

                        <c:forEach var="tag" items="${post.tags}">
                            <span class="label label-default">${tag}</span>
                        </c:forEach>
                    </span>
                    </p>
                </div>
                <hr>
            </c:forEach>
        </c:otherwise>
    </c:choose>


</div>
<t:sidebar/>

