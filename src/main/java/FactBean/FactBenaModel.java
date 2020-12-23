package FactBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Model.FactModel;
import Model.companytable;
import Model.handle;
import Model.number;

@Configuration
public class FactBenaModel {
	
	@Bean(name="compM")
	public companytable getCompanytable() {
		return new companytable();
	}
	
	@Bean(name="handM")
	public handle getHandle() {
		return new handle();
	}
	
	@Bean(name="numM")
	public number getNumber() {
		return new number();
	}
	
	@Bean(name="fbm")
	public FactModel getFactModel() {
		FactModel fm = new FactModel();
		fm.setCompM(getCompanytable());
		fm.setHandM(getHandle());
		fm.setNumM(getNumber());
		return fm;
	}
}
