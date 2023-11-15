package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sonido() {
		soundURL[0] = getClass().getResource("/sonido/theme.wav");
		
		soundURL[1] = getClass().getResource("/sonido/powerup.wav");

		soundURL[2] = getClass().getResource("/sonido/menutheme.wav");
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream sis = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(sis);
			
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	
}
