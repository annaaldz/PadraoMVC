<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>

<%
    String modelo = request.getParameter("MODELO");
    String cor = request.getParameter("COR");
    
    // Verifica se os campos não estão vazios
    if (modelo != null && !modelo.isEmpty() && cor != null && !cor.isEmpty()) {
        Veiculo vei = new Veiculo(modelo, cor);
        ControllerVeiculo veicont = new ControllerVeiculo();
        veicont.inserir(vei);
    }
    
    // REDIRECIONA PARA A PÁGINA DE INSERÇÃO DE VEÍCULO
    String url = "inserirVeiculo.jsp";
    response.sendRedirect(url);
%>
