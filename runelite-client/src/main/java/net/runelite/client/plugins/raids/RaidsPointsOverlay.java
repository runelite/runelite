/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.NumberFormat;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Varbits;
import static net.runelite.client.plugins.raids.RaidsPlugin.POINTS_FORMAT;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
public class RaidsPointsOverlay extends Overlay
{
	private static final NumberFormat UNIQUE_FORMAT = NumberFormat.getPercentInstance(Locale.ENGLISH);

	static
	{
		UNIQUE_FORMAT.setMaximumFractionDigits(2);
		UNIQUE_FORMAT.setMinimumFractionDigits(2);
	}

	private final PanelComponent panel = new PanelComponent();
	@Inject
	private Client client;
	@Inject
	private RaidsPlugin plugin;

	@Inject
	private RaidsPointsOverlay(final RaidsPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.HIGH);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Raids overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInRaidChambers())
		{
			return null;
		}

		int totalPoints = client.getVar(Varbits.TOTAL_POINTS);
		int personalPoints = client.getVar(Varbits.PERSONAL_POINTS);
		int partySize = client.getVar(Varbits.RAID_PARTY_SIZE);
		double uniqueChance = totalPoints / 867500f;

		panel.getChildren().clear();
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		tableComponent.addRow("Total:", POINTS_FORMAT.format(totalPoints));
		tableComponent.addRow(client.getLocalPlayer().getName() + ":", POINTS_FORMAT.format(personalPoints));


		if (partySize > 1)
		{
			tableComponent.addRow("Party size:", String.valueOf(partySize));
		}

		tableComponent.addRow("Unique:", UNIQUE_FORMAT.format(uniqueChance));

		panel.getChildren().add(tableComponent);

		return panel.render(graphics);
	}
}