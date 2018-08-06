package kr.co.kic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class BookBannap extends JPanel implements ActionListener {
	JTextField txtBbun,txtBjemok,txtBdaeil,txtBdaebun,  txtJemok;
	static JTextField txtBbanil;
	JButton btnBbun,btnChange,btnBannap,btnNew,btnClose;
	DefaultTableModel mod;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs1, rs2;
	String sql;
	
	static JFrame calFrame;

	public BookBannap(){
		design();
		accDB();
		addListener();
	}

	private void addListener() {
		btnBannap.addActionListener(this);
		btnBbun.addActionListener(this);
		btnChange.addActionListener(this);
		btnClose.addActionListener(this);
		btnNew.addActionListener(this);
	}

	private void accDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			BookDaeyeo();
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
	}

	private void BookDaeyeo() {
		mod.setNumRows(0);
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			sql = "select b_bun, b_jemok, c_bun, c_irum, b_daeil from book inner join customer on b_daebun = c_bun order by b_daeil desc, b_bun asc";
			pstmt = conn.prepareStatement(sql);
			rs1 = pstmt.executeQuery();
			int cou = 0;
			while (rs1.next()) {
				String[] imsi = {rs1.getString(1),rs1.getString(2),rs1.getString(3),
						rs1.getString(4),rs1.getString(5)};
				mod.addRow(imsi);
				cou++;
			}
			String[] imsi2 = {null, "건수" + cou};
			mod.addRow(imsi2);
		} catch (Exception e1) {

		} finally {
			try {
				if (rs1 != null) rs1.close();
				if (rs2 != null) rs2.close();
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e1) {

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBbun) {

			// 반납 도서 번호
			if (txtBbun.getText().equals("")) {	// 텍스트가 없으면
				txtBbun.requestFocus();		// 비번에 포커스를 갖다댐
				JOptionPane.showMessageDialog(this, "반납도서 번호를 입력하세요");
				return;
			}

			try {
        conn = DriverManager
            .getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
        sql = "select * from book where b_bun=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, txtBbun.getText());
        rs1 = pstmt.executeQuery();

        if (!rs1.next()) {    // 있다면~~~~ 없는 번호를 입력할 수 있으니깐 if써줌. 등록되지 않은 도서번호!
          JOptionPane.showMessageDialog(this, txtBbun.getText() + "등록된 도서가 아닙니다");
          txtBbun.requestFocus();    // 도서가 아니라서 포커스 다시 원래대로 하고 리턴으로 돌림.
          return;
        } else {

          // 제목넣기
          txtBjemok.setText(rs1.getString("b_jemok"));

        // 정식으로 대여된 도서여부를 판단하는 코드.
        if (rs1.getString("b_daeyn").equals("n")) {  // 대여되면 y 라고 나와있어야 함.
          JOptionPane.showMessageDialog(this, "정식으로 대여된 도서가 아닙니다");
          txtBbun.setText(null);
          txtJemok.setText(null);
          txtBbun.requestFocus();
          return;
        }

        // 반납 진행.
        txtBdaeil.setText(rs1.getString("b_daeil")
            .substring(0, 10));  // 도서번호 입력하면 대여일 뜨게하기. substr 0부터~ 10까지를 가져옴.

        // 반납일 날짜 뜨게하기.
        Calendar calendar = Calendar.getInstance();
        String day = calendar.get(Calendar.YEAR) + "/" +
            (calendar.get(Calendar.MONTH) + 1) + "/" +
            calendar.get(Calendar.DATE);
        txtBbanil.setText(day);
        txtBdaebun.setText(rs1.getString("b_daebun"));

        // 반납되는 도서제목을 customer 의 c_memo 에서 제거.'
        // 대여된 도서제목을 표시 후
        sql = "SELECT * FROM CUSTOMER WHERE C_BUN=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, txtBdaebun.getText());
        rs2 = pstmt.executeQuery();
        rs2.next();  // 마우스 포인터 이동.
        txtJemok.setText(rs2.getString("C_MEMO"));

        String ban_jemok = txtJemok.getText();  // txt제목을 ban제목에 죄다 넣음.
        int start = ban_jemok.indexOf(txtBjemok.getText());  //글자에 시작점 찾기.
        int end = txtBjemok.getText().length();
        txtJemok.setSelectionStart(start);    // 하이라이팅.
        txtJemok.setSelectionEnd(start + end + 1);
        txtJemok.requestFocus();
        txtJemok.replaceSelection("");    // 반납 도서가 지워짐.

        // 마지막에 콤마 생긴거 제거작업.
        try {
          String str = txtJemok.getText();
          int a = str.length() - 1;
          String ss = str.substring(a);    // 처음부터 a 까지만 취함.
          if (ss.equals(","))
            str = str.substring(0, a);
          txtJemok.setText(str);
        } catch (Exception e1) {
          // 대여도서가 하나일 경우 자동으로 무시.
        }
      }
				// ----------------------------

				btnBannap.setEnabled(true);	// 반납 확인 버튼을 활성화.


			} catch (Exception e1) {
				System.out.println("반납 오류" + e1);
			} finally {
				try {
					if(rs1 != null) rs1.close();
					if (rs2 != null) rs2.close();
					if (conn != null) conn.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) {

				}
			}

		} else if (e.getSource() == btnChange) {

			BookCal bookCal = new BookCal();
			calFrame = new JFrame("반납일 변경");
			calFrame.add(bookCal);
			calFrame.setBounds(300, 300, 250, 200);
			calFrame.setVisible(true);

		} else if (e.getSource() == btnBannap) {

			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

				// customer update
				sql = "update customer set c_memo=? where c_bun=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, txtJemok.getText());
				pstmt.setString(2, txtBdaebun.getText());
				pstmt.executeUpdate();

				sql = "update book set b_daeyn='n', b_daebun=0, b_daeil=null, b_banil=? where b_bun=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, txtBbanil.getText());
				pstmt.setString(2, txtBbun.getText());
				pstmt.executeUpdate();

				BookDaeyeo();

				btnBannap.setEnabled(false);
				btnNew.setEnabled(true);

				BookDaeyeo();	// 갱신 후 대여자료 다시 읽어서 출력.


			} catch (Exception e1) {
				System.out.println("반납 오류" + e1);
			} finally {
				try {
					if(rs1 != null) rs1.close();
					if (rs2 != null) rs2.close();
					if (conn != null) conn.close();
					if (pstmt != null) pstmt.close();
				} catch (Exception e1) {

				}
			}


		}	else if (e.getSource() == btnClose) {
			try {
				if (rs1 != null) rs1.close();
				if (rs2 != null) rs2.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
			} catch (Exception e1) {
				System.out.println("반납 닫기 오류");
			} finally {
				BookMain.book_ban.setEnabled(true);
				BookMain.childWinBan.dispose();	// 메인화면에 있는 대여창 닫기
			}
		}  else if (e.getSource() == btnNew) {
			txtBbun.setText("");
			txtBjemok.setText("");
			txtBdaeil.setText("");
			txtBdaebun.setText("");
			txtJemok.setText("");
			txtBbun.requestFocus();
			btnNew.setEnabled(false);
		}
	}

	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//도서정보 패널========================
		JPanel bookPn=new JPanel(new GridLayout(3,1));
		bookPn.setBorder(new TitledBorder(new TitledBorder("도서 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel bPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtBbun=new JTextField("",5);
		txtBjemok=new JTextField("",20);
		txtBdaeil=new JTextField("",10);
		txtBbanil=new JTextField("",10);
		txtBdaebun=new JTextField("",5);
		txtJemok=new JTextField("",25);  //반납되는 도서 제목을 고객메모에서 제거하기 위함
		
		btnBbun=new JButton("확인");
		btnBbun.setMargin(new Insets(0, 3, 0, 3));
		btnChange=new JButton("변경");
		btnChange.setMargin(new Insets(0, 3, 0, 3));

		bPn1.add(new JLabel("번호:"));
		bPn1.add(txtBbun);
		bPn1.add(btnBbun);
		
		bPn2.add(new JLabel("제목:"));
		bPn2.add(txtBjemok);
		txtBjemok.setEditable(false);
		
		bPn3.add(new JLabel("대여일:"));
		bPn3.add(txtBdaeil);	
		txtBdaeil.setEditable(false);
		bPn3.add(new JLabel("      반납일:"));
		bPn3.add(txtBbanil);
		bPn3.add(btnChange);	
		
		bPn4.add(new JLabel("대여자 번호:"));
		bPn4.add(txtBdaebun);
		bPn4.add(txtJemok);   //고객메모란의 대여도서 제목중 반납되는 비디오 제목만 제거하기 위해 사용  
		txtJemok.setVisible(true); //숨긴다.
		txtBdaebun.setEditable(false);
		
		JPanel bottomPn=new JPanel();
		bottomPn.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		btnBannap=new JButton("반납 확인");
		btnNew=new JButton("새로 입력");
		btnClose=new JButton(" 닫 기 ");
		
		bottomPn.add(btnBannap);
		bottomPn.add(btnNew);
		JLabel lbl=new JLabel("    "); 
		bottomPn.add(lbl);
		bottomPn.add(btnClose);
		
		bookPn.add(bPn1);  bookPn.add(bPn2); 	bookPn.add(bPn3);	
		
		this.add(bookPn);
		this.add(bPn4);
		this.add(bottomPn);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//도서 목록 테이블 삽입
		String[][]data=new String[0][4];
		String []cols={"번호","제목","대번","이름","대여일"};
		mod=new DefaultTableModel(data,cols){ //테이블 내용 수정 불가
			    public boolean isCellEditable(int rowIndex, int mColIndex) {
				   return false;
				}
			   };
		JTable tab=new JTable(mod);
		tab.getColumnModel().getColumn(0).setPreferredWidth(20);
		tab.getColumnModel().getColumn(1).setPreferredWidth(150);
		tab.getColumnModel().getColumn(2).setPreferredWidth(20);
		tab.getColumnModel().getColumn(3).setPreferredWidth(30);
		tab.setSelectionBackground(Color.green);
		JScrollPane pa=new JScrollPane(tab);
		this.add(pa);
		
		btnBannap.setEnabled(false);  //반납 버튼 비활성화
		btnNew.setEnabled(false);     
	}

	public static void main(String[] args) {
		BookBannap bookBannap = new BookBannap();
		JFrame frame=new JFrame("반납 창");
		frame.getContentPane().add(bookBannap);
		frame.setResizable(false);
		frame.setBounds(200,200,500,400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}