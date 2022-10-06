
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="css/regcss.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>

<div class="container">
    <div class="title">Inserisci una recensione per il seguente prodotto:</div>
    <center>
    <img src="images/${ProdottoMod.getNome_prodotto()}.png" id="ProductImg" width="150" height="230">
    <p> ${ProdottoMod.getNome_prodotto()} </p>
    </center>
    <div class="content">
        <form action="RecensioneServlet" method="post">
            <div class="user-details">

                <input type="hidden" name="prodotto" value=${ProdottoMod.getId_prodotto()}>
                <input type="hidden" name="utente" value=${utenteLoggato.getId()}>

                <div class="input-box">
                    <span class="details">Inserisci voto </span>
                    <input type="number" name="voto" value="0" min="0" max="5" required>
                </div>

                <div class="input-box">
                    <span class="details">Inserisci una breve descrizione </span>
                    <input type="text" name="testo" required>
                </div>

                <input type="hidden" name="azione" value="modifica4">
                <div class="button">
                    <input type="submit" value="Aggiungi recensione">
                </div>
            </div>
        </form>
    </div>
</div>

</body>

</html>

