package com.clanfree.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.clanfree.components.TextureComponent;
import com.clanfree.components.TransformComponent;
import com.clanfree.map.Map;

public class RenderingSystem extends IteratingSystem {
	
	private SpriteBatch batch;
	private Array<Entity> renderQueue;
	private OrthographicCamera cam;
	private Map map;
	
	private Texture background;

	public RenderingSystem(SpriteBatch batch, Map map, OrthographicCamera cam) {
		super(Family.getFor(TransformComponent.class, TextureComponent.class));
	
		renderQueue = new Array<Entity>();
	
		this.batch = batch;
		this.cam = cam;
		this.map = map;
		
		
		background = new Texture(Gdx.files.internal("background.png"));
		background.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
	}
	

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		
		
		//map.render(batch, cam);
		
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		batch.draw(background, 0, 0, background.getWidth() * 5000, background.getHeight() * 5000, 1000, 1000, 0, 0);
		
		
		for (Entity entity : renderQueue) {
			TextureComponent tex = entity.getComponent(TextureComponent.class);
			
			if (tex.region == null) {
				continue;
			}
			
			TransformComponent t = entity.getComponent(TransformComponent.class);
		
			float width = tex.region.getRegionWidth();
			float height = tex.region.getRegionHeight();
			float originX = width * 0.5f;
			float originY = height * 0.5f;
			
			batch.draw(tex.region,
					   t.pos.x - originX, t.pos.y - originY,
					   originX, originY,
					   width, height,
					   t.scale.x, t.scale.y,
					   MathUtils.radiansToDegrees * t.rotation);
		}
		
		batch.end();
		renderQueue.clear();
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) { 
		renderQueue.add(entity);
	}

}
