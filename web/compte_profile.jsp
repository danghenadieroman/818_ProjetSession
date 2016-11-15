<%-- author: Dan-Ghenadie Roman --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Placement Animeaux - Mon profile </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="WEB-INF/jspf/bootstrap.jspf" %>
    </head>
    <body>
        <div class="container">
            <%-- ResourceBundle --%>
            <fmt:setLocale value="${sessionScope.langue}"/>
            <fmt:setBundle basename="ressources_i18n.Messages"/>
            <%--  --%>
            <!--Premier row: Les deux div principaux: gauche et droite  -->
            <div class="row">
                <div class="col-sm-3">
                    <!--Contenue de gauche de la page: logo et rechercher  -->
                    <%@include file="WEB-INF/jspf/logo.jspf" %>
                    <%@include file="WEB-INF/jspf/chercher.jspf" %>
                </div>
                <!--Contenue droite de la page-->
                <div class="col-sm-9">
                    <div class="row">
                        <!--menu de navigation-->
                        <%@include file="WEB-INF/jspf/entete.jspf" %>
                        <!--contenue de la page-->
                        <%@include file="WEB-INF/jspf/compte_profile.jspf" %>
                    </div>
                </div>
            </div><!-- Fin premier row: contenue de gauche et droite de la page  -->
            <!-- 2 row: pagination  -->
            <div class="row">
                <div class="col-sm-9 col-sm-offset-3">
                </div>
            </div>
            <!-- 3 row: Contenue de bas de la page  -->
            <%@include file="WEB-INF/jspf/bas.jspf" %>
        </div><!-- Fin Container principale -->
    </body>
</html>
