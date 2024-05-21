<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usuarioEntrada = new Usuario(login, senha);
    ControllerUsuario usuarioController = new ControllerUsuario();
    Usuario usuarioValidado = usuarioController.validarWeb(usuarioEntrada);
    session.setAttribute("UsuarioLogado", usuarioValidado);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title> VEICULO </title>
    <body>
        <% if (usuarioValidado != null) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Veículo</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Relação Usuário-Veículo</a>        
                <% if (usuarioValidado.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuário </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
            <% } %>
            <% if (usuarioValidado.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../veiculo/inserirVeiculo.jsp"> Inserir Veículo </a></li>
                    <li><a href="../veiculo/consultarVeiculo.jsp"> Consultar Veículo </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../veiculo/consultarVeiculo.jsp"> Consultar Veículo </a></li>
                </ul>
            <% } %>
            <% if (usuarioValidado.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../ususvei/inserirRelacaoUsuarioVeiculo.jsp"> Inserir Relação Usuário-Veículo </a></li>
                    <li><a href="../ususvei/consultarRelacaoUsuarioVeiculo.jsp"> Consultar Relação Usuário-Veículo </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../ususvei/consultarRelacaoUsuarioVeiculo.jsp"> Consultar Relação Usuário-Veículo </a></li>
                </ul>
            <% } %>
        <% } else { %>
            <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>
