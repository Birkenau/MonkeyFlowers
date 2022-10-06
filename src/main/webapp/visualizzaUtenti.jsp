<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Utenti</title>
    <link rel="stylesheet" href="css/visualizzautenticss.css">
</head>
<body>

<% if(((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==true){ %>

<%@ include file="navbar.jsp"%>

<div class="table-wrapper">
    <table class="fl-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Email</th>
        <th>Password</th>
        <th>Via</th>
        <th>N.C.</th>
        <th>CAP</th>
        <th>Città</th>
        <th>Provincia</th>
    </tr>
    </thead>


<c:forEach var="utente" items="${listaUtenti}">
        <tbody>
    <tr>
        <td>${utente.getId()}</td>
        <td>${utente.getName()}</td>
        <td>${utente.getSurname()}</td>
        <td>${utente.getEmail()}</td>
        <td>${utente.getPassword()}</td>
        <td>${utente.getVia()}</td>
        <td>${utente.getCivico()}</td>
        <td>${utente.getCap()}</td>
        <td>${utente.getRegione()}</td>
        <td>${utente.getProvincia()}</td>
        <td>
            <form action="OperazioniCliente" method="post" >
                <input type="hidden" name="idUtente" value="${utente.getId()}">
                <input type="hidden" name="azione" value="rimuovi">
                <button><img src="https://toppng.com/uploads/preview/red-x-red-x-11563060665ltfumg5kvi.png" width="20px"></button>
            </form>
            <form action="OperazioniCliente">
                <input type="hidden" name="idUtente" value="${utente.getId()}">
                <input type="hidden" name="azione" value="modifica1">
                <button><a href="modificaUtente.jsp"><img src="https://cdn-icons-png.flaticon.com/512/32/32355.png" width="20px"></a></button>
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


