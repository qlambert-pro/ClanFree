package com.clanfree.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.math.MathUtils;
import com.clanfree.components.MovementComponent;
import com.clanfree.components.PlayerComponent;
import com.clanfree.components.TransformComponent;
import com.clanfree.sound.SoundManager;

public class ArrowSystem extends EntitySystem {	
	private Entity arrow;
	
	public ArrowSystem(Entity a) {
		this.arrow = a;
	}
		
	@Override
	public void update(float dt) {
		TransformComponent tp = arrow.getComponent(TransformComponent.class);
		MovementComponent mp = arrow.getComponent(MovementComponent.class);
		
		SoundManager.getInstance().setPitchArrow(tp.body.getLinearVelocity().x,
												tp.body.getLinearVelocity().y);

		tp.body.applyForceToCenter(mp.accel, true);
		tp.rotation = MathUtils.atan2(tp.body.getLinearVelocity().y, tp.body.getLinearVelocity().x) -
						MathUtils.atan2(1, 0);
		}

	public void setAccX(float value) {
		MovementComponent mp = arrow.getComponent(MovementComponent.class); 
		mp.accel.x = value * PlayerComponent.MOVE_ACC;
	}

	public void setAccY(float value) {
		MovementComponent mp = arrow.getComponent(MovementComponent.class); 
		mp.accel.y = value * PlayerComponent.MOVE_ACC;		
	}

}
