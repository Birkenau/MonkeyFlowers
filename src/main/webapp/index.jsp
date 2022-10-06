<%@ page import="model.UtenteBean" %>
<!DOCTYPE html>

<html>
<head>
    <link rel="shortcut icon" href="images/logo.jpg" />
    <title>HomePage</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

<%@ include file="navbar.jsp"%>


        <div class="row">
            <div class="col-2">
                <h1>Il fiore che sboccia nelle avversit&agrave; &egrave; <br> il pi&ugrave; raro e il pi&ugrave; bello di tutti. </h1>
                <br> <p>
                I fiori sono sicuramente uno dei beni pi&ugrave; preziosi che ci sono stati concessi dalla natura.
                <br> Quando ammiriamo un prato fiorito o entriamo in una casa piena di vasi, percepiamo un immediato senso di benessere.
            </p>
                <a href="index.jsp" class="btn">Esplora adesso &#8594;</a>
            </div>
            <div class="col-2">
                <img src="images/fiori1.png">
            </div>
        </div>
    </div>
</div>


<!--------I prodotti piÃ¹ amati-------->

<div class="small-container">
    <h2 class="title">I prodotti pi&ugrave; amati</h2>
    <div class="row">

        <div class="col-4">
            <img src="images/bouquet_armonia_floreale.png">
            <h4> Bouquet "Armonia Floreale"</h4>
            <p>39,99&euro;</p>
        </div>
        <div class="col-4">
            <img src="images/sogni_della_toscana.png">
            <h4> I sogni della Toscania</h4>
            <p>49,99&euro;</p>
        </div>
        <div class="col-4">
            <img src="images/il_miosole_luna_e_stelle.png">
            <h4> Il mio Sole,Luna e Stelle</h4>
            <p>44,99&euro;</p>
        </div>
        <div class="col-4">
            <img src="images/espressione_di_amore.png">
            <h4> Espressione di amore</h4>
            <p>44,99&euro;</p>
        </div>
    </div>
</div>

<!-------- offer -------->
<div class="offer">
    <div class="small-container">
        <div class="row">
            <div class="col-2">
                <img src="images/consegna-f.png" class="offer-img">
            </div>
            <div class="col-2">
                <h5>CONSEGNA NAZIONALE</h5>
                <br>
                <small>
                    Con MonkeyFlowers puoi mandare i tuoi regali floreali.<br>
                    Ovunque nel territorio italiano, anche in giornata.
                </small>

            </div>
        </div>
    </div>
</div>


<%@ include file="footbar.jsp"%>

</div>
</div>


</body>
</html>
