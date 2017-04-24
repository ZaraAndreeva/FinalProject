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

	  <c:if test="${UserDAO.getInstance().getAllUsers().get(sessionScope.user.email).getOrders() == null}">
	 	<h1>Няма налични поръчки.</h1>
	 </c:if>
	 <c:if test="${UserDAO.getInstance().getAllUsers().get(sessionScope.user.email).getOrders() != null}">
	 	<h3>Поръчки</h3>
	 	<c:forEach items="${list}" var="item">
   			
		</c:forEach>
	 </c:if>
</div>    </div>
</section>    
        </div>
        <footer>
        
  <%@ include file="/menu_krai.jsp" %>
  
    </body>
</html>