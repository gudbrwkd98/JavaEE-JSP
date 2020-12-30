package com.web2.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
	private static MybatisConfigManager instance;
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory ;
	
	public static MybatisConfigManager getInstance() {
		
		if(instance ==null) {
			instance= new MybatisConfigManager();
		}
		
		return instance;
	}

	private MybatisConfigManager() {
		String resource = "com/web2/mybatis/config/config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		sqlSession = sqlSessionFactory.openSession();
	
		return sqlSession;
	}
	
	public void close(SqlSession sqlSession) {
		sqlSession.close();
	}
	
}
