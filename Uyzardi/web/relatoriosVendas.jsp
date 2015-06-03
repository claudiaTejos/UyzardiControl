<%-- 
    Document   : relatoriosVendas
    Created on : 02/06/2015, 22:35:30
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <script src="amcharts/amcharts.js" type="text/javascript"></script>
    <script src="amcharts/serial.js" type="text/javascript"></script>
    <title>Uizardy Control</title>
</head>
<body>
    <form><button formaction="RelatorioVendaServlet" formmethod="POST">Teste</button></form>
    
    <script>      
        var chartData = [
            <c:forEach items="${dadosRelatorioVendaPorUnidade}" var="relatorio" varStatus="stat">
                {
                    "unidade":"${relatorio.nomeUnidade}",
                    "total":"${relatorio.valorVenda}",
                    "color": "#04D215"
                },
            </c:forEach>
        ];
        
        var chart;
        AmCharts.ready(function () {
            // SERIAL CHART
            chart = new AmCharts.AmSerialChart();
            chart.dataProvider = chartData;
            chart.categoryField = "unidade";
            chart.startDuration = 1;
            chart.depth3D = 50;
            chart.angle = 30;
            chart.marginRight = -45;

            // AXES
            // category
            var categoryAxis = chart.categoryAxis;
            categoryAxis.gridAlpha = 0;
            categoryAxis.axisAlpha = 0;
            categoryAxis.gridPosition = "start";

            // value
            var valueAxis = new AmCharts.ValueAxis();
            valueAxis.axisAlpha = 0;
            valueAxis.gridAlpha = 0;
            chart.addValueAxis(valueAxis);

            // GRAPH
            var graph = new AmCharts.AmGraph();
            graph.valueField = "total";
            graph.colorField = "color";
            graph.balloonText = "<b>[[category]]: [[value]]</b>";
            graph.type = "column";
            graph.lineAlpha = 0.5;
            graph.lineColor = "#FFFFFF";
            graph.topRadius = 1;
            graph.fillAlphas = 0.9;
            chart.addGraph(graph);

            // CURSOR
            var chartCursor = new AmCharts.ChartCursor();
            chartCursor.cursorAlpha = 0;
            chartCursor.zoomable = false;
            chartCursor.categoryBalloonEnabled = false;
            chartCursor.valueLineEnabled = true;
            chartCursor.valueLineBalloonEnabled = true;
            chartCursor.valueLineAlpha = 1;
            chart.addChartCursor(chartCursor);

            chart.creditsPosition = "top-right";

            // WRITE
            chart.write("chartdiv");
        });
    </script>
    
    <h3 class="titulo">Vendas por Unidade</h3>
    <div id="chartdiv" style="width: 75%; height: 400px;"></div>
    
    <table class="table table-striped" id="tabela">
        <thead>
            <tr>
                <th id="cellUnidade">Unidade</th>
                <th id="cellIdioma">Idioma</th>
                <th id="cellProduto">Produto</th>
                <th id="cellModulo">Modulo</th>
                <th id="cellTotal">Total</th>
            </tr>
	</thead>
	<tbody id="linhasTabela">
		
	<tbody>
    </table>

    <script type="text/javascript">        
    var dados=[
            <c:forEach items="${dadosRelatorioVendas}" var="relatorio" varStatus="stat">
                    {"unidade":"${relatorio.nomeUnidade}",
                        "idiomaProduto":"${relatorio.idiomaProduto}",
                        "nomeProduto":"${relatorio.nomeProduto}",
                        "moduloProduto":"${relatorio.moduloProduto}",
                        "total":"${relatorio.valorVenda}"
                    },
            </c:forEach>
        ];
    </script>
    <script src="js/relatorioVendas.js"></script>
</body>
</html>