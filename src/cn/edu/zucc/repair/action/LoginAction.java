package cn.edu.zucc.repair.action;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zucc.repair.model.UsersBean;
import cn.edu.zucc.repair.model.UsersDAO;

public class LoginAction{
	private UsersBean user;
	
	public void setUser(UsersBean user){
		this.user = user;
	}
	
	public UsersBean getUser(){
		return user;
	}
	
	public String execute(){
		UsersDAO dao = new UsersDAO();
		UsersBean bean = dao.getUserByName(user.getUserName());
		if(bean == null){
			ActionContext.getContext().put("errorMsg", "ÓÃ»§Ãû´íÎó");
			return "error";
		}else if(!bean.getPassword().equals(user.getPassword())){
			ActionContext.getContext().put("errorMsg", "ÃÜÂë´íÎó");
			return "error";
		}else{
			ActionContext.getContext().getSession().put("user", bean);
//			System.out.println(bean.getLevel());
			return bean.getLevel();
		}
		
	}

}
