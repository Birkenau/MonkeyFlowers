<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

<div class="header">





    <div class="container">

        <div class="navbar">

            <img src="images/logo.jpg">

            <nav>


                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="Piante">Piante</a></li>
                    <li><a href="Fiori">Fiori</a></li>
                    <li><a href="Avvenimenti">Avvenimenti</a></li>
                    <li><a href="Vasi">Vasi</a></li>
                    <li><a href="Boquet">Boquet</a></li>
                </ul>
            </nav>


            <%
                //utente non loggato
                if( (UtenteBean)request.getSession().getAttribute("utenteLoggato")==null ){
            %>
            <a href="login.jsp" class="btn">Login</a>
            <% //admin
            }else if( (UtenteBean)request.getSession().getAttribute("utenteLoggato")!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==true) {
            %>

            <a href="areaAdmin.jsp" class="btn">Il mio account</a>
            <% //utente loggato
            }else if ( (UtenteBean)request.getSession().getAttribute("utenteLoggato")!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getRuolo()==false){
            %>
            <a href="areaUtente.jsp" class="btn">Il mio account</a>
            <% } %>


            <a href="CarrelloServlet"><img src="images/carrello.png" width="30" height="30"/></a>

        </div>
    </div>
</div>
</body>
</html>