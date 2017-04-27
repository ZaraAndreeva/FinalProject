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

	 	<h3>Поръчки</h3>
	 	
	  	



		<!--  	
	 	<div id="contentholder" class="contentholder">
        <section>
    <div class="container">
        <div class="page-title sh-heading">
        
        </div>
        <div class="row">

            <div class="col-md-13">
                    <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Дата</th>
                        <th>Статус</th>
                        <th>Сума</th>
                        <th align="right" class="text-right"></th>
                    </tr>
                </thead>
                <tbody>
                	<tr>
                        <td>1158433</td>
                        <td>26 април 2017 г., 3:32:51</td>
                        <td>Непотвърдена поръчка</td>
                        <td><var class="price xs"><span class="color-inherit">1739.<sup>00</sup>  <small>лв.</small></span></var></td>
                        <td align="right"><a href="http://localhost:8080/TechnomarketSpring/user/orderPage" class="btn btn-tm btn-xs">Виж поръчката <i class="icon-arrow-long-right"></i></a></td>
                    </tr>
                                        <tr>
                        <td>1154382</td>
                        <td>6 април 2017 г., 9:30:21</td>
                        <td>Непотвърдена поръчка</td>
                        <td><var class="price xs"><span class="color-inherit">698.<sup>00</sup>  <small>лв.</small></span></var></td>
                        <td align="right"><a href="http://localhost:8080/TechnomarketSpring/user/orderPage" class="btn btn-tm btn-xs">Виж поръчката <i class="icon-arrow-long-right"></i></a></td>
                    </tr>

                                    </tbody>
            </table>
            </div>
        </div>
    </div>
</section>
        </div>
	 	-->
   			
   			
   			
   			<div id="contentholder" class="contentholder">
        <section>
		   <div class="container">
		        <div class="page-title sh-heading">
		        
		        </div>
				        <div class="row">
				
				            <div class="col-md-13">
				                    <table class="table table-striped">
				                <thead>
				                    <tr>
				                        <th>#</th>
				                        <th>Дата</th>
				                        <th>Статус</th>
				                        <th>Сума</th>
				                        <th align="right" class="text-right"></th>
				                    </tr>
				                </thead>
				                <tbody>
				                	 <c:set var="cnt" scope="page" value="1"/>
				                     <c:forEach items="${orders}" var="order">
					                	<tr>
					                        <td>${cnt}</td>
					                        	<c:set var="cnt" value="${cnt+1}"/>
					                        <td>${order.date}</td>
					                        <td>${order.status}</td>
					                        <td><var class="price xs"><span class="color-inherit">${order.price}<sup>00</sup>  <small>лв.</small></span></var></td>
					                        <td align="right"><a href="/TechnomarketSpring/user/orderPage/${order.orderId}" class="btn btn-tm btn-xs">Виж поръчката <i class="icon-arrow-long-right"></i></a></td>
					                    </tr>
									</c:forEach>
				                    
				                </tbody>
				            </table>
				            </div>
				        </div>
				    </div>
		</section>
        </div>
   			
   			
   			
   			
   			
	
	 
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>