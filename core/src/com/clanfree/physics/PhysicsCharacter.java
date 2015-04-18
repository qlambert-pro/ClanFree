package com.clanfree.physics;


import com.badlogic.gdx.physics.box2d.Contact;
import com.clanfree.systems.PlayerSystem;

public class PhysicsCharacter implements PhysicsObject {
	private PlayerSystem system;
	long id;
	
	public PhysicsCharacter(long id, PlayerSystem playerSystem) {
		system = playerSystem;
		this.id = id;
	}

	@Override
	public void BeginContactHandler(PhysicsDataStructure struct, Contact contact) {
		
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
