package kakao.project.student;

public class Student {

	private int sID;
	private String sName;
	private String sSex;
	private int sPresentTableNumber;
	
	private boolean sReservedSeatYN;
	private String sSeatReason;

	Student() {
		this.sID = 0;
		this.sName = null;
		this.sSex = null;
		this.sPresentTableNumber = 0;
		
		this.sReservedSeatYN = false; // 좌석 예약 여부 기본값은 false로 설정
	    this.sSeatReason = null; // 좌석 예약하지 않았을 때 이유는 초기에 null로 설정

	}

	Student(int sID, String sName, String sSex) {
		this.sID = sID;
		this.sName = sName;
		this.sSex = sSex;
		this.sReservedSeatYN = false; // 좌석 예약 여부 기본값은 false로 설정
	    this.sSeatReason = null; // 좌석 예약하지 않았을 때 이유는 초기에 null로 설정

	}

	Student(int sID, String sName, String sSex, int sPresentTableNumber) {
		this.sID = sID;
		this.sName = sName;
		this.sSex = sSex;
		this.sPresentTableNumber = sPresentTableNumber;
		
		this.sReservedSeatYN = false; // 좌석 예약 여부 기본값은 false로 설정
	    this.sSeatReason = null; // 좌석 예약하지 않았을 때 이유는 초기에 null로 설정

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


	// reservedSeatYN에 대한 getter와 setter 메서드
	public boolean isReservedSeatYN() {
	    return sReservedSeatYN;
	}

	public void setReservedSeatYN(boolean reservedSeatYN) {
	    this.sReservedSeatYN = reservedSeatYN;
	}

	// seatReason에 대한 getter와 setter 메서드
	public String getSeatReason() {
	    return sSeatReason;
	}

	public void setSeatReason(String seatReason) {
	    this.sSeatReason = seatReason;
	}

}

