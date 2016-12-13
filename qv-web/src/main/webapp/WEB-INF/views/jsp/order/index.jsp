<%@page import="com.techbeat.qv.models.Status"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <jsp:useBean id="statusConverter" class="com.techbeat.qv.web.util.StatusConverter"/>

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

    <h3>Lista de materias</h3>
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Quantidade</th>
            <th width="200">Email comprador</th>
            <th width="60">Status</th>
            <th width="60">Ações</th>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${fn:length(order.orderItems)}</td>
                <td>${order.user.email}</td>
                <td>${statusConverter.getName(order.status)}</td>
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