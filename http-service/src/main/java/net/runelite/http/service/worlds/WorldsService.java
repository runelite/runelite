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
import java.util.List;
import net.runelite.http.api.RuneliteAPI;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import spark.Request;
import spark.Response;

public class WorldsService
{
	private static final HttpUrl WORLD_URL = HttpUrl.parse("http://www.runescape.com/g=oldscape/slr.ws?order=LPWM");

	private HttpUrl url = WORLD_URL;

	public WorldResult listWorlds(Request request, Response response) throws IOException
	{
		WorldResult result = listWorlds();
		response.type("application/json");
		return result;
	}

	public WorldResult listWorlds() throws IOException
	{
		okhttp3.Request okrequest = new okhttp3.Request.Builder()
			.url(url)
			.build();

		okhttp3.Response okresponse = RuneliteAPI.CLIENT.newCall(okrequest).execute();
		byte[] b;

		try (ResponseBody body = okresponse.body())
		{
			b = body.bytes();
		}

		List<World> worlds = new ArrayList<>();
		ByteBuffer buf = ByteBuffer.wrap(b);

		int length = buf.getInt();
		buf.limit(length + 4);

		int num = buf.getShort() & 0xFFFF;

		for (int i = 0; i < num; ++i)
		{
			World world = new World();
			world.setId(buf.getShort() & 0xFFFF);
			world.setMask(buf.getInt());
			world.setAddress(readString(buf));
			world.setActivity(readString(buf));
			world.setLocation(buf.get() & 0xFF);
			world.setPlayers(buf.getShort() & 0xFFFF);

			worlds.add(world);
		}

		WorldResult result = new WorldResult();
		result.setWorlds(worlds);
		return result;
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
