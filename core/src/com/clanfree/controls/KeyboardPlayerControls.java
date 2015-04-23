package com.clanfree.controls;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.clanfree.systems.ArrowSystem;
import com.clanfree.systems.PlayerSystem;
	

public class KeyboardPlayerControls extends InputAdapter {
	private PlayerSystem pSystem;	
	private ArrowSystem aSystem;

	public KeyboardPlayerControls(PlayerSystem p, ArrowSystem as) {
		pSystem = p;
		aSystem = as;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.LEFT:
			aSystem.goLeft();
			return true;

		case Keys.RIGHT:
			aSystem.goRight();
			return true;

		case Keys.UP:
			aSystem.goUp();
			return true;
			
		case Keys.DOWN:
			aSystem.goDown();
			return true;

		case Keys.A:
		case Keys.Q:
			pSystem.goLeft();
			return true;
			
		case Keys.S:
			pSystem.goDown();
			return true;

		case Keys.D:
			pSystem.goRight();
			return true;

		case Keys.W:
		case Keys.Z:
			pSystem.goUp();
			return true;
		}

		return false;
	}

	
	   @Override
	   public boolean keyUp (int keycode) {
			switch (keycode) {
			case Keys.LEFT:
				aSystem.goRight();
				return true;

			case Keys.RIGHT:
				aSystem.goLeft();
				return true;

			case Keys.UP:
				aSystem.goDown();
				return true;
				
			case Keys.DOWN:
				aSystem.goUp();
				return true;

			case Keys.A:
			case Keys.Q:
				pSystem.goRight();
				return true;
				
			case Keys.S:
				pSystem.goUp();
				return true;

			case Keys.D:
				pSystem.goLeft();
				return true;

			case Keys.W:
			case Keys.Z:
				pSystem.goDown();
				return true;
			}
			
			return false;
	   }
}
