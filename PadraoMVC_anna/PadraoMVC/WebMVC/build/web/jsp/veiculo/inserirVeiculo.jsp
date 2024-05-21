<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - VEICULO</title>
    <body>
       <div class="container"/>
        <h1>INSERIR - VEICULO</h1>
        <form name="inserirVeiculo" action="validaInserirVeiculo.jsp" method="post">
            Modelo:  <input type="text" name="modelo" value=""> <br>
            Cor: <input type="text" name="cor" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
