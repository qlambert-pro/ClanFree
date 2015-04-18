package com.clanfree.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.math.Vector2;
import com.clanfree.components.AnimationComponent;
import com.clanfree.components.MovementComponent;
import com.clanfree.components.PlayerComponent;
import com.clanfree.components.StateComponent;
import com.clanfree.components.TextureComponent;
import com.clanfree.components.TransformComponent;
import com.clanfree.controls.PlayerControls;
import com.clanfree.physics.PhysicsCharacter;
import com.clanfree.physics.PhysicsDataStructure;
import com.clanfree.physics.PhysicsManager;
import com.clanfree.physics.PhysicsObjectType;
import com.clanfree.rendering.GraphicsAsset;
import com.clanfree.systems.PlayerSystem;


public class WorldBuilder {
	static private WorldBuilder builder;
	private Engine engine;
	
	public static WorldBuilder getBuilder() {
		if (builder == null)
			builder = new WorldBuilder();
		return builder;
	}
	
	private WorldBuilder() {
		
	}
	
	public void init (Engine e) {
		engine = e;
	}
	
	public Entity buildPlayer(Controller c, Vector2 p) {
		Entity entity = new Entity();
		
		AnimationComponent animation = new AnimationComponent();
		PlayerComponent player = new PlayerComponent();
		MovementComponent movement = new MovementComponent();
		TransformComponent position = new TransformComponent();
		StateComponent state = new StateComponent();
		TextureComponent texture = new TextureComponent();
		
		//TODO animation
		/*
		animation.animations.put(PlayerComponent.STATE_GRAB, GraphicsAsset.characterGrab);
		animation.animations.put(PlayerComponent.STATE_GRABBING, GraphicsAsset.characterGrabbing);
		animation.animations.put(PlayerComponent.STATE_JUMP, GraphicsAsset.characterJump);
		*/
		animation.animations.put(PlayerComponent.STATE_STANDING, GraphicsAsset.adjouaStanding);
		
		
		position.pos.set(p);
		position.scale.set(0.8f, 0.8f);
		
		 
		state.set(PlayerComponent.STATE_STANDING);
		
		entity.add(animation);
		entity.add(player);
		entity.add(movement);		
		entity.add(position);
		entity.add(state);
		entity.add(texture);
		
		engine.addEntity(entity);
		
		PlayerSystem ps = new PlayerSystem(entity); 
		engine.addSystem(ps);
				
		c.addListener(new PlayerControls(ps));
		
		PhysicsDataStructure s = new PhysicsDataStructure(new PhysicsCharacter(entity.getId(), ps),
														  PhysicsObjectType.PLAYER);
		position.body = PhysicsManager.getInstance().createDynamicCircle(
				position.pos.cpy(), PlayerComponent.WIDTH/2, s);
		PhysicsManager.getInstance().addSensor(position.body, 2*PlayerComponent.WIDTH);
		
		movement.velocity.scl(position.body.getMass());
		position.body.setLinearVelocity(movement.velocity);
		position.body.setAngularDamping(0);				
		
		return entity;
	}
}
