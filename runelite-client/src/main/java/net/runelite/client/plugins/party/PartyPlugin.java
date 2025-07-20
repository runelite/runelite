/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
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
import java.util.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.events.PartyMemberAvatar;
import net.runelite.client.input.KeyManager;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.party.events.UserJoin;
import net.runelite.client.party.events.UserPart;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.plugins.party.data.PartyTilePingData;
import net.runelite.client.plugins.party.messages.LocationUpdate;
import net.runelite.client.plugins.party.messages.StatusUpdate;
import net.runelite.client.plugins.party.messages.TilePing;
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
	@Inject
	private Client client;

	@Inject
	private PartyService party;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyPingOverlay partyPingOverlay;

	@Inject
	private PartyStatusOverlay partyStatusOverlay;

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
	@Named("developerMode")
	boolean developerMode;

	@Getter
	private final Map<Long, PartyData> partyDataMap = Collections.synchronizedMap(new HashMap<>());

	@Getter
	private final List<PartyTilePingData> pendingTilePings = Collections.synchronizedList(new ArrayList<>());

	private Instant lastLogout;

	private PartyPanel panel;
	private NavigationButton navButton;

	private WorldPoint lastLocation;
	private StatusUpdate lastStatus;

	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.pingHotkey())
	{
		@Override
		public void hotkeyPressed()
		{
			hotkeyPressed = true;
		}

		@Override
		public void hotkeyReleased()
		{
			hotkeyPressed = false;
		}
	};

	private boolean hotkeyPressed = false;

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

		overlayManager.add(partyPingOverlay);
		overlayManager.add(partyStatusOverlay);
		keyManager.registerKeyListener(hotkeyListener);
		wsClient.registerMessage(TilePing.class);
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
		pendingTilePings.clear();
		worldMapManager.removeIf(PartyWorldMapPoint.class::isInstance);
		overlayManager.remove(partyPingOverlay);
		overlayManager.remove(partyStatusOverlay);
		keyManager.unregisterKeyListener(hotkeyListener);
		wsClient.unregisterMessage(TilePing.class);
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
			hotkeyPressed = false;
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
		if (!hotkeyPressed || client.isMenuOpen() || !party.isInParty() || !config.pings())
		{
			return;
		}

		Tile selectedSceneTile = client.getSelectedSceneTile();
		if (selectedSceneTile == null)
		{
			return;
		}

		boolean isOnCanvas = false;

		for (MenuEntry menuEntry : client.getMenuEntries())
		{
			if (menuEntry == null)
			{
				continue;
			}

			if ("walk here".equalsIgnoreCase(menuEntry.getOption()))
			{
				isOnCanvas = true;
			}
		}

		if (!isOnCanvas)
		{
			return;
		}

		event.consume();
		final TilePing tilePing = new TilePing(selectedSceneTile.getWorldLocation());
		party.send(tilePing);
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

	@Subscribe
	public void onTilePing(TilePing event)
	{
		if (config.pings())
		{
			final PartyData partyData = getPartyData(event.getMemberId());
			final Color color = partyData != null ? partyData.getColor() : Color.RED;
			pendingTilePings.add(new PartyTilePingData(event.getPoint(), color));
		}

		if (config.sounds())
		{
			WorldPoint point = event.getPoint();

			if (point.getPlane() != client.getPlane() || !WorldPoint.isInScene(client, point.getX(), point.getY()))
			{
				return;
			}

			clientThread.invoke(() -> client.playSoundEffect(SoundEffectID.SMITH_ANVIL_TINK));
		}
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
		if (event.getMemberColor() != null)
		{
			partyData.setColor(event.getMemberColor());
		}

		final PartyMember member = party.getMemberById(event.getMemberId());
		if (event.getCharacterName() != null)
		{
			final String name = Text.removeTags(Text.toJagexName(event.getCharacterName()));
			if (!name.isEmpty())
			{
				member.setDisplayName(name);
				member.setLoggedIn(true);
			}
			else
			{
				member.setLoggedIn(false);
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
		final int runEnergy = (int) Math.ceil(client.getEnergy() / 1000.0) * 10; // flatten to reduce network load
		final int specEnergy = client.getVarpValue(VarPlayerID.SA_ENERGY) / 10;
		final boolean vengActive = client.getVarbitValue(VarbitID.VENGEANCE_REBOUND) == 1;
		final Color memberColor = getLocalMemberColor();

		final Player localPlayer = client.getLocalPlayer();
		final String characterName = Strings.nullToEmpty(localPlayer != null && client.getGameState().getState() >= GameState.LOADING.getState() ? localPlayer.getName() : null);

		boolean hasChange = false;
		boolean canDelay = !forceSend;
		final StatusUpdate update = new StatusUpdate();
		if (forceSend || !characterName.equals(lastStatus.getCharacterName()))
		{
			hasChange = true;
			update.setCharacterName(characterName);
		}
		if (forceSend || healthCurrent != lastStatus.getHealthCurrent())
		{
			hasChange = true;
			update.setHealthCurrent(healthCurrent);
		}
		if (forceSend || healthMax != lastStatus.getHealthMax())
		{
			hasChange = true;
			update.setHealthMax(healthMax);
		}
		if (forceSend || prayerCurrent != lastStatus.getPrayerCurrent())
		{
			hasChange = true;
			update.setPrayerCurrent(prayerCurrent);
		}
		if (forceSend || prayerMax != lastStatus.getPrayerMax())
		{
			hasChange = true;
			update.setPrayerMax(prayerMax);
		}
		if (forceSend || runEnergy != lastStatus.getRunEnergy())
		{
			hasChange = true;
			update.setRunEnergy(runEnergy);
		}
		if (forceSend || specEnergy != lastStatus.getSpecEnergy())
		{
			hasChange = true;
			canDelay = !forceSend && specEnergy - lastStatus.getSpecEnergy() == 10; // delay regen
			update.setSpecEnergy(specEnergy);
		}
		if (forceSend || vengActive != lastStatus.getVengeanceActive())
		{
			hasChange = true;
			update.setVengeanceActive(vengActive);
		}
		if (forceSend || !Objects.equals(memberColor, lastStatus.getMemberColor()))
		{
			hasChange = true;
			update.setMemberColor(memberColor);
		}

		if (canDelay && client.getTickCount() % messageFreq(party.getMembers().size()) != 0)
		{
			return;
		}

		if (hasChange)
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
				vengActive,
				memberColor
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
		pendingTilePings.clear();
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
		if (!developerMode || !commandExecuted.getCommand().equalsIgnoreCase("partyinfo"))
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

	private Color getLocalMemberColor()
	{
		Color memberColor = config.memberColor();
		if (memberColor == null)
		{
			PartyMember local = party.getLocalMember();
			if (local == null)
			{
				return null;
			}

			String localName = local.getDisplayName();
			memberColor = ColorUtil.fromObject(localName);
			log.debug("Computed member color {} for {}", memberColor, localName);
			config.setMemberColor(memberColor);
		}

		return memberColor;
	}

	private static int messageFreq(int partySize)
	{
		// introduce a tick delay for each member >6
		return Math.max(1, partySize - 6);
	}
}
