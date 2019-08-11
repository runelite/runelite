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
package net.runelite.http.service.worlds;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class WorldsService
{
	private static final HttpUrl WORLD_URL = HttpUrl.parse("http://www.runescape.com/g=oldscape/slr.ws?order=LPWM");

	private HttpUrl url = WORLD_URL;

	public WorldResult getWorlds() throws IOException
	{
		Request okrequest = new Request.Builder()
			.url(url)
			.build();

		byte[] b;

		try (Response okresponse = RuneLiteAPI.CLIENT.newCall(okrequest).execute())
		{
			b = okresponse.body().bytes();
		}

		List<World> worlds = new ArrayList<>();
		ByteBuffer buf = ByteBuffer.wrap(b);

		int length = buf.getInt();
		buf.limit(length + 4);

		int num = buf.getShort() & 0xFFFF;

		for (int i = 0; i < num; ++i)
		{
			final World.WorldBuilder worldBuilder = World.builder()
				.id(buf.getShort() & 0xFFFF)
				.types(getTypes(buf.getInt()))
				.address(readString(buf))
				.activity(readString(buf))
				.location(buf.get() & 0xFF)
				.players(buf.getShort() & 0xFFFF);

			worlds.add(worldBuilder.build());
		}

		WorldResult result = new WorldResult();
		result.setWorlds(worlds);
		return result;
	}

	private static EnumSet<WorldType> getTypes(int mask)
	{
		EnumSet<WorldType> types = EnumSet.noneOf(WorldType.class);

		for (ServiceWorldType type : ServiceWorldType.values())
		{
			if ((mask & type.getMask()) != 0)
			{
				types.add(type.getApiType());
			}
		}

		return types;
	}

	private static String readString(ByteBuffer buf)
	{
		byte b;
		StringBuilder sb = new StringBuilder();

		for (;;)
		{
			b = buf.get();

			if (b == 0)
			{
				break;
			}

			sb.append((char) b);
		}

		return sb.toString();
	}

	public HttpUrl getUrl()
	{
		return url;
	}

	public void setUrl(HttpUrl url)
	{
		this.url = url;
	}
}
