package com.clanfree.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.clanfree.components.TransformComponent;
import com.clanfree.components.ZombieComponent;
import com.clanfree.configuration.ConfigManager;
import com.clanfree.physics.PhysicsManager;

public class ZombieSystem extends IteratingSystem {
	Entity adjoua;
	Engine engine;
	
	public ZombieSystem(Engine engine, Entity e) {
		super(Family.getFor(ZombieComponent.class));
		adjoua = e;
		this.engine = engine;
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		ZombieComponent zc = entity.getComponent(ZombieComponent.class);
		TransformComponent tp = entity.getComponent(TransformComponent.class);
		if (zc.isDead) {
			PhysicsManager.getInstance().destroyBody(tp.body);
			engine.removeEntity(entity);
		}
		
		
		TransformComponent atp = adjoua.getComponent(TransformComponent.class);	
		
		
		Vector2 accel = new Vector2();
		accel.set(atp.pos);
		accel.sub(tp.pos);
		accel.scl(ZombieComponent.MOVE_ACC * tp.body.getMass()/accel.len());
		
		tp.body.applyForceToCenter(accel, true);
		
		if (!accel.epsilonEquals(0, 0, ConfigManager.epsilon)) {
			tp.rotation = MathUtils.atan2(accel.y, accel.x) -
				MathUtils.atan2(1, 0);
		}
	}

}
