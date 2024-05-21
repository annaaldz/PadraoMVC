<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    
    // Busca o veículo pelo ID
    Veiculo vei = new Veiculo(id);
    ControllerVeiculo veiCont = new ControllerVeiculo();
    vei = (Veiculo) veiCont.buscar(vei);
    
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
<%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - VEICULO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR VEICULO</h1>
        <form name="alterarVeiculo" action="validaAlterarVeiculo.jsp" method="post">
            Modelo: <input type="text" name="MODELO" value="<%=vei.getModelo()%>"> <br>
            Cor: <input type="text" name="COR" value="<%=vei.getCor()%>"> <br>
            <input type="hidden" name="ID" value="<%=vei.getId()%>"> <br>
            <input type="hidden" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
