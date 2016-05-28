<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<security:authentication property="principal.user.idUser" var="loggedUserId"/>

<div class="row">
    <div class="col-xs-12">

        <h1>Manage Posts</h1>

        <div class="table-responsive">
            <table id="data-table" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Post Date</th>
                    <th>Title</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${posts}">

                    <c:choose>
                        <c:when test="${post.isDeleted eq false }">
                            <c:set var="btnStyle" scope="session" value="btn-danger"/>
                            <c:set var="btnName" scope="session" value="Delete"/>
                            <c:set var="btnUrlPrefix" scope="session" value="delete"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="btnStyle" scope="session" value="btn-success"/>
                            <c:set var="btnName" scope="session" value="Restore"/>
                            <c:set var="btnUrlPrefix" scope="session" value="restore"/>
                        </c:otherwise>
                    </c:choose>
                    <tr>

                        <td><fmt:formatDate type="both" value="${post.postDate}"/></td>
                        <td>${post.title}"</td>

                        <td>
                            <spring:url value="/post/${btnUrlPrefix}/${post.idPost}" var="actionPostURL"/>
                            <form role="form" action="${postURL}" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn btn-block btn-xs ${btnStyle}" type="submit">
                                        ${btnName}
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
