package com.Graduate.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.FriendDaoImpl;
import com.Graduate.Po.Friend;
import com.Graduate.Tools.Constant;

/**
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int userid;
	private int user_friend_id;
	private Friend friend = new Friend();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		userid = Integer.valueOf(request.getParameter("Userid"));
		user_friend_id = Integer.valueOf(request.getParameter("User_friend_id"));
		System.out.println(user_friend_id+user_friend_id);
		friend.setUserid(userid);
		friend.setUser_friend_id(user_friend_id);
		friend.setStatus(0);
		try {
			Friend ef = new Friend();
			ef.setUserid(userid);
			ef.setUser_friend_id(user_friend_id);
			ef = new FriendDaoImpl().ShowExit(ef);
			if(ef!=null) {
				if(ef.getStatus()==0)
					response.getWriter().print(Constant.SUCCESSFUL);
				else if(ef.getStatus()==1)
					response.getWriter().print(Constant.EXITFRIEND);
				else if(ef.getStatus()==2) {
					int result = new FriendDaoImpl().AddFriend(friend);
					if(result==1)
						response.getWriter().print(Constant.SUCCESSFUL);
					else 
						response.getWriter().print(Constant.DEFEATE);
				}
			}
			else {
				int result = new FriendDaoImpl().AddFriend(friend);
				if(result==1)
					response.getWriter().print(Constant.SUCCESSFUL);
				else 
					response.getWriter().print(Constant.DEFEATE);
			}
//			int result = new FriendDaoImpl().AddFriend(friend);
//			if(result==1)
//				response.getWriter().print(Constant.SUCCESSFUL);
//			else 
//				response.getWriter().print(Constant.DEFEATE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
