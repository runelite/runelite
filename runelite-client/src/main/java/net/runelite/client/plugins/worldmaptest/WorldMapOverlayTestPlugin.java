/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.worldmaptest;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "WorldMapOverlayTest",
	developerPlugin = true,
	enabledByDefault = false
)
public class WorldMapOverlayTestPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	private BufferedImage markerImage;

	private WorldMapPoint playerDot;

	@Override
	protected void startUp() throws Exception
	{
		markerImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		Graphics markGraphics = markerImage.getGraphics();
		markGraphics.setColor(Color.ORANGE);
		markGraphics.fillOval(0, 0, 10, 10);

		BufferedImage playerImage = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);
		playerImage.getGraphics().setColor(Color.WHITE);
		playerImage.getGraphics().fillRect(0, 0, 5, 5);
		playerDot = new WorldMapPoint(null, playerImage);

		worldMapPointManager.add(playerDot);
	}

	@Override
	protected void shutDown() throws Exception
	{
		worldMapPointManager.remove(playerDot);
	}

	@Subscribe
	void onTick(GameTick tick)
	{
		WorldPoint wp = client.getLocalPlayer().getWorldLocation();
		playerDot.setWorldPoint(new WorldPoint(wp.getX(), wp.getY(), 0));
	}

	@Subscribe
	public void onCommand(CommandExecuted commandExecuted)
	{
		String[] args = commandExecuted.getArguments();

		if (commandExecuted.getCommand().equals("mappos"))
		{
			if (args.length >= 2)
			{
				int x = Integer.parseInt(args[0]);
				int y = Integer.parseInt(args[1]);

				WorldPoint worldPoint = new WorldPoint(x, y, 0);
				WorldMapPoint marker = new WorldMapPoint(worldPoint, markerImage);
				worldMapPointManager.add(marker);
				client.getRenderOverview().setWorldMapPositionTarget(worldPoint);
				if (args.length >= 3)
				{
					marker.setTooltip(args[2]);
				}
			}
			WorldPoint wp = client.getLocalPlayer().getWorldLocation();
			Point mapPoint = client.getRenderOverview().getWorldMapPosition();
			int diffX = mapPoint.getX() - wp.getX();
			int diffY = mapPoint.getY() - wp.getY();
			client.addChatMessage(ChatMessageType.SERVER, "", "Coordinate Difference:" + diffX + ", " + diffY, null);
			client.addChatMessage(ChatMessageType.SERVER, "", "Current Map Coordinates:" + mapPoint.getX() + ", " + mapPoint.getY(), null);
		}
	}
}
