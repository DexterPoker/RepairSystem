package cn.edu.zucc.repair.model;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class AssetsDAO  extends HibernateBaseDAO{
	public List<AssetsBean> getAllAssets(){
		List<?> l = this.query("from AssetsBean");
		if(l.isEmpty()){
			return null;
		}else{
			return (List<AssetsBean>) l;
		}
	}
	
	public AssetsBean getAssetsById(int id)
	{
		List<?> l = this.query("from AssetsBean where id="+id);
		if(l.isEmpty()){
			return null;
		}else{
			return (AssetsBean) l.get(0);
		}
	}
	
	public String getAssetsToJSON(){
		List<AssetsBean> listB = (List<AssetsBean>) new AssetsDAO().getAllAssets();
		List<GridJSON> list = new ArrayList<GridJSON>();
		for (int i = 1; i <= listB.size(); i++) {
			AssetsBean bean = (AssetsBean) listB.get(i - 1);
			GridJSON gj = new GridJSON();
			List l = new ArrayList();
			l.add(bean.getId());
			l.add(bean.getName());
			l.add(bean.getLocation());
			//l.add(bean.getStatus());
			l.add(bean.getType());
			gj.setId(i);
			gj.setData(l);
			
			list.add(gj);
		}
		
		JSONArray json = JSONArray.fromObject(list);
		String result = "{\"rows\":"+json.toString()+"}";
		return result;
	}
}
