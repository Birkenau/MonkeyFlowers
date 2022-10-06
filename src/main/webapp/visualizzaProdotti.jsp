<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Prodotti</title>
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
            <th>Prezzo</th>
            <th>Immagine</th>
            <th>Descrizione</th>
            <th>Tipo</th>
            <th>Quantità</th>
            <th>
                <button><a href="aggiungiProdotto.jsp"><img src="https://img.icons8.com/material-two-tone/452/filled-plus-2-math.png" width="20px"></a></button>
            </th>
        </tr>
        </thead>


        <c:forEach var="prodotto" items="${ProdottiDatabase}">
            <tbody>
            <tr>
                <td>${prodotto.getId_prodotto()}</td>
                <td>${prodotto.getNome_prodotto()}</td>
                <td>${prodotto.getPrezzo()}</td>
                <td>${prodotto.getImg()}</td>
                <td>${prodotto.getDescrizione()}</td>
                <td>${prodotto.getTipo()}</td>
                <td>${prodotto.getQuantita()}</td>
                <td>
                    <form action="OperazioniProdotto" method="post" >
                        <input type="hidden" name="idProdotto" value="${prodotto.getId_prodotto()}">
                        <input type="hidden" name="azione" value="rimuovi">
                        <button><img src="https://toppng.com/uploads/preview/red-x-red-x-11563060665ltfumg5kvi.png" width="20px"></button>
                    </form>
                    <form action="OperazioniProdotto">
                        <input type="hidden" name="idProdotto" value="${prodotto.getId_prodotto()}">
                        <input type="hidden" name="azione" value="modifica3">
                        <button><a href="modificaProdotto.jsp"><img src="https://cdn-icons-png.flaticon.com/512/32/32355.png" width="20px"></a></button>
                    </form>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
<%@ include file="footbar.jsp"%>
</body>
<%  }else{   response.sendRedirect("/index.jsp");       }%>
</html>


