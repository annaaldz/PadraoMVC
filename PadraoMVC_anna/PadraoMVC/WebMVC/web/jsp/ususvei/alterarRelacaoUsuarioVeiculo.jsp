<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Veiculo"%>
<%@page import="padraomvc.controller.ControllerVeiculo"%>
<%@page import="padraomvc.model.bean.UsuarioVeiculo"%>
<%@page import="padraomvc.controller.ControllerUsuarioVeiculo"%>

<%
    ControllerVeiculo sisCont = new ControllerVeiculo();
    Veiculo pf = new Veiculo("");
    List<Object> listaSistema = sisCont.listar(pf);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Object> listaUsuario = usuCont.listar(usuEnt);
    
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);

    UsuarioVeiculo ussis = new UsuarioVeiculo(id);
    ControllerUsuarioVeiculo ususiscont = new ControllerUsuarioVeiculo();
    ussis = (UsuarioVeiculo) ususiscont.buscar(ussis);
    
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO </title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - PRODUTO </h1>
        <form name="alterarUsuarioSistema" action="validaAlterarRelacaoUsuarioVeiculo.jsp" method="post">
            <table> 
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                               <% for (Object usuObj : listaUsuario) {
                                    Usuario usuSaida = (Usuario) usuObj;
                               %>
                                    <% if( ussis.getIdU()== usuSaida.getId()) { %>
                                        <option selected value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                    <% } else { %>
                                        <option value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                    <% } %>

                               <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Veiculo: </td>
                        <td>
                            <select NAME ="ID_VEICULO" class="browser-default">
                               <% for (Object sisObj : listaSistema) {
                                    Veiculo sisSaida = (Veiculo) sisObj;
                               %>
                                   <% if( ussis.getIdV()== sisSaida.getId()) { %>
                                        <option selected value="<%=sisSaida.getId()%>"><%=sisSaida.getModelo()%></option>
                                   <% } else { %>
                                        <option value="<%=sisSaida.getId()%>"><%=sisSaida.getModelo()%></option>
                                   <% } %>
                               <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=ussis.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=ussis.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>