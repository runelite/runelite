/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.itemskeptondeath;

import net.runelite.api.ScriptEvent;
import net.runelite.api.SpriteID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetType;

class WidgetButton
{
	private static final int ICON_HEIGHT = 26;
	private static final int ICON_WIDTH = 26;
	private static final int BACKGROUND_HEIGHT = 32;
	private static final int BACKGROUND_WIDTH = 32;
	private static final int PADDING = 5;
	private static final int ICON_PADDING = (BACKGROUND_HEIGHT - ICON_HEIGHT) / 2;

	private static final int BACKGROUND_SPRITE_ID = SpriteID.EQUIPMENT_SLOT_TILE;
	private static final int SELECTED_BACKGROUND_SPRITE_ID = SpriteID.EQUIPMENT_SLOT_SELECTED;

	@FunctionalInterface
	public interface WidgetButtonCallback
	{
		void run(boolean newState);
	}

	private final Widget parent;
	private final String name;
	private final int spriteID;
	private boolean selected;
	private final WidgetButtonCallback callback;

	private Widget icon;
	private Widget background;

	WidgetButton(
		final Widget parent,
		final String name,
		final int spriteID,
		final boolean selectedStartState,
		final WidgetButtonCallback callback)
	{
		this.parent = parent;
		this.name = name;
		this.spriteID = spriteID;
		this.selected = selectedStartState;
		this.callback = callback;
		createBackgroundWidget();
		createIconWidget();
	}

	private void createBackgroundWidget()
	{
		background = createWidget();
		background.setOriginalWidth(BACKGROUND_WIDTH);
		background.setOriginalHeight(BACKGROUND_HEIGHT);
		syncBackgroundSprite();
	}

	private void createIconWidget()
	{
		icon = createWidget();
		icon.setAction(1, "Toggle:");
		icon.setOnOpListener((JavaScriptCallback) this::onButtonClicked);
		icon.setOnMouseRepeatListener((JavaScriptCallback) e -> e.getSource().setOpacity(120));
		icon.setOnMouseLeaveListener((JavaScriptCallback) e -> e.getSource().setOpacity(0));
		icon.setHasListener(true);
		icon.setSpriteId(spriteID);
	}

	private Widget createWidget()
	{
		final Widget w = parent.createChild(-1, WidgetType.GRAPHIC);
		w.setOriginalWidth(ICON_WIDTH);
		w.setOriginalHeight(ICON_HEIGHT);
		w.setName("<col=ff981f>" + this.name);
		return w;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
		syncBackgroundSprite();
	}

	private void syncBackgroundSprite()
	{
		background.setSpriteId(selected ? SELECTED_BACKGROUND_SPRITE_ID : BACKGROUND_SPRITE_ID);
	}

	/**
	 * Adds the collection of WidgetButtons to the container overriding any existing children.
	 *
	 * @param container Widget to add buttons too
	 * @param buttons   buttons to add
	 */
	static void layoutButtonsToContainer(final Widget container, final WidgetButton... buttons)
	{
		// Each button has two widgets, Icon and Background
		final int xIncrement = BACKGROUND_WIDTH + PADDING;
		final int yIncrement = BACKGROUND_HEIGHT + PADDING;
		int maxRowItems = container.getWidth() / xIncrement;
		// Ensure at least 1 button per row
		maxRowItems = maxRowItems < 1 ? 1 : maxRowItems;

		int index = 0;
		for (final WidgetButton w : buttons)
		{
			if (w == null)
			{
				continue;
			}

			final int originalX = ((index % maxRowItems) * xIncrement);
			final int originalY = ((index / maxRowItems) * yIncrement);
			w.background.setOriginalX(originalX);
			w.background.setOriginalY(originalY);
			w.background.revalidate();

			// Icon must be padded to center inside image
			w.icon.setOriginalX(originalX + ICON_PADDING);
			w.icon.setOriginalY(originalY + ICON_PADDING);
			w.icon.revalidate();

			index++;
		}

		final int numButtons = index;
		final int rows = 1 + (numButtons > maxRowItems ? numButtons / maxRowItems : 0);
		container.setOriginalHeight(yIncrement * rows);
		container.revalidate();
	}

	private void onButtonClicked(ScriptEvent scriptEvent)
	{
		setSelected(!selected);
		callback.run(selected);
	}
}
