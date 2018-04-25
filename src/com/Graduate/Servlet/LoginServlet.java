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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private User user;
	private PrintWriter out ;
	
    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
			user.setUsername(username);
			user.setUserpwd(password);
			try {
				user = new UserDaoImpl().findUserName(username);
				if(user==null)
					out.print(Constant.NOUSER);
				else {
					if(!user.getUserpwd().equals(password))
						out.print(Constant.DEFEATE);
					else out.print(new UserDaoImpl().SendUser(user));
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
