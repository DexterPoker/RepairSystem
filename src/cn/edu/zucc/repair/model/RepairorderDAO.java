package cn.edu.zucc.repair.model;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class RepairorderDAO extends HibernateBaseDAO{
	public RepairorderBean getOrderById(int id){
		List<?> l = this.query("from RepairorderBean where id = " + id);
		if(l.isEmpty()){
			return null;
		}else{
			return (RepairorderBean)l.get(0);
		}
	}
	
	public RepairorderBean getOrderByPid(int id)
	{
		List<?> l = this.query("from RepairorderBean where proposerId =  " +id);
		if(l.isEmpty())
		{
			return null;
		}
		else
		{
			return (RepairorderBean) l.get(0);
		}
	}
	
	public RepairorderBean getOrderByPidandStatus(int id)
	{//status A :未承接订单；W ：以承接  N：已完成
		List<?> l = this.query("from RepairorderBean where proposerId =  " +id +"and status = 'A'");
		if(l.isEmpty())
		{
			return null;
		}
		else
		{
			return (RepairorderBean) l.get(0);
		}
	}
	
	public String isPepairing(int id)
	{
		List<?> l = this.query("from RepairorderBean where assetsId =  " +id +"and status = 'A' or assetsId = "+ id +"and status = 'W'");
		if(l.isEmpty())
		{
			return "not";
		}
		else
		{
			return "is";
		}
	}
	
	
	public void addOrder(RepairorderBean repairorder)
	{
		this.beginThransaction();
		try{
			this.getSession().save(repairorder);
			this.commitThransaction();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			this.rollbackThransaction();
		}
	}
	
	public void motifyOrder(RepairorderBean repairorder)
	{
		this.beginThransaction();
		try{
			this.getSession().merge(repairorder);
			this.commitThransaction();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			this.rollbackThransaction();
		}
	}
	
	/*public void deleteOrder(RepairorderBean repairorder)
	{
		this.beginThransaction();
		try{
			repairorder.setStatus("D");
			this.getSession().merge(repairorder);
			this.commitThransaction();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			this.rollbackThransaction();
		}
	}*/
	
	public List<RepairorderBean> getRepairorderByPropserid(int id)
	{
		List<?> l = this.query("from RepairorderBean where proposerId = " + id);
		if(l.isEmpty()){
			return null;
		}else{
			return (List<RepairorderBean>) l;
		}
	}
	
	
	public String getOrderToJSONAll(int id){
		List<RepairorderBean> listB = (List<RepairorderBean>) new RepairorderDAO().getRepairorderByPropserid(id);
		List<GridJSON> list = new ArrayList<GridJSON>();
		for (int i = 1; i <= listB.size(); i++) {
			RepairorderBean bean = (RepairorderBean) listB.get(i - 1);
			GridJSON gj = new GridJSON();
			List l = new ArrayList();
			l.add(bean.getId());
			l.add(new AssetsDAO().getAssetsById(bean.getAssetsId()).getId()+new AssetsDAO().getAssetsById(bean.getAssetsId()).getName());
			l.add(bean.getDescription());
			l.add(bean.getAddress());
			if(bean.getMaintainerId()==4){
				l.add(null);
				}
			else{
				l.add(new UsersDAO().getUserById(bean.getMaintainerId()).getUserName());
			}
			if(bean.getStatus().equals("A")){
				l.add("未承接");
				}
			else if(bean.getStatus().equals("W")){
				l.add("已承接");
				}
			else if(bean.getStatus().equals("N")){
				l.add("已完成");
				}
			if(bean.getStartDate()==null||bean.getStartDate().equals(""))
				l.add(bean.getStartDate());
			else
				l.add(bean.getStartDate().toString());
			if(bean.getEndDate()==null||bean.getEndDate().equals(""))
				l.add(bean.getEndDate());
			else
				l.add(bean.getEndDate().toString());
			l.add(new UsersDAO().getUserById(bean.getProposerId()).getUserName());
			if(bean.getLevel()==null||bean.getLevel().equals(""))
				l.add("无");
			else
				l.add(bean.getLevel());
			gj.setId(i);
			gj.setData(l);
			
			list.add(gj);
		}
		
		JSONArray json = JSONArray.fromObject(list);
		String result = "{\"rows\":"+json.toString()+"}";
		//System.out.println(result);
		return result;
	}
	
	public String getOrderToJSONDone(int id){
		List<RepairorderBean> listB = (List<RepairorderBean>) new RepairorderDAO().getRepairorderByPropserid(id);
		List<GridJSON> list = new ArrayList<GridJSON>();
		for (int i = 1; i <= listB.size(); i++) {
			RepairorderBean bean = (RepairorderBean) listB.get(i - 1);
			GridJSON gj = new GridJSON();
			List l = new ArrayList();
			if(bean.getStatus().equals("N")){
				l.add(bean.getId());
				l.add(new AssetsDAO().getAssetsById(bean.getAssetsId()).getId()+new AssetsDAO().getAssetsById(bean.getAssetsId()).getName());
				l.add(bean.getDescription());
				l.add(bean.getAddress());
				if(bean.getMaintainerId()==4){
					l.add(null);
					}
				else{
					l.add(new UsersDAO().getUserById(bean.getMaintainerId()).getUserName());
				}
				/*if(bean.getStatus().equals("A")){
					l.add("未承接");
					}
				else if(bean.getStatus().equals("W")){
					l.add("已承接");
					}
				else */if(bean.getStatus().equals("N")){
					l.add("已完成");
					}
				l.add(bean.getStartDate().toString());
				l.add(bean.getEndDate().toString());
				l.add(new UsersDAO().getUserById(bean.getProposerId()).getUserName());
				if(bean.getLevel()==null||bean.getLevel().equals(""))
					l.add("无");
				else
					l.add(bean.getLevel());
				gj.setId(i);
				gj.setData(l);
			}
			else
				continue;
			list.add(gj);
		}
		
		JSONArray json = JSONArray.fromObject(list);
		String result = "{\"rows\":"+json.toString()+"}";
		//System.out.println(result);
		return result;
	}
	
	public String getOrderToJSONNottaken(int id){
		List<RepairorderBean> listB = (List<RepairorderBean>) new RepairorderDAO().getRepairorderByPropserid(id);
		List<GridJSON> list = new ArrayList<GridJSON>();
		for (int i = 1; i <= listB.size(); i++) {
			RepairorderBean bean = (RepairorderBean) listB.get(i - 1);
			GridJSON gj = new GridJSON();
			List l = new ArrayList();
			if(bean.getStatus().equals("A"))
			{
				l.add(bean.getId());
				l.add(new AssetsDAO().getAssetsById(bean.getAssetsId()).getId()+new AssetsDAO().getAssetsById(bean.getAssetsId()).getName());
				l.add(bean.getDescription());
				l.add(bean.getAddress());
				if(bean.getMaintainerId()==4){
					l.add(null);
				}
				else{
					l.add(new UsersDAO().getUserById(bean.getMaintainerId()).getUserName());
				}
				if(bean.getStatus().equals("A")){
					l.add("未承接");
				}
				l.add(bean.getStartDate());
				l.add(bean.getEndDate());
				l.add(new UsersDAO().getUserById(bean.getProposerId()).getUserName());
				if(bean.getLevel()==null||bean.getLevel().equals(""))
					l.add("无");
				else
					l.add(bean.getLevel());
				l.add(0);
				gj.setId(i);
				gj.setData(l);
			}
			else
				continue;
			list.add(gj);
		}
		
		JSONArray json = JSONArray.fromObject(list);
		String result = "{\"rows\":"+json.toString()+"}";
		//System.out.println(result);
		return result;
	}
	
}
