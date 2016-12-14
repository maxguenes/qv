<%@page import="com.techbeat.qv.models.Status"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <jsp:useBean id="statusConverter" class="com.techbeat.qv.web.util.StatusConverter"/>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Quitanda Verde</title>

<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<spring:url value="/resources/core/img/icon_qv.png" var="logoImg" />

</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/"/>">
				<img src="${logoImg}" alt="Quitanda verde" />
			</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
	</div>
</div>

<div class="container">

    <h3>Lista de Pedidos</h3>
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
                <td>
                	<div><a href="<c:url value='/view/order/detail/${order.id}' />">Detalhe</a></div>
	                <c:if test="${order.status == 2}">
	                	<div><a href="<c:url value='/view/order/delivering/${order.id}' />">Enviar para entrega</a></div>
	                </c:if>
	                <c:if test="${order.status == 3}">
	                	<div><a href="<c:url value='/view/order/delivered/${order.id}' />">Marcar como entregue</a></div>
	                </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <footer>
        <p>Techbeat 2016</p>
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