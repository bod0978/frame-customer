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
 * 客戶服務紀錄表單
 */
@Entity
@Table(name="handle")
public class handle {
	/*
	 * id  SQL編號  id
	 * company 公司名稱
	 * number  統一編號
	 * tel   公司電話
	 * noticedate  申告時間
	 * service date  服務時間
	 * sort  服務類型
	 * centent  服務內容
	 * exp  交辦事項
	 * undertake  承辦人or會同人
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String company;
	private String number;
	private String tel;
	private Date noticedate;
	private Date servicedate;
	private String sort;
	private String centent;
	private String exp;
	private String undertake;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(Date noticedate) {
		this.noticedate = noticedate;
	}
	public Date getServicedate() {
		return servicedate;
	}
	public void setServicedate(Date servicedate) {
		this.servicedate = servicedate;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getCentent() {
		return centent;
	}
	public void setCentent(String centent) {
		this.centent = centent;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getUndertake() {
		return undertake;
	}
	public void setUndertake(String undertake) {
		this.undertake = undertake;
	}
	
	
}
