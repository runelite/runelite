/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.common.base.Strings;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@Singleton
public class InfoBoxOverlay extends Overlay
{
	private final PanelComponent panelComponent = new PanelComponent();
	private final InfoBoxManager infoboxManager;
	private final TooltipManager tooltipManager;
	private final Client client;
	private final RuneLiteConfig config;

	@Inject
	private InfoBoxOverlay(
		InfoBoxManager infoboxManager,
		TooltipManager tooltipManager,
		Client client,
		RuneLiteConfig config)
	{
		this.tooltipManager = tooltipManager;
		this.infoboxManager = infoboxManager;
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.TOP_LEFT);

		panelComponent.setBackgroundColor(null);
		panelComponent.setBorder(new Rectangle());
		panelComponent.setGap(new Point(1, 1));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<InfoBox> infoBoxes = infoboxManager.getInfoBoxes();

		if (infoBoxes.isEmpty())
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.setWrapping(config.infoBoxWrap());
		panelComponent.setOrientation(config.infoBoxVertical()
			? PanelComponent.Orientation.VERTICAL
			: PanelComponent.Orientation.HORIZONTAL);
		panelComponent.setPreferredSize(new Dimension(config.infoBoxSize(), config.infoBoxSize()));

		for (InfoBox box : infoBoxes)
		{
			if (!box.render())
			{
				continue;
			}

			final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
			infoBoxComponent.setColor(box.getTextColor());
			infoBoxComponent.setImage(box.getScaledImage());
			infoBoxComponent.setText(box.getText());
			infoBoxComponent.setTooltip(box.getTooltip());
			panelComponent.getChildren().add(infoBoxComponent);
		}

		final Dimension dimension = panelComponent.render(graphics);

		// Handle tooltips
		final Point mouse = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());

		for (final LayoutableRenderableEntity child : panelComponent.getChildren())
		{
			if (child instanceof InfoBoxComponent)
			{
				final InfoBoxComponent component = (InfoBoxComponent) child;

				if (!Strings.isNullOrEmpty(component.getTooltip()))
				{
					final Rectangle intersectionRectangle = new Rectangle(component.getPreferredLocation(), component.getPreferredSize());

					// Move the intersection based on overlay position
					intersectionRectangle.translate(getBounds().x, getBounds().y);

					// Move the intersection based on overlay "orientation"
					final Point transformed = OverlayUtil.transformPosition(getPosition(), intersectionRectangle.getSize());
					intersectionRectangle.translate(transformed.x, transformed.y);

					if (intersectionRectangle.contains(mouse))
					{
						tooltipManager.add(new Tooltip(component.getTooltip()));
					}
				}
			}
		}

		return dimension;
	}
}
