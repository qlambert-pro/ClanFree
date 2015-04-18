package com.clanfree.mode;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.clanfree.game.ClanFree;
import com.clanfree.game.WorldBuilder;
import com.clanfree.map.Map;
import com.clanfree.map.MapLoader;
import com.clanfree.components.CameraComponent;
import com.clanfree.configuration.ConfigManager;
import com.clanfree.physics.PhysicsManager;
import com.clanfree.systems.AnimationSystem;
import com.clanfree.systems.CameraSystem;
import com.clanfree.systems.PhysicsSystem;
import com.clanfree.systems.PlayerSystem;
import com.clanfree.systems.RenderingSystem;

public class GameMode extends ScreenAdapter {
	private ClanFree game;
	
	private Engine engine;
	private MapLoader mapLoader;
	//private CharacterBuilder characterBuilder;
	private Map map;
	
	private OrthographicCamera cam;
	
	public GameMode(ClanFree g) {
		game = g;
	
		engine = new Engine();
		WorldBuilder.getBuilder().init(engine);
		
		mapLoader = new MapLoader(engine);
		//characterBuilder = new CharacterBuilder(engine);
		
		/* Init Map */
		map = mapLoader.load();
		
		
				
		/* Init Character */
		Controller c = Controllers.getControllers().first();
		Entity e = WorldBuilder.getBuilder().buildPlayer(c, map.getSpawn());
		
		cam = new OrthographicCamera(ConfigManager.camWidth  * ConfigManager.minBlockSize,
								 ConfigManager.camHeight * ConfigManager.minBlockSize);
		
		createCamera(e);
		
		engine.addSystem(new PhysicsSystem());
		engine.addSystem(new CameraSystem());
		engine.addSystem(new AnimationSystem());
		engine.addSystem(new RenderingSystem(map, cam));
	}
	
	private void createCamera(Entity target) {
		Entity entity = new Entity();
		CameraComponent camera = new CameraComponent();
		camera.camera = cam;
		camera.target = target;
		entity.add(camera);
		engine.addEntity(entity);
	}
	
	@Override
	public void render(float dt) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		PhysicsManager.getInstance().update(dt);		
		engine.update(dt);
	}
}
