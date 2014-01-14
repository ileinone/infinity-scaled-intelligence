<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>

<!DOCTYPE HTML>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8895-1"/>
	<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
	<title>Infinity Scaled Intelligence</title>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
	<link rel="stylesheet" href="resources/css/jquery.ui.slider.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/normalize.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/grid.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/responsivemobilemenu.css" type="text/css"/>
	<!-- <link rel="stylesheet" href="resources/css/style.min.css" type="text/css" media="screen"> -->
	<!--[if IE]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
	<div class="menu">
		<div class="container clearfix">
			<div id="logo" class="grid_3">
                <div id="logo-container-header"><img src="resources/images/logo.png"></div>
                <div id="text-container-header"><h2>Infinity Scaled Intelligence</h2></div>
			</div>
			<div id="nav" class="grid_1 omega">
				<div class="rmm" data-menu-style="minimal" data-menu-title="">
					<ul id="navigation-ul" class="navigation">
						<li data-slide="1"> Perhe </li>
						<li data-slide="2"> Valaistus </li> 
						<li data-slide="3"> Mittaukset </li> 
	                    <li data-slide="4"> Turvallisuus </li> 
	                    <li data-slide="5"> Medialaitteet </li>
	                 </ul>
				</div>
			</div>
		</div>
	</div>

	<div class="slide" id="slide1" data-slide="1" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<h1>Perhe</h1>
				<h2>Valitse perheen aktiviteetit</h2>
	               <div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left">Kauppalista</td>
							<td id="io-points-right"><img src="resources/images/temperature.png"></td>
						</tr>
						<tr>
							<td id="io-points-left">Kalenteri</td>
							<td id="io-points-right"><img src="resources/images/temperature.png"></td>
						</tr>
						<tr>
							<td id="io-points-left">Kommunikointi</td>
							<td id="io-points-right"><img src="resources/images/temperature.png"></td>
						</tr>
					</table>	
				</div>
			</div>
		</div>
	</div>

	<div class="slide" id="slide2" data-slide="2" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				 <h1>Valaistus</h1>
				 <h1>ON-OFF Säätimet</h1>
				 <div id="iopoints">
					 <table>
						<tr>
							<td id="io-points-left"><img src="resources/images/lightning.png"> OH kattovalaisin</td>
							<td id="io-points-right">
								ON
							</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/lightning.png"> OH seinävalot</td>
							<td id="io-points-right">
								ON
							</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/lightning.png"> OH nurkkavalaisin</td>
							<td id="io-points-right">
								OFF
							</td>
						</tr>
					 </table>
				 </div>
                 <h1>Portaaton säätö</h1>
                 <div id="iopoints">
	                 <table>
						<tr>
							<td id="io-points-left"><img src="resources/images/lightning.png"> OH kattovalaisin</td>
							<td id="io-points-right">
								77%
							</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/lightning.png"> AK käytävävalaisin</td>
							<td id="io-points-right">
								67%
							</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/lightning.png"> YK käytävävalaisin</td>
							<td id="io-points-right">
								100%
							</td>
						</tr>
					</table>
				</div>
				<br />
				<br />
			</div>
		</div>
	</div>

	<div class="slide" id="slide3" data-slide="3" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<h1>Mittapisteet</h1>
				<h2>Lämpötila</h2>
				<div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Aula</td>
							<td id="io-points-right">23.4 &deg;C</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> OH</td>
							<td id="io-points-right">22.3 &deg;C</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Keittiö</td>
							<td id="io-points-right">20.4 &deg;C</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 1</td>
							<td id="io-points-right">19.4 &deg;C</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 2</td>
							<td id="io-points-right">19.5 &deg;C</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 3</td>
							<td id="io-points-right">19.4 &deg;C</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Työhuone</td>
							<td id="io-points-right">19.6 &deg;C</td>
						</tr>	
					</table>
				</div>
                <h2>Kosteusmittaukset</h2>
                <div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Aula</td>
							<td id="io-points-right">77</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Olohuone</td>
							<td id="io-points-right">75</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Keittiö</td>
							<td id="io-points-right">77</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 1</td>
							<td id="io-points-right">55</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 2</td>
							<td id="io-points-right">67</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 3</td>
							<td id="io-points-right">83</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Työhuone</td>
							<td id="io-points-right">77</td>
						</tr>
					</table>
				</div>
                 <h2>Hiilidioksidi</h2>
                   <div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Aula</td>
							<td id="io-points-right">15</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Olohuone</td>
							<td id="io-points-right">19</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Keittiö</td>
							<td id="io-points-right">15</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 1</td>
							<td id="io-points-right">23</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 2</td>
							<td id="io-points-right">22</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> MH 3</td>
							<td id="io-points-right">23</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/temperature.png"> Työhuone</td>
							<td id="io-points-right">25</td>
						</tr>
						
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="slide" id="slide4" data-slide="4" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<h1>Turvallisuus</h1>
				<h2>Liiketunnistimet</h2>
				<div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/security.png"> Etupiha</td>
							<td id="io-points-right">ON</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/security.png"> Takapiha</td>
							<td id="io-points-right">OFF</td>
						</tr>
					</table>
				</div>
				<h2>Kamerat</h2>
				<div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/wire.png"> Kuisti</td>
							<td id="io-points-right">AVAA</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/wire.png"> Terassi</td>
							<td id="io-points-right">AVAA</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="slide" id="slide5" data-slide="5" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<h1>Medialaitteet</h1>
				<h2>Media soitin</h2>
				<div id="iopoints">
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/music.png"> Olohuone</td>
							<td id="io-points-right">Play, Forward, Back, Skip</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/music.png"> Keittiö</td>
							<td id="io-points-right">Play, Forward, Back, Skip</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/music.png"> Sauna</td>
							<td id="io-points-right">Play, Forward, Back, Skip</td>
						</tr>
					</table>
					<h2>Televisio</h2>
					<table>
						<tr>
							<td id="io-points-left"><img src="resources/images/tv.png"> TV</td>
							<td id="io-points-right">Next, Prev, Set</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/tv.png"> Olohuone</td>
							<td id="io-points-right">Next, Prev, Set</td>
						</tr>
						<tr>
							<td id="io-points-left"><img src="resources/images/tv.png"> VH makuuhuone</td>
							<td id="io-points-right">Next, Prev, Set</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

<%-- 	<spring:url value="resources/scripts/domReady.js" var="domReady" /> --%>
	<script type="text/javascript" src="resources/web-resources/scripts/domReady.js"></script>
	<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="resources/js/1.10.3/jquery-ui.custom.min.js"></script>
	<script type="text/javascript" src="resources/js/1.10.3/jquery.ui.slider.js"></script>
	<script type="text/javascript" src="resources/js/jquery.stellar.min.js"></script>
	<script type="text/javascript" src="resources/js/waypoints.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/responsivemobilemenu.js"></script>
	<!-- <script type="text/javascript" src="resources/js/scripts.min.js"></script> -->
</body>
</html>
