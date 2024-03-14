/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CHUNK_SIZE;
import static net.runelite.api.Constants.SCENE_SIZE;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

public class LocationOverlay extends OverlayPanel
{
	private final Client client;
	private final DevToolsPlugin plugin;

	@Inject
	LocationOverlay(Client client, DevToolsPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getLocation().isActive())
		{
			return null;
		}

		WorldPoint worldPoint = client.getLocalPlayer().getWorldLocation();
		LocalPoint localPoint = client.getLocalPlayer().getLocalLocation();

		if (client.isInInstancedRegion())
		{
			worldPoint = WorldPoint.fromLocalInstance(client, localPoint);

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Instance")
				.build());
		}

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Local")
			.right(localPoint.getX() + ", " + localPoint.getY())
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("World")
			.right(worldPoint.getX() + ", " + worldPoint.getY() + ", " + client.getPlane())
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Scene")
			.right(localPoint.getSceneX() + ", " + localPoint.getSceneY())
			.build());

		if (client.isInInstancedRegion())
		{
			int[][][] instanceTemplateChunks = client.getInstanceTemplateChunks();
			int z = client.getPlane();
			for (int cy = 0; cy < SCENE_SIZE / CHUNK_SIZE; ++cy)
			{
				for (int cx = 0; cx < SCENE_SIZE / CHUNK_SIZE; ++cx)
				{
					int chunkData = instanceTemplateChunks[z][cx][cy];

					if (chunkData == -1)
					{
						continue;
					}

					int rotation = chunkData >> 1 & 0x3; // NOPMD
					int chunkY = (chunkData >> 3 & 0x7FF);
					int chunkX = (chunkData >> 14 & 0x3FF);
					int chunkPlane = chunkData >> 24 & 0x3;

					boolean myChunk = cx == localPoint.getSceneX() / CHUNK_SIZE && cy == localPoint.getSceneY() / CHUNK_SIZE;
					panelComponent.getChildren().add(LineComponent.builder()
						.left("Chunk")
						.right(chunkX + ", " + chunkY + ", " + chunkPlane)
						.rightColor(myChunk ? Color.GREEN : Color.WHITE)
						.build());
				}
			}
		}
		else
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Base")
				.right(client.getBaseX() + ", " + client.getBaseY())
				.build());
		}

		for (int i = 0; i < client.getMapRegions().length; i++)
		{
			int region = client.getMapRegions()[i];
			int mx = region >> 8;
			int my = region & 0xff;

			panelComponent.getChildren().add(LineComponent.builder()
				.left((i == 0) ? "Map regions" : " ")
				.right(mx + ", " + my)
				.rightColor((region == worldPoint.getRegionID()) ? Color.GREEN : Color.WHITE)
				.build());
		}

		return super.render(graphics);
	}
}
