<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8">

  <link rel="stylesheet" href="css/regcss.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%
    UtenteBean utenteLoggato = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
  %>

</head>
<body>

<div class="container">
  <div class="title">Modifica il tuo account</div>
  <div class="content">
    <form action="OperazioniCliente" method="post">
      <div class="user-details">

        <input type="hidden" name="id" value=${utenteLoggato.getId()}>

        <div class="input-box">
          <span class="details">Nome</span>
          <input type="text" name="name" value=${utenteLoggato.getName()} required>
        </div>

        <div class="input-box">
          <span class="details">Cognome</span>
          <input type="text" name="surname" value=${utenteLoggato.getSurname()} required>
        </div>

        <div class="input-box">
          <span class="details">Email</span>
          <input type="text" name="email" value=${utenteLoggato.getEmail()} required>
        </div>

        <div class="input-box">
          <span class="details">Password</span>
          <input type="password" name="password" value=${utenteLoggato.getPassword()} required>
        </div>

        <div class="input-box">
          <span class="details">Indirizzo</span>
          <input type="text" name="via" value=${utenteLoggato.getVia()} required>
        </div>

        <div class="input-box">
          <span class="details">Numero Civico</span>
          <input type="text" name="civico" value=${utenteLoggato.getCivico()} required>
        </div>

        <div class="input-box">
          <span class="details">Città</span>
          <input type="text" name="regione" value=${utenteLoggato.getRegione()} required>
        </div>

        <div class="input-box">
          <span class="details">CAP</span>
          <input type="number" name="cap" value=${utenteLoggato.getCap()} required>
        </div>

        <div class="input-box">
          <span class="details">Provincia</span>
          <input type="text" name="provincia" value=${utenteLoggato.getProvincia()} required>
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
        <input type="submit" value="Modifica dati">
      </div>

        <form action="areaUtente.jsp">
          <button type="submit" class="button">Torna indietro</button>
        </form>


    </form>
  </div>
</div>

</body>

</html>

