package cn.edu.zucc.repair.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.zucc.repair.model.AssetsDAO;


public class AssetsgridAction {
	public String execute()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		String result=new AssetsDAO().getAssetsToJSON();
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
