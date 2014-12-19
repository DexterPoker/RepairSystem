package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.zucc.repair.model.UsersBean;
import cn.edu.zucc.repair.model.UsersDAO;

public class DeleteuserAction {

	private int id;
	
	private int state;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int isState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String execute()
	{
		UsersDAO dao = new UsersDAO();
		UsersBean bean = new UsersBean();
		bean = dao.getUserById(id);
		if(state==1)
		{
			bean.setStatus("D");
			dao.motifyUser(bean);
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
		else if(state==0)
		{
			bean.setStatus("A");
			dao.motifyUser(bean);
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
