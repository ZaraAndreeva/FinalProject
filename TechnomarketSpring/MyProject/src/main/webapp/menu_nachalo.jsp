<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<html class="no-js" lang="">
    <head>
        <title>Технoмаркет - онлайн магазин</title>
<meta name="Description" CONTENT="Техномаркет най-голямата верига за бяла, черна и офис техника в България. Купи лесно и бързо онлайн с безплатна доставка. Удължаване на гаранцията с програма Гаранция плюс.">
<meta name="google-site-verification" content="4GUfQ24-SB-8p2dO6_vCnz-rDTs7NGJm_rr2pfXBAl4" />        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="//cdn.technomarket.bg/images/favicon.ico">
                                <link rel="stylesheet" href="//cdn.technomarket.bg/css/f38a55a.css?v=1" />
                            <script type="text/javascript" src="//cdn.technomarket.bg/assets/vendor/requirejs/require.js"></script>

<script type="text/javascript">
    require.config({
        map: {
            '*': {
                'css': 'css' // or whatever the path to require-css is
            }
        },
        paths: {
            'facebook': '//connect.facebook.net/en_US/all.js#xfbml=1',
            'google': "//apis.google.com/js/platform",
            'admin': '//cdn.technomarket.bg/bundles/taumediatechnomarketcms/js/admin',
            'app': '//cdn.technomarket.bg/bundles/taumediatechnomarketcms/js/app',
            'bootstrap': '//cdn.technomarket.bg/bundles/taumediatechnomarketcms/js/bootstrap',
            'framework': '//cdn.technomarket.bg/bundles/taumediatechnomarketcms/js/framework',
            'jquery.jstree': '//cdn.technomarket.bg/assets/vendor/jstree/dist/jstree',
            'jquery.plugin': '//cdn.technomarket.bg/assets/vendor/countdown/jquery.plugin.min',
            'jquery.countdown': '//cdn.technomarket.bg/assets/vendor/countdown/jquery.countdown.min',
            'jquery.maskedinput': '//cdn.technomarket.bg/assets/vendor/jquery.maskedinput/dist/jquery.maskedinput.min',
            'jquery.jstree-css': '//cdn.technomarket.bg/assets/vendor/jstree/dist/themes/default/style',
            'jquery': '//cdn.technomarket.bg/assets/vendor/jquery/dist/jquery',
            'jquery.ui': '//cdn.technomarket.bg/assets/vendor/jquery-ui/jquery-ui.min',
            'typeahead': '//cdn.technomarket.bg/assets/vendor/jquery-typeahead/dist/jquery.typeahead.min',
            'css': '//cdn.technomarket.bg/assets/vendor/require-css/css',
            'routing': '//cdn.technomarket.bg/bundles/fosjsrouting/js/router',
            'routes': '/js/routing?callback=fos.Router.setData',
            'slick': '//cdn.technomarket.bg/assets/vendor/slick-carousel/slick/slick.min'

        },
        packages: [{
            name: 'moment',
            // This location is relative to baseUrl. Choose bower_components
            // or node_modules, depending on how moment was installed.
            location: '//cdn.technomarket.bg/assets/vendor/moment/min',
            main: 'moment.min'
        }],
        shim: {
            'jquery.jstree': ['jquery', 'css!jquery.jstree-css'],
            'routing': {
                'exports': 'Routing'
            },
            'jquery': {
                'exports': '$'
            },
            'jquery.countdown': {
                'deps': ['jquery', 'jquery.plugin']
            },
            'jquery.maskedinput': {
                'deps': ['jquery']
            },
            'slick': {
                deps: ['jquery'],
                exports: 'jQuery.fn.slick'
            },
            'routes': ['routing'],
            'admin': ['framework'],
            'framework': ['jquery'],
            'bootstrap': ['jquery'],
            'facebook' : {
                exports: 'FB'
            }
        }
    });
</script>
        <!--[if lt IE 9]>
        <script src="//cdn.technomarket.bg/assets/vendor/html5shiv/dist/html5shiv.min.js"></script>
        <link rel="stylesheet" href="//cdn.technomarket.bg/css/ie.css" />
        <script src="//cdn.technomarket.bg/assets/vendor/respond/dest/respond.min.js"></script>
        <link href="/respond.proxy.gif" id="respond-redirect" rel="respond-redirect" />
        <link href="//cdn.technomarket.bg/assets/vendor/respond/cross-domain/respond-proxy.html" id="respond-proxy" rel="respond-proxy" />
        <script src="//cdn.technomarket.bg/assets/vendor/respond/cross-domain/respond.proxy.js"></script>
        <![endif]-->
    </head>
    <body itemscope itemtype="http://schema.org/WebPage" id="top" class="">
    <div id="fb-root"></div>
    <header>
        <div class="header-top">
        <div class="container">
            <a href="#" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#extranav" aria-expanded="false" aria-controls="extranav"><span class="icon-dot"></span> <span class="icon-dot"></span> <span class="icon-dot"></span></a>
            <div itemscope itemtype="http://schema.org/Organization" id="extranav" class="navbar-collapse collapse">
            	<link itemprop="url" href="http://www.technomarket.bg">
                <ul itemprop='contactPoint' itemscope itemtype='http://schema.org/ContactPoint' class="nav navbar-nav nav-left">                	
                    <meta itemprop="contactType" content="Customer service">
                    
                </ul>
                <ul itemscope itemtype="http://schema.org/Organization" class="nav navbar-nav nav-right">
                	<link itemprop="url" href="http://www.technomarket.bg"> 
                    <li class="icon-social"><a itemprop="sameAs" href="https://www.facebook.com/technomarket/" target="_blank"><i class="icon-facebook"></i> <span class="visible-xs">Facebook</span></a></li>
                    <li class="icon-social"><a itemprop="sameAs" href="https://plus.google.com/+technomarket/" target="_blank"><i class="icon-google"></i> <span class="visible-xs">Google +</span></a></li>
                    <li class="icon-social"><a itemprop="sameAs" href="https://twitter.com/technomarketbg/" target="_blank"><i class="icon-twitter"></i> <span class="visible-xs">Twitter</span></a></li>
                    <li class="icon-social"><a itemprop="sameAs" href="https://www.youtube.com/technomarket/" target="_blank"><i class="icon-youtube"></i> <span class="visible-xs">You Tube</span></a></li>
                    <li class="icon-social"><a itemprop="sameAs" href="https://www.linkedin.com/company/technomarket/" target="_blank"><i class="icon-linkedin"></i> <span class="visible-xs">Linked In</span></a></li>                        
                </ul>
            </div>
        </div>
    </div><!-- /.header-top -->
    <div class="heading">
        <div class="container">
            <div class="row">
                <div class="logo" itemscope itemtype="http://schema.org/Organization">
                	<span itemprop="name" class="hidden">Техномаркет</span>
                    <a itemprop="url" href="http://localhost:8080/MyProject">
                        <img itemprop="logo" src="//cdn.technomarket.bg/uploads/BG/tm-logo.png" alt="Technomarket" />
                    </a>
                </div><!-- /.logo -->
                <div class="heading-collapse">
                    <div itemscope itemtype="http://schema.org/WebSite" class="search">
                    	<link itemprop="url" href="http://www.technomarket.bg"/>
                        <form itemprop="potentialAction" itemscope itemtype="http://schema.org/SearchAction" action="/search/" method="get" class="input-group">
                            <meta itemprop="target" content="http://www.technomarket.bg/search/?query={query}"/>	
                            <input itemprop="query-input" type="text" name="query" placeholder="Търси..." class="form-control">
                            <span class="search-bar"></span>
                            <span class="input-group-btn">
                                <button class="btn btn-search" type="submit"><i class="icon-search"></i></button>
                            </span>                        
                        </form><!-- /.input-group -->                        
                    </div><!-- /.search -->
                    <c:if test="${sessionScope.user == null}">
	                    <div class="user-bar">
	                                                <div class="user-account dropdown">
	                            <button class="btn btn-tm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
	                            	<i class="icon-profile"></i> <span class="hidden-xs">Вход</span>
	                            </button>
	                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
	                                <li><a href="http://localhost:8080/MyProject/user/loginPage">Вход</a></li>
	                                <li><a href="http://localhost:8080/MyProject/html/technomarket_register.html">Регистрация</a></li>
	                            </ul>
	                        </div><!-- /.user-account -->
	                                                <div class="basket">
	                            <a href="/cart/" class="btn btn-tm">
	                                <i class="icon-basket"></i> -
	                            </a>
	                        </div><!-- /.basket -->
	                    </div><!-- /.user-bar -->
                    </c:if>
                    
                    <c:if test="${sessionScope.user != null}">
                    
                    		                    
                    	<c:if test="${sessionScope.user.admin}">
                    		<div class="user-bar">
		                                                <div class="user-account dropdown">
		                            <button class="btn btn-tm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		                            	<i class="icon-profile"></i> <span class="hidden-xs"> <c:out value="Admin"/> </span>
		                            </button>
		                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		                                <li><a href="http://localhost:8080/MyProject/user/openProfile">Профил</a></li>
		                                <li><a href="">Поръчки</a></li>
		                                <li><a href="">Любими</a></li>
		                                <li><a href="http://localhost:8080/MyProject/admin/addProductPage">Добави продукт</a></li>
		                                <li><a href="http://localhost:8080/MyProject/admin/removeProductPage">Премахни продукт</a></li>
		                                <li><a href="http://localhost:8080/MyProject/admin/editProductPage">Редактирай продукт</a></li>
		                                <li><a href="http://localhost:8080/MyProject/admin/addPromotionPage">Добави промоция</a></li>
		                                <li><a href="http://localhost:8080/MyProject/user/logout">Изход</a></li>
		                            </ul>
		                        </div>
		                                                <div class="basket">
		                            <a href="/cart/" class="btn btn-tm">
		                                <i class="icon-basket"></i> -
		                            </a>
		                        </div>
		                    </div> 
                    	</c:if>
                 
                    	 
                    	<c:if test="${!sessionScope.user.admin}">
                    	 

	                   		 <div class="user-bar">
		                                                <div class="user-account dropdown">
		                            <button class="btn btn-tm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		                            	<i class="icon-profile"></i> <span class="hidden-xs"> <c:out value="${sessionScope.user.name}"/> </span>
		                            </button>
		                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		                                <li><a href="http://localhost:8080/MyProject/user/openProfile">Профил</a></li>
		                                <li><a href="">Поръчки</a></li>
		                                <li><a href="">Любими</a></li>
		                                <li><a href="http://localhost:8080/MyProject/user/logout">Изход</a></li>
		                            </ul>
		                        </div><!-- /.user-account -->
		                                                <div class="basket">
		                            <a href="/cart/" class="btn btn-tm">
		                                <i class="icon-basket"></i> -
		                            </a>
		                        </div><!-- /.basket -->
		                    </div><!-- /.user-bar -->   
	               </c:if> 
	                    </c:if>
                    
                </div><!-- /.heading-collapse -->
            </div>
        </div>
    </div><!-- /.heading -->
    <nav class="navbar">
        <a href="#" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="hidden-xs">Категории</span></a>
        <div class="container">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav nav-main">
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Телевизори и Аудио</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Телевизори</a>
                                                                                                                                                                                                                                                                        
                                                                                                                                        <ul>
                                                    <li>
                                                        <a href="/televizor" class="ui-link ui-link-all">Всички Телевизори</a>
                                                    </li>
                                                                                                            <li>
                                                            <a href="/televizor/blaupunkt" class="ui-link">BLAUPUNKT</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/lg" class="ui-link">LG</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/neo" class="ui-link">NEO</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/panasonic" class="ui-link">PANASONIC</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/philips" class="ui-link">PHILIPS</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/samsung" class="ui-link">SAMSUNG</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/sharp" class="ui-link">SHARP</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/skyworth" class="ui-link">SKYWORTH</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/sony" class="ui-link">SONY</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/strong" class="ui-link">STRONG</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/televizor/toshiba" class="ui-link">TOSHIBA</a>
                                                        </li>
                                                                                                    </ul>
                                                                                    
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ТВ аксесоари</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-tv" class="ui-link">Аксесоари за Телевизори</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/anteni" class="ui-link">Антени</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/cifrovi-tuneri" class="ui-link">Цифрови Тунери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/distancionno" class="ui-link">Дистанционни управления</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/stoiki-stena" class="ui-link">Стойки за стена</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/multimedien-pleyr" class="ui-link">Мултимедийни Плеъри</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/video-kabeli" class="ui-link">Видео кабели</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/kino" class="ui-link">Домашно кино</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/sat-priemnici" class="ui-link">Сателитни приемници</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/dvd-playeri" class="ui-link">DVD плейъри</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аудио системи</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mini-audio" class="ui-link">Мини системи</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/micro-audio" class="ui-link">Микро системи</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/reciver" class="ui-link">Ресивъри</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/tonkoloni" class="ui-link">Тонколони</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аудио аксесоари</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mikrofon" class="ui-link">Микрофони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/slushalki" class="ui-link">Слушалки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/audio-kabel" class="ui-link">Аудио кабели</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Персонално аудио</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/ipod" class="ui-link">IPod</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/ipod-aksesoari" class="ui-link">IPod Аксесоари</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mp3" class="ui-link">MP3 плейъри</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/radiokasetofon" class="ui-link">Радиокасетофони с CD</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/radiochasovnik" class="ui-link">Радиочасовници</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/diktofon" class="ui-link">Диктофони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/radio" class="ui-link">Радиоприемници</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Авто и GPS</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/car-audio" class="ui-link">CD Плейъри</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/tonkoloni-za-kola" class="ui-link">Тонколони и субуфъри</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/usilvatel" class="ui-link">Усилватели</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                                                                                        <li>
                                                                                                                                            <a href="/browse/244" class="ui-link">GPS Софтуер</a>
                                                                                                                                    </li>
                                                                                                                            <li>
                                                                                                                                            <a href="/browse/243" class="ui-link">GPS Аксесоари</a>
                                                                                                                                    </li>
                                                                                                                            <li>
                                                                                                                                            <a href="/browse/242" class="ui-link">GPS Приемници</a>
                                                                                                                                    </li>
                                                                                                                    
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Батерии и зарядни</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/feneri" class="ui-link">Фенери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/baterii" class="ui-link">Батерии</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/zarejdashti-baterii" class="ui-link">Презареждащи батерии</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/zariadni" class="ui-link">Зарядни устройства</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Компютри и Периферия</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Лаптопи</a>
                                                                                                                                                                                                                                                                        
                                                                                                                                        <ul>
                                                    <li>
                                                        <a href="/laptopi" class="ui-link ui-link-all">Всички Лаптопи</a>
                                                    </li>
                                                                                                            <li>
                                                            <a href="/laptopi/acer" class="ui-link">ACER</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/laptopi/apple" class="ui-link">APPLE</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/laptopi/asus" class="ui-link">ASUS</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/laptopi/dell" class="ui-link">DELL</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/laptopi/hp" class="ui-link">HP</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/laptopi/lenovo" class="ui-link">LENOVO</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/laptopi/toshiba" class="ui-link">TOSHIBA</a>
                                                        </li>
                                                                                                    </ul>
                                                                                    
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари за Лаптоп</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/chanti-za-laptopi" class="ui-link">Чанти за лаптопи</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/ohladitel-za-laptop" class="ui-link">Oхладители за лаптопи</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-laptop" class="ui-link">Лаптоп Аксесоари</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/komputerni-kabeli" class="ui-link">Компютърни кабели</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/computri" class="ui-link">Компютри</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/monitori" class="ui-link">Монитори</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Периферни устройства</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="has-2cols">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/adapter-za-laptop" class="ui-link">Адаптери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mishki" class="ui-link">Мишки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/razklonitel" class="ui-link">Разклонители</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/komputerni-mikrofoni" class="ui-link">PC микрофони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/komputerni-slushalki" class="ui-link">PC слушалки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igrovi-kontroleri" class="ui-link">Game контролери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/optichno-ustrojstvo" class="ui-link">Оптични устройства</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/ruteri" class="ui-link">Рутери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/web-camera" class="ui-link">Web камери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/komputerni-kolonki" class="ui-link">PC колонки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/klaviatura" class="ui-link">Клавиатури</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Принтери и скенери</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mastilenostruen-printer" class="ui-link">Мастиленоструйни принтери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/lazerni-printeri" class="ui-link">Лазерни принтери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mastilenostruen-MFP" class="ui-link">Мастиленоструйни МФП</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/lazerni-printeri-MFP" class="ui-link">Лазерни мултифункционални устройства</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/skener" class="ui-link">Скенери</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Консумативи за принтери</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/toner-mastila" class="ui-link">Консумативи Мастиленоструйни Принтери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/toner-kaseti" class="ui-link">Тонер касети за Лазерни Принтери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/hartia" class="ui-link">Копирна и Фото хартия</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">HDD &amp; USB Flash</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/flashki" class="ui-link">USB Flash</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/tvyrd-disk" class="ui-link">Хард дискове</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/vynshen-tvyrd-disk" class="ui-link">Външни HDD</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/diskove" class="ui-link">Дискове</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/proektori" class="ui-link">Проектори</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/softuer" class="ui-link">Софтуер</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/kalkulatori" class="ui-link">Калкулатори</a>
                                                                                                            </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Телефони и Таблети</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Мобилни Телефони</a>
                                                                                                                                                                                                                                                                        
                                                                                                                                        <ul>
                                                    <li>
                                                        <a href="/telefoni" class="ui-link ui-link-all">Всички Мобилни Телефони</a>
                                                    </li>
                                                                                                            <li>
                                                            <a href="/telefoni/apple" class="ui-link">APPLE</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/asus" class="ui-link">ASUS</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/cellular" class="ui-link">CELLULAR</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/htc" class="ui-link">HTC</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/huawei" class="ui-link">HUAWEI</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/lenovo" class="ui-link">LENOVO</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/lg" class="ui-link">LG</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/microsoft" class="ui-link">MICROSOFT</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/moto" class="ui-link">MOTO</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/myphone" class="ui-link">MYPHONE</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/nokia" class="ui-link">NOKIA</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/samsung" class="ui-link">SAMSUNG</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/sony" class="ui-link">SONY</a>
                                                        </li>
                                                                                                            <li>
                                                            <a href="/telefoni/yotaphone" class="ui-link">YOTAPHONE</a>
                                                        </li>
                                                                                                    </ul>
                                                                                    
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/chasovnitzi" class="ui-link">Smart часовници и гривни</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/apple-aksesoari" class="ui-link">Apple аксесоари</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари за мобилни телефони</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/protektori-za-telefoni" class="ui-link">Протектори за мобилни телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kalyfi-za-telefoni" class="ui-link">Калъфи за мобилни телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/audio-za-telefoni" class="ui-link">Аудио аксесоари за мобилни телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/doking-stancii-za-android" class="ui-link">Докинг станции за Андроид</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/zariadni-za-telefoni" class="ui-link">Зарядни за мобилни телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/drugi-aksesoari-za-telefon" class="ui-link">Други аксесоари</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/tableti" class="ui-link">Таблети</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари за Таблети</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/protektor-za-tableti" class="ui-link">Протектори за Таблети</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kalyf-za-tableti" class="ui-link">Калъфи за Таблети</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/chetec-za--knigi" class="ui-link">E-Book</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Стационарни Телефони и Факс апарати</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/standartni-telefoni" class="ui-link">Стандартни телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/bezjichni-telefoni" class="ui-link">Безжични телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-bezjichni-telefoni" class="ui-link">Аксесоари за безжични телефони</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Електроуреди</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="">

                                                                                                                       <a href="/invertorni-klimatitzi" class="ui-link">Климатици</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Уреди за вграждане</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/microvylnova-furna-za-vgrajdane" class="ui-link">Микровълнови фурни за вграждане</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/sydomialna" class="ui-link">Съдомиялни машини</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/absorbatori" class="ui-link">Абсорбатори за вграждане</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/peralnia" class="ui-link">Перални за вграждане</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/hladilnitzi-za-vgrajdane" class="ui-link">Хладилници за вграждане</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/furni" class="ui-link">Фурни за вграждане</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/plotove" class="ui-link">Плотове</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Хладилници и фризери</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/hladilnitzi" class="ui-link">Хладилници</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/side-by-side-hladilnitzi" class="ui-link">Side by Side хладилници</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/frizeri" class="ui-link">Фризери и ракли</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/hladilni-vitrini" class="ui-link">Хладилни витрини</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/sushilni" class="ui-link">Сушилни машини</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/peralni" class="ui-link">Перални машини</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/mialni" class="ui-link">Миялни машини</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/mikrovylnova" class="ui-link">Микровълнови фурни</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/pechka" class="ui-link">Готварски печки</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/boiler" class="ui-link">Бойлери</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/absorbator" class="ui-link">Абсорбатори</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-hladilnitzi" class="ui-link">Аксесоари за Хладилници</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-peralni" class="ui-link">Аксесоари за Перални машини</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/sydomialni" class="ui-link">Аксесоари за Съдомиялни машини</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/pechki" class="ui-link">Аксесоари за Готварски печки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoar-za-klimatik" class="ui-link">Аксесоари за климатици</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-absorbatori" class="ui-link">Аксесоари за Абсорбатори</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/avtomat-za-voda" class="ui-link">Автомат за вода</a>
                                                                                                            </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Малки електроуреди</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Уреди за кухнята</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="has-2cols">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kuhnenski-vezni" class="ui-link">Кухненски везни</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/friturnik" class="ui-link">Фритюрници</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/tosteri" class="ui-link">Тостери и сандвич скари</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/sokoiztiskvachka" class="ui-link">Сокоизтисквачки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kuhnenski-roboti" class="ui-link">Кухненски роботи</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/pasatori" class="ui-link">Пасатори</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/hlebopekarni" class="ui-link">Хлебопекарни</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mikseri" class="ui-link">Миксери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mesomelachki" class="ui-link">Месомелачки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/elektricheski-kani" class="ui-link">Електрически кани</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kafe-machini" class="ui-link">Кафемашини</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kafe" class="ui-link">Кафе</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/gril-barbecue" class="ui-link">Грил &amp; Барбекю</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/blenderi" class="ui-link">Блендери</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/gotvene-na-para" class="ui-link">Уреди за готвене на пара</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/multi-kuker" class="ui-link">Multi Cooker</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/kafe-melachka" class="ui-link">Кафемелачки</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Здраве и красота</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/chetki-za-zybi" class="ui-link">Ел.Четки за зъби</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/presa-za-kosa" class="ui-link">Преси и маши</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/seshoar" class="ui-link">Сешоари</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/samobrysnachka" class="ui-link">Самобръсначки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/mashinka-za-podstrigvane" class="ui-link">Машинки за подстригване</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/epilatori" class="ui-link">Епилатори</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/fotoepilatori" class="ui-link">Фотоепилатори</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/elektricheski-vezni" class="ui-link">Ел. везни</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/grija-za-vyzduha" class="ui-link">Грижа за въздуха</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/grija-za-tqlo" class="ui-link">Грижа за тялото</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Уреди за дома</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/prahosmukachki" class="ui-link">Прахосмукачки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/utia" class="ui-link">Ютии</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/otoplitelni-uredi" class="ui-link">Отоплителни уреди</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/ventilatori" class="ui-link">Вентилатори</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/shevni-machini" class="ui-link">Шевни машини</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/produkti-za-bebe" class="ui-link">Продукти за Бебе</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/led-osvetlenie" class="ui-link">Енергоспестяващи крушки</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-prahosmukachki" class="ui-link">Аксесоари за Прахосмукачки</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-grija-za-tialo" class="ui-link">Аксесоари Грижа за тялото</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-shevni-mashini" class="ui-link">Аксесоари за Шевни Машини</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-pochistvane" class="ui-link">Почистване и Аксесоари</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Фото и Видео</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Фотоапарати</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/hibridno-foto" class="ui-link">Хибридни</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/foto" class="ui-link">Фотоапарати - компактни</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/DSLR-foto" class="ui-link">DSLR Фотоапарати</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/kameri" class="ui-link">Камери</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/foto-ramki" class="ui-link">Фото рамки</a>
                                                                                                            </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/karti-pameti" class="ui-link">Карти памет</a>
                                                                                                            </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари Фото и Видео</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-za-foto" class="ui-link">Аксесоари за фотоапарти</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/slr-aksesoari" class="ui-link">Аксесоари за SLR</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/stativi" class="ui-link">Стативи</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/zariadno-za-foto" class="ui-link">Зарядни устройства</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/baterii-za-foto" class="ui-link">Батерии</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/chanti-za-foto" class="ui-link">Чанта за Фото</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="">

                                                                                                                       <a href="/binokyl" class="ui-link">Бинокли</a>
                                                                                                            </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>
        <li class=" dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Забавления</a>
        <div class="dropdown-menu">
            <div class="container">
                <div class="row">
                                            <ul>
                                                                                                                        <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Игрови конзоли</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/sony-playstation" class="ui-link">Sony Playstation</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/xbox" class="ui-link">XBOX360</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/nintendo" class="ui-link">Nintendo</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/konzoli-drugi" class="ui-link">Други</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Аксесоари</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-playstation" class="ui-link">Аксесоари за PLAYSTATION</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-xbox" class="ui-link">Аксесоари за XBOX360</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/aksesoari-nintendo" class="ui-link">Аксесоари за Nintendo</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                                                            <li class="has-children">

                                                                                                                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Игри</a>
                                                                                                                                                                                                                                                                        
                                                                                            <ul class="has-2cols">
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-pc" class="ui-link">Игри за PC</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-psp" class="ui-link">Игри за PSP</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-playstation-vita" class="ui-link">Игри за PLAYSTATION VITA</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-playstation-2" class="ui-link">Игри за PLAYSTATION 2</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-playstation-3" class="ui-link">Игри за PLAYSTATION 3</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-playstation-4" class="ui-link">Игри за PLAYSTATION 4</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-xbox" class="ui-link">Игри за XBOX360</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-nintendo-wii" class="ui-link">Игри за Nintendo Wii</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-nintendo-3ds" class="ui-link">Игри за Nintendo 3DS</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-nintendo-ds" class="ui-link">Игри за Nintendo DS</a>
                                                                                                                            </li>
                                                        
                                                                                                                                                                        <li>
                                                                                                                                    <a href="/igri-nintendo-gba" class="ui-link">Игри за  Nintendo GBA</a>
                                                                                                                            </li>
                                                        
                                                                                                    </ul>

                                                                                                                                
                                                                    </li>
                                                                                    </ul>
                                    </div>
            </div>
        </div>
            </li>

                                    </div>
            </div>
        </div>
            </li>
    </ul>
            </div>
        </div>
    </nav><!-- /.navbar -->