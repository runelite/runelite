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

import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImagePanelComponent;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

class BlastMineOreCountOverlay extends Overlay
{
	private final static int COAL = ItemID.COAL;
	private final static int GOLD_ORE = ItemID.GOLD_ORE;
	private final static int MITHRIL_ORE = ItemID.MITHRIL_ORE;
	private final static int ADAMANTITE_ORE = ItemID.ADAMANTITE_ORE;
	private final static int RUNITE_ORE = ItemID.RUNITE_ORE;

	private final Client client;
	private final BlastMinePluginConfig config;
	private final ImagePanelComponent imagePanelComponent = new ImagePanelComponent();
	private final ItemManager itemManager;

	@Inject
	BlastMineOreCountOverlay(Client client, BlastMinePluginConfig config, ItemManager itemManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE);

		imagePanelComponent.getImages().clear();
		imagePanelComponent.setTitle("");

		if (blastMineWidget != null)
		{
			blastMineWidget.setHidden(true);
			if (config.showOreOverlay())
			{
				imagePanelComponent.getImages().add(getImage(COAL, client.getVar(Varbits.BLAST_MINE_COAL)));
				imagePanelComponent.getImages().add(getImage(GOLD_ORE, client.getVar(Varbits.BLAST_MINE_GOLD)));
				imagePanelComponent.getImages().add(getImage(MITHRIL_ORE, client.getVar(Varbits.BLAST_MINE_MITHRIL)));
				imagePanelComponent.getImages().add(getImage(ADAMANTITE_ORE, client.getVar(Varbits.BLAST_MINE_ADAMANTITE)));
				imagePanelComponent.getImages().add(getImage(RUNITE_ORE, client.getVar(Varbits.BLAST_MINE_RUNITE)));
			}
		}

		if (imagePanelComponent.getImages().size() > 0)
		{
			return imagePanelComponent.render(graphics);
		}

		return null;

	}

	private BufferedImage getImage(int itemID, int amount)
	{
		return itemManager.getImage(itemID, amount, true);
	}
}
