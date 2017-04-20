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

import com.google.common.base.Suppliers;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.service.Service;
import net.runelite.http.service.worlds.WorldsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class UpdateCheckService
{
	private static final Logger logger = LoggerFactory.getLogger(UpdateCheckService.class);

	private static final int PORT = 43594;
	private static final int WORLD_OFFSET = 300;
	private static final byte HANDSHAKE_TYPE = 15;

	private static final int RESPONSE_OK = 0;
	private static final int RESPONSE_OUTDATED = 6;

	private final Service service;
	private final Supplier<Boolean> updateAvailable = Suppliers.memoizeWithExpiration(this::checkUpdate, 1, TimeUnit.MINUTES);

	public UpdateCheckService(Service service)
	{
		this.service = service;
	}

	public Boolean check(Request request, Response response)
	{
		return updateAvailable.get();
	}

	private boolean checkUpdate()
	{
		int nextWorld = randomWorld();
		if (nextWorld == -1)
		{
			return false;
		}

		InetAddress address;
		try
		{
			String url = "oldschool" + nextWorld + ".runescape.com";
			address = InetAddress.getByName(url);
		}
		catch (UnknownHostException ex)
		{
			logger.warn(null, ex);
			return false;
		}

		try (Socket socket = new Socket(address, PORT))
		{
			ByteBuffer buffer = ByteBuffer.allocate(5);
			buffer.put(HANDSHAKE_TYPE);
			buffer.putInt(RuneliteAPI.getRsVersion());

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			os.write(buffer.array());

			int reply = is.read();

			if (reply == RESPONSE_OUTDATED)
			{
				return true;
			}

			if (reply != RESPONSE_OK)
			{
				logger.debug("Non-ok response for handshake: {}", reply);
			}
		}
		catch (IOException ex)
		{
			logger.warn(null, ex);
		}

		return false; // no update
	}

	private int randomWorld()
	{
		WorldsService worldsService = service.getWorlds();

		try
		{
			WorldResult worlds = worldsService.listWorlds();
			int size = worlds.getWorlds().size();
			Random rand = new Random();
			int worldNumber = worlds.getWorlds().get(rand.nextInt(size)).getId();
			return worldNumber - WORLD_OFFSET;
		}
		catch (IOException | URISyntaxException ex)
		{
			logger.warn(null, ex);
			return -1;
		}
	}
}
