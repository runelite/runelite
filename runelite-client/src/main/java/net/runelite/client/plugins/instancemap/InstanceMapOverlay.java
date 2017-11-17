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
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Tile;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

class InstanceMapOverlay extends Overlay
{
	/**
	 * Size of the drawn tile in the instance map.
	 */
	private static final int tileSize = 3;

	private final Client client;
	private final InstanceMapConfig config;

	private boolean showMap = false;

	@Inject
	InstanceMapOverlay(@Nullable Client client,
		InstanceMapConfig config)
	{
		super(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
	}

	public boolean isMapShown()
	{
		return showMap;
	}

	public void setShowMap(boolean show)
	{
		showMap = show;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled() || !showMap)
		{
			return null;
		}

		return drawInstanceMap(graphics);
	}

	/**
	 * Draws all the tiles on the current plane of client.reigion to the
	 * screen. This will show instances unlike the world map.
	 *
	 * @param graphics graphics to draw to
	 * @return The dimensions of the map
	 */
	private Dimension drawInstanceMap(Graphics2D graphics)
	{
		Tile[][][] regionTiles = client.getRegion().getTiles();

		int plane = client.getPlane();
		Tile[][] tiles = regionTiles[plane];

		Dimension mapOverlaySize = new Dimension(tiles.length * tileSize, tiles[0].length * tileSize);

		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, mapOverlaySize.width, mapOverlaySize.height);

		for (int x = 0; x < tiles.length; x++)
		{
			for (int y = 0; y < tiles[x].length; y++)
			{
				Tile curTile = tiles[x][(tiles[x].length - 1) - y]; // flip the y value
				if (curTile != null && curTile.getSceneTilePaint() != null)
				{
					graphics.setColor(new Color(curTile.getSceneTilePaint().getRBG()));
					graphics.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
				}
			}
		}

		return mapOverlaySize;
	}
}
