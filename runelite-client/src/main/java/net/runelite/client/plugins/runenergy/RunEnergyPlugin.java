/*
 * Copyright (c) 2018, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.runenergy;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Graceful;
import org.apache.commons.lang3.StringUtils;

@PluginDescriptor(
	name = "Run Energy",
	description = "Show various information related to run energy",
	tags = {"overlay", "stamina"}
)
public class RunEnergyPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RunEnergyOverlay energyOverlay;

	@Inject
	private RunEnergyConfig energyConfig;

	private boolean localPlayerRunningToDestination;
	private WorldPoint prevLocalPlayerLocation;

	@Provides
	RunEnergyConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunEnergyConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(energyOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(energyOverlay);
		localPlayerRunningToDestination = false;
		prevLocalPlayerLocation = null;
		resetRunOrbText();
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		localPlayerRunningToDestination =
			prevLocalPlayerLocation != null &&
				client.getLocalDestinationLocation() != null &&
				prevLocalPlayerLocation.distanceTo(client.getLocalPlayer().getWorldLocation()) > 1;

		prevLocalPlayerLocation = client.getLocalPlayer().getWorldLocation();

		if (energyConfig.replaceOrbText())
		{
			setRunOrbText(getEstimatedRunTimeRemaining(true));
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("runenergy") && !energyConfig.replaceOrbText())
		{
			resetRunOrbText();
		}
	}

	private void setRunOrbText(String text)
	{
		Widget runOrbText = client.getWidget(WidgetInfo.MINIMAP_RUN_ORB_TEXT);

		if (runOrbText != null)
		{
			runOrbText.setText(text);
		}
	}

	private void resetRunOrbText()
	{
		setRunOrbText(Integer.toString(client.getEnergy()));
	}

	String getEstimatedRunTimeRemaining(boolean inSeconds)
	{
		// Calculate the amount of energy lost every 2 ticks (0.6 seconds).
		// Negative weight has the same depletion effect as 0 kg.
		final int effectiveWeight = Math.max(client.getWeight(), 0);
		double lossRate = (Math.min(effectiveWeight, 64) / 100.0) + 0.64;

		if (client.getVar(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) != 0)
		{
			lossRate *= 0.3; // Stamina effect reduces energy depletion to 30%
		}

		// Calculate the number of seconds left
		final double secondsLeft = (client.getEnergy() * 0.6) / lossRate;

		// Return the text
		if (inSeconds)
		{
			return Integer.toString((int) Math.floor(secondsLeft)) + "s";
		}
		else
		{
			final int minutes = (int) Math.floor(secondsLeft / 60.0);
			final int seconds = (int) Math.floor(secondsLeft - (minutes * 60.0));

			return Integer.toString(minutes) + ":" + StringUtils.leftPad(Integer.toString(seconds), 2, "0");
		}
	}

	int getEstimatedRecoverTimeRemaining()
	{
		if (localPlayerRunningToDestination)
		{
			return -1;
		}

		// Calculate the amount of energy recovered every second
		double recoverRate = (48 + client.getBoostedSkillLevel(Skill.AGILITY)) / 360.0;

		if (Graceful.hasFullSet(client.getItemContainer(InventoryID.EQUIPMENT)))
		{
			recoverRate *= 1.3; // 30% recover rate increase from Graceful set effect
		}

		// Calculate the number of seconds left
		final double secondsLeft = (100 - client.getEnergy()) / recoverRate;
		return (int) secondsLeft;
	}
}