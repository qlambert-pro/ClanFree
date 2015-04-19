package com.clanfree.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.joints.RopeJoint;

public class ArrowComponent extends Component {
	public static final int STATE_ARROWING = 0;
	
	public static final float CAP_VELOCITY = 1000f;
	public static final float MOVE_ACC = 50f;
	public static final float FRICTION = 1000f;

	public RopeJoint joint = null;
}
