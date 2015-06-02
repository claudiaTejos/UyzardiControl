<%-- 
    Document   : relatorioMatricula
    Created on : 27/05/2015, 21:08:36
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <script src="Chart.js"></script>
    <title>Uizardy Control</title>
</head>
<body>
    <form><button formaction="RelatorioMatriculaServlet" formmethod="POST">Teste</button></form>

    <canvas id="myChart" width="450" height="400"></canvas>
    <script type="text/javascript">
        var ctx = document.getElementById("myChart").getContext("2d");
        var myNewChart = new Chart(ctx)..Bar(data, options);
    </script>
    
    <table class="table table-striped" id="tabela">
        <thead>
            <tr>
                <th id="cellUnidade">Unidade</th>
                <th id="cellCurso">Curso</th>
                <th id="cellModulo">Modulo</th>
                <th id="cellTotal">Total</th>
            </tr>
	</thead>
	<tbody id="linhasTabela">
		
	<tbody>
    </table>

    <script type="text/javascript">
    var dadosUnidades=[
        <c:forEach items="${listaRelatorio}" var="relatorio" varStatus="stat">
                {"unidade":"${relatorio.nomeUnidade}",
                    "nomeCurso":"${relatorio.nomeCurso}",
                    "moduloCurso":"${relatorio.moduloCurso}",
                    "total":"${relatorio.total}"
                },
        </c:forEach>
        ];
        
    var dadosPorUnidade = [
            <c:forEach items="${dadosRelatorioPorUnidade}" var="relatorio" varStatus="stat">
                {"unidade":"${relatorio.nomeUnidade}",
                    "total":"${relatorio.total}"
                },
            </c:forEach>
    ]; 
    </script>
    <script src="js/relatorio.js"></script>
</body>
</html>