/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class WidgetInspectorOverlay extends Overlay
{
	private final Client client;
	private final WidgetInspector inspector;

	@Inject
	public WidgetInspectorOverlay(
		Client client,
		WidgetInspector inspector
	)
	{
		this.client = client;
		this.inspector = inspector;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);
		drawAfterInterface(WidgetID.FULLSCREEN_CONTAINER_TLI);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		{
			Widget w = inspector.getSelectedWidget();
			if (w != null)
			{
				renderWidget(g, w, WidgetInspector.SELECTED_WIDGET_COLOR);
			}
		}

		if (inspector.isPickerSelected())
		{
			boolean menuOpen = client.isMenuOpen();

			MenuEntry[] entries = client.getMenuEntries();
			for (int i = menuOpen ? 0 : entries.length - 1; i < entries.length; i++)
			{
				MenuEntry e = entries[i];

				Widget w = inspector.getWidgetForMenuOption(e.getType(), e.getParam0(), e.getParam1());
				if (w == null)
				{
					continue;
				}

				Color color = inspector.colorForWidget(i, entries.length);
				renderWidget(g, w, color);
			}
		}

		return null;
	}

	private void renderWidget(Graphics2D g, Widget w, Color color)
	{
		g.setColor(color);
		g.draw(w.getBounds());
	}
}
