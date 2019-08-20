/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.blastmine;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
class BlastMineOreCountOverlay extends Overlay
{
	private final Client client;
	private final BlastMinePlugin plugin;
	private final ItemManager itemManager;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private BlastMineOreCountOverlay(final BlastMinePlugin plugin, final Client client, final ItemManager itemManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
		panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Blast mine overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE);

		if (blastMineWidget == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		if (plugin.isShowOreOverlay())
		{
			blastMineWidget.setHidden(true);
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.COAL, client.getVar(Varbits.BLAST_MINE_COAL))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.GOLD_ORE, client.getVar(Varbits.BLAST_MINE_GOLD))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.MITHRIL_ORE, client.getVar(Varbits.BLAST_MINE_MITHRIL))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.ADAMANTITE_ORE, client.getVar(Varbits.BLAST_MINE_ADAMANTITE))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.RUNITE_ORE, client.getVar(Varbits.BLAST_MINE_RUNITE))));
		}
		else
		{
			blastMineWidget.setHidden(false);
		}

		return panelComponent.render(graphics);
	}

	private BufferedImage getImage(int itemID, int amount)
	{
		return itemManager.getImage(itemID, amount, true);
	}
}
