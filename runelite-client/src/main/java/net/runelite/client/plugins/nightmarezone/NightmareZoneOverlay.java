/*
 * Copyright (c) 2018, Nickolaj <https://github.com/fire-proof>
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
package net.runelite.client.plugins.nightmarezone;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QuantityFormatter;

class NightmareZoneOverlay extends OverlayPanel
{
	private final Client client;
	private final NightmareZoneConfig config;
	private final NightmareZonePlugin plugin;
	private final InfoBoxManager infoBoxManager;
	private final ItemManager itemManager;

	private AbsorptionCounter absorptionCounter;

	@Inject
	NightmareZoneOverlay(
			Client client,
			NightmareZoneConfig config,
			NightmareZonePlugin plugin,
			InfoBoxManager infoBoxManager,
			ItemManager itemManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(PRIORITY_LOW);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.infoBoxManager = infoBoxManager;
		this.itemManager = itemManager;
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "NMZ overlay");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInNightmareZone() || !config.moveOverlay())
		{
			if (absorptionCounter != null)
			{
				removeAbsorptionCounter();
				// Restore original widget
				Widget nmzWidget = client.getWidget(InterfaceID.NzoneGame.UNIVERSE);
				if (nmzWidget != null)
				{
					nmzWidget.setHidden(false);
				}
			}
			return null;
		}

		renderAbsorptionCounter();

		final int currentPoints = client.getVarbitValue(VarbitID.NZONE_CURRENTPOINTS);
		final int totalPoints = currentPoints + client.getVarpValue(VarPlayerID.NZONE_REWARDPOINTS);

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Points: ")
			.right(QuantityFormatter.formatNumber(currentPoints))
			.build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Points/Hr: ")
			.right(QuantityFormatter.formatNumber(plugin.getPointsPerHour()))
			.build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Total: ")
			.right(QuantityFormatter.formatNumber(totalPoints))
			.build());

		return super.render(graphics);
	}

	private void renderAbsorptionCounter()
	{
		int absorptionPoints = client.getVarbitValue(VarbitID.NZONE_ABSORB_POTION_EFFECTS);
		if (absorptionPoints == 0)
		{
			if (absorptionCounter != null)
			{
				removeAbsorptionCounter();
				absorptionCounter = null;
			}
		}
		else if (config.moveOverlay())
		{
			if (absorptionCounter == null)
			{
				addAbsorptionCounter(absorptionPoints);
			}
			else
			{
				absorptionCounter.setCount(absorptionPoints);
			}
		}
	}

	private void addAbsorptionCounter(int startValue)
	{
		absorptionCounter = new AbsorptionCounter(itemManager.getImage(ItemID.NZONE4DOSEABSORPTIONPOTION), plugin, startValue, config.absorptionThreshold());
		absorptionCounter.setAboveThresholdColor(config.absorptionColorAboveThreshold());
		absorptionCounter.setBelowThresholdColor(config.absorptionColorBelowThreshold());
		infoBoxManager.addInfoBox(absorptionCounter);
	}

	public void removeAbsorptionCounter()
	{
		infoBoxManager.removeInfoBox(absorptionCounter);
		absorptionCounter = null;
	}

	public void updateConfig()
	{
		if (absorptionCounter != null)
		{
			absorptionCounter.setAboveThresholdColor(config.absorptionColorAboveThreshold());
			absorptionCounter.setBelowThresholdColor(config.absorptionColorBelowThreshold());
			absorptionCounter.setThreshold(config.absorptionThreshold());
		}
	}
}
