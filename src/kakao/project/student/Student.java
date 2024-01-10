package kakao.project.student;

public class Student {
	/*Student 클래스의 역할
	* 1. 학생의 정보를 저장하여 학생을 나타낸다.
	* 2. 정보에는 학생id, 학생이름, 학생성별, 현재 좌석번호, 지정석번호, 지정석 유무, 지정석 사유가 포함된다.
	*
	* Student & SeatAssignment & ReservedSeat 관계
	* 합성관계다.(UML로 따지면 검은 다이아몬드모양)
	* Student는 SeatAssignment와 ReservedSeat를 포함한다.
	*  */
	private int sID;
	private String sName;
	private String sSex;
	private int currentSeatNumber; //현재자리번호
	private int reservedSeatNumber; //지정석자리번호
	private String reservedSeatReason; //지정석사유
	private boolean reservedSeatStatus; //지정석 유무 : true, false

	public String getReservedSeatReason() {
		return reservedSeatReason;
	}

	public void setReservedSeatReason(String reservedSeatReason) {
		this.reservedSeatReason = reservedSeatReason;
	}

	public int getCurrentSeatNumber() {
		return currentSeatNumber;
	}

	public void setCurrentSeatNumber(int currentSeatNumber) {
		this.currentSeatNumber = currentSeatNumber;
	}

	public int getReservedSeatNumber() {
		return reservedSeatNumber;
	}
	public boolean getReservedSeatStatus() { return reservedSeatStatus; }
	public void setReservedSeatNumber(int reservedSeatNumber) {
		this.reservedSeatNumber = reservedSeatNumber;
	}

	public boolean isReservedSeatStatus() {
		return reservedSeatStatus;
	}

	public void setReservedSeatStatus(boolean reservedSeatStatus) {
		this.reservedSeatStatus = reservedSeatStatus;
	}

	private SeatAssignment seatAssignment; //좌석배정정보
	private ReservedSeat reservedSeat; //지정석 정보

	public Student() {
		this.sID = 0;
		this.sName = null;
		this.sSex = null;
		this.seatAssignment = new SeatAssignment(); //초기화
		this.reservedSeat = new ReservedSeat();
	}

	public Student(int sID, String sName, String sSex,int currentSeatNumber, int reservedSeatNumber, boolean reservedSeatStatus, String reservedSeatReason) {
		this.sID = sID;
		this.sName = sName;
		this.sSex = sSex;
		this.currentSeatNumber = currentSeatNumber;
		this.reservedSeatNumber = reservedSeatNumber;
		this.reservedSeatStatus = reservedSeatStatus;
		this.reservedSeatReason = reservedSeatReason;
		this.seatAssignment = new SeatAssignment(); //초기화
		this.reservedSeat = new ReservedSeat();
	}

	//*** Getter & Setter 시작 ***//
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


	public SeatAssignment getSeatAssignment(){
		return seatAssignment;
	}

	public void setSeatAssignment(SeatAssignment seatAssignment){
		this.seatAssignment = seatAssignment;
	}

	public ReservedSeat getReservedSeat(){
		return reservedSeat;
	}

	public void setReservedSeat(ReservedSeat reservedSeat){
		this.reservedSeat = reservedSeat;
	}

	//*** Getter & Setter 끝 ***//

	//좌석 번호 업데이트 메서드
	public void updateSeatNumber(int newSeatNumber){
		this.currentSeatNumber = newSeatNumber;
	}
}