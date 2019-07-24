/*
 * Copyright (c) 2018, Andrew EP | ElPinche256 <https://github.com/ElPinche256>
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
package net.runelite.client.plugins.warindicators;

import java.awt.Color;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;

@Singleton
public class WarIndicatorService
{
	private final Client client;
	private final WarIndicatorPlugin plugin;

	@Inject
	private WarIndicatorService(final Client client, final WarIndicatorPlugin plugin)
	{
		this.plugin = plugin;
		this.client = client;
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		if (!plugin.isHighlightSnipes() && !plugin.isHighLightCallers())
		{
			return;
		}

		if (plugin.isHighlightSnipes())
		{
			for (Player player : client.getPlayers())
			{
				if (player == null || player.getName() == null)
				{
					continue;
				}

				String[] targets = plugin.getGetTargetedSnipes().split(", ");

				for (String target : targets)
				{
					if (player.getName().equalsIgnoreCase(target))
					{
						consumer.accept(player, plugin.getGetSnipeColor());
					}
				}
			}
		}

		if (plugin.isHighLightCallers())
		{
			for (Player player : client.getPlayers())
			{
				if (player == null || player.getName() == null)
				{
					continue;
				}

				String[] callers = plugin.getGetActiveCallers().split(", ");

				for (String caller : callers)
				{
					if (player.getName().equalsIgnoreCase(caller))
					{
						consumer.accept(player, plugin.getGetCallerColor());
					}
				}
			}
		}
	}
}
