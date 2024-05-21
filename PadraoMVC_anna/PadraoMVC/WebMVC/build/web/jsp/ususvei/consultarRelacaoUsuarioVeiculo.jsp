<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - USUÁRIO - VEÍCULO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR USUÁRIO - VEÍCULO</h1>
       <form name="consultarUsuarioVeiculo" action="validaConsultarRelacaoUsuarioVeiculo.jsp" method="post">
           Observação: <input type="text" name="OBS" value=""> <br>
           <input type="submit" name="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
