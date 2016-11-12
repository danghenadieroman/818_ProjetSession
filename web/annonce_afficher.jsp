<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Placement Animeaux - Afficher annonce </title>
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
                            <div class="row"><!--Contenue-->
                                <div class="col-md-12">
                                    <div class="h3">Mes annonces</div>
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <img src="images/gallery/dogs/dog08.jpg" class="img-responsive img-thumbnail"/>
                                        </div>
                                        <div class="col-md-8">
                                            <p class="text-justify">
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ut mi congue, varius ante in, elementum sapien. In hendrerit posuere mi non iaculis. Sed vitae bibendum est, id feugiat mi. 
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-default">Creer</button>
                                    <button type="submit" class="btn btn-default">Modifier</button>
                                    <button type="submit" class="btn btn-default">Supprimer</button>
                                    <hr>

                                </div>
                            </div>


                            <div class="row"><!--Contenue-->
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="col-md-1">
                                            <div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <img src="images/gallery/cats/cat07.jpg" class="img-responsive img-thumbnail"/>
                                        </div>
                                        <div class="col-md-8">
                                            <p class="text-justify">
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ut mi congue, varius ante in, elementum sapien. In hendrerit posuere mi non iaculis. Sed vitae bibendum est, id feugiat mi. 
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-default">Creer</button>
                                    <button type="submit" class="btn btn-default">Modifier</button>
                                    <button type="submit" class="btn btn-default">Supprimer</button>
                                    <hr>
                                </div>

                            </div>


                        </div><!--fin contenue de la page-->
                    </div><!-- Fin deuxieme row: contenue droite de la page  -->
                </div><!--Fin contenue droite de la page-->
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
