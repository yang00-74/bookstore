<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台图书信息页</title>
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
     <caption><h2>图书信息</h2></caption>
     <tr> 
         <td>书名</td>
         <td>作者</td>
         <td>描述</td>
         <td>图片</td>
         <td>操作</td>
      </tr> 
      <c:forEach var="book" items="${list}">
        <tr> 
         <td>${book.name}</td>
         <td>${book.author}</td>
         <td>${book.description}</td>
         <td><a href="${pageContext.servletContext.contextPath }/images/${book.image}">查看图片</a></td>
         <td>
              <a href="">修改</a>
               <a href="">删除</a>
         </td>
        </tr>    
       </c:forEach>
       </table>
              
</body>
</html>