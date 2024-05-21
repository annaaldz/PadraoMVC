<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>

<%
    String modelo = request.getParameter("MODELO");
    String cor = request.getParameter("COR");
    Veiculo vei = new Veiculo(modelo, cor);
    ControllerVeiculo veicont = new ControllerVeiculo();
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    List<Object> listaVeiculo = veicont.listar(vei);
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA VEICULOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Modelo">Modelo</th>
                  <th data-field="Cor">Cor</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaVeiculo.isEmpty())) { %>    
                <tbody>
                    <% for (Object veiObj : listaVeiculo) {
                        Veiculo veiSaida = (Veiculo) veiObj;
                    %>
                    <tr>
                            <td><%=veiSaida.getId()%></td>
                            <td><%=veiSaida.getModelo()%></td>
                            <td><%=veiSaida.getCor()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirUsuario.jsp?<%=veiSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarUsuario.jsp?<%=veiSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
