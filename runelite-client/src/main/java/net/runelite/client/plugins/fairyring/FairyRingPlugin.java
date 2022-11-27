/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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

package net.runelite.client.plugins.fairyring;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Fairy Rings",
	description = "Show the location of the fairy ring teleport",
	tags = {"teleportation"}
)
public class FairyRingPlugin extends Plugin
{
	private static final String[] leftDial = {"A", "D", "C", "B"};
	private static final String[] middleDial = {"I", "L", "K", "J"};
	private static final String[] rightDial = {"P", "S", "R", "Q"};

	private static final int ENTRY_PADDING = 3;

	private static final String MENU_OPEN = "Open";
	private static final String MENU_CLOSE = "Close";
	private static final String SET_TAG = "Set Tag";

	@Inject
	private Client client;

	@Inject
	private FairyRingConfig config;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	Gson gson;

	private ChatboxTextInput searchInput = null;
	private Widget searchBtn;
	private Collection<CodeWidgets> codes = null;
	private Map<FairyRings, String> USER_CODES = new HashMap<>();

	@Data
	private static class CodeWidgets
	{
		// The fairy hideout has both of these null, because its not the same as the rest of them
		@Nullable
		private Widget favorite;

		@Nullable
		private Widget code;

		private Widget description;
	}

	@Provides
	FairyRingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FairyRingConfig.class);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setWidgetTextToDestination();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.FAIRY_RING_PANEL_GROUP_ID)
		{
			setWidgetTextToDestination();
			setTravelLogToCustomDestination();

			Widget header = client.getWidget(WidgetInfo.FAIRY_RING_HEADER);
			if (header != null)
			{
				searchBtn = header.createChild(-1, WidgetType.GRAPHIC);
				searchBtn.setSpriteId(SpriteID.GE_SEARCH);
				searchBtn.setOriginalWidth(17);
				searchBtn.setOriginalHeight(17);
				searchBtn.setOriginalX(11);
				searchBtn.setOriginalY(11);
				searchBtn.setHasListener(true);
				searchBtn.setAction(1, MENU_OPEN);
				searchBtn.setOnOpListener((JavaScriptCallback) this::menuOpen);
				searchBtn.setName("Search");
				searchBtn.revalidate();

				codes = null;

				if (config.autoOpen())
				{
					openSearch();
				}
			}
		}
	}

	@Subscribe
	public void onMenuOpened(MenuOpened menuOpened)
	{
		MenuEntry[] entries = client.getMenuEntries();
		for (int idx = entries.length - 1; idx >= 0; --idx)
		{
			MenuEntry entry = entries[idx];
			if (entry.getOption().contains("Use code"))
			{
				client.createMenuEntry(-1)
					.setOption(SET_TAG)
					.setTarget(entry.getTarget())
					.setType(MenuAction.RUNELITE);
			}
		}
	}

	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked option)
	{
		if (option.getMenuOption().equals(SET_TAG))
		{
			String ringCode = Text.removeTags(option.getMenuTarget().replaceAll(" ", ""));
			openCustomTagInput(ringCode);
		}
	}

	private void openCustomTagInput(String code)
	{
		searchInput = chatboxPanelManager.openTextInput(SET_TAG + " For " + code)
			.onDone(s ->
			{
				if (s == null || s.isEmpty())
				{
					USER_CODES.remove(FairyRings.valueOf(code));
					saveUserCodes(USER_CODES);
					setTravelLogToCustomDestination();
				}
				else
				{
					USER_CODES.put(FairyRings.valueOf(code), s);
					saveUserCodes(USER_CODES);
					setTravelLogToCustomDestination();
				}
			})
			.build();
	}

	private void menuOpen(ScriptEvent e)
	{
		openSearch();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void menuClose(ScriptEvent e)
	{
		updateFilter("");
		chatboxPanelManager.close();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void saveUserCodes(Map<FairyRings, String> userCodes)
	{
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		String codes = gson.toJson(userCodes);
		config.customFRDescriptions(codes);
	}

	private void readUserCodes()
	{
		Type type = new TypeToken<HashMap<FairyRings, String>>()
		{
		}.getType();
		this.USER_CODES = gson.<HashMap<FairyRings, String>>fromJson(config.customFRDescriptions(), type);
	}

	private void setTravelLogToCustomDestination()
	{
		readUserCodes();
		final Widget list = client.getWidget(WidgetInfo.FAIRY_RING_LIST);
		final Widget favoritesList = client.getWidget(WidgetInfo.FAIRY_RING_FAVORITES);

		try
		{
			for (Widget w : list.getStaticChildren())
			{
				String code = Text.removeTags(w.getName().replaceAll("\\s", ""));

				// find the widget we want by relative x value, this filters out the 'favorites' heart widget
				if (w.getRelativeX() >= 20 && USER_CODES.containsKey(FairyRings.valueOf(code)))
				{
					w.setText("<br>" + USER_CODES.get(FairyRings.valueOf(code)));
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			log.debug(e.getMessage());
		}

		try
		{
			for (Widget w : favoritesList.getStaticChildren())
			{
				if (w.getId() == 24969225)
				{
					continue;
				}

				String code = Text.removeTags(w.getName().replaceAll("\\s", ""));
				if (w.getRelativeX() >= 20 && USER_CODES.containsKey(FairyRings.valueOf(code)))
				{
					w.setText("<br>" + USER_CODES.get(FairyRings.valueOf(code)));
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			log.debug(e.getMessage());
		}
	}

	private void setWidgetTextToDestination()
	{
		Widget fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
		if (fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden())
		{
			String destination;
			try
			{
				FairyRings fairyRingDestination = getFairyRingDestination(client.getVarbitValue(Varbits.FAIRY_RING_DIAL_ADCB),
					client.getVarbitValue(Varbits.FAIRY_RIGH_DIAL_ILJK), client.getVarbitValue(Varbits.FAIRY_RING_DIAL_PSRQ));
				destination = (USER_CODES.containsKey(fairyRingDestination))
					? USER_CODES.get(fairyRingDestination) : fairyRingDestination.getDestination();
			}
			catch (IllegalArgumentException ex)
			{
				destination = "Invalid location";
			}

			fairyRingTeleportButton.setText(destination);
		}
	}

	private FairyRings getFairyRingDestination(int varbitValueDialLeft, int varbitValueDialMiddle, int varbitValueDialRight)
	{
		return FairyRings.valueOf(leftDial[varbitValueDialLeft] + middleDial[varbitValueDialMiddle] + rightDial[varbitValueDialRight]);
	}

	private void openSearch()
	{
		updateFilter("");
		searchBtn.setAction(1, MENU_CLOSE);
		searchBtn.setOnOpListener((JavaScriptCallback) this::menuClose);
		searchInput = chatboxPanelManager.openTextInput("Filter fairy rings")
			.onChanged(s -> clientThread.invokeLater(() -> updateFilter(s)))
			.onDone(s -> false)
			.onClose(() ->
			{
				clientThread.invokeLater(() -> updateFilter(""));
				searchBtn.setOnOpListener((JavaScriptCallback) this::menuOpen);
				searchBtn.setAction(1, MENU_OPEN);
			})
			.build();
	}

	@Subscribe
	public void onGameTick(GameTick t)
	{
		// This has to happen because the only widget that gets hidden is the tli one
		Widget fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
		boolean fairyRingWidgetOpen = fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden();
		boolean chatboxOpen = searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;

		if (!fairyRingWidgetOpen && chatboxOpen)
		{
			chatboxPanelManager.close();
		}
	}

	private void updateFilter(String filter)
	{
		filter = filter.toLowerCase();
		final Widget list = client.getWidget(WidgetInfo.FAIRY_RING_LIST);
		final Widget favorites = client.getWidget(WidgetInfo.FAIRY_RING_FAVORITES);

		if (list == null)
		{
			return;
		}

		if (codes != null)
		{
			// Check to make sure the list hasn't been rebuild since we were last her
			// Do this by making sure the list's dynamic children are the same as when we last saw them
			if (codes.stream().noneMatch(w ->
			{
				Widget codeWidget = w.getCode();
				if (codeWidget == null)
				{
					return false;
				}
				return list.getChild(codeWidget.getIndex()) == codeWidget;
			}))
			{
				codes = null;
			}
		}

		if (codes == null)
		{
			// Find all of the widgets that we care about, grouping by their Y value
			Map<Integer, CodeWidgets> codeMap = new TreeMap<>();

			for (Widget w : list.getStaticChildren())
			{
				if (w.isSelfHidden())
				{
					continue;
				}

				if (w.getSpriteId() != -1)
				{
					codeMap.computeIfAbsent(w.getRelativeY(), k -> new CodeWidgets()).setFavorite(w);
				}
				else if (!Strings.isNullOrEmpty(w.getText()))
				{
					codeMap.computeIfAbsent(w.getRelativeY(), k -> new CodeWidgets()).setDescription(w);
				}
			}

			for (Widget w : list.getDynamicChildren())
			{
				if (w.isSelfHidden())
				{
					continue;
				}

				CodeWidgets c = codeMap.computeIfAbsent(w.getRelativeY(), k -> new CodeWidgets());
				c.setCode(w);
			}

			codes = codeMap.values();
		}

		// Relayout the panel
		int y = 0;

		if (favorites != null)
		{
			boolean hide = !filter.isEmpty();
			favorites.setHidden(hide);
			if (!hide)
			{
				y += favorites.getOriginalHeight() + ENTRY_PADDING;
			}
		}

		for (CodeWidgets c : codes)
		{
			String code = Text.removeTags(c.getDescription().getName()).replaceAll(" ", "");
			String tags = null;

			if (!code.isEmpty())
			{
				try
				{
					FairyRings ring = FairyRings.valueOf(code);
					tags = ring.getTags();
				}
				catch (IllegalArgumentException e)
				{
					log.warn("Unable to find ring with code '{}'", code, e);
				}
			}

			boolean hidden = !(filter.isEmpty()
				|| Text.removeTags(c.getDescription().getText()).toLowerCase().contains(filter)
				|| code.toLowerCase().contains(filter)
				|| tags != null && tags.contains(filter));

			if (c.getCode() != null)
			{
				c.getCode().setHidden(hidden);
				c.getCode().setOriginalY(y);
			}

			if (c.getFavorite() != null)
			{
				c.getFavorite().setHidden(hidden);
				c.getFavorite().setOriginalY(y);
			}

			c.getDescription().setHidden(hidden);
			c.getDescription().setOriginalY(y);

			if (!hidden)
			{
				y += c.getDescription().getHeight() + ENTRY_PADDING;
			}
		}

		y -= ENTRY_PADDING;

		if (y < 0)
		{
			y = 0;
		}

		int newHeight = 0;
		if (list.getScrollHeight() > 0)
		{
			newHeight = (list.getScrollY() * y) / list.getScrollHeight();
		}

		list.setScrollHeight(y);
		list.revalidateScroll();
		client.runScript(
			ScriptID.UPDATE_SCROLLBAR,
			WidgetInfo.FAIRY_RING_LIST_SCROLLBAR.getId(),
			WidgetInfo.FAIRY_RING_LIST.getId(),
			newHeight
		);
	}
}
