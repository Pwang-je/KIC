package kr.co.kic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.sql.*;

public class BookBook extends JPanel implements ActionListener {
	JTextField txtBbun,txtBjemok,txtBjang,txtBkuil,txtBdaesu,txtBdaeyn,txtBdaebun,txtBdaeil,txtBbanil;
	JTextArea taBmemo;
	JButton btnInsert,btnUpdate,btnDel,btnFind,btnOption,btnClose;
	JButton btnF,btnP,btnN,btnL,btnin,btnsu;
	JLabel lblRec,lblPic;


	String sql, imgPath; //--- 그림 파일 경로 변수
	int iTotal = 0;	// 자료의 갯수
	int iLast = 0; 	// 마지막 레코드 번호
	JPanel picPn;
	File file;  //--- 이미지 로딩하기 위한 변수
	boolean isInsert = false;	// Insert 버튼 눌림 여부
	boolean isUpdate = false;	// Update 버튼 눌림 여부

  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs1, rs2;

	public BookBook(){
    accDb();
		design();
    addListener();

    init();
		display();
	}

  private void accDb() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
    } catch (Exception e) {
      System.out.println("드라이버 로딩 실패");
    } finally {

    }
  }

  private void addListener() {
//    btnClose.addActionListener(this);
    btnDel.addActionListener(this);
    btnF.addActionListener(this);
    btnFind.addActionListener(this);

    btnInsert.addActionListener(this);
    btnL.addActionListener(this);
    btnN.addActionListener(this);
    btnOption.addActionListener(this);
    btnP.addActionListener(this);
    btnUpdate.addActionListener(this);
    btnsu.addActionListener(this);
  }

  private void init() {
    try {
      sql = "SELECT * FROM book ORDER BY b_bun ASC";
      pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);	// 레코드 이동이 수정이 되야해서 이걸씀.
      rs1 = pstmt.executeQuery();

      // 카운트를 알아야 할 때.
      rs1.last(); // 마지막 라인으로 이동.
      iTotal = rs1.getRow();  // 전체 자료 수 획득.
      iLast = rs1.getInt("b_bun");  // 마지막 고객 번호 얻기.: 신규 고객 등록 시 사용.
      rs1.first();
    } catch (Exception e) {
      System.out.println("INITIAL 쪽 애러인데... : " + e);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == btnF) {
        rs1.first();
        display();
      } else if (e.getSource() == btnP) {   // 이전버튼
        if (rs1.isFirst()) return;
        rs1.previous();
        display();
      } else if (e.getSource() == btnN) {
        if (rs1.isLast()) return;
        rs1.next();
        display();
      } else if (e.getSource() == btnL) {
        rs1.last();
        display();
      }
    } catch (Exception e1) {
      System.out.println("레코드 이동 오류: " + e1.getMessage());
    }

    if (e.getSource() == btnInsert) { // 신규도서
      if (isInsert == false) {
        btnInsert.setText("확인");
        isInsert = true;

        txtBbun.setText(String.valueOf(iLast) + 1);
        txtBjemok.setEditable(true);
        txtBjang.setEditable(true);
        txtBkuil.setEditable(true);
        taBmemo.setEditable(true);
        taBmemo.setBackground(Color.white);

        txtBjemok.setText(null);
        txtBjang.setText(null);
        taBmemo.setText(null);
        imgPath = null; // 도서 이미지 경로 초기화

        Calendar cal = Calendar.getInstance();
        String imsi = cal.get(Calendar.YEAR) + "-" +
            (cal.get(Calendar.MONTH) + 1) + "-" +
              cal.get(Calendar.DATE);
        txtBkuil.setText(imsi);
        txtBdaeyn.setText("n");
        txtBdaesu.setText("0");
        txtBdaebun.setText("");
        txtBdaeil.setText("");
        txtBbanil.setText("");

        // 이미지를 이미지 추가 버튼으로 대체.
        picPn.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 50));
        btnin = new JButton("그림 삽입");
        btnin.addActionListener(this);
        lblPic.setVisible(false);
        picPn.add("Center", btnin);

        txtBjemok.requestFocus();;


      } else {
        btnInsert.setText("신규");
        isInsert = false;

        // 신규 도서 등록 작업
        try {
          sql = "INSERT INTO book VALUES (?<?<?<?<0<'n'<0<null<unll<?<?)";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, txtBbun.getText());
          pstmt.setString(2, txtBjemok.getText());
          pstmt.setString(3, txtBjang.getText());
          pstmt.setString(4, txtBkuil.getText());
          pstmt.setString(5, taBmemo.getText());
          if (file.getName() == null || file.getName().equals("")) {
            pstmt.setString(6, null);
          } else {
            pstmt.setString(6, file.getName());
          }
          pstmt.executeUpdate();

          txtBjemok.setEditable(false);
          txtBjang.setEditable(false);
          txtBkuil.setEditable(false);
          taBmemo.setEditable(false);
          taBmemo.setBackground(Color.LIGHT_GRAY);

          init();
          rs1.last();
          display();
        } catch (Exception e1) {
          System.out.println("도서 추가 오류" + e1);
        }
      }
    } else if (e.getSource() == btnUpdate) {

      // 제목, 장르, 구입일, 메모 = 수정 대상.
      if (isUpdate == false) {
        isUpdate = true;
        btnUpdate.setText("완료");

        txtBjemok.setEditable(true);
        txtBjang.setEditable(true);
        taBmemo.setEditable(true);
        // 수정 작업 시 부수 작업 필요하나 생략...

      } else {
        isUpdate = false;
        btnUpdate.setText("수정");

        try {
          sql = "UPDATE scott.customer SET b_jemok = ?, b_jang = ?, b_memo = ? where b_bun = ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, txtBjemok.getText());
          pstmt.setString(2, txtBjang.getText());
          pstmt.setString(3, taBmemo.getText());
          pstmt.setString(4, txtBbun.getText());
          pstmt.executeUpdate();

          // 수정할까요? 생략.

          int currentRow = rs1.getRow();  // 현재 레코드의 포인터 기억.
          init(); // 수정된 자료 출력을 위해.
          rs1.absolute(currentRow); //
          display();
        } catch (Exception e1) {
          System.out.println("고객 수정 오류입니다." + e1);
        }

        txtBjemok.setEditable(false);
        txtBjang.setEditable(false);
        taBmemo.setEditable(false);
      }
    } else if (e.getSource() == btnin) {

      JFileChooser chooser = new JFileChooser("C:\\work\\java_jdbc_final_book\\src\\bookimage");
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      int result = chooser.showOpenDialog(this);
      if (result == JFileChooser.CANCEL_OPTION) {
        file = null;
      } else {
        file = chooser.getSelectedFile();
      }
      imgPath = file.getPath();
      dispImage();

      lblPic.setVisible(true);
      btnin.setVisible(false);
//      System.out.println(file.getName());

    } else if (e.getSource() == btnDel) {
      int re = JOptionPane.showConfirmDialog(this, "정말 삭제?", "삭제", JOptionPane.YES_NO_OPTION);
      if (re == JOptionPane.YES_OPTION) {
        try {
          if (rs1.getRow() == 0) {  // 고객이 한명도 없을때
            JOptionPane.showMessageDialog(this, "삭제할 고객이 없네여.");
            return;
          }

          // 현재 대여중인 도서는 삭제 불가.
          if (txtBdaeyn.getText().equals("비치중")) {
            int currentRow = rs1.getRow();
            sql = "DELETE FROM scott.book WHERE b_bun = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtBbun.getText());
            pstmt.executeUpdate();
            init();   // 삭제 후 자료 다시 읽기
            if (currentRow == 1) {

            } else {
              rs1.absolute(currentRow - 1);  // 삭제 후 포인터 뒤로 이동해서 뒷사람 보여줌.
            }
            display();
          } else {
            JOptionPane.showMessageDialog(this, "삭제할 수 없음. 반납 필요.");
          }

        } catch (Exception e1) {
          System.out.println("고객 삭제 오류입니다" + e1);
        }
      }
    }
       else if (e.getSource() == btnFind) {

        // 도서 이름으로 검색하기.
        String fJemok = JOptionPane.showInputDialog(this, "검색할 도서명 입력");
        if (fJemok == null || fJemok.equals("")) return;
        try {
          int currentRow = rs1.getRow();  // 없을 시 포인터 디돌림. 검색 결과가 없는 경우.
          rs1.beforeFirst();

          boolean b = false;
          while (rs1.next()) {
            String ss = rs1.getString("b_jemok");
            if (fJemok.equals(ss)) { // 문자열 비교.
              display();
              b = true;
              break;
            }
          }
          if (b == false) {
            JOptionPane.showMessageDialog(this, "검색결과가 없습니다.");
            rs1.absolute(currentRow);
          }
        } catch (Exception e1) {
          System.out.println("고객 번호 검색 오류" + e1);
        }
    } else if (e.getSource() == btnOption) {

    } else if (e.getSource() == btnClose) {
      try {
        if (rs1 != null) rs1.close();
        if (rs2 != null) rs2.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
      } catch (Exception e1) {
        System.out.println("책닫기 오류");
      } finally {
        BookMain.book_book.setEnabled(true);
        BookMain.childWinBook.dispose();
      }

    }


  } // actionPerformed;

  private void display() {

	  try {

	    if (rs1.getString("b_banil") == null) {
	      txtBbanil.setText("없음");
      } else {
	      txtBbanil.setText(rs1.getString("b_banil"));
      }
      txtBbun.setText(rs1.getString("b_bun"));
	    txtBdaebun.setText(rs1.getString("b_daebun"));

	    if (rs1.getString("b_daeil") == null) {
	      txtBdaeil.setText("없음");
      } else {
	      txtBdaeil.setText(rs1.getString("b_daeil"));
      }
      txtBdaesu.setText(rs1.getString("b_daesu"));

	    if (rs1.getString("b_daeyn").equals("y")) {
	      txtBdaeyn.setText("대여중임");
	      txtBdaeyn.setForeground(Color.red);
      } else {
	      txtBdaeyn.setText("대여안됨");
	      txtBdaeyn.setForeground(Color.black);
      }
      txtBjang.setText(rs1.getString("b_jang"));
      txtBjemok.setText(rs1.getString("b_jemok"));

      if (rs1.getString("b_kuipil") == null) {
        txtBkuil.setText("없음");
      } else {
        txtBkuil.setText(rs1.getString("b_kuipil"));
      }
      taBmemo.setText(rs1.getString("b_memo"));
      lblRec.setText(rs1.getRow() + " / " + iTotal);

      try {
        imgPath = rs1.getString("b_image");
      } catch (Exception e1) {
        // empty.
      }
      dispImage();
    } catch (Exception e1) {

    }
/*
    try {
      txtBbun.setText(rs1.getString("b_bun"));
//      txtBdaeyn.setText(rs1.getString("b_daeyn"));
      if (rs1.getString("b_daeyn").equals("y")) {
        txtBdaeyn.setText("대여중");
        txtBdaeyn.setForeground(Color.red);
      } else {
        txtBdaeyn.setText("비치중");
        txtBdaeyn.setForeground(Color.black);
      }
      txtBjemok.setText(rs1.getString("b_jemok"));
      txtBjang.setText(rs1.getString("b_jang"));
      txtBdaesu.setText(rs1.getString("b_daesu"));

      if (rs1.getString("b_kuipil") == null) {
        txtBkuil.setText("");
      } else {
        txtBkuil.setText(rs1.getString("b_kuipil").substring(0, 10));
      }

      txtBkuil.setText(rs1.getString("b_kuipil"));

      if (rs1.getString("b_daeil") == null) {
        txtBdaeil.setText("");    // 반납일이 없을 때 공백으로 만듬.
      } else {
        txtBdaeil.setText(rs1.getString("b_daeil").substring(0, 10));
      }

      if (rs1.getString("b_banil") == null) {
        txtBbanil.setText("");    // 반납일이 없을 때 공백으로 만듬.
      } else {
        txtBbanil.setText(rs1.getString("b_banil").substring(0, 10));
      }

      taBmemo.setText(rs1.getString("b_memo"));

      lblRec.setText(rs1.getRow() + " / " + iTotal);

      // 이미지 출력.
      imgPath = rs1.getString("b_image");
      dispImage();

    } catch (Exception e2) {
      System.out.println("book display error:" + e2);
    }*/

  }


  private void dispImage() {
	  if (imgPath != null) {
	    String dir = "C:\\work\\java_jdbc_final_book\\src\\bookimage\\";
//      System.out.println(dir + imgPath);
      ImageIcon icon = new ImageIcon(dir + imgPath);
      lblPic.setIcon(icon);
      lblPic.setToolTipText("이미지 파일명:" + imgPath);

      /*if (icon != null) {
        lblPic.setText(null);
      } else {
        lblPic.setText("이미지 없음");
      }*/

    } else {

    }
  }


	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//도서정보 패널========================
		JPanel bookPn=new JPanel(new GridLayout(6,1));
		bookPn.setBorder(new TitledBorder(new TitledBorder("도서 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel bPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtBbun=new JTextField("",5);
		txtBjemok=new JTextField("",30);
		txtBjang=new JTextField("",10);
		txtBkuil=new JTextField("",10);
		txtBdaesu=new JTextField("",5);
		txtBdaeyn=new JTextField("",5);
		txtBdaebun=new JTextField("",5);
		txtBdaeil=new JTextField("",10);
		txtBbanil=new JTextField("",10);
		taBmemo=new JTextArea(2,30);
		JScrollPane scroll=new JScrollPane(taBmemo);
		taBmemo.setBackground(Color.lightGray);
		
		txtBbun.setEditable(true);
		txtBjemok.setEditable(false);
		txtBjang.setEditable(false);
		txtBkuil.setEditable(false);
		txtBdaesu.setEditable(false);
		txtBdaeyn.setEditable(false);
		txtBdaebun.setEditable(false);
		txtBdaeil.setEditable(false);
		txtBbanil.setEditable(false);
		taBmemo.setEditable(false);
				
		btnInsert=new JButton("신규");
		btnUpdate=new JButton("수정");
		btnDel=new JButton("삭제");
		btnFind=new JButton("검색");
		btnOption=new JButton("옵션");
		btnClose=new JButton("닫기");
		btnF=new JButton(" <<= ");
		btnP=new JButton("  <= ");
		btnN=new JButton(" =>  ");
		btnL=new JButton(" =>> ");
		lblRec=new JLabel(" 0 / 0 ",JLabel.CENTER);
		bPn1.add(new JLabel("번호 :"));
		bPn1.add(txtBbun);
		bPn1.add(new JLabel("                              대여표시 :"));
		bPn1.add(txtBdaeyn);
		
		bPn2.add(new JLabel("제목 :"));
		bPn2.add(txtBjemok);	

		bPn3.add(new JLabel("장르 :"));
		bPn3.add(txtBjang);
		bPn3.add(new JLabel("                구입일 :"));
		bPn3.add(txtBkuil);
		
		bPn4.add(new JLabel("대여횟수 :"));
		bPn4.add(txtBdaesu);
		bPn4.add(new JLabel("                 대여자번호 :"));
		bPn4.add(txtBdaebun);
		
		bPn5.add(new JLabel("대여일 :"));
		bPn5.add(txtBdaeil);
		bPn5.add(new JLabel("            반납일 :"));
		bPn5.add(txtBbanil);

		bPn6.add(new JLabel("메모 :"));
		bPn6.add(scroll);
		
		bookPn.add(bPn1);  bookPn.add(bPn2); 	bookPn.add(bPn3);
		bookPn.add(bPn4);  bookPn.add(bPn5); 	bookPn.add(bPn6);
		this.add(bookPn);
		
		//이미지 패널----------------------------------------------------
		picPn=new JPanel(new BorderLayout());
		lblPic = new JLabel();
		//lblPic.setPreferredSize(new Dimension(1000, 300));
		picPn.add(lblPic);

		this.add(picPn);

		//레코드 이동 패널------------------------------------------------
		JPanel movePn=new JPanel();
		movePn.setBorder(new TitledBorder(new TitledBorder("레코드 이동"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		movePn.add(btnF);
		movePn.add(btnP);
		movePn.add(lblRec);
		movePn.add(btnN);
		movePn.add(btnL);
		
		this.add(movePn);
		
        //명령 버튼 패널--------------------------------------------------
		JPanel bottomPn1=new JPanel();
		bottomPn1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		bottomPn1.add(btnInsert);
		bottomPn1.add(btnUpdate);
		bottomPn1.add(btnDel);
		bottomPn1.add(btnFind);
		bottomPn1.add(btnOption);
		bottomPn1.add(btnClose);
		
		this.add(bottomPn1);
		
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		btnsu=new JButton("그림 수정");

	}


	public static void main(String[] args){
		BookBook bookBook =new BookBook();
		
		JFrame frame=new JFrame("도서 창");
		frame.getContentPane().add(bookBook);
		frame.setBounds(440,110,430,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}


