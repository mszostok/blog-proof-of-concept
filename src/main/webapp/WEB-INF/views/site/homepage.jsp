<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<fmt:setLocale value="en_US"
               scope="session"/> <!-- Fix locale due to the fact that other stuff are not translated yet-->

<div class="col-md-7 col-sm-8 col-xs-12   col-md-offset-2 col-sm-offset-2 home-page">

    <!-- Alert for message response attribute -->
    <div class="alert alert-info alert-block fade in " style="${empty message ? 'display: none;' : ''}">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        ${message}
    </div>

    <!-- Setup page variable -->
    <c:url var="lastUrl" value="/pages/${page.totalPages == 0 ? 1 : page.totalPages}"/>
    <c:url var="prevUrl" value="/pages/${page.number }"/>
    <c:url var="nextUrl" value="/pages/${page.number + 2}"/> <!--Add two due to page.number start with 0 not 1. -->
    <c:set var="posts" scope="page" value="${page.content}"/>
    <c:set var="posts" scope="page" value="${page.content}"/>

    <!-- Print all posts from page -->
    <c:forEach var="post" items="${posts}">
        <div class="post-preview">
            <a href="<c:url value='/post/${post.idPost}/${post.url}'/>">
                <h2 class="post-title">
                        ${post.title}
                </h2>
                <c:if test="${not empty post.tags}">
                    <span class="tags" style="margin-left: 10px; font-size: 15px;">
                        <i class="fa fa-tags" aria-hidden="true"></i>

                        <c:forEach var="tag" items="${post.tags}">
                            <span class="label label-default">${tag}</span>
                        </c:forEach>
                    </span>
                </c:if>
                <h3 class="post-subtitle">
                        ${post.content}
                </h3>
            </a>
            <p class="post-meta">Posted on <fmt:formatDate pattern="dd MMMM yyyy" value="${post.postDate}"/>
                by ${post.userFullName}</p>
        </div>
        <hr>
    </c:forEach>


    <!-- Pager -->
    <ul class="pager">
        <li class="next" style="display: ${page.totalPages ge page.number+2 ? '' : 'none'}">
            <a href="${lastUrl}">Latest Post<i class="fa fa-angle-double-right " aria-hidden="true"></i>
            </a>
            <a href="${nextUrl}">Older Posts <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </a>
        </li>
        <li class="previous" style="display: ${page.number gt 0 ? '' : 'none'}">
            <a href="${prevUrl}"><i class="fa fa-chevron-left" aria-hidden="true"></i>
                Newer Posts
            </a>
        </li>
    </ul>
</div>

<tags:sidebar/>

