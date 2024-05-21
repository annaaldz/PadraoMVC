<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.model.bean.UsuarioVeiculo"%>
<%@page import="padraomvc.controller.ControllerUsuarioVeiculo"%>
<%
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idVeiculo = Integer.parseInt(request.getParameter("ID_VEICULO"));
    String obs = request.getParameter("OBS");
    
    UsuarioVeiculo usuarioVeiculo = new UsuarioVeiculo(idUsuario, idVeiculo, obs);
    
    ControllerUsuarioVeiculo controllerUsuarioVeiculo = new ControllerUsuarioVeiculo();
    controllerUsuarioVeiculo.inserir(usuarioVeiculo);
    
    // REDIRECIONA PARA A PÁGINA inserirRelacaoUsuarioVeiculo.jsp
    String url = "inserirRelacaoUsuarioVeiculo.jsp";
    response.sendRedirect(url);
%>
