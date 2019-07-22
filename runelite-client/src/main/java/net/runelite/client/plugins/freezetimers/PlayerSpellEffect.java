/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
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
package net.runelite.client.plugins.freezetimers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayerSpellEffect
{
	BIND("Bind", 181, 4800, true, 0, TimerType.FREEZE),
	SNARE("Snare", 180, 9600, true, 1, TimerType.FREEZE),
	ENTANGLE("Entangle", 179, 14400, true, 2, TimerType.FREEZE),
	RUSH("Ice Rush", 361, 4800, false, 3, TimerType.FREEZE),
	BURST("Ice Burst", 363, 9600, false, 4, TimerType.FREEZE),
	BLITZ("Ice Blitz", 367, 14400, false, 5, TimerType.FREEZE),
	BARRAGE("Ice Barrage", 369, 19200, false, 6, TimerType.FREEZE),
	TELEBLOCK("Teleblock", 345, 300000, true, 7, TimerType.TELEBLOCK),
	VENG("Vengeance", 726, 30000, false, 8, TimerType.VENG),
	VENG_OTHER("Vengeance Other", 725, 30000, false, 9, TimerType.VENG),
	NONE("Nothing", -69, 420, true, 9999, TimerType.THIS_SHIT_BROKE);

	@Getter(AccessLevel.PACKAGE)
	private final String name;
	@Getter(AccessLevel.PACKAGE)
	private final int spotAnimId;
	@Getter(AccessLevel.PACKAGE)
	private final int timerLengthTicks;
	@Getter(AccessLevel.PACKAGE)
	private boolean halvable;
	@Getter(AccessLevel.PACKAGE)
	private final int spriteIdx;
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
		return NONE;
	}

}
