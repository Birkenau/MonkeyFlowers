<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Area utente</title>
    <link rel="shortcut icon" href="images/logo.jpg" />
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bottone.css">

</head>
<body>



<%@ include file="navbar.jsp"%>

<center><h2>Benvenuto all'utente: ${utenteLoggato.getName()} ${utenteLoggato.getSurname()}</h2> </center>
<br> <br> <br> <br>
<center> <img src="images/funz.png"> </center>


<br> <br> <br> <br> <br><br> <br>
<center>
    <div style = "float:left; margin-right:12em;">
        <form action="VisualizzaOrdiniCliente">
            <button type="submit" class="button">I tuoi ordini</button>
        </form>
    </div>


    <div style = "float:left; margin-right:12em;">
        <form action="ModificaProfilo.jsp">
            <button type="submit" class="button">Il tuo profilo</button>
        </form>
    </div>

    <div style = "float:left; margin-right:12em;">
        <form action="VisualizzaRecensioni">
            <button type="submit" class="button">Le tue recensioni...</button>
        </form>
    </div>

    <div style = "float:left; margin-right:12em;">
        <form action="DisconnessioneUtente" method="post">
            <input class="button" type="submit"  value="Disconnetti">
        </form>

    </div>
</center>
<br> <br> <br> <br> <br>
<%@ include file="footbar.jsp"%>
</body>

</html>
