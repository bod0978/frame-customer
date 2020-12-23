package Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Dao.FactDao;
import Model.FactModel;



public class test {

	public static void main(String[] args) {
		ApplicationContext acm = new AnnotationConfigApplicationContext(FactBean.FactBenaModel.class);
		ApplicationContext acd = new AnnotationConfigApplicationContext(FactBean.FactBeanDao.class);
		
		FactDao fbd = acd.getBean("fbd",FactDao.class);
		FactModel fbm = acm.getBean("fbm", FactModel.class);
		
		System.out.println(fbm.getCompM()+" : "+fbm.gethandM()+" : "+fbm.getNumM());
		System.out.println(fbd.getCompD()+";"+fbd.getHandD()+";"+fbd.getNumD());
	}

}
