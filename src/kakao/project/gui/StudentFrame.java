package kakao.project.gui;

import kakao.project.student.StudentManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class StudentFrame extends JFrame{
	private JPanel student_i;
	private JTextField designated_seat_number;
	private JTextField sex;
	private JTextField name;
	private JTextField current_seat_number;
	private JTextField id;
	private JTextField design_seat_OX;
	private JTextField designed_seat_reason;
	private JTextArea student_information_print;
	private JScrollPane scrollPane;
	private JTextField presentSeat_textField;
	private JTextField sex_textField;
	private JTextField name_textField;
	private JTextField reservedNum_textField;
	private JTextField reservedYn_textField;
	private JTextField reservedRs_textField;
	private JTextField id_textField;
	private JPanel panel_5;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;

	StudentManager sm = StudentManager.getInstance();
	
	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		//Frame. setLocationRelativeTo (null) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		student_i = new JPanel();
		student_i.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(student_i);
		student_i.setLayout(null);
		
		Insets insets = new Insets(1, -3,1, -3);
		
		panel_4 = new JPanel();
		panel_4.setBounds(184, 13, 432, 546);
		student_i.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(40, 19, 351, 60);
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학생 정보 관리");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(6, 6, 133, 29);
		panel_2.add(lblNewLabel);
		
		// 뒤로가기 버튼
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("lib/backImage.png"));
		btnNewButton.setBounds(298, 7, 47, 47);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // ArrangeFrame으로 돌아가기
		        ArrangeFrame arrangeFrame = new ArrangeFrame();
		        arrangeFrame.setVisible(true);
		        dispose(); // 현재의 StudentFrame 닫기
		    }
		});
		
		lblNewLabel_1 = new JLabel("학생 정보를 입력해주세요.");
		lblNewLabel_1.setBounds(6, 37, 159, 16);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 309, 351, 200);
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_Display = new JButton("Display");
		
		btn_Display.setMargin(insets);
		btn_Display.setBounds(6, 5, 170, 30);
		panel_1.add(btn_Display);
		
		JButton btn_Search = new JButton("Search");
		
		btn_Search.setMargin(insets);
		btn_Search.setBounds(175, 5, 170, 30);
		panel_1.add(btn_Search);
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setMargin(insets);
		
		btn_Delete.setBounds(6, 35, 170, 30);
		panel_1.add(btn_Delete);
		
		JButton btn_Add = new JButton("Add");
		btn_Add.setMargin(insets);
		
		btn_Add.setBounds(175, 35, 170, 30);
		panel_1.add(btn_Add);
		
		JButton btn_Update = new JButton("Update");
		
		btn_Update.setMargin(insets);
		btn_Update.setBounds(6, 65, 170, 30);
		panel_1.add(btn_Update);
		
		JButton btn_Clean = new JButton("Clean");
		
		btn_Clean.setMargin(insets);
		btn_Clean.setBounds(175, 65, 170, 30);
		panel_1.add(btn_Clean);
		
		JButton btn_UploadFile = new JButton("Upload File");
		
		btn_UploadFile.setMargin(insets);
		btn_UploadFile.setBounds(6, 95, 339, 26);
		panel_1.add(btn_UploadFile);
		
		student_information_print = new JTextArea();
		student_information_print.setText("학생정보출력");
		student_information_print.setColumns(10);
		student_information_print.setBounds(6, 125, 339, 67);
		panel_1.add(student_information_print);
		scrollPane = new JScrollPane(student_information_print, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 125, 339, 67);
		panel_1.add(scrollPane);
		scrollPane.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 79, 351, 226);
		panel_4.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 6, 114, 220);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		id = new JTextField();
		id.setBounds(0, 6, 110, 26);
		panel_3.add(id);
		id.setEditable(false);
		id.setText("ID");
		id.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(0, 36, 110, 26);
		panel_3.add(sex);
		sex.setEditable(false);
		sex.setText("성별");
		sex.setColumns(10);
		
		name = new JTextField();
		name.setBounds(0, 67, 110, 26);
		panel_3.add(name);
		name.setEditable(false);
		name.setText("이름");
		name.setColumns(10);
		
		current_seat_number = new JTextField();
		current_seat_number.setBounds(0, 98, 110, 26);
		panel_3.add(current_seat_number);
		current_seat_number.setEditable(false);
		current_seat_number.setText("현재자리번호");
		current_seat_number.setColumns(10);
		
		design_seat_OX = new JTextField();
		design_seat_OX.setBounds(0, 129, 110, 26);
		panel_3.add(design_seat_OX);
		design_seat_OX.setEditable(false);
		design_seat_OX.setText("지정석여부");
		design_seat_OX.setColumns(10);
		
		designed_seat_reason = new JTextField();
		designed_seat_reason.setBounds(0, 160, 110, 26);
		panel_3.add(designed_seat_reason);
		designed_seat_reason.setEditable(false);
		designed_seat_reason.setText("지정석사유");
		designed_seat_reason.setColumns(10);
		
		designated_seat_number = new JTextField();
		designated_seat_number.setBounds(0, 191, 110, 26);
		panel_3.add(designated_seat_number);
		designated_seat_number.setEditable(false);
		designated_seat_number.setText("지정석자리번호");
		designated_seat_number.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setBounds(111, 6, 240, 220);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		sex_textField = new JTextField();
		sex_textField.setBounds(8, 36, 226, 26);
		panel_5.add(sex_textField);
		sex_textField.setEditable(true);
		sex_textField.setColumns(10);
		
		name_textField = new JTextField();
		name_textField.setBounds(8, 67, 226, 26);
		panel_5.add(name_textField);
		name_textField.setEditable(true);
		name_textField.setColumns(10);
		
		presentSeat_textField = new JTextField();
		presentSeat_textField.setBounds(8, 98, 226, 26);
		panel_5.add(presentSeat_textField);
		presentSeat_textField.setEditable(true);
		presentSeat_textField.setColumns(10);
		
		reservedYn_textField = new JTextField();
		reservedYn_textField.setBounds(8, 129, 226, 26);
		panel_5.add(reservedYn_textField);
		reservedYn_textField.setEditable(true);
		reservedYn_textField.setColumns(10);
		
		reservedRs_textField = new JTextField();
		reservedRs_textField.setBounds(8, 160, 226, 26);
		panel_5.add(reservedRs_textField);
		reservedRs_textField.setEditable(true);
		reservedRs_textField.setColumns(10);
		
		reservedNum_textField = new JTextField();
		reservedNum_textField.setBounds(8, 191, 226, 26);
		panel_5.add(reservedNum_textField);
		reservedNum_textField.setEditable(true);
		reservedNum_textField.setColumns(10);
		
		id_textField = new JTextField();
		id_textField.setBounds(8, 5, 226, 26);
		panel_5.add(id_textField);
		id_textField.setEditable(true);
		id_textField.setColumns(10);
		
		btn_UploadFile.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int result = fileChooser.showOpenDialog(null);

		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            StudentManager.getInstance().loadStudentDataFromFile(selectedFile);
		        }
		    }
		});
		btn_Display.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Display 학생 정보 출력
				String studentsText = sm.displayStudents();
				student_information_print.setText(studentsText);
			}
		});
		student_information_print.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				
			}
		});
		btn_Add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//추가
				int id = Integer.parseInt(id_textField.getText());
				String sex = sex_textField.getText();
				String name = name_textField.getText();
				int presentSeat = Integer.parseInt(presentSeat_textField.getText());
				boolean reservedYn = Boolean.parseBoolean(reservedYn_textField.getText());
				String reservedRs = reservedRs_textField.getText();
				int reservedNum = Integer.parseInt(reservedNum_textField.getText());
				if(reservedRs.equals("")) {
					reservedRs = null;
				}
				

				sm.addStudent(id, sex, name, presentSeat, reservedYn, reservedRs, reservedNum);
			}
		});
		btn_Clean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Clean
				id_textField.setText("");
				sex_textField.setText("");
				name_textField.setText("");
				presentSeat_textField.setText("");
				reservedYn_textField.setText("");
				reservedRs_textField.setText("");
				reservedNum_textField.setText("");
			}
		});
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//업데이트
				int id = Integer.parseInt(id_textField.getText());
				String sex = sex_textField.getText();
				String name = name_textField.getText();
				int presentSeat = Integer.parseInt(presentSeat_textField.getText());
				boolean reservedYn = Boolean.parseBoolean(reservedYn_textField.getText());
				String reservedRs = reservedRs_textField.getText();
				int reservedNum = Integer.parseInt(reservedNum_textField.getText());
				if(reservedRs.equals("")) {
					reservedRs = null;
				}
				sm.updateStudent(id, sex, name, presentSeat, reservedYn, reservedRs, reservedNum);
			}
		});
		btn_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 검색
				String studentsText = sm.searchStudent(Integer.parseInt(id_textField.getText()));
				student_information_print.setText(studentsText);
			}
		});
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//삭제
				int deleteID = Integer.parseInt(id_textField.getText());
				System.out.println(deleteID);
		        sm.deleteStudent(deleteID);
			}
		});
	}//StudentFrame()
}
