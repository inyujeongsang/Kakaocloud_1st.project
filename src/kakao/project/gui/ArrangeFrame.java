package kakao.project.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.AWTException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import kakao.project.arrange.Arrange;
import kakao.project.arrange.ArrangeManager;
import kakao.project.student.Student;
import kakao.project.student.StudentManager;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class ArrangeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Teacher;
	private JTextField textField_Title;
	private JButton[] buttonsArray; // 버튼 배열
	
	/**
	 * Create the frame.
	 */
	public ArrangeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton peoples = new JButton("");
		peoples.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//학생 정보 프레임 실행
				StudentFrame studentFrame = new StudentFrame();
    	        		studentFrame.setVisible(true);
    	        		dispose();
			}
		});
		peoples.setForeground(Color.BLACK);
		peoples.setBackground(Color.BLACK);
		peoples.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\1stProjectImage\\KakaoTalk_20240104_163010490_05.png"));
		peoples.setBounds(10, 56, 55, 40);
		contentPane.add(peoples);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(578, 115, 196, 41);
		contentPane.add(panel_1);
		
		textField_Teacher = new JTextField("강사님 책상");
		textField_Teacher.setBackground(new Color(192, 192, 192));
		textField_Teacher.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		textField_Teacher.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_Teacher);
		textField_Teacher.setColumns(12);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 214, 41);
		contentPane.add(panel_2);
		
		textField_Title = new JTextField();
		textField_Title.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		textField_Title.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Title.setBackground(Color.WHITE);
		textField_Title.setText("랜덤 자리 배치프로그램");
		panel_2.add(textField_Title);
		textField_Title.setColumns(13);
		
		JButton play = new JButton("");
		play.setBackground(Color.BLACK);
		play.setForeground(Color.BLACK);
		play.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\1stProjectImage\\KakaoTalk_20240104_163010490_01.png"));
		play.setBounds(69, 56, 55, 40);
		contentPane.add(play);
		
		JButton fileSave = new JButton("");
		fileSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	        try {
		    	            ArrangeFrame frame = (ArrangeFrame) SwingUtilities.getWindowAncestor(fileSave);
		    	            // ArrangeFrame의 위치와 크기 얻기
		    	            Rectangle frameRect = frame.getBounds();
    	            
		    	            // ArrangeFrame의 위치로 이동하여 캡쳐
		    	            Robot robot = new Robot();
		    	            BufferedImage screenshot = robot.createScreenCapture(frameRect);
    	            
		    	            // 파일 저장
		    	            String fileName = "screenshot_" + System.currentTimeMillis() + ".png";
		    	            File output = new File(fileName);
		    	            ImageIO.write(screenshot, "png", output);
    	            
		    	            System.out.println("스크린샷이 저장되었습니다: " + fileName);
		    	        } catch (AWTException | IOException ex) {
		    	            ex.printStackTrace();
		    	        }
		    	    }
		});
		fileSave.setForeground(Color.BLACK);
		fileSave.setBackground(Color.BLACK);
		fileSave.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\1stProjectImage\\KakaoTalk_20240104_163010490_03.png"));
		fileSave.setBounds(129, 56, 55, 40);
		contentPane.add(fileSave);
		
		JPanel panel_seat = new JPanel();
		panel_seat.setForeground(Color.WHITE);
		panel_seat.setBackground(Color.WHITE);
		panel_seat.setBounds(10, 158, 765, 350);
		contentPane.add(panel_seat);
		panel_seat.setLayout(null);
		
		JButton seatNumber_1 = new JButton("1");
		seatNumber_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_1.setBounds(12, 35, 95, 56);
		panel_seat.add(seatNumber_1);
		
		JButton seatNumber_2 = new JButton("2");
		seatNumber_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_2.setBounds(113, 35, 95, 56);
		panel_seat.add(seatNumber_2);
		
		JButton seatNumber_3 = new JButton("3");
		seatNumber_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_3.setBounds(237, 35, 95, 56);
		panel_seat.add(seatNumber_3);
		
		JButton seatNumber_4 = new JButton("4");
		seatNumber_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_4.setBounds(338, 35, 95, 56);
		panel_seat.add(seatNumber_4);
		
		JButton seatNumber_5 = new JButton("5");
		seatNumber_5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_5.setBounds(441, 35, 95, 56);
		panel_seat.add(seatNumber_5);
		
		JButton seatNumber_6 = new JButton("6");
		seatNumber_6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_6.setBounds(565, 35, 95, 56);
		panel_seat.add(seatNumber_6);
		
		JButton seatNumber_7 = new JButton("7");
		seatNumber_7.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_7.setBounds(666, 35, 95, 56);
		panel_seat.add(seatNumber_7);
		
		JButton seatNumber_8 = new JButton("8");
		seatNumber_8.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_8.setBounds(12, 97, 95, 56);
		panel_seat.add(seatNumber_8);
		
		JButton seatNumber_9 = new JButton("9");
		seatNumber_9.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_9.setBounds(113, 97, 95, 56);
		panel_seat.add(seatNumber_9);
		
		JButton seatNumber_10 = new JButton("10");
		seatNumber_10.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_10.setBounds(237, 97, 95, 56);
		panel_seat.add(seatNumber_10);
		
		JButton seatNumber_11 = new JButton("11");
		seatNumber_11.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_11.setBounds(338, 97, 95, 56);
		panel_seat.add(seatNumber_11);
		
		JButton seatNumber_12 = new JButton("12");
		seatNumber_12.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_12.setBounds(441, 97, 95, 56);
		panel_seat.add(seatNumber_12);
		
		JButton seatNumber_13 = new JButton("13");
		seatNumber_13.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_13.setBounds(565, 97, 95, 56);
		panel_seat.add(seatNumber_13);
		
		JButton seatNumber_14 = new JButton("14");
		seatNumber_14.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_14.setBounds(666, 97, 95, 56);
		panel_seat.add(seatNumber_14);
		
		JButton seatNumber_15 = new JButton("15");
		seatNumber_15.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_15.setBounds(12, 159, 95, 56);
		panel_seat.add(seatNumber_15);
		
		JButton seatNumber_16 = new JButton("16");
		seatNumber_16.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_16.setBounds(113, 159, 95, 56);
		panel_seat.add(seatNumber_16);
		
		JButton seatNumber_17 = new JButton("17");
		seatNumber_17.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_17.setBounds(237, 159, 95, 56);
		panel_seat.add(seatNumber_17);
		
		JButton seatNumber_18 = new JButton("18");
		seatNumber_18.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_18.setBounds(338, 159, 95, 56);
		panel_seat.add(seatNumber_18);
		
		JButton seatNumber_19 = new JButton("19");
		seatNumber_19.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_19.setBounds(441, 159, 95, 56);
		panel_seat.add(seatNumber_19);
		
		JButton seatNumber_20 = new JButton("20");
		seatNumber_20.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_20.setBounds(565, 159, 95, 56);
		panel_seat.add(seatNumber_20);
		
		JButton seatNumber_21 = new JButton("21");
		seatNumber_21.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_21.setBounds(666, 159, 95, 56);
		panel_seat.add(seatNumber_21);
		
		JButton seatNumber_22 = new JButton("22");
		seatNumber_22.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_22.setBounds(237, 221, 95, 56);
		panel_seat.add(seatNumber_22);
		
		JButton seatNumber_23 = new JButton("23");
		seatNumber_23.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_23.setBounds(338, 221, 95, 56);
		panel_seat.add(seatNumber_23);
		
		JButton seatNumber_24 = new JButton("24");
		seatNumber_24.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_24.setBounds(441, 221, 95, 56);
		panel_seat.add(seatNumber_24);
		
		JButton seatNumber_25 = new JButton("25");
		seatNumber_25.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_25.setBounds(565, 221, 95, 56);
		panel_seat.add(seatNumber_25);
		
		JButton seatNumber_26 = new JButton("26");
		seatNumber_26.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_26.setBounds(666, 221, 95, 56);
		panel_seat.add(seatNumber_26);
		
		JButton seatNumber_27 = new JButton("27");
		seatNumber_27.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_27.setBounds(565, 283, 95, 56);
		panel_seat.add(seatNumber_27);
		
		JButton seatNumber_28 = new JButton("28");
		seatNumber_28.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		seatNumber_28.setBounds(666, 283, 95, 56);
		panel_seat.add(seatNumber_28);
		
		JLabel door = new JLabel("");
		door.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\1stProjectImage\\KakaoTalk_20240104_174820270.png"));
		door.setHorizontalAlignment(SwingConstants.CENTER);
		door.setBounds(-14, 233, 84, 117);
		panel_seat.add(door);
		
		//버튼 배열 초기화
		buttonsArray = new JButton[] {
			seatNumber_1, seatNumber_2, seatNumber_3, seatNumber_4,
			seatNumber_5, seatNumber_6, seatNumber_7, seatNumber_8,
			seatNumber_9, seatNumber_10, seatNumber_11, seatNumber_12,
			seatNumber_13, seatNumber_14, seatNumber_15, seatNumber_16,
			seatNumber_17, seatNumber_18, seatNumber_19, seatNumber_20,
			seatNumber_21, seatNumber_22, seatNumber_23, seatNumber_24,
			seatNumber_25, seatNumber_26
		};
		
		// 각 버튼에 Inner class로 구현한 드래그 앤 드롭 핸들러 할당
	    for (JButton button : buttonsArray) {
	        button.setTransferHandler(new ButtonDragDropHandler("text"));
	        button.addMouseListener(new ButtonMouseListener());
	        button.setDropTarget(new DropTarget(button, new ButtonDropTargetListener()));
	    }
	    
	    play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//랜덤 배치 실행
				StudentManager sdtm = StudentManager.getInstance();
				ArrangeManager arrm = ArrangeManager.getInstance(StudentManager.getInstance().getStudents());
				sdtm.loadStudentData();
				arrm.allocateSeats();
				fetchStudents(arrm);
				repaint();
				System.out.println("랜덤 배치 버튼 눌림");
			}
		});
	    
	}//ArrangeFrame()
	
	// TransferHandler 클래스를 상속한 ButtonDragDropHandler 클래스
    class ButtonDragDropHandler extends TransferHandler {
    	// ButtonDragDropHandler 클래스의 생성자
        public ButtonDragDropHandler(String property) {
        	// 부모 클래스의 생성자 호출
            super(property);
        }
        // 데이터를 드래그하는 메서드 재정의
        public void exportAsDrag(JComponent comp, InputEvent e, int action) {
        	// 부모 클래스의 exportAsDrag 메서드 호출
            super.exportAsDrag(comp, e, action);
        }
    }//ButtonDragDropHandler
    
    // 마우스 이벤트를 처리하는 MouseAdapter를 상속한 ButtonMouseListener 클래스
    class ButtonMouseListener extends MouseAdapter {
    	// 마우스를 눌렀을 때의 동작을 정의하는 메서드
        public void mousePressed(MouseEvent e) {
        	// 이벤트가 발생한 소스 컴포넌트(JComponent)를 가져옴
            JComponent c = (JComponent) e.getSource();
            // 컴포넌트의 TransferHandler(전송 핸들러)를 가져옴
            TransferHandler handler = c.getTransferHandler();
            // 컴포넌트의 데이터를 드래그하여 복사(TransferHandler.COPY)하는 동작 수행
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }//ButtonMouseListener
    
 // 버튼이 놓인 위치에 따라 자리를 바꾸는 Drop 이벤트를 처리하는 리스너
    class ButtonDropTargetListener extends DropTargetAdapter {
        public void drop(DropTargetDropEvent evt) {
        	// 드래그된 데이터를 가져옴
            Transferable transferable = evt.getTransferable();
            // 가져온 데이터가 문자열인지 확인
            if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                	// 드래그된 데이터 문자열로 변환
                    String data = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                    // 드래그된 버튼과 이벤트가 발생한 현재 버튼을 가져옴
                    JButton sourceButton = (JButton) evt.getTransferable().getTransferData(DataFlavor.stringFlavor);
                    JButton currentButton = (JButton) evt.getDropTargetContext().getComponent();
                    // 버튼 텍스트를 서로 교환
                    String temp = currentButton.getText();
                    currentButton.setText(sourceButton.getText());
                    sourceButton.setText(temp);
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//ButtonDropTargetListener
    
    public void fetchStudents(ArrangeManager arrm){
    	for(int i=1; i < arrm.getSeats().size(); i++) {    	
    		if(arrm.getSeats().get(i).getStudent() != null) {
    			buttonsArray[arrm.getSeats().get(i).getSeatNum()-1].setText(arrm.getSeats().get(i).getStudent().getsName());    			
    		}
    	}
    }
}