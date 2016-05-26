<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="col-md-7 col-sm-8 col-xs-12   col-md-offset-2 col-sm-offset-2 home-page">

    <br/>
    <c:forEach var="post" items="${posts}">
        <div class="post-preview">
            <a href="<c:url value='/post/${post.idPost}/${post.url}'/>">
                <h2 class="post-title">
                        ${post.title}
                </h2>
                <h3 class="post-subtitle">
                        ${post.content}
                </h3>
            </a>
            <p class="post-meta">Posted by ${post.userFullName} at ${post.postDate}</p>
        </div>
        <hr>
    </c:forEach>

</div>
<t:sidebar/>

