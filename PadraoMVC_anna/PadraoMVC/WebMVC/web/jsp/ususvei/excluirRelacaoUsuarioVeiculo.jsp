<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioVeiculo"%>
<%@page import="padraomvc.controller.ControllerUsuarioVeiculo"%>

<%
    // Obtendo o ID da relação usuário-veículo a ser excluída
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    
    // Criando um objeto UsuarioVeiculo com o ID fornecido
    UsuarioVeiculo usuVei = new UsuarioVeiculo(id);
    
    // Criando um controlador para gerenciar a exclusão da relação
    ControllerUsuarioVeiculo usuVeiCont = new ControllerUsuarioVeiculo();
    
    // Excluindo a relação usuário-veículo
    usuVeiCont.excluir(usuVei);
    
    // Redirecionando para a página de consulta de relações
    String pbusca = request.getParameter("PBUSCA");
    String url = "validaConsultarRelacaoUsuarioVeiculo.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>
