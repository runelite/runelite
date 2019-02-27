/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.wiki;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.Text;
import okhttp3.HttpUrl;

@Slf4j
@PluginDescriptor(
	name = "Wiki",
	description = "Adds a Wiki button that takes you to the OSRS Wiki"
)
public class WikiPlugin extends Plugin
{
	private static final int[] QUESTLIST_WIDGET_IDS = new int[]
		{
			WidgetInfo.QUESTLIST_FREE_CONTAINER.getId(),
			WidgetInfo.QUESTLIST_MEMBERS_CONTAINER.getId(),
			WidgetInfo.QUESTLIST_MINIQUEST_CONTAINER.getId(),
		};

	static final HttpUrl WIKI_BASE = HttpUrl.parse("https://oldschool.runescape.wiki");
	static final HttpUrl WIKI_API = WIKI_BASE.newBuilder().addPathSegments("api.php").build();
	static final String UTM_SORUCE_KEY = "utm_source";
	static final String UTM_SORUCE_VALUE = "runelite";

	private static final String MENUOP_GUIDE = "Guide";
	private static final String MENUOP_QUICKGUIDE = "Quick Guide";
	private static final String MENUOP_WIKI = "Wiki";

	private static final Pattern SKILL_REGEX = Pattern.compile("([A-Za-z]+) guide");
	private static final Pattern DIARY_REGEX = Pattern.compile("([A-Za-z &]+) Journal");

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private Client client;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Provider<WikiSearchChatboxTextInput> wikiSearchChatboxTextInputProvider;

	private Widget icon;

	private boolean wikiSelected = false;

	@Override
	public void startUp()
	{
		spriteManager.addSpriteOverrides(WikiSprite.values());
		clientThread.invokeLater(this::addWidgets);
	}

	@Override
	public void shutDown()
	{
		spriteManager.removeSpriteOverrides(WikiSprite.values());
		clientThread.invokeLater(() ->
		{
			Widget minimapOrbs = client.getWidget(WidgetInfo.MINIMAP_ORBS);
			if (minimapOrbs == null)
			{
				return;
			}
			Widget[] children = minimapOrbs.getChildren();
			if (children == null || children.length < 1)
			{
				return;
			}
			children[0] = null;
		});
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded l)
	{
		if (l.getGroupId() == WidgetID.MINIMAP_GROUP_ID)
		{
			addWidgets();
		}
	}

	private void addWidgets()
	{
		Widget minimapOrbs = client.getWidget(WidgetInfo.MINIMAP_ORBS);
		if (minimapOrbs == null)
		{
			return;
		}

		icon = minimapOrbs.createChild(0, WidgetType.GRAPHIC);
		icon.setSpriteId(WikiSprite.WIKI_ICON.getSpriteId());
		icon.setOriginalX(0);
		icon.setOriginalY(2);
		icon.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
		icon.setYPositionMode(WidgetPositionMode.ABSOLUTE_BOTTOM);
		icon.setOriginalWidth(42);
		icon.setOriginalHeight(16);
		icon.setTargetVerb("Lookup");
		icon.setName("Wiki");
		icon.setClickMask(WidgetConfig.USE_GROUND_ITEM | WidgetConfig.USE_ITEM | WidgetConfig.USE_NPC | WidgetConfig.USE_OBJECT);
		icon.setNoClickThrough(true);
		icon.setOnTargetEnterListener((JavaScriptCallback) ev ->
		{
			wikiSelected = true;
			icon.setSpriteId(WikiSprite.WIKI_SELECTED_ICON.getSpriteId());
		});
		icon.setAction(5, "Search"); // Start at option 5 so the target op is ontop
		icon.setOnOpListener((JavaScriptCallback) ev ->
		{
			switch (ev.getOp())
			{
				case 6:
					openSearchInput();
					break;
			}
		});
		// This doesn't always run because we cancel the menuop
		icon.setOnTargetLeaveListener((JavaScriptCallback) ev -> onDeselect());
		icon.revalidate();
	}

	private void onDeselect()
	{
		wikiSelected = false;
		icon.setSpriteId(WikiSprite.WIKI_ICON.getSpriteId());
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked ev)
	{
		if (wikiSelected)
		{
			onDeselect();
			client.setSpellSelected(false);
			ev.consume();

			String type;
			int id;
			String name;
			WorldPoint location;

			switch (ev.getMenuAction())
			{
				case CANCEL:
					return;
				case ITEM_USE_ON_WIDGET:
				case SPELL_CAST_ON_GROUND_ITEM:
				{
					type = "item";
					id = itemManager.canonicalize(ev.getId());
					name = itemManager.getItemComposition(id).getName();
					location = null;
					break;
				}
				case SPELL_CAST_ON_NPC:
				{
					type = "npc";
					NPC npc = client.getCachedNPCs()[ev.getId()];
					NPCComposition nc = npc.getTransformedComposition();
					id = nc.getId();
					name = nc.getName();
					location = npc.getWorldLocation();
					break;
				}
				case SPELL_CAST_ON_GAME_OBJECT:
				{
					type = "object";
					ObjectComposition lc = client.getObjectDefinition(ev.getId());
					if (lc.getImpostorIds() != null)
					{
						lc = lc.getImpostor();
					}
					id = lc.getId();
					name = lc.getName();
					location = WorldPoint.fromScene(client, ev.getActionParam(), ev.getWidgetId(), client.getPlane());
					break;
				}
				default:
					log.info("Unknown menu option: {} {} {}", ev, ev.getMenuAction(), ev.getMenuAction() == MenuAction.CANCEL);
					return;
			}

			name = Text.removeTags(name);
			HttpUrl.Builder urlBuilder = WIKI_BASE.newBuilder();
			urlBuilder.addPathSegments("w/Special:Lookup")
				.addQueryParameter("type", type)
				.addQueryParameter("id", "" + id)
				.addQueryParameter("name", name)
				.addQueryParameter(UTM_SORUCE_KEY, UTM_SORUCE_VALUE);

			if (location != null)
			{
				urlBuilder.addQueryParameter("x", "" + location.getX())
					.addQueryParameter("y", "" + location.getY())
					.addQueryParameter("plane", "" + location.getPlane());
			}

			HttpUrl url = urlBuilder.build();

			LinkBrowser.browse(url.toString());
			return;
		}

		if (ev.getMenuAction() == MenuAction.RUNELITE)
		{
			boolean quickguide = false;
			switch (ev.getMenuOption())
			{
				case MENUOP_QUICKGUIDE:
					quickguide = true;
					//fallthrough;
				case MENUOP_GUIDE:
					ev.consume();
					String quest = Text.removeTags(ev.getMenuTarget());
					HttpUrl.Builder ub = WIKI_BASE.newBuilder()
						.addPathSegment("w")
						.addPathSegment(quest)
						.addQueryParameter(UTM_SORUCE_KEY, UTM_SORUCE_VALUE);
					if (quickguide)
					{
						ub.addPathSegment("Quick_guide");
					}
					LinkBrowser.browse(ub.build().toString());
					break;
				case MENUOP_WIKI:
					Matcher skillRegex = WikiPlugin.SKILL_REGEX.matcher(Text.removeTags(ev.getMenuTarget()));
					Matcher diaryRegex = WikiPlugin.DIARY_REGEX.matcher(Text.removeTags(ev.getMenuTarget()));

					if (skillRegex.find())
					{
						LinkBrowser.browse(WIKI_BASE.newBuilder()
							.addPathSegment("w")
							.addPathSegment(skillRegex.group(1))
							.addQueryParameter(UTM_SORUCE_KEY, UTM_SORUCE_VALUE)
							.build().toString());
					}
					else if (diaryRegex.find())
					{
						LinkBrowser.browse(WIKI_BASE.newBuilder()
							.addPathSegment("w")
							.addPathSegment(diaryRegex.group(1) + " Diary")
							.addQueryParameter(UTM_SORUCE_KEY, UTM_SORUCE_VALUE)
							.build().toString());
					}
			}
		}
	}

	private void openSearchInput()
	{
		wikiSearchChatboxTextInputProvider.get()
			.build();
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetIndex = event.getActionParam0();
		int widgetID = event.getActionParam1();
		MenuEntry[] menuEntries = client.getMenuEntries();

		if (Ints.contains(QUESTLIST_WIDGET_IDS, widgetID) && "Read Journal:".equals(event.getOption()))
		{
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 2);

			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();
			menuEntry.setTarget(event.getTarget());
			menuEntry.setOption(MENUOP_GUIDE);
			menuEntry.setParam0(widgetIndex);
			menuEntry.setParam1(widgetID);
			menuEntry.setType(MenuAction.RUNELITE.getId());

			menuEntry = menuEntries[menuEntries.length - 2] = new MenuEntry();
			menuEntry.setTarget(event.getTarget());
			menuEntry.setOption(MENUOP_QUICKGUIDE);
			menuEntry.setParam0(widgetIndex);
			menuEntry.setParam1(widgetID);
			menuEntry.setType(MenuAction.RUNELITE.getId());

			client.setMenuEntries(menuEntries);
		}

		if ((WidgetInfo.TO_GROUP(widgetID) == WidgetID.SKILLS_GROUP_ID && event.getOption().startsWith("View"))
			|| (WidgetInfo.TO_GROUP(widgetID) == WidgetID.DIARY_GROUP_ID && event.getOption().startsWith("Open")))
		{
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();
			menuEntry.setTarget(event.getOption().replace("View ", "").replace("Open ", ""));
			menuEntry.setOption(MENUOP_WIKI);
			menuEntry.setParam0(widgetIndex);
			menuEntry.setParam1(widgetID);
			menuEntry.setIdentifier(event.getIdentifier());
			menuEntry.setType(MenuAction.RUNELITE.getId());

			client.setMenuEntries(menuEntries);
		}
	}
}
