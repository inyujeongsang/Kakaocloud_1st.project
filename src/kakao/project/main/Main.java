package kakao.project.main;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import kakao.project.arrange.ArrangeManager;
import kakao.project.gui.ArrangeFrame;
import kakao.project.gui.MyFrame;
import kakao.project.student.StudentManager;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrangeFrame frame = new ArrangeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Scanner input = new Scanner(System.in);
	        StudentManager studentManager = StudentManager.getInstance();
	        ArrangeManager arrangeManager = ArrangeManager.getInstance(studentManager.getStudents());

	        int choice;
	        do {
	            System.out.println("1. Manage Students");
	            System.out.println("2. Manage Seats");
	            System.out.println("3. Exit");
	            System.out.println("Enter your choice:");

	            choice = input.nextInt();

	            switch (choice) {
	                case 1:
	                    studentManager.run();
	                    break;
	                case 2:
	                    arrangeManager.allocateSeats();
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice");
	                    break;
	            }
	        } while (choice != 3);

	        input.close();
	}

}
