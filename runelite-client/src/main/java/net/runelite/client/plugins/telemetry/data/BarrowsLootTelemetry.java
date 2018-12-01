/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.telemetry.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.barrows.BarrowsBrothers;

@Getter
@ToString(callSuper = true)
public class BarrowsLootTelemetry extends EventLootTelemetry
{
	private final int rewardPotential;
	private final boolean diaryCompleted;
	private final List<String> killedBrothers = new ArrayList<>();

	public BarrowsLootTelemetry(Collection<ItemStack> items, Client client)
	{
		super(null, items);
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			if (client.getVar(brother.getKilledVarbit()) > 0)
			{
				killedBrothers.add(brother.getName());
			}
		}
		this.rewardPotential = (killedBrothers.size() * 2) + client.getVar(Varbits.BARROWS_REWARD_POTENTIAL);
		this.diaryCompleted = client.getVar(Varbits.DIARY_MORYTANIA_HARD) > 0;
	}
}
