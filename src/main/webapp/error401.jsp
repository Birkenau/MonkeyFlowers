<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*" import = "model.*"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Errore 401</title>
		<link rel="stylesheet" type="text/css" href="css/errors">
	</head>
	
<body>
<% UtenteBean utente = (UtenteBean) request.getAttribute("utente"); %>

	<div>	
	<br><br>
		<h1 class="error-code">401</h1>
		<p class="error">Non autorizzato: impossibile accedere al sito.</p>	
		<img src="https://www.stickersmurali.com/it/img/aspemoj44-jpg/folder/products-listado-merchanthover/adesivi-faccia-triste-che-piange.jpg">
			<form method="get" action="index.jsp">
		 <input type="submit" value="Home"/>

	</form>
		
	</div>
	
		

</body>
</html>