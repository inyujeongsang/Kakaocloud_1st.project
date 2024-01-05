package kakao.project.student;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager {

	static ArrayList<Student> StudentArray = new ArrayList<>();
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		
		Scanner input = new Scanner(System.in);
		int cmd;
		do {

			
			System.out.println("1. loadStudentData ");
			System.out.println("2. saveStudentData ");
			System.out.println("3. Add ");
			System.out.println("4. Delete ");
			System.out.println("5. Update ");
			System.out.println("6. Search ");
			System.out.println("7. Display ");
			System.out.println("8. Exit\n\n");

			System.out.println("Enter your choice:");
			cmd = input.nextInt();
			System.out.println(cmd);

			switch (cmd) {
			case 1:
				loadStudentData();
				break;

			case 2:
				saveStudentData();
				break;
			case 3:
				System.out.println("Enter ID:");
				int sID = input.nextInt();
				System.out.println("Enter Name:");
				String sName = input.next();
				System.out.println("Enter Sex:");
				String sSex = input.next();
				System.out.println("Enter Present Table Number:");
				int sPresentTableNumber = input.nextInt();
				
				System.out.println("Enter Reserved Seat (Y/N):");
			    String sReservedSeatInput = input.next();
			    boolean sReservedSeatYN = sReservedSeatInput.equalsIgnoreCase("Y");
			    String sreservedSeatReason = null;
			    if (sReservedSeatYN) {
			        System.out.println("Enter Seat Reservation Reason:");
			        sreservedSeatReason = input.next();
			    }
				
				add(sID, sName, sSex, sPresentTableNumber, sReservedSeatYN, sreservedSeatReason);
				break;

			case 4:
				System.out.println("Enter delete ID:");
				int deleteID = input.nextInt();
				delete(deleteID);
				break;
				
			case 5:
				System.out.println("Enter ID:");
				int updateID = input.nextInt();
				System.out.println("Enter Name:");
				String updateName = input.next();
				System.out.println("Enter Sex:");
				String updateSex = input.next();
				System.out.println("Enter Present Table Number:");
				int updatePresentTableNumber = input.nextInt();
				
				System.out.println("Enter Updated Reserved Seat (Y/N):");
				String updatedReservedSeatInput = input.next();
				boolean updatedReservedSeatYN = updatedReservedSeatInput.equalsIgnoreCase("Y");
				String updatedreservedSeatReason = null;
				if (updatedReservedSeatYN) {
					System.out.println("Enter Updated Seat Reservation Reason:");
				    updatedreservedSeatReason = input.next();
				   }
				
				update(updateID, updateName, updateSex, updateID, updatedReservedSeatYN, updatedreservedSeatReason);
				break;
			case 6:
				System.out.println("Enter search ID:");
				int searchID = input.nextInt();
				search(searchID);
				break;
	
			case 7:
				
				display();
				break;
			case 8:
				
				System.out.println("End Program");
				break;
				
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (cmd != 8);
		
		

	}//main


	private static void loadStudentData() {
		File file = new File("Data.txt");

		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ee) {
			ee.printStackTrace();
			return;
		}

		while (input.hasNext()) {
			int id = input.nextInt();
			String name = input.next();
			String Sex = input.next();
			int PresentTableNumber = input.nextInt();
			boolean ReservedSeatYN = Boolean.parseBoolean(input.next());
			String reservedSeatReason = input.next();
			
			Student std = new Student();
			std.setsID(id);
			std.setsName(name);
			std.setsSex(Sex);
			std.setCurrentSeatNumber(PresentTableNumber);
			std.setReservedSeatStatus(ReservedSeatYN);
			std.setReservedSeatReason(reservedSeatReason);
			
			
			StudentArray.add(std);
		}
		input.close();
		//System.out.println(StudentArray);
	}//loadStudentData
	
	private static void saveStudentData() {
		FileWriter file = null;
		PrintWriter output = null;
		try {
			file = new FileWriter("Data.txt", false);
			output = new PrintWriter(file);

		} catch (FileNotFoundException e) {
			File f = new File("Data.txt");
			try {
				file = new FileWriter(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Student std : StudentArray) {
			output.print(std.getsID());
			output.print(" ");
			output.print(std.getsName());
			output.print(" ");
			output.print(std.getsSex());
			output.print(" ");
			output.print(std.getCurrentSeatNumber());
			output.print(" ");
			output.print(std.isReservedSeatStatus());
			output.print(" ");
			output.print(std.getReservedSeatReason());
			output.println(" ");
		}
		output.close();
	}//saveStudentData

	private static void add(int id, String name, String Sex, int currentSeatNumber, boolean reservedSeatStatus, String reservedSeatReason) {
		for (Student std : StudentArray) {
			if (std.getsID() == id) {
				System.out.println("Add failed. dup id");
				return;
			}
		}

		Student std = new Student();
		std.setsID(id);
		std.setsName(name);
		std.setsSex(Sex);
		std.setCurrentSeatNumber(currentSeatNumber);
		std.setReservedSeatStatus(reservedSeatStatus);
	    std.setReservedSeatReason(reservedSeatReason);
		StudentArray.add(std);
		System.out.println("Add success");
		saveStudentData();
	}//add

	private static void delete(int id) {
		for (Student std : StudentArray) {
			if (std.getsID() == id) {
				StudentArray.remove(std);
				saveStudentData();
				System.out.println("Delete success");
				return;
			}
		}
	}//delete
	
	private static void update(int id, String name, String Sex, int PresentTableNumber, boolean ReservedSeatYN, String reservedSeatReason) {
		for (Student std : StudentArray) {
			if (std.getsID() == id) {
				if (name != null) {
					std.setsName(name);
				}
				if (Sex != null) {
					std.setsSex(Sex);
				}
				if (PresentTableNumber != 0) {
					std.setCurrentSeatNumber(PresentTableNumber);
				}
				std.setReservedSeatStatus(ReservedSeatYN);
	            std.setReservedSeatReason(reservedSeatReason);
	            saveStudentData();
				System.out.println("Update success");
				return;
			}
		}
	}

	private static void search(int id) {
		for (Student std : StudentArray) {
			if (std.getsID() == id) {
		System.out.println(std.getsID() + " " + std.getsName() + " " + std.getsSex() + " " + std.getCurrentSeatNumber()
		+ " " + std.isReservedSeatStatus()
		+ " " + std.getReservedSeatReason());
				return;
			}
		}
		System.out.println("Not found");

	}//search

	private static void display() {
		for (int i=0; i<StudentArray.size(); i++) {
			System.out.print(StudentArray.get(i).getsID()+" ");
			System.out.print(StudentArray.get(i).getsName()+" ");
			System.out.print(StudentArray.get(i).getsSex()+" ");
			System.out.print(StudentArray.get(i).getCurrentSeatNumber()+" ");
			System.out.print(StudentArray.get(i).isReservedSeatStatus()+" ");
			System.out.println(StudentArray.get(i).getReservedSeatReason());
		}
		
	}//display
	
	
};
