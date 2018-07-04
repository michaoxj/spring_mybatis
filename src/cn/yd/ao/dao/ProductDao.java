package cn.yd.ao.dao;

import java.awt.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.yd.oa.model.Product;


public interface ProductDao {
	
	/* <mapper namespace="cn.yd.oa.dao.ProductDao">
    <!-- parameterType: ָ������Ķ������� -->
    <insert id="save" parameterType="cn.yd.oa.model.Product">
        <!-- #{name} ����name˽��,��������ͨ��getName������ȡ -->
    	insert into product (name,price,remark) values (#{name},#{price},#{remark})
    </insert>
 </mapper>
 * 
 * 
 * */
	
	public void save(Product product);
	
	public void update(Product product);
	
	public void delete(Integer id);
	
	public ArrayList<Product> queryByName(String keyword);
	
	public Product getById(Integer id);
	
	
}
