package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private Clip audioToBePlayed;

    public AudioPlayer(String path) {
        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            audioToBePlayed = AudioSystem.getClip();
            audioToBePlayed.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play() {
        if (audioToBePlayed != null) {
            audioToBePlayed.setFramePosition(0);
            audioToBePlayed.start();
        }
    }

    public void stop() {
        audioToBePlayed.stop();
    }
}