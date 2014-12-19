package cn.edu.zucc.repair.action;

import cn.edu.zucc.repair.model.RepairorderBean;
import cn.edu.zucc.repair.model.RepairorderDAO;

public class DeleteorderAction {

	private RepairorderBean order;

	public RepairorderBean getOrder() {
		return order;
	}

	public void setOrder(RepairorderBean order) {
		this.order = order;
	}
	
	public String execute()
	{
		RepairorderDAO dao = new RepairorderDAO();
		//dao.deleteOrder(getOrder());
		return "success";
	}
}
