/*
 * Copyright (c) 2019, Jacky <https://github.com/jkybtw>
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
package net.runelite.client.plugins.cox;

import com.google.inject.Provides;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Projectile;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Cox",
	description = "COX Helper",
	tags = {"combat", "overlay", "pve", "pvm"}
)
public class CoxPlugin extends Plugin
{
	@Getter
	private NPC olm = null;

	@Getter
	private int attackStyle = 0; // 0 - mage // 1 - range

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CoxOverlay coxOverlay;

	@Inject CoxOverlayAbove coxOverlayAbove;

	@Inject
	private CoxConfig config;


	@Provides
	CoxConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoxConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(coxOverlay);
		overlayManager.add(coxOverlayAbove);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(coxOverlay);
		overlayManager.remove(coxOverlayAbove);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!client.isInInstancedRegion())
		{
			olm = null;
			return;
		}

		if (client.getPlane() != 0) return;

		List<NPC> npcs = client.getNpcs();

		for (NPC npc : npcs)
		{
			if (npc.getId() == 7554)
			{
				olm = npc;
			}
		}

		if (olm == null) return;

		List<Projectile> projectiles = client.getProjectiles();

		for (Projectile projectile : projectiles)
		{
			if (projectile.getId() == 1339)
			{
				// mage
				attackStyle = 0;
			}

			if (projectile.getId() == 1340)
			{
				// range
				attackStyle = 1;
			}
		}
	}
}
