package cn.edu.zucc.repair.test;


import org.hibernate.Session;

import cn.edu.zucc.repair.model.UsersBean;
import cn.edu.zucc.repair.model.UsersDAO;
import cn.edu.zucc.repair.util.HibernateUtil;


public class ConnTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session  = HibernateUtil.getSession();
		System.out.println(session.connection());
		UsersBean bean = new UsersBean();
		bean.setLevel("normal");
		bean.setPassword("123");
		bean.setUserName("qwer");
		bean.setStatus("A");
		UsersDAO dao = new UsersDAO();
		dao.addUser(bean);
	}

}
