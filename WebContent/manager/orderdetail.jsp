<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页面</title>
<style type="text/css">
       a{
          text-decoration:none;
          color:blue;
       }
  </style>
</head>
<body style="text-align:center">
        <br/><br/>
        <table frame="border" cellpadding="0" width="90%">
             <caption><h2>订单信息</h2></caption>
             <tr>
               <td>书名</td>
                <td>售价</td>
                 <td>数量</td>
                 <td>应收款</td>
              </tr>
              
              <c:forEach var="orderitem" items="${order.orderitems}">
                 <tr>
                    <td>${orderitem.book.name}</td> 
                     <td>${orderitem.book.price}</td> 
                     <td>${orderitem.quantity}</td> 
                     <td>${orderitem.price}</td>

                   </tr>
               </c:forEach>
                  <tr>
			           
			           <td>合计</td>
			            <td></td>
			           <td></td>         
			             <td >${order.price}元</td>
			        </tr>
             </table>
             <br/><br/>
 <table frame="border" cellpadding="0" width="90%">
             <caption><h2>收货人信息</h2></caption>
             <tr>
               <td>用户</td>
                <td>电话</td>
                 <td>地址</td>
              </tr>
              
                 <tr>
                    <td>${order.user.username}</td> 
                     <td>${order.user.phone}</td> 
                     <td>${order.user.address}</td>
                   </tr>
             </table>            
             <br/>
              <a href="${pageContext.request.contextPath }/OrderServlet1?method=update&id=${order.id}">确认发货</a>
</body>
</html>