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
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QuantityFormatter;

@Singleton
class NightmareZoneOverlay extends Overlay
{
	private final Client client;
	private final NightmareZonePlugin plugin;
	private final InfoBoxManager infoBoxManager;
	private final ItemManager itemManager;

	private AbsorptionCounter absorptionCounter;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	NightmareZoneOverlay(
		final Client client,
		final NightmareZonePlugin plugin,
		final InfoBoxManager infoBoxManager,
		final ItemManager itemManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.infoBoxManager = infoBoxManager;
		this.itemManager = itemManager;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "NMZ overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isNotInNightmareZone() || !plugin.isMoveOverlay())
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

		final int currentPoints = client.getVar(Varbits.NMZ_POINTS);
		final int totalPoints = currentPoints + client.getVar(VarPlayer.NMZ_REWARD_POINTS);

		panelComponent.getChildren().clear();

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
		tableComponent.addRow("Points:", QuantityFormatter.formatNumber(currentPoints));
		tableComponent.addRow("Points/Hour:", QuantityFormatter.formatNumber(plugin.getPointsPerHour()));
		
		if (plugin.isShowtotalpoints())
		{
			tableComponent.addRow("Total:", QuantityFormatter.formatNumber(totalPoints));
		}
		
		panelComponent.getChildren().add(tableComponent);

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
		else if (plugin.isMoveOverlay())
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
		absorptionCounter = new AbsorptionCounter(itemManager.getImage(ItemID.ABSORPTION_4), plugin, startValue, plugin.getAbsorptionThreshold());
		absorptionCounter.setAboveThresholdColor(plugin.getAbsorptionColorAboveThreshold());
		absorptionCounter.setBelowThresholdColor(plugin.getAbsorptionColorBelowThreshold());
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
			absorptionCounter.setAboveThresholdColor(plugin.getAbsorptionColorAboveThreshold());
			absorptionCounter.setBelowThresholdColor(plugin.getAbsorptionColorBelowThreshold());
			absorptionCounter.setThreshold(plugin.getAbsorptionThreshold());
		}
	}
}
