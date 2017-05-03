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
            <h2>Регистрация</h2>
            <div class="fos_user_registration_register form-horizontal"><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_first_name">
                    Име
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="text" id="name" name="name" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="nameError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_last_name">
                    Фамилия							
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="text" id="familyName" name="familyName" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="familyNameError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_email">
                    E-mail
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="email" id="email" name="email" required="required" class="form-control" />
                                            	<span id="emailError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_first">
                    Парола
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="password" id="passwordFirst" name="passwordFirst" required="required" class="form-control" />
                                            	<span id="passwordFirstError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_second">
                    Парола (отново)
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar">
                                            <input type="password" id="passwordSecond" name="passwordSecond" required="required" class="form-control" />
                                            	<span id="passwordSecondError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    Пол
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><div class="control-group"><label class="required radio-inline">
                                            <input type="radio" id="fos_user_registration_form_sex_0" name="sex" required="required" value="1" />Мъж</label><label class="required radio-inline">
                                            <input type="radio" id="fos_user_registration_form_sex_1" name="sex" required="required" value="2" />Жена</label></div>
                                            	<span id="sexError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                                            
                    <div class="col-sm-offset-6 col-sm-10">
                         <button  class="btn btn-tm" id="btn">Добави</button>
                    </div>
                </div>
                <h2 id="status"></h2>      
            </div>
        </div>
        <div class="col-half">
            <h2>Имаш профил?</h2>
            <a href="http://localhost:8080/TechnomarketSpring/user/loginPage" class="btn btn-tm">Вход в сайта</a>
            <hr>
                                                        </div>
    </div>
</div>    </div>
</section>    
        </div>
        <footer>
    
     <%@ include file="/menu_krai.jsp" %>
        
        
        
        
        
        
        
        
        
        
        <script>
        var btn = document.getElementById("btn"); 
    	btn.addEventListener("click", function() {
    		$.ajax({
    			  url: "/TechnomarketSpring/user/register",
    			  type: "POST", //send it through get method
    			  contentType : 'application/json; charset=utf-8',
    			  dataType : 'json',
    			  data: JSON.stringify(
    					  	{
    							name: document.getElementById("name").value,	  		
    							familyName: document.getElementById("familyName").value,
    							email: document.getElementById("email").value,
    							passwordFirst: document.getElementById("passwordFirst").value,
    							passwordSecond: document.getElementById("passwordSecond").value,
    							//pictureUrl: document.getElementById("picture_url").value,
    							sex: $('input:radio[name=sex]:checked').val(),
    							//subSubCategory: document.getElementById("sub_sub_category").value
    							//birthDate: document.getElementById("birthDate").value
    					  	}			  
    			  ),
    			  success: function(response) {
    				  	var responseData = response;
    				  	document.getElementById("nameError").innerHTML="";
    					document.getElementById("familyNameError").innerHTML="";
    					document.getElementById("emailError").innerHTML="";
    					document.getElementById("passwordFirstError").innerHTML="";
    					//document.getElementById("urlError").innerHTML="";
    					document.getElementById("passwordSecondError").innerHTML="";
    					document.getElementById("sexError").innerHTML="";
    					document.getElementById("status").innerHTML="";
    					//document.getElementById("dateError").innerHTML="";
    				  	
    				  if(!responseData.error){
    					  	document.getElementById("status").innerHTML="Вие се регистрирахте успешно";
    					  	document.getElementById("name").value="";	  		
    						document.getElementById("familyName").value="";
    						document.getElementById("email").value="";
    						document.getElementById("passwordFirst").value="";
    						document.getElementById("passwordSecond").value="";
    						//$('input:radio[name=sex]:checked').val()=0;
    						//document.getElementById("picture_url").value="";
    						//document.getElementById("sub_category").value="";
    						//document.getElementById("sub_sub_category").value="";
    						//document.getElementById("birthDate").value="";
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