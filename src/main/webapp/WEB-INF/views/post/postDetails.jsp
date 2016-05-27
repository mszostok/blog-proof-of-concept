<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Post Content -->

<div class="col-lg-6 col-lg-offset-3 col-md-10 col-md-offset-1">
    <article>
        <div class="post-heading">
            <h1>${post.title}</h1>
            <span class="meta">Posted by ${post.userFullName} at ${post.postDate}</span>
            <span class="tags" style="margin-left: 10px; font-size: 15px;">
                <i class="fa fa-tags" aria-hidden="true"></i>

                <c:forEach var="tag" items="${post.tags}">
                    <span class="label label-default">${tag}</span>
                </c:forEach>
            </span>
        </div>
        <p>
            ${post.content}
        </p>
    </article>
</div>

<hr>
