/*
 * Copyright (c) 2024, DapperMickie <rustenhovenmick@gmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import java.util.EnumSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter(onMethod_ = @Override)
public enum AgilityBonus implements SkillBonus
{
	WILDERNESS_AGILITY_TICKET_11_TO_50("11-50 Wilderness Tickets", 1.05f),
	WILDERNESS_AGILITY_TICKET_51_TO_100("51-100 Wilderness Tickets", 1.1f),
	WILDERNESS_AGILITY_TICKET_101_PLUS("101+ Wilderness Tickets", 1.15f),
	DESERT_HARD_DIARY("Desert Hard Diary", 1016f / 890),
	FREMENNIK_HARD_DIARY("Fremennik Hard Diary", 920f / 780)
	;

	private final String name;
	private final float value;

	@Override
	public Set<AgilityBonus> getCanBeStackedWith()
	{
		switch (this)
		{
			case WILDERNESS_AGILITY_TICKET_11_TO_50:
			case WILDERNESS_AGILITY_TICKET_51_TO_100:
			case WILDERNESS_AGILITY_TICKET_101_PLUS:
				return EnumSet.complementOf(EnumSet.of(WILDERNESS_AGILITY_TICKET_11_TO_50, WILDERNESS_AGILITY_TICKET_51_TO_100, WILDERNESS_AGILITY_TICKET_101_PLUS));
			default:
				return EnumSet.complementOf(EnumSet.of(this));
		}
	}
}
