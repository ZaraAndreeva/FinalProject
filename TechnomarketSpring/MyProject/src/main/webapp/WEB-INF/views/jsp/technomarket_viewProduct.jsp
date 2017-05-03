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
    
    <div id="contentholder" class="contentholder">
            <div class="">
    
    

                    <section class="">
            <div class="container">            	
                 
    		<div class="row">
            <figure itemscope="" itemtype="http://schema.org/Product" class="product product-details clearfix">
                <div class="product-thumb photoswipe">
                    <div class="product-heading">
                                                <div class="product-category"><a href="/TechnomarketSpring/showProduct/${product.subCategory}"><i class="icon-arrow-long-left"></i> ${product.subCategory}</a></div>
                                                <h1><a href=""><span itemprop="name">${product.name}</span></a></h1>
                        <div class="product-model">Арт.№: <span itemprop="productID">${product.productId}</span></div>
                    </div>                                
                    
                    	                    <img itemprop="image" src="/TechnomarketSpring/image/${product.productId}" alt="Technomarket" />
                    <div class="product-gallery">
                                        </div>

                </div>
                <figcaption>
                    <div class="product-name">    
                                                 
                        
                        <div class="product-share">                                      
                            <ul>
                                <li>
                                                                            <a href="http://localhost:8080/TechnomarketSpring/user/addFavProd/${product.productId}" class="favorites favorites-add"><i class="icon-heart"></i> Любими</a>
                                                                    </li>
                                <li>
                                                                                                                   </li>                       	
                            </ul>
                            
                                                        
                            
                        </div>


                                                                                                <ul itemprop="description" class="product-description moreLines">
                                                            <li><b>Количество: </b>${product.quantity}</li>
                                                            <li><b>Марка: </b>${product.brand}</li>
                                                            <li><b>Описание: </b>${product.description}</li>
                                                          
                                                     
                                                     </ul>
                                                       </div>
                                        <div itemprop="offers" itemscope="" itemtype="http://schema.org/Offer" class="product-price">
                    	<meta itemprop="priceCurrency" content="BGN">
                    	<div class="price-row price-online clearfix">
                        	<div class="price-title">Купи сега</div>
                                                        <var class="price">

                                <c:if test="${product.promoPrice != 0}">
				                	<span itemprop="price" class="new">${product.promoPrice}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
				                	<span itemprop="price" class="old">${product.price}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                				</c:if>
                				<c:if test="${product.promoPrice == 0}">
                					<span itemprop="price" class="new">${product.price}<sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</sup><small>лв.</small></span>
                				</c:if>
                            </var>

                        </div>      
                                                
                        <form action="http://localhost:8080/TechnomarketSpring/user/addToCart/${product.productId}" method = "POST" novalidate="1">
 
                                                                                    <div class="buy-now">
                                <input type="hidden" value="${product.productId}" name="product">
                                                                <button type="submit" class="btn btn-tm flix_cart_click_check">
                                    <i class="icon-basket"></i> Добави в количка
                                    
                                </button>
                                </div>
                         </form>
                                
                                <c:if test="${user.admin}">
                                	<c:if test = "${product.promoPrice == 0}">
                                			<div class="buy-now">
		                                		<button onclick="showDiv()" class="btn btn-tm flix_cart_click_check">Добави в промоция.</button>
		                                	</div>
		                                		<div id="welcomeDiv"  style="display:none;" class="buy-now">
				                              		<b>Нова цена:</b> <br>
				                              		<span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar">
                                           			 <input type="number" min = "0" id="newPrice" name="newPrice" required="required" class="form-control" />
                                            		<span id="newPriceError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            		<span class="bar"></span></div>
				                                	<input id = "btn" class="btn btn-tm" type="submit" value="Добави" />
		                       
		                         			
												</div>
											
											<script>
											function showDiv() {
												   document.getElementById('welcomeDiv').style.display = "block";
												}
										
											</script>
                                  	</c:if>
                                  	
		<script>
        var btn = document.getElementById("btn"); 
    	btn.addEventListener("click", function() {
    		$.ajax({
    			  url: "/TechnomarketSpring/admin/addPromotion/${product.productId}",
    			  type: "POST", //send it through get method
    			  contentType : 'application/json; charset=utf-8',
    			  dataType : 'json',
    			  data: JSON.stringify(
    					  	{
    					  		newPrice: document.getElementById("newPrice").value,
    					  	}			  
    			  ),
    			  success: function(response) {
    				  	var responseData = response;
    					document.getElementById("newPriceError").innerHTML="";
    				  	
    				  if(!responseData.error){
    					  window.location.href = "http://localhost:8080/TechnomarketSpring/product/viewProductPage/${product.productId}";  		
    				  }
    				  else{
    					  var errors = responseData.errors;
    					  
    					  for(var i = 0; i < errors.length; i++){
    						  document.getElementById(errors[i].errorPlace).innerHTML = errors[i].errorMessege;
    					  }
    				  }
    				  
    				  
    			  },
    			  error: function(xhr) {
    				  document.getElementById("status").innerHTML="Грешката е при нас... Моля, опитайте по-късно.";
    			  }
    			});    
    		
    		
    		
    	});
        
        
        </script>
                                  	
                                   	<c:if test = "${product.promoPrice != 0}">
                                   		<div class="buy-now">
                                   		<a href="http://localhost:8080/TechnomarketSpring/admin/removePromotion/${product.productId}" class="btn btn-tm flix_cart_click_check">Премахни от промоция</a>
                                   		</div>
                                   	</c:if>
                             
                                   	<div class="buy-now">
                                   	<a href="http://localhost:8080/TechnomarketSpring/admin/deleteProduct/${product.productId}" class="btn btn-tm flix_cart_click_check">Премахни продукт</a>
                                   	</div>
                 					
                                   	<div class="buy-now">
                                   		<button onclick="showDiv2()" class="btn btn-tm flix_cart_click_check">Редактирай продукт</button>
                                   		<form action="http://localhost:8080/TechnomarketSpring/admin/editProduct/${product.productId}" method = "GET" novalidate="1">
			                  					<div id="welcomeDiv2"  style="display:none;" class="buy-now">
				                              		<b>Име:</b> <br>
				                                	<input type="text" id="name" name = "name"/> <br>
				                                	<b>Количество:</b> <br>
				                                	<input type="number" min = "0" id="quantity" name = "quantity"/> <br>
				                                	<b>Цена:</b> <br>
				                                	<input type="number" min = "0" id="price" name = "price"/> <br>
				                                	<b>Описание:</b> <br>
				                                	<input type="text" id="description" name = "description"/> <br>
				                                	<input class="btn btn-tm" type="submit" value="Промени" />
		                         					
												</div>
										</form>
										<script>
											function showDiv2() {
												   document.getElementById('welcomeDiv2').style.display = "block";
												}
										
											</script>
                                   	</div>
    	
                                 </c:if>
                                
                                                            </div>
                                         
                        

                        <div class="partials-info">
                                                                                </div>                       
                    </div>
     
                       <c:if test="${product.quantity} == 0">
                      	 <h1>Продуктът вече не е наличен.</h1>
                       </c:if>        
                                    </figcaption>
                <div class="partials">
                    <div class="col-md-12">
                                                <div class="row">
                                                    </div>
                    </div>
                </div>
            </figure>          
        </div>


     <h1>${messageErrorN}</h1>  
     <h1>${messageErrorQ}</h1>
     <h1>${messageErrorD}</h1>
     <h1>${messageErrorP}</h1>
	 <h1>${message}</h1> 
       
    <div class="row row-brp">            
        <div class="col-md-12">                             
            <div class="tm-tabs">
                                <ul class="nav nav-tabs">
                                        
                    <li class="active">
                    <!-- 
                        <a aria-expanded="true" aria-controls="product-tab1" data-toggle="tab" role="tab" id="product-nav-tab-1" href="#product-tab1">
                            Спецификации
                        </a>
                         -->
                    </li>
                                                                                    <li class="kiosk-hidden ">
                        

                                                                                                        
                </ul>        
            </div><!--/.tm-tabs-->
            <div class="tab-content">  
                  
                          
                <div id="product-tab1" class="tab-pane fade active in" role="tabpanel">
                    <section class="product-specifications">                      
                        <table class="table tm-table">
                            <tbody>
                            
                            </tbody>
                        </table>
                    </section>                         
                </div>
                                                                    <div id="product-tab2" class="kiosk-hidden tab-pane fade" role="tabpanel">
                    <section class="product-stock">               
                        <div class="stock-legend">
	<ul>
   		 
    </ul>
    
</div>
<hr>
<ul>
    
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>