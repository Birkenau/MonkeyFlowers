<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pannello MonkeyFlowers</title>
    <link rel="shortcut icon" href="images/logo.jpg" />
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bottone.css">

</head>
<body>

<% if(((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==true){ %>

<%@ include file="navbar.jsp"%>

<center><h2>Benvenuto all'amministratore : ${utenteLoggato.getName()} ${utenteLoggato.getSurname()}</h2> </center>
<br> <br> <br> <br>
<center> <img src="images/funz.png"> </center>

<marquee> Si ricorda ai gentili amministratori che ogni azione effettuata sarà monitorata</marquee>
<br> <br> <br> <br> <br><br> <br>
<center>
<div style = "float:left; margin-right:12em;">
<form action="VisualizzaClienti">
    <button type="submit" class="button">Gestisci Clienti</button>
</form>
</div>

<div style = "float:left; margin-right:12em;">
<form action="VisualizzaProdotti">
    <button type="submit" class="button">Gestisci Prodotti</button>
</form>
</div>

    <div style = "float:left; margin-right:12em;">
<form action="VisualizzaOrdini">
    <button type="submit" class="button">Gestisci Ordini</button>
</form>
    </div>

<div style = "float:left; margin-right:12em;">
<form action="daiRuolo.jsp">
    <button type="submit" class="button">Gestisci Ruoli</button>
</form>
</div>

<div style = "float:right; margin-right:7em;">
    <form action="DisconnessioneUtente" method="post">
        <input class="button" type="submit"  value="Disconnetti">
    </form>

</div>
</center>
<br> <br> <br> <br> <br>
<%@ include file="footbar.jsp"%>
</body>

<%  }else{   response.sendRedirect("/index.jsp");       }%>
</html>
