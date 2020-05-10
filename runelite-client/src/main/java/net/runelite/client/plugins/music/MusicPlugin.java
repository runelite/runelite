/*
 * Copyright (c) 2019, Anthony Chen <https://github.com/achencoms>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, Sean Dewar <https://github.com/seandewar>
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
package net.runelite.client.plugins.music;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VolumeChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@PluginDescriptor(
	name = "Music",
	description = "Adds search and filter for the music list, and additional volume control",
	tags = {"sound", "volume"}
)
public class MusicPlugin extends Plugin
{
	private static final Set<Integer> SOURCELESS_PLAYER_SOUNDS = ImmutableSet.of(
		SoundEffectID.TELEPORT_VWOOP
	);

	private static final Set<Integer> PRAYER_SOUNDS = ImmutableSet.of(
		SoundEffectID.PRAYER_ACTIVATE_THICK_SKIN,
		SoundEffectID.PRAYER_ACTIVATE_BURST_OF_STRENGTH,
		SoundEffectID.PRAYER_ACTIVATE_CLARITY_OF_THOUGHT,
		SoundEffectID.PRAYER_ACTIVATE_SHARP_EYE_RIGOUR,
		SoundEffectID.PRAYER_ACTIVATE_MYSTIC_WILL_AUGURY,
		SoundEffectID.PRAYER_ACTIVATE_ROCK_SKIN,
		SoundEffectID.PRAYER_ACTIVATE_SUPERHUMAN_STRENGTH,
		SoundEffectID.PRAYER_ACTIVATE_IMPROVED_REFLEXES,
		SoundEffectID.PRAYER_ACTIVATE_RAPID_RESTORE_PRESERVE,
		SoundEffectID.PRAYER_ACTIVATE_RAPID_HEAL,
		SoundEffectID.PRAYER_ACTIVATE_PROTECT_ITEM,
		SoundEffectID.PRAYER_ACTIVATE_HAWK_EYE,
		SoundEffectID.PRAYER_ACTIVATE_MYSTIC_LORE,
		SoundEffectID.PRAYER_ACTIVATE_STEEL_SKIN,
		SoundEffectID.PRAYER_ACTIVATE_ULTIMATE_STRENGTH,
		SoundEffectID.PRAYER_ACTIVATE_INCREDIBLE_REFLEXES,
		SoundEffectID.PRAYER_ACTIVATE_PROTECT_FROM_MAGIC,
		SoundEffectID.PRAYER_ACTIVATE_PROTECT_FROM_MISSILES,
		SoundEffectID.PRAYER_ACTIVATE_PROTECT_FROM_MELEE,
		SoundEffectID.PRAYER_ACTIVATE_EAGLE_EYE,
		SoundEffectID.PRAYER_ACTIVATE_MYSTIC_MIGHT,
		SoundEffectID.PRAYER_ACTIVATE_RETRIBUTION,
		SoundEffectID.PRAYER_ACTIVATE_REDEMPTION,
		SoundEffectID.PRAYER_ACTIVATE_SMITE,
		SoundEffectID.PRAYER_ACTIVATE_CHIVALRY,
		SoundEffectID.PRAYER_ACTIVATE_PIETY,
		SoundEffectID.PRAYER_DEACTIVE_VWOOP
	);

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private MusicConfig musicConfig;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private TooltipManager tooltipManager;

	private ChatboxTextInput searchInput;

	private Widget musicSearchButton;
	private Widget musicFilterButton;

	private Collection<Widget> tracks;

	private MusicState currentMusicFilter = MusicState.ALL;

	private MusicSlider hoveredSlider;

	@Override
	protected void startUp()
	{
		clientThread.invoke(() ->
		{
			addMusicButtons();
			applyMusicVolumeConfig();
			updateMusicOptions();
		});
	}

	@Override
	protected void shutDown()
	{
		Widget header = client.getWidget(WidgetInfo.MUSIC_WINDOW);
		if (header != null)
		{
			header.deleteAllChildren();
		}

		tracks = null;
		hoveredSlider = null;
		clientThread.invoke(this::teardownMusicOptions);
	}

	@Provides
	MusicConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MusicConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Reset music filter on logout
			currentMusicFilter = MusicState.ALL;
			tracks = null;
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.MUSIC_GROUP_ID)
		{
			tracks = null;
			// Reset filter state as the widget has been reloaded.
			// It is too early here to call updateFilter()
			currentMusicFilter = MusicState.ALL;
			addMusicButtons();
		}
		if (widgetLoaded.getGroupId() == WidgetID.OPTIONS_GROUP_ID)
		{
			updateMusicOptions();
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

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged)
	{
		if (isChatboxOpen() && !isOnMusicTab())
		{
			chatboxPanelManager.close();
		}
	}

	@Subscribe
	public void onVolumeChanged(VolumeChanged volumeChanged)
	{
		applyMusicVolumeConfig();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("music"))
		{
			clientThread.invokeLater(this::applyMusicVolumeConfig);
		}
	}

	private void applyMusicVolumeConfig()
	{
		int musicVolume = musicConfig.getMusicVolume();
		if (musicVolume > 0)
		{
			client.setMusicVolume(musicVolume - 1);
		}

		int soundEffectVolume = musicConfig.getSoundEffectVolume();
		if (soundEffectVolume > 0)
		{
			client.setSoundEffectVolume(soundEffectVolume - 1);
		}

		int areaSoundEffectVolume = musicConfig.getAreaSoundEffectVolume();
		if (areaSoundEffectVolume > 0)
		{
			client.setAreaSoundEffectVolume(areaSoundEffectVolume - 1);
		}

		updateMusicOptions();
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
			.onDone(s -> false)
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

	@RequiredArgsConstructor
	@Getter
	private enum MusicSlider
	{
		MUSIC("Music", WidgetInfo.OPTIONS_MUSIC_SLIDER, VarPlayer.MUSIC_VOLUME, MusicConfig::getMusicVolume, MusicConfig::setMusicVolume, 255),
		AREA("Area Sounds", WidgetInfo.OPTIONS_AREA_SOUND_SLIDER, VarPlayer.AREA_EFFECT_VOLUME, MusicConfig::getAreaSoundEffectVolume, MusicConfig::setAreaSoundEffectVolume, 127),
		EFFECT("Sound Effects", WidgetInfo.OPTIONS_SOUND_EFFECT_SLIDER, VarPlayer.SOUND_EFFECT_VOLUME, MusicConfig::getSoundEffectVolume, MusicConfig::setSoundEffectVolume, 127);

		private final String name;
		private final WidgetInfo widgetID;
		private final VarPlayer var;
		private final ToIntFunction<MusicConfig> getter;
		private final BiConsumer<MusicConfig, Integer> setter;
		private final int max;

		@Setter
		private Widget handle;

		@Setter
		private Widget track;

		private static int PADDING = 8;

		private int getX()
		{
			return getTrack().getRelativeX() + PADDING;
		}

		private int getWidth()
		{
			return getTrack().getWidth() - (PADDING * 2) - handle.getWidth();
		}

		private int getValue(final MusicConfig config, final Client client)
		{
			int value = getter.applyAsInt(config) - 1;
			if (value <= -1)
			{
				// Use the vanilla value
				value = ((4 - client.getVar(var)) * max) / 4;
			}

			return value;
		}
	}

	private void teardownMusicOptions()
	{
		for (MusicSlider slider : MusicSlider.values())
		{
			Widget icon = client.getWidget(slider.getWidgetID());
			if (icon == null)
			{
				return;
			}

			if (slider.getHandle() != null)
			{
				{
					Widget handle = slider.getHandle();
					Widget parent = handle.getParent();
					if (parent == null)
					{
						continue;
					}
					else
					{
						Widget[] siblings = parent.getChildren();
						if (siblings == null || handle.getIndex() >= siblings.length || siblings[handle.getIndex()] != handle)
						{
							continue;
						}
						siblings[slider.getTrack().getIndex()] = null;
						siblings[handle.getIndex()] = null;
					}
				}

				Object[] init = icon.getOnLoadListener();
				init[1] = slider.getWidgetID().getId();

				// Readd the var transmit triggers and rerun options_allsounds
				client.runScript(init);
				slider.setHandle(null);
				slider.setTrack(null);
			}
		}
	}

	private void updateMusicOptions()
	{
		for (MusicSlider slider : MusicSlider.values())
		{
			Widget icon = client.getWidget(slider.getWidgetID());
			// VolumeChanged can trigger us before the sliders interface is fully valid, so
			//  we check if the width is set before we copy it to all of our widgets
			if (icon == null || icon.getWidth() == 0)
			{
				return;
			}

			Widget handle = slider.getHandle();
			if (handle != null)
			{
				Widget parent = handle.getParent();
				if (parent == null)
				{
					handle = null;
				}
				else
				{
					Widget[] siblings = parent.getChildren();
					if (siblings == null || handle.getIndex() >= siblings.length || siblings[handle.getIndex()] != handle)
					{
						handle = null;
					}
				}
			}
			if (handle == null)
			{
				Object[] init = icon.getOnLoadListener();
				icon.setVarTransmitTrigger((int[]) null);

				Widget track = icon.getParent().createChild(-1, WidgetType.TEXT);
				slider.setTrack(track);
				handle = icon.getParent().createChild(-1, WidgetType.GRAPHIC);
				slider.setHandle(handle);

				{
					// First widget of the track
					int wid = (Integer) init[2];
					Widget w = client.getWidget(WidgetInfo.TO_GROUP(wid), WidgetInfo.TO_CHILD(wid));

					track.setOriginalX(w.getRelativeX());
					track.setOriginalY(w.getRelativeY());
				}
				{
					// Last widget of the track
					int wid = (Integer) init[6];
					Widget w = client.getWidget(WidgetInfo.TO_GROUP(wid), WidgetInfo.TO_CHILD(wid));

					track.setOriginalWidth((w.getRelativeX() + w.getWidth()) - track.getOriginalX());
				}

				track.setOriginalHeight(16);
				track.setNoClickThrough(true);
				track.revalidate();

				handle.setSpriteId(SpriteID.OPTIONS_ZOOM_SLIDER_THUMB);
				handle.setOriginalWidth(16);
				handle.setOriginalHeight(16);
				handle.setClickMask(WidgetConfig.DRAG);
				handle.revalidate();

				handle.setOnMouseRepeatListener((JavaScriptCallback) ev -> hoveredSlider = slider);
				handle.setHasListener(true);

				JavaScriptCallback move = ev ->
				{
					int newVal = ((ev.getMouseX() - MusicSlider.PADDING - (slider.getHandle().getWidth() / 2)) * slider.getMax())
						/ slider.getWidth();
					if (newVal < 0)
					{
						newVal = 0;
					}
					if (newVal > slider.getMax())
					{
						newVal = slider.getMax();
					}

					// We store +1 so we can tell the difference between 0 and muted
					slider.getSetter().accept(musicConfig, newVal + 1);
					applyMusicVolumeConfig();
				};

				track.setOnClickListener(move);
				track.setOnHoldListener(move);
				track.setOnReleaseListener(move);
				track.setHasListener(true);

				client.runScript(ScriptID.OPTIONS_ALLSOUNDS, -1, init[2], init[3], init[4], init[5], init[6]);
			}

			final int value = slider.getValue(musicConfig, client);
			final int newX = ((value * slider.getWidth()) / slider.getMax()) + slider.getX();
			slider.getHandle().setOriginalX(newX);
			slider.getHandle().setOriginalY(slider.getTrack().getOriginalY());
			slider.getHandle().revalidate();
		}
	}

	@Subscribe
	public void onBeforeRender(final BeforeRender event)
	{
		// Tooltips are auto-cleared before each render frame; create a new updated one for this frame
		if (hoveredSlider != null)
		{
			final int value = hoveredSlider.getValue(musicConfig, client);
			final int percent = (int) Math.round((value * 100.0 / hoveredSlider.getMax()));

			tooltipManager.add(new Tooltip(hoveredSlider.getName() + ": " + percent + "%"));
			hoveredSlider = null;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent ev)
	{
		switch (ev.getEventName())
		{
			case "optionsAllSounds":
				// We have to override this script because it gets invoked periodically from the server
				client.getIntStack()[client.getIntStackSize() - 1] = -1;
		}
	}

	@Subscribe
	public void onAreaSoundEffectPlayed(AreaSoundEffectPlayed areaSoundEffectPlayed)
	{
		Actor source = areaSoundEffectPlayed.getSource();
		int soundId = areaSoundEffectPlayed.getSoundId();
		if (source == client.getLocalPlayer()
			&& musicConfig.muteOwnAreaSounds())
		{
			areaSoundEffectPlayed.consume();
		}
		else if (source != client.getLocalPlayer()
			&& (source instanceof Player || (source == null && SOURCELESS_PLAYER_SOUNDS.contains(soundId)))
			&& musicConfig.muteOtherAreaSounds())
		{
			areaSoundEffectPlayed.consume();
		}
		else if (source instanceof NPC
			&& musicConfig.muteNpcAreaSounds())
		{
			areaSoundEffectPlayed.consume();
		}
		else if (source == null
			&& !SOURCELESS_PLAYER_SOUNDS.contains(soundId)
			&& musicConfig.muteEnvironmentAreaSounds())
		{
			areaSoundEffectPlayed.consume();
		}
	}

	@Subscribe
	public void onSoundEffectPlayed(SoundEffectPlayed soundEffectPlayed)
	{
		if (musicConfig.mutePrayerSounds()
			&& PRAYER_SOUNDS.contains(soundEffectPlayed.getSoundId()))
		{
			soundEffectPlayed.consume();
		}
	}
}
