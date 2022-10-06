<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Ordini</title>
    <link rel="stylesheet" href="css/visualizzautenticss.css">
</head>
<body>

<% if(((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==true){ %>

<%@ include file="navbar.jsp"%>

<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>IDORDINE</th>
            <th>IDUTENTE</th>
            <th>Indirizzo</th>
            <th>Civico</th>
            <th>Cap</th>
            <th>Provincia</th>
            <th>Citta'</th>


        </tr>
        </thead>


        <c:forEach var="ordine" items="${listaOrdini}">
            <tbody>
            <tr>
                <td>${ordine.getId_ordine()}</td>
                <td>${ordine.getId_utente()}</td>
                <td>${ordine.getIndirizzo()}</td>
                <td>${ordine.getCivico()}</td>
                <td>${ordine.getCap()}</td>
                <td>${ordine.getProvincia()}</td>
                <td>${ordine.getCitta()}</td>
                <td>
                    <form action="OperazioniOrdine" method="post" >
                        <input type="hidden" name="idOrdine" value="${ordine.getId_ordine()}">
                        <input type="hidden" name="azione" value="rimuovi">
                        <button><img src="https://toppng.com/uploads/preview/red-x-red-x-11563060665ltfumg5kvi.png" width="20px"></button>
                    </form>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
<%  }else{   response.sendRedirect("/index.jsp");       }%>

</html>


