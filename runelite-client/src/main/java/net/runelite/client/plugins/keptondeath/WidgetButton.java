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
package net.runelite.client.plugins.keptondeath;

import java.util.Arrays;
import java.util.Collection;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetType;

@Slf4j
public class WidgetButton
{
	private static final int ICON_HEIGHT = 26;
	private static final int ICON_WIDTH = 26;
	private static final int BACKGROUND_HEIGHT = 32;
	private static final int BACKGROUND_WIDTH = 32;
	private static final int PADDING = 5;
	private static final int ICON_PADDING = (BACKGROUND_HEIGHT - ICON_HEIGHT) / 2;

	private static final int BACKGROUND_SPRITE_ID = SpriteID.EQUIPMENT_SLOT_TILE;
	private static final int SELECTED_BACKGROUND_SPRITE_ID = SpriteID.EQUIPMENT_SLOT_SELECTED;

	public interface WidgetButtonCallback
	{
		void run(String name, boolean newState);
	}

	private String name;
	private int spriteID;
	@Getter
	private Widget icon;
	@Getter
	private Widget background;
	private boolean selected;
	private WidgetButtonCallback callback;

	WidgetButton(String name, int spriteID, boolean selectedStartState, WidgetButtonCallback callback, Client client)
	{
		this.name = name;
		this.spriteID = spriteID;
		this.selected = selectedStartState;
		this.callback = callback;
		createBackgroundWidget(client);
		createIconWidget(client);
	}

	private void createBackgroundWidget(Client client)
	{
		background = createWidget(client);
		background.setOriginalWidth(BACKGROUND_WIDTH);
		background.setOriginalHeight(BACKGROUND_HEIGHT);
		syncBackgroundSprite();
	}

	private void createIconWidget(Client client)
	{
		icon = createWidget(client);
		icon.setAction(1, "Toggle:");
		icon.setOnOpListener((JavaScriptCallback) ev -> onButtonClicked());
		icon.setHasListener(true);
		icon.setSpriteId(spriteID);
	}

	private Widget createWidget(Client client)
	{
		Widget w = client.createWidget();
		w.setType(WidgetType.GRAPHIC);
		w.setOriginalWidth(ICON_WIDTH);
		w.setOriginalHeight(ICON_HEIGHT);
		w.setName("<col=ff981f>" + this.name);
		w.setIsIf3(true);
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
	static void addButtonsToContainerWidget(Widget container, Collection<WidgetButton> buttons)
	{
		Widget[] children = container.getChildren();
		if (children == null)
		{
			// Create a child so we can copy the returned Widget[] and avoid hn casting issues from creating a new Widget[]
			container.createChild(0, WidgetType.GRAPHIC);
			children = container.getChildren();
		}
		// Each button has two widgets, Icon and Background
		Widget[] itemsArray = Arrays.copyOf(children, buttons.size() * 2);
		int parentId = container.getId();

		int xIncrement = BACKGROUND_WIDTH + PADDING;
		int yIncrement = BACKGROUND_HEIGHT + PADDING;
		int maxRowItems = container.getWidth() / xIncrement;
		// Ensure at least 1 button per row
		maxRowItems = maxRowItems < 1 ? 1 : maxRowItems;

		int startingIndex = 0;
		for (WidgetButton w : buttons)
		{
			int originalX = (((startingIndex / 2) % maxRowItems) * xIncrement);
			int originalY = (((startingIndex / 2) / maxRowItems) * yIncrement);
			Widget background = updateWidgetPosition(w.getBackground(), parentId, startingIndex, originalX, originalY);
			itemsArray[startingIndex] = background;
			startingIndex++;
			// Icon must be padded to center inside image
			Widget icon = updateWidgetPosition(w.getIcon(), parentId, startingIndex, originalX + ICON_PADDING, originalY + ICON_PADDING);
			itemsArray[startingIndex] = icon;
			startingIndex++;
		}

		int rows = 1 + (buttons.size() > maxRowItems ? buttons.size() / maxRowItems : 0);
		container.setOriginalHeight(yIncrement * rows);
		container.setChildren(itemsArray);
		container.revalidate();
	}

	private static Widget updateWidgetPosition(Widget w, int id, int index, int originalX, int originalY)
	{
		w.setParentId(id);
		w.setId(id);
		w.setIndex(index);

		w.setOriginalX(originalX);
		w.setOriginalY(originalY);
		w.revalidate();

		return w;
	}

	private void onButtonClicked()
	{
		setSelected(!selected);
		callback.run(name, selected);
	}
}
