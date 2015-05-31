<%-- 
    Document   : index
    Created on : 16/04/2015, 20:08:55
    Author     : senac2012
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
</head>
<body>
    <img src="css/logoPI.png" height="160" width="200" class="imagem">
	<form class="form-signin" action="login" method="POST" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded">
	<h2 class="form-signin-heading">Uizardy Control</h2>
	<label for="inputEmail" class="sr-only"> Email</label>
	<input type="email" id="inputEmail"class="form-control" placeholder="Email address" name="inputEmail" required autofocus>
	<label for="inputPassword" class="sr-only">Senha</label>
	<input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="inputPassword" required >
        <c:if test="${not empty lblErro}">
            <script>alert("${lblErro}")</script>
	</c:if>
	<button class="btn btn-lg btn-primary btn-block" type="submit"> Entre</button>	
	</form>
</body>
</html>

