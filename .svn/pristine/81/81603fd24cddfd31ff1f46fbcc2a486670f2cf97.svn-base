<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台左侧导航</title>
 <style type="text/css">
     .dc{
        display:block;
        margin-left:10px;
       }
       a{
           color:blue;
           text-decoration:none;
       }
 </style>
 <script language="javascript">
        function hidden(div){
        	div.style.display=(div.style.display=='none'?'block':'none');
        }
 </script>
</head>

<body>
   <ul>
     <li>
       <a href="javascript:void(0)" onclick="hidden(children[0])">分类管理
         <div class="dc">
               <a href="${pageContext.request.contextPath}/manager/addcategory.jsp" target="right">添加分类</a><br/>
                <a href="${pageContext.request.contextPath}/CategoryServlet?method=getAll" target="right">查看分类</a><br/>
         </div>
        </a>
       </li>
        <br/><br/> 
         <li>
       <a href="javascript:void(0)" onclick="hidden(children[0])">图书管理
         <div class="dc" id="d">
               <a  href="${pageContext.request.contextPath}/BookServlet?method=forAddUI" target="right">添加图书</a><br/>
                <a href="${pageContext.request.contextPath}/BookServlet?method=listBook" target="right">查看图书</a><br/>
         </div>
        </a>
       </li>
        <br/><br/>
          <li>
       <a href="javascript:void(0)" onclick="hidden(children[0])">订单管理
         <div class="dc">
               <a href="${pageContext.request.contextPath}/OrderServlet1?method=getAll&state=false" target="right">待处理订单</a><br/>
                <a href="${pageContext.request.contextPath}/OrderServlet1?method=getAll&state=true" target="right">已发货订单</a><br/>
         </div>
        </a>
       </li>
        <br/><br/>
      </ul>
</body>
</html>