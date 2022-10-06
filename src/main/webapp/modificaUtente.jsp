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
    <div class="title">Modifica Utente Admin</div>
    <div class="content">
        <form action="OperazioniCliente" method="post">
            <div class="user-details">

                <input type="hidden" name="id" value=${UtenteMod.getId()}>

                <div class="input-box">
                    <span class="details">Nome</span>
                    <input type="text" name="name" value=${UtenteMod.getName()} required>
                </div>

                <div class="input-box">
                    <span class="details">Cognome</span>
                    <input type="text" name="surname" value=${UtenteMod.getSurname()} required>
                </div>

                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" name="email" value=${UtenteMod.getEmail()} required>
                </div>

                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="password" name="password" value=${UtenteMod.getPassword()} required>
                </div>

                <div class="input-box">
                    <span class="details">Indirizzo</span>
                    <input type="text" name="via" value=${UtenteMod.getVia()} required>
                </div>

                <div class="input-box">
                    <span class="details">Numero Civico</span>
                    <input type="text" name="civico" value=${UtenteMod.getCivico()} required>
                </div>

                <div class="input-box">
                    <span class="details">Città</span>
                    <input type="text" name="regione" value=${UtenteMod.getRegione()} required>
                </div>

                <div class="input-box">
                    <span class="details">CAP</span>
                    <input type="number" name="cap" value=${UtenteMod.getCap()} required>
                </div>

                <div class="input-box">
                    <span class="details">Provincia</span>
                    <input type="text" name="provincia" value=${UtenteMod.getProvincia()} required>
                </div>

            </div>

            <div class="gender-details">
                <input type="radio" name="gender" id="dot-1">
                <input type="radio" name="gender" id="dot-2">
                <input type="radio" name="gender" id="dot-3">
                <span class="gender-title">Sesso</span>
                <div class="category">
                    <label for="dot-1">
                        <span class="dot one"></span>
                        <span class="gender">Maschio</span>
                    </label>
                    <label for="dot-2">
                        <span class="dot two"></span>
                        <span class="gender">Femmina</span>
                    </label>
                    <label for="dot-3">
                        <span class="dot three"></span>
                        <span class="gender">Altro</span>
                    </label>
                </div>
            </div>

            <input type="hidden" name="azione" value="modifica2">
            <div class="button">
                <input type="submit" value="Modifica">
            </div>
            <form action="VisualizzaClienti">
                <button type="submit" class="button">Torna indietro</button>
            </form>
        </form>
    </div>
</div>

</body>
<%  }else{   response.sendRedirect("/index.jsp");       }%>
</html>

