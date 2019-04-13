/*
 * Copyright (c) 2019 Atroolantra <https://github.com/Atrolantra>
 * Heavily adapted from the QuestListPlugin - (c) 2019 Spudjb <https://github.com/spudjb>
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
package net.runelite.client.plugins.musiclist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@PluginDescriptor(
	name = "Music List",
	description = "Adds searching and filtering to the music list"
)
@Slf4j
public class MusicListPlugin extends Plugin
{
	private static final String MENU_OPEN = "Open";
	private static final String MENU_CLOSE = "Close";

	private static final String MENU_TOGGLE = "Toggle";

	private static final String MENU_SEARCH = "Search";
	private static final String MENU_SHOW = "Show";

	@Inject
	private Client client;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	private ChatboxTextInput searchInput;
	private Widget musicSearchButton;
	private Widget musicHideButton;

	private Collection<MusicWidget> musicSet;

	private MusicState currentFilterState;

	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		if (e.getGameState() == GameState.LOGGING_IN)
		{
			currentFilterState = MusicState.ALL;
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.MUSIC_GROUP_ID)
		{
			Widget header = client.getWidget(WidgetInfo.MUSIC_WINDOW);

			if (header != null)
			{
				musicSearchButton = header.createChild(-1, WidgetType.GRAPHIC);
				musicSearchButton.setSpriteId(SpriteID.GE_SEARCH);
				musicSearchButton.setOriginalWidth(18);
				musicSearchButton.setOriginalHeight(17);
				musicSearchButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
				musicSearchButton.setOriginalX(5);
				musicSearchButton.setOriginalY(33);
				musicSearchButton.setHasListener(true);
				musicSearchButton.setAction(1, MENU_OPEN);
				musicSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
				musicSearchButton.setName(MENU_SEARCH);
				musicSearchButton.revalidate();

				musicHideButton = header.createChild(-1, WidgetType.GRAPHIC);
				redrawHideButton();

				musicHideButton.setOriginalWidth(13);
				musicHideButton.setOriginalHeight(13);
				musicHideButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
				musicHideButton.setOriginalX(24);
				musicHideButton.setOriginalY(36);
				musicHideButton.setHasListener(true);
				musicHideButton.setOnOpListener((JavaScriptCallback) e -> toggleHidden());
				musicHideButton.setAction(1, MENU_TOGGLE);
				musicHideButton.revalidate();

				if (!header.isHidden())
				{
					updateFilter();
				}
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		if (isChatboxOpen() && !isOnMusicTab())
		{
			chatboxPanelManager.close();
		}
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged)
	{
		if (varClientIntChanged.getIndex() == VarClientInt.INVENTORY_TAB.getIndex())
		{
			if (isChatboxOpen() && !isOnMusicTab())
			{
				chatboxPanelManager.close();
			}
		}
	}

	private void toggleHidden()
	{
		MusicState[] musicStates = MusicState.values();
		int nextState = (currentFilterState.ordinal() + 1) % musicStates.length;
		currentFilterState = musicStates[nextState];

		redrawHideButton();

		updateFilter();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void redrawHideButton()
	{
		musicHideButton.setSpriteId(currentFilterState.getSpriteId());
		musicHideButton.setName(MENU_SHOW + " " + currentFilterState.getName());
	}

	private boolean isOnMusicTab()
	{
		return client.getVar(VarClientInt.INVENTORY_TAB) == 13;
	}

	private boolean isChatboxOpen()
	{
		return searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;
	}

	private void closeSearch()
	{
		updateFilter("");
		chatboxPanelManager.close();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void openSearch()
	{
		updateFilter("");
		client.playSoundEffect(SoundEffectID.UI_BOOP);
		musicSearchButton.setAction(1, MENU_CLOSE);
		musicSearchButton.setOnOpListener((JavaScriptCallback) e -> closeSearch());
		searchInput = chatboxPanelManager.openTextInput("Search music list")
			.onChanged(s -> clientThread.invokeLater(() -> updateFilter(s)))
			.onClose(() ->
			{
				clientThread.invokeLater(() -> updateFilter(""));
				musicSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
				musicSearchButton.setAction(1, MENU_OPEN);
			})
			.build();
	}

	private void updateFilter()
	{
		String filter = "";
		if (isChatboxOpen())
		{
			filter = searchInput.getValue();
		}

		updateFilter(filter);
	}

	private void updateFilter(String filter)
	{
		filter = filter.toLowerCase();
		final Widget container = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST);

		if (container == null)
		{
			return;
		}

		updateList(filter);
	}

	private void updateList(String filter)
	{
		Widget trackList = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST);

		if (trackList == null)
		{
			return;
		}
		if (trackList.getChild(0).getText().equals("")) {
			return;
		}

		int prevScrollY = trackList.getScrollY();
		int prevScrollHeight = trackList.getScrollHeight();

		Collection<MusicWidget> tracks = musicSet;

		if (tracks != null)
		{
			// Check to make sure the list hasn't been rebuilt since we were last here
			// Do this by making sure the list's dynamic children are the same as when we last saw them
			if (tracks.stream().noneMatch(w ->
			{
				Widget codeWidget = w.getTrack();
				if (codeWidget == null)
				{
					return false;
				}
				return trackList.getChild(codeWidget.getIndex()) == codeWidget;
			}))
			{
				tracks = null;
			}
		}

		if (tracks == null)
		{
			// Find all of the track widgets that we care about, sorting by alphabetical order
			tracks = Arrays.stream(trackList.getChildren())
					.sorted(Comparator.comparing(Widget::getRelativeY))
					.filter(w -> !w.isSelfHidden())
					.map(w -> new MusicWidget(w, Text.removeTags(w.getText()).toLowerCase()))
					.collect(Collectors.toList());
			musicSet = tracks;
		}

		// Offset downwards
		int y = 3;
		for (MusicWidget trackInfo : tracks)
		{
			Widget track = trackInfo.getTrack();
			MusicState musicState = MusicState.getByColor(track.getTextColor());

			boolean hidden;
			if (!filter.isEmpty())
			{
				// If searching, show result regardless of filtered state
				hidden = !trackInfo.getTitle().contains(filter);
			}
			else
			{
				// Otherwise hide if it doesn't match the filter state
				hidden = currentFilterState != MusicState.ALL && musicState != currentFilterState;
			}

			track.setHidden(hidden);
			track.setOriginalY(y);
			track.revalidate();

			if (!hidden)
			{
				y += track.getHeight();
			}
		}

		trackList.setScrollHeight(y);

		// Set the new scrollbar position to the same relative list position.
		int newHeight = 0;
		if (trackList.getScrollHeight() > 0)
		{
			newHeight = (prevScrollY * trackList.getScrollHeight()) / prevScrollHeight;
		}

		client.runScript(
				ScriptID.UPDATE_SCROLLBAR,
				WidgetInfo.MUSIC_TRACK_SCROLLBAR.getId(),
				WidgetInfo.MUSIC_TRACK_LIST.getId(),
				newHeight
		);
	}

	@AllArgsConstructor
	@Getter
	private enum MusicState
	{
		NOT_UNLOCKED(0xff0000, "Not unlocked", SpriteID.MINIMAP_ORB_HITPOINTS),
		UNLOCKED(0xdc10d, "Unlocked", SpriteID.MINIMAP_ORB_HITPOINTS_POISON),
		ALL(0, "All", SpriteID.MINIMAP_ORB_PRAYER);

		private final int color;
		private final String name;
		private final int spriteId;

		static MusicState getByColor(int color)
		{
			for (MusicState value : values())
			{
				if (value.getColor() == color)
				{
					return value;
				}
			}

			return null;
		}
	}

	@Data
	@AllArgsConstructor
	private static class MusicWidget
	{
		private Widget track;
		private String title;
	}
}
