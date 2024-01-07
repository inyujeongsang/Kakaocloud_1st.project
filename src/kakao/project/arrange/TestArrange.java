package kakao.project.arrange;

import kakao.project.student.Student;

import java.util.ArrayList;
import java.util.List;

public class TestArrange {
        public static void main(String[] args) {
            // 학생 데이터를 생성 및 초기화
            List<Student> students = new ArrayList<>();
            // 학생 데이터를 생성 및 초기화하는 코드를 여기에 추가

            // ArrangeManager 인스턴스 생성
            ArrangeManager arrangeManager = ArrangeManager.getInstance(students);

            // 좌석 배정 실행
            arrangeManager.allocateSeats();

            // 배정된 좌석 및 학생 정보 출력
            List<Arrange> seats = arrangeManager.getSeats();
            for (Arrange seat : seats) {
                if (seat.getStudent() != null) {
                    System.out.println("Seat Number: " + seat.getSeatNum());
                    System.out.println("Student Name: " + seat.getStudent());
                    // 필요한 학생 정보 출력 추가
                }
            }

        }
}
