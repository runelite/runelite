/*
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
package net.runelite.client.plugins.corp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.NPC;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
class CorpDamageOverlay extends Overlay
{
	private final Client client;
	private final CorpPlugin corpPlugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private CorpDamageOverlay(final Client client, final CorpPlugin corpPlugin)
	{
		super(corpPlugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.corpPlugin = corpPlugin;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Corp overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget damageWidget = client.getWidget(WidgetID.CORP_DAMAGE, 0);
		if (damageWidget != null)
		{
			damageWidget.setHidden(true);
		}

		NPC corp = corpPlugin.getCorp();
		if (corp == null)
		{
			return null;
		}

		int myDamage = client.getVar(Varbits.CORP_DAMAGE);
		int totalDamage = corpPlugin.getTotalDamage();
		int players = corpPlugin.getPlayers().size();

		// estimate how much damage is required for kill based on number of players
		int damageForKill = players != 0 ? totalDamage / players : 0;

		panelComponent.getChildren().clear();
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		NPC core = corpPlugin.getCore();
		if (core != null)
		{
			WorldPoint corePoint = core.getWorldLocation();
			WorldPoint myPoint = client.getLocalPlayer().getWorldLocation();

			String text = null;

			if (core.getInteracting() == client.getLocalPlayer())
			{
				text = "The core is targeting you!";
			}
			else if (corePoint.distanceTo(myPoint) <= 1)
			{
				text = "Stay away from the core!";
			}

			if (text != null)
			{
				final FontMetrics fontMetrics = graphics.getFontMetrics();
				int textWidth = Math.max(ComponentConstants.STANDARD_WIDTH, fontMetrics.stringWidth(text));

				panelComponent.setPreferredSize(new Dimension(textWidth, 0));
				tableComponent.addRow(ColorUtil.prependColorTag(text, Color.RED), "");
			}
		}

		if (corpPlugin.isShowDamage())
		{
			tableComponent.addRow("Your damage", ColorUtil.prependColorTag(Integer.toString(myDamage), damageForKill > 0 && myDamage >= damageForKill ? Color.GREEN : Color.RED));
			tableComponent.addRow("Total damage:", Integer.toString(totalDamage));
		}

		panelComponent.getChildren().add(tableComponent);
		return panelComponent.render(graphics);
	}
}
