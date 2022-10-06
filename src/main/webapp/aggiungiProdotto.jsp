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
    <div class="title">Aggiungi prodotto</div>
    <div class="content">
        <form action="OperazioniProdotto" method="post">
            <div class="user-details">



                <div class="input-box">
                    <span class="details">Nome</span>
                    <input type="text" name="nome_prodotto" placeholder="Inserisci il nome del prodotto" required>
                </div>

                <div class="input-box">
                    <span class="details">Prezzo</span>
                    <input type="number" name="prezzo" placeholder="Inserisci il prezzo" required>
                </div>

                <div class="input-box">
                    <span class="details">Immagine</span>
                    <input type="text" name="img" placeholder="Inserisci link immagine" required>
                </div>


                <div class="input-box">
                    <span class="details">Descrizione</span>
                    <input type="text" name="descrizione" placeholder="Inserisci una descrizione" required>
                </div>


                <div class="input-box">


                    <form>

                            <span class="details">Tipo</span>
                            <select name="tipo" >

                                <option value="piante" selected="selected">piante </option>
                                <option value="fiori" selected="selected">fiori </option>
                                <option value="avvenimenti" selected="selected">avvenimenti </option>
                                <option value="vasi" selected="selected">vasi </option>
                                <option value="boquet" selected="selected">boquet </option>
                            </select>

                    </form>
                </div>


                <div class="input-box">
                    <span class="details">Quantita</span>
                    <input type="number" name="quantita" placeholder="Inserisci la quantita" required>
                </div>

                <input type="hidden" name="azione" value="aggiungiProdotto">
                <div class="button">
                    <input type="submit" value="Aggiungi al db">
                </div>
            </div>
        </form>
    </div>
</div>


</body>
<%  }else{   response.sendRedirect("/index.jsp");       }%>
</html>

