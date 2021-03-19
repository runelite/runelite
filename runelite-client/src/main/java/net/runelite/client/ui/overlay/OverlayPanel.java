/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
@Setter
public abstract class OverlayPanel extends Overlay
{
	protected final PanelComponent panelComponent = new PanelComponent();

	/**
	 * Enables/disables automatic clearing of {@link OverlayPanel#getPanelComponent()} children after rendering (enabled by default)
	 */
	private boolean clearChildren = true;

	/**
	 * Enables/disables automatic font size changes based on panel component size relative to default panel component size.
	 */
	private boolean dynamicFont = false;

	/**
	 * Preferred color used for panel component background
	 */
	private Color preferredColor = null;

	protected OverlayPanel()
	{
		super();
		setResizable(true);
	}

	protected OverlayPanel(Plugin plugin)
	{
		super(plugin);
		setResizable(true);
	}

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		final Dimension oldSize = panelComponent.getPreferredSize();

		if (getPreferredSize() != null)
		{
			panelComponent.setPreferredSize(getPreferredSize());

			if (dynamicFont)
			{
				if (getPreferredSize().width >= ComponentConstants.STANDARD_WIDTH * 1.3)
				{
					graphics.setFont(FontManager.getRunescapeBoldFont());
				}
				else if (getPreferredSize().width <= ComponentConstants.STANDARD_WIDTH * 0.8)
				{
					graphics.setFont(FontManager.getRunescapeSmallFont());
				}
			}
		}

		final Color oldBackgroundColor = panelComponent.getBackgroundColor();

		if (getPreferredColor() != null && ComponentConstants.STANDARD_BACKGROUND_COLOR.equals(oldBackgroundColor))
		{
			panelComponent.setBackgroundColor(getPreferredColor());
		}

		final Dimension dimension = panelComponent.render(graphics);

		if (clearChildren)
		{
			panelComponent.getChildren().clear();
		}

		panelComponent.setPreferredSize(oldSize);
		panelComponent.setBackgroundColor(oldBackgroundColor);
		return dimension;
	}
}
