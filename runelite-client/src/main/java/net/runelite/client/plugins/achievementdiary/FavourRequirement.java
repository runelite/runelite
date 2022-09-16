/*
 * Copyright (c) 2019 William <https://github.com/monsterxsync>
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
package net.runelite.client.plugins.achievementdiary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varbit;

@RequiredArgsConstructor
@Getter
public class FavourRequirement implements Requirement
{
	/**
	 * An enumeration of Kourend house favour the player can earn.
	 */
	@RequiredArgsConstructor
	public enum Favour
	{
		ARCEUUS("Arceuus", Varbits.KOUREND_FAVOR_ARCEUUS),
		HOSIDIUS("Hosidius", Varbits.KOUREND_FAVOR_HOSIDIUS),
		LOVAKENGJ("Lovakengj", Varbits.KOUREND_FAVOR_LOVAKENGJ),
		PISCARILIUS("Piscarilius", Varbits.KOUREND_FAVOR_PISCARILIUS),
		SHAYZIEN("Shayzien", Varbits.KOUREND_FAVOR_SHAYZIEN);

		@Getter
		private final String name;
		@Getter(onMethod_ = {@Varbit})
		private final int varbit;
	}

	private final Favour house;
	private final int percent;

	@Override
	public String toString()
	{
		return percent + "% " + house.getName() + " favour";
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		int realFavour = client.getVarbitValue(house.getVarbit());
		return (realFavour / 10) >= percent;
	}
}