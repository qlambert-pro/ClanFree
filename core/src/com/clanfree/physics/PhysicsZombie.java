package com.clanfree.physics;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;
import com.clanfree.components.ZombieComponent;


public class PhysicsZombie implements PhysicsObject {
	Entity zombie = null;
	
	public PhysicsZombie(Entity z) {
		zombie = z;
	}
	
	@Override
	public void BeginContactHandler(PhysicsDataStructure struct, Contact contact) {
		if(struct.type == PhysicsObjectType.ARROW) {
			ZombieComponent zc = zombie.getComponent(ZombieComponent.class);
			
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
