package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * The <code>AudioPlayer</code> class loads and 
 * plays all the audio files to be played. This 
 * includes all <em>background music</em> and 
 * <em>sound effects</em>.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public class AudioPlayer {

    /**
     * The audio clip to be played.
     */
    private Clip audioToBePlayed;
    /**
     * The gain control of the clip.
     */
    private FloatControl gainControl;

    /**
     * Loads in the audio file using the path provided.
     * 
     * @param path the path of the audio file to be played
     */
    public AudioPlayer(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            audioToBePlayed = AudioSystem.getClip();
            audioToBePlayed.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Plays the audio clip with the specified volume.
     * 
     * @param volume the volume the audio clip is to be played at
     */
    public void play(float volume) {
        if (audioToBePlayed != null) {
            gainControl = (FloatControl) audioToBePlayed.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            audioToBePlayed.setFramePosition(0);
            audioToBePlayed.start();
        }
    }

    /**
     * Stops the audio clip.
     */
    public void stop() {
        audioToBePlayed.stop();
    }
}