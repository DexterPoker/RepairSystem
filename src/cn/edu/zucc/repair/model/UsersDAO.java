package cn.edu.zucc.repair.model;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class UsersDAO extends HibernateBaseDAO{
	public UsersBean getUserById(int id){
		List<?> l = this.query("from UsersBean where userId = " + id);
		if(l.isEmpty()){
			return null;
		}else{
			return (UsersBean)l.get(0);
		}
	}
	
	public UsersBean getUserByName(String name){
		List<?> l = this.query("from UsersBean where userName = '" + name + "'");
		if(l.isEmpty()){
			return null;
		}else{
			return (UsersBean) l.get(0);
		}
	}
	
	public String compareName(UsersBean user)
	{
		List<?> l = this.query("from UsersBean where userName = '" + user.getUserName() + "'");
		if(l.isEmpty()){
			return "none";
		}else{
			return "exist";
		}
	}
	
	public List<UsersBean> getUserByIds()
	{
		List<?> l = this.query("from UsersBean");
		if(l.isEmpty()){
			return null;
		}else{
			return (List<UsersBean>) l;
		}
		
	}
	
	
	public void addUser(UsersBean user){
		this.beginThransaction();
		try{
			this.getSession().save(user);
			this.commitThransaction();
		}catch(Exception ex){
			ex.printStackTrace();
			this.rollbackThransaction();
		}
	}
	
	public void motifyUser(UsersBean user){
		this.beginThransaction();
		try{
			this.getSession().merge(user);
			this.commitThransaction();
		}catch(Exception ex){
			ex.printStackTrace();
			this.rollbackThransaction();
		}
	}
	
	/*public void deleteUser(UsersBean user){
		this.beginThransaction();
		try{
			this.getSession().merge(user);
			this.commitThransaction();
		}catch(Exception ex){
			ex.printStackTrace();
			this.rollbackThransaction();
		}
	}*/
	public String getUsersToJSON(){
		List<UsersBean> listB = new UsersDAO().getUserByIds();
		List<GridJSON> list = new ArrayList<GridJSON>();
		for (int i = 1; i <= listB.size(); i++) {
			UsersBean bean = (UsersBean) listB.get(i - 1);
			if(bean.getUserId()==4)
				continue;
			GridJSON gj = new GridJSON();
			List l = new ArrayList();
			l.add(bean.getUserId());
			l.add(bean.getUserName());
			l.add(bean.getPassword());
			if(bean.getLevel().equals("normal")){
				l.add("普通用户");
			}else if(bean.getLevel().equals("admin")){
				l.add("管理员");
			}else if(bean.getLevel().equals("repairer")){
				l.add("维修员");
			}
			if(bean.getStatus().equals("A"))
				l.add(0);
			else if(bean.getStatus().equals("D"))
				l.add(1); 
			else
				l.add(0);
			//l.add(0);
			gj.setId(i);
			gj.setData(l);
			
			list.add(gj);
		}
		
		JSONArray json = JSONArray.fromObject(list);
		String result = "{\"rows\":"+json.toString()+"}";
		return result;
	}
}
