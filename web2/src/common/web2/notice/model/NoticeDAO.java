package common.web2.notice.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web2.mybatis.config.MybatisConfigManager;

public class NoticeDAO {
	
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("Notice.selectAll");
		manager.close(sqlSession);
		
		return list;
	}
	
}
