<%-- 
    Document   : index
    Created on : 16/04/2015, 20:08:55
    Author     : senac2012
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
</head>
<body>
	<form class="form-signin" action="LoginServlet" method="POST" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded">
	<h2 class="form-signin-heading">Uyzardi Control</h2>
	<label for="inputEmail" class="sr-only"> Email</label>
	<input type="email" id="inputEmail"class="form-control" placeholder="Email address" required autofocus>
	<label for="inputPassword" class="sr-only">Senha</label>
	<input type="password" id="inputPassword" class="form-control" placeholder="Senha" required >
	
	
	<button class="btn btn-lg btn-primary btn-block" type="submit"> Entre</button>	
	</form>
</body>
</html>

