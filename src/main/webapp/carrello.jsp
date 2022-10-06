<%@ page import="model.Carrello" %>
<%@ page import="controller.CarrelloServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="model.ProdottoBean" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%  Carrello cart = (Carrello) request.getSession().getAttribute("cart");

    if(cart == null){
        cart = new Carrello();
    }
%>

<html>
<head>
    <title>Carrello</title>
    <link rel="stylesheet" href="css/carrello.css">
</head>

<body>
<%@ include file="navbar.jsp"%>
<h1>Il tuo carrello</h1>

<table >
    <thead>
    <tr>
        <th>immagine</th>
        <th>nome</th>
        <th>prezzo</th>
        <th>quantita</th>
        <th>Elimina prodotto</th>
    </tr>
    </thead>


    <form id="ordina" action="Checkout"></form>

    <tbody>
    <c:forEach var="prodotto" items="${prodottiCarrello}">
        <tr>
            <td><img class="foto" src="images/${prodotto.getNome_prodotto()}.png"></td>
            <td><input type="hidden" id="nomeProd">${prodotto.getNome_prodotto()}</td>
            <td><input type="hidden" id="prezProd" >${prodotto.getPrezzo()}€</td>
            <td><input type="number" class="input" id="quantity_${prodotto.getId_prodotto()}" name="quantity[]" min="1" value="1"></td>

            <td>
                <!-- tasto rimuovi -->
                <form action="CarrelloServlet" method="post">
                    <input type="hidden" name="nomeProdotto" value="${prodotto.getNome_prodotto()}">
                    <input type="hidden" name="azione" value="rimuovi">
                    <button><img src="https://toppng.com/uploads/preview/red-x-red-x-11563060665ltfumg5kvi.png" width="20px"></button>
                </form>
                <!------------------->
            </td>
        </tr>
    </c:forEach>

    <% if( (UtenteBean)request.getSession().getAttribute("utenteLoggato")==null ){ %>
    <td colspan="4">
        <button form="ordina" disabled>Devi prima registrarti</button>
        <%=String.format("%,.2f",cart.getTotPrezzo()) %>
    </td>
    <td>
        <form action="CarrelloServlet" method="post">
            <input type="hidden" name="azione" value="rimuoviTutto">
            <button>Svuota Carrello</button>
        </form>
    </td>

    <%} else{ %>
    <td colspan="4">
        <button form="ordina">Effettua ordine</button>
        <%=String.format("%,.2f",cart.getTotPrezzo()) %>
    </td>
    <td>
        <form action="CarrelloServlet" method="post">
            <input type="hidden" name="azione" value="rimuoviTutto">
            <button>Svuota Carrello</button>
        </form>
    </td>

    <% } %>

    </tbody>
</table>




<%@ include file="footbar.jsp"%>

</body>
</html>
