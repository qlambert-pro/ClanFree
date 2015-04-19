package com.clanfree.game;

import com.badlogic.gdx.Game;
import com.clanfree.mode.GameMode;
import com.clanfree.rendering.GraphicsAsset;
import com.clanfree.mode.CreditMode;



public class ClanFree extends Game {
	private GameMode gameMode = null;
	private CreditMode creditMode = null;
		
	@Override
	public void create () {
		GraphicsAsset.load();
		
		gameMode = new GameMode(this);
		setScreen(gameMode);
	}
	
	public void startCreditMode(long timeMillis, int zombieCount) {
		if (creditMode == null)
			creditMode = new CreditMode(this);
		creditMode.setTime(timeMillis);
		creditMode.setCount(zombieCount);
		setScreen(creditMode);
	}
}
