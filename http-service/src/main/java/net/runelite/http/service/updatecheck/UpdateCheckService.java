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
package net.runelite.http.service.updatecheck;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.service.worlds.WorldsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update-check")
public class UpdateCheckService
{
	private static final Logger logger = LoggerFactory.getLogger(UpdateCheckService.class);

	private static final Duration TIMEOUT = Duration.ofSeconds(5);

	private static final int PORT = 43594;
	private static final byte HANDSHAKE_TYPE = 15;

	private static final int RESPONSE_OK = 0;
	private static final int RESPONSE_OUTDATED = 6;

	private final WorldsService worldsService;
	private boolean updateAvailable;

	@Autowired
	public UpdateCheckService(WorldsService worldsService)
	{
		this.worldsService = worldsService;
	}

	@RequestMapping
	public Boolean check()
	{
		return updateAvailable;
	}

	@Scheduled(fixedDelay = 60_000)
	public void scheduledCheck()
	{
		updateAvailable = checkUpdate();
	}

	private int checkResponse(InetAddress address, int revision) throws IOException
	{
		try (Socket socket = new Socket())
		{
			socket.setSoTimeout((int) TIMEOUT.toMillis());
			socket.connect(new InetSocketAddress(address, PORT), (int) TIMEOUT.toMillis());

			ByteBuffer buffer = ByteBuffer.allocate(5);
			buffer.put(HANDSHAKE_TYPE);
			buffer.putInt(revision);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			os.write(buffer.array());

			int reply = is.read();
			return reply;
		}
	}

	private boolean checkUpdate()
	{
		World nextWorld = randomWorld();
		if (nextWorld == null)
		{
			return false;
		}

		InetAddress address;
		try
		{
			String url = nextWorld.getAddress();
			address = InetAddress.getByName(url);
		}
		catch (UnknownHostException ex)
		{
			logger.warn(null, ex);
			return false;
		}

		// Since mobile, the handshake server will handshake multiple revisions successfully,
		// so we can't assume that just because it says our revision is okay doesn't mean that
		// the client revision hasn't changed.
		int thisRevision = RuneLiteAPI.getRsVersion();
		int nextRevision = thisRevision + 1;

		try
		{
			int thisCode = checkResponse(address, thisRevision);
			int nextCode = checkResponse(address, nextRevision);

			if (thisCode == RESPONSE_OK && nextCode == RESPONSE_OUTDATED)
			{
				return false; // This is most up-to-date
			}

			return true; // Needs to be updated
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return false; // assume not updated
		}
	}

	private World randomWorld()
	{
		try
		{
			WorldResult worldResult = worldsService.getWorlds();
			List<World> worlds = worldResult.getWorlds();
			Random rand = new Random();
			return worlds.get(rand.nextInt(worlds.size()));
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
			return null;
		}
	}
}
