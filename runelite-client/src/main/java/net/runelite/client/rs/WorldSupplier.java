/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.rs;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.RuneLiteProperties;
import net.runelite.http.api.worlds.World;
import net.runelite.client.game.WorldClient;
import net.runelite.http.api.worlds.WorldType;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

@Slf4j
@RequiredArgsConstructor
class WorldSupplier implements Supplier<World>
{
	private final OkHttpClient okHttpClient;
	private final Random random = new Random(System.nanoTime());
	private final Queue<World> worlds = new ArrayDeque<>();

	@Override
	public World get()
	{
		if (!worlds.isEmpty())
		{
			return worlds.poll();
		}

		try
		{
			List<World> newWorlds = new WorldClient(okHttpClient, HttpUrl.get(RuneLiteProperties.getApiBase()))
				.lookupWorlds()
				.getWorlds()
				.stream()
				.filter(w -> w.getTypes().isEmpty() || EnumSet.of(WorldType.MEMBERS).equals(w.getTypes()))
				.collect(Collectors.toList());

			Collections.shuffle(newWorlds, random);

			worlds.addAll(newWorlds.subList(0, 16));
		}
		catch (IOException e)
		{
			log.warn("Unable to retrieve world list", e);
		}

		while (worlds.size() < 2)
		{
			int id = random.nextInt(50) + 1;
			World world = World.builder()
				.id(300 + id) // worlds start at 300
				.address("oldschool" + id + ".runescape.COM")
				.build();
			worlds.add(world);
		}

		return worlds.poll();
	}
}
