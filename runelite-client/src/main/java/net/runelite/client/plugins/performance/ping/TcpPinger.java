/*
 * Copyright (c) 2017, William Gray <wgray5093@gmail.com>
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
package net.runelite.client.plugins.performance.ping;

import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import net.runelite.client.RuneLite;
import static net.runelite.client.callback.Hooks.log;

/**
 * This functionality should only be used in developer mode
 * It is known to work but the load of the public user base using it may not be acceptable.
 */
public class TcpPinger implements Pinger
{
	public final boolean enabled;

	TcpPinger()
	{
		enabled = RuneLite.getOptions().has("developer-mode");
	}

	@Override
	public void startup()
	{
	}

	@Override
	public void shutdown()
	{
	}

	@Override
	public int ping(String address)
	{
		if (!enabled)
		{
			return -1;
		}

		InetAddress host;

		try
		{
			host = InetAddress.getByName(address);
		}
		catch (UnknownHostException he)
		{
			log.warn("Cannot ping host", he);
			return -1;
		}

		Instant start = Instant.now();

		// Java cannot use ping (via ICMP), use sockets instead
		try (Socket sock = new Socket(host, 443))
		{
			sock.setSoTimeout(5000);

			if (sock.isConnected())
			{
				return Math.toIntExact(ChronoUnit.MILLIS.between(start, Instant.now()));
			}

			log.warn("Host {} is not reachable", host);
		}
		catch (SocketTimeoutException e)
		{
			log.warn("Host {} timed out", host, e);
			return 5000;
		}
		catch (Exception e)
		{
			log.warn("Could not create new socket", e);
		}

		return -1;
	}
}
