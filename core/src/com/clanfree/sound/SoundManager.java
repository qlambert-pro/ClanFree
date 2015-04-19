package com.clanfree.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	private static SoundManager singleton;
	
	
	private Sound deadZombie;
	private long  arrowxid;
	private Sound arrowx;
	private long  arrowyid;
	private Sound arrowy;
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
		zombie = Gdx.audio.newSound(Gdx.files.internal("sound/zombie.wav"));	
		arrowx = Gdx.audio.newSound(Gdx.files.internal("sound/arrow1.wav"));
		arrowy = Gdx.audio.newSound(Gdx.files.internal("sound/arrow1.wav"));
		music = Gdx.audio.newSound(Gdx.files.internal("sound/background.wav"));
	}
	
	public void startBackGroundMusic(){
		long id = music.play();
		music.setLooping(id,true);
		music.setVolume(id, volume);
	}
	
	public void startArrow() {
		/*
		arrowxid = arrowx.play();
		arrowx.setLooping(arrowxid,true);
		arrowx.setVolume(arrowxid, 0.3f);
	
		arrowyid = arrowy.play();
		arrowy.setLooping(arrowyid,true);
		arrowy.setVolume(arrowyid, 0.3f);
		*/
	}
	
	
	public void startZombie() {
		long id = zombie.play();
		zombie.setVolume(id, volume);
	}
	
	public void stopArrow() {
		arrowx.stop();
		arrowy.stop();
	}
	
	public void setPitchArrow(float x, float y) {
		/*
		arrowx.setPitch(arrowxid, x);
		arrowy.setPitch(arrowyid, y);
		*/
	}
	
	public void endBackgroundMusic() {
		music.stop();
	}
	
	public void deadZombie(){
		long id = deadZombie.play();
		deadZombie.setVolume(id, volume);
	}	
}
