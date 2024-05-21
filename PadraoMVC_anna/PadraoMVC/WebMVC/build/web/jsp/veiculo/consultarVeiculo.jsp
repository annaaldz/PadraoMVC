<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - VEICULO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR VEICULO</h1>
       <form name="consultarVeiculo" action="validaConsultarVeiculo.jsp" method="post">
           MODELO <input type="text" name="MODELO" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
