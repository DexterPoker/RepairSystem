package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zucc.repair.model.AssetsDAO;
import cn.edu.zucc.repair.model.RepairorderBean;
import cn.edu.zucc.repair.model.RepairorderDAO;
import cn.edu.zucc.repair.model.UsersBean;

public class AddorderAction {

	private int assetsid;
	
	private String description;
	
	
	public int getAssetsid() {
		return assetsid;
	}

	public void setAssetsid(int assetsid) {
		this.assetsid = assetsid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String execute()
	{
		RepairorderDAO dao = new RepairorderDAO();
		RepairorderBean bean = new RepairorderBean();
		int propser = ((UsersBean)ActionContext.getContext().getSession().get("user")).getUserId();
		String address = new AssetsDAO().getAssetsById(assetsid).getLocation();
		String status = "A";
		bean.setAssetsId(assetsid);
		bean.setDescription(description);
		bean.setProposerId(propser);
		bean.setAddress(address);
		bean.setStatus(status);
		bean.setMaintainerId(4);
		/*System.out.println(propser);
		System.out.println(assetsid);
		System.out.println(description);
		System.out.println(address);*/
		
		if(dao.isPepairing(assetsid)=="not")
		{
			dao.addOrder(bean);
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
