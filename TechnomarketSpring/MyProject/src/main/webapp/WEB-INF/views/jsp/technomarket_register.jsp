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
                    Дата на раждане
                                            <span class="required" title="This field is required">*</span></label><div class="col-sm-10 control-bar"><div id="fos_user_registration_form_birthday" class="form-inline"><select id="fos_user_registration_form_birthday_day" name="fos_user_registration_form[birthday][day]" required="required" class="form-control"><option value="" selected="selected">ден</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option></select><select id="fos_user_registration_form_birthday_month" name="fos_user_registration_form[birthday][month]" required="required" class="form-control"><option value="" selected="selected">месец</option><option value="1">01</option><option value="2">02</option><option value="3">03</option><option value="4">04</option><option value="5">05</option><option value="6">06</option><option value="7">07</option><option value="8">08</option><option value="9">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select><select id="fos_user_registration_form_birthday_year" name="fos_user_registration_form[birthday][year]" required="required" class="form-control"><option value="" selected="selected">година</option><option value="1897">1897</option><option value="1898">1898</option><option value="1899">1899</option><option value="1900">1900</option><option value="1901">1901</option><option value="1902">1902</option><option value="1903">1903</option><option value="1904">1904</option><option value="1905">1905</option><option value="1906">1906</option><option value="1907">1907</option><option value="1908">1908</option><option value="1909">1909</option><option value="1910">1910</option><option value="1911">1911</option><option value="1912">1912</option><option value="1913">1913</option><option value="1914">1914</option><option value="1915">1915</option><option value="1916">1916</option><option value="1917">1917</option><option value="1918">1918</option><option value="1919">1919</option><option value="1920">1920</option><option value="1921">1921</option><option value="1922">1922</option><option value="1923">1923</option><option value="1924">1924</option><option value="1925">1925</option><option value="1926">1926</option><option value="1927">1927</option><option value="1928">1928</option><option value="1929">1929</option><option value="1930">1930</option><option value="1931">1931</option><option value="1932">1932</option><option value="1933">1933</option><option value="1934">1934</option><option value="1935">1935</option><option value="1936">1936</option><option value="1937">1937</option><option value="1938">1938</option><option value="1939">1939</option><option value="1940">1940</option><option value="1941">1941</option><option value="1942">1942</option><option value="1943">1943</option><option value="1944">1944</option><option value="1945">1945</option><option value="1946">1946</option><option value="1947">1947</option><option value="1948">1948</option><option value="1949">1949</option><option value="1950">1950</option><option value="1951">1951</option><option value="1952">1952</option><option value="1953">1953</option><option value="1954">1954</option><option value="1955">1955</option><option value="1956">1956</option><option value="1957">1957</option><option value="1958">1958</option><option value="1959">1959</option><option value="1960">1960</option><option value="1961">1961</option><option value="1962">1962</option><option value="1963">1963</option><option value="1964">1964</option><option value="1965">1965</option><option value="1966">1966</option><option value="1967">1967</option><option value="1968">1968</option><option value="1969">1969</option><option value="1970">1970</option><option value="1971">1971</option><option value="1972">1972</option><option value="1973">1973</option><option value="1974">1974</option><option value="1975">1975</option><option value="1976">1976</option><option value="1977">1977</option><option value="1978">1978</option><option value="1979">1979</option><option value="1980">1980</option><option value="1981">1981</option><option value="1982">1982</option><option value="1983">1983</option><option value="1984">1984</option><option value="1985">1985</option><option value="1986">1986</option><option value="1987">1987</option><option value="1988">1988</option><option value="1989">1989</option><option value="1990">1990</option><option value="1991">1991</option><option value="1992">1992</option><option value="1993">1993</option><option value="1994">1994</option><option value="1995">1995</option><option value="1996">1996</option><option value="1997">1997</option><option value="1998">1998</option><option value="1999">1999</option><option value="2000">2000</option><option value="2001">2001</option><option value="2002">2002</option><option value="2003">2003</option><option value="2004">2004</option><option value="2005">2005</option><option value="2006">2006</option><option value="2007">2007</option><option value="2008">2008</option><option value="2009">2009</option><option value="2010">2010</option><option value="2011">2011</option><option value="2012">2012</option><option value="2013">2013</option><option value="2014">2014</option><option value="2015">2015</option><option value="2016">2016</option><option value="2017">2017</option></select></div><span class="bar"></span></div></div><div class="form-group"><div class="col-sm-6"></div><div class="col-sm-10"><div class="checkbox"><label class="required"><input type="checkbox" id="fos_user_registration_form_subscribe" name="fos_user_registration_form[subscribe]" required="required" value="1" />Искам да получавам информация за промоции и нови продукти.</label></div></div></div><div class="form-group"><div class="col-sm-6"></div><div class="col-sm-10"><input type="checkbox" id="fos_user_registration_form_accept_terms" name="fos_user_registration_form[accept_terms]" required="required" value="1" /><a href="/uslovia-za-online-pazaruvane" target="_blank" class="color-inherit">Приемам условията за ползване</a></div></div><input type="hidden" id="fos_user_registration_form__token" name="fos_user_registration_form[_token]" class="form-control" value="QELEjmkCqek7doFbSVGnQGNNdJekaTUZVPziZdl4nOc" /><div class="form-group">
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