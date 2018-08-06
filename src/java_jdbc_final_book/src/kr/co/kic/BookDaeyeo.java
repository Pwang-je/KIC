package kr.co.kic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;

public class BookDaeyeo extends JPanel implements ActionListener {
	JTextField txtCbun,txtCirum,txtCjunhwa,txtCjuso,txtBbun,txtBjemok,txtBdaeil;
	JTextArea taCmemo;
	JButton btnCbun,btnCirum,btnCjunhwa,btnBbun,btnBjemok,btnDaeyeo,btnNew,btnClose;
	
	boolean bg=false, bv=false;  //대여확인 버튼 활성화 여부

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs1, rs2;
	String sql;
	
	public BookDaeyeo(){
		design();
		addListener();
		accDB();
	}

	private void addListener() {
		btnCbun.addActionListener(this);
		btnCirum.addActionListener(this);
		btnCjunhwa.addActionListener(this);
    btnClose.addActionListener(this);

    btnBbun.addActionListener(this);
		btnBjemok.addActionListener(this);
		btnDaeyeo.addActionListener(this);
		btnNew.addActionListener(this);
	}

	private void accDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("accDB err: " + e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	  if (e.getSource() == btnCbun) {
	    if (txtCbun.getText().equals("")) {
	      txtCbun.requestFocus();
	      JOptionPane.showMessageDialog(this, "고객 번호를 입력하세요");
	      return;
      }
      sql = "SELECT * FROM customer WHERE c_bun = ?";
	    commonc(txtCbun.getText());

    }	else if (e.getSource() == btnCirum) {
      if (txtCirum.getText().equals("")) {
        txtCirum.requestFocus();
        JOptionPane.showMessageDialog(this, "고객 이름을 입력하세요");
        return;
      }
      sql = "SELECT * FROM customer WHERE C_IRUM = ?";
      commonc(txtCirum.getText());

		} else if (e.getSource() == btnCjunhwa) {
      if (txtCjunhwa.getText().equals("")) {
        txtCjunhwa.requestFocus();
        JOptionPane.showMessageDialog(this, "고객 전화번호를 입력하세요");
        return;
      }
      sql = "SELECT * FROM CUSTOMER WHERE C_JUNHWA = ?";
      commonc(txtCjunhwa.getText());

		} else if (e.getSource() == btnClose) {		// 닫기.
      try {
        if (rs1 != null) rs1.close();
        if (rs2 != null) rs2.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
      } catch (Exception e1 ) {
        System.out.println("대여 닫기 오류: " + e1);
      } finally {
        BookMain.book_dae.setEnabled(true);	// 메인화면에 대여 메뉴 활성화.
        BookMain.childWinDae.dispose();		// 메인 화면에 있는 대여창 닫기.
      }
    } // btnClose;

    else if (e.getSource() == btnBbun) {
      if (txtBbun.getText().equals("")) {
        txtBbun.requestFocus();
        JOptionPane.showMessageDialog(this, "책 번호를 입력하세요");
        return;
      }
      sql = "SELECT * FROM BOOK WHERE B_BUN = ?";
      commonb(txtBbun.getText());

    } else if (e.getSource() == btnBjemok) {
      if (txtBjemok.getText().equals("")) {
        txtBjemok.requestFocus();
        JOptionPane.showMessageDialog(this, "책 이름을 입력하세요");
        return;
      }
      sql = "SELECT * FROM BOOK WHERE B_JEMOK = ?";
      commonb(txtBjemok.getText());

		} else if (e.getSource() == btnDaeyeo) {

	    if (taCmemo.getText().equals("")) {
	      taCmemo.setText(txtBjemok.getText().trim());
      } else {
	      taCmemo.setText(taCmemo.getText() + "," +txtBjemok.getText().trim());
      }
      try {
	      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

	      sql = "UPDATE CUSTOMER SET C_DAESU = C_DAESU + 1, C_MEMO = ? WHERE C_BUN = ?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, taCmemo.getText());
	      pstmt.setString(2, txtCbun.getText());
	      pstmt.executeUpdate();

	      sql = "UPDATE BOOK SET B_DAESU = B_DAESU +1 B_DAEYN = 'Y', B_DAEBUN = ?, B_DAEIL = ? WHERE B_BUN = ?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, txtCbun.getText());
	      pstmt.setString(2, txtBdaeil.getText());
	      pstmt.setString(3, txtBbun.getText());
	      pstmt.executeUpdate();

	      bv = false;
	      btnNew.setEnabled(true);
	    } catch (Exception e1) {
          // empty.
      } finally {
          try {
            if(rs1 != null) rs1.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
          } catch (Exception e1) {
            // empty;
          }
      }

		} else if (e.getSource() == btnNew) {
        txtCbun.setText(null);
        txtCirum.setText(null);
        txtCjunhwa.setText(null);
        txtCjuso.setText(null);
        taCmemo.setText(null);

        txtBbun.setText(null);
        txtBjemok.setText(null);
        txtBdaeil.setText(null);
        txtCbun.requestFocus();

        btnNew.setText(null);
    }
  }

  private void commonc(String fd) {

	  try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
      pstmt = conn.prepareStatement(sql); // 여기 왜 sql이 들어감? 없는데?
      pstmt.setString(1, fd);
      rs1 = pstmt.executeQuery();

      if (rs1.next()) {
        txtCbun.setText(rs1.getString("C_BUN"));
        txtCirum.setText(rs1.getString("C_IRUM"));
        txtCjunhwa.setText(rs1.getString("C_JUNHWA"));
        txtCjuso.setText(rs1.getString("C_JUSO"));
        taCmemo.setText(rs1.getString("C_MEMO"));
        bg = true;
        btnDaeyeo.setEnabled(bg && bv);
      } else {
        JOptionPane.showMessageDialog(this, "등록이 되지 않은 고객입니다. 등록먼저 하세요.");
        txtCbun.setText(null);
        txtCirum.setText(null);
        txtCjunhwa.setText(null);
        txtCjuso.setText(null);
        taCmemo.setText(null);
        txtCbun.requestFocus();
      }
    } catch (Exception e) {
        // empty.
    } finally {
      try {
        if(rs1 != null) rs1.close();
        if (conn != null) conn.close();
        if (pstmt != null) pstmt.close();
      } catch (Exception e1) {
          // empty.
      }
    }
  }   // commonc;

  private void commonb(String fd) {
    try {
      // Driver connect
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, fd);
      rs1 = pstmt.executeQuery();

      if (rs1.next()) {
        if (rs1.getString("B_DAEYN").equals("y")) {
          JOptionPane.showMessageDialog(this, "대여중인 책입니다");
          txtBbun.setText(null);
          txtBjemok.setText(null);
          txtBbun.requestFocus();
        } else {
          txtBbun.setText(rs1.getString("B_BUN"));
          txtBjemok.setText(rs1.getString("B_JEMOK"));
          Date today = new Date();
          SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
          String day = dateFormat.format(today);
          txtBdaeil.setText(day);
          bv = true;
          btnDaeyeo.setEnabled(bg && bv);
        }
      } else {
          JOptionPane.showMessageDialog(this, "등록되지 않은 책입니다");
          txtBbun.setText(null);
          txtBjemok.setText(null);
          txtBbun.requestFocus();
      }
    } catch (Exception e) {
        // empty.
    } finally {
      try {
        if (rs1 != null) rs1.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
      } catch (Exception e) {
          // empty.
      }
    }
  }   // //commonb;

	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//고객정보 패널========================
		JPanel customerPn=new JPanel(new GridLayout(3,2));
		customerPn.setBorder(new TitledBorder(new TitledBorder("고객 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel cPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));

		txtCbun=new JTextField("",5);
		txtCirum=new JTextField("",10);
		txtCjunhwa=new JTextField("",10);
		txtCjuso=new JTextField("",20);
		txtCjuso.setEditable(false);
		
		taCmemo=new JTextArea(2,20);
		JScrollPane scroll=new JScrollPane(taCmemo,	ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		taCmemo.setEditable(false);
		taCmemo.setBackground(Color.lightGray);
		
		btnCbun=new JButton("확인1");
		btnCbun.setMargin(new Insets(0, 3, 0, 3));
		btnCirum=new JButton("확인2");
		btnCirum.setMargin(new Insets(0, 3, 0, 3));
		btnCjunhwa=new JButton("확인3");
		btnCjunhwa.setMargin(new Insets(0, 3, 0, 3));

		cPn1.add(new JLabel("번호:"));
		cPn1.add(txtCbun);
		cPn1.add(btnCbun);
		
		cPn2.add(new JLabel("이름:"));
		cPn2.add(txtCirum);	
		cPn2.add(btnCirum);
		
		cPn3.add(new JLabel("전화:"));
		cPn3.add(txtCjunhwa);
		cPn3.add(btnCjunhwa);
		
		cPn4.add(new JLabel("주소:"));
		cPn4.add(txtCjuso);
		
		customerPn.add(cPn1); customerPn.add(cPn2); customerPn.add(cPn3);
		customerPn.add(cPn4); 
		customerPn.add(new JLabel("고객이 대여한 도서  ☞   ",JLabel.RIGHT));
		customerPn.add(scroll); 
		scroll.setBorder(BorderFactory.createEmptyBorder(1, 1, 5, 5));
		this.add(customerPn);
				
		//도서정보 패널========================
		JPanel bookPn=new JPanel(new GridLayout(3,1));
		bookPn.setBorder(new TitledBorder(new TitledBorder("도서 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		
		JPanel bPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtBbun=new JTextField("",5);
		txtBjemok=new JTextField("",20);
		txtBdaeil=new JTextField("",10);
		btnBbun=new JButton("확인1");
		btnBbun.setMargin(new Insets(0, 3, 0, 3));
		btnBjemok=new JButton("확인2");
		btnBjemok.setMargin(new Insets(0, 3, 0, 3));

		// 도서 정보쪽 디자인

		bPn1.add(new JLabel("번호:"));
		bPn1.add(txtBbun);
		bPn1.add(btnBbun);
		
		bPn2.add(new JLabel("제목:"));
		bPn2.add(txtBjemok);
		bPn2.add(btnBjemok);
		
		bPn3.add(new JLabel("대여일:"));
		bPn3.add(txtBdaeil);	
		
		JPanel bottomPn=new JPanel();
		bottomPn.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		btnDaeyeo=new JButton("대여 확인");
		btnNew=new JButton("새로 입력");
		btnClose=new JButton(" 닫 기 ");
		
		bottomPn.add(btnDaeyeo);
		bottomPn.add(btnNew);
		JLabel lbl=new JLabel("    ");  //버튼 사이에 공백 부여
		bottomPn.add(lbl);
		bottomPn.add(btnClose);
		
		bookPn.add(bPn1);  bookPn.add(bPn2); 	bookPn.add(bPn3);	
		
		this.add(customerPn);
		this.add(bookPn);
		this.add(bottomPn);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		btnDaeyeo.setEnabled(false); //대여 버튼 비활성화
		btnNew.setEnabled(false);
	}

	public static void main(String[] args) {
		BookDaeyeo daeyeo=new BookDaeyeo();
		JFrame frame=new JFrame("대여 창");
		frame.getContentPane().add(daeyeo);
		//frame.setResizable(false);
		frame.setBounds(200,200,580,400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
