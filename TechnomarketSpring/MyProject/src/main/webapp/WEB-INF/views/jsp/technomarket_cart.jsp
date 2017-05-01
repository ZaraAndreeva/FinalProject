<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%@ include file="/menu_nachalo.jsp" %>
</header>
                                                <div id="contentholder" class="contentholder">
        <section>
    <div class="container">
        <div class="security">
  
	  <c:if test="${empty sessionScope.cartProducts}">
	 	
	 	
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
	    			  type: "POST", //send it through get method
	    			  contentType : 'application/json; charset=utf-8',
	    			  dataType : 'json',
	    			  success: function(response) {
	    				  var changes = response.changes;
	    				  for(i = 0; i < changes.length; i++){
	    					  var price = (changes[i].messege).toFixed(2);
		    				  document.getElementById(changes[i].place).innerHTML = price + " лв.";
	    				  }	  
	    			  },
	    			  error: function(xhr) {
	    				  document.getElementById("status").innerHTML="Грешката е при нас... Моля, опитайте по-късно.";
	    			  }
	    		});    
	    	
		    
		    
          }
          
          function removeProduct(productId) {
	          	$.ajax({ 
			         url: "/TechnomarketSpring/user/removeFromCart/" + productId,
			         type: "POST"
				     }).done(function(responseData) {
				         //console.log('Done: ', responseData);
				     }).fail(function() {
			         //console.log('Failed');
			   });
          }
          
          function makeOrder() {
	          	$.ajax({ 
			         url: "/TechnomarketSpring/user/makeOrder",
			         type: "POST"
				     }).done(function(responseData) {
				         //console.log('Done: ', responseData);
				     }).fail(function() {
			         //console.log('Failed');
			   });
        }
          
      </script>
      
	 <c:if test="${not empty sessionScope.cartProducts}">

	 <div id="contentholder" class="contentholder">
            	<div class="container cart">
    	<div class="sh-heading">
            <h2>Количка</h2>
        </div>
        
                <div name="cart" id="cart_form" class="form-horizontal" novalidate="1">
        
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
	                        	<a href="/TechnomarketSpring/product/viewProductPage/${entry.key.productId}">
	                            	${entry.key.name}
	                            </a>
	                        </div>                      
	                    </td>
	                    <td class="cart-price"><var class="price"><span class="color-inherit"><fmt:formatNumber pattern="0.00" value="${entry.key.price}"/><sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup>  <small>лв.</small></span></var></td>                                        
	                    <td class="cart-quantity"><input onchange="changeQuantity(${entry.key.productId}, this.value)" type="number" id="quantity" name="cart[items][09154100][quantity]" required="required" min="0" class="input-quantity form-control" value="${entry.value}"></td>
	                    <td class="cart-price-total"><var class="price"><span id="total_product_price_${entry.key.productId}"><fmt:formatNumber pattern="0.00" value="${entry.key.price * entry.value}"/><sup>&nbsp;&nbsp;</sup>лв.</span></var></td>
	                    <td class="cart-remove"><a href="/TechnomarketSpring/user/cartPage" onclick="removeProduct(${entry.key.productId})" class="cart-product-remove" title="Премахни продукт"><i class="icon-minus"></i></a></td>                    
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
                <td align="right"><var class="price"><span id="total_cart_price"><fmt:formatNumber pattern="0.00" value="${money}"/><sup>&nbsp;&nbsp;</sup>лв.</span></var></td>
                <td></td>
            </tr>
            </tbody>
            <tfoot>
                        <tr>
            	<td colspan="2" align="left"><a href="http://localhost:8080/TechnomarketSpring" class="btn btn-tm-dark"><i class="icon-arrow-long-left"></i> Добави още продукти</a></td>
            	<td colspan="3" align="right">
											<!--  	            	
                                            <span id="cart_save_button" style="display: none">

                        Имате незапазени промени! <a href="/TechnomarketSpring/user/cartPage" type="submit" id="cart_save" name="cart[save]" class="btn-default btn">Запиши</a>
                        </span>
                        -->
                        
                        	<c:if test = "${sessionScope.user != null}">
                       				                              <a onclick="makeOrder()" href="/TechnomarketSpring/user/ordersPage" id="cart_checkout" name="cart[checkout]" class="btn-default btn">Поръчай</a>
                                                      </c:if>
                                                      <c:if test = "${sessionScope.user == null}">
                                                      <a onclick="makeOrder()" href="/TechnomarketSpring/user/loginPage" id="cart_checkout" name="cart[checkout]" class="btn-default btn">Поръчай</a>
                                                      </c:if>
                                                      </td>
               <td></td> 
            </tr>            	
            </tfoot>
        </table>
        <h2 id="status"></h2>
        <div style="display:none;">
        <div class="form-group"><label class="col-sm-6 control-label required">
                    Packs
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><div id="cart_packs"></div><span class="bar"></span></div></div><input type="hidden" id="cart__token" name="cart[_token]" class="form-control" value="4pklpq7uuwcJq21A8bW0ReeEdtKlsvE-oXOi9UuNGPM">
        </div>
        </div>
        <h1>${message}</h1>
        	
            </div>
        </div>
	  </c:if>
	 
	 
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
  
  
    </body>
</html>