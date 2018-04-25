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
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int userid = Integer.valueOf(request.getParameter("Userid"));
		int user_friend_id = Integer.valueOf(request.getParameter("User_friend_id"));
		int status = Integer.valueOf(request.getParameter("Status"));
		Friend friend = new Friend();
		friend.setUserid(userid);
		friend.setUser_friend_id(user_friend_id);
		friend.setStatus(1);
		Friend ef = new Friend();
		ef.setUser_friend_id(userid);
		ef.setUserid(user_friend_id);
		if(status==1) {
			ef.setStatus(1);
			try {
				int result = new FriendDaoImpl().UpdateFriend(ef);
				if(result==1) {
					int resadd = new FriendDaoImpl().AddFriend(friend);
					if(resadd==1)
						response.getWriter().print(Constant.SUCCESSFUL);
					else response.getWriter().print(Constant.DEFEATE);
				}
				else response.getWriter().print(Constant.DEFEATE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(status==2){
			ef.setStatus(2);
			int result;
			try {
				result = new FriendDaoImpl().UpdateFriend(ef);
				if(result==1) response.getWriter().print(Constant.SUCCESSFUL);
				else response.getWriter().print(Constant.DEFEATE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
