/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.runecraft;

import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class EssencePouchOverlay extends WidgetItemOverlay
{
	private final RunecraftPlugin plugin;
	private final RunecraftConfig config;

	@Inject
	EssencePouchOverlay(RunecraftPlugin plugin, RunecraftConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		showOnInventory();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (!config.showPouch())
		{
			return;
		}

		final Pouch pouch = plugin.getPouches().get(RunecraftPlugin.getPouchID(itemId));
		if (pouch == null)
		{
			return;
		}

		final Rectangle bounds = itemWidget.getCanvasBounds();
		final TextComponent textComponent = new TextComponent();
		textComponent.setPosition(new Point(bounds.x - 1, bounds.y + 8));
		textComponent.setColor(Color.CYAN);
		if (pouch.getHolding() == 15)
		{
			textComponent.setText("?");
		}
		else
		{
			textComponent.setText(pouch.getHolding() + (pouch.isDegraded() ? "?" : ""));
		}
		textComponent.render(graphics);
	}
}
