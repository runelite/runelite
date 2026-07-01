/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.loottracker;

import java.time.Instant;
import java.util.Arrays;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.runelite.http.api.loottracker.LootRecordType;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"type", "name"})
class ConfigLoot
{
	LootRecordType type;
	String name;
	int kills;
	Instant first = Instant.now();
	Instant last;
	int[] drops;

	ConfigLoot(LootRecordType type, String name)
	{
		this.type = type;
		this.name = name;
		this.drops = new int[0];
	}

	void add(int id, int qty)
	{
		for (int i = 0; i < drops.length; i += 2)
		{
			if (drops[i] == id)
			{
				drops[i + 1] += qty;
				if (drops[i + 1] < 0)
				{
					drops[i + 1] = Integer.MAX_VALUE;
				}
				return;
			}
		}

		drops = Arrays.copyOf(drops, drops.length + 2);
		drops[drops.length - 2] = id;
		drops[drops.length - 1] = qty;
	}

	int numDrops()
	{
		return drops.length / 2;
	}
}
