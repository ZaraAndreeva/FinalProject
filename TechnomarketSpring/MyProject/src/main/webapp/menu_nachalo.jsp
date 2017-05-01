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
                            <script src="http://localhost:8080/TechnomarketSpring/js/handlebars-v4.0.5.js"></script>
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
                    <a itemprop="url" href="http://localhost:8080/TechnomarketSpring">
                        <img itemprop="logo" src="//cdn.technomarket.bg/uploads/BG/tm-logo.png" alt="Technomarket" />
                    </a>
                </div><!-- /.logo -->
                <div class="heading-collapse">
                    <div itemscope itemtype="http://schema.org/WebSite" class="search">
                    	<link itemprop="url" href="http://www.technomarket.bg"/>
                        <form itemprop="potentialAction" itemscope itemtype="http://schema.org/SearchAction" action="http://localhost:8080/TechnomarketSpring/search/search" method="GET" class="input-group">
                            <meta itemprop="target" content="http://www.technomarket.bg/search/?query={query}"/>	
                            <input itemprop="query-input" type="text" name="search" placeholder="Търси..." class="form-control">
                            <span class="search-bar"></span>
                            <span class="input-group-btn">
                                <button class="btn btn-search" type="submit"><i class="icon-search"></i></button>
                            </span>                        
                        </form><!-- /.input-group -->                        
                    </div><!-- /.search -->
                    
                    
                    <c:if test="${sessionScope.user == null}">
                    
                    <SCRIPT type="text/javascript">
						    	window.history.forward();
						    	function noBack() { window.history.forward(); }
							</SCRIPT>
							</HEAD>
							<BODY onload="noBack();"
						    onpageshow="if (event.persisted) noBack();">
						
	                    <div class="user-bar">
	                                                <div class="user-account dropdown">
	                            <button class="btn btn-tm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
	                            	<i class="icon-profile"></i> <span class="hidden-xs">Вход</span>
	                            </button>
	                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
	                                <li><a href="http://localhost:8080/TechnomarketSpring/user/loginPage">Вход</a></li>
	                                <li><a href="http://localhost:8080/TechnomarketSpring/user/registerPage">Регистрация</a></li>
	                            </ul>
	                        </div><!-- /.user-account -->
	                                                <div class="basket">
	                            <a href="http://localhost:8080/TechnomarketSpring/user/cartPage" class="btn btn-tm">
	                                <i class="icon-basket"></i>
	                            </a>
	                        </div><!-- /.basket -->
	                    </div><!-- /.user-bar -->
                    </c:if>
                    
                    <c:if test="${sessionScope.user != null}">
                    	
                    	<SCRIPT type="text/javascript">
						    window.history.forward();
						    function noBack() { window.history.forward(); }
						</SCRIPT>
						</HEAD>
						<BODY onload="noBack();"
						    onpageshow="if (event.persisted) noBack();">
                    		                    
                    	<c:if test="${sessionScope.user.admin}">
                    		<div class="user-bar">
		                                                <div class="user-account dropdown">
		                            <button class="btn btn-tm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		                            	<i class="icon-profile"></i> <span class="hidden-xs"> <c:out value="Admin"/> </span>
		                            </button>
		                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/openProfile">Профил</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/ordersPage">Поръчки</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/viewFavProd">Любими</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/upload">Добави продукт</a></li>
		                                <!-- 
		                                <li><a href="http://localhost:8080/TechnomarketSpring/admin/removeProductPage">Премахни продукт</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/admin/editProductPage">Редактирай продукт</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/admin/addPromotionPage">Добави промоция</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/admin/removePromotionPage">Премахни промоция</a></li>
		                                 -->
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/logout">Изход</a></li>
		                            </ul>
		                        </div>
		                                                <div class="basket">
		                            <a href="http://localhost:8080/TechnomarketSpring/user/cartPage" class="btn btn-tm">
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
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/openProfile">Профил</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/ordersPage">Поръчки</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/viewFavProd">Любими</a></li>
		                                <li><a href="http://localhost:8080/TechnomarketSpring/user/logout">Изход</a></li>
		                            </ul>
		                        </div><!-- /.user-account -->
		                                                <div class="basket">
		                            <a href="http://localhost:8080/TechnomarketSpring/user/cartPage" class="btn btn-tm">
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
        
		        
		        
		        
		        
		        
		        
		        
		        <!--  
		        <li class=" dropdown">
		                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Забавления</a>
			        <div class="dropdown-menu">
			            <div class="container">
			                <div class="row">
			                	<ul>
			                    	<li>
										
										
										
										
										
										
										<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Игри</a>
			                       
			                       
			                       
			                       
			                       
			                       
			                       
			                       
			                       
			                       
			                       
			                        </li>
			                   	</ul>
			                </div>
			            </div>
			        </div>
		        </li>
				-->
            
            
            
            
            
            <c:forEach items="${applicationScope['entriesForAllCategories']}" var="entry">
    			<li class=" dropdown">
		                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${entry.getKey()}</a>
			        <div class="dropdown-menu">
			            <div class="container">
			                <div class="row">
			                	<ul>
			                    	
										<!--  
											<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Игри</a>
			                       		-->
			                       		<c:forEach items="${entry.getValue()}" var="subCategory">			                       			
                                              <li class="">
                                       			 <a href="/TechnomarketSpring/showProduct/${subCategory}" class="ui-link">${subCategory}</a>
                                              </li>
										</c:forEach>
			                        
			                   	</ul>
			                </div>
			            </div>
			        </div>
		        </li>
			</c:forEach>
            
            
            
            
            
            
            
            
            
            
            </div>
         </div>
    </nav><!-- /.navbar -->