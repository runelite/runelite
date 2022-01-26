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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.SwingUtilities;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.discord.events.DiscordJoinRequest;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.events.PartyMemberAvatar;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.plugins.party.data.PartyTilePingData;
import net.runelite.client.plugins.party.messages.CharacterNameUpdate;
import net.runelite.client.plugins.party.messages.LocationUpdate;
import net.runelite.client.plugins.party.messages.SkillUpdate;
import net.runelite.client.plugins.party.messages.TilePing;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;
import net.runelite.http.api.ws.messages.party.UserJoin;
import net.runelite.http.api.ws.messages.party.UserPart;
import net.runelite.http.api.ws.messages.party.UserSync;

@PluginDescriptor(
	name = "Party",
	configName = "PartyPlugin2",
	description = "Party management and basic info",
	enabledByDefault = false
)
public class PartyPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private PartyService party;

	@Inject
	private WSClient ws;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyStatsOverlay partyStatsOverlay;

	@Inject
	private PartyPingOverlay partyPingOverlay;

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
	private DiscordService discordService;

	@Inject
	@Named("developerMode")
	boolean developerMode;

	@Getter
	private final Map<UUID, PartyData> partyDataMap = Collections.synchronizedMap(new HashMap<>());

	@Getter
	private final List<PartyTilePingData> pendingTilePings = Collections.synchronizedList(new ArrayList<>());

	private PartyPanel panel;
	private NavigationButton navButton;

	private int lastHp, lastPray;
	private String lastCharacterName = "";
	private WorldPoint lastLocation;
	private boolean sendAlert;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(PartyPluginService.class).to(PartyPluginServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		panel = injector.getInstance(PartyPanel.class);

		final BufferedImage icon = ImageUtil.loadImageResource(PartyPlugin.class, "panel_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Party")
			.icon(icon)
			.priority(9)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		overlayManager.add(partyStatsOverlay);
		overlayManager.add(partyPingOverlay);
		wsClient.registerMessage(SkillUpdate.class);
		wsClient.registerMessage(TilePing.class);
		wsClient.registerMessage(LocationUpdate.class);
		wsClient.registerMessage(CharacterNameUpdate.class);
		// Delay sync so the eventbus can register prior to the sync response
		SwingUtilities.invokeLater(this::requestSync);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);

		panel = null;

		partyDataMap.clear();
		pendingTilePings.clear();
		worldMapManager.removeIf(PartyWorldMapPoint.class::isInstance);
		overlayManager.remove(partyStatsOverlay);
		overlayManager.remove(partyPingOverlay);
		wsClient.unregisterMessage(SkillUpdate.class);
		wsClient.unregisterMessage(TilePing.class);
		wsClient.unregisterMessage(LocationUpdate.class);
		wsClient.unregisterMessage(CharacterNameUpdate.class);
		sendAlert = false;
		lastLocation = null;
	}

	@Provides
	public PartyConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PartyConfig.class);
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

		if (!config.messages())
		{
			return;
		}

		final String leaveMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("You have left the party.")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(leaveMessage)
			.build());
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(PartyConfig.GROUP))
		{
			final PartyMember localMember = party.getLocalMember();

			if (localMember != null)
			{
				if (config.includeSelf())
				{
					final PartyData partyData = getPartyData(localMember.getMemberId());
					assert partyData != null;
					SwingUtilities.invokeLater(() -> panel.addMember(partyData));
				}
				else
				{
					SwingUtilities.invokeLater(() -> panel.removeMember(localMember.getMemberId()));
				}
			}

			// rebuild the panel in the event the "Recolor names" option changes
			SwingUtilities.invokeLater(panel::updateAll);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!client.isKeyPressed(KeyCode.KC_SHIFT) || client.isMenuOpen() || party.getMembers().isEmpty() || !config.pings())
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
		tilePing.setMemberId(party.getLocalMember().getMemberId());
		wsClient.send(tilePing);
	}

	@Subscribe
	public void onDiscordJoinRequest(DiscordJoinRequest request)
	{
		final String requestMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("New join request received. Check your Party panel.")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(requestMessage)
			.build());

		String userName = request.getUsername() + "#" + request.getDiscriminator();
		SwingUtilities.invokeLater(() -> panel.addRequest(request.getUserId(), userName));
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		checkStateChanged(false);
	}

	public void replyToRequest(String userId, int reply)
	{
		discordService.respondToRequest(userId, reply);
		panel.removeRequest(userId);
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
	public void shareLocation()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final PartyMember localMember = party.getLocalMember();

		if (localMember == null)
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
		locationUpdate.setMemberId(localMember.getMemberId());
		wsClient.send(locationUpdate);
	}

	@Subscribe
	public void onGameTick(final GameTick event)
	{
		if (sendAlert && client.getGameState() == GameState.LOGGED_IN)
		{
			sendAlert = false;
			sendInstructionMessage();
		}

		checkStateChanged(false);
	}

	void requestSync()
	{
		if (!party.getMembers().isEmpty())
		{
			// Request sync
			final UserSync userSync = new UserSync();
			userSync.setMemberId(party.getLocalMember().getMemberId());
			ws.send(userSync);
		}
	}

	@Subscribe
	public void onCharacterNameUpdate(final CharacterNameUpdate event)
	{
		final PartyData partyData = getPartyData(event.getMemberId());

		if (partyData == null)
		{
			return;
		}

		String name = event.getCharacterName();
		name = Text.removeTags(Text.toJagexName(name));

		partyData.setCharacterName(name);
		SwingUtilities.invokeLater(() -> panel.updateMember(partyData.getMember().getMemberId()));
	}

	@Subscribe
	public void onSkillUpdate(final SkillUpdate event)
	{
		final PartyData partyData = getPartyData(event.getMemberId());

		if (partyData == null)
		{
			return;
		}

		if (event.getSkill() == Skill.HITPOINTS)
		{
			partyData.setHitpoints(event.getValue());
			partyData.setMaxHitpoints(event.getMax());
		}
		else if (event.getSkill() == Skill.PRAYER)
		{
			partyData.setPrayer(event.getValue());
			partyData.setMaxPrayer(event.getMax());
		}

		SwingUtilities.invokeLater(() -> panel.updateMember(partyData.getMember().getMemberId()));
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
		final PartyData partyData = getPartyData(event.getMemberId());

		if (partyData == null || !config.messages())
		{
			return;
		}

		final String joinMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(partyData.getMember().getName())
			.append(" has joined the party!")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(joinMessage)
			.build());

		final PartyMember localMember = party.getLocalMember();

		if (localMember != null && partyData.getMember().getMemberId().equals(localMember.getMemberId()))
		{
			sendAlert = true;
		}
	}

	@Subscribe
	public void onUserSync(final UserSync event)
	{
		checkStateChanged(true);
		lastLocation = null;
	}

	private void checkStateChanged(boolean forceSend)
	{
		final int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int realHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		final int realPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final PartyMember localMember = party.getLocalMember();

		final Player localPlayer = client.getLocalPlayer();
		final String characterName = Strings.nullToEmpty(localPlayer != null && client.getGameState().getState() >= GameState.LOADING.getState() ? localPlayer.getName() : null);

		if (localMember != null)
		{
			if (forceSend || currentHealth != lastHp)
			{
				final SkillUpdate update = new SkillUpdate(Skill.HITPOINTS, currentHealth, realHealth);
				update.setMemberId(localMember.getMemberId());
				ws.send(update);
			}

			if (forceSend || currentPrayer != lastPray)
			{
				final SkillUpdate update = new SkillUpdate(Skill.PRAYER, currentPrayer, realPrayer);
				update.setMemberId(localMember.getMemberId());
				ws.send(update);
			}

			if (forceSend || !characterName.equals(lastCharacterName))
			{
				final CharacterNameUpdate update = new CharacterNameUpdate(characterName);
				update.setMemberId(localMember.getMemberId());
				ws.send(update);
			}
		}

		lastHp = currentHealth;
		lastPray = currentPrayer;
		lastCharacterName = characterName;
	}

	@Subscribe
	public void onUserPart(final UserPart event)
	{
		final PartyData removed = partyDataMap.remove(event.getMemberId());

		if (removed != null)
		{
			if (config.messages())
			{
				final String joinMessage = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append(removed.getMember().getName())
					.append(" has left the party!")
					.build();

				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
					.runeLiteFormattedMessage(joinMessage)
					.build());
			}

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
			config.setPreviousPartyId(String.valueOf(event.getPartyId()));
		}

		SwingUtilities.invokeLater(() ->
		{
			panel.removeAllMembers();
			panel.removeAllRequests();
		});
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (!developerMode || !commandExecuted.getCommand().equals("partyinfo"))
		{
			return;
		}

		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value("Party " + party.getPartyId()).build());
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value("Local Party " + party.getLocalPartyId()).build());
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value("Local ID " + party.getLocalMember().getMemberId()).build());
		for (PartyMember partyMember : party.getMembers())
		{
			chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.GAMEMESSAGE).value(" " + partyMember.getName() + " " + partyMember.getMemberId()).build());
		}
	}

	@Subscribe
	public void onPartyMemberAvatar(PartyMemberAvatar event)
	{
		SwingUtilities.invokeLater(() -> panel.updateMember(event.getMemberId()));
	}

	@Nullable
	PartyData getPartyData(final UUID uuid)
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
			worldMapPoint.setTooltip(memberById.getName());

			// When first joining a party, other members can join before getting a join for self
			PartyMember partyMember = party.getLocalMember();

			boolean isSelf = partyMember != null && u.equals(partyMember.getMemberId());

			if (!isSelf)
			{
				worldMapManager.add(worldMapPoint);
			}

			PartyData partyData = new PartyData(memberById, worldMapPoint, ColorUtil.fromObject(memberById.getName()));
			partyData.setShowOverlay(config.autoOverlay());

			if (config.includeSelf() || !isSelf)
			{
				SwingUtilities.invokeLater(() -> panel.addMember(partyData));
			}
			else
			{
				SwingUtilities.invokeLater(panel::updateParty);
			}

			return partyData;
		});
	}

	private void sendInstructionMessage()
	{
		final String helpMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("To leave the party, click \"Leave party\" on the party panel.")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.FRIENDSCHATNOTIFICATION)
			.runeLiteFormattedMessage(helpMessage)
			.build());
	}
}
