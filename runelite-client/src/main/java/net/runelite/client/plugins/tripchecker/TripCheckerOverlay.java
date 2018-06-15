/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.tripchecker;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Item;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class TripCheckerOverlay extends Overlay
{
	@Inject
	private ItemManager itemManager;

	private final TripCheckerPlugin plugin;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	TripCheckerOverlay(TripCheckerPlugin plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		imagePanelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isMissingItem())
		{
			return null;
		}

		imagePanelComponent.getChildren().clear();
		for (Item missingItem : plugin.getMissingItems())
		{
			imagePanelComponent.getChildren()
				.add(new ImageComponent(getItemImage(missingItem.getId(), missingItem.getQuantity())));
		}

		return imagePanelComponent.render(graphics);
	}

	private BufferedImage getItemImage(int id, int quantity)
	{
		return quantity > 1 ? itemManager.getImage(id, quantity, true)
			: itemManager.getImage(id, quantity, false);
	}
}
