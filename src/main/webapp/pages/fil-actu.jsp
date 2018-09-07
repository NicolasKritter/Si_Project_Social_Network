<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
	<meta charset="utf-8">
	<meta name="language" content="fr-FR">
	<title>File d'actualités</title>
	<link rel="stylesheet"  type="text/css" href="/resources/css/main.css" />
</head>
<body>
	<h1>Les actualités</h1>
	<div role="flux">
		<div class="box" id="box1">
			<p>Bonjour ${prenom} ${nom }</p>
		</div>
		<c:forEach var="listValue" items="${list}">
			<div class="box" id="box2">
			<p> ${listValue.titre}</p>
			<p>${listValue.content}</p>
		</div>
			</c:forEach>
		
	</div>
</body>