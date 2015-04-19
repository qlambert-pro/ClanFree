package com.clanfree.mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.clanfree.game.ClanFree;

public class CreditMode extends ScreenAdapter {
	private ClanFree game;
	private long time;
	private int count;
	
	public CreditMode(ClanFree clanFree) {
		game = clanFree;
	}

	@Override
	public void render(float dt) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}

	public void setTime(long timeMillis) {
		time = timeMillis;		
	}

	public void setCount(int zombieCount) {
		count = zombieCount;
	}
	
}
