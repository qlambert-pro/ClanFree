package com.clanfree.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.joints.RopeJoint;
import com.badlogic.gdx.physics.box2d.joints.RopeJointDef;
import com.clanfree.components.AnimationComponent;
import com.clanfree.components.ArrowComponent;
import com.clanfree.components.GoreComponent;
import com.clanfree.components.MovementComponent;
import com.clanfree.components.PlayerComponent;
import com.clanfree.components.StateComponent;
import com.clanfree.components.TextureComponent;
import com.clanfree.components.TransformComponent;
import com.clanfree.components.ZombieComponent;
import com.clanfree.configuration.ConfigManager;
import com.clanfree.physics.PhysicsArrow;
import com.clanfree.physics.PhysicsCharacter;
import com.clanfree.physics.PhysicsDataStructure;
import com.clanfree.physics.PhysicsManager;
import com.clanfree.physics.PhysicsObjectType;
import com.clanfree.physics.PhysicsZombie;
import com.clanfree.rendering.GraphicsAsset;



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
	
	public Entity buildPlayer(Vector2 p) {
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
				
		 
		
		PhysicsDataStructure s = new PhysicsDataStructure(new PhysicsCharacter(entity),
														  PhysicsObjectType.PLAYER);
		position.body = PhysicsManager.getInstance().createDynamicCircle(
				position.pos.cpy(), PlayerComponent.WIDTH/2, s);				
		
		return entity;
	}
	
	public Entity buildZombie(Vector2 p) {
		Entity entity = new Entity();
		
		AnimationComponent animation = new AnimationComponent();
		ZombieComponent zombie = new ZombieComponent();
		MovementComponent movement = new MovementComponent();
		TransformComponent position = new TransformComponent();
		StateComponent state = new StateComponent();
		TextureComponent texture = new TextureComponent();
		

		animation.animations.put(ZombieComponent.STATE_FOLLOWING, GraphicsAsset.zombie);
		animation.animations.put(ZombieComponent.STATE_DEAD, GraphicsAsset.zombie);
		
		
		position.pos.set(p);
		position.scale.set(0.8f, 0.8f);
		
		 
		state.set(ZombieComponent.STATE_FOLLOWING);
		
		entity.add(animation);
		entity.add(zombie);
		entity.add(movement);		
		entity.add(position);
		entity.add(state);
		entity.add(texture);
		
		engine.addEntity(entity);

		PhysicsDataStructure s = new PhysicsDataStructure(new PhysicsZombie(entity),
														  PhysicsObjectType.ZOMBIE);
		position.body = PhysicsManager.getInstance().createDynamicCircle(
				position.pos.cpy(), PlayerComponent.WIDTH/2, s);		
		
		movement.velocity.scl(position.body.getMass());
		position.body.setLinearVelocity(movement.velocity);
		position.body.setAngularDamping(0);				
		
		return entity;
	}
	
	public Entity buildArrow(Entity player, Vector2 p){
		Entity entity = new Entity();
		
		AnimationComponent animation = new AnimationComponent();
		ArrowComponent arrow = new ArrowComponent();
		MovementComponent movement = new MovementComponent();
		TransformComponent position = new TransformComponent();
		StateComponent state = new StateComponent();
		TextureComponent texture = new TextureComponent();
		

		animation.animations.put(ArrowComponent.STATE_ARROWING, GraphicsAsset.arrow);		
		
		position.pos.set(p);
		position.scale.set(0.8f, 0.8f);
		
		 
		state.set(ArrowComponent.STATE_ARROWING);
		
		entity.add(animation);
		entity.add(arrow);
		entity.add(movement);		
		entity.add(position);
		entity.add(state);
		entity.add(texture);
		
		engine.addEntity(entity);

		PhysicsDataStructure s = new PhysicsDataStructure(new PhysicsArrow(entity),
														  PhysicsObjectType.ARROW);
		position.body = PhysicsManager.getInstance().createArrow(
				position.pos.cpy(), PlayerComponent.WIDTH*2, s);		
		
		movement.velocity.scl(position.body.getMass());
		position.body.setLinearVelocity(movement.velocity);
		position.body.setAngularDamping(0);	
		
		Body anchorPlayer = player.getComponent(TransformComponent.class).body;
		
		RopeJointDef jointDef = new RopeJointDef();
		jointDef.bodyA = position.body;
		jointDef.bodyB = anchorPlayer;
		jointDef.collideConnected = true;
		jointDef.maxLength = ConfigManager.max_distance * PhysicsManager.WORLD_TO_BOX;
		
		arrow.joint = (RopeJoint) PhysicsManager.getInstance().createJoint(jointDef);
		
		return entity;
	}
	
	public Entity buildGore(Vector2 p){
		Entity entity = new Entity();
		
		GoreComponent gore = new GoreComponent();
		gore.particles = GraphicsAsset.getGore();
		gore.particles.setPosition(p.x, p.y);
		gore.particles.start();
		
		
		entity.add(gore);	
		
		engine.addEntity(entity);		
		
		return entity;
	}
}
