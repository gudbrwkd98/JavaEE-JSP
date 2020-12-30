package com.webapp1216prac.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.webapp1216prac.board.mybatis.config.MybatisConfigManager;

public class NoticeDAO {
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		List list = null;
		
		SqlSession sqlsession = manager.getSqlSession();
		list = sqlsession.selectList("Notice.selectAll");
		manager.close(sqlsession);
		return list;
	}
}
