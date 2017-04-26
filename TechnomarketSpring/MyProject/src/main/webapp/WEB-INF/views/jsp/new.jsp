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
           
        </div>
        <div class="row">
            <aside class="col-md-3 sidebar">
	<h3 class="aside-filter-title"><a aria-controls="aside-filter" aria-expanded="true" href="#aside-filter-58f7d9c33c0e3" data-toggle="collapse" role="button" class="tm-collapse">Филтър</a></h3>
    
</aside>

<main class="col-md-13 filter-container">
    <div class="row">
	
		<c:forEach items="${products}" var="product">
    		<div class="col-md-4">
	                       
				<figure itemscope itemtype="http://schema.org/Product" class="product">
	        		<div class="badges">
	        			<c:if test="${product.promoPrice != 0}">
                    		<div class="badge-label badge-red badge-promo" title="Промо цена">Промо цена</div>
						</c:if>
    
                	</div>
                	<c:if test = ""> <!-- TODO ako gledame liubimi produkti -->
                		 <a href="" class="btn-remove" title="Премахни от любими"><i class="icon-remove"></i></a>
     				</c:if>
        			<a itemprop="url" href="http://localhost:8080/TechnomarketSpring/product/viewProductPage/${product.productId}" class="product-thumb">
                		<!--  
                		<img itemprop="image" src="//cdn.technomarket.bg/media/cache/my_thumb/uploads/library/product/09126068/560af7c4f4122.jpeg" alt="Technomarket" />
            			-->
            			<img itemprop="image" src="/TechnomarketSpring/image/${product.productId}" alt="Technomarket" />
            			
            		</a>
            			 
    			<figcaption>
        			<div class="product-name">
            		<h3><a itemprop="url" href="http://localhost:8080/TechnomarketSpring/product/viewProductPage/${product.productId}"><span itemprop="name">${product.brand}</span></a></h3>
            		<small class="product-model">Арт.№: ${product.productId}<span itemprop="productID"></small>
            		<ul itemprop="description" class="product-description">
                            <li>- МИКРОВЪЛНОВА ФУРНА ЗА ВГРАЖДАНЕ</li>
                            <li>- ПОЛЕЗЕН ОБЕМ 26 литра</li>
                            <li>- МОЩНОСТ МИКРОВЪЛНИ - 900W</li>
                            <li>- МОЩНОСТ ГРИЛ - 1000W</li>
                            <li>- ДИАМЕТЪР НА ЧИНИЯТА - 32.5 см.</li>
                            <li>- ЦИФРОВ ДИСПЛЕЙ</li>
                            <li>- 5 НИВА НА РЕГУЛАЦИЯ НА МОЩНОСТТА</li>
                            <li>- ЗАПАМЕТЯВАНЕ НА РЕЦЕПТИ</li>
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