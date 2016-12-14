<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<div class="row">
		<div class="col-md-4">
			<h2>Estoque</h2>
			<p>
				<a class="btn btn-default" href="<c:url value="/view/stock"/>" role="button">Estoque</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Pedidos</h2>
			<p>
				<a class="btn btn-default" href="<c:url value="/view/order"/>" role="button">Pedidos</a>
			</p>
		</div>
	</div>


	<hr>
	<footer>
		<p>Techbeat 2016</p>
	</footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>