/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.examine;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.eventbus.Subscribe;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.client.RuneLite;
import net.runelite.client.events.ChatMessage;
import net.runelite.client.events.GameStateChanged;
import net.runelite.client.events.MenuOptionClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.examine.ExamineClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Submits exammine info to the api
 *
 * @author Adam
 */
@PluginDescriptor(
	name = "Examine plugin"
)
public class ExaminePlugin extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(ExaminePlugin.class);

	private final RuneLite runelite = RuneLite.getRunelite();
	private final ExamineClient client = new ExamineClient();
	private final Deque<PendingExamine> pending = new ArrayDeque<>();
	private final Cache<CacheKey, Boolean> cache = CacheBuilder.newBuilder()
		.maximumSize(128L)
		.build();

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		pending.clear();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		ExamineType type;
		int id;
		switch (event.getMenuAction())
		{
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				id = event.getId();
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				id = event.getId() >>> 14;
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				id = event.getId();
				break;
			default:
				return;
		}

		PendingExamine pendingExamine = new PendingExamine(type, id, Instant.now());
		pending.push(pendingExamine);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		ExamineType type;
		switch (event.getType())
		{
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				break;
			default:
				return;
		}

		if (pending.isEmpty())
		{
			logger.debug("Got examine without a pending examine?");
			return;
		}

		PendingExamine pendingExamine = pending.pop();

		if (pendingExamine.getType() != type)
		{
			logger.debug("Type mismatch for pending examine: {} != {}", pendingExamine.getType(), type);
			pending.clear(); // eh
			return;
		}

		logger.debug("Got examine for {} {}: {}", pendingExamine.getType(), pendingExamine.getId(), event.getMessage());

		CacheKey key = new CacheKey(type, pendingExamine.getId());
		Boolean cached = cache.getIfPresent(key);
		if (cached != null)
		{
			return;
		}

		cache.put(key, Boolean.TRUE);

		ScheduledExecutorService executor = runelite.getExecutor();
		executor.submit(() -> submit(pendingExamine, event.getMessage()));
	}

	private void submit(PendingExamine examine, String text)
	{
		int id = examine.getId();

		try
		{
			switch (examine.getType())
			{
				case ITEM:
					client.submitItem(id, text);
					break;
				case OBJECT:
					client.submitObject(id, text);
					break;
				case NPC:
					client.submitNpc(id, text);
					break;
			}
		}
		catch (IOException ex)
		{
			logger.warn("Error submitting examine", ex);
		}
	}

}
