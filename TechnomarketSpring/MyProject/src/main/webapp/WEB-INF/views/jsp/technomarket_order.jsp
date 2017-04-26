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
                                    <h3><a href="">Вашата поръчка все още не е потвърдена</a></h3>
                            </div>
            <div class="panel-body">
                <dl class="dl-horizontal">
                    <dt>Дата:</dt><dd><p>26 април 2017 г., 3:32:51</p></dd>
                    <dt>Статус:</dt><dd><p>Непотвърдена поръчка</p></dd>
                    <dt>Е-майл:</dt><dd><p><a href="">zara.andreeva@yahoo.com</a></p></dd>
                </dl>
            </div>
        </div><!--/.panel-->
            
        <div class="panel" id="heading-2">
            <div class="panel-heading">
                <h3><a href="">Детайли на поръчката</a></h3>
            </div>
            <div class="panel-body">
                <dl class="dl-horizontal">
                    <dt>Продукт:</dt>
                    <dd>
                                                                        <p>
                            1 x APPLE IPHONE 7 128GB RED SPECIAL EDITION - <var class="price xs"><span>1739.<sup>00</sup>  <small>лв.</small></span></var>
                                                    </p>
                                                                    </dd>
                    <dt>Доставка:</dt><dd><p><var class="price xs"><span>-</span></var></p></dd>
                                        <dt>Общо за плащане:</dt><dd><p><var class="price xs"><span>1739.<sup>00</sup>  <small>лв.</small></span></var></p></dd>
                </dl>
            </div>
        </div><!--/.panel-->        
            
                <div class="panel" id="panel_address">
            <div class="panel-heading">
                <h3><a href="#collapse-3">Адрес за доставка</a></h3>
            </div>
            <div class="panel-body">
                <div class="col-md-8">
                                                                  
                        
                        
                        <hr>
                        <script type="text/javascript">
                            require(['jquery'], function($){


                                $('#warehouse_pickup_trigger').on('click', function(event) {
                                    event.preventDefault();
                                    event.stopPropagation();
                                    $(this).hide();
                                    $('#warehouse_pickup_container').show();
                                });
                            });
                            for(var f=document.forms,i=f.length;i--;)f[i].setAttribute("novalidate",i)
                        </script>
                                        <h4><strong>Доставка до дома Ви</strong></h4>
                    <div class="tm-html"><form name="address" method="post" action="#panel_address" class="form-horizontal" novalidate="2">	<table class="address-widget" width="100%">
    	<tbody>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label required" for="address_receiver">
                    Име
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="address_receiver" name="name" required="required" class="form-control">
                    
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label required" for="address_receiver">
                    Фамилия
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="address_receiver" name="familyName" required="required" class="form-control">
                    
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label required" for="address_phone_br">
                    Тел.
                                            <span class="required" title="This field is required">*</span></label>
                    <input type="text" id="address_phone_br" name="phone" required="required" class="form-control">
                    
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
              <input type="text" id="address_city_br" name="town" required="required" autocomplete="off" class="form-control">
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
                    <input type="text" id="address_streetb_id" name="street" required="required" class="form-control">
                    
                </td>
                
            </tr>
            <tr>
                <td>
                    <label class="col-sm-6 control-label" for="address_block_b">
                    Блок
                                    </label>
                    <input type="number" min = "1" id="address_block_b" name="block" class="form-control">
                    
                </td>
                <td>
                    <label class="col-sm-6 control-label" for="address_entrance_b">
                    Вход
                                    </label>
                    <input type="text" id="address_entrance_b" name="entrance" class="form-control">
                    
                </td>
                <td>
                    <label class="col-sm-6 control-label" for="address_floor_b">
                    Етаж
                                    </label>
                    <input type="number" min = "1" max = "100" id="address_floor_b" name="floor" class="form-control">
                    
                </td>
                <td>
                    <label class="col-sm-6 control-label" for="address_apartment_b">
                    Апартамент
                                    </label>
                    <input type="number" min = "1" id="address_apartment_b" name="apartment" class="form-control">
                    
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <label class="col-sm-6 control-label" for="address_additional_info_b">
                    Уточнения за адрес
                                    </label>
                    <textarea id="address_additional_info_b" name="descriptionAddress" class="form-control"></textarea>
                    
                </td>
            </tr>
        </tbody>
    </table>

    <div id="address"><input type="hidden" id="address_siteid_br" name="address[siteid_br]" required="required" class="form-control">    <div class="form-group form-submit">
    	<div class="col-sm-6"></div>
        <div class="col-sm-10">
            <button type="submit" id="address_submit" name="address[submit]" class="btn-default btn">Изпрати</button>
        </div>
    </div>
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
            $el.typeahead({
                minLength: 1,
                dynamic: true,
                template: '<span class="row">{{type}} {{name}} ({{region}})</span>',
                mustSelectItem: false,
                source: {
                    user: {
                        display: ["name"],
                        filter: false,
                        url: [{
                            type: "GET",
                            url: "/tools/cities",

                            data: {
                                q: "{{query}}"
                            }
                        }, "data.cities"]
                    }
                },
                callback: {
                    onClickAfter: function  (node, a, item, event) {
                        selectItem(item)
                    }
                }
            });
        });
    </script>
</form></div>
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