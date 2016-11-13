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

                        <div class="col-sm-12">
                            <div class="row"><!--Contenue ads-->

                                <div class="col-md-2">
                                </div>
                                <div class="col-md-8">
                                    <div class="h3">Mon profile</div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form>
                                                <div class="form-group">
                                                    <label for="nom">Nom</label>
                                                    <input type="text" class="form-control" id="nom">
                                                </div>
                                                <div class="form-group">
                                                    <label for="prenom">Prenom</label>
                                                    <input type="text" class="form-control" id="prenom">
                                                </div>
                                                <div class="form-group">
                                                    <label for="couriel">Couriel</label>
                                                    <input type="text" class="form-control" id="couriel">
                                                </div>
                                                <div class="form-group">
                                                    <label for="zipcode">Code postale</label>
                                                    <input type="text" class="form-control" id="zipcode">
                                                </div>
                                                <div class="form-group">
                                                    <label for="tel">Téléphone</label>
                                                    <input type="text" class="form-control" id="tel">
                                                </div>
                                                <div class="form-group">
                                                    <label>Photo</label>
                                                    <button type="submit" class="btn btn-default">Choisissez une photo</button>
                                                </div>
                                                <div class="form-group">
                                                    <label for="login">Nom utilisateur</label>
                                                    <input type="text" class="form-control" id="login">
                                                </div>  
                                                <div class="form-group">
                                                    <label for="pwd">Mot de passe</label>
                                                    <input type="text" class="form-control" id="pwd">
                                                </div>
                                                <div class="form-group">
                                                    <label for="reppwd">Confirmer mot de passe</label>
                                                    <input type="text" class="form-control" id="reppwd">
                                                </div>
                                                <button type="submit" class="btn btn-default">
                                                    <fmt:message key="message.sauvegarder"/>
                                                </button>
                                            </form>
                                        </div>

                                    </div>

                                </div>
                                <div class="col-md-2">
                                </div>
                            </div>
                        </div>
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