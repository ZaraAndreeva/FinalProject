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
            <h2>Вход</h2>
            <div  class="fos_user_registration_register form-horizontal"><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_first_name">
                     E-mail
                                            <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="text" id="email" name="email" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="emailError" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_last_name">
                    Парола
                                            <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="password" id="password" name="password" required="required" pattern=".{2,}" class="form-control" />
                                            <span id="emailError" class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_email">
                <!-- 
        			<a href = "http://localhost:8080/TechnomarketSpring/forgotPass/forgotPassSend">Забравена парола?</a>
        			 -->
                    <div class="col-sm-offset-6 col-sm-10">
                         <input id = "btn" class="btn btn-tm" type="submit" value="Вход" />
                    </div>
                </div>      
            </div>
            <h3>${message}</h3>
            
        </div>
        <div class="col-half">
            <h2>Нямаш профил?</h2>
            <a href="/TechnomarketSpring/user/registerPage" class="btn btn-tm">Регистрирай се</a>
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
    			  url: "/TechnomarketSpring/user/login",
    			  type: "POST", //send it through get method
    			  contentType : 'application/json; charset=utf-8',
    			  dataType : 'json',
    			  data: JSON.stringify(
    					  	{
    							email: document.getElementById("email").value,
    							password: document.getElementById("password").value,
    					  	}			  
    			  ),
    			  success: function(response) {
    				  	var responseData = response;
    					document.getElementById("emailError").innerHTML="";
    					document.getElementById("emailError").innerHTML="";
    				  	
    				  if(!responseData.error){
    					  	window.location.href = "/TechnomarketSpring/";
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
        
  
  
  
  
    </body>
</html>