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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.SpritePixels;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.util.WorldMapView;

@Singleton
class InstanceMapOverlay extends Overlay
{
	/**
	 * The size of tiles on the map. The way the client renders requires
	 * this value to be 4. Changing this will break the method for rendering
	 * complex tiles
	 */
	private static final int TILE_SIZE = 4;

	/**
	 * The size of the player's position marker on the map
	 */
	private static final int DOT_SIZE = 4;

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
	private final WorldMapView worldMapView;

	/**
	 * Saved image of the region, no reason to draw the whole thing every
	 * frame.
	 */
	private volatile BufferedImage mapImage;
	private volatile boolean showMap = false;
	private volatile WorldPoint mapLocation;
	private final BackgroundComponent backgroundComponent = new BackgroundComponent();

	@Inject
	private InstanceMapOverlay(final Client client, final WorldMapView worldMapView)
	{
		this.client = client;
		this.worldMapView = worldMapView;
		backgroundComponent.setFill(false);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.TOP_LEFT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
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
		mapLocation = null;
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

	/**
	 * Open the instance map at specified location
	 * @param mapLocation map location
	 */
	public void openAt(final WorldPoint mapLocation)
	{
		if (this.mapLocation != mapLocation)
		{
			setShowMap(mapLocation != null);
			this.mapLocation = mapLocation;
			mapImage = null;

			if (mapLocation != null)
			{
				viewedPlane = mapLocation.getPlane();
			}
		}
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!showMap)
		{
			return null;
		}

		// avoid locking on fast path by creating a local ref
		BufferedImage image = mapImage;

		if (image == null)
		{
			if (mapLocation == null)
			{
				SpritePixels map = client.drawInstanceMap(viewedPlane);
				image = minimapToBufferedImage(map);
			}
			else
			{
				worldMapView.setZoom(1);
				worldMapView.setCenter(new WorldPoint(mapLocation.getX(), mapLocation.getY(), viewedPlane));
				worldMapView.setGraphicsWidth(TILE_SIZE * 104);
				worldMapView.setGraphicsHeight(TILE_SIZE * 104);
				image = worldMapView.buildMapImage();
			}

			synchronized (this)
			{
				if (showMap)
				{
					mapImage = image;
				}
			}
		}

		graphics.drawImage(image, 0, 0, null);
		backgroundComponent.setRectangle(new Rectangle(0, 0, image.getWidth(), image.getHeight()));
		backgroundComponent.render(graphics);

		if (mapLocation != null)
		{
			final Point point = worldMapView.worldPointToGraphicsPoint(mapLocation);
			drawDot(graphics, point.x, point.y, Color.white, Color.black);
		}
		else if (client.getPlane() == viewedPlane) //If we are not viewing the plane we are on, don't show player's position
		{
			drawPlayerDot(graphics, client.getLocalPlayer(), Color.white, Color.black);
		}

		return new Dimension(image.getWidth(), image.getHeight());
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
	 * Draws the players position as a dot on the map.
	 *
	 * @param graphics graphics to be drawn to
	 */
	private void drawPlayerDot(Graphics2D graphics, Player player,
		Color dotColor, Color outlineColor)
	{
		LocalPoint playerLoc = player.getLocalLocation();

		Tile[][] tiles = getTiles();
		int tileX = playerLoc.getRegionX();
		int tileY = (tiles[0].length - 1) - playerLoc.getRegionY(); // flip the y value
		int x = tileX * TILE_SIZE;
		int y = tileY * TILE_SIZE;
		drawDot(graphics, x, y, dotColor, outlineColor);
	}

	private void drawDot(Graphics2D graphics, int x, int y, Color dotColor, Color outlineColor)
	{
		graphics.setColor(dotColor);
		graphics.fillRect(x, y, DOT_SIZE, DOT_SIZE);//draw the point on the map
		graphics.setColor(outlineColor);
		graphics.drawRect(x, y, DOT_SIZE, DOT_SIZE);//outline
	}

	/**
	 * Handles game state changes and re-draws the map
	 *
	 * @param event The game state change event
	 */
	public void onGameStateChange(GameStateChanged event)
	{
		mapImage = null;
	}

	private static BufferedImage minimapToBufferedImage(SpritePixels spritePixels)
	{
		int width = spritePixels.getWidth();
		int height = spritePixels.getHeight();
		int[] pixels = spritePixels.getPixels();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		img.setRGB(0, 0, width, height, pixels, 0, width);
		// 24624 / 512 and 24624 % 512 are both 48
		img = img.getSubimage(48, 48, TILE_SIZE * 104, TILE_SIZE * 104);
		return img;
	}
}
