package Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Allen Chu
 * 新增客戶資料表單
 *
 */
@Entity
@Table(name="companytable")
public class companytable {
	/*
	 * id  SQL編號  id
	 * onlyday 新增資料的時間
	 * its  主機型號
	 * company  公司名稱
	 * number  統一編號
	 * tel  公司電話
	 * undertake  承辦人名稱
	 * phone  承辦人電話
	 * addr  公司電話
	 * ps  備註事項
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date onlyday;
	private String its;
	private String company;
	private String number;
	private String tel;
	private String undertake;
	private String phone;
	private String addr;
	private String ps;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOnlyday() {
		return onlyday;
	}
	public void setOnlyday(Date onlyday) {
		this.onlyday = onlyday;
	}
	public String getIts() {
		return its;
	}
	public void setIts(String its) {
		this.its = its;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUndertake() {
		return undertake;
	}
	public void setUndertake(String undertake) {
		this.undertake = undertake;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	

}
