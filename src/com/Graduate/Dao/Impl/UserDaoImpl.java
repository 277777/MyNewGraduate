package com.Graduate.Dao.Impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Graduate.Dao.UserDao;
import com.Graduate.Po.User;

public class UserDaoImpl implements UserDao {

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
	public int Register(User user) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		System.out.println(user.getUsername());
		result = session.insert("UserDB.Register", user);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public User findUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		user = session.selectOne("UserDB.findUserName", username);
		session.close();
		return user;
	}

	@Override
	public int UpdatePassword(User user) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		System.out.println(user.getUsername());
		result = session.update("UserDB.UpdatePassword", user);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public User findUserAll(User user) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		user = session.selectOne("UserDB.findUserAll", user);
		session.close();
		return user;
	}

	@Override
	public String SendUser(User user) {
		String string = null;
		if (user.getUserimg().equals("default"))
			string = user.getUserid() + "#" + user.getUsername() + "#" + user.getUserpwd() + "#" + user.getUserimg();
		else {
			String path="/MyNewGraduate/Image/"+user.getUsername()+"/touxiang.png";
			string = user.getUserid() + "#" + user.getUsername() + "#" + user.getUserpwd() + "#" + path;
		}
		return string;
	}

	@Override
	public int UpdateImage(User user) throws Exception {
		// TODO Auto-generated method stub
		session = GetXML();
		int result = 0;
		System.out.println(user.getUsername());
		System.out.println(user.getUserimg());
		result = session.update("UserDB.UpdateImage", user);
		session.commit();
		session.close();
		return result;
	}

}
