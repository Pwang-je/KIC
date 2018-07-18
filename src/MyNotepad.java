import Pack_gui.NoteAbout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyNotepad extends JFrame implements ActionListener {

  JButton btnCopy = new JButton("Copy");
  JButton btnDel = new JButton("Delete");
  JButton btnPaste = new JButton("Paste");
  JButton btnCut = new JButton("Cut");
  JPanel panel_1 = new JPanel();

  JTextArea txtMemo = new JTextArea("");
  String cpyText;

  // 메뉴 아이템.
  JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
  JMenuItem mnuCopy, mnuPaste, mnuDel, mnuCut;
  JMenuItem mnuAbout, mnuETC1, mnuETC2;

  // 팝업 메뉴.
  JPopupMenu popup;
  JMenuItem mWhite, mBlue, mYellow;

  public MyNotepad() {
    super("Notepad");
    initLayout();
    menuLayout();

    setBounds(200,200,600,600);
    setVisible(true);




    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        int re = JOptionPane.showConfirmDialog(MyNotepad.this, "종료할까요?","종료", JOptionPane.YES_NO_CANCEL_OPTION);
        if (re == JOptionPane.YES_NO_CANCEL_OPTION) {
          setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
      }
    });
  }

  private void initLayout() {
      panel_1.add(btnCopy);
      panel_1.add(btnCut);
      panel_1.add(btnDel);
      panel_1.add(btnPaste);
      add("South", panel_1);  // ( 방향, 이름)
      JScrollPane scrollPane = new JScrollPane(txtMemo);  // 메모장 스크롤 가지기.
      add("Center", scrollPane);

      btnCopy.addActionListener(this);
      btnCut.addActionListener(this);
      btnDel.addActionListener(this);
      btnPaste.addActionListener(this);
  }


  private void menuLayout() {

    JMenuBar menuBar = new JMenuBar();

    JMenu mnuFile = new JMenu("File");  // 주메뉴
    mnuNew = new JMenuItem("새로만들기");
    mnuOpen = new JMenuItem("열기...");
    mnuSave = new JMenuItem("저장...");
    mnuExit = new JMenuItem("종료");
    mnuFile.add(mnuNew);
    mnuFile.add(mnuOpen);
    mnuFile.add(mnuSave);
    mnuFile.addSeparator();
    mnuFile.add(mnuExit);

    JMenu mnuEdit = new JMenu("Edit");
    mnuCopy = new JMenuItem("복사");
    mnuPaste = new JMenuItem("붙여넣기");
    mnuCut = new JMenuItem("잘라내기");
    mnuDel = new JMenuItem("삭제");
    mnuEdit.add(mnuCopy);
    mnuEdit.add(mnuPaste);
    mnuEdit.add(mnuCut);
    mnuEdit.add(mnuDel);

    JMenu mnuHelp = new JMenu("Help");
    mnuAbout = new JMenuItem("Notepad Info...");
    JMenu mnuEtc = new JMenu("기타");
      mnuETC1 = new JMenuItem("계산기");
      mnuETC2 = new JMenuItem("메모장");
    mnuEtc.add(mnuETC1);
    mnuEtc.add(mnuETC2);
    mnuHelp.add(mnuAbout);
    mnuHelp.add(mnuEtc);


    menuBar.add(mnuFile);   // 메뉴바에 메뉴를 장착.
    menuBar.add(mnuEdit);   // 메뉴에 기타를 자앛ㄱ.
    menuBar.add(mnuHelp);
    setJMenuBar(menuBar);   // frame 에 menuBar 를 장착.

    mnuNew.addActionListener(this);
    mnuOpen.addActionListener(this);
    mnuSave.addActionListener(this);
    mnuExit.addActionListener(this);
    mnuCopy.addActionListener(this);
    mnuPaste.addActionListener(this);
    mnuCut.addActionListener(this);
    mnuDel.addActionListener(this);
    mnuAbout.addActionListener(this);
    mnuETC1.addActionListener(this);
    mnuETC2.addActionListener(this);

    // 팝업메ㅔ뉴
    popup = new JPopupMenu();
    JMenu mColor = new JMenu("색상선택");
    mWhite = new JMenuItem("하얀색");
    mBlue = new JMenuItem("파란색");
    mYellow = new JMenuItem("노란색");
    mColor.add(mWhite);
    mColor.add(mBlue);
    mColor.add(mYellow);
    popup.add(mColor);
    txtMemo.add(popup);

    mWhite.addActionListener(this);
    mBlue.addActionListener(this);
    mYellow.addActionListener(this);

    txtMemo.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
          popup.show(txtMemo, e.getX(), e.getY());
        }
      }
    });




  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == btnCopy || e.getSource() == mnuCopy) {
//      System.out.println(txtMemo.getSelectedText());  // 드래그한 텍스트 값을 받아옴.
      cpyText = txtMemo.getSelectedText();
      txtMemo.requestFocus(); // 드래그한 텍스트 focus 유지.
    } else if (e.getSource() == btnPaste || e.getSource() == mnuPaste) {
      int position = txtMemo.getCaretPosition();  // 커서 범위를
      txtMemo.insert(cpyText, position);  // 복사한거 커서가 있는 지점에 붙이기.
    } else if (e.getSource() == btnCut || e.getSource() == mnuCut) {
      cpyText = txtMemo.getSelectedText();

      int start = txtMemo.getSelectionStart(); // 범위의 시작점 얻기
      int end = txtMemo.getSelectionEnd();    // 범위만큼의 값을
      txtMemo.replaceRange("", start, end);

    } else if (e.getSource() == btnDel || e.getSource() == mnuDel) {
      int start = txtMemo.getSelectionStart(); // 범위의 시작점 얻기
      int end = txtMemo.getSelectionEnd();    // 범위만큼의 값을
      txtMemo.replaceRange("", start, end);
    } else if (e.getSource() == mnuNew) {
      txtMemo.setText("");
      this.setTitle("제목없음 메모장");
    } else if (e.getSource() == mnuOpen) {
      FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
      dialog.setDirectory(".");
      dialog.setVisible(true);
      if (dialog.getFile() == null)
        return;

      String dfName = dialog.getDirectory() + dialog.getFile();

      try {
        BufferedReader reader = new BufferedReader(new FileReader(dfName));
        txtMemo.setText("");
        String line;
        while ((line = reader.readLine()) != null) {
          txtMemo.append(line + "\n");
        }
        reader.close();
        this.setTitle(dialog.getFile() + " - 메모장");
      } catch (Exception e1) {
        System.out.println("저장 애러" + e1);
      }
    } else if (e.getSource() == mnuSave) {
      // 경로명 및 파일명 얻기 대화
      FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
      dialog.setDirectory(".");
      dialog.setVisible(true);
      if (dialog.getFile() == null)
        return;

      String dfName = dialog.getDirectory() + dialog.getFile();

      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
        writer.write(txtMemo.getText());
        writer.close();
      } catch (Exception e1) {
        System.out.println("저장 애러" + e1);
      }

    } else if (e.getSource() == mnuExit) {
      System.exit(0);
    } else if (e.getSource() == mnuAbout) {
      new NoteAbout(this);
//      System.out.println("창 호출 후");
    } else if (e.getSource() == mnuETC1) {
      try {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("calc.exe");
      } catch (Exception e1) {

      }
    } else if (e.getSource() == mnuETC2) {
      try {
        Runtime.getRuntime().exec("notepad.exe");
      } catch (Exception e1) {

      }
    } else if (e.getSource() == mWhite) {
      try {
        txtMemo.setBackground(Color.white);
      } catch (Exception e1) {

      }
    } else if (e.getSource() == mBlue) {
      try {
        txtMemo.setBackground(Color.blue);
      } catch (Exception e1) {

      }
    }  else if (e.getSource() == mBlue) {
      try {
        txtMemo.setBackground(Color.blue);
      } catch (Exception e1) {

      }
    }


  }

  public static void main(String[] args) {
    new MyNotepad();
  }


}
