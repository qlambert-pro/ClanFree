package com.clanfree.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.clanfree.components.MovementComponent;
import com.clanfree.components.TransformComponent;
import com.clanfree.physics.PhysicsManager;

public class PhysicsSystem extends IteratingSystem {
	private ComponentMapper<TransformComponent> tm;
	private ComponentMapper<MovementComponent> cm;
	
	public PhysicsSystem() {
		super(Family.getFor(MovementComponent.class));
		
		tm = ComponentMapper.getFor(TransformComponent.class);
		cm = ComponentMapper.getFor(MovementComponent.class);
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {				
		TransformComponent tComp = tm.get(entity);		
		
		tComp.pos.set(tComp.body.getWorldCenter().scl(PhysicsManager.BOX_TO_WORLD));
		tComp.rotation = tComp.body.getAngle();
		
		MovementComponent mComp = cm.get(entity);
		
		mComp.velocity.set(tComp.body.getLinearVelocity());
		mComp.rotation_speed = tComp.body.getAngularVelocity();
	}
}
