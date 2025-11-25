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
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;

class BlastMineOreCountOverlay extends OverlayPanel
{
	private final Client client;
	private final BlastMinePluginConfig config;
	private final ItemManager itemManager;

	@Inject
	private BlastMineOreCountOverlay(BlastMinePlugin plugin, Client client, BlastMinePluginConfig config, ItemManager itemManager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.itemManager = itemManager;
		panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Blast mine overlay");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget blastMineWidget = client.getWidget(InterfaceID.LovakengjBlastMiningHud.DATA);

		if (blastMineWidget == null)
		{
			return null;
		}

		if (config.showOreOverlay())
		{
			blastMineWidget.setHidden(true);
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.COAL, client.getVarbitValue(VarbitID.LOVAKENGJ_ORE_COAL_BIGGER))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.GOLD_ORE, client.getVarbitValue(VarbitID.LOVAKENGJ_ORE_GOLD_BIGGER))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.MITHRIL_ORE, client.getVarbitValue(VarbitID.LOVAKENGJ_ORE_MITHRIL_BIGGER))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.ADAMANTITE_ORE, client.getVarbitValue(VarbitID.LOVAKENGJ_ORE_ADAMANTITE_BIGGER))));
			panelComponent.getChildren().add(new ImageComponent(getImage(ItemID.RUNITE_ORE, client.getVarbitValue(VarbitID.LOVAKENGJ_ORE_RUNITE_BIGGER))));
		}
		else
		{
			blastMineWidget.setHidden(false);
		}

		return super.render(graphics);
	}

	private BufferedImage getImage(int itemID, int amount)
	{
		return itemManager.getImage(itemID, amount, true);
	}
}
