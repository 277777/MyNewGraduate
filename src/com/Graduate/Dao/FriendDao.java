package com.Graduate.Dao;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.Friend;

public interface FriendDao {

	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	//添加好友-insert-user
	public int AddFriend(Friend friend) throws Exception;
	
	//根据名字查询-select-user;
	public Friend ShowFriend(String username) throws Exception;
	
	//更新申请-update-friend
	public int UpdateFriend(Friend friend) throws Exception;
	
	//
	public Friend ShowExit(Friend friend) throws Exception;
	
	
}
