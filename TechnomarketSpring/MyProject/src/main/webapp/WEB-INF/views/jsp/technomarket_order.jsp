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
    <div class="row-split">

         <div class="col-half">
         
         <div id="contentholder" class="contentholder">
        <div class="container">
    <div class="sh-heading">
        <h2>Преглед на поръчката</h2>
    </div>
    
    <div class="panel-group tm-panel-group">        
        <div class="panel" id="heading-1">
            <div class="panel-heading">
                                    <h3><a>Вашата поръчка все още не е потвърдена</a></h3>
                            </div>
            <div class="panel-body">
                <dl class="dl-horizontal">
                    <dt>Дата:</dt><dd><p>${order.date}</p></dd>
                    <dt>Статус:</dt><dd><p>${order.status}</p></dd>
                    <dt>Е-майл:</dt><dd><p>${order.email}</p></dd>
                   
                </dl>
            </div>
        </div><!--/.panel-->
            
        <div class="panel" id="heading-2">
            <div class="panel-heading">
                <h3><a>Детайли на поръчката</a></h3>
            </div>
            <div class="panel-body">
                <dl class="dl-horizontal">
                    <dt>Продукт:</dt>
                    <dd>
                        <p>
                        	<!--  
                            	1 x APPLE IPHONE 7 128GB RED SPECIAL EDITION - <var class="price xs"><span>1739.<sup>00</sup>  <small>лв.</small></span></var>
                       			
                       		-->
                       		
                       		
                       	</p>
                       	
                       	
                       	<c:forEach items="${order.products}" var="entry">
		                	<p>
                        		${entry.value} x ${entry.key.name} - <var class="price xs"><span>${entry.value * entry.key.price}<sup>00</sup>  <small>лв.</small></span></var>
                      		</p>	
						</c:forEach>
                                                                    </dd>
                    <dt>Доставка:</dt><dd><p><var class="price xs"><span>-</span></var></p></dd>
                                        <dt>Общо за плащане:</dt><dd><p><var class="price xs"><span>${order.price}<sup>00</sup>  <small>лв.</small></span></var></p></dd>
                </dl>
            </div>
        </div><!--/.panel-->        
            
                <div class="panel" id="panel_address">
            <div class="panel-heading">
                <h3><a>Адрес за доставка</a></h3>
            </div>
            <div class="panel-body">
                <div class="col-md-8">
                                                                  
                        
                        
                        <hr>
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
                        <script src="http://maps.googleapis.com/maps/api/js?libraries=places&region=BG&key=AIzaSyBWlzyztqg13r3PfVQ0sjAHBLm3b-mioJ4" type="text/javascript"></script>
                        <script type="text/javascript">
                        
	                        function initialize() {
	                            var input = document.getElementById('address_city_br');
	                            var options = {
	                            		  types: ['(cities)'],
	                            		  componentRestrictions: {country: 'bg'}
	                            };
	                            var autocomplete = new google.maps.places.Autocomplete(input, options);
	                        }
	                        google.maps.event.addDomListener(window, 'load', initialize);
	                        $('.search-location').keypress(function(e) {
	                        	  if (e.which == 13) {
	                        	    google.maps.event.trigger(autocomplete, 'place_changed');
	                        	    return false;
	                        	  }
	                        });
                        
                            require(['jquery'], function($){


                                $('#warehouse_pickup_trigger').on('click', function(event) {
                                    event.preventDefault();
                                    event.stopPropagation();
                                    $(this).hide();
                                    $('#warehouse_pickup_container').show();
                                });
                            });
                            
	              	    		
	              	    		
							
                        </script>
                                        <h4><strong>Доставка до дома Ви</strong></h4>
                    <div class="tm-html">
<div class="form-horizontal" novalidate="2">	<table class="address-widget" width="100%">
    	<tbody>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label required" for="address_receiver">
                    Име
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="name" required="required" class="form-control" maxlength="100">
                  		<span id="nameError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            	                     	
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label required" for="address_receiver">
                    Фамилия
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="familyName" required="required" class="form-control" maxlength="100">
                    	<span id="familyNameError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            			
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label required" for="address_phone_br">
                    Тел.
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="phone" required="required" class="form-control">
                    	<span id="phoneError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            	
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <label class="col-sm-6 control-label required" for="address_city_br">
                    Град
                                            <span class="required" title="This field is required">*</span></label>
                        <div class="typeahead-container">
        <div class="typeahead-field">

            <span class="typeahead-query">
              <input type="text" id="address_city_br" required="required" class="form-control" autocomplete="off">
 				<span id="cityError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            		     	
            </span>
            

        </div>
    </div>

                    
                </td>
                
            </tr>
            <tr>
                <td colspan="3">
                    <label class="col-sm-6 control-label required" for="address_streetb_id">
                    Улица/Квартал
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="street" name="street" required="required" class="form-control" maxlength="100">
                    	<span id="streetError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            	
                </td>
                
            </tr>
            <tr>
                <td>
                    <label class="col-sm-6 control-label" for="address_block_b">
                    Блок
                                    </label>
                    <input type="number" min = "1" id="block" name="block" class="form-control" maxlength="5">
                		    	
                </td>
                  	
                <td>
                    <label class="col-sm-6 control-label" for="address_entrance_b">
                    Вход
                                    </label>
                    <input type="text" id="entrance" name="entrance" class="form-control" maxlength="5">
                    
                </td>
                <td>
                    <label class="col-sm-6 control-label" for="address_floor_b">
                    Етаж
                                    </label>
                    <input type="number" min = "1" max = "100" id="floor" name="floor" class="form-control">
                    
                </td>
                <td>
                    <label class="col-sm-6 control-label" for="address_apartment_b">
                    Апартамент
                                    </label>
                    <input type="number" min = "1" id="apartment" name="apartment" class="form-control">
                    
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label" for="address_additional_info_b">
                    Уточнения за адрес
                                    </label>
                    <textarea id="descriptionAddress" name="descriptionAddress" class="form-control" maxlength="200"></textarea>
                    
                </td>
            </tr>
        </tbody>
    </table>

    <div id="address"><input type="hidden" id="address_siteid_br" name="address[siteid_br]" required="required" class="form-control">    <div class="form-group form-submit">
    	<div class="col-sm-6"></div>
        <div class="col-sm-10">
            <button id="btn" class="btn-default btn">Изпрати</button>
        </div>
       
    </div>
    <h2 id="status"></h2>
<input type="hidden" id="address__token" name="address[_token]" class="form-control" value="rsZMPYqoqEnfDD97DVgrOR5hIV1orSAkD3aAKbK1HW4"></div>

    <script type="text/javascript">
        require(['typeahead'], function(){

            var selectedItem = false;

            $el = $('#address_city_br');
            $pkEl = $('#address_pk_br');
            $idEl = $('#address_siteid_br');

            function selectItem(item)
            {
                selectedItem = item;
                $pkEl.val(item.zip);
                $idEl.val(item.id);
            }

            $el.blur(function(){

                var val = $el.val();

                if (val != selectedItem.name)
                {
                    $el.val('');
                    $pkEl.val('');
                    $idEl.val('');
                }

            });
            
            
            
        });
        
        
        
        var btn = document.getElementById("btn"); 
    	btn.addEventListener("click", function() {
    		$.ajax({
    			  url: "/TechnomarketSpring/user/finishOrder/${order.orderId}",
    			  type: "POST", //send it through get method
    			  contentType : 'application/json; charset=utf-8',
    			  dataType : 'json',
    			  data: JSON.stringify(
    					  	{
    							name: document.getElementById("name").value,	  		
    							familyName: document.getElementById("familyName").value,
    							phone: document.getElementById("phone").value,
    							city: document.getElementById("address_city_br").value,
    							street: document.getElementById("street").value,
    							block: document.getElementById("block").value,
    							entrance: document.getElementById("entrance").value,
    							floor: document.getElementById("floor").value,
    							apartment: document.getElementById("apartment").value,
    							descriptionAddress: document.getElementById("descriptionAddress").value
    						}			  
    			  ),
    			  success: function(response) {
    				  	document.getElementById("nameError").innerHTML="";
    					document.getElementById("familyNameError").innerHTML="";
    					document.getElementById("phoneError").innerHTML="";
    					document.getElementById("cityError").innerHTML="";
    					document.getElementById("streetError").innerHTML="";
    					document.getElementById("status").innerHTML="";
    				if(!response.error){
    					  	document.getElementById("status").innerHTML="Вашата поръчка чака потвърждение. Моля, проверете си пощата и потвърдете поръчката.";
    					  	document.getElementById("name").value="";	  		
    						document.getElementById("familyName").value="";
    						document.getElementById("phone").value="";
    						document.getElementById("address_city_br").value="";
    						document.getElementById("street").value="";
    				  }
    				  else{
    					  var errors = response.errors;
    					  
    					  for(var i = 0; i < errors.length; i++){
    						  //document.getElementById(errors[i]).innerHTML="Error";
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
</div></div>
                </div>
            </div>
        </div><!--/.panel-->
        
            
        
                
    </div><!--/.panel-group-->
</div>

        </div>
         
         
         
         
            
                                                        </div>

    </div>
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>