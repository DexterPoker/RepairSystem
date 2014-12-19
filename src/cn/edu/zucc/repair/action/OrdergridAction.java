package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zucc.repair.model.RepairorderDAO;
import cn.edu.zucc.repair.model.UsersBean;


public class OrdergridAction {
	
	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String execute()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		int id = ((UsersBean)ActionContext.getContext().getSession().get("user")).getUserId();
		String result;
		if(method.equals("all"))
		{
			result=new RepairorderDAO().getOrderToJSONAll(id);
		}
		else if(method.equals("done"))
		{
			result=new RepairorderDAO().getOrderToJSONDone(id);
		}
		
		else if(method.equals("nottaken"))
		{
			result=new RepairorderDAO().getOrderToJSONNottaken(id);
		}
		else
			result = "fail";
		response.setContentType("text/xml;charset=UTF-8");
		//System.out.println(result);
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
