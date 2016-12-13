<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Quitanda Verde</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>">Quitanda Verde</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
    </div>
</div>

<div class="container">

    <h3>Editar estoque</h3>

    <form id="formStock" action="<c:url value="/view/stock/save"/>" method="POST">
        <table class="tg">
            <tr>
                <td><span>ID:</span></td>
                <td>
                    <input type="hidden" name="id" value="${stock.id}"/>
                    <span>${stock.id}</span>
                </td>
            </tr>
            <tr>
                <td><span>Nome do produto:</span></td>
                <td><span>${stock.product.name}</span>
            </tr>
            <tr>
                <td><span>Estoque atual:</span></td>
                <td><span>${stock.quantitiy}</span>
            </tr> 
			<tr>
                <td><span>Colocar:</span></td>
                <td><input type="number" id="quantitiy" name="quantitiy" value="0"/>
            </tr>            
        </table>
        <div class="row">
            <div class="col-md-4">
                <input type="submit" value="Salvar" />
                <input type="button" value="Voltar" onclick="location.href = '<c:url value="/view/stock"/>';"/>
            </div>
        </div>
    </form>
    <hr>
    <footer>
        <p>Max Guenes 2016</p>
    </footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs"/>
<spring:url value="/resources/core/css/bootstrap.min.js"
            var="bootstrapJs"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>