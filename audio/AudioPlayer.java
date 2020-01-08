package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioPlayer {

    private Clip audioToBePlayed;
    FloatControl gainControl;

    public AudioPlayer(String path) {
        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            audioToBePlayed = AudioSystem.getClip();
            audioToBePlayed.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play(float volume) {
        if (audioToBePlayed != null) {
            gainControl = (FloatControl) audioToBePlayed.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            audioToBePlayed.setFramePosition(0);
            audioToBePlayed.start();
        }
    }

    public void stop() {
        audioToBePlayed.stop();
    }
}