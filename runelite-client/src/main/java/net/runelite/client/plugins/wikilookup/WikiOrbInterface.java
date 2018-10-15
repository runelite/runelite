/*
 * Copyright (c) 2018, Tanner Mjelde
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

package net.runelite.client.plugins.wikilookup;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.SpriteID;
import net.runelite.api.WidgetType;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Slf4j
@Singleton
public class WikiOrbInterface
{
	private static final String WIKI_ORB = "Wiki Lookup";

	private final Client client;
	private Widget wikiOrb;
	private Widget orbSearch;
	private Widget orbBackground;

	@Getter
	private Widget parent;

	@Inject
	private WikiOrbInterface(final Client client)
	{
		this.client = client;
	}

	void init()
	{
		if (isHidden() || parent != null)
		{
			return;
		}

		parent = client.getWidget(WidgetInfo.MINIMAP_ORBS);
		wikiOrb = createGraphic(SpriteID.MINIMAP_ORB_WORLD_MAP_FRAME, 30 , 30 , 170, 0, true);
		orbBackground = createGraphic(SpriteID.MINIMAP_ORB_RUN, 25 , 25 , 173, 3, false);
		orbSearch = createGraphic(SpriteID.BANK_SEARCH, 22, 20, 173, 5, false);
		wikiOrb.setAction(0, WIKI_ORB);
	}

	void destroy()
	{
		parent = null;
		wikiOrb.setHidden(true);
		orbSearch.setHidden(true);
		orbBackground.setHidden(true);
	}

	boolean isActive()
	{
		if (isHidden())
		{
			return false;
		}

		return orbBackground.getSpriteId() == SpriteID.MINIMAP_ORB_RUN_ACTIVATED;
	}

	void setActive(boolean active)
	{
		if (isHidden())
		{
            return;
		}

		orbBackground.setSpriteId(active ? SpriteID.MINIMAP_ORB_RUN_ACTIVATED : SpriteID.MINIMAP_ORB_RUN);
	}

	void handleClick(MenuOptionClicked event)
	{
		if (isHidden())
		{
			return;
		}

		if (event.getMenuOption().equals(WIKI_ORB))
		{
			setActive(!isActive());
		}
	}

	private boolean isHidden()
	{
		Widget widget = client.getWidget(WidgetInfo.MINIMAP_ORBS);
		return widget == null || widget.isHidden();
	}

	private Widget createGraphic(int spriteId, int width, int height, int x, int y, boolean hasListener)
	{
		final Widget widget = parent.createChild(-1, WidgetType.GRAPHIC);
		widget.setOriginalWidth(width);
		widget.setOriginalHeight(height);
		widget.setOriginalX(x);
		widget.setOriginalY(y);
		widget.setSpriteId(spriteId);

		if (-1 > -1)
		{
			widget.setItemId(-1);
			widget.setItemQuantity(-1);
			widget.setBorderType(1);
		}

		if (hasListener)
		{
			widget.setOnOpListener(ScriptID.NULL);
			widget.setHasListener(true);
		}

		widget.setName("");
		widget.revalidate();
		return widget;
	}
}
