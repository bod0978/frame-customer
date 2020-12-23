package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface implDao {
	//spring 工廠模式 model
	ApplicationContext acm = new AnnotationConfigApplicationContext(FactBean.FactBenaModel.class);
	
	//spring 工廠模式 Dao
	ApplicationContext acd = new AnnotationConfigApplicationContext(FactBean.FactBeanDao.class);
	//資料庫連線
	
	public static Session getSe() {
		
		Configuration conn = new Configuration().configure();
		
		SessionFactory sf = conn.buildSessionFactory();
		
		Session se = sf.openSession();
		
		return se;
	}
	
	//新增
	void add(Object o);
	//更新
	void update(Object o);
	//刪除
	void delete(Integer id);
	//查詢
	List query();
}
