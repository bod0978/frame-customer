package Dao;

public class FactDao {
	private compDao compD;
	private handleDao handD;
	private numberDao numD;
	
	public void setCompD(compDao compD) {
		this.compD = compD;
	}
	
	public compDao getCompD() {
		return compD;
	}
	
	public void setHandD(handleDao handD) {
		this.handD = handD;
	}
	
	public handleDao getHandD() {
		return handD;
	}
	
	public void setNumD(numberDao numD) {
		this.numD = numD;
	}
	
	public numberDao getNumD() {
		return numD;
	}
}
