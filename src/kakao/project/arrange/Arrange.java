package kakao.project.arrange;

import kakao.project.student.Student;

public class Arrange {
    /*Arrange 클래스의 역할
    * 1. 개별 좌석을 나타낸다.
    * 2. 각 좌석에는 학생이 배정될 수 있다.
    * 3. 좌석번호와 학생정보를 가지고 있다.
    *
    * 이 클래스가 꼭 필요한 이유
    * 1. 학생과 좌석을 연결해준다.
    * 2. 학생이 자리를 옮길 때, 현재 자리와 이전 자리를 추적해야한다.
    * 이 클래스는 현재 좌석과 이전 좌석 정보를 저장하기에 학생의 자리 이동을 관리할 수 있다.
    * */
    private int seatNum; //자리 번호
    private Student student; //자리에 배정된 학생, null일 수 있음.

    //생성자
    public Arrange(int seatNum){
        this.seatNum = seatNum;
        this.student = null;
    }


    //getter
    public int getSeatNum(){
        return seatNum;
    }

    public Student getStudent() {
        return student;
    }

    public void assignStudent(Student student){
        this.student = student;
    }
}