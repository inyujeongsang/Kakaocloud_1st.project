package kakao.project.student;

public class Student {

	private int sID;
	private String sName;
	private String sSex;
	private int sPresentTableNumber;

	Student() {
		this.sID = 0;
		this.sName = null;
		this.sSex = null;
		this.sPresentTableNumber = 0;
	}

	Student(int sID, String sName, String sSex) {
		this.sID = sID;
		this.sName = sName;
		this.sSex = sSex;
	}

	Student(int sID, String sName, String sSex, int sPresentTableNumber) {
		this.sID = sID;
		this.sName = sName;
		this.sSex = sSex;
		this.sPresentTableNumber = sPresentTableNumber;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public int getsPresentTableNumber() {
		return sPresentTableNumber;
	}

	public void setsPresentTableNumber(int sPresentTableNumber) {
		this.sPresentTableNumber = sPresentTableNumber;
	}

	

}

