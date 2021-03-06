<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">

    <spring:url var="postURL" value="/post"/>
    <form:form action="${postURL}" method="POST" modelAttribute="form" charset='utf-8'>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <!-- Alert when adding post as anonymous -->
        <security:authorize access="isAnonymous()">
            <div class="alert alert-danger alert-block fade in ">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                Now you adding post as <strong>Anonymous</strong>, to take advantage of all features i.e.
                <u>add tags, upload own images</u>, please sign in or sign up.
            </div>
        </security:authorize>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h2>Create Blog Post</h2>
            </div>

            <div class="panel-body">
                <!-- Title -->
                <fieldset class="form-group">
                    <label for="title">Title *</label>
                    <form:input path="title" id="title" class="form-control" rows="4"
                                placeholder="Title"/>
                    <div class="has-error">
                        <form:errors path="title" cssClass="alert alert-danger" cssStyle="display: block;"/>
                    </div>
                </fieldset> <!-- end title -->

                <!-- Content input (Tiny MCE)-->
                <fieldset class="form-group">
                    <label for="post-edit-area">Content *</label>
                    <form method="post">
                        <form:textarea path="content" id="post-edit-area"></form:textarea>
                    </form>
                    <div class="has-error">
                        <form:errors path="content" cssClass="alert alert-danger" cssStyle="display: block;"/>
                    </div>
                </fieldset><!-- end content input -->

                <!-- Tags input & upload only for logged user -->
                <security:authorize access="isAuthenticated()">
                    <fieldset class="form-group">
                        <label class="control-label">Tags</label>
                        <div data-toggle='tooltip' title='Divide by comma' data-placement='bottom'>
                            <form:input path="tagsInput" type="text" name="tags" id="tags"
                                        class="form-control ui-widget-content ui-autocomplete-input"
                                        data-role="tagsinput"
                            />
                        </div>
                        <div class="has-error">
                            <form:errors path="tagsInput" cssClass="alert alert-danger" cssStyle="display: block;"/>
                        </div>
                    </fieldset>  <!-- end tags input -->

                    <!-- Upload file form -->
                    <form id="upload-file-form">
                        <label for="upload-file-input">Upload your images (only jpg):</label>
                        <input id="upload-file-input" type="file" name="file" accept="image/jpeg"/>
                        <br/>
                        <span id="upload-file-message"></span>
                    </form>
                </security:authorize>

                <p>* indicates required field</p>
                <button type="submit" class="btn btn-primary pull-right">Save & Publish</button>
            </div>
        </div>
    </form:form>
</div>









