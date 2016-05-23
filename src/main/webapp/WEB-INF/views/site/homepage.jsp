<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:forEach var="post" items="${posts}">
    <div class="post-preview">
        <a href="post.html">
            <h2 class="post-title">
                    ${post.title}
            </h2>
            <h3 class="post-subtitle">
                    ${post.content}
            </h3>
        </a>
        <p class="post-meta">Posted by <a href="#">${post.user.firstName}</a> at ${post.postDate}</p>
    </div>
    <hr>
</c:forEach>


<!-- Pager -->
<ul class="pager">
    <li class="next">
        <a href="#">Older Posts &rarr;</a>
    </li>
</ul>
