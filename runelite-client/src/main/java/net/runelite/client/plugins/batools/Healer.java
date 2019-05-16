/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.batools;


import lombok.Getter;
import lombok.Setter;

import net.runelite.api.NPC;
import net.runelite.api.Actor;


class Healer
{

	@Getter
	private NPC npc;

	@Getter
	@Setter
	private int wave;

	@Getter
	@Setter
	private int spawnNumber;

	@Getter
	@Setter
	private int foodRemaining;

	@Getter
	@Setter
	private int lastFoodTime;

	@Getter
	@Setter
	private int firstCallFood;

	@Getter
	@Setter
	private int secondCallFood;

	Healer(NPC npc, int spawnNumber, int wave)
	{
		this.npc = npc;
		this.wave = wave;
		this.spawnNumber = spawnNumber;
		this.firstCallFood = getCode(wave).getFirstCallFood()[spawnNumber];
		this.secondCallFood = getCode(wave).getSecondCallFood()[spawnNumber];
		this.foodRemaining = firstCallFood + secondCallFood;
		this.lastFoodTime = getCode(wave).getSpacing()[spawnNumber];
	}

	private HealerCode getCode(int wave)
	{
		switch(wave)
		{
			case 1:
				return HealerCode.WAVEONE;
			case 2:
				return HealerCode.WAVETWO;
			case 3:
				return HealerCode.WAVETHREE;
			case 4:
				return HealerCode.WAVEFOUR;
			case 5:
				return HealerCode.WAVEFIVE;
			case 6:
				return HealerCode.WAVESIX;
			case 7:
				return HealerCode.WAVESEVEN;
			case 8:
				return HealerCode.WAVEEIGHT;
			case 9:
				return HealerCode.WAVENINE;
			case 10:
				return HealerCode.WAVETEN;
			default: return null;
		}
	}
}