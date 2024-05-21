<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>
<%@page import="padraomvc.model.bean.UsuarioVeiculo"%>
<%@page import="padraomvc.controller.ControllerUsuarioVeiculo"%>

<%
    // Obtendo a lista de usuários e veículos
    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Object> listaUsuarios = usuCont.listar(usuEnt);
    
    ControllerVeiculo veiculoCont = new ControllerVeiculo();
    Veiculo veiculoEnt = new Veiculo("");
    List<Object> listaVeiculos = veiculoCont.listar(veiculoEnt);
%>

<html>
<%@include file="../../inc/materalizeWeb.inc" %>
    <title>Inserir Relação Usuário Veículo</title>
    <body>
        <div class="container"/>
            <h1>Inserir Relação Usuário Veículo</h1>
            <form name="inserirRelacaoUsuarioVeiculo" action="validaRelacaoUsuarioVeiculo.jsp" method="POST">
                <table>
                    <tr>
                        <td>Usuário:</td>
                        <td>
                            <select name="ID_USUARIO" class="browser-default">
                                <% for (Object usuario : listaUsuarios) {
                                    Usuario usu = (Usuario) usuario;
                                %>
                                    <option value="<%=usu.getId()%>"><%=usu.getLogin()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Veículo:</td>
                        <td>
                            <select name="ID_VEICULO" class="browser-default">
                                <% for (Object veiculo : listaVeiculos) {
                                    Veiculo vei = (Veiculo) veiculo;
                                %>
                                    <option value="<%=vei.getId()%>"><%=vei.getModelo()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
