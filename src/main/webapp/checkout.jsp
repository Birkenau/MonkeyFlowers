<%@ page import="model.Carrello" %>
<%@ page import="controller.CarrelloServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="model.UtenteBean" %>
<%@ page import="model.ProdottoBean" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="javax.print.attribute.standard.PresentationDirection" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%  Carrello cart = (Carrello) request.getSession().getAttribute("cart");

    if(cart.getTotPrezzo()==0){
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/carrello.jsp");
        dispatcher.forward(request, response);
    }

    UtenteBean utenteLoggato = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
%>



<!DOCTYPE html>
<html lang="en">
<script src="scriptPayment.js"></script>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/payment.css">
    <title>Pagamento</title>
</head>
<body>

<div class="container mt-5 px-5">

    <div class="mb-4">

        <h2>Payout MonkeyFlowers</h2>
        <span id="span">Quando effettui un ordine il tuo metodo di pagamento sarà salvato nel tuo profilo e verrà utilizzato automaticamente l'indirizzo salvato nel profilo</span>

    </div>

    <div class="row">
        <form  action="OperazioniOrdine" method="post" onsubmit="event.preventDefault(); validate(this)">
            <div class="col-md-8">

                <input type="hidden" name="idUtente" value=${utenteLoggato.getId()}>
                <input type="hidden" name="indirizzo" value=${utenteLoggato.getVia()}>
                <input type="hidden" name="civico" value=${utenteLoggato.getCivico()}>
                <input type="hidden" name="cap" value=${utenteLoggato.getCap()}>
                <input type="hidden" name="provincia" value=${utenteLoggato.getProvincia()}>
                <input type="hidden" name="citta" value=${utenteLoggato.getRegione()}>

                <div class="card p-3">

                    <h6 class="text-uppercase white">Dettagli del Pagamento</h6>
                    <div class="inputbox mt-3">
                        <input type="text" name="name" maxlength="40" class="form-control"
                               required="required"> <span>Nome intestatario</span>
                    </div>


                    <div class="row">

                        <div class="col-md-6">

                            <div class="inputbox mt-3 mr-2">
                                <input type="number" name="cardNumber"
                                       class="form-control" required="required"> <i
                                    class="fa fa-credit-card"></i> <span>Numero della carta</span>

                            </div>

                        </div>

                        <div class="col-md-6">

                            <div class="d-flex flex-row">


                                <div class="inputbox mt-3 mr-2">
                                    <input type="text" maxlength="5" minlength="5" name="expiry"
                                           class="form-control" required="required"> <span>Data
										di scadenza</span>
                                </div>

                                <div class="inputbox mt-3 mr-2">
                                    <input type="number" maxlength="3" minlength="3" name="cvv"
                                           class="form-control" required="required"> <span>CVV</span>
                                </div>

                            </div>

                        </div>
                    </div>

                </div>
            </div>

            <div class="col-md-4">

                <div class="card card-blue p-3 text-white mb-3">
                    <p id="errorMessage">Il nome deve contenere solo lettere</p>
                    <span>Devi pagare</span>
                    <div class="d-flex flex-row align-items-end mb-3">
                        <h1 class="mb-0 yellow"> </h1>


                        <span><%=String.format("%,.2f",cart.getTotPrezzo()) %> €</span>
                    </div>

                    <c:forEach var="prodotto" items="${prodottiCarrello}">
                        <span>${prodotto.getNome_prodotto()}</span>
                        <span>${prodotto.getPrezzo()}</span>
                        <span>-------------------</span>
                    </c:forEach>

                    <span>Costi di spezione : 5€</span>

                    <div class="mt-4 mb-4">

                        <button class="btn btn-outline-warning  px-3"
                                onclick="validate(this);">
                            Pay €
                            <%=String.format("%,.2f",cart.getTotPrezzo()+5) %></button>
                    </div>

                </div>


            </div>


        </form>

    </div>


</div>


</body>
</html>