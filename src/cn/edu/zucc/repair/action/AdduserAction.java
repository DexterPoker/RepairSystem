package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.zucc.repair.model.UsersBean;
import cn.edu.zucc.repair.model.UsersDAO;

public class AdduserAction {

	private String name;
	private String pwd;
	private String level;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String execute()
	{
		UsersDAO dao = new UsersDAO();
		UsersBean bean =  new UsersBean();
		bean.setUserName(name);
		bean.setLevel(level);
		bean.setPassword(pwd);
		bean.setStatus("A");
		
		if(dao.compareName(bean)=="none")
		{
			dao.addUser(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			String result="success";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		else
		{
			HttpServletResponse response = ServletActionContext.getResponse();
			String result="fail";
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}


	
}
