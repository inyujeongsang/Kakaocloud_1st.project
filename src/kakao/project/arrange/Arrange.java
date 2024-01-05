package kakao.project.arrange;

import kakao.project.student.Student;

public class Arrange {
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
