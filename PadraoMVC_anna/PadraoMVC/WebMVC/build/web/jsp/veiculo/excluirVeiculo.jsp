<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Veiculo veiculo = new Veiculo(id);
    ControllerVeiculo veiculoController = new ControllerVeiculo();
    veiculoController.excluir(veiculo);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PÁGINA DE CONSULTA DE VEÍCULOS
    String url = "validaConsultarVeiculo.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
