<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioVeiculo"%>
<%@page import="padraomvc.controller.ControllerUsuarioVeiculo"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idV = Integer.parseInt(request.getParameter("ID_VEICULO"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    
    UsuarioVeiculo usuVei = new UsuarioVeiculo(id, idU, idV, obs);
    ControllerUsuarioVeiculo usuVeiCont = new ControllerUsuarioVeiculo();
    usuVeiCont.alterar(usuVei);
    
    // REDIRECIONA PARA A PÁGINA DE CONSULTA
    String url = "validaConsultarRelacaoUsuarioVeiculo.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>
