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

public class Hitsplat
{
	public enum HitsplatType
	{
		BLOCK, // Blue
		DAMAGE, // Red
		POISON, // Green
		VENOM, // Darkgreen
		DISEASE, // Yellow
		HEAL; // Purple

		public static HitsplatType fromInteger(int type)
		{
			switch (type)
			{
				case 0: return BLOCK;
				case 1: return DAMAGE;
				case 2: return POISON;
				case 4: return DISEASE;
				case 5: return VENOM;
				case 6: return HEAL;
			}
			return null;
		}
	}

	@Getter
	private HitsplatType hitsplatType;

	@Getter
	private int amount;

	@Getter
	private int disappearsOnGameCycle;

	public Hitsplat(HitsplatType hitsplatType, int amount, int disappearsOnGameCycle)
	{
		this.hitsplatType = hitsplatType;
		this.amount = amount;
		this.disappearsOnGameCycle = disappearsOnGameCycle;
	}
}