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

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;

public class MaxHitCalc extends MaxHitPlugin
{
	public int melee(Client client, Widget meleeStrength)
	{
		double equipmentMeleeStrength = Double.parseDouble(meleeStrength.getText().replace("Melee strength: ", ""));
		int str = client.getRealSkillLevel(Skill.STRENGTH);
		double effectiveStrength = Math.floor((Math.floor((str + meleeBoost) * meleePrayerBonus) + 11) * voidMeleeBonus);
		double maxHit = Math.floor((0.5 + effectiveStrength * (equipmentMeleeStrength + 64) / 640) * meleeSlayerBonus);
		return (int)maxHit;
	}

	public int trident(Client client, Widget magicDamage, int i)
	{
		double equipmentMagicDamage = Double.parseDouble(magicDamage.getText().replace("Magic damage: ", "").replace(".", "").replace("%", ""));
		int magic = client.getRealSkillLevel(Skill.MAGIC);
		double maxHit = Math.floor(((Math.floor((magic + magicBoost) / 3) - i) * ( 1 + ((equipmentMagicDamage) / 1000))) * rangeSlayerBonus);
		return (int)maxHit;
	}

	public int ranged(Client client, Widget rangedStrength)
	{
		double equipmentRangedStrength = Double.parseDouble(rangedStrength.getText().replace("Ranged strength: ", ""));
		int ranged = client.getRealSkillLevel(Skill.RANGED);
		double effectiveRangedStrength = Math.floor((Math.floor((ranged + rangedBoost) * rangedPrayerBonus) + 8) * voidRangedBonus);
		double maxHit = Math.floor((0.5 + effectiveRangedStrength * (equipmentRangedStrength + 64) / 640) * rangeSlayerBonus);
		return (int)maxHit;
	}

	public int dharok(Client client, Widget meleeStrength)
	{
		double equipmentMeleeStrength = Double.parseDouble(meleeStrength.getText().replace("Melee strength: ", ""));
		int str = client.getRealSkillLevel(Skill.STRENGTH);
		double effectiveStrength = Math.floor((Math.floor((str + meleeBoost) * meleePrayerBonus) + 11) * voidMeleeBonus);
		double maxHit = Math.floor(Math.floor(0.5 + effectiveStrength * (equipmentMeleeStrength + 64) / 640) * dharokSetBoost);
		return (int)maxHit;
	}
}
