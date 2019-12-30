package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private Clip clip;

    public AudioPlayer(String path) {
        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        public void play() {
            if (clip != null) {
                clip.setFramePosition(0);
                clip.start();
            }
        }

        public void stop() {
            clip.stop();
        }
}