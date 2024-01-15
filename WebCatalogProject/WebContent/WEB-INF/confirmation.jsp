<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>

	<jsp:include page="../views/Header.jsp"></jsp:include>

    <jsp:include page="../views/SideBar.jsp"></jsp:include>

    
    <main>
    	<h3>Confirmation</h3>
    	<p>Merci pour votre confiance.</p>
    	<p>votre numéro de confirmation est : ${numeroCommande}.</p>
    </main>
	<jsp:include page="../views/Footer.jsp"></jsp:include>

