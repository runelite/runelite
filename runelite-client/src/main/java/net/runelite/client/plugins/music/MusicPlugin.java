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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.ScriptID;
import net.runelite.api.SettingID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.events.AmbientSoundEffectCreated;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.DBTableID;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
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
		SoundEffectID.PRAYER_ACTIVATE_DEADEYE,
		SoundEffectID.PRAYER_ACTIVATE_MYSTIC_MIGHT,
		SoundEffectID.PRAYER_ACTIVATE_MYSTIC_VIGOUR,
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

	private String search = "";

	@Nullable
	private MusicState currentMusicFilter = null;

	private Tooltip sliderTooltip;

	private final Map<Integer, VolumeSlider> volumeSliders = new HashMap<>();

	@AllArgsConstructor
	private static class VolumeSlider
	{
		private final Widget widget;
		private final int varPlayerId;
		private final String name;
	}

	@Override
	protected void startUp()
	{
		clientThread.invoke(() ->
		{
			addMusicButtons();
			addTooltips();
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				if (musicConfig.muteAmbientSounds())
				{
					// Reload the scene to remove ambient sounds
					client.setGameState(GameState.LOADING);
				}
			}
		});
	}

	@Override
	protected void shutDown()
	{
		Widget header = client.getWidget(InterfaceID.Music.NOW_PLAYING);
		if (header != null)
		{
			header.deleteAllChildren();
		}

		currentMusicFilter = null;
		search = "";

		clientThread.invoke(() ->
		{
			removeTooltips();
			if (musicConfig.muteAmbientSounds())
			{
				// Reload the scene to reapply ambient sounds
				if (client.getGameState() == GameState.LOGGED_IN)
				{
					client.setGameState(GameState.LOADING);
				}
			}
		});
		sliderTooltip = null;
		volumeSliders.clear();
	}

	@Provides
	MusicConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MusicConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState gameState = gameStateChanged.getGameState();
		if (gameState == GameState.LOGIN_SCREEN)
		{
			// Reset music filter on logout
			currentMusicFilter = null;
			volumeSliders.clear();
		}
		else if (gameState == GameState.LOGGED_IN)
		{
			if (musicConfig.muteAmbientSounds())
			{
				client.getAmbientSoundEffects()
					.clear();
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == InterfaceID.MUSIC)
		{
			// Reset filter state as the widget has been reloaded.
			// It is too early here to call updateFilter()
			currentMusicFilter = null;
			addMusicButtons();
		}
		else if (widgetLoaded.getGroupId() == InterfaceID.SETTINGS_SIDE)
		{
			addTooltips();
		}
	}

	private void addMusicButtons()
	{
		Widget header = client.getWidget(InterfaceID.Music.NOW_PLAYING);

		if (header == null)
		{
			return;
		}

		header.deleteAllChildren();

		//Creation of the search and toggle status buttons
		musicSearchButton = header.createChild(-1, WidgetType.GRAPHIC)
			.setSpriteId(SpriteID.GeSmallicons.SEARCH)
			.setSize(18, 17)
			.setPos(5, 6, WidgetPositionMode.ABSOLUTE_RIGHT, WidgetPositionMode.ABSOLUTE_BOTTOM)
			.setName("Search")
			.setHasListener(true);
		musicSearchButton.setAction(1, "Open");
		musicSearchButton.setOnOpListener((JavaScriptCallback) e -> openSearch());
		musicSearchButton.revalidate();

		musicFilterButton = header.createChild(-1, WidgetType.GRAPHIC)
			.setSpriteId(SpriteID.OrbFiller.PRAYER)
			.setSize(15, 15)
			.setPos(25, 6, WidgetPositionMode.ABSOLUTE_RIGHT, WidgetPositionMode.ABSOLUTE_BOTTOM)
			.setName("All")
			.setHasListener(true);
		musicFilterButton.setAction(1, "Toggle");
		musicFilterButton.setOnOpListener((JavaScriptCallback) e -> toggleStatus());
		musicFilterButton.revalidate();

		updateFilterButton();
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
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(MusicConfig.GROUP))
		{
			clientThread.invoke(() ->
			{
				if (MusicConfig.MUTE_AMBIENT_SOUNDS.equals(configChanged.getKey()))
				{
					// Reload the scene to reapply ambient sounds
					if (client.getGameState() == GameState.LOGGED_IN)
					{
						client.setGameState(GameState.LOADING);
					}
				}
			});
		}
	}

	@Subscribe
	private void onVarbitChanged(VarbitChanged ev)
	{
		if (ev.getVarbitId() == VarbitID.SETTINGS_MUSIC_PLAYER_HIDE_TRACKS)
		{
			currentMusicFilter = null;
			updateFilterButton();
		}
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent ev)
	{
		if ("musicTrackFilter".equals(ev.getEventName()))
		{
			int override = -1;

			if (currentMusicFilter != null)
			{
				boolean unlocked = client.getIntStack()[client.getIntStackSize() - 1] != 0;
				switch (currentMusicFilter)
				{
					case ALL:
						override = 1;
						break;
					case LOCKED:
						override = unlocked ? 0 : 1;
						break;
					case UNLOCKED:
						override = unlocked ? 1 : 0;
						break;
				}
			}

			if (!Strings.isNullOrEmpty(search))
			{
				int dbrow = client.getIntStack()[client.getIntStackSize() - 2];
				var displayName = client.getDBTableField(dbrow, DBTableID.Music.COL_DISPLAYNAME, 0);
				if (displayName.length > 0 && !((String) displayName[0]).toLowerCase().contains(search))
				{
					override = 0;
				}
			}

			client.getIntStack()[client.getIntStackSize() - 3] = override;
		}
	}

	private boolean isOnMusicTab()
	{
		return client.getVarcIntValue(VarClientID.TOPLEVEL_PANEL) == 13;
	}

	private boolean isChatboxOpen()
	{
		return searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;
	}

	private void toggleStatus()
	{
		MusicState[] states = MusicState.values();

		if (currentMusicFilter == null)
		{
			int state = client.getVarbitValue(VarbitID.SETTINGS_MUSIC_PLAYER_HIDE_TRACKS);
			currentMusicFilter = states[state];
		}

		currentMusicFilter = states[(currentMusicFilter.ordinal() + 1) % states.length];
		updateFilterButton();
		client.playSoundEffect(SoundEffectID.UI_BOOP);

		redrawList();
	}

	private void updateFilterButton()
	{
		var filter = currentMusicFilter;
		if (filter == null)
		{
			int state = client.getVarbitValue(VarbitID.SETTINGS_MUSIC_PLAYER_HIDE_TRACKS);
			filter = MusicState.values()[state];
		}

		musicFilterButton.setSpriteId(filter.getSpriteID());
		musicFilterButton.setName(filter.getName());
	}

	private void redrawList()
	{
		var transmitListenerWidget = client.getWidget(InterfaceID.Music.INNER);
		if (transmitListenerWidget != null && transmitListenerWidget.getOnVarTransmitListener() != null)
		{
			client.runScript(transmitListenerWidget.getOnVarTransmitListener());
		}
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
		search = input.toLowerCase();
		redrawList();
	}

	@AllArgsConstructor
	@Getter
	private enum MusicState
	{
		ALL("All", SpriteID.OrbFiller.PRAYER),
		UNLOCKED("Unlocked", SpriteID.OrbFiller.HITPOINTS_POISON),
		LOCKED("Locked", SpriteID.OrbFiller.HITPOINTS),
		;

		private final String name;
		private final int spriteID;
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

	@Subscribe
	public void onAmbientSoundEffectCreated(AmbientSoundEffectCreated ev)
	{
		if (musicConfig.muteAmbientSounds())
		{
			client.getAmbientSoundEffects().clear();
		}
	}

	private void addTooltips()
	{
		volumeSliders.clear();
		addVolumeSlider(InterfaceID.SettingsSide.MUSIC_SLIDER_BOBBLE, VarPlayerID.OPTION_MUSIC, "Music");
		addVolumeSlider(InterfaceID.SettingsSide.MUSIC_ZOOM_CONTAINER, VarPlayerID.OPTION_MUSIC, "Music");

		addVolumeSlider(InterfaceID.SettingsSide.SOUND_SLIDER_BOBBLE, VarPlayerID.OPTION_SOUNDS, "Sound Effects");
		addVolumeSlider(InterfaceID.SettingsSide.SOUND_ZOOM_CONTAINER, VarPlayerID.OPTION_SOUNDS, "Sound Effects");

		addVolumeSlider(InterfaceID.SettingsSide.AREASOUNDS_SLIDER_BOBBLE, VarPlayerID.OPTION_AREASOUNDS, "Area Sounds");
		addVolumeSlider(InterfaceID.SettingsSide.AREASOUNDS_ZOOM_CONTAINER, VarPlayerID.OPTION_AREASOUNDS, "Area Sounds");

		addVolumeSlider(InterfaceID.SettingsSide.MASTER_SLIDER_BOBBLE, VarPlayerID.OPTION_MASTER_VOLUME, "Master Volume");
		addVolumeSlider(InterfaceID.SettingsSide.MASTER_ZOOM_CONTAINER, VarPlayerID.OPTION_MASTER_VOLUME, "Master Volume");
	}

	private void addVolumeSlider(int widgetId, int varPlayerId, String name)
	{
		Widget w = client.getWidget(widgetId);
		if (w != null)
		{
			volumeSliders.put(widgetId, new VolumeSlider(w, varPlayerId, name));
			w.setOnMouseRepeatListener((JavaScriptCallback) ev -> sliderTooltip = makeVolumeTooltip(varPlayerId, name));
		}
	}

	private void removeTooltips()
	{
		for (VolumeSlider slider : volumeSliders.values())
		{
			if (slider.widget != null)
			{
				slider.widget.setOnMouseRepeatListener((Object[]) null);
			}
		}
		volumeSliders.clear();
	}

	private Tooltip makeVolumeTooltip(int varPlayerId, String name)
	{
		int value = client.getVarpValue(varPlayerId);
		return new Tooltip(name + ": " + value + "%");
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		sliderTooltip = null;

		if (client.getMouseCurrentButton() != 0 && !volumeSliders.isEmpty())
		{
			Point mousePos = client.getMouseCanvasPosition();
			for (VolumeSlider slider : volumeSliders.values())
			{
				if (slider.widget != null && !slider.widget.isHidden() && slider.widget.getBounds().contains(mousePos.getX(), mousePos.getY()))
				{
					sliderTooltip = makeVolumeTooltip(slider.varPlayerId, slider.name);
					break;
				}
			}
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		if (sliderTooltip != null)
		{
			tooltipManager.add(sliderTooltip);
		}
	}

	@Subscribe
	private void onScriptPreFired(ScriptPreFired ev)
	{
		if (ev.getScriptId() == ScriptID.SETTINGS_SLIDER_CHOOSE_ONOP)
		{
			int arg = client.getIntStackSize() - 12;
			int[] is = client.getIntStack();
			int settingId = is[arg];
			Widget activeWidget = client.getScriptActiveWidget();

			if (activeWidget != null)
			{
				if (settingId == SettingID.MUSIC_VOLUME)
				{
					volumeSliders.put(activeWidget.getId(), new VolumeSlider(activeWidget, VarPlayerID.OPTION_MUSIC, "Music"));
				}
				else if (settingId == SettingID.EFFECT_VOLUME)
				{
					volumeSliders.put(activeWidget.getId(), new VolumeSlider(activeWidget, VarPlayerID.OPTION_SOUNDS, "Sound Effects"));
				}
				else if (settingId == SettingID.AREA_VOLUME)
				{
					volumeSliders.put(activeWidget.getId(), new VolumeSlider(activeWidget, VarPlayerID.OPTION_AREASOUNDS, "Area Sounds"));
				}
				else if (settingId == SettingID.MASTER_VOLUME)
				{
					volumeSliders.put(activeWidget.getId(), new VolumeSlider(activeWidget, VarPlayerID.OPTION_MASTER_VOLUME, "Master Volume"));
				}
			}
		}
		else if (ev.getScriptId() == ScriptID.SETTINGS_SLIDER_ONDRAG)
		{
			Widget activeWidget = client.getScriptActiveWidget();

			if (activeWidget != null)
			{
				VolumeSlider slider = volumeSliders.get(activeWidget.getId());
				if (slider != null)
				{
					sliderTooltip = makeVolumeTooltip(slider.varPlayerId, slider.name);
				}
			}
		}
	}
}
