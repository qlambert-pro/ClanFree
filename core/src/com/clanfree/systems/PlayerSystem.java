package com.clanfree.systems;

import java.util.HashMap;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.clanfree.components.PlayerComponent;



public class PlayerSystem extends IteratingSystem{	
	private HashMap<Long, Integer> ids = new HashMap<Long, Integer>();
	
	public PlayerSystem() {
		super(Family.getFor(PlayerComponent.class));	
	}
	
	@Override
	public void addedToEngine (Engine engine) {
		super.addedToEngine(engine);
		
		ImmutableArray<Entity> entities = getEntities();
		
		for(int i = 0; i < entities.size(); i++) {
			ids.put(entities.get(i).getId(), i);
		}
	}	
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
	}
}
