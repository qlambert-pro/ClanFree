package com.clanfree.physics;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;
import com.clanfree.components.PlayerComponent;

public class PhysicsCharacter implements PhysicsObject {
	Entity player = null;
	
	public PhysicsCharacter(Entity player) {
		this.player = player;
	}

	@Override
	public void BeginContactHandler(PhysicsDataStructure struct, Contact contact) {
		if(struct.type == PhysicsObjectType.ZOMBIE) {
			PlayerComponent pc = player.getComponent(PlayerComponent.class);
			
			pc.isDead = true;		
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
