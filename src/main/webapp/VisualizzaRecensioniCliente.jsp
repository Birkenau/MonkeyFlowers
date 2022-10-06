<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza le tue recensioni</title>
    <link rel="stylesheet" href="css/visualizzautenticss.css">
</head>
<body>



<%@ include file="navbar.jsp"%>
<h2> Lista delle tue recensioni:</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>idrecensione</th>
            <th>prodotto</th>
            <th>utente</th>
            <th>voto</th>
            <th>testo</th>


        </tr>
        </thead>


        <c:forEach var="recensione" items="${listaRecensioni}">
            <tbody>
            <tr>
                <td>${recensione.getIdrecensione()}</td>
                <td>${recensione.getProdotto()}</td>
                <td>${recensione.getUtente()}</td>
                <td>${recensione.getVoto()}</td>
                <td>${recensione.getTesto()}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>

</html>


