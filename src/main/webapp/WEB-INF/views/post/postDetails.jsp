<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="en_US" scope="session"/> <!-- Fix locale due to the fact that other stuff are not translated yet-->


<div class="col-lg-6 col-lg-offset-3 col-md-10 col-md-offset-1">
    <article>
        <!-- Post Content -->
        <div class="post-heading">
            <h1>${post.title}</h1>
            <span class="meta">Posted on <fmt:formatDate pattern="dd MMMM yyyy" value="${post.postDate}"/>
                by ${post.userFullName}
            </span>
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
