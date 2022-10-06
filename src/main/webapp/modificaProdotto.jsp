<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="css/regcss.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
<% if(((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==true){ %>
<div class="container">
    <div class="title">Modifica Prodotto Admin</div>
    <div class="content">
        <form action="OperazioniProdotto" method="post">
            <div class="user-details">

                <input type="hidden" name="id_prodotto" value=${ProdottoMod.getId_prodotto()}>

                <div class="input-box">
                    <span class="details">Nome</span>
                    <input type="text" name="nome_prodotto" value=${ProdottoMod.getNome_prodotto()} required>
                </div>

                <div class="input-box">
                    <span class="details">Prezzo</span>
                    <input type="text" name="prezzo" value=${ProdottoMod.getPrezzo()} required>
                </div>

                <div class="input-box">
                    <span class="details">Immagine</span>
                    <input type="text" name="img" value=${ProdottoMod.getImg()} required>
                </div>



                <div class="input-box">
                    <span class="details">Descrizione</span>
                    <input type="text" name="descrizione" value=${ProdottoMod.getDescrizione()} required>
                </div>

                <div class="input-box">
                    <span class="details">Tipo</span>
                    <input type="text" name="tipo" value=${ProdottoMod.getTipo()} required>
                </div>



                <div class="input-box">
                    <span class="details">Quantita</span>
                    <input type="number" name="quantita" value=${ProdottoMod.getQuantita()} required>
                </div>



                <input type="hidden" name="azione" value="modifica4">
                <div class="button">
                    <input type="submit" value="Modifica">
                </div>

                <form action="VisualizzaProdotti">
                    <button type="submit" class="button">Torna indietro</button>
                </form>
            </div>
        </form>
    </div>
</div>

</body>
<%  }else{   response.sendRedirect("/index.jsp");       }%>
</html>

