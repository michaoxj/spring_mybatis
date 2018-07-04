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

@Component(value="p")// ����Ӧ�ý���spring����,ǰ����ͨ��url��ַ���ʶ���id��˿��Բ���ָ������
@RequestMapping("/product") // ���ʵ�ǰcontroller�ĵ�ַ   /������/product
public class ProductController {
	
	// MVC֧�ְ�request session application�Զ�ע�뵽Controller��
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	
	
	// �������ע��ķ�ʽ,����Ҫдset����
	@Resource(name="ps")   // <bean id="ps" class="cn.yd.oa.service.ProductService">
	private ProductService productService;
	
	// jsp --> controller --> service --> productDao --> jdbcTemplate --> dataSource --> db
	
	// servletֻ�ṩ doget/dopost,��controllerΪÿ������ָ������
	// mvc֧���Զ���ֵ(ǰ���ı���� name������Product����ƥ��)
	// <input type="text" name="price" /> ===> Product��price
	@RequestMapping("/save")    // /������/product/save.mvc(mvc��web.xml����Լ��)
	public String save(Product product) {
		// 1: ��ȡǰ����������(mvc�����)
		// 2: ����ҵ���߼�
		productService.save(product);
		// 3: ���ؽ��ҳ��(�˴���ת����ѯҳ��,��ǰcontroller��query.jspû�����ݽ�����˲����ض���)
		return "redirect:/query.jsp";  // mvc������ת�������ض���Ĭ����ӹ�����
	}
	@RequestMapping("/query")
	public String queryByName(String keyword) {
		// ����ҵ���߼�
		ArrayList<Product> proList = productService.queryByName(keyword);
		request.setAttribute("proList", proList);
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
	}
	@RequestMapping("/delete")
	public String delete(Integer id) {
		// ����ҵ���߼�
		productService.delete(id);
		String keyword = (String)session.getAttribute("keyword");
		request.setAttribute("proList", productService.queryByName(keyword));
		return "forward:/query.jsp";
	}
	@RequestMapping("/getById")
	public String getById(Integer id) {
		// ����ҵ���߼�
		Product product = productService.getById(id);
		request.setAttribute("product", product);
		// ��ת��update.jsp(��ҳ��Ӧ����Ĭ��ֵ)
		return "forward:/update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/query.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
