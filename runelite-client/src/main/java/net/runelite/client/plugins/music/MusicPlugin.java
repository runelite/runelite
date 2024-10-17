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
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
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
import net.runelite.api.ParamID;
import net.runelite.api.Player;
import net.runelite.api.Preferences;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.SettingID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.StructComposition;
import net.runelite.api.StructID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Component;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.annotations.Varp;
import net.runelite.api.events.AmbientSoundEffectCreated;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.PostStructComposition;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VolumeChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetConfig;
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
	private static final int SLIDER_HANDLE_SIZE = 16;

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

	private Channel musicChannel;
	private Channel effectChannel;
	private Channel areaChannel;
	private Channel[] channels;

	private ChatboxTextInput searchInput;

	private Widget musicSearchButton;
	private Widget musicFilterButton;

	private Collection<Widget> tracks;

	private MusicState currentMusicFilter = MusicState.ALL;

	private Tooltip sliderTooltip;
	private boolean shuttingDown = false;

	@Override
	protected void startUp()
	{
		clientThread.invoke(() ->
		{
			this.shuttingDown = false;

			Preferences preferences = client.getPreferences();
			musicChannel = new Channel("Music",
				VarPlayer.MUSIC_VOLUME, Varbits.MUTED_MUSIC_VOLUME,
				musicConfig::getMusicVolume, musicConfig::setMusicVolume,
				client::setMusicVolume, 255,
				ComponentID.SETTINGS_SIDE_MUSIC_SLIDER);
			effectChannel = new Channel("Sound Effects",
				VarPlayer.SOUND_EFFECT_VOLUME, Varbits.MUTED_SOUND_EFFECT_VOLUME,
				musicConfig::getSoundEffectVolume, musicConfig::setSoundEffectVolume,
				preferences::setSoundEffectVolume, 127,
				ComponentID.SETTINGS_SIDE_SOUND_EFFECT_SLIDER);
			areaChannel = new Channel("Area Sounds",
				VarPlayer.AREA_EFFECT_VOLUME, Varbits.MUTED_AREA_EFFECT_VOLUME,
				musicConfig::getAreaSoundEffectVolume, musicConfig::setAreaSoundEffectVolume,
				preferences::setAreaSoundEffectVolume, 127,
				ComponentID.SETTINGS_SIDE_AREA_SOUND_SLIDER);
			channels = new Channel[]{musicChannel, effectChannel, areaChannel};

			addMusicButtons();
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				if (musicConfig.granularSliders())
				{
					updateMusicOptions();
					resetSettingsWindow();
				}

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
		Widget header = client.getWidget(ComponentID.MUSIC_CONTAINER);
		if (header != null)
		{
			header.deleteAllChildren();
		}

		tracks = null;
		clientThread.invoke(() ->
		{
			shuttingDown = true;
			teardownMusicOptions();

			if (musicConfig.muteAmbientSounds())
			{
				// Reload the scene to reapply ambient sounds
				if (client.getGameState() == GameState.LOGGED_IN)
				{
					client.setGameState(GameState.LOADING);
				}
			}
		});
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
			currentMusicFilter = MusicState.ALL;
			tracks = null;
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
			tracks = null;
			// Reset filter state as the widget has been reloaded.
			// It is too early here to call updateFilter()
			currentMusicFilter = MusicState.ALL;
			addMusicButtons();
		}

		if ((widgetLoaded.getGroupId() == InterfaceID.SETTINGS || widgetLoaded.getGroupId() == InterfaceID.SETTINGS_SIDE)
			&& musicConfig.granularSliders())
		{
			updateMusicOptions();
		}
	}

	private void addMusicButtons()
	{
		Widget header = client.getWidget(ComponentID.MUSIC_CONTAINER);

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
		if (musicConfig.granularSliders())
		{
			updateMusicOptions();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals(MusicConfig.GROUP))
		{
			clientThread.invoke(() ->
			{
				if (MusicConfig.GRANULAR_SLIDERS.equals(configChanged.getKey()))
				{
					if (musicConfig.granularSliders())
					{
						updateMusicOptions();
						resetSettingsWindow();
					}
					else
					{
						teardownMusicOptions();
					}
				}
				else if (MusicConfig.MUTE_AMBIENT_SOUNDS.equals(configChanged.getKey()))
				{
					// Reload the scene to reapply ambient sounds
					if (client.getGameState() == GameState.LOGGED_IN)
					{
						client.setGameState(GameState.LOADING);
					}
				}
				else if (musicConfig.granularSliders())
				{
					updateMusicOptions();
				}
			});
		}
	}

	private boolean isOnMusicTab()
	{
		return client.getVarcIntValue(VarClientInt.INVENTORY_TAB) == 13;
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
		final Widget container = client.getWidget(ComponentID.MUSIC_CONTAINER);
		final Widget musicList = client.getWidget(ComponentID.MUSIC_LIST);
		final Widget scrollContainer = client.getWidget(ComponentID.MUSIC_SCROLL_CONTAINER);

		if (container == null || musicList == null)
		{
			return;
		}

		String filter = input.toLowerCase();
		updateList(scrollContainer, musicList, filter);
	}

	private void updateList(Widget scrollContainer, Widget musicList, String filter)
	{
		if (tracks == null)
		{
			tracks = Arrays.stream(musicList.getDynamicChildren())
				.sorted(Comparator.comparingInt(Widget::getRelativeY))
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

		if (scrollContainer.getScrollHeight() > 0)
		{
			newHeight = (scrollContainer.getScrollY() * y) / scrollContainer.getScrollHeight();
		}

		scrollContainer.setScrollHeight(y);
		scrollContainer.revalidateScroll();

		client.runScript(
			ScriptID.UPDATE_SCROLLBAR,
			ComponentID.MUSIC_SCROLLBAR,
			ComponentID.MUSIC_SCROLL_CONTAINER,
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
	private class Slider
	{
		@Getter
		protected final Channel channel;

		protected Widget track;
		protected Widget handle;

		public void update()
		{
			handle.setNoClickThrough(false);
			handle.setOnDragListener((JavaScriptCallback) this::drag);
			handle.setOnDragCompleteListener((JavaScriptCallback) this::drag);
			handle.setHasListener(true);

			track.setOnMouseRepeatListener((JavaScriptCallback) ev ->
			{
				int value = channel.getValue();
				int percent = (int) Math.round((value * 100.0 / channel.getMax()));

				sliderTooltip = new Tooltip(channel.getName() + ": " + percent + "%");
			});
			track.setOnClickListener((JavaScriptCallback) this::click);
			track.setHasListener(true);
		}

		public void shutDown()
		{
			if (handle != null)
			{
				handle.setDragParent(null);
				handle.setOnDragListener((Object[]) null);
				handle.setOnDragCompleteListener((Object[]) null);
			}
			if (track != null)
			{
				track.setOnMouseRepeatListener((Object[]) null);
				track.setOnClickListener((Object[]) null);
			}
		}

		protected void drag(ScriptEvent ev)
		{
			moveHandle(ev.getMouseX());
		}

		protected void click(ScriptEvent ev)
		{
			moveHandle(ev.getMouseX() - (SLIDER_HANDLE_SIZE / 2));
		}

		protected void moveHandle(int x)
		{
			int level = (x * channel.max) / getWidth();
			level = Ints.constrainToRange(level, 0, channel.max);
			channel.setLevel(level);

			int percent = (int) Math.round((level * 100.0 / channel.getMax()));
			sliderTooltip = new Tooltip(channel.getName() + ": " + percent + "%");
		}

		protected int getWidth()
		{
			return track.getWidth() - SLIDER_HANDLE_SIZE;
		}
	}

	private class SettingsSideSlider extends Slider
	{
		@Component
		private final int root;
		private Widget icon;

		SettingsSideSlider(Channel channel, @Component int root)
		{
			super(channel);
			this.root = root;
		}

		@Override
		public void update()
		{
			Widget root = client.getWidget(this.root);
			if (root == null)
			{
				return;
			}

			Object[] onLoad = root.getOnLoadListener();
			if (onLoad == null || onLoad.length != 6)
			{
				return;
			}

			this.icon = client.getWidget((Integer) onLoad[1]);
			this.track = client.getWidget((Integer) onLoad[2]);
			this.handle = client.getWidget((Integer) onLoad[3]);
			if (this.track == null || this.handle == null)
			{
				return;
			}

			Widget[] trackChildren = track.getChildren();

			if (trackChildren != null)
			{
				for (Widget w : trackChildren)
				{
					if (w != null)
					{
						w.setAction(0, null);
					}
				}
			}

			handle.setOnVarTransmitListener((Object[]) null);
			handle.setDragParent(track);
			handle.setSpriteId(SpriteID.SETTINGS_SLIDER_HANDLE_GREEN);
			super.update();

			int val = channel.getValue();
			handle.setOriginalX((val * getWidth()) / channel.getMax());
			handle.revalidate();

			// emulate [proc,settings_update_icon]
			boolean unmuted = val != 0;
			Widget strikethrough = icon.getChild(1);
			if (strikethrough != null)
			{
				strikethrough.setHidden(unmuted);
			}
			icon.setAction(0, unmuted ? "Mute" : "Unmute");
			// Set name + no tooltip; we have our own for ops
			icon.setName(channel.getName());
			icon.setOnMouseRepeatListener((Object[]) null);
			icon.setOnOpListener((JavaScriptCallback) ev -> channel.toggleMute());
			icon.setClickMask(0); // do not transmit op, it can get desynced from our state
		}

		@Override
		public void shutDown()
		{
			super.shutDown();

			if (this.handle != null)
			{
				handle.setSpriteId(SpriteID.SETTINGS_SLIDER_HANDLE_BLUE);
			}

			if (this.icon != null)
			{
				this.icon.setOnOpListener((Object[]) null);
				this.icon.setClickMask(WidgetConfig.transmitAction(0));
			}

			Widget root = client.getWidget(this.root);
			if (root != null)
			{
				client.createScriptEvent(root.getOnLoadListener())
					.setSource(root)
					.run();
			}

			this.handle = this.track = this.icon = null;
		}
	}

	private class SettingsSlider extends Slider
	{
		private final int offsetX;
		private final int offsetY;
		private final int width;
		private final Widget realTrack;

		SettingsSlider(Channel channel, Widget handle, Widget track, int width, int offsetY, int offsetX, Widget realTrack)
		{
			super(channel);
			this.handle = handle;
			this.track = track;
			this.width = width;
			this.offsetX = offsetX;
			this.offsetY = offsetY;
			this.realTrack = realTrack;
		}

		@Override
		public void update()
		{
			super.update();

			int val = channel.getValue();
			handle.setOriginalX(offsetX + (val * getWidth()) / channel.getMax());
			handle.setOriginalY(offsetY);
			handle.revalidate();
		}

		@Override
		protected int getWidth()
		{
			return width - SLIDER_HANDLE_SIZE;
		}

		@Override
		protected void click(ScriptEvent ev)
		{
			super.click(ev);
			realTrack.setOriginalX(offsetX);
			realTrack.setOriginalY(offsetY);
			realTrack.setOriginalWidth(this.width);
			realTrack.setOriginalHeight(SLIDER_HANDLE_SIZE);
			realTrack.revalidate();
		}

		@Override
		@SuppressWarnings("PMD.UselessOverridingMethod")
		public void shutDown()
		{
			// calling settings_init will do teardown for us
			super.shutDown();
		}
	}

	@Subscribe
	private void onPostStructComposition(PostStructComposition ev)
	{
		if (shuttingDown)
		{
			return;
		}

		StructComposition sc = ev.getStructComposition();
		switch (sc.getId())
		{
			case StructID.SETTINGS_MUSIC_VOLUME:
			case StructID.SETTINGS_EFFECT_VOLUME:
			case StructID.SETTINGS_AREA_VOLUME:
				if (!musicConfig.granularSliders())
				{
					return;
				}

				sc.setValue(ParamID.SETTING_SLIDER_STEPS, 1);
				sc.setValue(ParamID.SETTING_CUSTOM_TRANSMIT, 0);
				sc.setValue(ParamID.SETTING_FOREGROUND_CLICKZONE, 0);
				sc.setValue(ParamID.SETTING_SLIDER_CUSTOM_ONOP, 1);
				sc.setValue(ParamID.SETTING_SLIDER_CUSTOM_SETPOS, 1);
				sc.setValue(ParamID.SETTING_SLIDER_IS_DRAGGABLE, 1);
				sc.setValue(ParamID.SETTING_SLIDER_DEADZONE, 0);
				sc.setValue(ParamID.SETTING_SLIDER_DEADTIME, 0);
				break;
		}
	}

	@Subscribe
	private void onScriptPreFired(ScriptPreFired ev)
	{
		if (shuttingDown)
		{
			return;
		}

		if (ev.getScriptId() == ScriptID.SETTINGS_SLIDER_CHOOSE_ONOP)
		{
			if (!musicConfig.granularSliders())
			{
				return;
			}

			int arg = client.getIntStackSize() - 11;
			int[] is = client.getIntStack();
			Channel channel;
			switch (is[arg])
			{
				case SettingID.MUSIC_VOLUME:
					channel = musicChannel;
					break;
				case SettingID.EFFECT_VOLUME:
					channel = effectChannel;
					break;
				case SettingID.AREA_VOLUME:
					channel = areaChannel;
					break;
				default:
					return;
			}

			Widget track = client.getScriptActiveWidget();
			Widget handle = client.getWidget(is[arg + 1])
				.getChild(is[arg + 2]);
			Widget realTrack = client.getWidget(is[arg + 7]);
			SettingsSlider s = new SettingsSlider(channel, handle, track, is[arg + 3], is[arg + 4], is[arg + 5], realTrack);
			s.update();
			s.getChannel().setWindowSlider(s);
		}

		if (ev.getScriptId() == ScriptID.TOPLEVEL_REDRAW && musicConfig.granularSliders())
		{
			// we have to set the var to our value so toplevel_redraw doesn't try to set
			// the volume to what vanilla has stored
			for (Channel c : channels)
			{
				c.updateVar();
			}
		}
	}

	private class Channel
	{
		@Getter
		private final String name;
		@Varp
		private final int var;
		@Varbit
		private final int mutedVarbitId;
		private final IntSupplier getter;
		private final Consumer<Integer> setter;
		private final IntConsumer volumeChanger;

		@Getter
		private final int max;

		private final Slider sideSlider;

		@Setter
		private Slider windowSlider;

		Channel(String name,
				@Varp int var, @Varbit int mutedVarbitId,
				IntSupplier getter, Consumer<Integer> setter,
				IntConsumer volumeChanger, int max,
				@Component int sideRoot)
		{
			this.name = name;
			this.var = var;
			this.mutedVarbitId = mutedVarbitId;
			this.getter = getter;
			this.setter = setter;
			this.volumeChanger = volumeChanger;
			this.max = max;
			this.sideSlider = new SettingsSideSlider(this, sideRoot);
		}

		private int getValueRaw()
		{
			int value = getter.getAsInt();
			if (value == 0)
			{
				// Use the vanilla value

				// the varps are known by the engine and it requires they are stored so
				// 0 = max and 4 = muted
				int raw = client.getVarpValue(var);
				if (raw == 0)
				{
					raw = -client.getVarbitValue(mutedVarbitId);
				}
				value = raw * this.max / 100;

				// readd our 1 offset for unknown's place
				value += value < 0 ? -1 : 1;
			}

			return value;
		}

		private int getValue()
		{
			int value = getValueRaw();

			// muted with saved restore point
			if (value < 0)
			{
				return 0;
			}

			// 0 is used for unknown, so config values are 1 away from zero
			return value - 1;
		}

		public void toggleMute()
		{
			int val = -getValueRaw();
			if (val == -1)
			{
				// muted without a reset value
				val = max / 2;
			}
			setter.accept(val);
		}

		public void setLevel(int level)
		{
			setter.accept(level + 1);
			update();
		}

		public void update()
		{
			volumeChanger.accept(getValue());
			sideSlider.update();
			if (windowSlider != null)
			{
				windowSlider.update();
			}
		}

		public void updateVar()
		{
			int val = getValue();
			int varVal = Math.round(val / (max / 100.f));
			client.getVarps()[this.var] = varVal;
		}

		public void shutDown()
		{
			sideSlider.shutDown();
			if (windowSlider != null)
			{
				windowSlider.shutDown();
			}

			volumeChanger.accept(client.getVarpValue(var) * this.max / 100);
		}
	}

	private void updateMusicOptions()
	{
		for (Channel channel : channels)
		{
			channel.update();
		}
	}

	private void teardownMusicOptions()
	{
		// the side panel uses this too, so it has to run before they get shut down
		client.getStructCompositionCache().reset();

		for (Channel channel : channels)
		{
			channel.shutDown();
		}

		resetSettingsWindow();
	}

	private void resetSettingsWindow()
	{
		client.getStructCompositionCache().reset();

		Widget init = client.getWidget(ComponentID.SETTINGS_INIT);
		if (init != null)
		{
			// [clientscript, settings_init]
			client.createScriptEvent(init.getOnLoadListener())
				.setSource(init)
				.run();
		}
	}

	@Subscribe
	private void onBeforeRender(BeforeRender ev)
	{
		if (sliderTooltip != null)
		{
			tooltipManager.add(sliderTooltip);
		}
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		sliderTooltip = null;
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
}
