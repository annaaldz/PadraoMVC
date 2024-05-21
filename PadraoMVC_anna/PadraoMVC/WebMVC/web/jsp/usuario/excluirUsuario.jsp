<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id);
    ControllerUsuario usuCont = new ControllerUsuario();
    usuCont.excluir(usu);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PÁGINA DE CONSULTA DE USUÁRIO COM O LOGIN ANTERIOR
    String url = "validaConsultarUsuario.jsp?LOGIN=" + pbusca;
    response.sendRedirect(url);
%>
