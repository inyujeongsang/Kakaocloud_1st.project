package kakao.project.student;

import java.util.*;

public class SeatAssignment {
    /*클래스 역할
    * 1. 학생의 자리배정 정보를 관리한다.
    * 2. 현재 자리번호, 이전 자리번호, 이전 짝꿍의 정보를 관리한다.
    * 3. 자리 배정 데이터를 캡슐화하여 이 데이터에 대한 접근과 수정을 제어한다.
    * 4. 특정 상황에서 학생의 자리 배정 정보를 초기화할 필요가 있을 수 있다. 이때 resetCurrentSeat메서드를 호출한다.
    * 5. 전체 자리배치는 ArrangeManager가 관리하지만, 개별 자리 정보는 SeatAssignment가 관리한다.
    * */
    private int currentTableNumber; //자리번호
    private int previousTableNumber; //이전 자리번호
    private List<Integer> previousPartners; //이전 분단 짝꿍ID배열

    public SeatAssignment(){
        this.currentTableNumber = 0;
        this.previousTableNumber = 0;
        this.previousPartners = new ArrayList<>(); //최대 짝꿍의 수 = 2
    }

    //*** Getter & Setter 시작 ***//
    public int getcurrentTableNumber() { // 현재 자리 번호를 가져오는 메서드
        return this.currentTableNumber;
    }

    public void setcurrentTableNumber(int currentTableNumber){
        this.currentTableNumber = currentTableNumber;
    }

    public int getPreviousTableNumber(){ //이전 자리 번호를 가져오는 메서드
        return this.previousTableNumber;
    }

    public void setPreviousTableNumber(int previousTableNumber) {
        this.previousTableNumber = previousTableNumber;
    }

    public List<Integer> getpreviousPartners() {//이전 짝꿍 목록을 가져오는 메서드
        return new ArrayList<>(this.previousPartners);
    }

    public void setpreviousPartners(List<Integer> previousPartners) {
        this.previousPartners = previousPartners;
    }
    //*** Getter & Setter 끝 ***//


    //현재 자리 번호를 설정하고 이전 자리 번호를 업데이트하는 메서드
    //새로운 자리 번호가 주어질때마다 호출 되어야함.
    public void updateSeat(int newSeatNumber){
        this.previousTableNumber = this.currentTableNumber; //현재 자리번호를 이전 자리로 업데이트함.
        this.currentTableNumber = newSeatNumber; //현재 자리번호에 새 자리 번호 업데이트.
    }

    //이전 짝꿍을 추가하는 메서드
    public void addPreviousPartner(int partnerID){
        if(!this.previousPartners.contains(partnerID)){
            this.previousPartners.add(partnerID);
        }
    }

    //특정 자리가 이전 자리였는지 확인하는 메서드
    public boolean wasPreviousSeat(int seatNumber){
        return this.previousTableNumber == seatNumber;
    }

    //현재 자리 번호를 초기화하는 메서드
    public void resetCurrentSeat(){
        this.currentTableNumber = 0;
    }

    //이전 짝꿍 목록을 초기화하는 메서드
    public void clearPreviousPartner(){
        this.previousPartners.clear();
    }

    //특정 학생이 이전 짝꿍인지 확인하는 메서드
    public boolean isPreviousPartner(int studentID){
        return this.previousPartners.contains(studentID);
    }
}