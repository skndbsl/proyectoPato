package animaciones;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	public static final AudioClip explosion = Applet.newAudioClip(Sound.class.getResource("explosion.wav"));
	public static final AudioClip gameover = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
	public static final AudioClip background = Applet.newAudioClip(Sound.class.getResource("background.wav"));
	public static final AudioClip disparos = Applet.newAudioClip(Sound.class.getResource("disparos.wav"));
	public static final AudioClip intro = Applet.newAudioClip(Sound.class.getResource("intro.wav"));
	public static final AudioClip reload = Applet.newAudioClip(Sound.class.getResource("reload.wav"));
}
