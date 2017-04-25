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
            <h2>Премахване на промоция</h2>
            <form action="http://localhost:8080/TechnomarketSpring/admin/removePromotion"  method="POST" class="fos_user_registration_register form-horizontal"><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_first_name">
                    Артикулен номер
                                            <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="number" min = "0" id="fos_user_registration_form_first_name" name="artikulenNomer" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="myspan" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_last_name">
                     Въведи цена
                                            <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="number" min = "0" id="fos_user_registration_form_email" name="price" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_first">
                       <div class="col-sm-offset-6 col-sm-10">
                         <input class="btn btn-tm" type="submit" value="Премахни" />
                    </div>
                </div>      
            </form>
            <h1>${message}</h1>
        </div>
                <div class="col-half">

                                                        </div>
         <div class="col-half">
            
                                                        </div>

    </div>
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>