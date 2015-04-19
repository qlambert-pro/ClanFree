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
			aSystem.setAccX(-1);
			return true;

		case Keys.RIGHT:
			aSystem.setAccX(1);
			return true;

		case Keys.UP:
			aSystem.setAccY(1);
			return true;
			
		case Keys.DOWN:
			aSystem.setAccY(-1);
			return true;

		case Keys.A:
		case Keys.Q:
			pSystem.setAccX(-1);
			return true;
			
		case Keys.S:
			pSystem.setAccY(-1);
			return true;

		case Keys.D:
			pSystem.setAccX(1);
			return true;

		case Keys.W:
		case Keys.Z:
			pSystem.setAccY(1);
			return true;
		}

		return false;
	}

	
	   @Override
	   public boolean keyUp (int keycode) {
			switch (keycode) {
			case Keys.LEFT:
				aSystem.setAccX(0);
				return true;

			case Keys.RIGHT:
				aSystem.setAccX(0);
				return true;

			case Keys.UP:
				aSystem.setAccY(0);
				return true;
				
			case Keys.DOWN:
				aSystem.setAccY(0);
				return true;

			case Keys.A:
			case Keys.Q:
				pSystem.setAccX(0);
				return true;
				
			case Keys.S:
				pSystem.setAccY(0);
				return true;

			case Keys.D:
				pSystem.setAccX(0);
				return true;

			case Keys.W:
			case Keys.Z:
				pSystem.setAccY(0);
				return true;
			}
			
			return false;
	   }
}
