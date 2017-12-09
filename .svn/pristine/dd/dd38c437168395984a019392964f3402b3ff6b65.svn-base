<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店首页</title>

 <style type="text/css">
       a{
          text-decoration:none;
          color:blue;
       }
 </style>
</head>
<body style="font-family: KaiTi;font-size:20px;">
    <div id="container">
          <div id="head">
               <%@include file= "/client/head.jsp"%>
          </div>
          
          <div id="main">
               <div style="line-height:45px;float:left;
                           font-size:25px;
                           margin-left:200px;
                           border:solid 1px blue;
                           width:200px;">
                                     分类列表：
                  <c:forEach var= "c" items="${categories }">
                          <li><a href="${pageContext.request.contextPath }/IndexServlet?category_id=${c.id}">${c.name}</a></li>
                  </c:forEach>
               </div>
               
               <div style="margin-left:20%; float:left;">
               
                     <c:forEach var="book" items="${pagebean.list}" varStatus="status">
                       <div style="float:left;">
                            <div style="float:left;">
                             <img src="${pageContext.request.contextPath }/images/${book.image}"></img>
                            </div>
                            <div style="float:left;">
                                  <li>${book.name }</li>
                                   <li>${book.author }</li>
                                    <li>${book.price }</li>
                                     <li>${book.description }</li>
                                     <li>
                                        <a href="${pageContext.request.contextPath }/BuyServlet?id=${book.id}">购买</a>
                                     </li>
                            </div>
                            <div style="clear:both"></div> 
                       </div>
                        <c:if test="${status.count%3==0}">
                             <div style="clear:both"></div> 
                        </c:if>
                     </c:forEach>
                      <div style="clear:both"></div> 
                      <br> 
                     
                     <div style="margin-top:300px;">
                                             总共${pagebean.totalpage}页
                                             当前 ${pagebean.currentpage}页  
                      <c:forEach var="pagenum" items="${pagebean.pagebar }">  
                            <a href="${pageContext.request.contextPath }/IndexServlet?currentpage=${pagenum}&category_id=${param.category_id}">${pagenum }</a>
                       </c:forEach>                    
                                                             
                     </div>
                     
               </div>
          </div>
     
    </div>  
</body>
</html>