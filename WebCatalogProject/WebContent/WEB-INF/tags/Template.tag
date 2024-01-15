<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" required="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
    <header>
    	<img src="images/header.png" alt="" />
	</header>
    <div class="content">
        <jsp:invoke fragment="content"></jsp:invoke>
    </div>
    <footer>
	    <p>Crée avec <span class="heart">&#10084;</span> Par Ayoub EL HADDADI</p>
	</footer>
</body>
</html>