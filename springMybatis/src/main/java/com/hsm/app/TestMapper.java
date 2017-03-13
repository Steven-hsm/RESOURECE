package com.hsm.app;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.hsm.dao.UserDao;
import com.hsm.model.User;

public class TestMapper {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	
	
	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		//获取日志
		Logger log = Logger.getLogger(TestMapper.class);
		log.info("程序开始执行了!");
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			User user=userDao.getUser(1);
			log.debug("获取id=1的用户信息!");
			if(user!=null){
				log.debug("打印信息");
				String userInfo = "名字"+user.getName()+",所属部门"+user.getDept()+",主页"+user.getWebsite();
				System.out.println(userInfo);
			}
		} finally {
			session.close();
		}
	}
}
