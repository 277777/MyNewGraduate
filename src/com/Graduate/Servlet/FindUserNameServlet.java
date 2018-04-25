package com.Graduate.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Graduate.Dao.Impl.UserDaoImpl;
import com.Graduate.Po.User;
import com.Graduate.Tools.Constant;

/**
 * Servlet implementation class FindUserNameServlet
 */
@WebServlet("/FindUserNameServlet")
public class FindUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private User user = new User();
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindUserNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		username = request.getParameter("Name");
		out = response.getWriter();
		System.out.println("收到" + username);
		if (username != null) {
			user.setUsername(username);
			try {
				user = new UserDaoImpl().findUserName(username);
				if (user == null)
					out.print(Constant.NOUSER);
				else 
					out.print(user.getUserid()+"#"+user.getUsername());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
