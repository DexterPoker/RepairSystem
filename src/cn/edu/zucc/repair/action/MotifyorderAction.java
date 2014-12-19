package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.zucc.repair.model.RepairorderBean;
import cn.edu.zucc.repair.model.RepairorderDAO;


public class MotifyorderAction {

	private String value;

	private int id;
	
	public int cellid;
	
	private String function;
	
	

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getCellid() {
		return cellid;
	}

	public void setCellid(int cellid) {
		this.cellid = cellid;
	}

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

	public String execute()
	{
		RepairorderBean bean  = new RepairorderBean();
		RepairorderDAO dao = new RepairorderDAO();
		
		bean=dao.getOrderById(id);
		if(cellid==9)
		{
			bean.setLevel(Integer.valueOf(value));
			dao.motifyOrder(bean);
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
		else if(cellid==2)
		{
			bean.setDescription(value);
			dao.motifyOrder(bean);
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
		else if(function.equals("delete"))
		{
			if(value.equals("0"))
				bean.setStatus("A");
			else
				bean.setStatus("D");
			dao.motifyOrder(bean);
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
