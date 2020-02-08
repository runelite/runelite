/*
 * Copyright (c) 2020 ThatGamerBlue
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
package net.runelite.client.plugins.effecttimers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayerSpellEffect
{
	BIND("Bind", 181, 8, false, TimerType.FREEZE),
	SNARE("Snare", 180, 16, false, TimerType.FREEZE),
	ENTANGLE("Entangle", 179, 24, false, TimerType.FREEZE),
	RUSH("Ice Rush", 361, 8, false, TimerType.FREEZE),
	BURST("Ice Burst", 363, 16, false, TimerType.FREEZE),
	BLITZ("Ice Blitz", 367, 24, false, TimerType.FREEZE),
	BARRAGE("Ice Barrage", 369, 32, false, TimerType.FREEZE),
	TELEBLOCK("Teleblock", 345, 500, true, TimerType.TELEBLOCK),
	VENG("Vengeance", 726, 50, false, TimerType.VENG),
	VENG_OTHER("Vengeance Other", 725, 50, false, TimerType.VENG),
	STAFF_OF_THE_DEAD("Staff of the Dead", 1288, 100, false, TimerType.SOTD);

	@Getter(AccessLevel.PACKAGE)
	private final String name;
	@Getter(AccessLevel.PACKAGE)
	private final int spotAnimId;
	@Getter(AccessLevel.PACKAGE)
	private final int timerLengthTicks;
	@Getter(AccessLevel.PACKAGE)
	private boolean halvable;
	@Getter(AccessLevel.PACKAGE)
	private final TimerType type;

	static PlayerSpellEffect getFromSpotAnim(int spotAnim)
	{
		for (PlayerSpellEffect effect : values())
		{
			if (effect.getSpotAnimId() == spotAnim)
			{
				return effect;
			}
		}
		return null;
	}
}
