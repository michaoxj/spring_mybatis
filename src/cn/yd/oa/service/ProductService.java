package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

// ������Ҫ������ʵ��ҵ���߼�
public class ProductService {
	
	private ProductDao productDao = null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void save(Product product) {
		// �˴�����ʵ��ҵ���߼�����,���������Ʒ
		productDao.save(product);
		// �����־
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
