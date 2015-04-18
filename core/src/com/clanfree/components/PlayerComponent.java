package com.clanfree.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.controllers.Controller;

public class PlayerComponent extends Component {
	public static final int STATE_RUNNING_AND_PLAYING = 0;
	public static final int STATE_STANDING_AND_PLAYING =1;
	public static final int STATE_STANDING = 2;
	public static final int STATE_RUNNING = 3;
	
	public static final float MOVE_ACC = 100f;
	public static final float WIDTH = 0.8f;
	
	public static final float MASS = 1.0f;
	
	public Controller c = null;
}
