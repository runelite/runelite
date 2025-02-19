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
import com.google.inject.Provides;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
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
	private static final String EDIT_TAGS_MENU_OPTION = "Edit Tags";

	@Inject
	private Client client;

	@Inject
	private FairyRingConfig config;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	private ChatboxTextInput searchInput = null;
	private ChatboxTextInput tagInput;
	private Widget searchBtn;
	private Collection<CodeWidgets> codes = null;

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

	@Override
	public void resetConfiguration()
	{
		List<String> extraKeys = configManager.getConfigurationKeys(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS);
		for (String prefix : extraKeys)
		{
			List<String> keys = configManager.getConfigurationKeys(prefix);
			for (String key : keys)
			{
				String[] str = key.split("\\.", 2);
				if (str.length == 2)
				{
					configManager.unsetConfiguration(str[0], str[1]);
				}
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setWidgetTextToDestination();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == InterfaceID.FAIRY_RING_PANEL)
		{
			setWidgetTextToDestination();

			Widget header = client.getWidget(ComponentID.FAIRY_RING_PANEL_HEADER);
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

	private void setWidgetTextToDestination()
	{
		Widget fairyRingTeleportButton = client.getWidget(ComponentID.FAIRY_RING_TELEPORT_BUTTON);
		if (fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden())
		{
			String destination;
			try
			{
				FairyRings fairyRingDestination = getFairyRingDestination(client.getVarbitValue(Varbits.FAIRY_RING_DIAL_ADCB),
					client.getVarbitValue(Varbits.FAIRY_RIGH_DIAL_ILJK), client.getVarbitValue(Varbits.FAIRY_RING_DIAL_PSRQ));
				destination = fairyRingDestination.getDestination();
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
		Widget fairyRingTeleportButton = client.getWidget(ComponentID.FAIRY_RING_TELEPORT_BUTTON);
		boolean fairyRingWidgetOpen = fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden();
		boolean searchInputBoxOpen = searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;
		boolean tagInputBoxOpen = tagInput != null && chatboxPanelManager.getCurrentInput() == tagInput;

		if (!fairyRingWidgetOpen && (searchInputBoxOpen || tagInputBoxOpen))
		{
			chatboxPanelManager.close();
		}
	}

	private void updateFilter(String input)
	{
		final String filter = input.toLowerCase();
		final Widget list = client.getWidget(ComponentID.FAIRY_RING_PANEL_LIST);
		final Widget favorites = client.getWidget(ComponentID.FAIRY_RING_PANEL_FAVORITES);

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

			if (favorites != null)
			{
				for (Widget w : favorites.getStaticChildren())
				{
					if (w.getId() == ComponentID.FAIRY_RING_PANEL_SEPARATOR)
					{
						continue;
					}

					// Favorites widgets are pre-allocated and hidden if the max of 4 favorites isn't reached
					if (w.getSpriteId() != -1 && !w.isSelfHidden())
					{
						codeMap.computeIfAbsent(w.getRelativeY(), k -> new CodeWidgets()).setFavorite(w);
					}
					else if (!Strings.isNullOrEmpty(w.getName()) && !w.isSelfHidden())
					{
						codeMap.computeIfAbsent(w.getRelativeY(), k -> new CodeWidgets()).setDescription(w);
					}
					else if (!Strings.isNullOrEmpty(w.getText()) && !w.isSelfHidden())
					{
						codeMap.computeIfAbsent(w.getRelativeY(), k -> new CodeWidgets()).setCode(w);
					}
				}
			}

			codes = codeMap.values();
		}

		// reset the separator widget
		Widget separator = client.getWidget(ComponentID.FAIRY_RING_PANEL_SEPARATOR);
		if (separator != null)
		{
			separator.setHidden(true);
			separator.setOriginalY(3);
		}

		// Relayout the panel
		int y = 0;
		CodeWidgets lastFavorite = null;
		boolean hasFavorites = false;
		boolean hasNormal = false;
		for (CodeWidgets c : codes)
		{
			String code = Text.removeTags(c.getDescription().getName()).replace(" ", "");
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
				|| tags != null && tags.contains(filter)
				|| getConfigTags(code).stream().anyMatch(s -> s.contains(filter)
			));

			// add padding to the first widget after the separator
			if (!hidden && lastFavorite != null && (c.getFavorite() == null || c.getFavorite().getSpriteId() == SpriteID.FAIRY_RING_ADD_FAVOURITE))
			{
				y += ENTRY_PADDING;
				lastFavorite = null;
			}

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

				if (c.getFavorite() != null && c.getFavorite().getSpriteId() == SpriteID.FAIRY_RING_REMOVE_FAVOURITE)
				{
					hasFavorites = true;
					lastFavorite = c;
				}
				else
				{
					hasNormal = true;
				}

				// if we have both favorites and standard items in the search results, show the separator
				if (hasFavorites && hasNormal)
				{
					separator.setHidden(false);
				}
			}
			else if (c.getFavorite() != null && c.getFavorite().getSpriteId() == SpriteID.FAIRY_RING_REMOVE_FAVOURITE)
			{
				// separator widget layouts from the bottom of the favorites container
				separator.setOriginalY(separator.getOriginalY() + c.getDescription().getHeight() + ENTRY_PADDING);
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
			ComponentID.FAIRY_RING_PANEL_SCROLLBAR,
			ComponentID.FAIRY_RING_PANEL_LIST,
			newHeight
		);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (WidgetUtil.componentToInterface(event.getActionParam1()) == InterfaceID.FAIRY_RING_PANEL &&
			event.getOption().equals("Use code"))
		{
			client.getMenu().createMenuEntry(-1)
				.setParam0(event.getActionParam0())
				.setParam1(event.getActionParam1())
				.setTarget(event.getTarget())
				.setOption(EDIT_TAGS_MENU_OPTION)
				.setType(MenuAction.RUNELITE)
				.setIdentifier(event.getIdentifier())
				.onClick(this::setTagMenuOpen);
		}
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.FAIRYRINGS_SORT_UPDATE && searchInput != null && tagInput == null)
		{
			clientThread.invokeLater(() -> updateFilter(searchInput.getValue()));
		}
	}

	private List<String> getConfigTags(String fairyRingCode)
	{
		String config = Optional.ofNullable(configManager.getConfiguration(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS, fairyRingCode)).orElse("").toLowerCase();
		return Text.fromCSV(config);
	}

	private void setConfigTags(String fairyRingCode, String tags)
	{
		if (Strings.isNullOrEmpty(tags))
		{
			configManager.unsetConfiguration(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS, fairyRingCode);
		}
		else
		{
			configManager.setConfiguration(FairyRingConfig.CONFIG_GROUP + '.' + FairyRingConfig.CONFIG_GROUP_TAGS, fairyRingCode, tags);
		}
	}

	private void setTagMenuOpen(MenuEntry menuEntry)
	{
		String code = Text.removeTags(menuEntry.getTarget()).replaceAll(" ", "");
		String initialValue = Text.toCSV(getConfigTags(code));
		client.playSoundEffect(SoundEffectID.UI_BOOP);
		tagInput = chatboxPanelManager.openTextInput("Code " + code + " tags:")
			.value(initialValue)
			.onDone(s ->
			{
				setConfigTags(code, s);
				if (config.autoOpen())
				{
					clientThread.invokeLater(this::openSearch);
				}
			})
			.build();
	}
}
