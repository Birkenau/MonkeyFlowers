<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="checkFormProfilo.js"> </script>
  <title>Pannello MonkeyFlowers</title>
  <link rel="shortcut icon" href="images/flower.png" />
  <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
  <link href="css/login.css" rel="stylesheet" type="text/css" />


</head>

<body>


<center><img src="images/logopannel.png"></center>

<div class="hero">

  <div class="img">

    <img src="images/img1.png" height=444 width=514 align="left">
  </div>

  <div class="form-box">


    <img src="images/logo.jpg" align="right">
    <br>
    <div class="title"><font size="5"> Registrazione</font></div>
    <br />

    <div class="linea">
      <hr color="pink">
    </div>

    <div class="content">

      <form action="registrazione-utente-servlet" method="post">
        <div class="user-details">

          <div class="input-box">
            <span class="details">Nome</span>
            <input type="text" name="name" placeholder="Inserisci il tuo nome" required>
          </div>

          <div class="input-box">
            <span class="details">Cognome</span>
            <input type="text" name="surname" placeholder="Inserisci il tuo cognome" required>
          </div>

          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" name="email" placeholder="Inserisci la tua email" required>
          </div>

          <div class="input-box">
            <span class="details">Password</span>
            <input type="password" name="password" placeholder="Inserisci la password" required>
          </div>

          <div class="input-box">
            <span class="input-box">Data di Nascita</span>
            <input type="date" required>
          </div>

          <div class="input-box">
            <span class="details">Indirizzo</span>
            <input type="text" name="via" placeholder="Via/Piazza" required>
          </div>

          <div class="input-box">
            <span class="details">Numero Civico</span>
            <input type="text" name="civico" placeholder="Inserisci numero civico" required>
          </div>

          <div class="input-box">
            <span class="details">Città</span>
            <input type="text" name="regione" placeholder="Inserisci la tua citta'" required>
          </div>

          <div class="input-box">
            <span class="details">CAP</span>
            <input type="number" name="cap" placeholder="00000" required>
          </div>

          <div class="input-box">
            <span class="details">Provincia</span>
            <input type="text" name="provincia" placeholder="Inserisci provincia" required>
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
              <span class="gender">Non binario</span>
            </label>
          </div>
        </div>

        <div class="button">
          <input type="submit" value="Registrati">
        </div>

      </form>
    </div>
  </div>
</div>





</body>
</html>