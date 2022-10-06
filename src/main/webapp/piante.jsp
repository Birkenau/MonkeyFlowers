<%@ page import="model.ProdottoBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ProdottoBean> prodottiLista = (List<ProdottoBean>) request.getAttribute("prodottiLista");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" href="css/style.css">



</head>
<body>





<%@ include file="navbar.jsp"%>

<h2 class="title">Le nostre piante....</h2>






<ul class="contenitore" align="center" style="list-style-type:none;"> <!-- style elimina il puntino -->
    <c:forEach var="prodotto" items="${prodottiLista}">
        <li>

            <div style = "float:left; margin-right:3em;">
                <form action="InfoProdotto">
                    <input type="hidden" name="idProd" value=${prodotto.getId_prodotto()}>

                    <input class="foto" type="image" src="images/${prodotto.getNome_prodotto()}.png" width="150" height="170">

                </form>

                <nome id="nomeProd">${prodotto.getNome_prodotto()}</nome>
                <prezzo id="prezProd">${prodotto.getPrezzo()}€</prezzo>

                <!-- aggiungi -->
                <form action="CarrelloServlet" method="post">
                    <input type="hidden" name="idProdotto" value="${prodotto.getId_prodotto()}">
                    <input type="hidden" name="azione" value="aggiungi">
                    <button class="btn">Aggiungi al carrello</button>
                </form>
            </div>

        </li>

    </c:forEach>

</ul>



<%@ include file="footbar.jsp"%>

</body>
</html>