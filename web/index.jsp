<%-- author: Dan-Ghenadie Roman --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Placement animeaux </title>
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
                                <div class="col-sm-12">
                                    <div class="row">
                                        <c:forEach var="annonce" items="${catalogue}">
                                            <div class="col-sm-4">
                                                <a href="#">
                                                    <img src="${annonce.image}" class="img-responsive img-thumbnail" alt="chat"/>
                                                </a>
                                            </div>
                                            <div class="col-sm-8">
                                                <h4>${annonce.nom}<small><i> ${annonce.date}</i></small></h4>
                                                <p class="text-justify">${annonce.details}</p>
                                                <hr>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div><!--fin contenue de la page-->
                    </div><!-- Fin deuxieme row: contenue droite de la page  -->
                </div><!--Fin contenue droite de la page-->
            </div><!-- Fin premier row: contenue de gauche et droite de la page  -->

            <!-- 2 row: pagination  -->
            <div class="row">
                <div class="col-sm-9 col-sm-offset-3">
                    <div class="text-center">
                        <ul class="pagination">
                            <li><a href="#">&laquo;</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li class="active"><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">6</a></li>
                            <li><a href="#">7</a></li>
                            <li><a href="#">8</a></li>
                            <li><a href="#">9</a></li>
                            <li><a href="#">&raquo;</a></li>

                        </ul>
                    </div>
                </div>
            </div>
            <!-- 3 row: Contenue de bas de la page  -->
            <%@include file="WEB-INF/jspf/bas.jspf" %>
        </div><!-- Fin Container principale -->
    </body>
</html>
