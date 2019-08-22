/*
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public abstract class InfoBox extends Overlay
{
	@Getter
	@Setter
	private BufferedImage image;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private BufferedImage scaledImage;

	// TODO take this option into account again, currently it's ignored
	@Getter(AccessLevel.PACKAGE)
	@Setter
	private InfoBoxPriority infoBoxPriority;

	@Getter
	@Setter
	private String tooltip;

	@Setter
	private TooltipManager tooltipManager;

	@Setter
	private Client client;

	@Setter
	private RuneLiteConfig config;


	public InfoBox(BufferedImage image, Plugin plugin)
	{
		super(plugin);

		setImage(image);
		setInfoBoxPriority(InfoBoxPriority.NONE);

		setPosition(OverlayPosition.TOP_LEFT);
	}

	public abstract String getText();

	public abstract Color getTextColor();

	public boolean render()
	{
		return true;
	}

	public boolean cull()
	{
		return false;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!render())
		{
			return null;
		}

		final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
		infoBoxComponent.setText(getText());
		if (getTextColor() != null)
		{
			infoBoxComponent.setColor(getTextColor());
		}
		infoBoxComponent.setImage(getScaledImage());
		infoBoxComponent.setTooltip(getTooltip());

		// Create infobox preferred size
		final Dimension preferredSize = new Dimension(config.infoBoxSize(), config.infoBoxSize());

		// Render
		infoBoxComponent.setPreferredLocation(new Point());
		infoBoxComponent.setPreferredSize(preferredSize);
		final Dimension dimension = infoBoxComponent.render(graphics);


		// Handle tooltips
		final Point mouse = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());

		if (!Strings.isNullOrEmpty(infoBoxComponent.getTooltip()))
		{
			// Create intersection rectangle
			final Rectangle intersectionRectangle = new Rectangle(infoBoxComponent.getBounds());
			intersectionRectangle.translate(getBounds().x, getBounds().y);

			if (intersectionRectangle.contains(mouse))
			{
				tooltipManager.add(new Tooltip(infoBoxComponent.getTooltip()));
			}
		}

		return dimension;
	}

	@Override
	public String getName()
	{
		return "InfoBox_" + super.getName();
	}
}
