<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
  
</head>
<body>
   <!--
    request.setAttribute("product", product); -->
   
   <form action="${pageContext.request.contextPath}/product/update.mvc" method="post">
      <!--  ctrl + atl + 下方向键 -->
           商品名:<input type="text" name="name" value="${requestScope.product.name}" /><br/>
            价格:<input type="text" name="price" value="${requestScope.product.price}" /><br/>
            备注:<input type="text" name="remark" value="${requestScope.product.remark}" /><br/>
       <input type="submit" value="更新" />
       <input type="hidden" name="id" value="${requestScope.product.id}" />
   </form>
</body>
</html>





