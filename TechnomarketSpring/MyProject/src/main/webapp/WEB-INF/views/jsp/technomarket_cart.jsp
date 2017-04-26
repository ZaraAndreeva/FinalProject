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
  <!-- 
	  <c:if test="${UserDAO.getInstance().getAllUsers().get(sessionScope.user.email).getCart() == null}">
	 	
	 	
 		<div id="contentholder" class="contentholder">
         	<div class="container cart">
    	<div class="sh-heading">
           <h1>Количката е празна.</h1>
        </div>
         
            <p><a href="http://localhost:8080/TechnomarketSpring" class="btn btn-tm"><i class="icon-arrow-long-left"></i> Избери продукт</a></p>
            <hr>
            
            </div>
        </div>	 	
	 	
	 </c:if>
	 <c:if test="${UserDAO.getInstance().getAllUsers().get(sessionScope.user.email).getCart() != null}">
	 	<h3>Продукти в количката</h3>
	 	<c:forEach items="${list}" var="item">
	 	

	 	
	 	
   			
		</c:forEach>
	 </c:if>
	  -->
	  
	  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
            <script type="text/javascript">

                require(['jquery'], function ($) {

                    $('#cart_form input').change(function() {
                        $('#cart_save_button').show();
                    });
                });
               
                function changeQuantity(productId, value) {
                	$.ajax({ 
			            url: "/TechnomarketSpring/user/setNewQuantity/" + productId + "/" + value,
			            type: "POST"
			        }).done(function(responseData) {
			            //console.log('Done: ', responseData);
			        }).fail(function() {
			            //console.log('Failed');
			        });
                }  
            </script>
	 
	 <div id="contentholder" class="contentholder">
            	<div class="container cart">
    	<div class="sh-heading">
            <h2>Количка</h2>
        </div>
        
                <form name="cart" method="get" action="http://localhost:8080/TechnomarketSpring/user/orderPage" id="cart_form" class="form-horizontal" novalidate="1">
        
        <table class="table cart-table">
            <thead>
                <tr>
                    <th class="cart-id">#</th>
                    <th class="cart-product">Продукт</th>
                    <th class="cart-price">Цена</th>                    
                    <th class="cart-quantity">Количество</th>                    
                    <th class="cart-price-total">Общо</th>   
                    <th class="cart-remove" width="10"></th>                    
                </tr>
            </thead>
            <tbody>
                <c:set var="cnt" scope="page" value="1"/>
                <c:set var="money" scope="page" value="0"/>
                <c:forEach items="${sessionScope.cartProducts}" var="entry">
                	<c:set var="money" scope="page" value="${money+ (entry.key.price * entry.value)}"/>
                	<tr>
	                    <td class="cart-id">${cnt}</td>
	                    	<c:set var="cnt" value="${cnt+1}"/>
	                    <td class="cart-product">
	                    	<div class="cart-product-thumb">
	                        	<img src="/TechnomarketSpring/image/${entry.key.productId}" alt="Technomarket">
	                        </div>
	                        <div class="cart-product-info">
	                            ${entry.key.name}
	                        </div>                      
	                    </td>
	                    <td class="cart-price"><var class="price"><span class="color-inherit">${entry.key.price}<sup>00</sup>  <small>лв.</small></span></var></td>                                        
	                    <td class="cart-quantity"><input onchange="changeQuantity(${entry.key.productId}, this.value)" type="number" id="quantity" name="cart[items][09154100][quantity]" required="required" min="0" class="input-quantity form-control" value="${entry.value}"></td>
	                    <td class="cart-price-total"><var class="price"><span>${entry.key.price * entry.value}<sup>00</sup>  <small>лв.</small></span></var></td>
	                    <td class="cart-remove"><a href="/cart/remove?p=09154100" class="cart-product-remove" title="Премахни продукт"><i class="icon-minus"></i></a></td>                    
	                </tr>
	                
				</c:forEach>
                <tr>
                    <td colspan="3"></td>
                    <td align="right"><strong>Доставка:</strong></td>
                    <td align="right">Безплатна доставка</td>
                    <td></td>
                </tr>
                        
                        <tr class="cart-total">
                <td colspan="3"></td>
                <td align="right"><strong>Общо за плащане:</strong></td>
                <td align="right"><var class="price"><span>${money}<sup>00</sup>  <small>лв.</small></span></var></td>
                <td></td>
            </tr>
            </tbody>
            <tfoot>
                        <tr>
            	<td colspan="2" align="left"><a href="http://localhost:8080/TechnomarketSpring" class="btn btn-tm-dark"><i class="icon-arrow-long-left"></i> Добави още продукти</a></td>
            	<td colspan="3" align="right">
                                            <span id="cart_save_button" style="display: none">

                        Имате незапазени промени! <button type="submit" id="cart_save" name="cart[save]" class="btn-default btn">Запиши</button>
                        </span>
                       				                              <button type="submit" id="cart_checkout" name="cart[checkout]" class="btn-default btn">Поръчай</button>
                                                      </td>
               <td></td> 
            </tr>            	
            </tfoot>
        </table>
        <div style="display:none;">
        <div class="form-group"><label class="col-sm-6 control-label required">
                    Packs
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><div id="cart_packs"></div><span class="bar"></span></div></div><input type="hidden" id="cart__token" name="cart[_token]" class="form-control" value="4pklpq7uuwcJq21A8bW0ReeEdtKlsvE-oXOi9UuNGPM">
        </div>
        </form>
        <h1>${message}</h1>
        	
            </div>
        </div>
	 
	 
	 
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>