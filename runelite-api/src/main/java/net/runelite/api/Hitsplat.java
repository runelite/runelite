/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.api;

import lombok.Getter;
import static net.runelite.api.HitsplatID.BLOCK_ME;
import static net.runelite.api.HitsplatID.BLOCK_OTHER;
import static net.runelite.api.HitsplatID.DAMAGE_MAX_ME;
import static net.runelite.api.HitsplatID.DAMAGE_MAX_ME_CYAN;
import static net.runelite.api.HitsplatID.DAMAGE_MAX_ME_ORANGE;
import static net.runelite.api.HitsplatID.DAMAGE_MAX_ME_WHITE;
import static net.runelite.api.HitsplatID.DAMAGE_MAX_ME_YELLOW;
import static net.runelite.api.HitsplatID.DAMAGE_MAX_ME_POISE;
import static net.runelite.api.HitsplatID.DAMAGE_ME;
import static net.runelite.api.HitsplatID.DAMAGE_ME_CYAN;
import static net.runelite.api.HitsplatID.DAMAGE_ME_ORANGE;
import static net.runelite.api.HitsplatID.DAMAGE_ME_WHITE;
import static net.runelite.api.HitsplatID.DAMAGE_ME_YELLOW;
import static net.runelite.api.HitsplatID.DAMAGE_ME_POISE;
import static net.runelite.api.HitsplatID.DAMAGE_OTHER;
import static net.runelite.api.HitsplatID.DAMAGE_OTHER_CYAN;
import static net.runelite.api.HitsplatID.DAMAGE_OTHER_ORANGE;
import static net.runelite.api.HitsplatID.DAMAGE_OTHER_WHITE;
import static net.runelite.api.HitsplatID.DAMAGE_OTHER_YELLOW;
import static net.runelite.api.HitsplatID.DAMAGE_OTHER_POISE;
import net.runelite.api.annotations.HitsplatType;

/**
 * A hitsplat that has been applied to an {@link Actor}.
 */
public class Hitsplat
{
	/**
	 * The type of hitsplat.
	 */
	@Getter(onMethod_ = {@HitsplatType})
	@HitsplatType
	private int hitsplatType;

	/**
	 * The value displayed by the hitsplat.
	 */
	@Getter
	private int amount;

	/**
	 * When the hitsplat will disappear.
	 */
	@Getter
	private int disappearsOnGameCycle;

	public Hitsplat(@HitsplatType int hitsplatType, int amount, int disappearsOnGameCycle)
	{
		this.hitsplatType = hitsplatType;
		this.amount = amount;
		this.disappearsOnGameCycle = disappearsOnGameCycle;
	}

	public boolean isMine()
	{
		switch (hitsplatType)
		{
			case BLOCK_ME:
			case DAMAGE_ME:
			case DAMAGE_ME_CYAN:
			case DAMAGE_ME_YELLOW:
			case DAMAGE_ME_ORANGE:
			case DAMAGE_ME_WHITE:
			case DAMAGE_ME_POISE:
			case DAMAGE_MAX_ME:
			case DAMAGE_MAX_ME_CYAN:
			case DAMAGE_MAX_ME_ORANGE:
			case DAMAGE_MAX_ME_YELLOW:
			case DAMAGE_MAX_ME_WHITE:
			case DAMAGE_MAX_ME_POISE:
				return true;
			default:
				return false;
		}
	}

	public boolean isOthers()
	{
		switch (hitsplatType)
		{
			case BLOCK_OTHER:
			case DAMAGE_OTHER:
			case DAMAGE_OTHER_CYAN:
			case DAMAGE_OTHER_YELLOW:
			case DAMAGE_OTHER_ORANGE:
			case DAMAGE_OTHER_WHITE:
			case DAMAGE_OTHER_POISE:
				return true;
			default:
				return false;
		}
	}
}