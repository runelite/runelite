/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.plugins.skybox;

import com.google.inject.Inject;
import java.io.IOException;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Skybox",
	description = "Draws a oldschool styled skybox",
	enabledByDefault = false,
	tags = {"sky"}
)
public class SkyboxPlugin extends Plugin
{
	@Inject
	private Client client;

	private Skybox skybox;

	@Override
	public void startUp() throws IOException
	{
		skybox = new Skybox(SkyboxPlugin.class.getResourceAsStream("skybox.txt"), "skybox.txt");
	}

	@Override
	public void shutDown()
	{
		client.setSkyboxColor(0);
		skybox = null;
	}

	private int mapChunk(int cx, int cy, int plane)
	{
		cx -= client.getBaseX() / 8;
		cy -= client.getBaseY() / 8;

		int[][] instanceTemplateChunks = client.getInstanceTemplateChunks()[plane];
		// Blending can access this out of bounds, so do a range check
		if (cx < 0 || cx >= instanceTemplateChunks.length || cy < 0 || cy >= instanceTemplateChunks[cx].length)
		{
			return -1;
		}

		return instanceTemplateChunks[cx][cy];
	}

	@Subscribe
	public void onBeforeRender(BeforeRender r)
	{
		if (skybox == null || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return;
		}

		int px, py;
		if (client.getOculusOrbState() == 1)
		{
			px = client.getOculusOrbFocalPointX();
			py = client.getOculusOrbFocalPointY();
		}
		else
		{
			LocalPoint p = client.getLocalPlayer().getLocalLocation();
			px = p.getX();
			py = p.getY();
		}

		// Inverse of camera location / 2
		int spx = -((client.getCameraX() - px) >> 1);
		int spy = -((client.getCameraY() - py) >> 1);

		int baseX = client.getBaseX();
		int baseY = client.getBaseY();

		client.setSkyboxColor(skybox.getColorForPoint(
			baseX + ((px + spx) / 128.f),
			baseY + ((py + spy) / 128.f),
			baseX + (px / 128),
			baseY + (py / 128),
			client.getPlane(),
			client.getTextureProvider().getBrightness(),
			client.isInInstancedRegion() ? this::mapChunk : null
		));
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			client.setSkyboxColor(0);
		}
	}
}
