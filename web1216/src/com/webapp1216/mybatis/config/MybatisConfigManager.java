/*
 *mybatis 의 config.xml은 xml 일뿐 현재 실행중인 자바 어플리케이션과는 상관없는 상태이다.
 *따라서 자바코드에서 config.xml 을읽어야한다  
 *최종목표 : xml 을 들여서 실제 쿼리문을 수행해주는 객체인 SqlSession 얻기 위함 
 * */

package com.webapp1216.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
	String resource = "com/webapp1216/mybatis/config/config.xml";
	SqlSessionFactory sqlSessionFactory;
	InputStream inputStream;
	private static MybatisConfigManager instance;//전세계
	
	
	
	
	private MybatisConfigManager() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static MybatisConfigManager getInstance() {
		if(instance ==null) {
			instance = new MybatisConfigManager(); //아무리 private 이라도 나의 생성자는 내가 호출가능
		}
		return instance;
	}
	//sqlSession 을 반환하는 메서드 
	public SqlSession getSqlSession() {
		SqlSession sqlsession = null;
		sqlsession = sqlSessionFactory.openSession();
		
		return sqlsession;
	}
	
	public void close(SqlSession sqlSession) {
		if(sqlSession !=null) {	
		sqlSession.close();
		}
	}
	
	
}
