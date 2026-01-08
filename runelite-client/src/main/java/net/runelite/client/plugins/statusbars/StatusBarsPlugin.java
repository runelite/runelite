/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.statusbars;

import javax.inject.Inject;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.itemstats.ItemStatPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Status Bars",
	description = "Draws status bars next to players inventory showing current HP & Prayer and healing amounts",
	enabledByDefault = false
)
@PluginDependency(ItemStatPlugin.class)
public class StatusBarsPlugin extends Plugin
{
	@Inject
	private StatusBarsOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private StatusBarsConfig config;

	@Inject
	private ClientThread clientThread;

	@Getter(AccessLevel.PACKAGE)
	private boolean barsDisplayed;

	private int lastCombatActionTickCount;

	@Override
	protected void startUp() throws Exception
	{
		clientThread.invokeLater(this::checkStatusBars);
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		barsDisplayed = false;
	}

	@Provides
	StatusBarsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StatusBarsConfig.class);
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		checkStatusBars();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (StatusBarsConfig.GROUP.equals(event.getGroup()) && event.getKey().equals("hideAfterCombatDelay"))
		{
			clientThread.invokeLater(this::checkStatusBars);
		}
	}

	private void checkStatusBars()
	{
		final Player localPlayer = client.getLocalPlayer();
		if (localPlayer == null)
		{
			return;
		}

		final Actor interacting = localPlayer.getInteracting();

		if (config.hideAfterCombatDelay() == 0)
		{
			barsDisplayed = true;
		}
		else if ((interacting instanceof NPC && ArrayUtils.contains(((NPC) interacting).getComposition().getActions(), "Attack"))
			|| (interacting instanceof Player && client.getVarbitValue(VarbitID.PVP_AREA_CLIENT) == 1))
		{
			lastCombatActionTickCount = client.getTickCount();
			barsDisplayed = true;
		}
		else if (client.getTickCount() - lastCombatActionTickCount >= config.hideAfterCombatDelay())
		{
			barsDisplayed = false;
		}
	}
}
