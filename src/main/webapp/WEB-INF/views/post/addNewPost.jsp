<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1">
<form:form action="/post" method="POST" modelAttribute="form" charset='utf-8'>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Create Blog Post</h2>
        </div>

        <div class="panel-body">
            <fieldset class="form-group">
                <label for="title">Title *</label>
                <form:input path="title" id="title" class="form-control" rows="4"
                       placeholder="Title"/>
                <div class="has-error">
                    <form:errors path="title" cssClass="alert alert-danger" cssStyle="display: block;"/>
                </div>
            </fieldset>

            <fieldset class="form-group">
                <label for="post-edit-area">Content *</label>
                <form method="post">
                    <form:textarea path="content" id="post-edit-area"></form:textarea>
                </form>
                <div class="has-error" >
                    <form:errors path="content" cssClass="alert alert-danger" cssStyle="display: block;"/>
                </div>
            </fieldset>


            <button type="submit" class="btn btn-primary pull-right">Save & Publish</button>
        </div>
    </div>
    </form:form>
</div>










