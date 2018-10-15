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
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;

@Slf4j
@Singleton
public class WikiOrbInterface
{
	private static final String WIKI_ORB = "Wiki Lookup";
	private final Client client;
	private final ClientThread clientThread;
	private final ConfigManager configManager;
	private final WikiLookupConfig config;
	private boolean loaded = false;

	private Widget wikiOrb;
	private Widget orbSearch;
	private Widget orbBackground;

	@Getter
	private Widget parent;
	
	@Inject
	private WikiOrbInterface(
			final Client client,
			final ClientThread clientThread,
			final ConfigManager configManager,
			final WikiLookupConfig config)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.configManager = configManager;
		this.config = config;
	}
	
	public void init()
	{
		if (isHidden())
		{
			return;
		}
		loaded = true;
		parent = client.getWidget(WidgetInfo.MINIMAP_ORBS);
		wikiOrb = createGraphic("", SpriteID.MINIMAP_ORB_WORLD_MAP_FRAME, -1, 30 , 30 , 170, 0, true);
		orbBackground = createGraphic("", SpriteID.MINIMAP_ORB_RUN, -1, 25 , 25 , 173, 3, false);
		orbSearch = createGraphic("", SpriteID.BANK_SEARCH, -1, 22, 20, 173, 5, false);
		wikiOrb.setAction(0, WIKI_ORB);
	}
	
	public void destroy()
	{
		wikiOrb.setHidden(true);
		orbSearch.setHidden(true);
		orbBackground.setHidden(true);
	}
	
	public boolean getLoaded()
	{
		return loaded;
	}
	
	private boolean isHidden()
	{
		Widget widget = client.getWidget(WidgetInfo.MINIMAP_ORBS);
		return widget == null || widget.isHidden();
	}

	public boolean getStatus()
	{
		return orbBackground.getSpriteId() == SpriteID.MINIMAP_ORB_RUN_ACTIVATED;
	}

	public void setStatus(boolean status)
	{
		if (status)
		{
			orbBackground.setSpriteId(SpriteID.MINIMAP_ORB_RUN_ACTIVATED);
		}
		else
		{
			orbBackground.setSpriteId(SpriteID.MINIMAP_ORB_RUN);
		}
	}
	
	private Widget createGraphic(String name, int spriteId, int itemId, int width, int height, int x, int y, boolean hasListener)
	{
		Widget widget = parent.createChild(-1, WidgetType.GRAPHIC);
		widget.setOriginalWidth(width);
		widget.setOriginalHeight(height);
		widget.setOriginalX(x);
		widget.setOriginalY(y);
		widget.setSpriteId(spriteId);
		if (itemId > -1)
		{
			widget.setItemId(itemId);
			widget.setItemQuantity(-1);
			widget.setBorderType(1);
		}
		if (hasListener)
		{
			widget.setOnOpListener(ScriptID.NULL);
			widget.setHasListener(true);
		}
		widget.setName(name);
		widget.revalidate();
		return widget;
	}
}
