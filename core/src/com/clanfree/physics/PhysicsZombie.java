package com.clanfree.physics;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;
import com.clanfree.components.StateComponent;
import com.clanfree.components.TransformComponent;
import com.clanfree.components.ZombieComponent;
import com.clanfree.game.WorldBuilder;


public class PhysicsZombie implements PhysicsObject {
	Entity zombie = null;
	
	public PhysicsZombie(Entity z) {
		zombie = z;
	}
	
	@Override
	public void BeginContactHandler(PhysicsDataStructure struct, Contact contact) {
		if(struct.type == PhysicsObjectType.ARROW) {
			StateComponent sc = zombie.getComponent(StateComponent.class);
			ZombieComponent zc = zombie.getComponent(ZombieComponent.class);
			
			TransformComponent tc = ((PhysicsArrow) struct.obj).arrow.getComponent(TransformComponent.class);
			WorldBuilder.getBuilder().buildGore(tc.pos);
			zc.isDead = true;		
		}
	}

	@Override
	public void EndContactHandler(PhysicsDataStructure struct, Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void PreContactHandler(PhysicsDataStructure b, Contact contact) {
		// TODO Auto-generated method stub

	}

}
