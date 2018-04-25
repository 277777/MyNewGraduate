package com.Graduate.Dao.Impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.MultipleDao;
import com.Graduate.Po.Friend;
import com.Graduate.Po.Multiple;
import com.Graduate.Po.User;

public class MultipleDaoImpl implements MultipleDao {

	public SqlSession session;
	public User user = new User();
	
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
	public List<Map<Integer, String>> ShowStatus(Friend friend) throws Exception {
		session = GetXML();
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();  
		List<User> listuser = session.selectList("MultipleDB.ShowStatus", friend);
		session.close();
		//System.out.println("长度："+list.size()+"内容名字："+listuser.get(0).getUserimg());
		for(int i=0;i<listuser.size();i++) {
			Map<Integer,String> map = new HashMap<Integer,String>();
			map.put(1, ""+listuser.get(i).getUserid());
			map.put(2, listuser.get(i).getUsername());
			list.add(map);
		}
		return list;
	}

	@Override
	public List<Map<Integer, String>> ShowFriend(Friend friend) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		List<Map<Integer, String>> list = new ArrayList<Map<Integer,String>>();  
		List<User> listuser = session.selectList("MultipleDB.ShowFriend", friend);
		session.close();
		//System.out.println("长度："+list.size()+"内容名字："+listuser.get(0).getUserimg());
		for(int i=0;i<listuser.size();i++) {
			Map<Integer,String> map = new HashMap<Integer,String>();
			map.put(1, ""+listuser.get(i).getUserid());
			map.put(2, listuser.get(i).getUsername());
			list.add(map);
		}
		return list;
	}

	@Override
	public List<Map<Integer, String>> ShowMessage(User user) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		List<Map<Integer, String>> list = new ArrayList<Map<Integer,String>>();  
		List<Multiple> listuser = session.selectList("MultipleDB.ShowMessage", user);
		session.close();
		//System.out.println("长度："+list.size()+"内容名字："+listuser.get(0).getUserimg());
		for(int i=0;i<listuser.size();i++) {
			Map<Integer,String> map = new HashMap<Integer,String>();
			map.put(1, listuser.get(i).getUsername());
			map.put(2, listuser.get(i).getMsgtext());
			map.put(3, listuser.get(i).getMsgtime().toString());
			list.add(map);
		}
		return list;
	}

}
