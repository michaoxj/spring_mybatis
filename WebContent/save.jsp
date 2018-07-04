<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
  
</head>
<body>
    <!-- java代码声明,在Jsp有3大内置对象用来存储数据: request  session application 
        
           1: 存储到application对象中的数据与项目的生命周期相同,如果项目重启则app数据将会消失
                application可以存储系统公共的数据(类似内存的一个缓存区域)
           2： session(会话,每个用户都有独立的区域,但是只要会话结束则session消失)
                                会话结束两种情况: 默认情况下30分钟没有与服务器交互, 2: 浏览器关闭
           3: request: 代表的是用户与服务器端的一次请求.每次请求都会产生一个request对象
                               如果当前用户产生一个新request对象,则原来的request将会自动销毁
    -->
    <a href="query.jsp">query.jsp</a>

   <!-- 发送的是http请求,ProductService是不能够识别,需要一个中介Servlet -->
   <!-- 在项目中所有的请求都要从工程名开始,请修改成自己工程名 -->
   <form action="${pageContext.request.contextPath}/product/save.mvc" method="post">
      <!--  ctrl + atl + 下方向键 -->
           商品名:<input type="text" name="name" /><br/>
            价格:<input type="text" name="price" /><br/>
            备注:<input type="text" name="remark" /><br/>
       <input type="submit" value="提交" />
   </form>
</body>
</html>





