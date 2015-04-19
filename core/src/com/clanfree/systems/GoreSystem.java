package com.clanfree.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.clanfree.components.GoreComponent;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class GoreSystem extends IteratingSystem {
	Engine engine;
	private Array<Entity> renderQueue;
	private OrthographicCamera cam;
	private SpriteBatch batch;
	
	public GoreSystem(Engine e, SpriteBatch batch, OrthographicCamera cam) {
		super(Family.getFor(GoreComponent.class));
		renderQueue = new Array<Entity>();
		
		engine = e;
		this.batch = batch;
		this.cam = cam;		
	}
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		GoreComponent gc = entity.getComponent(GoreComponent.class);
		
		if(gc.particles.isComplete())
			engine.removeEntity(entity);
		else		
			renderQueue.add(entity);
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for (Entity entity : renderQueue) {
			GoreComponent gc = entity.getComponent(GoreComponent.class);
			gc.particles.draw(batch, deltaTime);
		}
		batch.end();
	}
	
}
