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
            <form action="http://localhost:8080/MyProject/product/addProduct"  method="GET" class="fos_user_registration_register form-horizontal"><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_first_name">
                    Описание
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><input type="text" id="fos_user_registration_form_first_name" name="fos_user_registration_form[first_name]" required="required" pattern=".{2,}" class="form-control" />
                                            	<span id="myspan" class="help-block"><ul class="list-unstyled"><li><span class="glyphicon glyphicon-exclamation-sign"></span> </li></ul></span>
                                            <span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_last_name">
                    Количество
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><input type="number" min = "0" id="fos_user_registration_form_last_name" name="fos_user_registration_form[last_name]" required="required" pattern=".{2,}" class="form-control" /><span class="bar"></span></div></div>
                <div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_email">
                    Цена
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><input type="number" min = "0" id="fos_user_registration_form_email" name="fos_user_registration_form[email]" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_first">
                    Марка
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><input type="text" id="fos_user_registration_form_plainPassword_first" name="fos_user_registration_form[plainPassword][first]" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required" for="fos_user_registration_form_plainPassword_second">
                    Категория
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><input type="text" id="fos_user_registration_form_plainPassword_second" name="fos_user_registration_form[plainPassword][second]" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    ПодКатегория
                   							 <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><input type="text" id="fos_user_registration_form_plainPassword_second" name="fos_user_registration_form[plainPassword][second]" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    ПодПодКатегория
                						    <span class="required" title="This field is required"></span></label><div class="col-sm-10 control-bar"><input type="text" id="fos_user_registration_form_plainPassword_second" name="fos_user_registration_form[plainPassword][second]" required="required" class="form-control" /><span class="bar"></span></div></div><div class="form-group"><label  class="col-sm-6 control-label required">
                    <div class="col-sm-offset-6 col-sm-10">
                         <input class="btn btn-tm" type="submit" value="Добави" />
                    </div>
                </div>      
            </form>
        </div>
                <div class="col-half">
            <h2>Качи снимка: </h2>
            <a href="" class="btn btn-tm">Избери</a>
            <hr>
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