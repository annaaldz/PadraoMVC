<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String modelo = request.getParameter("MODELO");
    String cor = request.getParameter("COR");
    Veiculo vei = new Veiculo(id, modelo, cor);
    ControllerVeiculo veicont = new ControllerVeiculo();
    veicont.alterar(vei);
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAGINA DE CONSULTA DE VEICULOS
    String url = "validaConsultarVeiculo.jsp?MODELO=" + pbusca;
    response.sendRedirect(url);
%>
