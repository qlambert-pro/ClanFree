package com.clanfree.mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.clanfree.controls.CreditControl;
import com.clanfree.game.ClanFree;

public class CreditMode extends ScreenAdapter {
	private ClanFree game;
	private long time;
	private int count;
	
	private SpriteBatch batch;
	private BitmapFont font;
	
	public CreditMode(ClanFree clanFree) {
		game = clanFree;
	}

	@Override
	public void render(float dt) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		
		String timeStr = "Time survived: " + Float.toString(time/(float)1000);
		String zombiesStr = "Zombies killed: " + Long.toString(count);
		
		String esc = "Press Escape to quit the game.";
		String ent = "Press Enter to retry the game.";
		
		String credit = "Developed by Daiwen";
		
		batch.begin();
		font.draw(batch, timeStr, 100, 400);
		font.draw(batch, zombiesStr, 100, 350);
		font.draw(batch, esc, 100, 250);
		font.draw(batch, ent, 100, 200);
		
		font.draw(batch, credit, 100, 100);
		batch.end();
		
	}
	
	public void show() {
		InputAdapter inputs = new CreditControl(this);
		game.setInputProcessor(inputs);
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.scale(0.1f);
	}

	public void setTime(long timeMillis) {
		time = timeMillis;		
	}

	public void setCount(int zombieCount) {
		count = zombieCount;
	}

	public void restart() {
		game.startGameMode();		
	}

	public void gameOver() {
		System.exit(0);		
	}
	
}
