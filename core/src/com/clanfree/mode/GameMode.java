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
import com.clanfree.controls.PlayerControls;
import com.clanfree.physics.PhysicsManager;
import com.clanfree.systems.AnimationSystem;
import com.clanfree.systems.ArrowSystem;
import com.clanfree.systems.CameraSystem;
import com.clanfree.systems.PhysicsSystem;
import com.clanfree.systems.PlayerSystem;
import com.clanfree.systems.RenderingSystem;
import com.clanfree.systems.ZombieSystem;

public class GameMode extends ScreenAdapter {
	private ClanFree game;
	
	private Engine engine;
	private MapLoader mapLoader;
	private Map map;
	
	private OrthographicCamera cam;
	
	public GameMode(ClanFree g) {
		game = g;
		
		engine = new Engine();
		WorldBuilder.getBuilder().init(engine);
		
		mapLoader = new MapLoader(engine);
		
		/* Init Map */
		map = mapLoader.load();
		
		
				
		/* Init Character */
		Controller c = Controllers.getControllers().first();
		Entity player = WorldBuilder.getBuilder().buildPlayer(map.getSpawn());
		Entity arrow = WorldBuilder.getBuilder().buildArrow(player, map.getSpawn());
		
		PlayerSystem ps = new PlayerSystem(player); 
		ArrowSystem as = new ArrowSystem(arrow);
		
		c.addListener(new PlayerControls(ps, as));
		
		WorldBuilder.getBuilder().buildZombie(map.getSpawn().cpy().add(10, 10));
		
		cam = new OrthographicCamera(ConfigManager.camWidth  * ConfigManager.minBlockSize,
								 ConfigManager.camHeight * ConfigManager.minBlockSize);
		
		createCamera(player);
		
		engine.addSystem(ps);
		engine.addSystem(as);
		engine.addSystem(new ZombieSystem(engine, player));
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
