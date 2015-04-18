package com.clanfree.game;

import com.badlogic.gdx.Game;
import com.clanfree.mode.GameMode;
import com.clanfree.rendering.GraphicsAsset;

public class ClanFree extends Game {
	private GameMode gameMode = null;
	
	@Override
	public void create () {
		GraphicsAsset.load();
		
		gameMode = new GameMode(this);
		setScreen(gameMode);
	}
}
