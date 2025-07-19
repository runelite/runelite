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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.InfoBoxMenuClicked;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

@Slf4j
public class InfoBoxOverlay extends OverlayPanel
{
	private static final int GAP = 1;
	private static final int DEFAULT_WRAP_COUNT = 4;

	private static final Marker DEDUPLICATE = MarkerFactory.getMarker("DEDUPLICATE");

	private final InfoBoxManager infoboxManager;
	private final TooltipManager tooltipManager;
	private final Client client;
	private final RuneLiteConfig config;
	private final EventBus eventBus;
	private final String name;
	private ComponentOrientation orientation;

	@Getter
	private final List<InfoBox> infoBoxes = new CopyOnWriteArrayList<>();

	private InfoBoxComponent hoveredComponent;

	InfoBoxOverlay(
		InfoBoxManager infoboxManager,
		TooltipManager tooltipManager,
		Client client,
		RuneLiteConfig config,
		EventBus eventBus,
		String name,
		@NonNull ComponentOrientation orientation)
	{
		this.tooltipManager = tooltipManager;
		this.infoboxManager = infoboxManager;
		this.client = client;
		this.config = config;
		this.eventBus = eventBus;
		this.name = name;
		this.orientation = orientation;
		setPosition(OverlayPosition.TOP_LEFT);
		setClearChildren(false);
		setDragTargetable(true);

		panelComponent.setWrap(true);
		panelComponent.setBackgroundColor(null);
		panelComponent.setBorder(new Rectangle());
		panelComponent.setGap(new Point(GAP, GAP));
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final boolean menuOpen = client.isMenuOpen();
		if (!menuOpen)
		{
			hoveredComponent = null;
		}

		if (infoBoxes.isEmpty())
		{
			return null;
		}

		// Set preferred size to the size of DEFAULT_WRAP_COUNT infoboxes, including the padding - which is applied
		// to the last infobox prior to wrapping too.
		panelComponent.setPreferredSize(new Dimension(DEFAULT_WRAP_COUNT * (config.infoBoxSize() + GAP), DEFAULT_WRAP_COUNT * (config.infoBoxSize() + GAP)));
		panelComponent.setOrientation(orientation);

		final Font font = config.infoboxFontType().getFont();
		final boolean infoBoxTextOutline = config.infoBoxTextOutline();
		final Color overlayBackgroundColor = config.overlayBackgroundColor();
		final Dimension preferredSize = new Dimension(config.infoBoxSize(), config.infoBoxSize());
		for (InfoBox box : infoBoxes)
		{
			try
			{
				if (!box.render())
				{
					continue;
				}
			}
			catch (Exception ex)
			{
				log.warn(DEDUPLICATE, "Error during infobox rendering", ex);
				continue;
			}

			final String text = box.getText();
			final Color color = box.getTextColor();

			final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
			infoBoxComponent.setText(text);
			infoBoxComponent.setFont(font);
			if (color != null)
			{
				infoBoxComponent.setColor(color);
			}
			infoBoxComponent.setOutline(infoBoxTextOutline);
			infoBoxComponent.setImage(box.getScaledImage());
			infoBoxComponent.setTooltip(box.getTooltip());
			infoBoxComponent.setPreferredSize(preferredSize);
			infoBoxComponent.setBackgroundColor(overlayBackgroundColor);
			infoBoxComponent.setInfoBox(box);
			panelComponent.getChildren().add(infoBoxComponent);
		}

		final Dimension dimension = super.render(graphics);

		// Handle tooltips
		final Point mouse = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());

		for (final LayoutableRenderableEntity child : panelComponent.getChildren())
		{
			final InfoBoxComponent component = (InfoBoxComponent) child;

			// Create intersection rectangle
			final Rectangle intersectionRectangle = new Rectangle(component.getBounds());
			intersectionRectangle.translate(getBounds().x, getBounds().y);

			if (intersectionRectangle.contains(mouse))
			{
				final String tooltip = component.getTooltip();
				if (!Strings.isNullOrEmpty(tooltip))
				{
					tooltipManager.add(new Tooltip(tooltip));
				}

				if (!menuOpen)
				{
					hoveredComponent = component;
				}
				break;
			}
		}

		panelComponent.getChildren().clear();
		return dimension;
	}

	@Override
	public List<OverlayMenuEntry> getMenuEntries()
	{
		// we dynamically build the menu options based on which infobox is hovered
		return hoveredComponent == null ? Collections.emptyList() : hoveredComponent.getInfoBox().getMenuEntries();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		if (menuOptionClicked.getMenuAction() != MenuAction.RUNELITE_INFOBOX || hoveredComponent == null)
		{
			return;
		}

		InfoBox infoBox = hoveredComponent.getInfoBox();
		OverlayMenuEntry overlayMenuEntry = infoBox.getMenuEntries().stream()
			.filter(me -> me.getOption().equals(menuOptionClicked.getMenuOption()))
			.findAny()
			.orElse(null);
		if (overlayMenuEntry != null)
		{
			eventBus.post(new InfoBoxMenuClicked(overlayMenuEntry, infoBox));
		}
	}

	@Override
	public boolean onDrag(Overlay source)
	{
		if (!(source instanceof InfoBoxOverlay))
		{
			return false;
		}

		infoboxManager.mergeInfoBoxes((InfoBoxOverlay) source, this);
		return true;
	}

	ComponentOrientation flip()
	{
		return orientation = orientation == ComponentOrientation.HORIZONTAL ? ComponentOrientation.VERTICAL : ComponentOrientation.HORIZONTAL;
	}
}
