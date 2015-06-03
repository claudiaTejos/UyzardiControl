<%-- 
    Document   : erroNaoAutorizado
    Created on : 03/06/2015, 13:45:22
    Author     : Joana
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
    <script>
        alert("Você não tem autorização para acessar essa página");
    </script>
    <ul class="nav nav-pills nav-justified">
        <li><a id="voltar" href="telaPrincipal.jsp">Voltar</a></li>
    </ul>
</body>
</html>
