package kakao.project.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrame extends JFrame{
    private JPanel student_i;
    private JTextField designated_seat_number;
    private JTextField sex;
    private JTextField name;
    private JTextField current_seat_number;
    private JTextField id;
    private JTextField design_seat_OX;
    private JTextField designed_seat_reason;
    private JTextField student_information_print;
    private JTextField textField_4;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_7;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_1;
    private JPanel panel_5;
    private JPanel panel_4;
    private JLabel lblNewLabel_1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentFrame frame = new StudentFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public StudentFrame() {
        //Frame. setLocationRelativeTo (null) ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);//브라우저 창 크기
        student_i = new JPanel();
        student_i.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(student_i);
        student_i.setLayout(null);

        Insets insets = new Insets(1, -3,1, -3);

        panel_4 = new JPanel(); //container 패널
        panel_4.setBounds(184, 13, 432, 546);
        student_i.add(panel_4);
        panel_4.setLayout(null);

        JPanel panel_2 = new JPanel(); //header 패널
        panel_2.setBounds(40, 19, 351, 60);
        panel_4.add(panel_2); //하위 패널로 넣는다.
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("학생 정보 관리");  // 제목
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT); //정렬 왼쪽으로
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20)); //제목 style
        lblNewLabel.setBounds(6, 6, 133, 29); //자리 차지
        panel_2.add(lblNewLabel); //패널2에 제목 넣는다.

        JButton btnNewButton = new JButton(""); //text를 넣으면 그림 밀리니까 ""이렇게 설정.
        btnNewButton.setIcon(new ImageIcon("/Users/kimminhyuk/Desktop/KakaoTalk_Photo_2024-01-05-17-39-20.png")); //뒤로가기 이미지
        btnNewButton.setBounds(298, 7, 47, 46);
        panel_2.add(btnNewButton); //패널2에 뒤로가기 버튼 넣는다.

        lblNewLabel_1 = new JLabel("학생 정보를 입력해주세요.");//header 붙임말
        lblNewLabel_1.setBounds(6, 37, 159, 16);
        panel_2.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel(); //기능 버튼을 담고 있는 box
        panel_1.setBounds(40, 309, 351, 200);
        panel_4.add(panel_1); //container에 넣는다.
        panel_1.setLayout(null);

        JButton btn_Display = new JButton("Display"); //display 버튼
        btn_Display.setMargin(insets);
        btn_Display.setBounds(6, 5, 170, 30);
        panel_1.add(btn_Display);

        JButton btn_Search = new JButton("Search");
        btn_Search.setMargin(insets); //insets정보를 margin처리한다. (창희 임의값)
        btn_Search.addActionListener(new ActionListener() { //버튼 클릭이벤트
            public void actionPerformed(ActionEvent e) { //클릭하면 실행되는 메서드(어떤 메서드인지 확인 필요)
            }
        });
        btn_Search.setBounds(175, 5, 170, 30);
        panel_1.add(btn_Search);

        JButton btn_Delete = new JButton("Delete");
        btn_Delete.setMargin(insets);
        btn_Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn_Delete.setBounds(6, 35, 170, 30);
        panel_1.add(btn_Delete);

        JButton btn_Add = new JButton("Add");
        btn_Add.setMargin(insets);
        btn_Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
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

        student_information_print = new JTextField();
        student_information_print.setText("학생정보출력");
        student_information_print.setColumns(10);//텍스트필드의 너비.
        student_information_print.setBounds(6, 125, 339, 67);
        panel_1.add(student_information_print);

        JPanel panel = new JPanel();//텍스트 라벨 (=텍스트 필드 editable false) + 텍스트 필드 모음
        panel.setBounds(40, 79, 351, 226);
        panel_4.add(panel);
        panel.setLayout(null);

        JPanel panel_3 = new JPanel();//panel의 하위 패널 _ 텍스트 라벨
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

        panel_5 = new JPanel();  //panel의 하위 패널_텍스트 입력 필드 모음
        panel_5.setBounds(111, 6, 240, 220);
        panel.add(panel_5);
        panel_5.setLayout(null);

        //textField들을 가독성 좋게 바꿀 것.
        textField_2 = new JTextField();
        textField_2.setBounds(8, 36, 226, 26);
        panel_5.add(textField_2);
        textField_2.setEditable(true);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(8, 67, 226, 26);
        panel_5.add(textField_3);
        textField_3.setEditable(true);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(8, 98, 226, 26);
        panel_5.add(textField_4);
        textField_4.setEditable(true);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(8, 129, 226, 26);
        panel_5.add(textField_5);
        textField_5.setEditable(true);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(8, 160, 226, 26);
        panel_5.add(textField_6);
        textField_6.setEditable(true);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setBounds(8, 191, 226, 26);
        panel_5.add(textField_7);
        textField_7.setEditable(true);
        textField_7.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(8, 5, 226, 26);
        panel_5.add(textField_1);
        textField_1.setEditable(true);
        textField_1.setColumns(10);
        btn_UploadFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn_Display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}