/*
 * Copyright (c) 2019, Anthony Chen <https://github.com/achencoms>
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientInt;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Music List",
	description = "Adds search and filter for the music list"
)
@Singleton
public class MusicListPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private EventBus eventBus;

	private ChatboxTextInput searchInput;

	private Widget musicSearchButton;
	private Widget musicFilterButton;

	private Collection<Widget> tracks;

	private MusicState currentMusicFilter = MusicState.ALL;

	@Override
	protected void startUp()
	{
		addSubscriptions();

		clientThread.invoke(this::addMusicButtons);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		Widget header = client.getWidget(WidgetInfo.MUSIC_WINDOW);
		if (header != null)
		{
			header.deleteAllChildren();
		}

		tracks = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(VarClientIntChanged.class, this, this::onVarClientIntChanged);
	}

	private void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Reset music filter on logout
			currentMusicFilter = MusicState.ALL;
			tracks = null;
		}
	}

	private void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.MUSIC_GROUP_ID)
		{
			tracks = null;
			// Reset filter state as the widget has been reloaded.
			// It is too early here to call updateFilter()
			currentMusicFilter = MusicState.ALL;
			addMusicButtons();
		}
	}

	private void addMusicButtons()
	{
		Widget header = client.getWidget(WidgetInfo.MUSIC_WINDOW);

		if (header == null)
		{
			return;
		}

		header.deleteAllChildren();

		//Creation of the search and toggle status buttons
		musicSearchButton = header.createChild(-1, WidgetType.GRAPHIC);
		musicSearchButton.setSpriteId(SpriteID.GE_SEARCH);
		musicSearchButton.setOriginalWidth(18);
		musicSearchButton.setOriginalHeight(17);
		musicSearchButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
		musicSearchButton.setOriginalX(5);
		musicSearchButton.setOriginalY(32);
		musicSearchButton.setHasListener(true);
		musicSearchButton.setAction(1, "Open");
		musicSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
		musicSearchButton.setName("Search");
		musicSearchButton.revalidate();

		musicFilterButton = header.createChild(-1, WidgetType.GRAPHIC);
		musicFilterButton.setSpriteId(SpriteID.MINIMAP_ORB_PRAYER);
		musicFilterButton.setOriginalWidth(15);
		musicFilterButton.setOriginalHeight(15);
		musicFilterButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
		musicFilterButton.setOriginalX(25);
		musicFilterButton.setOriginalY(34);
		musicFilterButton.setHasListener(true);
		musicFilterButton.setAction(1, "Toggle");
		musicFilterButton.setOnOpListener((JavaScriptCallback) e -> toggleStatus());
		musicFilterButton.setName("All");
		musicFilterButton.revalidate();
	}

	private void onVarClientIntChanged(VarClientIntChanged varClientIntChanged)
	{
		if (isChatboxOpen() && !isOnMusicTab())
		{
			chatboxPanelManager.close();
		}
	}

	private boolean isOnMusicTab()
	{
		return client.getVar(VarClientInt.INVENTORY_TAB) == 13;
	}

	private boolean isChatboxOpen()
	{
		return searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;
	}

	private String getChatboxInput()
	{
		return isChatboxOpen() ? searchInput.getValue() : "";
	}

	private void toggleStatus()
	{
		MusicState[] states = MusicState.values();
		currentMusicFilter = states[(currentMusicFilter.ordinal() + 1) % states.length];
		musicFilterButton.setSpriteId(currentMusicFilter.getSpriteID());
		musicFilterButton.setName(currentMusicFilter.getName());
		updateFilter(getChatboxInput());
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void openSearch()
	{
		updateFilter("");
		client.playSoundEffect(SoundEffectID.UI_BOOP);
		musicSearchButton.setAction(1, "Close");
		musicSearchButton.setOnOpListener((JavaScriptCallback) e -> closeSearch());
		searchInput = chatboxPanelManager.openTextInput("Search music list")
			.onChanged(s -> clientThread.invokeLater(() -> updateFilter(s.trim())))
			.onClose(() ->
			{
				clientThread.invokeLater(() -> updateFilter(""));
				musicSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
				musicSearchButton.setAction(1, "Open");
			})
			.build();
	}

	private void closeSearch()
	{
		updateFilter("");
		chatboxPanelManager.close();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void updateFilter(String input)
	{
		final Widget container = client.getWidget(WidgetInfo.MUSIC_WINDOW);
		final Widget musicList = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST);

		if (container == null || musicList == null)
		{
			return;
		}

		String filter = input.toLowerCase();
		updateList(musicList, filter);
	}

	private void updateList(Widget musicList, String filter)
	{
		if (tracks == null)
		{
			tracks = Arrays.stream(musicList.getDynamicChildren())
				.sorted(Comparator.comparing(Widget::getRelativeY))
				.collect(Collectors.toList());
		}

		tracks.forEach(w -> w.setHidden(true));

		Collection<Widget> relevantTracks = tracks.stream()
			.filter(w -> w.getText().toLowerCase().contains(filter))
			.filter(w -> currentMusicFilter == MusicState.ALL || w.getTextColor() == currentMusicFilter.getColor())
			.collect(Collectors.toList());

		// Original music track list has a little offset
		int y = 3;

		for (Widget track : relevantTracks)
		{
			track.setHidden(false);
			track.setOriginalY(y);
			track.revalidate();

			y += track.getHeight();
		}

		y += 3;

		int newHeight = 0;

		if (musicList.getScrollHeight() > 0)
		{
			newHeight = (musicList.getScrollY() * y) / musicList.getScrollHeight();
		}

		musicList.setScrollHeight(y);
		musicList.revalidateScroll();

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
		NOT_FOUND(0xff0000, "Locked", SpriteID.MINIMAP_ORB_HITPOINTS),
		FOUND(0xdc10d, "Unlocked", SpriteID.MINIMAP_ORB_HITPOINTS_POISON),
		ALL(0, "All", SpriteID.MINIMAP_ORB_PRAYER);

		private final int color;
		private final String name;
		private final int spriteID;
	}
}
