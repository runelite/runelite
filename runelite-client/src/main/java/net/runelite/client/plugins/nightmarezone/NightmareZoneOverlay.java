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
import net.runelite.api.ItemID;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.StackFormatter;

class NightmareZoneOverlay extends Overlay
{
	private final Client client;
	private final NightmareZoneConfig config;
	private final NightmareZonePlugin plugin;
	private final InfoBoxManager infoBoxManager;
	private final ItemManager itemManager;

	private AbsorptionCounter absorptionCounter;
	private final PanelComponent panelComponent = new PanelComponent();

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
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		this.infoBoxManager = infoBoxManager;
		this.itemManager = itemManager;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "NMZ overlay"));
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
				Widget nmzWidget = client.getWidget(WidgetInfo.NIGHTMARE_ZONE);
				if (nmzWidget != null)
				{
					nmzWidget.setHidden(false);
				}
			}
			return null;
		}

		Widget nmzWidget = client.getWidget(WidgetInfo.NIGHTMARE_ZONE);

		if (nmzWidget != null)
		{
			nmzWidget.setHidden(true);
		}

		renderAbsorptionCounter();

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Points: ")
			.right(StackFormatter.formatNumber(client.getVar(Varbits.NMZ_POINTS)))
			.build());

		return panelComponent.render(graphics);
	}

	private void renderAbsorptionCounter()
	{
		int absorptionPoints = client.getVar(Varbits.NMZ_ABSORPTION);
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
				absorptionCounter.setAbsorption(absorptionPoints);
			}
		}
	}

	private void addAbsorptionCounter(int startValue)
	{
		absorptionCounter = new AbsorptionCounter(itemManager.getImage(ItemID.ABSORPTION_4), plugin, startValue, config.absorptionThreshold());
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
