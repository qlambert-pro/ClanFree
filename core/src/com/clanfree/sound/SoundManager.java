package com.clanfree.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	private static SoundManager singleton;
	
	
	private Sound deadZombie;
	private Sound arrow;
	private Sound zombie;
	private Sound music;
	
	private float volume = 1f;
	
	
	public static SoundManager getInstance(){
		if (singleton == null)
			singleton = new SoundManager();
		return singleton;
	}
	
	private SoundManager() {
		deadZombie = Gdx.audio.newSound(Gdx.files.internal("sound/deadZombie.wav"));				
		//zombie = Gdx.audio.newSound(Gdx.files.internal("sound/zombie.wav"));	
		//arrow = Gdx.audio.newSound(Gdx.files.internal("sound/arrow.wav"));
		music = Gdx.audio.newSound(Gdx.files.internal("sound/background.wav"));
	}
	
	public void startBackGroundMusic(){
		long id = music.play();
		music.setLooping(id,true);
		music.setVolume(id, volume);
	}
	
	public void endBackgroundMusic() {
		music.stop();
	}
	
	public void deadZombie(){
		long id = deadZombie.play();
		deadZombie.setVolume(id, volume);
	}	
	//deadZombie.setPitch(id, pitch);
}
