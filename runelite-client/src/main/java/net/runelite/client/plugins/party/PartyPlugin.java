/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
 * Copyright (c) 2022, kamielvf <code@kamiel.dev>
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
package net.runelite.client.plugins.party;

import com.google.common.base.Strings;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.events.PartyMemberAvatar;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.party.events.UserJoin;
import net.runelite.client.party.events.UserPart;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.plugins.party.data.PartyPingData;
import net.runelite.client.plugins.party.messages.LocationUpdate;
import net.runelite.client.plugins.party.messages.StatusUpdate;
import net.runelite.client.plugins.party.messages.PartyPing;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Party",
	configName = "PartyPlugin2",
	description = "Party management and basic info",
	enabledByDefault = false
)
@Slf4j
public class PartyPlugin extends Plugin
{
	// deadzone (radius in px) within radial menu that will cancel out ping selection
	static final int PING_MENU_DEADZONE = 25;

	@Inject
	private Client client;

	@Inject
	@Getter(AccessLevel.PACKAGE)
	private PartyService party;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyPingOverlay partyPingOverlay;

	@Inject
	private PartyStatusOverlay partyStatusOverlay;

	@Inject
	private PartyPingSelectionOverlay partyPingSelectionOverlay;

	@Inject
	private WSClient wsClient;

	@Inject
	private WorldMapPointManager worldMapManager;

	@Inject
	private PartyConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	@Named("developerMode")
	boolean developerMode;

	@Getter
	private final Map<Long, PartyData> partyDataMap = Collections.synchronizedMap(new HashMap<>());

	@Getter
	private final List<PartyPingData> pendingPartyPings = Collections.synchronizedList(new ArrayList<>());

	private Instant lastLogout;

	private PartyPanel panel;
	private NavigationButton navButton;

	private WorldPoint lastLocation;
	private StatusUpdate lastStatus;

	@Getter(AccessLevel.PACKAGE)
	private Point mouseStartPosition;
	private PartyPingMouseListener pingMouseListener;

	@Getter(AccessLevel.PACKAGE)
	private PartyPing pendingPartyPing;

	@Setter
	@Getter(AccessLevel.PACKAGE)
	private boolean advancedPingMenuOpen = false;

	@Getter(AccessLevel.PACKAGE)
	private boolean pingHotkeyPressed = false;
	private final HotkeyListener pingHotkeyListener = new HotkeyListener(() -> config.pingHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			pingHotkeyPressed = true;
		}

		@Override
		public void hotkeyReleased()
		{
			pingHotkeyPressed = false;
		}
	};

	private boolean dangerHotkeyPressed = false;
	private final HotkeyListener dangerHotkeyListener = new HotkeyListener(() -> config.dangerPingHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			dangerHotkeyPressed = true;
		}

		@Override
		public void hotkeyReleased()
		{
			dangerHotkeyPressed = false;
		}
	};

	private boolean destinationHotkeyPressed = false;
	private final HotkeyListener destinationHotkeyListener = new HotkeyListener(() -> config.destinationPingHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			destinationHotkeyPressed = true;
		}

		@Override
		public void hotkeyReleased()
		{
			destinationHotkeyPressed = false;
		}
	};

	private boolean requestHotkeyPressed = false;
	private final HotkeyListener requestHotkeyListener = new HotkeyListener(() -> config.requestPingHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			requestHotkeyPressed = true;
		}

		@Override
		public void hotkeyReleased()
		{
			requestHotkeyPressed = false;
		}
	};
	
	private boolean questionHotkeyPressed = false;
	private final HotkeyListener questionHotkeyListener = new HotkeyListener(() -> config.questionPingHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			questionHotkeyPressed = true;
		}

		@Override
		public void hotkeyReleased()
		{
			questionHotkeyPressed = false;
		}
	};

	private boolean isHotkeyPressed()
	{
		return pingHotkeyPressed || dangerHotkeyPressed || destinationHotkeyPressed || requestHotkeyPressed || questionHotkeyPressed;
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(PartyPluginService.class).to(PartyPluginServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		lastLogout = Instant.now();
		panel = injector.getInstance(PartyPanel.class);

		final BufferedImage icon = ImageUtil.loadImageResource(PartyPlugin.class, "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Party")
			.icon(icon)
			.priority(9)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		pingMouseListener = new PartyPingMouseListener(client, this, config);
		mouseManager.registerMouseListener(pingMouseListener);
		overlayManager.add(partyPingOverlay);
		overlayManager.add(partyStatusOverlay);
		overlayManager.add(partyPingSelectionOverlay);
		keyManager.registerKeyListener(pingHotkeyListener);
		keyManager.registerKeyListener(questionHotkeyListener);
		keyManager.registerKeyListener(dangerHotkeyListener);
		keyManager.registerKeyListener(destinationHotkeyListener);
		keyManager.registerKeyListener(requestHotkeyListener);
		wsClient.registerMessage(PartyPing.class);
		wsClient.registerMessage(LocationUpdate.class);
		wsClient.registerMessage(StatusUpdate.class);
		// Delay sync so the eventbus can register prior to the sync response
		SwingUtilities.invokeLater(this::requestSync);
	}

	@Override
	protected void shutDown() throws Exception
	{
		lastLogout = null;
		clientToolbar.removeNavigation(navButton);

		panel = null;

		partyDataMap.clear();
		pendingPartyPings.clear();
		worldMapManager.removeIf(PartyWorldMapPoint.class::isInstance);
		mouseManager.unregisterMouseListener(pingMouseListener);
		pingMouseListener = null;
		overlayManager.remove(partyPingOverlay);
		overlayManager.remove(partyStatusOverlay);
		overlayManager.remove(partyPingSelectionOverlay);
		keyManager.unregisterKeyListener(pingHotkeyListener);
		keyManager.unregisterKeyListener(questionHotkeyListener);
		keyManager.unregisterKeyListener(dangerHotkeyListener);
		keyManager.unregisterKeyListener(destinationHotkeyListener);
		keyManager.unregisterKeyListener(requestHotkeyListener);
		wsClient.unregisterMessage(PartyPing.class);
		wsClient.unregisterMessage(LocationUpdate.class);
		wsClient.unregisterMessage(StatusUpdate.class);
		lastLocation = null;
		lastStatus = null;
	}

	@Provides
	public PartyConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PartyConfig.class);
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			pingHotkeyPressed = false;
			questionHotkeyPressed = false;
			dangerHotkeyPressed = false;
			destinationHotkeyPressed = false;
			requestHotkeyPressed = false;
		}
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked event)
	{
		if (event.getEntry().getMenuAction() == MenuAction.RUNELITE_OVERLAY &&
			event.getEntry().getTarget().equals("Party") &&
			event.getEntry().getOption().equals("Leave"))
		{
			leaveParty();
		}
	}

	void leaveParty()
	{
		party.changeParty(null);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(PartyConfig.GROUP))
		{
			partyStatusOverlay.updateConfig();
			// rebuild the panel in the event the "Recolor names" option changes
			SwingUtilities.invokeLater(panel::updateAll);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!isHotkeyPressed() || client.isMenuOpen() || !party.isInParty() || !config.pings())
		{
			return;
		}

		final Integer target;
		final PartyPingTargetType targetType;
		final WorldPoint location;

		switch(event.getMenuAction())
		{
			case NPC_FIRST_OPTION:
			case NPC_SECOND_OPTION:
			case NPC_THIRD_OPTION:
			case NPC_FOURTH_OPTION:
			case NPC_FIFTH_OPTION:
				targetType = PartyPingTargetType.NPC;
				target = event.getId();
				location = null;
				break;

			case GAME_OBJECT_FIRST_OPTION:
			case GAME_OBJECT_SECOND_OPTION:
			case GAME_OBJECT_THIRD_OPTION:
			case GAME_OBJECT_FOURTH_OPTION:
			case GAME_OBJECT_FIFTH_OPTION:
				targetType = PartyPingTargetType.OBJECT;
				target = event.getId();
				location = WorldPoint.fromScene(client, event.getParam0(), event.getParam1(), client.getPlane());
				break;

			case WALK:
				Tile selectedSceneTile = client.getSelectedSceneTile();
				if (selectedSceneTile == null)
				{
					return;
				}
				
				targetType = PartyPingTargetType.TILE;
				target = null;
				location = selectedSceneTile.getWorldLocation();
				break;

			default:
				log.debug("Ping attempt failed due to unhandled menu action {}", event.getMenuAction());
				return;
		}

		PartyPingType pingType =
			questionHotkeyPressed ? PartyPingType.QUESTION :
			dangerHotkeyPressed ? PartyPingType.DANGER :
			destinationHotkeyPressed ? PartyPingType.DESTINATION :
			requestHotkeyPressed ? PartyPingType.REQUEST :
			PartyPingType.TARGET; //default to target ping
		
		final PartyPing ping = new PartyPing(pingType, targetType, location, target, client.getWorld(), client.getLocalPlayer().getId());
		if (pingHotkeyPressed && config.advancedPingMenu())
		{
			mouseStartPosition = client.getMouseCanvasPosition();
			pendingPartyPing = ping;
		}
		else
		{
			party.send(ping);
		}

		event.consume();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			lastLogout = Instant.now();
		}

		checkStateChanged(false);
	}

	void resetPingMenu()
	{
		advancedPingMenuOpen = false;
		mouseStartPosition = null;
		pendingPartyPing = null;
	}

	private boolean pingIsSameSourceAndTarget(PartyPingData data, PartyPingData other)
	{
		if (data.getSourcePlayerIdx() != other.getSourcePlayerIdx() && data.getTargetType() != other.getTargetType())
		{
			return false;
		}

		if (data.getPoint() == null)
		{
			return other.getPoint() == null && data.getTargetActor() == other.getTargetActor() && data.getTargetObject() == other.getTargetObject();
		}

		return data.getPoint().equals(other.getPoint());
	}

	@Subscribe
	public void onPartyPing(PartyPing ping)
	{
		if (ping.getWorld() != client.getWorld() || !config.pings())
		{
			return;
		}
		
		PartyPingTargetType targetType = ping.getTargetType();
		if (targetType != PartyPingTargetType.NPC && (ping.getPoint().getPlane() != client.getPlane() || !WorldPoint.isInScene(client, ping.getPoint().getX(), ping.getPoint().getY())))
		{
			return;
		}

		Integer target = ping.getTarget();
		Color color = null;
		int soundId;
		WorldPoint point = null;
		Actor actor = null;
		TileObject object = null;

		switch (targetType)
		{
			case TILE:
				point = ping.getPoint();
				break;

			case NPC:
				actor = client.getCachedNPCs()[target];
				if (actor == null)
				{
					return;
				}
				break;

			case OBJECT:
				object = findTileObject(ping.getPoint(), target);
				if (object == null)
				{
					// couldn't find the object so target tile instead
					targetType = PartyPingTargetType.TILE;
					point = ping.getPoint();
				}
				break;
		}

		final PartyPingType type = ping.getPingType();
		switch (type)
		{
			case TARGET:
				color = config.targetPingColor();
				soundId = !config.targetPingSound() ? -1 :
						targetType == PartyPingTargetType.TILE ? type.getSoundId() : SoundEffectID.SOTE_BELL_HIGH_C;
				break;

			case QUESTION:
				color = config.questionPingColor();
				soundId = config.questionPingSound() ? type.getSoundId() : -1;
				break;

			case DANGER:
				color = config.dangerPingColor();
				soundId = config.dangerPingSound() ? type.getSoundId()  : -1;
				break;

			case DESTINATION:
				color = config.destinationPingColor();
				soundId = config.destinationPingSound() ? type.getSoundId()  : -1;
				break;

			case REQUEST:
				color = config.requestPingColor();
				soundId = config.requestPingSound() ? type.getSoundId()  : -1;
				break;

			default:
				log.debug("Received PartyPing with unhandled type: {}", type);
				return;
		}
		
		// if user has not set a color preference, use unique hash based color instead
		if (color == null)
		{
			final PartyData partyData = getPartyData(ping.getMemberId());
			color = partyData != null ? partyData.getColor() : Color.ORANGE;
		}

		final PartyPingData pingData = new PartyPingData(type, targetType, ping.getPlayerId(), actor, object, point, color);
		pendingPartyPings.removeIf(p -> pingIsSameSourceAndTarget(p, pingData));
		pendingPartyPings.add(pingData);

		if (soundId > -1)
		{
			clientThread.invoke(() -> client.playSoundEffect(soundId));
		}
	}

	private TileObject findTileObject(WorldPoint point, int objectId)
	{
		LocalPoint local = LocalPoint.fromWorld(client, point);
		Tile tile = client.getScene().getTiles()[client.getPlane()][local.getSceneX()][local.getSceneY()];
		if (tile == null)
		{
			return null;
		}
		
		if (tile.getWallObject() != null && tile.getWallObject().getId() == objectId)
		{
			return tile.getWallObject();
		}
		
		if (tile.getDecorativeObject() != null && tile.getDecorativeObject().getId() == objectId)
		{
			return tile.getDecorativeObject();
		}

		for (GameObject gameObject : tile.getGameObjects())
		{
			if (gameObject != null && gameObject.getId() == objectId)
			{
				return gameObject;
			}
		}

		return null;
	}

	@Schedule(
		period = 10,
		unit = ChronoUnit.SECONDS
	)
	public void scheduledTick()
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			shareLocation();
		}
		else if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			checkIdle();
		}
	}

	private void shareLocation()
	{
		if (!party.isInParty())
		{
			return;
		}

		WorldPoint location = client.getLocalPlayer().getWorldLocation();
		if (location.equals(lastLocation))
		{
			return;
		}

		lastLocation = location;

		final LocationUpdate locationUpdate = new LocationUpdate(location);
		party.send(locationUpdate);
	}

	private void checkIdle()
	{
		if (lastLogout != null && lastLogout.isBefore(Instant.now().minus(30, ChronoUnit.MINUTES))
			&& party.isInParty())
		{
			log.info("Leaving party due to inactivity");
			party.changeParty(null);
		}
	}

	@Subscribe
	public void onGameTick(final GameTick event)
	{
		checkStateChanged(false);
	}

	void requestSync()
	{
		if (party.isInParty())
		{
			// Request sync
			final UserSync userSync = new UserSync();
			party.send(userSync);
		}
	}

	@Subscribe
	public void onStatusUpdate(final StatusUpdate event)
	{
		final PartyData partyData = getPartyData(event.getMemberId());
		if (partyData == null)
		{
			return;
		}

		if (event.getHealthCurrent() != null)
		{
			partyData.setHitpoints(event.getHealthCurrent());
		}
		if (event.getHealthMax() != null)
		{
			partyData.setMaxHitpoints(event.getHealthMax());
		}
		if (event.getPrayerCurrent() != null)
		{
			partyData.setPrayer(event.getPrayerCurrent());
		}
		if (event.getPrayerMax() != null)
		{
			partyData.setMaxPrayer(event.getPrayerMax());
		}
		if (event.getRunEnergy() != null)
		{
			partyData.setRunEnergy(event.getRunEnergy());
		}
		if (event.getSpecEnergy() != null)
		{
			partyData.setSpecEnergy(event.getSpecEnergy());
		}
		if (event.getVengeanceActive() != null)
		{
			partyData.setVengeanceActive(event.getVengeanceActive());
		}

		final PartyMember member = party.getMemberById(event.getMemberId());
		if (event.getCharacterName() != null)
		{
			final String name = Text.removeTags(Text.toJagexName(event.getCharacterName()));
			if (!name.isEmpty())
			{
				member.setDisplayName(name);
				member.setLoggedIn(true);
				partyData.setColor(ColorUtil.fromObject(name));
			}
			else
			{
				member.setLoggedIn(false);
				partyData.setColor(Color.WHITE);
			}
		}

		SwingUtilities.invokeLater(() -> panel.updateMember(event.getMemberId()));
	}

	@Subscribe
	public void onLocationUpdate(final LocationUpdate event)
	{
		final PartyData partyData = getPartyData(event.getMemberId());

		if (partyData == null)
		{
			return;
		}

		partyData.getWorldMapPoint().setWorldPoint(event.getWorldPoint());
	}

	@Subscribe
	public void onUserJoin(final UserJoin event)
	{
		// this has a side effect of creating the party data
		getPartyData(event.getMemberId());
	}

	@Subscribe
	public void onUserSync(final UserSync event)
	{
		clientThread.invokeLater(() -> checkStateChanged(true));
		lastLocation = null;
	}

	private void checkStateChanged(boolean forceSend)
	{
		if (lastStatus == null)
		{
			forceSend = true;
		}

		if (!party.isInParty())
		{
			return;
		}

		final int healthCurrent = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int prayerCurrent = client.getBoostedSkillLevel(Skill.PRAYER);
		final int healthMax = client.getRealSkillLevel(Skill.HITPOINTS);
		final int prayerMax = client.getRealSkillLevel(Skill.PRAYER);
		final int runEnergy = (int) Math.ceil(client.getEnergy() / 10.0) * 10; // flatten to reduce network load
		final int specEnergy = client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT) / 10;
		final boolean vengActive = client.getVarbitValue(Varbits.VENGEANCE_ACTIVE) == 1;

		final Player localPlayer = client.getLocalPlayer();
		final String characterName = Strings.nullToEmpty(localPlayer != null && client.getGameState().getState() >= GameState.LOADING.getState() ? localPlayer.getName() : null);

		boolean shouldSend = false;
		final StatusUpdate update = new StatusUpdate();
		if (forceSend || !characterName.equals(lastStatus.getCharacterName()))
		{
			shouldSend = true;
			update.setCharacterName(characterName);
		}
		if (forceSend || healthCurrent != lastStatus.getHealthCurrent())
		{
			shouldSend = true;
			update.setHealthCurrent(healthCurrent);
		}
		if (forceSend || healthMax != lastStatus.getHealthMax())
		{
			shouldSend = true;
			update.setHealthMax(healthMax);
		}
		if (forceSend || prayerCurrent != lastStatus.getPrayerCurrent())
		{
			shouldSend = true;
			update.setPrayerCurrent(prayerCurrent);
		}
		if (forceSend || prayerMax != lastStatus.getPrayerMax())
		{
			shouldSend = true;
			update.setPrayerMax(prayerMax);
		}
		if (forceSend || runEnergy != lastStatus.getRunEnergy())
		{
			shouldSend = true;
			update.setRunEnergy(runEnergy);
		}
		if (forceSend || specEnergy != lastStatus.getSpecEnergy())
		{
			shouldSend = true;
			update.setSpecEnergy(specEnergy);
		}
		if (forceSend || vengActive != lastStatus.getVengeanceActive())
		{
			shouldSend = true;
			update.setVengeanceActive(vengActive);
		}

		if (shouldSend)
		{
			party.send(update);
			// non-null values for next-tick comparison
			lastStatus = new StatusUpdate(
				characterName,
				healthCurrent,
				healthMax,
				prayerCurrent,
				prayerMax,
				runEnergy,
				specEnergy,
				vengActive
			);
		}
	}

	@Subscribe
	public void onUserPart(final UserPart event)
	{
		final PartyData removed = partyDataMap.remove(event.getMemberId());

		if (removed != null)
		{
			worldMapManager.remove(removed.getWorldMapPoint());

			SwingUtilities.invokeLater(() -> panel.removeMember(event.getMemberId()));
		}
	}

	@Subscribe
	public void onPartyChanged(final PartyChanged event)
	{
		// Reset party
		partyDataMap.clear();
		pendingPartyPings.clear();
		worldMapManager.removeIf(PartyWorldMapPoint.class::isInstance);

		if (event.getPartyId() != null)
		{
			config.setPreviousPartyId(event.getPassphrase());
		}

		SwingUtilities.invokeLater(panel::removeAllMembers);
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (!developerMode || !commandExecuted.getCommand().equals("partyinfo"))
		{
			return;
		}

		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value("Party " + party.getPartyPassphrase() + " ID " + party.getPartyId()).build());
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value("Local ID " + party.getLocalMember().getMemberId()).build());
		for (PartyMember partyMember : party.getMembers())
		{
			chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value("Member " + partyMember.getDisplayName() + " " + partyMember.getMemberId()).build());
		}
	}

	@Subscribe
	public void onPartyMemberAvatar(PartyMemberAvatar event)
	{
		SwingUtilities.invokeLater(() -> panel.updateMember(event.getMemberId()));
	}

	@Nullable
	PartyData getPartyData(final long uuid)
	{
		final PartyMember memberById = party.getMemberById(uuid);

		if (memberById == null)
		{
			// This happens when you are not in party but you still receive message.
			// Can happen if you just left party and you received message before message went through
			// in ws service
			return null;
		}

		return partyDataMap.computeIfAbsent(uuid, (u) ->
		{
			final WorldMapPoint worldMapPoint = new PartyWorldMapPoint(new WorldPoint(0, 0, 0), memberById);

			// When first joining a party, other members can join before getting a join for self
			PartyMember partyMember = party.getLocalMember();

			boolean isSelf = partyMember != null && u.equals(partyMember.getMemberId());

			if (!isSelf)
			{
				worldMapManager.add(worldMapPoint);
			}

			PartyData partyData = new PartyData(uuid, worldMapPoint);

			SwingUtilities.invokeLater(() -> panel.addMember(partyData));
			return partyData;
		});
	}
}
