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

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.ScriptID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.JagexColors;
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
	static final HttpUrl WIKI_BASE = HttpUrl.get("https://oldschool.runescape.wiki");
	static final HttpUrl WIKI_API = WIKI_BASE.newBuilder().addPathSegments("api.php").build();
	static final String UTM_SOURCE_KEY = "utm_source";
	static final String UTM_SOURCE_VALUE = "runelite";

	private static final String MENUOP_WIKI = "Wiki";

	@Inject
	private WikiConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Provider<WikiSearchChatboxTextInput> wikiSearchChatboxTextInputProvider;

	@Inject
	private WikiDpsManager wikiDpsManager;

	private Widget icon;

	private boolean wikiSelected = false;

	static final String CONFIG_GROUP_KEY = "wiki";

	@Provides
	WikiConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WikiConfig.class);
	}

	@Override
	public void startUp()
	{
		clientThread.invokeLater(this::addWidgets);
		wikiDpsManager.startUp();
	}

	@Override
	public void shutDown()
	{
		clientThread.invokeLater(this::removeWidgets);
		wikiDpsManager.shutDown();
	}

	private void removeWidgets()
	{
		Widget wikiBannerParent = client.getWidget(InterfaceID.Orbs.WIKI);
		if (wikiBannerParent == null)
		{
			return;
		}
		Widget[] children = wikiBannerParent.getChildren();
		if (children == null || children.length < 1)
		{
			return;
		}
		children[0] = null;

		Widget vanilla = client.getWidget(InterfaceID.Orbs.WIKI_ICON);
		if (vanilla != null && client.getVarbitValue(VarbitID.WIKI_ICON_DISABLED) == 0)
		{
			vanilla.setHidden(false);
		}

		onDeselect();
		client.setWidgetSelected(false);
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded l)
	{
		if (l.getGroupId() == InterfaceID.ORBS)
		{
			addWidgets();
		}
	}

	private void addWidgets()
	{
		Widget wikiBannerParent = client.getWidget(InterfaceID.Orbs.WIKI);
		if (wikiBannerParent == null)
		{
			return;
		}

		if (client.getVarbitValue(VarbitID.WIKI_ICON_DISABLED) == 1) // disabled
		{
			// when the wiki entity lookup option is disabled the banner parent layer,
			// which is used for var transmit events, is not positioned. This is copied
			// from [proc,wiki_icon_update]
			wikiBannerParent.setOriginalX(client.isResized() ? 0 : 8);
			wikiBannerParent.setOriginalY(135);
			wikiBannerParent.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
			wikiBannerParent.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
			wikiBannerParent.revalidate();
		}

		Widget vanilla = client.getWidget(InterfaceID.Orbs.WIKI_ICON);
		if (vanilla != null)
		{
			vanilla.setHidden(true);
		}

		if (!config.showWikiMinimapButton())
		{
			return;
		}

		icon = wikiBannerParent.createChild(0, WidgetType.GRAPHIC);
		icon.setSpriteId(SpriteID.WikiIcon.DESELECTED);
		icon.setOriginalX(0);
		icon.setOriginalY(0);
		icon.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
		icon.setYPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
		icon.setOriginalWidth(40);
		icon.setOriginalHeight(14);
		icon.setTargetVerb("Lookup");
		icon.setName("Wiki");
		icon.setClickMask(WidgetConfig.USE_GROUND_ITEM | WidgetConfig.USE_NPC
			| WidgetConfig.USE_OBJECT | WidgetConfig.USE_WIDGET);
		icon.setNoClickThrough(true);
		icon.setOnTargetEnterListener((JavaScriptCallback) ev ->
		{
			wikiSelected = true;
			icon.setSpriteId(SpriteID.WikiIcon.SELECTED);
			client.setAllWidgetsAreOpTargetable(true);
		});

		final int searchIndex = config.leftClickSearch() ? 4 : 5;
		icon.setAction(searchIndex, "Search");
		icon.setAction(6, "DPS");
		icon.setOnOpListener((JavaScriptCallback) ev ->
		{
			int op = ev.getOp() - 1;
			if (op == searchIndex)
			{
				openSearchInput();
			}
			else if (op == 6)
			{
				wikiDpsManager.launch();
			}
		});

		// This doesn't always run because we cancel the menuop
		icon.setOnTargetLeaveListener((JavaScriptCallback) ev -> onDeselect());
		icon.revalidate();
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.WIKI_ICON_UPDATE)
		{
			Widget w = client.getWidget(InterfaceID.Orbs.WIKI_ICON);
			w.setHidden(true);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP_KEY))
		{
			clientThread.invokeLater(() ->
			{
				removeWidgets();
				addWidgets();
			});
		}
	}

	private void onDeselect()
	{
		client.setAllWidgetsAreOpTargetable(false);

		wikiSelected = false;
		if (icon != null)
		{
			icon.setSpriteId(SpriteID.WikiIcon.DESELECTED);
		}
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked ev)
	{
		optarget:
		if (wikiSelected)
		{
			onDeselect();
			client.setWidgetSelected(false);
			ev.consume();

			String type;
			int id;
			String name;
			WorldPoint location;

			switch (ev.getMenuAction())
			{
				case RUNELITE:
					// This is a quest widget op
					break optarget;
				case CANCEL:
					return;
				case WIDGET_TARGET_ON_GROUND_ITEM:
				{
					type = "item";
					id = itemManager.canonicalize(ev.getId());
					name = itemManager.getItemComposition(id).getMembersName();
					location = null;
					break;
				}
				case WIDGET_TARGET_ON_NPC:
				{
					type = "npc";
					NPC npc = ev.getMenuEntry().getNpc();
					if (npc == null)
					{
						return;
					}
					NPCComposition nc = npc.getTransformedComposition();
					if (nc == null)
					{
						return;
					}
					id = nc.getId();
					name = nc.getName();
					location = npc.getWorldLocation();
					break;
				}
				case WIDGET_TARGET_ON_GAME_OBJECT:
				{
					type = "object";
					ObjectComposition lc = client.getObjectDefinition(ev.getId());
					if (lc.getImpostorIds() != null)
					{
						lc = lc.getImpostor();
					}
					id = lc.getId();
					name = lc.getName();
					location = WorldPoint.fromScene(client, ev.getParam0(), ev.getParam1(), client.getPlane());
					break;
				}
				case WIDGET_TARGET_ON_WIDGET:
					Widget w = getWidget(ev.getParam1(), ev.getParam0());

					if (w.getType() == WidgetType.GRAPHIC && w.getItemId() != -1)
					{
						type = "item";
						id = itemManager.canonicalize(w.getItemId());
						name = itemManager.getItemComposition(id).getMembersName();
						location = null;
						break;
					}
					// fallthrough
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
				.addQueryParameter(UTM_SOURCE_KEY, UTM_SOURCE_VALUE);

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
	}

	private void openSearchInput()
	{
		wikiSearchChatboxTextInputProvider.get()
			.build();
	}

	private Widget getWidget(int wid, int index)
	{
		Widget w = client.getWidget(wid);
		if (index != -1)
		{
			w = w.getChild(index);
		}
		return w;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetIndex = event.getActionParam0();
		int widgetID = event.getActionParam1();

		if (wikiSelected && event.getType() == MenuAction.WIDGET_TARGET_ON_WIDGET.getId())
		{
			Menu menu = client.getMenu();
			MenuEntry[] menuEntries = menu.getMenuEntries();
			Widget w = getWidget(widgetID, widgetIndex);
			if (w.getType() == WidgetType.GRAPHIC && w.getItemId() != -1 && w.getItemId() != ItemID.BLANKOBJECT)
			{
				for (int ourEntry = menuEntries.length - 1; ourEntry >= 0; ourEntry--)
				{
					MenuEntry entry = menuEntries[ourEntry];
					if (entry.getType() == MenuAction.WIDGET_TARGET_ON_WIDGET)
					{
						int id = itemManager.canonicalize(w.getItemId());
						String name = itemManager.getItemComposition(id).getMembersName();
						if ("null".equals(name))
						{
							// may be a dummy item for the UI without a name
							menu.removeMenuEntry(entry);
						}
						else
						{
							entry.setTarget(JagexColors.MENU_TARGET_TAG + name);
						}
						break;
					}
				}
			}
			else
			{
				// we don't support this widget
				// remove the last SPELL_CAST_ON_WIDGET; we can't blindly remove the top action because some other
				// plugin might have added something on this same event, and we probably shouldn't remove that instead
				MenuEntry[] oldEntries = menuEntries;
				menuEntries = Arrays.copyOf(menuEntries, menuEntries.length - 1);
				for (int ourEntry = oldEntries.length - 1;
					ourEntry >= 2 && oldEntries[oldEntries.length - 1].getType() != MenuAction.WIDGET_TARGET_ON_WIDGET;
					ourEntry--)
				{
					menuEntries[ourEntry - 1] = oldEntries[ourEntry];
				}
				client.setMenuEntries(menuEntries);
			}
		}

		if (event.getType() == MenuAction.CC_OP.getId() && WidgetUtil.componentToInterface(widgetID) == InterfaceID.STATS)
		{
			Widget w = getWidget(widgetID, widgetIndex);
			if (w.getActions() == null || w.getParentId() != InterfaceID.Stats.UNIVERSE)
			{
				return;
			}

			String action = Stream.of(w.getActions())
				.filter(s -> s != null && !s.isEmpty())
				.findFirst().orElse(null);
			if (action == null)
			{
				return;
			}

			client.createMenuEntry(-1)
				.setTarget(action.replace("View ", "").replace(" guide", ""))
				.setOption(MENUOP_WIKI)
				.setType(MenuAction.RUNELITE)
				.onClick(ev -> LinkBrowser.browse(WIKI_BASE.newBuilder()
					.addPathSegment("w")
					.addPathSegment(Text.removeTags(ev.getTarget()))
					.addQueryParameter(UTM_SOURCE_KEY, UTM_SOURCE_VALUE)
					.build().toString()));
		}

		if (event.getType() == MenuAction.CC_OP.getId() && WidgetUtil.componentToInterface(widgetID) == InterfaceID.CA_TASKS)
		{
			Widget w = getWidget(widgetID, widgetIndex);
			if (w.getActions() == null || w.getParentId() != InterfaceID.CaTasks.TASKS_BACKGROUND)
			{
				return;
			}

			client.getMenu().createMenuEntry(-1)
				.setTarget(w.getName())
				.setOption(MENUOP_WIKI)
				.setType(MenuAction.RUNELITE)
				.onClick(ev -> LinkBrowser.browse(WIKI_BASE.newBuilder()
					.addPathSegment("w")
					.addPathSegment(Text.removeTags(ev.getTarget()))
					.addQueryParameter(UTM_SOURCE_KEY, UTM_SOURCE_VALUE)
					.build().toString()));
		}
	}
}
