package mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
	private static MybatisConfigManager instance;
	
	String resource = "mybatis/config/config.xml";
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfigManager() {

		try {
			inputStream  = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//�����ڸ� ���ұ� ������ ���� �� �޼��忡 ���ؼ��� �ν��Ͻ��� ���� �ֵ��� ��������!!
	public static MybatisConfigManager getInstance() {
		if(instance==null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}
	
	//sqlsession�� ��ȯ�ϴ� �޼���
	public SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	//sqlsession�� �ݴ¸޼���
	public void close(SqlSession sqlSession) {
		sqlSession.close();
	}
}
