/*
 *mybatis �� config.xml�� xml �ϻ� ���� �������� �ڹ� ���ø����̼ǰ��� ������� �����̴�.
 *���� �ڹ��ڵ忡�� config.xml ���о���Ѵ�  
 *������ǥ : xml �� �鿩�� ���� �������� �������ִ� ��ü�� SqlSession ��� ���� 
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
	private static MybatisConfigManager instance;//������
	
	
	
	
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
			instance = new MybatisConfigManager(); //�ƹ��� private �̶� ���� �����ڴ� ���� ȣ�Ⱑ��
		}
		return instance;
	}
	//sqlSession �� ��ȯ�ϴ� �޼��� 
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