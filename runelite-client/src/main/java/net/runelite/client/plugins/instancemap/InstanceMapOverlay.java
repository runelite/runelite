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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.IndexedSprite;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Region;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.SpritePixels;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MapRegionChanged;
import static net.runelite.client.plugins.instancemap.PixelMaps.ALL;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_LEFT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_LEFT_DOT;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_LEFT_TO_TOP_RIGHT;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_RIGHT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.BOTTOM_RIGHT_DOT;
import static net.runelite.client.plugins.instancemap.PixelMaps.LEFT;
import static net.runelite.client.plugins.instancemap.PixelMaps.RIGHT;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_LEFT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_LEFT_DOT;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_LEFT_TO_BOTTOM_RIGHT;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_RIGHT_CORNER;
import static net.runelite.client.plugins.instancemap.PixelMaps.TOP_RIGHT_DOT;
import static net.runelite.client.plugins.instancemap.WallOffset.BOTTOM_LEFT;
import static net.runelite.client.plugins.instancemap.WallOffset.BOTTOM_RIGHT;
import static net.runelite.client.plugins.instancemap.WallOffset.NONE;
import static net.runelite.client.plugins.instancemap.WallOffset.TOP_LEFT;
import static net.runelite.client.plugins.instancemap.WallOffset.TOP_RIGHT;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.BackgroundComponent;

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
	private final InstanceMapPlugin plugin;

	/**
	 * The plane to render on the instance map. When the map is opened this
	 * defaults to the current plane. The ascend and descend buttons raise
	 * and lower this This is used to render parts of an instance below or
	 * above the local player's current plane.
	 */
	private int viewedPlane = 0;

	private final Client client;

	/**
	 * Saved image of the region, no reason to draw the whole thing every
	 * frame.
	 */
	private volatile BufferedImage mapImage;
	private volatile boolean showMap = false;
	private final BackgroundComponent backgroundComponent = new BackgroundComponent();

	@Inject
	InstanceMapOverlay(Client client, InstanceMapPlugin plugin)
	{
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	public Dimension getInstanceMapDimension()
	{
		BufferedImage image = mapImage;

		if (image == null)
		{
			return null;
		}

		return new Dimension(image.getWidth(), image.getHeight());
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
	public synchronized void setShowMap(boolean show)
	{
		showMap = show;
		if (showMap)
		{
			//When we open the map show the current plane
			viewedPlane = client.getPlane();
		}
		mapImage = null;
	}

	/**
	 * Increases the viewed plane. The maximum viewedPlane is 3
	 */
	public synchronized void onAscend()
	{
		if (viewedPlane >= MAX_PLANE)
		{
			return;
		}

		viewedPlane++;//Increment plane
		mapImage = null;
	}

	/**
	 * Decreases the viewed plane. The minimum viewedPlane is 0
	 */
	public synchronized void onDescend()
	{
		if (viewedPlane <= MIN_PLANE)
		{
			return;
		}

		viewedPlane--;
		mapImage = null;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point parent)
	{
		if (!showMap)
		{
			return null;
		}

		// avoid locking on fast path by creating a local ref
		BufferedImage image = mapImage;

		if (image == null)
		{
			image = drawMapImage(getTiles());
			synchronized (this)
			{
				if (showMap)
				{
					mapImage = image;
				}
			}
		}

		final Point offset = plugin.getMapOffset();

		graphics.drawImage(image, offset.getX(), offset.getY(), null);

		if (client.getPlane() == viewedPlane)//If we are not viewing the plane we are on, don't show player's position
		{
			drawPlayerDot(graphics, offset.getX(), offset.getY(), client.getLocalPlayer(), Color.white, Color.black);
		}

		return getInstanceMapDimension();
	}

	/**
	 * Draws the players position as a dot on the map.
	 *
	 * @param graphics graphics to be drawn to
	 */
	private void drawPlayerDot(Graphics2D graphics, int baseX, int baseY, Player player,
		Color dotColor, Color outlineColor)
	{
		LocalPoint playerLoc = player.getLocalLocation();

		Tile[][] tiles = getTiles();
		int tileX = playerLoc.getRegionX();
		int tileY = (tiles[0].length - 1) - playerLoc.getRegionY(); // flip the y value

		int x = baseX + (int) (tileX * TILE_SIZE * MAP_SCALING);
		int y = baseY + (int) (tileY * TILE_SIZE * MAP_SCALING);
		graphics.setColor(dotColor);
		graphics.fillRect(x, y, PLAYER_MARKER_SIZE, PLAYER_MARKER_SIZE);//draw the players point on the map
		graphics.setColor(outlineColor);
		graphics.drawRect(x, y, PLAYER_MARKER_SIZE, PLAYER_MARKER_SIZE);//outline
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

		backgroundComponent.setFill(false);
		backgroundComponent.setRectangle(new Rectangle(0, 0, mapOverlaySize.width, mapOverlaySize.height));
		backgroundComponent.render(graphics, new java.awt.Point());

		//These loops are seperated on purpose to prevent layering issues. This is how it's written in the client
		//Draw the base colors first
		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = tiles[x].length - 1; y >= 0; y--)//flip y value
			{
				drawTileColor(graphics, region, tiles[x][(tiles[x].length - 1) - y], x, y);
			}
		}

		//environment
		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = tiles[x].length - 1; y >= 0; y--)//Flip y value
			{
				drawEnvironment(graphics, region, tiles[x][(tiles[x].length - 1) - y], x, y);//draw trees/rocks/bushes
			}
		}

		//Draw walls
		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = tiles[x].length - 1; y >= 0; y--)//Flip y value
			{
				drawTileWalls(graphics, tiles[x][(tiles[x].length - 1) - y], x, y);
			}
		}

		//Finally draw map icons on top of that
		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = tiles[x].length - 1; y >= 0; y--)//Flip y value
			{
				drawMapIcons(graphics, region, tiles[x][(tiles[x].length - 1) - y], x, y);//draw map icons
			}
		}

	}

	private void drawTileWalls(Graphics2D graphics, Tile curTile, int x, int y)
	{
		if (curTile == null)
		{
			return;
		}

		WallObject wallObject = curTile.getWallObject();
		if (wallObject != null)
		{
			drawWallObject(graphics, wallObject, curTile, x * TILE_SIZE, y * TILE_SIZE);
		}
	}

	private void drawTileColor(Graphics2D graphics, Region region, Tile curTile, int x, int y)
	{
		if (curTile == null)
		{
			return;
		}

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

	private void drawMapIcons(Graphics2D graphics, Region region, Tile curTile, int x, int y)
	{
		if (curTile == null)
		{
			return;
		}

		//Draw game objects
		GroundObject groundObject = curTile.getGroundObject();
		if (groundObject == null)
		{
			return;
		}

		int hash = groundObject.getHash();
		int objId = groundObject.getId();

		int startX = x * TILE_SIZE;
		int startY = y * TILE_SIZE;

		if (hash != 0)
		{
			ObjectComposition objectComposition = client.getObjectDefinition(objId);
			int mapIconId = objectComposition.getMapIconId();
			if (mapIconId >= 0)
			{
				// this parameter is unused
				SpritePixels sprite = client.getMapAreas()[mapIconId].getMapIcon(false);

				if (sprite == null)
				{
					return;
				}

				BufferedImage img = sprite.toBufferedImage();
				graphics.drawImage(img, startX - (img.getWidth() / 2), startY - (img.getHeight() / 2), null);
			}
		}
	}

	private void drawEnvironment(Graphics2D graphics, Region region, Tile curTile, int x, int y)
	{
		if (curTile == null)
		{
			return;
		}

		//Draw game objects
		GameObject[] gameObjects = curTile.getGameObjects();
		if (gameObjects != null)
		{
			Tile[][] tiles = getTiles();
			for (GameObject gameObject : gameObjects)
			{
				if (gameObject == null)
				{
					continue;
				}

				int hash = gameObject.getHash();
				int objId = gameObject.getId();

				int startX = x * TILE_SIZE;
				int startY = y * TILE_SIZE;

				if (hash == 0)
				{
					continue;
				}

				ObjectComposition objectComposition = client.getObjectDefinition(objId);
				if (objectComposition.getMapSceneId() != -1)
				{
					Point gameObjectLocation = gameObject.getRegionMinLocation();
					int tileX = x;
					int tileY = ((tiles[x].length - 1) - y);//flip y value

					if (gameObjectLocation.getX() == tileX && gameObjectLocation.getY() == tileY)
					{

						IndexedSprite objectMapSprite = client.getMapScene()[objectComposition.getMapSceneId()];
						if (objectMapSprite != null)
						{
							drawIndexedSprite(graphics, objectMapSprite, gameObject, startX, startY);
						}
					}
				}

			}
		}
	}

	private void drawIndexedSprite(Graphics2D graphics, IndexedSprite indexedSprite, GameObject gameObject, int startX, int startY)
	{
		//Mostly from code in IndexedSprite
		int sourceOffset = 0;

		//For some reason some sprites don't have a byte array that is the same size as the width*height
		if (indexedSprite.getPixels().length != indexedSprite.getHeight() * indexedSprite.getWidth())
		{
			return;
		}

		for (int y = -indexedSprite.getHeight(); y < 0; y++)
		{
			for (int x = -indexedSprite.getWidth(); x < 0; x++)
			{
				int index = indexedSprite.getPixels()[sourceOffset++] & 0xff;
				if (index != 0)
				{
					graphics.setColor(new Color(indexedSprite.getPalette()[index]));//Get color from the pallete
					drawPoint(graphics, startX + x + indexedSprite.getWidth() + indexedSprite.getOffsetX(), startY + y + indexedSprite.getHeight() / 2 + indexedSprite.getOffsetY());
				}
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
		//Normal map pixels have only 1 solid color
		Color c = new Color(sceneTilePaint.getRBG());
		graphics.setColor(c);
		graphics.fillRect(startX, startY, TILE_SIZE, TILE_SIZE);
	}

	private WallShape getWallShape(WallObject wallObject)
	{
		int[][] pixels = ALL;
		WallOffset wallOffset = NONE;

		//Warning: Gower code below
		int flags = wallObject.getConfig() & 255;
		int config1 = flags >> 6 & 3;
		int config2 = flags & 31;

		// Straight walls
		if (config2 == 0)
		{
			switch (config1)
			{
				case 0:
					//draw left wall
					pixels = LEFT;
					wallOffset = NONE;
					break;
				case 1:
					//draw top wall
					pixels = TOP;
					wallOffset = NONE;
					break;
				case 2:
					//draw right wall
					pixels = RIGHT;
					wallOffset = NONE;
					break;
				case 3:
					//draw bottom wall
					pixels = BOTTOM;
					wallOffset = NONE;
					break;

			}
		}
		// Corners
		else if (config2 == 2)
		{
			switch (config1)
			{
				case 0:
					pixels = TOP_LEFT_CORNER;
					break;
				case 1:
					pixels = TOP_RIGHT_CORNER;
					wallOffset = NONE;
					break;
				case 2:
					pixels = BOTTOM_RIGHT_CORNER;
					wallOffset = NONE;
					break;
				case 3:
					pixels = BOTTOM_LEFT_CORNER;
					wallOffset = NONE;
					break;
				default:
					break;
			}
		}
		// Dots
		else if (config2 == 3)
		{
			switch (config1)
			{
				case 0:
					//draw dot top left
					pixels = TOP_LEFT_DOT;
					wallOffset = NONE;
					break;
				case 1:
					//draw dot top right
					pixels = TOP_RIGHT_DOT;
					wallOffset = NONE;
					break;
				case 2:
					//draw dot bottom right
					pixels = BOTTOM_RIGHT_DOT;
					wallOffset = NONE;
					break;
				case 3:
					//draw dot bottom left
					pixels = BOTTOM_LEFT_DOT;
					wallOffset = NONE;
					break;
				default:
					break;
			}
		}
		//This part never gets called, but it's written in the client. ¯\_(ツ)_/¯
		else if (config2 == 9)
		{
			if (config1 != 0 && config1 != 2)
			{
				//draw diagonal \
				pixels = TOP_LEFT_TO_BOTTOM_RIGHT;
				wallOffset = NONE;
			}
			else
			{
				//draw diagonal /
				pixels = BOTTOM_LEFT_TO_TOP_RIGHT;
				wallOffset = NONE;
			}
		}
		//Diagonals
		else if (config2 == 1)
		{
			switch (config1)
			{
				case 0:
					//draw diagonal /
					pixels = BOTTOM_LEFT_TO_TOP_RIGHT;
					wallOffset = TOP_LEFT;
					break;
				case 1:
					//draw diagonal \
					pixels = TOP_LEFT_TO_BOTTOM_RIGHT;
					wallOffset = TOP_RIGHT;
					break;
				case 2:
					pixels = BOTTOM_LEFT_TO_TOP_RIGHT;
					wallOffset = BOTTOM_RIGHT;
					break;
				case 3:
					pixels = TOP_LEFT_TO_BOTTOM_RIGHT;
					wallOffset = BOTTOM_LEFT;
					break;
				default:
					break;
			}
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

		if (wallObject.getHash() == 0)
		{
			return;
		}

		//door
		if (wallObject.getHash() > 0)
		{
			graphics.setColor(Color.red);
		}
		ObjectComposition objectComposition = client.getObjectDefinition(wallObject.getId());

		if (objectComposition.getMapSceneId() != -1)
		{
			return;
		}

		WallShape wallShape = getWallShape(wallObject);
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

		//SceneTileModels have only two colors, and overlay and underlay.
		int overlay = sceneTileModel.getModelOverlay();
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
