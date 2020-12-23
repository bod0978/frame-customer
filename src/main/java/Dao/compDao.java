package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class compDao implements implDao{
	
	public static void main(String args[]) {
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List query() {
		return null;
		// TODO Auto-generated method stub
	}
	
	//公司電話搜尋
	public List queryTel(String tel) {
		Session se = implDao.getSe();
		Query q = se.createQuery("FROM companytable where tel = '"+tel+" '");
		List l = q.list();
		return l;
	}
	
	//統一編號查詢
	public List queryNumber(String number) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from companytable where number = '"+number+"'");
		List l = q.list();
		return l;
	}

}
