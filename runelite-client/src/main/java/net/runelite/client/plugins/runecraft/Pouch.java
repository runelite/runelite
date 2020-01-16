/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2019 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.runecraft;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ItemID;

enum Pouch
{
	SMALL(3),
	MEDIUM(6, 3),
	LARGE(9, 7),
	GIANT(12, 9);

	private final int baseHoldAmount;
	private final int degradedBaseHoldAmount;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int holding;
	@Getter(AccessLevel.PACKAGE)
	private boolean degraded;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean unknown = true;

	Pouch(int holdAmount)
	{
		this(holdAmount, -1);
	}

	Pouch(int holdAmount, int degradedHoldAmount)
	{
		this.baseHoldAmount = holdAmount;
		this.degradedBaseHoldAmount = degradedHoldAmount;
	}

	static Pouch forItem(int itemId)
	{
		switch (itemId)
		{
			case ItemID.SMALL_POUCH:
				return SMALL;
			case ItemID.MEDIUM_POUCH:
			case ItemID.MEDIUM_POUCH_5511:
				return MEDIUM;
			case ItemID.LARGE_POUCH:
			case ItemID.LARGE_POUCH_5513:
				return LARGE;
			case ItemID.GIANT_POUCH:
			case ItemID.GIANT_POUCH_5515:
				return GIANT;
			default:
				return null;
		}
	}

	int getHoldAmount()
	{
		return degraded ? degradedBaseHoldAmount : baseHoldAmount;
	}

	int getRemaining()
	{
		final int holdAmount = degraded ? degradedBaseHoldAmount : baseHoldAmount;
		return holdAmount - holding;
	}

	void addHolding(int delta)
	{
		holding += delta;

		final int holdAmount = degraded ? degradedBaseHoldAmount : baseHoldAmount;
		if (holding < 0)
		{
			holding = 0;
		}
		if (holding > holdAmount)
		{
			holding = holdAmount;
		}
	}

	void degrade(boolean state)
	{
		if (state != degraded)
		{
			degraded = state;
			final int holdAmount = degraded ? degradedBaseHoldAmount : baseHoldAmount;
			holding = Math.min(holding, holdAmount);
		}
	}
}
