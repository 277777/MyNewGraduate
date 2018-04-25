package com.Graduate.Dao;

import org.apache.ibatis.session.SqlSession;

import com.Graduate.Po.User;


public interface UserDao {
	
	//获取UserDB.xml
	public SqlSession GetXML() throws Exception;
	
	//注册-insert-user
	public int Register(User user) throws Exception;
	
	//根据名字查询-select-user;
	public User findUserName(String username) throws Exception;
	
	//更新密码-update-user
	public int UpdatePassword(User user) throws Exception;
	
	//查询所有用户信息-select -user
	public User findUserAll(User user) throws Exception;
	
	//整理字符串
	public String SendUser(User user);
	
	//更新头像-update-user
	public int UpdateImage(User user) throws Exception;
}
