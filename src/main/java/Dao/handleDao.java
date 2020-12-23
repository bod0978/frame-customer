package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.handle;

public class handleDao implements implDao{
	
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
		// TODO Auto-generated method stub
		return null;
	}
		
	public String StringNumber(String Number) {
		String all = "";
		Session se = implDao.getSe();
		Query q = se.createQuery("from handle where number ='"+Number+" ' order by id DESC " );
		List l = q.list();
		String Con ,Ex;
		//for(Object o:l) {
		for(int i=0;i<l.size();i++) {
			String myPopup = "a" + i; 
			String PmyPopup2 = "b" + i;
			Object o[] = l.toArray();
			handle ha = (handle)o[i];
		
			if(ha.getCentent() == null && ha.getCentent()=="") {
				Con ="無";
			}else {
				if( ha.getCentent().length() > 10) {
					Con = ha.getCentent().substring(0, 6)+ "....";
				}else {
					Con = ha.getCentent();
				}
			}
			
			if(ha.getExp() == null && ha.getExp()=="") {
				Ex = "無";
			}else {
				if( ha.getExp().length() > 10 ) { 
					Ex = ha.getExp().substring(0, 6)+"...";
				}else {
					Ex = ha.getExp();
				}
			}
			
			all =all + "<tr><td align=center width=\"12%\">"+ha.getUndertake()
				+"<td align=center width=\"12%\">"+ha.getServicedate()
				//+"<td align=center width=\"25%\"><div data-role=\"collapsible\" data-theme=\"a\" data-content-theme=\"a\"><h1>"+Con+"</h1><p>"+ha.getCentent()+"</p></div>"
				//+"<td align=center width=\"25%\"><div data-role=\"collapsible\" data-theme=\"a\" data-content-theme=\"a\"><h1>"+Ex+"</h1><p>"+ha.getExp()+"</p></div>";
				
				+"<td align=center><a href=\"#"+myPopup+"\" data-rel=\"popup\" class=\"ui-btn ui-btn-inline ui-corner-all\" data-position-to=\"window\">"+Con+"</a>"	
				+"<div data-role=\"popup\" id=\""+myPopup+"\" class=\"ui-content\"><p>"+ha.getCentent()+"</p></div>"
				
				+"<td align=center><a href=\"#"+PmyPopup2+"\" data-rel=\"popup\" class=\"ui-btn ui-btn-inline ui-corner-all\" data-position-to=\"window\">"+Ex+"</a>"	
				+"<div data-role=\"popup\" id=\""+PmyPopup2+"\" class=\"ui-content\"><p>"+ha.getExp()+"</p></div>";
				
		}
		return all;
	}
	
	public List queryTel(String Tel) {
		Session se = implDao.getSe();
		//ELECT * FROM customer.handle  where tel like '%82452034' ;
		Query q = se.createQuery("from handle where tel like '%"+Tel+" '" );
		List l = q.list();
		return l;
	}
	
	public List queryNumber(String Number) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from handle where number ='"+Number+" '" );
		List l = q.list();
		return l;
	}
}
