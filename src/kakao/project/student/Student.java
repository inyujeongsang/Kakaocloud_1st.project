package kakao.project.student;

public class Student {

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

   Student(int sID, String sName, String sSex) {
      this.sID = sID;
      this.sName = sName;
      this.sSex = sSex;
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
}
