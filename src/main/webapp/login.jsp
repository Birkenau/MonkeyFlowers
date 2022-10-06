<!DOCTYPE html>
<html lang="en">
<head>
    <title>Accesso</title>

    <link rel="stylesheet" href="css/login.css">
    <link rel="shortcut icon" href="images/flower.png" />

</head>
<body>
<div class="hero">



    <div class="img">

        <img src="images/fall_flowers.png" align="right" height="800">

    </div>





    <style>
        .form-box {
            width: 690px;
            height: 460px;
            margin: 6% auto;
            background: #fff;
            padding: 20px;
        }
    </style>
    <br><br><br><br>

    <div class="logo">

        <img src="images/logo.jpg" align="right" width="105">


        <div class="img2">
            <img src="images/img2.png" height=360 width=380>

        </div>

    </div>
    <div id="index27">

        <div class="reg">

            <a class="reg" href="registrazione.jsp">Sei nuovo? Registrati!</a>
        </div>


        <div id="index28">



            <div id="indexusername">

                <x>Ciao</x>
                effettua il login!
            </div>
        </div>

        <form action="accesso-utente-servlet" method="post" style="position:absolute;right:150px;height:250px;bottom:260px;width:340px">
        <input type="email" id="email" name="email" onkeyup="loadlook()" autofocus="" placeholder="ciao@model.prova.it" class="indexinput" />
        <div id="indexformsepare"></div>
        <input type="password" id="password" name="password" placeholder="Password" class="indexinput" />
        <div id="indexformsepare"></div>
        <br />

        <button id="indexsubmit" type="submit">
            <p><strong>Entra!</strong></p>
        </button>

        </form>

    </div>



</div>



</body>
</html>

