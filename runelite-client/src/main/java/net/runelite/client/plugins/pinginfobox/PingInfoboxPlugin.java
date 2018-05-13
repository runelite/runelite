/*
 * Copyright (c) 2018, William Gray <wgray5093@gmail.com>
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

package net.runelite.client.plugins.pinginfobox;

import java.net.InetAddress;
import java.net.Socket;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
		name = "Ping Infobox",
		enabledByDefault = false
)

public class PingInfoboxPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ScheduledExecutorService executor;

	private InetAddress host = null;

	private int start;

	private int ping;

	@Inject
	private PingInfoboxOverlay pingOverlay;

	@Override
	public List<Overlay> getOverlays()
	{
		return Arrays.asList(pingOverlay);
	}

	@Schedule(
			asynchronous = true,
			period = 5,
			unit = ChronoUnit.SECONDS
	)
	public int getPingToCurrentWorld() throws Exception
	{
		Exception ex;
		if (client.getGameState().equals(GameState.LOGGED_IN))
		{
			host = InetAddress.getByName(client.getWorldHostname());
			start = (int) System.currentTimeMillis();
			Socket sock = null;
			try
			{
				sock = new Socket(host, 443);
			}
			catch (Exception e)
			{
				ex = e;
			}
			finally
			{
				try
				{
					if (sock != null)
					{
						sock.close();
					}
				}
				catch (Exception e)
				{
				}
				if (sock != null && sock.isConnected())
				{
					ping = (int) System.currentTimeMillis() - start;
					return ping;
				}
				ex = new Exception(String.format("Host '%s' at '%s' is not reachable.", host));
			}
			throw ex;
		}
		return ping = -1;
	}

	public int getPing()
	{
		return ping;
	}
}
