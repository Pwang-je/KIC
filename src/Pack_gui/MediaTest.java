/*
package Pack_gui;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MediaTest {
  public void kbs() {
    File file;
    AudioInputStream stream;
    AudioFormat format;
    DataLine dataLine;    // 데이터 시작, 방송

    file = new File("c:/work/packman/gun.wav");

    Clip clip;    // 자바에서 사운드 처리하기 위한.

    try {
      stream = AudioSystem.getAudioInputStream(file);
      format = stream.getFormat();
      info = new DataLine.Info(Clip.class,format);
      clip = (Clip)AudioSystem.getLine(info);
      clip.open(stream);
      clip.start();
    } catch (Exception e) {

    }

  }
  public static void main(String[] args) {

    MediaTest test = new MediaTest();

    while (true) {
      try {
        test.kbs();
        Thread.sleep(3000);
      } catch (Exception e) {

      }
    }





  }

}
*/
