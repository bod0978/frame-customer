package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.number;

public class numberDao implements implDao{

	public static void main(String[] args) {
		number n = new number();
		n.setId(2);
		n.setName("測試更新2");
		
		n.setType(false);
		
		
		new numberDao().update(n);
		/*
		String Type = "0";
		Boolean bl = false;
		if(Type.equals("1")) {
			bl = true;
		}
		System.out.println(bl);
		 */
	}

	@Override
	public void add(Object o) {
		Session se = implDao.getSe();
		Transaction tt = se.beginTransaction();
		se.save(o);
		tt.commit();
		se.close();
		
	}

	@Override
	public void update(Object o) {
		Session se = implDao.getSe();
		Transaction tt = se.beginTransaction();
		//更新的檔案
		number n = (number)o;
		Object o1[] =( new numberDao().numalter(n.getId())).toArray();
		//抓出來的檔案
		number n2 = (number)o1[0];
		if(n.getName() != n2.getName() )n2.setName(n.getName());
		if(n.getPassword() != n2.getPassword() && n.getPassword() != null ) n2.setPassword(n.getPassword());
		if(n.getUser() != null )n2.setUser(n.getUser());
		if(n.getPhone() != n2.getPhone() && n.getPhone() != null) n2.setPhone(n.getPhone());
		if(n.getBody() != n2.getBody() && n.getBody() != null) n2.setBody(n.getBody());
		if(n.getType() != n2.getType() && n.getType() != null ) n2.setType(n.getType());
		
		se.update(n2);
		tt.commit();
		se.close();
		
	}

	@Override
	public void delete(Integer id) {
		Session se = implDao.getSe();
		Transaction tt = se.beginTransaction();
		number num = new number();
		num.setId(id);
		System.out.println("numDao"+id);
		se.delete(num);
		tt.commit();
		se.close();
	}
	
	//user see all
	public String queryall() {
		Session se = implDao.getSe();
		Query q  = se.createQuery("from number");
		List l = q.list();
		String all = "";
		for(Object o:l) {
			number m = (number)o;
			all = all+ "<tr><td align=center>"+m.getId()+"<td align=center>"+m.getUser()
			+"<td align=center>"+m.getName()+"<td align=center>"+m.getPassword()+"<td align=center>"+m.getPhone()
			+"<td align=center><a href=\"../Con/numdelete?id="+m.getId()+ "\"/a>刪除"
			+"<td align=center><a href=\"../Con/alter?id="+m.getId()+ "\"/a>編輯";
		}
		return all;
	}
	
	@Override
	public List query() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//checkuser
	public List loginCheck(String user,String password) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from number where user='"+user+"' and password='"+password+"' ");
		List l = q.list();
		return l;
	}
	
	//alter
		public List numalter(Integer id) {
			Session se = implDao.getSe();
			Query q = se.createQuery("from number where id='"+id+"' ");
			List l = q.list();
			return l;
		}
}
