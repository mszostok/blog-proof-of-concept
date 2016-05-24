<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Post Content -->

    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <article>
        <div class="post-heading">
            <h1>${post.title}</h1>
            <span class="meta">Posted by ${post.userFullName} at ${post.postDate}</span>
        </div>

        <div class="tags">
            Tags
            <span class="label label-default">Lorem</span>
            <span class="label label-default">Ipsum</span>
        </div>

        ${post.content}
        </article>
    </div>

<hr>
