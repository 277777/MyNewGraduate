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
 * Servlet implementation class ForgetServlet
 */
@WebServlet("/ForgetServlet")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private User user;
	private PrintWriter out;
	int result;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		out = response.getWriter();
		username = request.getParameter("Name");
		password = request.getParameter("Pwd");
		System.out.println("收到"+username+password);
		if(username!=null&&password!=null) {
			user = new User();
			try {
				user = new UserDaoImpl().findUserName(username);
				if(user==null)
					out.print(Constant.NOUSER);
				else {
					user = new User();
					user.setUsername(username);
					user.setUserpwd(password);
					result = new UserDaoImpl().UpdatePassword(user);
					if(result==1)
						out.print(Constant.SUCCESSFUL);
					else out.print(Constant.DEFEATE);
				}
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
