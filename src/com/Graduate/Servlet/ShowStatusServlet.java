package com.Graduate.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.Graduate.Dao.Impl.MultipleDaoImpl;
import com.Graduate.Po.Friend;
import com.Graduate.Tools.Constant;

/**
 * Servlet implementation class ShowStatusServlet
 */
@WebServlet("/ShowStatusServlet")
public class ShowStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStatusServlet() {
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
		Friend friend = new Friend();
		friend.setUserid(userid);
		try {
			List<Map<Integer, String>> list = new MultipleDaoImpl().ShowStatus(friend);
			if(list==null) {
				response.getWriter().print(Constant.NOUSER);
			}else {
				JSONArray jsonstr = new JSONArray(list);
				response.getWriter().print(jsonstr);
			}
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
