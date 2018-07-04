package cn.yd.ao.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// jdbcUtils: 加载mybatis.cfg.xml配置文件
// 获取connection数据库连接
public class MybatisUtils {
	
	public static void main(String[] args) {
		System.out.println(MybatisUtils.getSqlSession().getConnection());
		System.out.println(MybatisUtils.getSqlSession().getConnection());
	}
	
	// mybatis中 sqlsession就是以前connection
	private static SqlSessionFactory sf;

	// 配置文件只加载一次,则使用静态代码块,如果在web项目中,配置文件都放在
	// web.xml中而且在启动的时候加载,且加载一次
static {
	System.out.println("1:");
	// 通过java文件流读取配置文件
	InputStream in =  MybatisUtils.class.getResourceAsStream("/mybatis.cfg.xml");
	sf = new SqlSessionFactoryBuilder().build(in);
}
	
	// 编写一个返回sqlSession/connection的方法
	public static SqlSession getSqlSession() {
		System.out.println("2:");
		return sf.openSession();
	}
	
	
	
	
	
}
