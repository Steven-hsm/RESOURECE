package com.hsm.app;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hsm.dao.UserDao;
import com.hsm.model.User;

public class HelloInter {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	//��������ʵ��ʱ�ͻ�ȡsql����
	static {
		try {
			reader = Resources.getResourceAsReader("Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����һ��sql�Ự����
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	public static void main(String[] args) {
		sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao iuser = sqlSession.getMapper(UserDao.class);
		User user = iuser.getUserByID(1);
		if(user!=null){
			String userInfo = "���֣�"+user.getName()+", �������ţ�"+user.getDept()+", ��ҳ��"+user.getWebsite();
			System.out.println(userInfo);
		}
	}
}
