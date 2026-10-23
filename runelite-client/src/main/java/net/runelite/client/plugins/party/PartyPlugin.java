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

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.util.Providers;
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
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.Skill;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.events.PartyMemberAvatar;
import net.runelite.client.input.KeyManager;
import net.runelite.client.party.PartyDataService;
import net.runelite.client.party.PartyDataType;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.party.events.UserJoin;
import net.runelite.client.party.events.UserPart;
import net.runelite.client.party.messages.PartyData;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.party.data.PartyMemberData;
import net.runelite.client.plugins.party.data.PartyTilePingData;
import net.runelite.client.plugins.party.messages.MemberColorUpdate;
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
	private PartyDataService partyDataService;

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
	private PartyPluginService partyPluginService;

	@Inject
	@Named("developerMode")
	boolean developerMode;

	@Getter
	private final Map<Long, PartyMemberData> partyDataMap = Collections.synchronizedMap(new HashMap<>());

	@Getter
	private final List<PartyTilePingData> pendingTilePings = Collections.synchronizedList(new ArrayList<>());

	private Instant lastLogout;

	private PartyPanel panel;
	private NavigationButton navButton;

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
	public Module getPublicModule()
	{
		return b -> b.bind(PartyPluginService.class).toProvider(Providers.of(partyPluginService));
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

		overlayManager.add(partyPingOverlay);
		overlayManager.add(partyStatusOverlay);
		keyManager.registerKeyListener(hotkeyListener);
		wsClient.registerMessage(TilePing.class);
		wsClient.registerMessage(MemberColorUpdate.class);
		partyDataService.subscribe(this, PartyDataType.CHARACTER_NAME, PartyDataType.COORD, PartyDataType.ENERGY, PartyDataType.SPEC, PartyDataType.VENGEANCE);
		partyDataService.subscribe(this, Skill.HITPOINTS, Skill.PRAYER);
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
		partyDataService.unsubscribe(this, PartyDataType.values());
		partyDataService.unsubscribe(this, Skill.values());
		wsClient.unregisterMessage(TilePing.class);
		wsClient.unregisterMessage(MemberColorUpdate.class);
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
			if ("memberColor".equals(event.getKey()) && event.getOldValue() != null)
			{
				requestSync();
			}
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
	}

	@Subscribe
	public void onTilePing(TilePing event)
	{
		if (config.pings())
		{
			final PartyMemberData partyData = getPartyData(event.getMemberId());
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
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			checkIdle();
		}
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
	private void onMemberColorUpdate(MemberColorUpdate event)
	{
		final PartyMemberData partyData = getPartyData(event.getMemberId());
		if (partyData == null)
		{
			return;
		}

		partyData.setColor(event.getColor());

		SwingUtilities.invokeLater(() -> panel.updateMember(event.getMemberId()));
	}

	@Subscribe
	public void onPartyData(final PartyData event)
	{
		final PartyMember member = party.getMemberById(event.getMemberId());
		final PartyMemberData partyData = getPartyData(event.getMemberId());
		if (member != null && partyData != null)
		{
			partyData.getWorldMapPoint().setWorldPoint(member.getCoord());
		}

		SwingUtilities.invokeLater(() -> panel.updateMember(event.getMemberId()));
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
		Color c = getLocalMemberColor();
		if (c != null)
		{
			party.send(new MemberColorUpdate(c));
		}
	}

	@Subscribe
	public void onUserPart(final UserPart event)
	{
		final PartyMemberData removed = partyDataMap.remove(event.getMemberId());

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
	PartyMemberData getPartyData(final long uuid)
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

			PartyMemberData partyData = new PartyMemberData(uuid, worldMapPoint);

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
}
