package kakao.project.gui;

// Java AWT와 Swing 라이브러리를 임포트하여 GUI 구성 요소 사용
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// JFrame, JPanel, JLabel 등 Swing 컴포넌트를 사용하기 위한 임포트
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

// 파일 입출력을 위한 java.io 패키지 임포트
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// ArrayList와 Scanner를 사용하기 위한 임포트
import java.util.ArrayList;
import java.util.Scanner;

public class Information extends JFrame {

    // GUI 컴포넌트 선언
    private JPanel contentPane;
    private JTextField StudnetID;
    private JTextField StudentName;
    private JTextField StduentSEX;
    private JTextField StudentPresentTableNumber;
    JTextArea displayArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(displayArea);

    // 학생 정보를 저장하는 ArrayList 선언
    ArrayList<Student> StudentArray = new ArrayList<Student>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test frame = new Test();
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
    public Information() {
        // 파일에서 학생 데이터를 로드하는 메소드 호출
        loadStudentData();
        // 프레임의 기본 닫기 동작 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 프레임의 위치와 크기 설정
        setBounds(100, 100, 558, 426);
        // 패널 초기화 및 설정
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student ID");
        l1.setBackground(Color.ORANGE);
        l1.setBounds(14, 9, 143, 18);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Student Name");
        l2.setBounds(14, 39, 111, 18);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Student Sex");
        l3.setBounds(14, 69, 111, 18);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Student PTN");
        l4.setBounds(14, 99, 143, 18);
        contentPane.add(l4);

        StudnetID = new JTextField();
        StudnetID.setBackground(Color.PINK);
        StudnetID.setBounds(139, 6, 116, 24);
        contentPane.add(StudnetID);
        StudnetID.setColumns(10);

        StudentName = new JTextField();
        StudentName.setBounds(139, 36, 116, 24);
        contentPane.add(StudentName);
        StudentName.setColumns(10);

        StduentSEX = new JTextField();
        StduentSEX.setBounds(139, 66, 116, 24);
        contentPane.add(StduentSEX);
        StduentSEX.setColumns(10);

        StudentPresentTableNumber = new JTextField();
        StudentPresentTableNumber.setBounds(139, 96, 116, 24);
        contentPane.add(StudentPresentTableNumber);
        StudentPresentTableNumber.setColumns(10);

        JButton btnDisplay = new JButton("Display");
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                for (Student std : StudentArray) {
                    displayArea.append(std.getID() + " " + std.getName() + " " + std.getSex() + " "
                            + std.getPresnetTableNumber() + "\n");
                }
                displayArea.setCaretPosition(displayArea.getDocument().getLength());
            }
        });
        btnDisplay.setBounds(50, 130, 105, 27);
        contentPane.add(btnDisplay);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(StudnetID.getText());
                String Name = StudentName.getText();
                String Sex = StduentSEX.getText();
                int PresentTableNumber = Integer.parseInt(StudentPresentTableNumber.getText());


                add(id, Name, Sex, PresentTableNumber);

            }
        });
        btnAdd.setBounds(50, 170, 105, 27);
        contentPane.add(btnAdd);

        displayArea.setEditable(false);
        displayArea.setBackground(Color.LIGHT_GRAY);
        scrollPane.setBounds(51, 228, 425, 108);

        contentPane.add(scrollPane);

        JButton btnsearch = new JButton("search");
        btnsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(StudnetID.getText());
                search(id);
            }
        });
        btnsearch.setBounds(200, 130, 105, 27);
        contentPane.add(btnsearch);

        JButton btnupdate = new JButton("update");
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(StudnetID.getText());
                String Name = StudentName.getText();
                String Sex = StduentSEX.getText();
                int PresentTableNumber = Integer.parseInt(StudentPresentTableNumber.getText());
                update(id, Name, Sex, PresentTableNumber);
            }
        });
        btnupdate.setBounds(200, 170, 105, 27);
        contentPane.add(btnupdate);

        JButton btndelete = new JButton("delete");
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(StudnetID.getText());
                delete(id);
            }
        });
        btndelete.setBounds(350, 130, 105, 27);
        contentPane.add(btndelete);

        JButton btnclear = new JButton("clear");

        btnclear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                StudnetID.setText("");
                StudentName.setText("");
                StduentSEX.setText("");
                StudentPresentTableNumber.setText("");

            }

        });

        btnclear.setBounds(350, 170, 105, 27);

        contentPane.add(btnclear);

    }

    private void loadStudentData() {
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

            Student std = new Student();
            std.setID(id);
            std.setName(name);
            std.setSex(Sex);
            std.setPresentTableNumber(PresentTableNumber);
            StudentArray.add(std);
        }
        input.close();
    }

    private void saveStudentData() {
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
            output.print(std.getID());
            output.print(" ");
            output.print(std.getName());
            output.print(" ");
            output.print(std.getSex());
            output.print(" ");
            output.println(std.getPresnetTableNumber());
        }
        output.close();
    }

    private void add(int id, String name, String Sex, int PresentTableNumber) {
        for (Student std : StudentArray) {
            if (std.getID() == id) {
                displayArea.setText("Add failed. dup id");
                return;
            }
        }

        Student std = new Student();
        std.setID(id);
        std.setName(name);
        std.setSex(Sex);
        std.setPresentTableNumber(PresentTableNumber);
        StudentArray.add(std);
        displayArea.setText("Add success");
        saveStudentData();
    }

    private void update(int id, String name, String Sex, int PresentTableNumber) {
        for (Student std : StudentArray) {
            if (std.getID() == id) {
                if (name != null) {
                    std.setName(name);
                }
                if (Sex != null) {
                    std.setSex(Sex);
                }
                if (PresentTableNumber != 0) {
                    std.setPresentTableNumber(PresentTableNumber);
                }
                saveStudentData();
                displayArea.setText("Update success");
                return;
            }
        }
    }

    private void delete(int id) {
        for (Student std : StudentArray) {
            if (std.getID() == id) {
                StudentArray.remove(std);
                saveStudentData();
                displayArea.setText("Delete success");
                return;
            }
        }
    }

    private void search(int id) {
        for (Student std : StudentArray) {
            if (std.getID() == id) {
                displayArea.setText(
                        std.getID() + " " + std.getName() + " " + std.getSex() + " " + std.getPresnetTableNumber());
                return;
            }
        }
        displayArea.setText("Not found");

    }
}
