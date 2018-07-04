package cn.yd.oa.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

@Component(value="p")// 此类应该交给spring管理,前端是通过url地址访问而非id因此可以不用指定名称
@RequestMapping("/product") // 访问当前controller的地址   /工程名/product
public class ProductController {
	
	// MVC支持把request session application自动注入到Controller中
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	
	
	// 如果采用注解的方式,则不需要写set方法
	@Resource(name="ps")   // <bean id="ps" class="cn.yd.oa.service.ProductService">
	private ProductService productService;
	
	// jsp --> controller --> service --> productDao --> jdbcTemplate --> dataSource --> db
	
	// servlet只提供 doget/dopost,而controller为每个请求都指定方法
	// mvc支持自动赋值(前端文本框的 name属性与Product属性匹配)
	// <input type="text" name="price" /> ===> Product的price
	@RequestMapping("/save")    // /工程名/product/save.mvc(mvc在web.xml配置约定)
	public String save(Product product) {
		// 1: 获取前端请求数据(mvc已完成)
		// 2: 调用业务逻辑
		productService.save(product);
		// 3: 返回结果页面(此处跳转到查询页面,当前controller与query.jsp没有数据交互因此采用重定向)
		return "redirect:/query.jsp";  // mvc无论是转发还是重定向都默认添加工程名
	}
	@RequestMapping("/query")
	public String queryByName(String keyword) {
		// 调用业务逻辑
		ArrayList<Product> proList = productService.queryByName(keyword);
		request.setAttribute("proList", proList);
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
	}
	@RequestMapping("/delete")
	public String delete(Integer id) {
		// 调用业务逻辑
		productService.delete(id);
		String keyword = (String)session.getAttribute("keyword");
		request.setAttribute("proList", productService.queryByName(keyword));
		return "forward:/query.jsp";
	}
	@RequestMapping("/getById")
	public String getById(Integer id) {
		// 调用业务逻辑
		Product product = productService.getById(id);
		request.setAttribute("product", product);
		// 跳转到update.jsp(此页面应该有默认值)
		return "forward:/update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/query.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
