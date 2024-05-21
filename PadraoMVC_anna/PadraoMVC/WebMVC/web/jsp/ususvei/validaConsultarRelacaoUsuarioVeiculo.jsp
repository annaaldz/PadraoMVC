<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.model.bean.UsuarioVeiculo"%>
<%@page import="padraomvc.controller.ControllerUsuarioVeiculo"%>

<%
    String obs = request.getParameter("OBS");
    UsuarioVeiculo usuarioVeiculo = new UsuarioVeiculo(obs);
    ControllerUsuarioVeiculo controllerUsuarioVeiculo = new ControllerUsuarioVeiculo();
    List<Object> listaUsuarioVeiculo = controllerUsuarioVeiculo.listar(usuarioVeiculo);
    Usuario usuarioLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + obs + "&ID=";
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>LISTA USUÁRIOS VEÍCULO</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista de Relações</h1>
            <table class="striped responsive-table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Id Usuario</th>
                        <th>Login</th>
                        <th>Id Veiculo</th>
                        <th>Modelo Veiculo</th>
                        <th>Observacao</th>
                        <th>Excluir</th>
                        <th>Alterar</th>
                    </tr>
                </thead>
                <% if (!listaUsuarioVeiculo.isEmpty()) { %>    
                    <tbody>
                        <% for (Object item : listaUsuarioVeiculo) {
                           UsuarioVeiculo uv = (UsuarioVeiculo) item;
                        %>
                            <tr>
                                <td><%= uv.getId() %></td>
                                <td><%= uv.getIdU()%></td>
                                <td><%= uv.getLogin() %></td>
                                <td><%= uv.getIdV()%></td>
                                <td><%= uv.getVeiculo()%></td>
                                <td><%= uv.getObs()%></td>
                                <% if ("ADM".equals(usuarioLogado.getTipo())) { %>
                                    <td><a href="excluirRelacaoUsuarioVeiculo.jsp?<%= url + uv.getId() %>">Excluir</a></td>
                                    <td><a href="alterarRelacaoUsuarioVeiculo.jsp?<%= url + uv.getId() %>">Alterar</a></td>
                                <% } else { %>
                                    <td>N/A</td>
                                    <td>N/A</td>
                                <% } %>
                            </tr>
                        <% } %>
                    </tbody>
                <% } else { %>
                    <tbody>
                        <tr>
                            <td colspan="8">Nenhuma relação encontrada.</td>
                        </tr>
                    </tbody>
                <% } %>
            </table>
        </div>
    </body>
</html>
