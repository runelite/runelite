/*
 * Copyright (c) 2019, Bartvollebregt <https://github.com/Bartvollebregt>
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
package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;

public enum PrayerBonusConfig
{
	BURST_OF_STRENGTH(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_BURST_OF_STRENGTH, 0.05),
	SUPERHUMAN_STRENGTH(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_SUPERHUMAN_STRENGTH, 0.1),
	ULTIMATE_STRENGTH(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_ULTIMATE_STRENGTH, 0.15),
	CHIVALRY(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_CHIVALRY, 0.18),
	PIETY(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_PIETY, 0.23),

	SHARP_EYE(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_SHARP_EYE, 0.05),
	HAWK_EYE(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_HAWK_EYE, 0.1),
	EAGLE_EYE(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_EAGLE_EYE, 0.15),
	RIGOUR(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_RIGOUR, 0.23);

	private final MaxHitCalculator.CombatMethod combatMethod;
	private final Varbits prayerVarbit;
	private final double strengthBonus;

	PrayerBonusConfig(MaxHitCalculator.CombatMethod combatMethod, Varbits prayerVarbit, double strengthBonus)
	{
		this.combatMethod = combatMethod;
		this.prayerVarbit = prayerVarbit;
		this.strengthBonus = strengthBonus;
	}

	public MaxHitCalculator.CombatMethod getCombatMethod()
	{
		return combatMethod;
	}

	public Varbits getPrayerVarbit()
	{
		return prayerVarbit;
	}

	public double getStrengthBonus()
	{
		return strengthBonus;
	}
}