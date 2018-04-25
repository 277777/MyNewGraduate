package com.Graduate.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.Friend;
import com.Graduate.Po.User;

public interface MultipleDao {

	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	//
	public List<Map<Integer, String>> ShowStatus(Friend friend) throws Exception;
	
	//
	public List<Map<Integer, String>> ShowFriend(Friend friend) throws Exception;
	
	//
	public List<Map<Integer, String>> ShowMessage(User users) throws Exception;
	
}
