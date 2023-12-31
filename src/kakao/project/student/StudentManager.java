package kakao.project.student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	
	
	
	public List<Student> getStudents() {
        return studentArray; // 혹은 학생 목록을 저장하고 있는 필드명
    }
	/*StudentManager의 역할
	* 1. 학생 목록을 관리한다.
	* 2. 학생 데이터를 load, save, add, delete, update, search, display하는 메서드 제공
	*
	* Student와의 관계
	* 1. Student객체를 참조하여 studentArray(학생배열)을 만든다.
	*
	* 특징
	* - 싱글톤패턴으로 만들었다. (Manager라서 하나의 인스턴스만 Manager의 역할을 수행하기 위함)
	* */

	private static StudentManager instance = null;
	private ArrayList<Student> studentArray;
	public void setStudentArray(ArrayList<Student> studentArray) {
		this.studentArray = studentArray;
	}
	Scanner input = new Scanner(System.in);
	
	private StudentManager() {
		studentArray = new ArrayList<>();
	}

	public static StudentManager getInstance() {
		if (instance == null) {
			instance = new StudentManager();
		}
		return instance;
	}

	public void run() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		int cmd;

		do {
			System.out.println("1. Load Student Data");
			System.out.println("2. Save Student Data");
			System.out.println("3. Add");
			System.out.println("4. Delete");
			System.out.println("5. Update");
			System.out.println("6. Search");
			System.out.println("7. Display");
			System.out.println("8. Exit\n");

			System.out.println("Enter your choice:");
			cmd = input.nextInt();

			switch (cmd) {
				case 1:
					loadStudentData();
					break;

				case 2:
					saveStudentData();
					break;

				case 3:
//					addStudent();
					break;

				case 4:
//					deleteStudent();
					break;

				case 5:
//					updateStudent();
					break;

				case 6:
//					searchStudent();
					break;

				case 7:
					displayStudents();
					break;

				case 8:
					System.out.println("End Program");
					break;

				default:
					System.out.println("Invalid choice");
					break;
			}
		} while (cmd != 8);
	}

	public void loadStudentData() {
		try {
			File file = new File("Data.txt");
			Scanner input = new Scanner(file);
			studentArray.clear();
			while (input.hasNext()) {
				int id = input.nextInt();
				String name = input.next();
				String sex = input.next();
				int presentTableNumber = input.nextInt();
				int reservedSeatNumber = input.nextInt();
				boolean reservedSeatStatus = Boolean.parseBoolean(input.next());
				String reservedSeatReason = input.next();

				Student student = new Student();
				student.setsID(id);
				student.setsName(name);
				student.setsSex(sex);
				student.setCurrentSeatNumber(presentTableNumber);
				student.setReservedSeatNumber(reservedSeatNumber);
				student.setReservedSeatStatus(reservedSeatStatus);
				student.setReservedSeatReason(reservedSeatReason);

				studentArray.add(student);
			}

			input.close();
			System.out.println("Student data loaded successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("File not found. No data loaded.");
		}
	}

	private void saveStudentData() {
		try {
			FileWriter file = new FileWriter("Data.txt", false);
			PrintWriter output = new PrintWriter(file);

			for (Student student : studentArray) {
				output.print(student.getsID() + " ");
				output.print(student.getsName() + " ");
				output.print(student.getsSex() + " ");
				output.print(student.getCurrentSeatNumber() + " ");
				output.print(student.getReservedSeatNumber() + " ");
				output.print(student.isReservedSeatStatus() + " ");
				output.print(student.getReservedSeatReason() + " ");
				output.println();
			}

			output.close();
			System.out.println("Student data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error saving student data.");
		}
	}

//	public void addStudent() {
//		System.out.println("Enter ID:");
//		int id = input.nextInt();
//		if (isIDExists(id)) {
//			System.out.println("Add failed. Duplicate ID.");
//			return;
//		}
//
//		System.out.println("Enter Name:");
//		String name = input.next();
//		System.out.println("Enter Sex:");
//		String sex = input.next();
//		System.out.println("Enter Present Table Number:");
//		int presentTableNumber = input.nextInt();
//		System.out.println("Enter Reserved Seat (Y/N):");
//		boolean reservedSeatStatus = input.next().equalsIgnoreCase("Y");
//		int reservedSeatNumber = 0;
//		String reservedSeatReason = null;
//
//		if (reservedSeatStatus) {
//			System.out.println("Enter Reserved Seat Number:");
//			reservedSeatNumber = input.nextInt();
//			System.out.println("Enter Seat Reservation Reason:");
//			reservedSeatReason = input.next();
//		}
//
//		Student student = new Student(id, name, sex, presentTableNumber, reservedSeatNumber, reservedSeatStatus, reservedSeatReason);
//		studentArray.add(student);
//		System.out.println("Add success");
//		saveStudentData();
//	}
	public void addStudent(int id, String sex, String name, int presentTableNumber, boolean reservedSeatStatus, String reservedSeatReason, int reservedSeatNumber) {
		Student student = new Student(id, name, sex, presentTableNumber, reservedSeatNumber, reservedSeatStatus, reservedSeatReason);
		studentArray.add(student);
		System.out.println("Add success");
		saveStudentData();
	}

	public void deleteStudent(int deleteID) {
		
		Student studentToDelete = null;

		for (Student student : studentArray) {
			if (student.getsID() == deleteID) {
				studentToDelete = student;
				break;
			}
		}

		if (studentToDelete != null) {
			studentArray.remove(studentToDelete);
			saveStudentData();
			System.out.println("Delete success");
		} else {
			System.out.println("Student not found.");
		}
	}

	public void updateStudent(int id, String sex, String name,  int presentSeat, boolean reservedYn ,String reservedRs, int reservedNum) {

		Student studentToUpdate = null;

		for (Student student : studentArray) {
			if (student.getsID() == id) {
				studentToUpdate = student;
				break;
			}
		}

		if (studentToUpdate != null) {

			if (!name.isEmpty()) {
				studentToUpdate.setsName(name);
			}


			if (!sex.isEmpty()) {
				studentToUpdate.setsSex(sex);
			}


			if (presentSeat != 0) {
				studentToUpdate.setCurrentSeatNumber(presentSeat);
			}

//			System.out.println("Enter Updated Reserved Seat (Y/N):");
//			String updatedReservedSeatInput = input.next();
			if (reservedYn) {
				studentToUpdate.setReservedSeatNumber(reservedNum);
				studentToUpdate.setReservedSeatReason(reservedRs);
			}

			studentToUpdate.setReservedSeatStatus(reservedYn);

			saveStudentData();
			System.out.println("Update success");
		} else {
			System.out.println("Student not found.");
		}
	}

	public String searchStudent(int searchID) {
//		System.out.println("Enter search ID:");
//		int searchID = input.nextInt();
		String studentsText = "";
		 for (Student std : studentArray) {
	         if (std.getsID() == searchID) {
	      System.out.println(std.getsID() + " " + std.getsName() + " " + std.getsSex() + " " + std.getCurrentSeatNumber()
	      + " " + std.isReservedSeatStatus()
	      + " " + std.getReservedSeatReason());
	      	studentsText += std.getsID() + " " + std.getsName() + " " + std.getsSex() + " " + std.getCurrentSeatNumber()
		      + " " + std.isReservedSeatStatus()
		      + " " + std.getReservedSeatReason();
	            return studentsText;
	         }
	      }
	      System.out.println("Not found");
	      return "Not found";
	}

	public String displayStudents() {
		String studentsText = "";
		  for (int i=0; i<studentArray.size(); i++) {
		         System.out.print(studentArray.get(i).getsID()+" ");
		         System.out.print(studentArray.get(i).getsName()+" ");
		         System.out.print(studentArray.get(i).getsSex()+" ");
		         System.out.print(studentArray.get(i).getCurrentSeatNumber()+" ");
		         System.out.print(studentArray.get(i).isReservedSeatStatus()+" ");
		         System.out.println(studentArray.get(i).getReservedSeatReason());
		         studentsText += studentArray.get(i).getsID() + " ";
		         studentsText += studentArray.get(i).getsName() + " ";
		         studentsText += studentArray.get(i).getsSex() + " ";
		         studentsText += studentArray.get(i).getCurrentSeatNumber() + " ";
		         studentsText += studentArray.get(i).isReservedSeatStatus() + " ";
		         studentsText += studentArray.get(i).getReservedSeatReason() + " ";
		         studentsText += "\n";
		      }
		  
		  return studentsText;
	}

	private boolean isIDExists(int id) {
		for (Student student : studentArray) {
			if (student.getsID() == id) {
				return true;
			}
		}
		return false;
	}
	public void loadStudentDataFromFile(File file) {
			try {
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        String line;

		        while ((line = reader.readLine()) != null) {
		            String[] data = line.split(" ");

		            int id = Integer.parseInt(data[0]);
		            String name = data[1];
		            String sex = data[2];
		            int presentTableNumber = Integer.parseInt(data[3]);
		            int reservedSeatNumber = Integer.parseInt(data[4]);
		            boolean reservedSeatStatus = Boolean.parseBoolean(data[5]);
		            String reservedSeatReason = data[6];

		            Student student = new Student(id, name, sex, presentTableNumber, reservedSeatNumber, reservedSeatStatus, reservedSeatReason);
		            studentArray.add(student);
		        }

		        reader.close();
		        System.out.println("Student data loaded successfully.");
		    } catch (FileNotFoundException e) {
		        System.out.println("File not found. No data loaded.");
		    } catch (IOException e) {
		        e.printStackTrace();
		        System.out.println("Error reading student data.");
		    }
	    }
}
