package com.Graduate.Dao.Impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.FriendDao;
import com.Graduate.Po.Friend;

public class FriendDaoImpl implements FriendDao {

	public SqlSession session;
	
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
	public int AddFriend(Friend friend) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		result = session.insert("FriendDB.AddFriend",friend);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Friend ShowFriend(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int UpdateFriend(Friend friend) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		result = session.update("FriendDB.UpdateFriend", friend);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public Friend ShowExit(Friend friend) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		friend = session.selectOne("FriendDB.ShowExit", friend);
		session.close();
		return friend;
	}

}
