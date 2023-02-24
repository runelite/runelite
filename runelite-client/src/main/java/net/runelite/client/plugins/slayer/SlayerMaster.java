/*
 * Copyright (c) 2023, Macweese <https://github.com/Macweese>
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
package net.runelite.client.plugins.slayer;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import java.util.Arrays;

enum SlayerMaster
{
	NULL(0, ""),
	TURAEL_SPRIA(1, "Turael", "Spria"),
	MAZCHNA(2, "Mazchna"),
	VANNAKA(3, "Vannaka"),
	CHAELDAR(4, "Chaeldar"),
	DURADEL(5, "Duradel"),
	NIEVE_STEVE(6, "Nieve", "Steve"),
	KRYSTILIA(7, "Krystilia"),
	KONAR(8, "Konar"),
	;

	@Getter
	private final int index;
	@Getter
	private final String[] names;

	SlayerMaster(int index, String... names)
	{
		this.index = index;
		this.names = names;
	}

	static SlayerMaster getSlayerMaster(Client client)
	{
		return Arrays.stream(SlayerMaster.values())
				.filter(master -> master.getIndex() == client.getVarbitValue(Varbits.SLAYER_MASTER))
				.findFirst()
				.get();
	}
}
