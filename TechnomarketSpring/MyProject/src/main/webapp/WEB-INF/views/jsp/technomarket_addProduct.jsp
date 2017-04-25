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
            <h2>Добавяне на продукт</h2>
            <div class="fos_user_registration_register form-horizontal">
            <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_first_name">
                    Описание
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="text" id="description" name="fos_user_registration_form[first_name]" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="descriptionError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_last_name">
                    Количество
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="number" min = "0" id="quantity" name="fos_user_registration_form[last_name]" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="quantityError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_email">
                    Цена
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="number" min = "0" id="price" name="fos_user_registration_form[email]" required="required" class="form-control" />
                                            	<span id="priceError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_first">
                    Марка
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="text" id="brand" name="fos_user_registration_form[plainPassword][first]" required="required" class="form-control" />
                                            	<span id="brandError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_second">
                    <!--  
                    Категория
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="text" id="fos_user_registration_form_plainPassword_second" name="fos_user_registration_form[plainPassword][second]" required="required" class="form-control" />
                                            	
                      		                  <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    -->
                    Подкатегория
                   							 <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                   							 <input type="text" id="sub_category" name="fos_user_registration_form[plainPassword][second]" required="required" class="form-control" />
                   								<span id="subCategoryError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    <!--  
                    ПодПодКатегория
                						    <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar">
                						    <input type="text" id="fos_user_registration_form_plainPassword_second" name="fos_user_registration_form[plainPassword][second]" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    -->
                    <div class="col-sm-offset-6 col-sm-10">
                         <button  class="btn btn-tm" id="btn">Добави</button>
                    </div>                    
                </div>
                <h2 id="status"></h2>      
            </div>
        </div>
        <div class="col-half">
            <h2>Качи снимка: </h2>
            <!--  
            	<a href="" class="btn btn-tm">Избери</a>
            -->
            <form method="POST" enctype="multipart/form-data">
				<input type="file" id="file" name="failche" accept="image/*">
				<input type="text" id="productId" name="productId" class="form-control" required/>
				<!--      		
										
					<input type="submit" value="Upload now" class="btn btn-tm">
				-->
				<button id="btnUpload" type="submit" class="btn btn-tm">Качи</button>
			</form>
			<h2>${messege}</h2>
       	</div>
         <div class="col-half">
            
                                                        </div>

    </div>
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
  
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
  	<script>
  	var btn = document.getElementById("btn"); 
	btn.addEventListener("click", function() {
		$.ajax({
			  url: "/TechnomarketSpring/product/addProduct",
			  type: "POST", //send it through get method
			  contentType : 'application/json; charset=utf-8',
			  dataType : 'json',
			  data: JSON.stringify(
					  	{
							description: document.getElementById("description").value,	  		
							quantity: document.getElementById("quantity").value,
							price: document.getElementById("price").value,
							brand: document.getElementById("brand").value,
							//pictureUrl: document.getElementById("picture_url").value,
							subCategory: document.getElementById("sub_category").value,
							//subSubCategory: document.getElementById("sub_sub_category").value
					  	}			  
			  ),
			  success: function(response) {
				  	var responseData = response;
				  	document.getElementById("descriptionError").innerHTML="";
					document.getElementById("quantityError").innerHTML="";
					document.getElementById("priceError").innerHTML="";
					document.getElementById("brandError").innerHTML="";
					//document.getElementById("urlError").innerHTML="";
					document.getElementById("subCategoryError").innerHTML="";
					document.getElementById("status").innerHTML="";
				  	
				  if(!responseData.error){
					  	document.getElementById("status").innerHTML="Добавянето на продукт е успешно!!! Продуктът е с номер " + response.productId;
					  	document.getElementById("description").value="";	  		
						document.getElementById("quantity").value="";
						document.getElementById("price").value="";
						document.getElementById("brand").value="";
						//document.getElementById("picture_url").value="";
						document.getElementById("sub_category").value="";
						//document.getElementById("sub_sub_category").value="";
				  }
				  else{
					  var errors = responseData.errors;
					  
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
  
    </body>
</html>