package com.clanfree.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.clanfree.mode.GameMode;
import com.clanfree.rendering.GraphicsAsset;
import com.clanfree.mode.CreditMode;



public class ClanFree extends Game {
	private GameMode gameMode = null;
	private CreditMode creditMode = null;
		
	private InputMultiplexer inputs = new InputMultiplexer();
	
	@Override
	public void create () {
		GraphicsAsset.load();
		
		gameMode = new GameMode(this);
		setScreen(gameMode);
		
		Gdx.input.setInputProcessor(inputs);
	}
	
	public void startCreditMode(long timeMillis, int zombieCount) {
		this.inputs.clear();
		
		if (creditMode == null)
			creditMode = new CreditMode(this);
		creditMode.setTime(timeMillis);
		creditMode.setCount(zombieCount);
		setScreen(creditMode);
	}

	public void setInputProcessor(InputAdapter inputs) {
		this.inputs.addProcessor(inputs);
	}
	
	public void removeInputProcessor(InputAdapter inputs) {
		this.inputs.removeProcessor(inputs);
	}
}
