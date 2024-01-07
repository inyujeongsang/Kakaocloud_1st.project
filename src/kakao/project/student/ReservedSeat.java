package kakao.project.student;

public class ReservedSeat {
    /* ReservedSeat의 역할
    * 1. 특정 학생에게 지정된 좌석과 그에 대한 정보를 관리한다.
    * 2. 지정석 여부, 지정 자리번호, 지정석 사유 정보를 관리한다.
    *
    * 쓰이는 곳
    * student에서 ReservedSeat객체 getter로 가져오고,
    * ArrangeManager에서 student의 getter로 ReservedSeat의 메서드에 접근한다.
    * (student.getReservedSeat().isReserved())
    * */
    private int reservedSeatNum; //지정석 자리번호
    private boolean isReserved; //지정석 여부
    private String reserveReason; //지정석 사유

    //생성자
    public ReservedSeat(){
        this.reservedSeatNum = -1; //초기값으로 -1설정.
        this.isReserved = false; //초기화
        this.reserveReason = "";
    }

    //*** Getter & Setter 시작 ***//
    public boolean isReserved(){
        return this.isReserved;
    }

    public void setReserved(boolean isReserved){
        this.isReserved = isReserved;
    }

    public int getReservedSeatNum(){
        return this.reservedSeatNum;
    }

    public void setReservedSeatNum(int reservedSeatNum) {
        this.reservedSeatNum = reservedSeatNum;
    }

    public String getReserveReason(){
        return this.reserveReason;
    }

    public void setReserveReason(String reserveReason){
        this.reserveReason = reserveReason;
    }
    //*** Getter & Setter 끝 ***//

    //지정석 설정하는 메서드
    public void setReservedSeat(int reservedSeatNum, String reason) {
        this.reservedSeatNum = reservedSeatNum;
        this.isReserved = true;
        this.reserveReason = reason;
    }

    //지정석 해제 메서드
    public void clearReservedSeat(){
        this.reservedSeatNum = -1; //초기값으로 -1설정.
        this.isReserved = false; //초기화
        this.reserveReason = "";
    }

    //지정석 정보 업데이트 메서드
    public void updateReserve(boolean isReserved, int reservedSeatNum, String reserveReason){
        this.isReserved = isReserved;
        this.reservedSeatNum = isReserved ? reservedSeatNum : -1; // true: 지정석번호 update, false : 초기화
        this.reserveReason = isReserved ? reserveReason : ""; // true: 지정석사유 update, false : 초기화
    }

    //이미 예약된 자리인지 아닌지 확인하는 메서드
    /*지정석을 신청한 ReservedSeat seat1 = new ReservedSeat(); 인스턴스들을 비교할 때 쓴다.
    * true를 반환하면 두 좌석이 동일 한것.
    * */
    @Override
    public boolean equals(Object obj){ //Object 클래스에 정의되어있는 메서드라서 오버라이딩함.
        //1단계 : 메서드에 전달된 객체가 현재 객체와 동일한지 확인함.
        if(this == obj) return true;
        //2단계 : 전달된 객체 null체크하고 현재객체와 같은 클래스인지 확인한다.
        if(obj == null || getClass() != obj.getClass()){ //
            return false;
        }
        //3단계 : 2단계에서 같은 클래스임이 보장됐으니 ReservedSeat 타입으로 캐스팅함.
        ReservedSeat that = (ReservedSeat)obj;
        //4단계 : 두 객체의 지정석 자리번호와 지정석 여부가 같은지 비교한다. 두 조건 모두 true이면 이미 예약된 자리다.
        return reservedSeatNum == that.reservedSeatNum && isReserved == that.isReserved;
    }
}
