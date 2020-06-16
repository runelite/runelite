/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
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
import java.awt.event.KeyEvent;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.InfoBoxComponent;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;

@Singleton
public class InfoBoxOverlay extends OverlayPanel implements KeyListener
{
	private static final int GAP = 1;
	private static final int DEFAULT_WRAP_COUNT = 4;

	private final InfoBoxManager infoboxManager;
	private final TooltipManager tooltipManager;
	private final Client client;
	private final RuneLiteConfig config;

	private boolean isShiftHeld;
	private MenuEntry[] menuEntries;

	@Inject
	private InfoBoxOverlay(
		InfoBoxManager infoboxManager,
		TooltipManager tooltipManager,
		Client client,
		KeyManager keyManager,
		RuneLiteConfig config)
	{
		this.tooltipManager = tooltipManager;
		this.infoboxManager = infoboxManager;
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.TOP_LEFT);
		setClearChildren(false);

		panelComponent.setWrap(true);
		panelComponent.setBackgroundColor(null);
		panelComponent.setBorder(new Rectangle());
		panelComponent.setGap(new Point(GAP, GAP));

		keyManager.registerKeyListener(this);
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			isShiftHeld = false;
			menuEntries = null;
		}
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (menuEntries == null)
		{
			return;
		}

		if (!isShiftHeld && config.menuEntryShift())
		{
			return;
		}

		if (client.isMenuOpen())
		{
			return;
		}

		MenuEntry[] clientMenuEntries = client.getMenuEntries();
		MenuEntry[] newEntries = new MenuEntry[clientMenuEntries.length + menuEntries.length];

		newEntries[0] = clientMenuEntries[0]; // Keep cancel at 0
		System.arraycopy(menuEntries, 0, newEntries, 1, menuEntries.length); // Add infobox menu entries
		System.arraycopy(clientMenuEntries, 1, newEntries, menuEntries.length + 1,
			clientMenuEntries.length - 1); // Add remaining menu entries
		client.setMenuEntries(newEntries);
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		menuEntries = null;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<InfoBox> infoBoxes = infoboxManager.getInfoBoxes();

		if (infoBoxes.isEmpty())
		{
			return null;
		}

		// Set preferred size to the size of DEFAULT_WRAP_COUNT infoboxes, including the padding - which is applied
		// to the last infobox prior to wrapping too.
		panelComponent.setPreferredSize(new Dimension(DEFAULT_WRAP_COUNT * (config.infoBoxSize() + GAP), DEFAULT_WRAP_COUNT * (config.infoBoxSize() + GAP)));
		panelComponent.setOrientation(config.infoBoxVertical()
			? ComponentOrientation.VERTICAL
			: ComponentOrientation.HORIZONTAL);

		for (InfoBox box : infoBoxes)
		{
			if (!box.render())
			{
				continue;
			}

			final String text = box.getText();
			final Color color = box.getTextColor();

			final InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
			infoBoxComponent.setText(text);
			if (color != null)
			{
				infoBoxComponent.setColor(color);
			}
			infoBoxComponent.setImage(box.getScaledImage());
			infoBoxComponent.setTooltip(box.getTooltip());
			infoBoxComponent.setPreferredSize(new Dimension(config.infoBoxSize(), config.infoBoxSize()));
			infoBoxComponent.setBackgroundColor(config.overlayBackgroundColor());
			infoBoxComponent.setMenuEntries(box.getMenuEntries());
			infoBoxComponent.setParentId(box.getId());
			panelComponent.getChildren().add(infoBoxComponent);
		}

		final Dimension dimension = super.render(graphics);

		// Handle tooltips
		final Point mouse = new Point(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY());

		for (final LayoutableRenderableEntity child : panelComponent.getChildren())
		{
			if (child instanceof InfoBoxComponent)
			{
				final InfoBoxComponent component = (InfoBoxComponent) child;

				// Create intersection rectangle
				final Rectangle intersectionRectangle = new Rectangle(component.getBounds());
				intersectionRectangle.translate(getBounds().x, getBounds().y);
				if (intersectionRectangle.contains(mouse))
				{
					if (!Strings.isNullOrEmpty(component.getTooltip()))
					{
						tooltipManager.add(new Tooltip(component.getTooltip()));
					}

					if (!client.isMenuOpen() && !client.getSpellSelected())
					{
						// this block creates the menu entries, and combines the two menu entry arrays,
						// allowing for overlapping infoboxes to have menu entries if they are possible in future
						final MenuEntry[] createdEntries = createRightClickMenuEntries(component);

						if (createdEntries != null)
						{
							if (menuEntries == null)
							{
								menuEntries = createdEntries;
							}
							else
							{
								final MenuEntry[] newEntries = new MenuEntry[createdEntries.length + menuEntries.length];
								System.arraycopy(createdEntries, 0, newEntries, 0, createdEntries.length);
								System.arraycopy(menuEntries, 0, newEntries, createdEntries.length - 1, menuEntries.length);
								menuEntries = newEntries;
							}
						}
					}
				}
			}
		}

		panelComponent.getChildren().clear();
		return dimension;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.isShiftDown() && config.menuEntryShift())
		{
			isShiftHeld = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isShiftDown())
		{
			isShiftHeld = false;
		}
	}

	private MenuEntry[] createRightClickMenuEntries(InfoBoxComponent component)
	{
		List<OverlayMenuEntry> entriesList = component.getMenuEntries();

		if (entriesList.size() == 0)
		{
			// null will fall through to any overlapping infoboxes (future)
			return null;
		}

		final MenuEntry[] entries = new MenuEntry[entriesList.size()];

		for (int i = entriesList.size() - 1; i >= 0; i--)
		{
			OverlayMenuEntry overlayEntry = entriesList.get(i);

			final MenuEntry entry = new MenuEntry();
			entry.setOption(overlayEntry.getOption());
			entry.setTarget(ColorUtil.wrapWithColorTag(overlayEntry.getTarget(), JagexColors.MENU_TARGET));
			entry.setType(MenuAction.RUNELITE_INFOBOX.getId());
			entry.setIdentifier(component.getParentId());

			entries[i] = entry;
		}

		return entries;
	}
}
