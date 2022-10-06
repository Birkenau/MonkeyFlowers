<%@ page import="model.RecensioneBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
<%
    List<RecensioneBean> recensioniLista = (List<RecensioneBean>) request.getAttribute("prodottiLista");
%>
%>
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" href="css/index.css">

</head>
<body>


<%@ include file="navbar.jsp"%>


<h1>Prova visualizzazione prodotti</h1><br><br>

<ul class="contenitore" align="center" style="list-style-type:none;"> <!-- style elimina il puntino -->

    <c:forEach var="recensione" items="${recensioniLista}">

            <form action="RecensioneServlet">

                <h1>${recensione.getIdrecensione()} </h1>
                <h1>${recensione.getProdotto()} </h1>
                <h1>${recensione.getUtente()} </h1>
                <h1>${recensione.getVoto()} </h1>
                <h1>${recensione.getTesto()} </h1>


    </c:forEach>

</ul>


<%@ include file="footbar.jsp"%>


</body>
</html>
