package FactBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Dao.FactDao;
import Dao.compDao;
import Dao.handleDao;
import Dao.numberDao;

@Configuration
public class FactBeanDao {
	
	@Bean(name="compD")
	public compDao getCompDao() {
		return new compDao();
	}
	
	@Bean(name="handD")
	public handleDao getHandleDao() {
		return new handleDao();
	}
	
	@Bean(name="numD")
	public numberDao getNumberDao() {
		return new numberDao();
	}
	
	@Bean(name="fbd")
	public FactDao getFactDao() {
		FactDao fd = new FactDao();
		fd.setCompD(getCompDao());
		fd.setHandD(getHandleDao());
		fd.setNumD(getNumberDao());
		return fd;
	}
}
