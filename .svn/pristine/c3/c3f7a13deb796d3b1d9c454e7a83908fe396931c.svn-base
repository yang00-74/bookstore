<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<div style="text-align:center">
           <h1>网上书店</h1>
           
           
        <div style="margin-left:50%; float:left">
        
        <a href="${pageContext.request.contextPath }/index.jsp">首页</a>
            <a href="${pageContext.request.contextPath }/client/listcart.jsp" >查看购物车</a>
            <a href="${pageContext.request.contextPath }/manager/listorder.jsp" >查看订单</a>
            
        </div>
        
        <div style="float:right;">
         <c:if test="${user==null}">
              <form action="/BookStore/LoginServlet" method="post">
                        用户名：<input type="text" name="username" style="width:100px"/>
                         密码   ： <input type="password" name="password" style="width:100px"/>   
                <input type="submit" value="登录">
                <input type="button" value="注册" onclick="location.href='/BookStore/client/register.jsp'"> 
              </form>
            </c:if>
             <c:if test="${user!=null}">
                              欢迎你：${user.username}
             </c:if>
          </div>
        <div style="clear:both"></div> 
 </div>     
<hr>