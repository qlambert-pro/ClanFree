package com.clanfree.physics;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;


public class PhysicsArrow implements PhysicsObject {
	public Entity arrow;
	
	public PhysicsArrow(Entity a) {
		arrow = a;
	}
	
	
	@Override
	public void BeginContactHandler(PhysicsDataStructure struct, Contact contact) {
		// TODO Auto-generated method stub
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
