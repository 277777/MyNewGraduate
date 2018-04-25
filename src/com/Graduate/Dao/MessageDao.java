package com.Graduate.Dao;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.Message;

public interface MessageDao {

	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	//添加好友-insert-user
	public int AddMessage(Message message) throws Exception;

}
