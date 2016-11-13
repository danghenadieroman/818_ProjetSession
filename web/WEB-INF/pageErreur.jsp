<%-- 
    Document   : pageErreur
    Created on : 13-Nov-2016, 12:54:04 AM
    Author     : Dan-Ghenadie Roman
--%>
<%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>
<%-- ResourceBundle --%>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ressources_i18n.Messages"/>
<%--  --%>
<html>
    <head>
        <title>Show Error Page</title>
    </head>
    <body>
        <div class="container">

            <h1>Opps...</h1>
            <table class="table table-responsive">
                <tr >
                    <td ><b>Error:</b></td>
                    <td>${pageContext.exception}</td>
                </tr>
                <tr >
                    <td><b>URI:</b></td>
                    <td>${pageContext.errorData.requestURI}</td>
                </tr>
                <tr >
                    <td><b>Status code:</b></td>
                    <td>${pageContext.errorData.statusCode}</td>
                </tr>
                <tr >
                    <td><b>Stack trace:</b></td>
                    <td>
                        <c:forEach var="trace" 
                                   items="${pageContext.exception.stackTrace}">
                            <p>${trace}</p>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </div>

    </body>
</html>
