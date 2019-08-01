/*
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.roguesden;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.api.ObjectID.*;

class Obstacles
{
	static final Map<WorldPoint, Obstacle> TILE_MAP = new HashMap<>();
	static final Obstacle[] OBSTACLES =
	{
		new Obstacle(3050, 4997, "Enter"),
		new Obstacle(3049, 4997, CONTORTION_BARS),
		new Obstacle(3039, 4999, "Stand"),
		new Obstacle(3029, 5003, "Run"),
		new Obstacle(3024, 5001, "Open", GRILL_7255),
		new Obstacle(3011, 5005, "Run"),
		new Obstacle(3004, 5003, "Run"),

		new Obstacle(2994, 5004, "Climb"),
		new Obstacle(2993, 5004, LEDGE_7240),
		new Obstacle(2994, 5005, "Climb"),
		new Obstacle(2993, 5005, LEDGE_7240),

		new Obstacle(2969, 5016, "Stand"),
		new Obstacle(2969, 5017, "Stand"),
		new Obstacle(2969, 5018, "Stand"),
		new Obstacle(2969, 5019, "Stand"),

		new Obstacle(2958, 5031, "Cross"),
		new Obstacle(2962, 5050, "Stand"),
		new Obstacle(2963, 5056, "Run"),

		new Obstacle(2957, 5068, "Enter"),
		new Obstacle(2957, 5069, PASSAGEWAY),

		new Obstacle(2955, 5094, "Enter"),
		new Obstacle(2955, 5095, PASSAGEWAY),

		new Obstacle(2963, 5105, "Stand"),

		new Obstacle(2972, 5098, "Enter"),
		new Obstacle(2972, 5097, PASSAGEWAY),

		new Obstacle(2972, 5094, "Open"),
		new Obstacle(2972, 5094, GRILL_7255),

		new Obstacle(2982, 5087, "Climb"),
		new Obstacle(2983, 5087, LEDGE_7240),

		new Obstacle(2982, 5090, "Climb"),
		new Obstacle(2983, 5090, LEDGE_7240),

		new Obstacle(2993, 5088, "Search"),
		new Obstacle(2993, 5087, WALL_7249),
		new Obstacle(2997, 5088, "Run"),

		new Obstacle(2993, 5089, "Search"),
		new Obstacle(2993, 5089, WALL_7249),
		new Obstacle(2997, 5089, "Run"),

		new Obstacle(3006, 5088, "Run"),
		new Obstacle(3018, 5080, "Take"),
		new Obstacle(3023, 5082, "Open", DOOR_7234),

		// Maze
		new Obstacle(3030, 5079, GRILL_7255),
		new Obstacle(3032, 5078, GRILL_7255),
		new Obstacle(3036, 5076, GRILL_7255),
		new Obstacle(3039, 5079, GRILL_7255),
		new Obstacle(3042, 5076, GRILL_7255),
		new Obstacle(3044, 5069, GRILL_7255),
		new Obstacle(3041, 5068, GRILL_7255),
		new Obstacle(3040, 5070, GRILL_7255),
		new Obstacle(3038, 5069, GRILL_7255),

		new Obstacle(3028, 5033, "Stand"),
		new Obstacle(3024, 5033, "Run"),
		new Obstacle(3028, 5034, "Stand"),
		new Obstacle(3024, 5034, "Run"),

		new Obstacle(3015, 5033, "Open", GRILL_7255),
		new Obstacle(3010, 5033, "Run/Open", GRILL_7255),

		new Obstacle(3000, 5034, "Run"),

		new Obstacle(2992, 5045, "Stand"),
		new Obstacle(2992, 5053, "Run"),

		new Obstacle(2992, 5067, "Stand"),
		new Obstacle(2992, 5075, "Run"),
		new Obstacle(3009, 5063, "Take"),
		new Obstacle(3028, 5056, "Run"),
		new Obstacle(3028, 5047, "Walk"),

		new Obstacle(3018, 5047, "Crack", WALL_SAFE_7237),

		// Start of 80+ thieving shortcut
		new Obstacle(2967, 5061, "80 Thieving", DOOR_7246),
		new Obstacle(2967, 5066, "80 Thieving", DOOR_7246),
		new Obstacle(2974, 5061, "Enter"),
		new Obstacle(2974, 5060, CONTORTION_BARS),
		new Obstacle(2989, 5057, "Open", GRILL_7255),
		new Obstacle(2989, 5058, "Open", GRILL_7255),

		// The 3x3 square around the spinning blade in the middle of the maze
		new AvoidObstacle(2977, 5090), new AvoidObstacle(2978, 5090), new AvoidObstacle(2979, 5090),
		new AvoidObstacle(2977, 5089), new AvoidObstacle(2978, 5089), new AvoidObstacle(2979, 5089),
		new AvoidObstacle(2977, 5088), new AvoidObstacle(2978, 5088), new AvoidObstacle(2979, 5088),

		new TipObstacle(3014, 5063, "Stun NPC"),
		new TipObstacle(2992, 5057, "Continue North"),  // Hint for 80 thieving shortcut
	};

	@Getter
	static class Obstacle
	{
		private WorldPoint tile;
		private String hint;
		private int objectId = -1;
		private final Color tileColor = Color.GREEN;

		// Highlights tile and shows a hint
		private Obstacle(int x, int y, String hint)
		{
			tile = new WorldPoint(x, y, 1);
			this.hint = hint;
		}

		// Doesn't highlight tile, but instead highlights object of objectId found on tile
		private Obstacle(int x, int y, int objectId)
		{
			this(x, y, "");
			this.objectId = objectId;
			TILE_MAP.put(new WorldPoint(x, y, 1), this);
		}

		// Doesn't highlight tile, but instead highlights object of objectId found on tile and shows a hint
		private Obstacle(int x, int y, String hint, int objectId)
		{
			this(x, y, objectId);
			this.hint = hint;
		}
	}

	private static class AvoidObstacle extends Obstacle
	{
		@Getter
		private final Color tileColor = Color.RED;

		private AvoidObstacle(int x, int y)
		{
			super(x, y, "AVOID");
		}
	}

	private static class TipObstacle extends Obstacle
	{
		@Getter
		private final Color tileColor = Color.ORANGE;

		private TipObstacle(int x, int y, String hint)
		{
			super(x, y, hint);
		}
	}
}
