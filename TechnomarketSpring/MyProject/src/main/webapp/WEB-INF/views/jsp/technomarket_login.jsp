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
            <form action="http://localhost:8080/MyProject/user/login" method="post" class="fos_user_registration_register form-horizontal"><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_first_name">
                     E-mail
                                            <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="text" id="fos_user_registration_form_first_name" name="email" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="myspan" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_last_name">
                    Парола
                                            <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="password" id="fos_user_registration_form_last_name" name="password" required="required" pattern=".{2,}" class="form-control" /><span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_email">
        			<a href = "http://localhost:8080/MyProject/forgotPass/forgotPassSend">Забравена парола?</a>
                    <div class="col-sm-offset-6 col-sm-10">
                         <input class="btn btn-tm" type="submit" value="Вход" />
                    </div>
                </div>      
            </form>
        </div>
        <div class="col-half">
            <h2>Нямаш профил?</h2>
            <a href="http://localhost:8080/MyProject/html/technomarket_register.html" class="btn btn-tm">Регистрирай се</a>
            <hr>
                                                        </div>
    </div>
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>