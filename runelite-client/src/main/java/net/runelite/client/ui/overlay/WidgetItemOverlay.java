/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.widgets.WidgetItem;

public abstract class WidgetItemOverlay extends Overlay
{
	@Setter(AccessLevel.PACKAGE)
	private OverlayManager overlayManager;

	protected WidgetItemOverlay()
	{
		super.setPosition(OverlayPosition.DYNAMIC);
		super.setPriority(OverlayPriority.LOW);
		super.setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	public abstract void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget);

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<WidgetItem> itemWidgets = overlayManager.getItemWidgets();
		for (WidgetItem widget : itemWidgets)
		{
			renderItemOverlay(graphics, widget.getId(), widget);
		}
		return null;
	}

	// Don't allow setting position, priority, or layer

	@Override
	public void setPosition(OverlayPosition position)
	{
		throw new IllegalStateException();
	}

	@Override
	public void setPriority(OverlayPriority priority)
	{
		throw new IllegalStateException();
	}

	@Override
	public void setLayer(OverlayLayer layer)
	{
		throw new IllegalStateException();
	}
}
