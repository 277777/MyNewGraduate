package com.Graduate.Dao.Impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.MessageDao;
import com.Graduate.Po.Message;

public class MessageDaoImpl implements MessageDao {
	
	private SqlSession session;

	@Override
	public SqlSession GetXML() throws Exception {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}

	@Override
	public int AddMessage(Message message) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		result = session.insert("MessageDB.AddMessage",message);
		session.commit();
		session.close();
		return result;
	}

}
