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
    <div class="title">Dai ruolo Admin</div>
    <div class="content">
        <form action="OperazioniCliente" method="post">
            <div class="user-details">



                <div class="input-box">
                    <span class="details">E-Mail</span>
                    <input type="text" name="email" placeholder="Inserisci l'email" required>
                </div>




                <input type="hidden" name="azione" value="daiRuolo">
                <div class="button">
                    <input type="submit" value="Rendi amministratore">
                </div>
            </div>
        </form>
    </div>
</div>


</body>
<%  }else{   response.sendRedirect("/index.jsp");       }%>
</html>

