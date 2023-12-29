package kakao.project.arrange;

import kakao.project.student.Student;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class ArrangeManager implements SeatColor{
    private List<Arrange> seats;
    private List<Student> students;
    public static final int SEAT_NUMBER = 26;
    public static final int CIRCLE_SIZE = 5;
    
    public ArrangeManager(List<Student> students, int SEAT_NUMBER){
        this.students = students;
        this.seats = new ArrayList<>(SEAT_NUMBER);
        initializeSeats(SEAT_NUMBER); //자리 초기화
    }

    //자리 초기화
    private void initializeSeats(int SEAT_NUMBER) {
        for(int i = 0; i < SEAT_NUMBER; i++){
            seats.add(new Arrange(i));
        }
    }

    public void allocateSeats() {
        // 먼저 지정석에 학생 배치
        for (Student student : students) {
//            if (student.isDesignated) { //지정석여부 체크
//                seats.get(student.designatedSeatNumber).assignStudent(student);
//                //지정석번호를 get해오고 학생과 매칭시켜줌.
//            }
        }

        // 지정석이 아닌 나머지 자리에 랜덤으로 학생 배치
        List<Student> remainStudents = getRemainStudents();
        List<Arrange> availableSeats = getAvailableSeats();

        Collections.shuffle(remainStudents);//남아있는 학생들로 셔플
        for (int i = 0; i < remainStudents.size(); i++) {
            availableSeats.get(i).assignStudent(remainStudents.get(i));
        }
        
        for(int j=0; j < students.size(); j++) {
        	if(students.get(j).getSex() == "Men") {
        		setMenSeatColor(g);
        	}else if(students.get(j).getSex() == "Women") {
        		setWomenSeatColor(g);
        	}else {
        		setReaderSeatColor(g);
        	}
        }
    }

    //남아있는 학생 배열에 넣기
    private List<Student> getRemainStudents() {
        List<Student> remain = new ArrayList<>();
        for (Student student : students) {
//            if (!student.isDesignated) {
//                remain.add(student);
//            }
        }
        return remain;
    }

    //랜덤자리배치 가능한 좌석 배열에 넣기
    private List<Arrange> getAvailableSeats() {
        List<Arrange> available = new ArrayList<>();
        for (Arrange seat : seats) {
            if (seat.getStudent() == null) { // 아직 학생이 배정되지 않은 자리
                available.add(seat);
            }
        }
        return available;
    }


	@Override
	public void setMenSeatColor(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(0,0,CIRCLE_SIZE,CIRCLE_SIZE);
	}

	@Override
	public void setWomenSeatColor(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(0,0,CIRCLE_SIZE,CIRCLE_SIZE);		
	}

	@Override
	public void setReaderSeatColor(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(0,0,CIRCLE_SIZE,CIRCLE_SIZE);
	}

}
