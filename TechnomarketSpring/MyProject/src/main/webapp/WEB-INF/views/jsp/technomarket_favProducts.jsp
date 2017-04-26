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
        <section>
    <div class="container">
        <div class="security">
 
	  <c:if test="${UserDAO.getInstance().getFavProducts(sessionScope.user) == null}">
	 	<h1>Няма любими продукти.</h1>
	 </c:if>
	 <c:if test="${UserDAO.getInstance().getFavProducts(sessionScope.user) != null}">  
	 	<h3>Любими продукти</h3>
	 	
	 	<c:forEach items="${productFav}" var="product">
    		<div class="col-md-4">
	
				<figure itemscope itemtype="http://schema.org/Product" class="product">
	        		<div class="badges">
	        			<c:if test="${productFav.promoPrice != 0}">
                    		<div class="badge-label badge-red badge-promo" title="Промо цена">Промо цена</div>
						</c:if>
    
                	</div>
        			<a itemprop="url" href="http://localhost:8080/TechnomarketSpring/product/viewProductPage/${productFav.productId}" class="product-thumb">
                		<!--  
                		<img itemprop="image" src="//cdn.technomarket.bg/media/cache/my_thumb/uploads/library/product/09126068/560af7c4f4122.jpeg" alt="Technomarket" />
            			-->
            			<img itemprop="image" src="/TechnomarketSpring/image/${productFav.productId}" alt="Technomarket" />
            			
            		</a>
    			<figcaption>
        			<div class="product-name">
            		<h3><a itemprop="url" href="http://localhost:8080/TechnomarketSpring/product/viewProductPage/${productFav.productId}"><span itemprop="name">${productFav.brand}</span></a></h3>
            		<small class="product-model">Арт.№: ${productFav.productId}<span itemprop="productID"></small>
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
                <c:if test="${productFav.promoPrice != 0}">
                	<span itemprop="price" class="new">${productFav.promoPrice}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                	<span itemprop="price" class="old">${productFav.price}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                </c:if>
                <c:if test="${productFav.promoPrice == 0}">
                	<span itemprop="price" class="new">${productFav.price}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
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
	 	
	 	
	 </c:if>
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>