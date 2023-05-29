<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Una sola persona</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>



	<div class="container pt-5 w-50">
		<div class="card-body bg-light">
			<h2 class="text-center">Información de la Usuario</h2>
			<div class="row mt-3">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h1 class="card-text">${persona.nombre}${persona.apellido}</h1>
						</div>
					</div>
				</div>
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Numero Licencia</h5>
							<p class="card-text">00${ persona.getLicense().getNumero() }</p>
						</div>
					</div>
				</div>
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Estado</h5>
							<p class="card-text">${ persona.getLicense().getEstado() }</p>
						</div>
					</div>
				</div>
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Fecha</h5>
							<p class="card-text">${ persona.license.fechaExpiracion }</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>