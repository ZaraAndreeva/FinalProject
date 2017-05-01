<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%@ include file="/menu_nachalo.jsp" %>

</header>
                                                <div id="contentholder" class="contentholder">
            <div class="">
    
    

                    <section class="">
            <div class="container">            	
                    
            <section>
        <div class="container"><div class="page-title sh-heading">
            <h2>${category}</h2>
        </div>
           
        </div>

	<div class="row">
	            <aside class="col-md-3 sidebar">
		<h3 class="aside-filter-title"><a aria-controls="aside-filter" aria-expanded="true" href="#aside-filter-590706410427b" data-toggle="collapse" role="button" class="tm-collapse">Филтър</a></h3>
<c:if test = "${categorySearch}">
	    <div id="aside-filter-590706410427b" class="aside-filter collapse in">
	        <form name="sort" method="get" action="" class="form-horizontal" novalidate="1">
		        <div id="filter_form">
			        <fieldset class="filter-box"><header><h3>
				        <a class="required" for="filter_form_sort">Подреди по</a></h3></header>
				        <div class="filter-content">
				        	<!-- 
					        <select id="filter_form_sort" name="filter_form[sort]" class="form-control" >
					        	<option value="default">по подразбиране</option>
					        	<option value="type" id = "byName">по азбучен ред</option>
					        	<option value="priceVuz">по цена възходящо</option>
					        	<option value="priceNiz">по цена низходящо</option>
					        </select>
					         -->
				         	<a href="http://localhost:8080/TechnomarketSpring/product/sortProductsByName/${category}" class="btn btn-tm flix_cart_click_check">По азбучен ред</a> <br> <br>
					        <a href="http://localhost:8080/TechnomarketSpring/product/sortProductsByPriceVuz/${category}" class="btn btn-tm flix_cart_click_check">По цена възходящо</a> <br> <br> 
					        <a href="http://localhost:8080/TechnomarketSpring/product/sortProductsByPriceNiz/${category}" class="btn btn-tm flix_cart_click_check">По цена низходящо</a>  
					        
				        </div>
			        </fieldset>
		
		       		<fieldset class="filter-box"><header><h3><a class="required">Цена</a></h3></header><div class="filter-content">
		       			<div class="range-widget">
			       			<input type="number" min = "1" id="minPrice" name="minPrice" required="required" placeholder="" class="form-control" value="19">
			       			<input type="number" min = "1" id="maxPrice" name="maxPrice" required="required" placeholder="" class="form-control" value="139">
		       			</div></div>
		       		</fieldset>
	       		</div>
		    </form>
	    </div>	
</c:if>
	</aside>	

<main class="col-md-13 filter-container">
    <div class="row">
		<h2>${error}</h2>
			
		<c:forEach items="${products}" var="product">
		<c:if test = "${favPr}">
			<h1>${message123}</h1>
		</c:if>
		<c:if test= "${product.quantity > 0}">
    		<div class="col-md-4">
	                       
				<figure itemscope itemtype="http://schema.org/Product" class="product">
	        		<div class="badges">
	        			<c:if test="${product.promoPrice != 0}">
                    		<div class="badge-label badge-red badge-promo" title="Промо цена">Промо цена</div>
						</c:if>
    
                	</div>
                	<c:if test = "${favPr}">
                		 <a href="http://localhost:8080/TechnomarketSpring/user/removeFavProd/${product.productId}" class="btn-remove" title="Премахни от любими"><i class="icon-remove"></i></a>
     				</c:if>
        			<a itemprop="url" href="http://localhost:8080/TechnomarketSpring/product/viewProductPage/${product.productId}" class="product-thumb">
                		<!--  
                		<img itemprop="image" src="//cdn.technomarket.bg/media/cache/my_thumb/uploads/library/product/09126068/560af7c4f4122.jpeg" alt="Technomarket" />
            			-->
            			<img itemprop="image" src="/TechnomarketSpring/image/${product.productId}" alt="Technomarket" />
            			
            		</a>
            			 
    			<figcaption>
        			<div class="product-name">
            		<h3><a itemprop="url" href="http://localhost:8080/TechnomarketSpring/product/viewProductPage/${product.productId}"><span itemprop="name">${product.name}</span></a></h3>
            		<small class="product-model">Арт.№: ${product.productId}<span itemprop="productID"></small>
            		<ul itemprop="description" class="product-description">

                     </ul>            
       	 </div>
       
                <div class="product-price">
            <var itemprop="offers" itemscope itemtype="http://schema.org/Offer" class="price">
            	<meta itemprop="priceCurrency" content="BGN" />
                <c:if test="${product.promoPrice != 0}">
                	<span itemprop="price" class="new">${product.promoPrice}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                	<span itemprop="price" class="old">${product.price}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                </c:if>
                <c:if test="${product.promoPrice == 0}">
                	<span itemprop="price" class="new">${product.price}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                </c:if>
                                
                <div><link itemprop="itemCondition" href="http://schema.org/NewCondition" /> <span class="hidden">New</span></div>
            </var>
            <form action="/cart/add">
                <input type="hidden" value="09126068" name="product">
                <button type="submit" class="btn btn-tm">
                	<i class="icon-basket"></i> Купи онлайн
                </button>
            </form>            
        </div>
          </figcaption>
		</figure><!--.product-->

	</div>
	</c:if>
		</c:forEach>
		<h3>${message}</h3>
		<!--End of product div-->
		
<div class="clear filter_load_more" data-from="20" data-size="20"></div>
    </div>
</main>

<hr class="clear">
<script type="text/javascript">
    require(['app', 'jquery'], function(app, $){
        app.facets($('#aside-filter-58f7d9c33c0e3'), "/microvylnova-furna-za-vgrajdane|static|static");
    });
</script>
        </div>
    </div>
</section>

            </div>
        </section>    
        
    
    </div>
        </div>
        <footer>
    
    
   <%@ include file="/menu_krai.jsp" %>
        
    </body>
</html>