package com.clanfree.map;

import java.util.Collection;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

public class Map {
	private TiledMapRenderer tiledMapRenderer;

	private Vector2 spawn;
	private Vector2 size;

	private Texture background;

	public Map(Engine engine, TiledMap tiledMap,
			TiledMapRenderer tiledMapRenderer, Vector2 spawn,
			Vector2 size,
			Collection<Edge> edges) {
		this.tiledMapRenderer = tiledMapRenderer;
		this.spawn = spawn;
		this.size = size;

	}
	
	public void render(Batch batch, OrthographicCamera cam) {
		tiledMapRenderer.setView(cam);
		tiledMapRenderer.render();
	}
	
	public Vector2 getSpawn() {
		return spawn;
	}

	public Vector2 getSize() {
		return size;
	}
}
