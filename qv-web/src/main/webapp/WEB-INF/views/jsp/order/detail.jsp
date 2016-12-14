<%@page import="com.techbeat.qv.models.Status"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
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

    <h3>Detalhes do pedido</h3>
    
    <table class="tg">
	    <tr>
	        <td><span>ID:</span></td>
	        <td>
	            <span>${order.id}</span>
	        </td>
	    </tr>
	    <tr>
	        <td><span>Nome do comprador:</span></td>
	        <td><span>${order.user.name}</span>
	    </tr>
	    <tr>
	        <td><span>Email do comprador:</span></td>
	        <td><span>${order.user.email}</span>
	    </tr>
	    <tr>
	        <td><span>Status:</span></td>
	        <td><span>${statusConverter.getName(order.status)}</span>
	    </tr>
	    
	    <tr>
	        <td><span>Valor total:</span></td>
	        <td><span><fmt:formatNumber value="${totalSum}" type="currency"/></span>
	    </tr>
    </table>
    
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Quantidade</th>
            <th width="200">Nome do produto</th>
            <th width="60">Unidade do produto</th>
            <th width="60">Valor unitario</th>
            <th width="60">Sub total</th>
        </tr>
        <c:forEach items="${order.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.id}</td>
                <td>${orderItem.quantitiy}</td>
                <td>${orderItem.product.name}</td>
                <td>${orderItem.product.unit.unitName}</td>
                <td>${orderItem.product.value}</td>
                <td><fmt:formatNumber value="${orderItem.quantitiy * orderItem.product.value}" type="currency"/></td>
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