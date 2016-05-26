<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authentication property="principal.user.idUser" var="loggedUserId"/>

<div class="row">
    <div class="col-xs-12">

        <h1>Manage clients</h1>

        <div class="table-responsive">
            <table id="data-table" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${users}">

                    <c:choose>
                        <c:when test="${post.activeUrlPattern eq true }">
                            <c:set var="btnStyle" scope="session" value="btn-danger"/>
                            <c:set var="btnName" scope="session" value="Deactivate"/>
                            <c:set var="btnUrlPrefix" scope="session" value="deactivate"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="btnStyle" scope="session" value="btn-success"/>
                            <c:set var="btnName" scope="session" value="Activate"/>
                            <c:set var="btnUrlPrefix" scope="session" value="activate"/>
                        </c:otherwise>
                    </c:choose>
                    <tr>
                        <td><c:out value="${post.firstName}"/></td>
                        <td><c:out value="${post.lastName}"/></td>
                        <td><c:out value="${post.eMail}"/></td>

                        <td>
                            <form role="form" action="/user/${btnUrlPrefix}/${post.idUser}" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn btn-block btn-xs ${btnStyle}" type="submit"
                                ${post.idUser eq loggedUserId ? "data-toggle='tooltip' title='Cannot modify your self' data-placement='bottom' disabled='true'" : ''}>
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
