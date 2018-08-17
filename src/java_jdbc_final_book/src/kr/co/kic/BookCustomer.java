/*
package kr.co.kic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.TreeUI;

public class BookCustomer extends JPanel implements ActionListener {
	JTextField txtCbun,txtCirum,txtCjunhwa,txtCjuso,txtCdaesu;
	JTextArea taCmemo;
	JButton btnInsert,btnOk,btnUpdate,btnDel,btnFind,btnOption,btnClose;
	JButton btnF,btnP,btnN,btnL;
	JLabel lblRec;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs1, rs2;
	String sql;
	
	int iTotal = 0;	// 자료의 갯수
	int iLast = 0; 	// 마지막 레코드 번호
	boolean isInsert = false;	// Insert 버튼 눌림 여부
	boolean isUpdate = false;	// Update 버튼 눌림 여부
	
	// 생성자
	public BookCustomer(){
		design();
		accDb();
		addListener();

		init();
		display();

	}

	private void addListener() {
    btnInsert.addActionListener(this);
    btnOk.addActionListener(this);
    btnUpdate.addActionListener(this);
    btnDel.addActionListener(this);
    btnFind.addActionListener(this);
    btnOption.addActionListener(this);
    btnClose.addActionListener(this);
    btnF.addActionListener(this);
    btnP.addActionListener(this);
    btnN.addActionListener(this);
    btnL.addActionListener(this);
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

	private void init() {
		try {
			sql = "select * from customer order by c_bun asc";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);	// 레코드 이동이 수정이 되야해서 이걸씀.
			rs1 = pstmt.executeQuery();

			// 카운트를 알아야 할 때.
			rs1.last();
			iTotal = rs1.getRow();
			iLast = rs1.getInt("c_bun");  // 마지막 고객 번호 얻기.: 신규 고객 등록 시 사용.
      rs1.first();
		} catch (Exception e) {
			System.out.println("init err : " + e);
		}
	}

	private void display() {

	  try {
      txtCbun.setText(rs1.getString("c_bun"));
      txtCirum.setText(rs1.getString("c_irum"));
      txtCjunhwa.setText(rs1.getString("c_junhwa"));
      txtCjuso.setText(rs1.getString("c_juso"));
      txtCdaesu.setText(rs1.getString("c_daesu"));
      taCmemo.setText(rs1.getString("c_memo"));
      lblRec.setText(rs1.getRow() + " / " + iTotal);  //  1 / 10 이 뜸.
    } catch (Exception e) {
      System.out.println("display err: " + e.getMessage());
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

    if (e.getSource() == btnInsert) {
    	if (isInsert == false) {
    		btnInsert.setText("취소");
    		isInsert = true;
    		btnOk.setEnabled(true);

    		txtCirum.setEditable(true);
    		txtCjunhwa.setEditable(true);
    		txtCjuso.setEditable(true);

    		txtCbun.setText(String.valueOf(iLast) + 1); // 신규번호
        txtCirum.setText(null);
        txtCjunhwa.setText(null);
        txtCjuso.setText(null);
        txtCdaesu.setText(null);
        taCmemo.setText(null);
        txtCirum.requestFocus();

			} else {
				btnInsert.setText("신규");
				isInsert = false;
        btnOk.setEnabled(false);

        txtCirum.setEditable(false);
        txtCjunhwa.setEditable(false);
        txtCjuso.setEditable(false);
        display();
			}
		} else if (e.getSource() == btnOk) {
      // 신규 고객 등록 작업. 실질적 작업은 btn OK가 하는거임.
      // 입력자료 오류 검사가 필요하나 지금 여기서는 생략함. (이름을 입력하세요, 뭘 입력하세요 등등)
      try {
        sql = "INSERT INTO scott.customer VAlUES (?,?,?,?,0,'')";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, txtCbun.getText());
        pstmt.setString(2, txtCirum.getText());
        pstmt.setString(3, txtCjunhwa.getText());
        pstmt.setString(4, txtCjuso.getText());
        pstmt.executeUpdate();

        init(); // 전체 건수 출력.
        rs1.last(); // 추가 했으므로 마지막 자료가 보여야 되기 때문에.
        display();

        txtCirum.setEditable(false);
        txtCjunhwa.setEditable(false);
        txtCjuso.setEditable(false);
        btnInsert.setText("신규");
        btnOk.setEnabled(false);
      } catch (Exception e1) {
        System.out.println("신규 등록 오류입니다." + e1);
      }

    } else if (e.getSource() == btnUpdate) {
        if (isUpdate == false) {
          isUpdate = true;
          btnUpdate.setText("완료");

          txtCirum.setEditable(true);
          txtCjunhwa.setEditable(true);
          txtCjuso.setEditable(true);
          // 수정 작업 시 부수 작업 필요하나 생략...

        } else {
          isUpdate = false;
          btnUpdate.setText("수정");

          // 수정 처리 부분. : 입력자료 검사 생략.
          try {
            sql = "UPDATE scott.customer SET c_irum = ?, c_junhwa = ?, c_juso = ? where c_bun = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtCirum.getText());
            pstmt.setString(2, txtCjunhwa.getText());
            pstmt.setString(3, txtCjuso.getText());
            pstmt.setString(4, txtCbun.getText());
            pstmt.executeUpdate();

            // 수정할까요? 생략.

            int currentRow = rs1.getRow();  // 현재 레코드의 포인터 기억.
            init(); // 수정된 자료 출력을 위해.
            rs1.absolute(currentRow); //
            display();

          } catch (Exception e1) {
            System.out.println("고객 수정 오류입니다." + e1);
          }

          txtCirum.setEditable(false);
          txtCjunhwa.setEditable(false);
          txtCjuso.setEditable(false);

        }
    } else if (e.getSource() == btnDel) {
        int re = JOptionPane.showConfirmDialog(this, "정말 삭제?", "삭제", JOptionPane.YES_NO_OPTION);
        if (re == JOptionPane.YES_OPTION) {
          try {
            if (rs1.getRow() == 0) {  // 고객이 한명도 없을때
              JOptionPane.showMessageDialog(this, "삭제할 고객이 없네여.");
              return;
            }

            // 현재 도서를 대여중인 고객은 삭제하면 안됨.
            if (taCmemo.getText().equals("")) {
              int currentRow = rs1.getRow();
              sql = "DELETE FROM scott.customer WHERE c_bun = ?";
              pstmt = conn.prepareStatement(sql);
              pstmt.setString(1, txtCbun.getText());
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
    } else if (e.getSource() == btnFind) {  // 검색기능.

      // 고객 번호로 검색하기.
      String fbun = JOptionPane.showInputDialog(this, "검색할 고객 번호입니다.");
      if (fbun == null || fbun.equals("")) return;
      try {
        int currentRow = rs1.getRow();  // 없을 시 포인터 디돌림. 검색 결과가 없는 경우.
        rs1.beforeFirst();
        int find = 0;

        int cou = 0;
        while (rs1.next()) {
          String ss = rs1.getString("c_bun");
          if (fbun.equals(ss)) { // 문자열 비교.
            display();
            cou++;
            break;
          }
        }
        if (cou == 0) {
          JOptionPane.showMessageDialog(this, "검색결과가 없습니다.");
          rs1.absolute(currentRow);
        }
      } catch (Exception e1) {
        System.out.println("고객 번호 검색 오류" + e1);
      }

    } else if (e.getSource() == btnOption) {

      // 생략.

    } else if (e.getSource() == btnClose) {
      try {
        if(rs1 != null) rs1.close();
        if (rs2 != null) rs2.close();
        if (conn != null) conn.close();
        if (pstmt != null) pstmt.close();
      } catch (Exception e1) {
        System.out.println("반납 닫기 오류");
      } finally {
        BookMain.book_ban.setEnabled(true);
        BookMain.childWinBan.dispose();	// 메인화면에 있는 대여창 닫기
      }
    }


  }



	public void design(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//고객정보 패널========================
		JPanel customerPn=new JPanel(new GridLayout(4,1));
		customerPn.setBorder(new TitledBorder(new TitledBorder("고객 정보"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		JPanel cPn1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cPn4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		txtCbun=new JTextField("",5);
		txtCirum=new JTextField("",10);
		txtCjunhwa=new JTextField("",15);
		txtCjuso=new JTextField("",28);
		txtCdaesu=new JTextField("",5);
		taCmemo=new JTextArea(2,28);
		JScrollPane scroll=new JScrollPane(taCmemo);
		taCmemo.setBackground(Color.lightGray);
		
		txtCbun.setEditable(false);
		txtCirum.setEditable(false);
		txtCjunhwa.setEditable(false);
		txtCjuso.setEditable(false);
		txtCdaesu.setEditable(false);
		taCmemo.setEditable(false);
		
		btnInsert=new JButton("신규");
		btnOk=new JButton("확인");
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
		cPn1.add(new JLabel("번호 :"));
		cPn1.add(txtCbun);
		cPn1.add(new JLabel("       이름 :"));
		cPn1.add(txtCirum);
		
		cPn2.add(new JLabel("전화 :"));
		cPn2.add(txtCjunhwa);	
		cPn2.add(new JLabel("      대여횟수 :"));
		cPn2.add(txtCdaesu);
		
		cPn3.add(new JLabel("주소 :"));
		cPn3.add(txtCjuso);
		
		cPn4.add(new JLabel("메모 :"));
		cPn4.add(scroll);

		customerPn.add(cPn1);  customerPn.add(cPn2); 	customerPn.add(cPn3);	customerPn.add(cPn4);
		this.add(customerPn);
		
		btnOk.setEnabled(false);
		
		//레코드 이동 패널========================
		JPanel movePn=new JPanel();
		movePn.setBorder(new TitledBorder(new TitledBorder("레코드 이동"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		movePn.add(btnF);
		movePn.add(btnP);
		movePn.add(lblRec);
		movePn.add(btnN);
		movePn.add(btnL);
		
		this.add(movePn);
		
        //명령 버튼 패널========================
		JPanel bottomPn1=new JPanel();
		bottomPn1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		bottomPn1.add(btnInsert);
		bottomPn1.add(btnOk);
		JLabel lbl1=new JLabel("    "); 
		bottomPn1.add(lbl1);
		bottomPn1.add(btnUpdate);
		bottomPn1.add(btnDel);
		
		JPanel bottomPn2=new JPanel();
		bottomPn2.add(btnFind);
		bottomPn2.add(btnOption);
		JLabel lbl2=new JLabel("                          "); 
		bottomPn2.add(lbl2);
		bottomPn2.add(btnClose);
		
		this.add(bottomPn1);
		this.add(bottomPn2);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	public static void main(String[] args) {
		BookCustomer bookCustomer=new BookCustomer();
		JFrame frame=new JFrame("고객 창");
		frame.getContentPane().add(bookCustomer);
		frame.setBounds(200,200,430,450);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}*/
