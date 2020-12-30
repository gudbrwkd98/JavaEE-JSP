package com.webapp1216prac.board.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
		String resource = "com/webapp1216prac/board/mybatis/config/config.xml";
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory;
		private static MybatisConfigManager instance;
		
	private MybatisConfigManager() {

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static MybatisConfigManager getInstance() {
		if(instance ==  null) {
			instance = new MybatisConfigManager(); //private 이라도 자기 자신을 부를수는있다..
		}
		
		return instance;
	}
	
	
	public SqlSession getSqlSession() {
		SqlSession sqlsession = null;
		sqlsession = sqlSessionFactory.openSession();
		
		return sqlsession;
	}
	
	public void close(SqlSession sqlsession) {
		if(sqlsession !=null) {
			sqlsession.close();
		}
	}
	
}
