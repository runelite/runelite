/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.streaming;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.WorldChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Streaming Plugin",
	description = "Hides your world",
	enabledByDefault = false
)
public class StreamingPlugin extends Plugin
{
	private static final int HIDDEN_WORLD = 1;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	private int oldWorld;

	@Override
	protected void startUp()
	{
		oldWorld = client.getWorld();
		client.setWorld(HIDDEN_WORLD);
	}

	@Override
	protected void shutDown()
	{
		client.setWorld(oldWorld);
	}

	@Subscribe
	public void onClanChanged(ClanChanged clanChanged)
	{
		if (clanChanged.isJoined())
		{
			// defer until full clan packet is parsed
			clientThread.invokeLater(() ->
			{
				ClanMember clanMember = client.getClanMember();
				if (clanMember != null)
				{
					clanMember.setWorld(HIDDEN_WORLD);
				}
			});
		}
	}

	@Subscribe
	public void onWorldChanged(WorldChanged worldChanged)
	{
		oldWorld = client.getWorld();
		client.setWorld(HIDDEN_WORLD);
	}
}
