/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
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
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Skill;
import net.runelite.api.SoundEffectID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.plugins.party.data.PartyTilePingData;
import net.runelite.client.plugins.party.messages.LocationUpdate;
import net.runelite.client.plugins.party.messages.SkillUpdate;
import net.runelite.client.plugins.party.messages.TilePing;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.ws.PartyMember;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;
import net.runelite.http.api.ws.messages.party.UserJoin;
import net.runelite.http.api.ws.messages.party.UserPart;
import net.runelite.http.api.ws.messages.party.UserSync;

@PluginDescriptor(
	name = "Party",
	description = "Shows useful information about current party"
)
@Slf4j
public class PartyPlugin extends Plugin implements KeyListener
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
	private KeyManager keyManager;

	@Inject
	private WSClient wsClient;

	@Inject
	private WorldMapPointManager worldMapManager;

	@Inject
	private PartyConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Getter
	private final Map<UUID, PartyData> partyDataMap = Collections.synchronizedMap(new HashMap<>());

	@Getter
	private final List<PartyTilePingData> pendingTilePings = Collections.synchronizedList(new ArrayList<>());

	private int lastHp, lastPray;
	private boolean hotkeyDown, doSync;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(PartyPluginService.class).to(PartyPluginServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(partyStatsOverlay);
		overlayManager.add(partyPingOverlay);
		wsClient.registerMessage(SkillUpdate.class);
		wsClient.registerMessage(TilePing.class);
		wsClient.registerMessage(LocationUpdate.class);
		keyManager.registerKeyListener(this);
		doSync = true; // Delay sync so eventbus can process correctly.
	}

	@Override
	protected void shutDown() throws Exception
	{
		partyDataMap.clear();
		pendingTilePings.clear();
		worldMapManager.removeIf(PartyWorldMapPoint.class::isInstance);
		overlayManager.remove(partyStatsOverlay);
		overlayManager.remove(partyPingOverlay);
		wsClient.unregisterMessage(SkillUpdate.class);
		wsClient.unregisterMessage(TilePing.class);
		wsClient.unregisterMessage(LocationUpdate.class);
		keyManager.unregisterKeyListener(this);
		hotkeyDown = false;
		doSync = false;
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
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(leaveMessage)
				.build());
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!hotkeyDown || client.isMenuOpen() || party.getMembers().isEmpty() || !config.pings())
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

			client.playSoundEffect(SoundEffectID.SMITH_ANVIL_TINK);
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

		final LocationUpdate locationUpdate = new LocationUpdate(client.getLocalPlayer().getWorldLocation());
		locationUpdate.setMemberId(localMember.getMemberId());
		wsClient.send(locationUpdate);
	}

	@Subscribe
	public void onGameTick(final GameTick event)
	{
		if (doSync && !party.getMembers().isEmpty())
		{
			// Request sync
			final UserSync userSync = new UserSync();
			userSync.setMemberId(party.getLocalMember().getMemberId());
			ws.send(userSync);
		}

		doSync = false;

		final int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int realHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		final int realPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final PartyMember localMember = party.getLocalMember();

		if (localMember != null)
		{
			if (currentHealth != lastHp)
			{
				final SkillUpdate update = new SkillUpdate(Skill.HITPOINTS, currentHealth, realHealth);
				update.setMemberId(localMember.getMemberId());
				ws.send(update);
			}

			if (currentPrayer != lastPray)
			{
				final SkillUpdate update = new SkillUpdate(Skill.PRAYER, currentPrayer, realPrayer);
				update.setMemberId(localMember.getMemberId());
				ws.send(update);
			}
		}

		lastHp = currentHealth;
		lastPray = currentPrayer;
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
			.append(partyData.getName())
			.append(" has joined the party!")
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.GAME)
			.runeLiteFormattedMessage(joinMessage)
			.build());

		final PartyMember localMember = party.getLocalMember();

		if (localMember != null && partyData.getMemberId().equals(localMember.getMemberId()))
		{
			final String helpMessage = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("To leave party hold SHIFT and right click party stats overlay.")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(helpMessage)
				.build());
		}
	}

	@Subscribe
	public void onUserSync(final UserSync event)
	{
		final int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int realHealth = client.getRealSkillLevel(Skill.HITPOINTS);
		final int realPrayer = client.getRealSkillLevel(Skill.PRAYER);
		final PartyMember localMember = party.getLocalMember();

		if (localMember != null)
		{
			final SkillUpdate hpUpdate = new SkillUpdate(Skill.HITPOINTS, currentHealth, realHealth);
			hpUpdate.setMemberId(localMember.getMemberId());
			ws.send(hpUpdate);

			final SkillUpdate prayUpdate = new SkillUpdate(Skill.PRAYER, currentPrayer, realPrayer);
			prayUpdate.setMemberId(localMember.getMemberId());
			ws.send(prayUpdate);
		}
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
					.append(removed.getName())
					.append(" has left the party!")
					.build();

				chatMessageManager.queue(QueuedMessage.builder()
					.type(ChatMessageType.GAME)
					.runeLiteFormattedMessage(joinMessage)
					.build());
			}

			worldMapManager.remove(removed.getWorldMapPoint());
		}
	}

	@Subscribe
	public void onPartyChanged(final PartyChanged event)
	{
		// Reset party
		partyDataMap.clear();
		pendingTilePings.clear();
		worldMapManager.removeIf(PartyWorldMapPoint.class::isInstance);
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
			final String name = memberById.getName();
			final WorldMapPoint worldMapPoint = new PartyWorldMapPoint(new WorldPoint(0, 0, 0), memberById);
			worldMapPoint.setTooltip(name);

			// When first joining a party, other members can join before getting a join for self
			PartyMember partyMember = party.getLocalMember();
			if (partyMember == null || !u.equals(partyMember.getMemberId()))
			{
				worldMapManager.add(worldMapPoint);
			}

			return new PartyData(u, name, worldMapPoint, ColorUtil.fromObject(name));
		});
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			hotkeyDown = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent keyEvent)
	{

	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		if (keyEvent.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			hotkeyDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		if (keyEvent.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			hotkeyDown = false;
		}
	}
}
