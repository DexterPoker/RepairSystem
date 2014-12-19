package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.zucc.repair.model.UsersBean;
import cn.edu.zucc.repair.model.UsersDAO;

public class MotifyuserAction {

	private int cellid;
	
	private String value;

	private int id;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCellid() {
		return cellid;
	}

	public void setCellid(int cellid) {
		this.cellid = cellid;
	}

	public String getVaule() {
		return value;
	}

	public void setVaule(String value) {
		this.value = value;
	}
	
	
	public String execute()
	{
		UsersBean bean = new UsersBean();
		UsersDAO dao = new UsersDAO();
		
		bean=dao.getUserById(id);
		if(cellid==2)
		{
			bean.setPassword(value);
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
		else if(cellid==3)
		{
			bean.setLevel(value);
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
