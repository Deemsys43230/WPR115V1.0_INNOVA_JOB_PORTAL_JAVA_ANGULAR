<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="UTF-8">
	
	<title>Innova Consulting Group</title>
	
	<meta property="og:image" content="http://182.75.114.194:8082/jobs/resources/images/jobs-1.png"/>
	<meta property="og:title" content="<c:out value="${title}"/>"/>
	<meta property="og:description" content="<c:out value="${description}"/>" />
	<meta property="og:url" content="http://182.75.114.194:8082/jobs/<c:out value="${url}"/>"/>
	<meta property="og:site_name" content="Innova Consulting Group"/>
	<meta property="og:type" content="website"/>
	<meta name="author" content="Innova Consulting Group"/>
	<meta property="fb:app_id" content="2054449691447123">
	
	<!-- Main CSS file -->
	<link rel="stylesheet" href="resources/styles/bootstrap.css" />
	<link rel="stylesheet" href="resources/styles/owl-carousel.css" />
	<link rel="stylesheet" href="resources/styles/magnific-popup.css" />
	<link rel="stylesheet" href="resources/styles/font-awesome.css" />
	<link rel="stylesheet" href="resources/styles/style.css" />
	<link rel="stylesheet" href="resources/styles/responsive.css" />

	<!-- Favicon -->
	<link rel="shortcut icon" href="resources/images/icon/favicon.png">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/styles/icon/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/styles/icon/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/styles/icon/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="resources/styles/icon/apple-touch-icon-57-precomposed.png">
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
</head>
<body ng-app="innovaApp">

	<!-- PRELOADER -->
	<div id="st-preloader">
		<div id="pre-status">
			<div class="preload-placeholder"></div>
		</div>
	</div>
	<!-- /PRELOADER -->

	
	<!-- HEADER -->
	<header id="header">
		<nav class="navbar st-navbar navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#st-navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
				    	<span class="icon-bar"></span>
				    	<span class="icon-bar"></span>
				    	<span class="icon-bar"></span>
					</button>
					<a class="logo" href="index.html"><img src="resources/images/logo.png" alt=""></a>
                    <!--<div class="slogan">Talent x Innovation</div>-->
				</div>

				<div class="collapse navbar-collapse" id="st-navbar-collapse" ng-controller="SocialMediaController">
                    <div class="follow-us" >Follow Us :
                        <a href="{{socialMediaDetails.facebookLink}}" target="_blank" class="ic ic-rounded ic-facebook"><i class="fa fa-facebook"></i></a>
                        <a href="{{socialMediaDetails.twitterLink}}" target="_blank" class="ic ic-rounded ic-twitter"><i class="fa fa-twitter"></i></a>
                        <a href="{{socialMediaDetails.googlePlusLink}}" target="_blank" class="ic ic-rounded ic-google-plus"><i class="fa fa-google-plus"></i></a>
                        <a href="{{socialMediaDetails.linkedInLink}}" target="_blank" class="ic ic-rounded ic-linkedin"><i class="fa fa-linkedin"></i></a>
                    </div>
					<ul class="nav navbar-nav navbar-right">
				    	<li class="first"><a class="{{activeClass.index}}" href="#index">Home</a></li>
				    	<li><a href="#about" class="{{activeClass.about}}">About</a></li>
				    	<li><a href="#jobs" class="{{activeClass.jobs}}">jobs</a></li>
				    	<li><a href="#solutions"class="{{activeClass.solutions}}">Solutions</a></li>
				    	<li><a href="#news-details" class="{{activeClass.news}}">News</a></li>
				    	<li><a href="#contact" class="{{activeClass.contact}}">Contact</a></li>
                        <!--<li>
                            <div class="input-group" style="width: 250px;margin-top: 7px">
                                <input type="text" style="border-radius: 0" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                            <button class="btn btn-secondary" style="border-radius: 0" type="button"><i class="fa fa-search"></i></button>
                        </span>
                            </div>
                        </li>-->
					</ul>

				</div><!-- /.navbar-collapse -->
			</div><!-- /.container -->
		</nav>
	</header>
	<!-- /HEADER -->


    <div ng-view></div>

	<!-- FOOTER -->
	<footer id="footer">
		<div class="container">
			<div class="row">
				<!-- SOCIAL ICONS -->
				<!--<div class="col-sm-6 col-sm-push-6 footer-social-icons">
					<span>Follow us:</span>
					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-google-plus"></i></a>
					<a href="#"><i class="fa fa-pinterest-p"></i></a>
				</div>-->
				<!-- /SOCIAL ICONS -->
				<div class="col-sm-12 copyright text-center">
					<p>&copy; 2016 <a href="">Innova</a>. All Rights Reserved.</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- /FOOTER -->


	<!-- Scroll-up -->
	<div class="scroll-up">
		<ul><li><a href=""><i class="fa fa-angle-up"></i></a></li></ul>
	</div>

	
	<!-- JS -->
	<script type="text/javascript" src="resources/js/jquery.min.js"></script><!-- jQuery -->
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script><!-- Bootstrap -->

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.min.js"></script>
    <script type="text/javascript" src="scripts/app.js"></script>
    <script type="text/javascript" src="scripts/services/requestHandler.js"></script>
    <script type="text/javascript" src="resources/angular/angular-route-1.4.5.js"></script>
    <script type="text/javascript" src="resources/angular/ocLazyLoad.min.js"></script>
    <script type="text/javascript" src="resources/angular/angular-cookies-1.4.5.js"></script>

	<script type="text/javascript" src="resources/js/jquery.parallax.js"></script><!-- Parallax -->
	<script type="text/javascript" src="resources/js/smoothscroll.js"></script><!-- Smooth Scroll -->
	<script type="text/javascript" src="resources/js/masonry.pkgd.min.js"></script><!-- masonry -->
	<script type="text/javascript" src="resources/js/jquery.fitvids.js"></script><!-- fitvids -->
	<script type="text/javascript" src="resources/js/owl.carousel.min.js"></script><!-- Owl-Carousel -->
	<script type="text/javascript" src="resources/js/jquery.counterup.min.js"></script><!-- CounterUp -->
	<script type="text/javascript" src="resources/js/waypoints.min.js"></script><!-- CounterUp -->
	<script type="text/javascript" src="resources/js/jquery.isotope.min.js"></script><!-- isotope -->
	<script type="text/javascript" src="resources/js/jquery.magnific-popup.min.js"></script><!-- magnific-popup -->
	<script type="text/javascript" src="resources/js/scripts.js"></script><!-- Scripts -->
	
	<!-- Directive -->
	<script type="text/javascript" src="resources/scripts/directives/fileUpload.js"></script>
    <script src="resources/angular/angular-flash/angular-flash.min.js"></script>
    <link rel="stylesheet" href="resources/angular/angular-flash/angular-flash.css">
     <!-- dirPagination -->
    <script src="resources/angular/angular-utils-pagination/dirPagination.js"></script> 
</body>
</html>