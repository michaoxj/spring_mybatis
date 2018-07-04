package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

// 此类主要是用来实现业务逻辑
public class ProductService {
	
	private ProductDao productDao = null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void save(Product product) {
		// 此处用来实现业务逻辑代码,例如添加商品
		productDao.save(product);
		// 添加日志
	}
	
	public void update(Product product) {
		productDao.update(product);
	}
	
	public Product getById(Integer id) {
		return productDao.getById(id);
	}
	
	public ArrayList<Product> queryByName(String keyword){
		return productDao.queryByName("%" + keyword + "%");
	}
	
	public void delete(Integer id) {
		productDao.delete(id);
	}
}
