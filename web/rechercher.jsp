<%-- author: Dan-Ghenadie Roman --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Placement Animeaux - Recherche annonce </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="WEB-INF/jspf/bootstrap.jspf" %>
    </head>
    <body>
        <div class="container">

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
                                    <div class="h3">Recherche annonce</div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form>
                                                <div class=" form-group">
                                                    <label>Type annonce</label>
                                                    <select class="form-control">
                                                        <option>Adopter</option>
                                                        <option>Donner</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Type animal</label>
                                                    <select class="form-control">
                                                        <option>Chien</option>
                                                        <option>Chat</option>
                                                        <option>Peroqet</option>
                                                        <option>Poisson</option>
                                                        <option>Hammster</option>
                                                        <option>Serpent</option>
                                                        <option>Autre</option>
                                                    </select>
                                                </div>
                                                <div class=" form-group">
                                                    <label>Sex</label>
                                                    <select class="form-control">
                                                        <option>Masculin</option>
                                                        <option>Feminin</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Age</label>
                                                    <input type="text" class="form-control" placeholder="min"/> 
                                                    à  
                                                    <input type="text" class="form-control" placeholder="max"/>
                                                </div>
                                                <button type="submit" class="btn btn-default">Sauvgarder</button>
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

            <!-- 3 row: Contenue de bas de la page  -->
            <%@include file="WEB-INF/jspf/bas.jspf" %>
        </div><!-- Fin Container principale -->
    </body>
</html>