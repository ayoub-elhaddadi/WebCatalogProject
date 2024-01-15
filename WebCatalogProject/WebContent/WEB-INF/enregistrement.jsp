<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enregistrement</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
<link rel="stylesheet" type="text/css" href="styles/register.css">
</head>
<body>

<header>
    <img src="images/header2.png" alt="" />
    <img class="eilco" src="images/EILCO.png" alt="" />
</header>


<div>
	 <form id="register-form" action="valider-commande" method="post">
  	<h3 id="Heading">Inscription</h3>
      
      <label>Nom :</label>
      <div class="row name">
      	<input type="text" placeholder="Nom" name="nom" required>
      	<input type="text" placeholder="Prénom" name="prenom" required>
      </div>
      
      <label>Email :</label>
      <div class="row">
        	<div class="icon">
        		<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="100%"><path d="M48 64C21.5 64 0 85.5 0 112c0 15.1 7.1 29.3 19.2 38.4L236.8 313.6c11.4 8.5 27 8.5 38.4 0L492.8 150.4c12.1-9.1 19.2-23.3 19.2-38.4c0-26.5-21.5-48-48-48H48zM0 176V384c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V176L294.4 339.2c-22.8 17.1-54 17.1-76.8 0L0 176z"/></svg>
        	</div>
        	<input type="email" placeholder="Email" name="email" required>
      </div>
      
      <label>Mot de passe :</label>
      <div class="row">
      	<div class="icon">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" width="30px">
  				<path d="M336 352c97.2 0 176-78.8 176-176S433.2 0 336 0S160 78.8 160 176c0 18.7 2.9 36.8 8.3 53.7L7 391c-4.5 4.5-7 10.6-7 17v80c0 13.3 10.7 24 24 24h80c13.3 0 24-10.7 24-24V448h40c13.3 0 24-10.7 24-24V384h40c6.4 0 12.5-2.5 17-7l33.3-33.3c16.9 5.4 35 8.3 53.7 8.3zM376 96a40 40 0 1 1 0 80 40 40 0 1 1 0-80z"/>
			</svg>
      	</div>
      	<input type="password" placeholder="Mot de passe"  name="mtp" required> 
      </div>
      
      <label>Adresse :</label>
      <div class="row">
          <div class="icon">
			<svg xmlns="http://www.w3.org/2000/svg" width="30px" viewBox="0 0 50.000000 50.000000" preserveAspectRatio="xMidYMid meet">
			<g transform="translate(0.000000,50.000000) scale(0.100000,-0.100000)" stroke="none">
			<path d="M193 466 c-66 -30 -88 -108 -54 -194 23 -59 98 -182 111 -182 12 0 88 123 110 180 24 60 25 89 6 135 -26 61 -108 90 -173 61z m113 -25 c45 -27 61 -72 45 -130 -12 -46 -89 -191 -101 -191 -12 0 -89 145 -101 191 -16 58 0 103 45 130 39 24 73 24 112 0z"/>
			<path d="M216 384 c-31 -30 -9 -84 34 -84 24 0 50 26 50 50 0 24 -26 50 -50 50 -10 0 -26 -7 -34 -16z m59 -34 c0 -18 -6 -26 -23 -28 -13 -2 -25 3 -28 12 -10 26 4 48 28 44 17 -2 23 -10 23 -28z"/>
			<path d="M46 106 c-14 -41 -26 -77 -26 -80 0 -3 104 -6 230 -6 127 0 230 3 230 6 0 3 -12 39 -26 80 l-27 74 -38 0 c-21 0 -41 -4 -44 -10 -4 -6 8 -10 30 -10 31 0 38 -4 50 -33 7 -18 17 -45 20 -60 l7 -27 -202 0 -202 0 7 27 c3 15 13 42 20 60 12 29 19 33 50 33 22 0 34 4 30 10 -3 6 -23 10 -44 10 l-38 0 -27 -74z"/></g>
			</svg>
          </div>
          <input type="text" placeholder="Adresse" name="adresse" required>
	 </div>
	 
	 <label>Numéro de téléphone :</label>
      <div class="row">
          <div class="icon">
			<svg xmlns="http://www.w3.org/2000/svg"
			 width="30px" viewBox="0 0 100.000000 100.000000"
			 preserveAspectRatio="xMidYMid meet">
			<g transform="translate(0.000000,100.000000) scale(0.100000,-0.100000)" stroke="none">
			<path d="M185 921 c-51 -31 -125 -117 -125 -146 0 -49 42 -151 98 -235 73
			-112 270 -309 382 -382 84 -56 186 -98 235 -98 29 0 127 86 151 132 27 53 20
			63 -91 138 -57 38 -112 70 -122 70 -10 0 -40 -11 -66 -26 -26 -14 -56 -23 -66
			-19 -22 7 -231 218 -231 234 0 6 11 34 25 61 14 27 25 56 25 65 0 9 -32 63
			-70 120 -77 114 -88 121 -145 86z m115 -111 c33 -49 60 -93 60 -98 0 -5 -14
			-34 -31 -66 -30 -55 -30 -57 -13 -84 22 -35 211 -224 246 -246 27 -17 29 -17
			84 13 32 17 61 31 66 31 14 0 188 -119 188 -129 0 -14 -71 -99 -97 -116 -73
			-48 -261 62 -463 272 -158 163 -254 325 -236 397 6 23 107 116 127 116 5 0 36
			-40 69 -90z"/>
			</g>
			</svg>
          </div>
          <input type="text" placeholder="Numéro de téléphone" name="phone" required>
	 </div>

      <button type="submit">s'inscrire</button>
	</form>
	<jsp:include page="../views/Footer.jsp"></jsp:include>

