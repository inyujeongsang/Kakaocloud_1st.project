package kakao.project.arrange;

import kakao.project.student.SeatAssignment;
import kakao.project.student.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrangeManager{
    /*ArrangeManager 클래스의 역할
    1. 좌석관리와 학생 배치를 담당한다.
    - 자리 초기화 : 좌석을 초기화하여 빈자리를 만든다.
    - 학생 배치 : 학생들을 좌석에 배치한다.
      지정석 먼저 배치 -> 이전 자리, 이전 짝꿍 안겹치도록 나머지 학생 랜덤배치
    2. 자리 배치와 관련된 모든 작업을 중앙에서 관리하도록 하여, 코드의 일관성과 유지보수성 향상.

    특징
    - 하나의 인스턴스만 위 역할을 수행하도록 싱글톤 패턴으로 구현함.

    * */
    private static ArrangeManager instance; //싱글톤 인스턴스
    private List<Arrange> seats;
    private List<Student> students;
    public static final int SEAT_NUMBER = 26;
    public static final int CIRCLE_SIZE = 5;

    //분단별 좌석 번호 정보
    private static final int[] FIRST_SEATS = {1,2,8,9,15,16}; //1분단
    private static final int[] SECOND_SEATS = {3, 4, 5, 10, 11, 12, 17, 18, 19, 22, 23, 24}; //2분단
    private static final int[] THIRD_SEATS = {6, 7, 13, 14, 20, 21, 25, 26};//3분단

    //싱글톤이라 접근제어자 private으로 사용.
    private ArrangeManager(List<Student> students){
        this.students = students;
        this.seats = new ArrayList<>(SEAT_NUMBER);
        initializeSeats(); //자리 초기화
    }

    //싱글톤 인스턴스 반환하는 메서드 ( 멀티스레드 환경아니라서 double-checked locking적용하지 않음. )
    public static ArrangeManager getInstance(List<Student> students){
        if(instance == null){
            instance = new ArrangeManager(students);
        }
        return instance;
    }

    //자리 초기화
    private void initializeSeats() {
        if(seats.isEmpty()) {
            seats.add(null); //0번인덱스를 null값으로 채움. 인덱스와 학생 자리번호를 일치시켜주기 위함(직관적으로)

            for(int i = 1; i <= SEAT_NUMBER; i++){
                seats.add(new Arrange(i)); //1부터 시작하는 자리번호
            }
        }else {
            for(int i = 1; i<=SEAT_NUMBER; i++) {
                seats.set(i, new Arrange(i));
            }
        }

    }

    //자리배치 메서드
    public void allocateSeats() {
        initializeSeats();
        // 지정석 학생 우선 배치
        for (Student student : students) {
            if(student != null) {
                if(student.isReservedSeatStatus()) { //지정석여부 체크
                    int reservedSeatNum = student.getReservedSeatNumber();
                    seats.get(reservedSeatNum).assignStudent(student);
                    System.out.println("Assigned student to reserved seat: " + student.getsName() + " to seat number " + reservedSeatNum);
                }
            }
        }
        System.out.println("---------------------------------");
        //이전 자리 및 짝꿍을 고려한 랜덤 배치 로직
        List<Student> remainStudents = getRemainStudents(); //남아있는 학생
        List<Arrange> availableSeats = getAvailableSeats(); //남아있는 자리

        for(Student student : remainStudents){ //남아있는 학생 배열 순회
            Arrange assignedSeat = assignNewSeat(student, availableSeats);
            if(assignedSeat != null){
                assignedSeat.assignStudent(student);
                availableSeats.remove(assignedSeat);
                System.out.println("*Assigned student to not reserved seat: " + student.getsName() + " to seat number " + assignedSeat.getSeatNum());
            }
        }
    }

    //지정석이 아닌 학생들 목록 반환
    private List<Student> getRemainStudents() {
        List<Student> remain = new ArrayList<>();
        for (Student student : students) {
            if (!student.isReservedSeatStatus()) {
                remain.add(student);
            }
        }
        return remain;
    }

    //배정되지 않은 자리목록 반환
    private List<Arrange> getAvailableSeats() {
        List<Arrange> available = new ArrayList<>();
        for (Arrange seat : seats) {
            if (seat != null && seat.getStudent() == null) { // seat이 null이 아니고 학생이 배정되지 않은 자리
                available.add(seat);
            }
        }
        return available;
    }

    //이전 자리 및 짝꿍 피하기 메서드
    private Arrange assignNewSeat(Student student, List<Arrange> availableSeats){
        Collections.shuffle(availableSeats);//가능한 자리들을 랜덤으로 섞음.
        for(Arrange seat : availableSeats){
            if (!checkPreviousSeat(seat, student)) {
                return seat;
            }
        }
        return null; //적합한 자리 없는 경우 null 반환.
    }

    //이전 자리나 이전 짝꿍 피하는지 체크하는 메서드
    private boolean checkPreviousSeat(Arrange seat, Student student){
        int currentSeatNUm = seat.getSeatNum();
        SeatAssignment seatAssignment = student.getSeatAssignment();

        //이전 자리인지 확인
        if(seatAssignment.getPreviousTableNumber() == currentSeatNUm) {
            return true;
        }

        //이전 짝꿍인지 확인
        return checkPreviousPartner(currentSeatNUm, seatAssignment);
    }

    //이전 짝꿍 여부를 확인하는 메서드
    private boolean checkPreviousPartner(int currentSeat,SeatAssignment seatAssignment){
        //현재 자리의 양 옆 자리번호 구하기
        int leftSeat = currentSeat - 1;
        int rightSeat = currentSeat + 1;

        //양 옆 자리가 같은 분단에 있는지 확인
        if(isSameDivision(currentSeat,leftSeat)&&seatAssignment.wasPreviousSeat(leftSeat)){
            return true;
        }

        if(isSameDivision(currentSeat,rightSeat)&&seatAssignment.wasPreviousSeat(rightSeat)){
            return true;
        }
        return false;
    }

    //두 자리 번호가 같은 분단에 속하는지 확인하는 메서드
    private boolean isSameDivision(int seatNum1, int seatNum2){
        return (isInDivision(seatNum1, FIRST_SEATS)&&isInDivision(seatNum2, FIRST_SEATS))||
                (isInDivision(seatNum1, SECOND_SEATS)&&isInDivision(seatNum2, SECOND_SEATS))||
                (isInDivision(seatNum1, THIRD_SEATS)&&isInDivision(seatNum2, THIRD_SEATS));
    }

    //특정 자리 번호가 주어진 분단에 속하는지 확인
    private boolean isInDivision(int seatNum, int[] divisionsSeats){
        for(int s : divisionsSeats){
            if(s == seatNum){
                return true;
            }
        }
        return false;
    }

    public List<Arrange> getSeats() {
        return seats;
    }

}
