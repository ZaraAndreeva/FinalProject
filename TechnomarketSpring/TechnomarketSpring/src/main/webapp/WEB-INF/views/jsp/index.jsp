<!doctype html>
<html class="no-js" lang="">
    <head>
                                            <title>Technomarket - Технoмаркет - онлайн магазин</title>
<meta name="google-site-verification" content="4GUfQ24-SB-8p2dO6_vCnz-rDTs7NGJm_rr2pfXBAl4" />        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="//cdn.technomarket.bg/images/favicon.ico">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
		<%@ page contentType="text/html; charset=UTF-8" %>
       	<link rel="stylesheet" type="text/css" href="technomarket_index.css">
        <script type="text/javascript" src="//cdn.technomarket.bg/assets/vendor/requirejs/require.js"></script>

    </head>
    <body itemscope itemtype="http://schema.org/WebPage" id="top" class="home">
    
    <div class="heading">
        <div class="container">
            <div class="row">
                <div class="logo" itemscope itemtype="http://schema.org/Organization">
                	<span itemprop="name" class="hidden">Техномаркет</span>
                    <a itemprop="url" href="/">
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
                    <div class="user-bar">
                                                <div class="user-account dropdown">
                            <button class="btn btn-tm dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            	<i class="icon-profile"></i> <span class="hidden-xs">Вход</span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="/login">Вход</a></li>
                                <li><a href="/register/">Регистрация</a></li>
                            </ul>
                        </div><!-- /.user-account -->
                                                <div class="basket">
                            <a href="/cart/" class="btn btn-tm">
                                <i class="icon-basket"></i> -
                            </a>
                        </div><!-- /.basket -->
                    </div><!-- /.user-bar -->
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
                
                          
                <sql:setDataSource
				    var="myDS"
				    driver="com.mysql.jdbc.Driver"
				    url="jdbc:mysql://localhost:3306/mydb"
				    user="root" password="123"
				/>
                
               
				
				 <ul>
                            <li class="has-children">
       <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <c:forEach var="category" items="${listCategories.rows}">
                <ul>
                <li>
                 <c:out value="${category.name}" />
                 </li>
                 </ul>
                 </c:forEach> </a>   
                 
                 
                 <sql:query var="list_categories" dataSource="${myDS}">
    				SELECT name FROM sub_categories where category_id = 1;
				</sql:query>
				<li>
           <a href="/televizor/blaupunkt" class="ui-link"> 
            <c:forEach var="sub_category" items="${listCategories.rows}">
                <ul>
                <li>
                 <c:out value="${sub_category.name}" />
                 </li>
                 </ul>
                 </c:forEach> 
           </a>                                           
                </li>
               </ul>
                

</body>
</html>