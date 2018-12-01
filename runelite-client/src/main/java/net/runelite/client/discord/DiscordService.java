/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.discord;

import com.google.common.base.Strings;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.discord.events.DiscordDisconnected;
import net.runelite.client.discord.events.DiscordErrored;
import net.runelite.client.discord.events.DiscordJoinGame;
import net.runelite.client.discord.events.DiscordJoinRequest;
import net.runelite.client.discord.events.DiscordReady;
import net.runelite.client.discord.events.DiscordSpectateGame;
import net.runelite.client.eventbus.EventBus;
import net.runelite.discord.DiscordEventHandlers;
import net.runelite.discord.DiscordRPC;
import net.runelite.discord.DiscordRichPresence;

@Singleton
@Slf4j
public class DiscordService implements AutoCloseable
{
	@Inject
	private EventBus eventBus;

	@Inject
	private RuneLiteProperties runeLiteProperties;

	@Inject
	private ScheduledExecutorService executorService;

	private DiscordRPC discordRPC;

	/**
	 * Initializes the Discord service, sets up the event handlers and starts worker thread that will poll discord
	 * events every 2 seconds.
	 * Before closing the application it is recommended to call {@link #close()}
	 */
	public void init()
	{
		log.info("Initializing Discord RPC service.");

		try
		{
			discordRPC = DiscordRPC.INSTANCE;
		}
		catch (UnsatisfiedLinkError e)
		{
			log.warn("Failed to load Discord library, Discord support will be disabled.");
			return;
		}

		final DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers();
		discordEventHandlers.ready = this::ready;
		discordEventHandlers.disconnected = this::disconnected;
		discordEventHandlers.errored = this::errored;
		discordEventHandlers.joinGame = this::joinGame;
		discordEventHandlers.spectateGame = this::spectateGame;
		discordEventHandlers.joinRequest = this::joinRequest;
		discordRPC.Discord_Initialize(runeLiteProperties.getDiscordAppId(), discordEventHandlers, true, null);
		executorService.scheduleAtFixedRate(discordRPC::Discord_RunCallbacks, 0, 2, TimeUnit.SECONDS);
	}

	/**
	 * Shuts the RPC connection down.
	 * If not currently connected, this does nothing.
	 */
	@Override
	public void close()
	{
		if (discordRPC != null)
		{
			discordRPC.Discord_Shutdown();
		}
	}

	/**
	 * Updates the currently set presence of the logged in user.
	 * <br>Note that the client only updates its presence every <b>15 seconds</b>
	 * and queues all additional presence updates.
	 *
	 * @param discordPresence The new presence to use
	 */
	public void updatePresence(DiscordPresence discordPresence)
	{
		if (discordRPC == null)
		{
			return;
		}

		final DiscordRichPresence discordRichPresence = new DiscordRichPresence();
		discordRichPresence.state = discordPresence.getState();
		discordRichPresence.details = discordPresence.getDetails();
		discordRichPresence.startTimestamp = discordPresence.getStartTimestamp() != null
			? discordPresence.getStartTimestamp().getEpochSecond()
			: 0;
		discordRichPresence.endTimestamp = discordPresence.getEndTimestamp() != null
			? discordPresence.getEndTimestamp().getEpochSecond()
			: 0;
		discordRichPresence.largeImageKey = Strings.isNullOrEmpty(discordPresence.getLargeImageKey())
			? "default"
			: discordPresence.getLargeImageKey();
		discordRichPresence.largeImageText = discordPresence.getLargeImageText();
		discordRichPresence.smallImageKey = Strings.isNullOrEmpty(discordPresence.getSmallImageKey())
			? "default"
			: discordPresence.getSmallImageKey();
		discordRichPresence.smallImageText = discordPresence.getSmallImageText();
		discordRichPresence.partyId = discordPresence.getPartyId();
		discordRichPresence.partySize = discordPresence.getPartySize();
		discordRichPresence.partyMax = discordPresence.getPartyMax();
		discordRichPresence.matchSecret = discordPresence.getMatchSecret();
		discordRichPresence.joinSecret = discordPresence.getJoinSecret();
		discordRichPresence.spectateSecret = discordPresence.getSpectateSecret();
		discordRichPresence.instance = (byte) (discordPresence.isInstance() ? 1 : 0);

		log.debug("Sending presence update {}", discordPresence);
		discordRPC.Discord_UpdatePresence(discordRichPresence);
	}

	/**
	 * Clears the currently set presence.
	 */
	public void clearPresence()
	{
		if (discordRPC != null)
		{
			discordRPC.Discord_ClearPresence();
		}
	}

	/**
	 * Responds to the given user with the specified reply type.
	 *
	 * @param userId The id of the user to respond to
	 * @param reply  The reply type
	 */
	public void respondToRequest(String userId, DiscordReplyType reply)
	{
		if (discordRPC != null)
		{
			discordRPC.Discord_Respond(userId, reply.ordinal());
		}
	}

	private void ready()
	{
		log.info("Discord RPC service is ready.");
		eventBus.post(new DiscordReady());
	}

	private void disconnected(int errorCode, String message)
	{
		eventBus.post(new DiscordDisconnected(errorCode, message));
	}

	private void errored(int errorCode, String message)
	{
		eventBus.post(new DiscordErrored(errorCode, message));
	}

	private void joinGame(String joinSecret)
	{
		eventBus.post(new DiscordJoinGame(joinSecret));
	}

	private void spectateGame(String spectateSecret)
	{
		eventBus.post(new DiscordSpectateGame(spectateSecret));
	}

	private void joinRequest(net.runelite.discord.DiscordJoinRequest joinRequest)
	{
		eventBus.post(new DiscordJoinRequest(
			joinRequest.userId,
			joinRequest.username,
			joinRequest.discriminator,
			joinRequest.avatar));
	}
}
