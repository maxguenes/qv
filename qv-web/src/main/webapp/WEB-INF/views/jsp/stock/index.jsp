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
            <a class="navbar-brand" href="<c:url value="/" /> ">Quitanda Verde</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
    </div>
</div>

<div class="container">

    <h3>Lista de Produtos em estoque</h3>
    
    <div class="row">
         <div class="col-md-4">
             <input type="button" value="Novo produto em estoque" onclick="location.href = '<c:url value="/view/stock/new"/>';"/>
         </div>
     </div>
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Produto</th>
            <th width="60">Quantidade</th>
            <th width="60">Edit</th>
        </tr>
        <c:forEach items="${stockList}" var="stock">
            <tr>
                <td>${stock.id}</td>
                <td>${stock.product.name}</td>
                <td>${stock.quantitiy}</td>
                <td><a href="<c:url value='/view/stock/edit/${stock.id}' />">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
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