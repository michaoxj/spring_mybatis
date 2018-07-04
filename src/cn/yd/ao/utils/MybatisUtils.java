package cn.yd.ao.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// jdbcUtils: ����mybatis.cfg.xml�����ļ�
// ��ȡconnection���ݿ�����
public class MybatisUtils {
	
	public static void main(String[] args) {
		System.out.println(MybatisUtils.getSqlSession().getConnection());
		System.out.println(MybatisUtils.getSqlSession().getConnection());
	}
	
	// mybatis�� sqlsession������ǰconnection
	private static SqlSessionFactory sf;

	// �����ļ�ֻ����һ��,��ʹ�þ�̬�����,�����web��Ŀ��,�����ļ�������
	// web.xml�ж�����������ʱ�����,�Ҽ���һ��
static {
	System.out.println("1:");
	// ͨ��java�ļ�����ȡ�����ļ�
	InputStream in =  MybatisUtils.class.getResourceAsStream("/mybatis.cfg.xml");
	sf = new SqlSessionFactoryBuilder().build(in);
}
	
	// ��дһ������sqlSession/connection�ķ���
	public static SqlSession getSqlSession() {
		System.out.println("2:");
		return sf.openSession();
	}
	
	
	
	
	
}
