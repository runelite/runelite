/*
 * Copyright (c) 2018, terminatusx <jbfleischman@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.wintertodt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import static net.runelite.client.plugins.wintertodt.WintertodtPlugin.WINTERTODT_KINDLING_MULTIPLIER;
import static net.runelite.client.plugins.wintertodt.WintertodtPlugin.WINTERTODT_ROOTS_MULTIPLIER;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
class WintertodtOverlay extends Overlay
{
	@Inject
	private Client client;

	private final WintertodtPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private WintertodtOverlay(final WintertodtPlugin plugin)
	{
		super(plugin);
		this.plugin = plugin;
		setPosition(OverlayPosition.BOTTOM_LEFT);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Wintertodt overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInWintertodt())
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.setPreferredSize(new Dimension(180, 0));

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Points in inventory")
			.color(Color.WHITE)
			.build());

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		tableComponent.addRow(ColorUtil.prependColorTag("Status:", Color.WHITE), ColorUtil.prependColorTag(plugin.getCurrentActivity().getActionString(), plugin.getCurrentActivity() == WintertodtActivity.IDLE ? Color.RED : Color.GREEN));

		int firemakingLvl = client.getRealSkillLevel(Skill.FIREMAKING);

		int rootsScore = plugin.getNumRoots() * WINTERTODT_ROOTS_MULTIPLIER;
		int rootsXp = plugin.getNumRoots() * Math.round(2 + (3 * firemakingLvl));

		tableComponent.addRow(ColorUtil.prependColorTag("Roots:", Color.WHITE), ColorUtil.prependColorTag(rootsScore + " pts (" + rootsXp + " xp)", plugin.getNumRoots() > 0 ? Color.GREEN : Color.RED));

		int kindlingScore = plugin.getNumKindling() * WINTERTODT_KINDLING_MULTIPLIER;
		long kindlingXp = plugin.getNumKindling() * Math.round(3.8 * firemakingLvl);

		tableComponent.addRow(ColorUtil.prependColorTag("Kindling:", Color.WHITE), ColorUtil.prependColorTag(kindlingScore + " pts (" + kindlingXp + " xp)", plugin.getNumKindling() > 0 ? Color.GREEN : Color.RED));
		tableComponent.addRow(ColorUtil.prependColorTag("Total:", Color.WHITE), ColorUtil.prependColorTag((rootsScore + kindlingScore) + " pts (" + (rootsXp + kindlingXp) + " xp)", (rootsScore + kindlingScore > 0) ? Color.GREEN : Color.RED));

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}