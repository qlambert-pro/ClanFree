package com.clanfree.configuration;

import com.clanfree.physics.PhysicsManager;

public class ConfigManager {
	
	public static int minBlockSize = 60;
	
	public static float moveSpeed = 10;
	public static float accTime = 0.2f;

	public static float physicsStepSize = 1f/60f;
	
	
	/* Camera settings */
	public static float camWidth = 64;
	public static float camHeight = 36;

	public static float epsilon = 0.01f;
	public static float playerDamping = 5.0f;
	public static float arrowDamping = 1f;
	
	public static final float max_distance = camWidth*1000*PhysicsManager.WORLD_TO_BOX;
}
