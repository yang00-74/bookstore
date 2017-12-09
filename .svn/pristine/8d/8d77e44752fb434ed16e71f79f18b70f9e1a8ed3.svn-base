<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类列表</title>
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
             <caption><h2>书籍分类</h2></caption>
             <tr>
               <td>分类名称</td>
                <td>描述</td>
                 <td>操作</td>
              </tr>
              
              <c:forEach var="category" items="${categories}">
                 <tr>
                    <td>${category.name}</td> 
                     <td>${category.description}</td> 
                    <td>
                       <a href="">修改</a>
                       <a href="">删除</a>
                      </td>
                   </tr>
               </c:forEach>
             </table>
</body>
</html>