package com.clanfree.controls;


import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.clanfree.systems.ArrowSystem;
import com.clanfree.systems.PlayerSystem;


public class PlayerControls extends ControllerAdapter {
	private PlayerSystem pSystem;
	private ArrowSystem aSystem;
	
	public PlayerControls(PlayerSystem pSyst, ArrowSystem as) {
		this.pSystem = pSyst;
		this.aSystem = as;
	}
	
	@Override
	public boolean axisMoved (Controller controller, int axisCode, float value) {
		switch (axisCode) {
		case Xbox360Pad.AXIS_RIGHT_X:
			aSystem.setAccX(value);
			return true;
		case Xbox360Pad.AXIS_RIGHT_Y:
			aSystem.setAccY(-value);
			return true;
		case Xbox360Pad.AXIS_LEFT_X:
			pSystem.setAccY(-value);
			return true;
		case Xbox360Pad.AXIS_LEFT_Y:			
			pSystem.setAccX(value);
			return true;
		}
		
		return false;
	}
	
}
