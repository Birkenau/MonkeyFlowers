<%
    UtenteBean utenteLoggato = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
%>
<html>

<head>
    <title>Informazione Prodotto</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/infoprodotto.css">


</head>

<body>
<%@ include file="navbar.jsp"%>
<div class="small-container single-product">
    <div class="row">
        <div class="col-2">
            <img src="images/${prodottoPagina.getNome_prodotto()}.png" id="ProductImg" width="475" height="554">



        </div>
        <div class="col-2">
            <p>Home / ${prodottoPagina.getTipo()}</p>
            <h1>
                ${prodottoPagina.getNome_prodotto()} by MonkeyFlowers
            </h1>
            <h4>${prodottoPagina.getPrezzo()} 	&euro;</h4>
            <input type="number" name="quant" value="1" min="1">


            <form action="CarrelloServlet" method="post">
                <input type="hidden" name="idProdotto" value="${prodottoPagina.getId_prodotto()}">
                <input type="hidden" name="azione" value="aggiungi">
                <button class="btn">Aggiungi al carrello</button>
            </form>

            <h3> Dettagli del prodotto</h3>
            <br>
            <p>${prodottoPagina.getDescrizione()} </p>

        </div>
    </div>
</div>


<form action="RecensioneServlet">
    <input type="hidden" name="idProdotto" value="${prodottoPagina.getId_prodotto()}">
    <input type="hidden" name="idUtente" value=${utenteLoggato.getId()}>
    <input type="hidden" name="azione" value="modifica3">
    <button disabled><a href="Recensione.jsp"><img src="https://www.suiteforlife.it/wp-content/uploads/2020/10/Recensioni.png" width="40%"></a></button>
</form>




<%@ include file="footbar.jsp"%>
</body>
</html>