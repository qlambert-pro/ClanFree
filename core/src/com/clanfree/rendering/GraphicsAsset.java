package com.clanfree.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class GraphicsAsset {
	public static Animation adjouaStanding;
	
	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}
	
	public static void load() {
		Texture characAnim = loadTexture("character.png"); 
		adjouaStanding =     new Animation(0.2f, new TextureRegion(characAnim, 0,   0, 400, 400), new TextureRegion(characAnim, 400,   0, 400, 400));
		adjouaStanding.setPlayMode(PlayMode.LOOP);
	}
}
