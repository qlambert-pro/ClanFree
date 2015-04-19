package com.clanfree.controls;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.clanfree.mode.CreditMode;

public class CreditControl extends InputAdapter {
	CreditMode cm;
	
	public CreditControl(CreditMode cm) {
		this.cm = cm;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.ENTER:
			cm.restart();
			return true;

		case Keys.ESCAPE:
			cm.gameOver();
			return true;

		
		}
		
		return false;
	}
}
