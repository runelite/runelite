/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.instancemap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Region;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.client.events.GameStateChanged;
import net.runelite.client.events.MapRegionChanged;
import static net.runelite.client.plugins.instancemap.PixelMaps.ALL;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_LEFT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_LEFT_TO_TOP_RIGHT;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_RIGHT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.LEFT;
import static net.runelite.client.plugins.instancemap.PixelMaps.RIGHT;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_LEFT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_RIGHT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_RIGHT_TO_BOTTOM_LEFT;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

class InstanceMapOverlay extends Overlay
{
	/**
	 * The size of tiles on the map. The way the client renders requires
	 * this value to be 4. Changing this will break the method for rendering
	 * complex tiles
	 */
	static final int TILE_SIZE = 4;

	/**
	 * The multiplier to scale the map size by. This is just for rendering
	 * mapImage. mapImage is scaled by this value
	 */
	private static final double MAP_SCALING = 1;

	/**
	 * The size of the player's position marker on the map
	 */
	private static final int PLAYER_MARKER_SIZE = 4;

	private static final int MAX_PLANE = 3;
	private static final int MIN_PLANE = 0;

	/**
	 * The plane to render on the instance map. When the map is opened this
	 * defaults to the current plane. The ascend and descend buttons raise
	 * and lower this This is used to render parts of an instance below or
	 * above the local player's current plane.
	 */
	private int viewedPlane = 0;

	private final Client client;
	private final InstanceMapConfig config;

	/**
	 * Saved image of the region, no reason to draw the whole thing every
	 * frame. This is redrawn in the drawToBufferedImage method
	 */
	private BufferedImage mapImage;
	private boolean showMap = false;

	@Inject
	InstanceMapOverlay(@Nullable Client client, InstanceMapConfig config)
	{
		super(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
	}

	public boolean isMapShown()
	{
		return showMap;
	}

	/**
	 * Setter for showing the map. When the map is set to show, the map is
	 * re-rendered
	 *
	 * @param show Whether or not the map should be shown.
	 */
	public void setShowMap(boolean show)
	{
		showMap = show;
		if (showMap)
		{
			viewedPlane = client.getPlane();//When we open the map show the current plane
			mapImage = drawMapImage(getTiles());
		}
	}

	/**
	 * Increases the viewed plane. The maximum viewedPlane is 3
	 */
	public void onAscend()
	{
		if (viewedPlane >= MAX_PLANE)
		{
			return;
		}

		viewedPlane++;//Increment plane
		mapImage = drawMapImage(getTiles());
	}

	/**
	 * Decreases the viewed plane. The minimum viewedPlane is 0
	 */
	public void onDescend()
	{
		if (viewedPlane <= MIN_PLANE)
		{
			return;
		}

		viewedPlane--;
		mapImage = drawMapImage(getTiles());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled() || !showMap)
		{
			return null;
		}

		if (mapImage == null)
		{
			mapImage = drawMapImage(getTiles());
		}

		//Scale mapImage by the mapScaling to display a larger map.
		graphics.drawImage(mapImage, 0, 0, (int) (mapImage.getWidth() * MAP_SCALING), (int) (mapImage.getHeight() * MAP_SCALING), 0, 0, mapImage.getWidth(), mapImage.getHeight(), null);

		if (client.getPlane() == viewedPlane)//If we are not viewing the plane we are on, don't show player's position
		{
			drawPlayerDot(graphics, client.getLocalPlayer(), Color.white, Color.black);
		}

		Tile[][] tiles = getTiles();
		Dimension mapOverlaySize = new Dimension(tiles.length * TILE_SIZE, tiles[0].length * TILE_SIZE);

		return mapOverlaySize;
	}

	/**
	 * Draws the players position as a dot on the map.
	 *
	 * @param graphics graphics to be drawn to
	 */
	private void drawPlayerDot(Graphics2D graphics, Player player, Color dotColor, Color outlineColor)
	{
		Point playerLocation = player.getRegionLocation();

		Tile[][] tiles = getTiles();
		Point localPlayerPoint = new Point(playerLocation.getX(), (tiles[0].length - 1) - playerLocation.getY()); // flip the y value

		graphics.setColor(dotColor);
		graphics.fillRect((int) (localPlayerPoint.getX() * TILE_SIZE * MAP_SCALING), (int) (localPlayerPoint.getY() * TILE_SIZE * MAP_SCALING), PLAYER_MARKER_SIZE, PLAYER_MARKER_SIZE);//draw the players point on the map
		graphics.setColor(outlineColor);
		graphics.drawRect((int) (localPlayerPoint.getX() * TILE_SIZE * MAP_SCALING), (int) (localPlayerPoint.getY() * TILE_SIZE * MAP_SCALING), PLAYER_MARKER_SIZE, PLAYER_MARKER_SIZE);//outline
	}

	/**
	 * Handles region changes and re-draws the map
	 *
	 * @param event The region change event
	 */
	public void onRegionChange(MapRegionChanged event)
	{
		mapImage = drawMapImage(getTiles());
	}

	/**
	 * Handles game state changes and re-draws the map
	 *
	 * @param event The game state change event
	 */
	public void onGameStateChange(GameStateChanged event)
	{
		mapImage = drawMapImage(getTiles());
	}

	/**
	 * Get the files for the current viewed plane
	 *
	 * @return
	 */
	private Tile[][] getTiles()
	{
		Tile[][][] regionTiles = client.getRegion().getTiles();
		return regionTiles[viewedPlane];
	}

	/**
	 * Draws the map to the the buffered image mapImage
	 *
	 * @param tiles The tiles to draw to the map
	 */
	private BufferedImage drawMapImage(Tile[][] tiles)
	{
		BufferedImage image = new BufferedImage(tiles.length * TILE_SIZE, tiles[0].length * TILE_SIZE, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		drawInstanceMap(g);
		g.dispose();
		return image;
	}

	/**
	 * Draws all the tiles on the current plane of client.reigion to the
	 * screen. This will show instances unlike the world map.
	 *
	 * @param graphics graphics to draw to
	 * @return The dimensions of the map
	 */
	private void drawInstanceMap(Graphics2D graphics)
	{
		Region region = client.getRegion();
		Tile[][] tiles = getTiles();

		Dimension mapOverlaySize = new Dimension(tiles.length * TILE_SIZE, tiles[0].length * TILE_SIZE);

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, mapOverlaySize.width, mapOverlaySize.height);//draw background
		graphics.setColor(Color.white);
		graphics.drawRect(0, 0, mapOverlaySize.width - 1, mapOverlaySize.height - 1);//draw outline

		//Draw the base colors first
		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = tiles[x].length - 1; y >= 0; y--)//flip y value
			{
				drawTileColor(graphics, region, tiles[x][(tiles[x].length - 1) - y], x, y);
			}
		}

		//Draw walls on top
		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = tiles[x].length - 1; y >= 0; y--)//Flip y value
			{
				drawTileWalls(graphics, tiles[x][(tiles[x].length - 1) - y], x, y);
			}
		}

	}

	private void drawTileWalls(Graphics2D graphics, Tile curTile, int x, int y)
	{
		if (curTile != null)
		{
			WallObject wallObject = curTile.getWallObject();
			if (wallObject != null)
			{
				drawWallObject(graphics, wallObject, curTile, x * TILE_SIZE, y * TILE_SIZE);
			}
		}
	}

	private void drawTileColor(Graphics2D graphics, Region region, Tile curTile, int x, int y)
	{
		if (curTile != null)
		{
			SceneTilePaint sceneTilePaint = curTile.getSceneTilePaint();
			SceneTileModel sceneTileModel = curTile.getSceneTileModel();

			if (sceneTilePaint != null)
			{
				drawMapPixel(graphics, sceneTilePaint, x * TILE_SIZE, y * TILE_SIZE);
			}
			else if (sceneTileModel != null)
			{
				drawComplexMapPixel(graphics, sceneTileModel, region, x * TILE_SIZE, y * TILE_SIZE);
			}
		}
	}

	/**
	 * Draws a tile as 4x4 pixels on the map. This tile will be drawn as a
	 * set of 4x4 pixels
	 *
	 * @param graphics graphics to be drawn to
	 * @param sceneTilePaint the tiles sceneTilePaint used to get the RGB
	 * value of that tile
	 * @param startX the top left point at which the 4x4 is drawn
	 * @param startY the top left point at which the 4x4 is drawn
	 */
	private void drawMapPixel(Graphics2D graphics, SceneTilePaint sceneTilePaint, int startX, int startY)
	{
		Color c = new Color(sceneTilePaint.getRBG());//Normal map pixels have only 1 solid color
		graphics.setColor(c);
		graphics.fillRect(startX, startY, TILE_SIZE, TILE_SIZE);
	}

	/**
	 * Gets the walls shape from the orientation
	 *
	 * @param orientationA the wall object's orientationA
	 * @param orientationB the wall object's orientationB
	 * @return A WallShape representing the wall as a 4x4 set of pixels with
	 * an offset
	 */
	private WallShape getWallShape(int orientationA, int orientationB)
	{
		int[][] pixels = ALL;
		WallOffset wallOffset = WallOffset.NONE;

		switch (orientationA)
		{
			case 16:
				//Diagonal /
				pixels = BOTTOM_LEFT_TO_TOP_RIGHT;
				wallOffset = WallOffset.TOP_LEFT;
				break;
			case 32:
				//Diagonal \
				pixels = TOP_RIGHT_TO_BOTTOM_LEFT;
				wallOffset = WallOffset.TOP_RIGHT;
				break;
			case 64:
				//Diagonal /
				pixels = BOTTOM_LEFT_TO_TOP_RIGHT;
				wallOffset = WallOffset.BOTTOM_RIGHT;
				break;
			case 1:
				//Left wall
				pixels = LEFT;
				break;
			case 2:
				//Top wall
				pixels = TOP;
				break;
			case 4:
				//Right wall
				pixels = RIGHT;
				break;
			case 8:
				//Bottom wall
				pixels = BOTTOM;
				break;
			case 128:
				//Diagonal \
				pixels = TOP_RIGHT_TO_BOTTOM_LEFT;
				wallOffset = WallOffset.BOTTOM_LEFT;
				break;
		}

		switch (orientationB)
		{
			case 2:
				//top left corner
				pixels = TOP_LEFT_CORNER;
				break;
			case 4:
				//top right corner
				pixels = TOP_RIGHT_CORNER;
				break;
			case 8:
				//bottom right corner
				pixels = BOTTOM_RIGHT_CORNER;
				break;
			case 1:
				//Bottom left corner
				pixels = BOTTOM_LEFT_CORNER;
				break;
		}

		return new WallShape(pixels, wallOffset);
	}

	/**
	 * Draws a wall on the map using a tiles WallObject. This wall will be
	 * drawn as a set of 4x4 pixels
	 *
	 * @param graphics graphics to be drawn to
	 * @param wallObject the wall object of the tile
	 * @param startX the top left point at which the 4x4 is drawn
	 * @param startY the top left point at which the 4x4 is drawn
	 */
	private void drawWallObject(Graphics2D graphics, WallObject wallObject, Tile tile, int startX, int startY)
	{
		graphics.setColor(Color.white);

		int orientationA = wallObject.getOrientationA();//Orientation is a set of flags stored as an int
		int orientationB = wallObject.getOrientationB();

		WallShape wallShape = getWallShape(orientationA, orientationB);
		int[][] pixels = wallShape.getPixels();

		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = 0; j < pixels.length; j++)
			{
				if (pixels[i][j] == 1)
				{
					//Draw the 4x4 and offset accordingly
					drawPoint(graphics, startX + wallShape.getOffset().xOffset + j, startY + wallShape.getOffset().yOffset + i);
				}
			}
		}

	}

	/**
	 * Draws just one pixel to the screen
	 *
	 * @param graphics Graphics to be drawn to
	 * @param x x position of the pixel
	 * @param y y position of the pixel
	 */
	private void drawPoint(Graphics2D graphics, int x, int y)
	{
		graphics.drawLine(x, y, x, y);
	}

	/**
	 * Draws tiles which have more than one color to them. For example a
	 * tile that falls on the edge of a river will have one part that is
	 * grass, and the other part will be water. To draw these tiles we need
	 * to use two colors. This tile will be drawn as a 4x4 set of pixels
	 *
	 * @param graphics the graphics to be drawn to
	 * @param sceneTileModel The SceneTileModel of the complex tile
	 * @param region The current region
	 * @param startX the top left point at which the 4x4 is drawn
	 * @param startY the top left point at which the 4x4 is drawn
	 */
	private void drawComplexMapPixel(Graphics2D graphics, SceneTileModel sceneTileModel, Region region, int startX, int startY)
	{
		//Most of this code is directly from the client from minimap rendering
		int[][] TILE_MASK_2D = region.getTileMask2d();
		int[][] TILE_ROTATION_2D = region.getTileRotation2d();

		int shape = sceneTileModel.getShape();
		int rotation = sceneTileModel.getRotation();

		int overlay = sceneTileModel.getModelOverlay();//SceneTileModels have only two colors, and overlay and underlay.
		int underlay = sceneTileModel.getModelUnderlay();

		int[] shapes = TILE_MASK_2D[shape];
		int[] rotations = TILE_ROTATION_2D[rotation];

		int rotationIndex = 0;

		for (int i = 0; i < TILE_SIZE; i++)
		{
			for (int j = 0; j < TILE_SIZE; j++)
			{
				int intColor = (shapes[rotations[rotationIndex++]] == 0) ? underlay : overlay;
				Color c = new Color(intColor);
				graphics.setColor(c);
				graphics.fillRect(startX + j, startY + i, 1, 1);
			}
		}

	}

}
