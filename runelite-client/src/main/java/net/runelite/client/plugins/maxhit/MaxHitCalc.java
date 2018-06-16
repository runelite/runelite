/*
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.maxhit;

import net.runelite.api.widgets.Widget;

public class MaxHitCalc
{
	private double maxHit;

	public int maxHit(Widget widget, double currentStat, double prayerBonus, int set, double multiplier, int... i)
	{
		final int MELEE_STRENGTH_ID = 5505059;
		final int RANGED_STRENGTH_ID = 5505060;
		final int MAGIC_DAMAGE_ID = 5505061;

		switch (widget.getId())
		{
			case MELEE_STRENGTH_ID:
				double equipmentMeleeStrength = Double.parseDouble(widget.getText().replace("Melee strength: ", ""));
				double effectiveStrength = Math.floor((Math.floor(currentStat * prayerBonus) + 11) * SetBoosts.find(set).getVoidMelee());
				maxHit = Math.floor((0.5 + effectiveStrength * (equipmentMeleeStrength + 64) / 640) * SetBoosts.find(set).getSlayerMelee());
				maxHit = Math.floor(maxHit * multiplier);
				break;
			case RANGED_STRENGTH_ID:
				double equipmentRangedStrength = Double.parseDouble(widget.getText().replace("Ranged strength: ", ""));
				double effectiveRangedStrength = Math.floor((Math.floor(currentStat * prayerBonus) + 8) * SetBoosts.find(set).getVoidRange());
				maxHit = Math.floor((0.5 + effectiveRangedStrength * (equipmentRangedStrength + 64) / 640) * SetBoosts.find(set).getSlayerRange());
				maxHit = Math.floor(maxHit * multiplier);
				break;
			case MAGIC_DAMAGE_ID:
				double equipmentMagicDamage = Double.parseDouble(widget.getText().replace("Magic damage: ", "").replace(".", "").replace("%", ""));
				maxHit = Math.floor(((Math.floor(currentStat / 3) - i[0]) * ( 1 + ((equipmentMagicDamage) / 1000))) * SetBoosts.find(set).getSlayerRange());
				maxHit = Math.floor(maxHit * multiplier);
				break;
		}
		return (int) maxHit;
	}
}