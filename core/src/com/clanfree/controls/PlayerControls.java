package com.clanfree.controls;


import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.clanfree.systems.PlayerSystem;


public class PlayerControls extends ControllerAdapter {
	private PlayerSystem pSystem;
	private long id;
	
	public PlayerControls(PlayerSystem pSyst) {
		this.pSystem = pSyst;
	}
	
	@Override
	public boolean axisMoved (Controller controller, int axisCode, float value) {
		switch (axisCode) {
		case Xbox360Pad.AXIS_RIGHT_X:
			//system.setSpeedX(value);
			return true;
		case Xbox360Pad.AXIS_RIGHT_Y:
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
