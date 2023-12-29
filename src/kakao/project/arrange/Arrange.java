package kakao.project.arrange;

import kakao.project.student.Student;

import java.awt.*;

public class Arrange {
    private int seatNum; //자리 번호
    private Student student; //자리에 배정된 학생, null일 수 있음.
    private boolean isDesignated; //지정석 여부

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

    public boolean isDesignated() {
        return isDesignated;
    }

    // setter
    public void setDesignated(boolean isDesignated) {
        this.isDesignated = isDesignated;
    }

    //지정석 메서드
    public void assignStudent(Student student) {
        this.student = student;
    }
}
