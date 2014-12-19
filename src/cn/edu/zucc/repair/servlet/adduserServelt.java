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
 * Servlet implementation class adduserServelt
 */
@WebServlet("/adduserServelt")
public class adduserServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduserServelt() {
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
		UsersDAO dao = new UsersDAO();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String level=request.getParameter("level");
		name=java.net.URLDecoder.decode(name,"UTF-8");
		pwd=java.net.URLDecoder.decode(pwd,"UTF-8");
		level=java.net.URLDecoder.decode(level,"UTF-8");
		bean.setUserName(name);
		bean.setPassword(pwd);
		bean.setLevel(level);
		bean.setStatus("A");
		if(dao.compareName(bean)=="ok")
		{
			dao.addUser(bean);
			String result="success";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
		}
		else
		{
			String result="fail";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
		}
	}

}
