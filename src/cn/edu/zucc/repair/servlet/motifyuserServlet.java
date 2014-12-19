package cn.edu.zucc.repair.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zucc.repair.model.UsersBean;
import cn.edu.zucc.repair.model.UsersDAO;

/**
 * Servlet implementation class motifyuserServlet
 */
@WebServlet("/motifyuserServlet")
public class motifyuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public motifyuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsersBean bean = new UsersBean();
		UsersDAO  dao = new UsersDAO();
		
		String name=request.getParameter("name");
		name=java.net.URLDecoder.decode(name,"UTF-8");
		String pwd=request.getParameter("pwd");
		name=java.net.URLDecoder.decode(pwd,"UTF-8");
		String level=request.getParameter("level");
		level=java.net.URLDecoder.decode(level,"UTF-8");
		
		bean.setLevel(level);
		bean.setPassword(pwd);
		bean.setStatus("A");
		//dao.deleteUser(bean);
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("success");

	}

}
