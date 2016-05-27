<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="col-md-5 col-md-offset-1">
    <h2>What happened?</h2>
    <p class="lead">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
    <h3>Search your post by Tag</h3>
    <form:form action="/post" method="GET">
        <div class="input-group">
            <div class="input-group-addon">#</div>
            <input type="text" class="form-control" name="tag" placeholder="Search for tag...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Search</button>
                    </span>
        </div>
    </form:form>
    </p>
</div>
<div class="col-md-6">
    <h2>What can I do?</h2>
    <p class="lead">If you're a site visitor</p>
    <p>Please use your browser's back button and check that you're in the right place. If you need immediate
        assistance, please send us an email instead.</p>
    <p class="lead">If you're the site owner</p>
    <p>Please check that you're in the right place and get in touch with your website provider if you believe this
        to be an error.</p>
</div>