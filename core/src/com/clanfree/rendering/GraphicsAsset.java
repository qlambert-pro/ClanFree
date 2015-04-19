package com.clanfree.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class GraphicsAsset {
	public static Animation adjouaStanding;
	public static Animation zombie;
	public static Animation arrow;
	
	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}
	
	public static void load() {
		Texture characAnim = loadTexture("character.png"); 
		
		adjouaStanding =     new Animation(0.2f, new TextureRegion(characAnim, 0,   0, 400, 400), new TextureRegion(characAnim, 400,   0, 400, 400));
		adjouaStanding.setPlayMode(PlayMode.LOOP);
		
		zombie = new Animation(0.2f, new TextureRegion(characAnim, 0,   400, 400, 400), new TextureRegion(characAnim, 400,   400, 400, 400));
		zombie.setPlayMode(PlayMode.LOOP);
		
		arrow = new Animation(0.2f, new TextureRegion(characAnim, 0,  800, 400, 400), new TextureRegion(characAnim, 400,   800, 400, 400));
		arrow.setPlayMode(PlayMode.LOOP);
		
		
	}
	
	public static ParticleEffect getGore() {
		ParticleEffect gore = new ParticleEffect();
		gore.load(Gdx.files.internal("gore.p"), Gdx.files.internal("."));
		
		return gore;
	}
}
