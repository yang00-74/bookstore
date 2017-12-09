<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
<style type="text/css">
       a{
          text-decoration:none;
          color:blue;
       }
  </style>
</head>

<body style="text-align:center;
             font-size:20px;
             font-family:KaiTi;">
          <%@include file= "/client/head.jsp"%>
        <br/><br/>
   <table style="margin-left:200px" frame="border" cellpadding="0" width="60%">
       
        <caption><h2>购物车页面</h2></caption>
        <tr>
            <td>书名</td>
             <td>售价</td>
              <td>数量</td>
               <td>小计</td>
        </tr>
        <c:forEach var="entry" items="${cart.map}">
             <tr> 
                <td>${entry.value.book.name}</td>
                <td>${entry.value.book.price}</td>
                <td>${entry.value.quantity}</td>
                <td>${entry.value.price}元</td>
             </tr>
        </c:forEach>
        <tr>
          
           <td>合计</td>
            <td></td>
           <td></td>         
             <td >${cart.price}元</td>
        </tr>
     </table>
       <div style="margin-top:50px;">
       <a href="${pageContext.request.contextPath }/OrderServlet">确认订单</a>
     </div>
</body>
</html>