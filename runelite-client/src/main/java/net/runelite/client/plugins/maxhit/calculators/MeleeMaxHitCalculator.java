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
package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.attackstyle.AttackStyle;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;

public class MeleeMaxHitCalculator extends MaxHitCalculator
{

	public MeleeMaxHitCalculator(Client client, Item[] equipedItems)
	{
		super(client, CombatMethod.MELEE, equipedItems);
	}

	MeleeMaxHitCalculator(Client client, CombatMethod combatMethod, Item[] equipedItems)
	{
		super(client, combatMethod, equipedItems);
	}

	@Override
	protected String getSkillStrengthText(String equipmentText)
	{
		return equipmentText.replace("Melee strength: ", "");
	}

	@Override
	public Widget equipmentSkillPower()
	{
		return this.client.getWidget(WidgetInfo.EQUIPMENT_MELEE_STRENGTH);
	}

	@Override
	public double getCurrentSkillPower()
	{
		return this.client.getBoostedSkillLevel(Skill.STRENGTH);
	}

	private double getEffectiveLevel()
	{
//      a. Take the visible strength or ranged level from the skills interface.
		double skillPower = this.getCurrentSkillPower();

//      b. Multiply the level by the prayer adjustment
		double effectiveLevel = skillPower * this.getPrayerBonus();

//      c. Round down to the nearest integer.
		effectiveLevel = Math.floor(effectiveLevel);

//      d. Add the stance bonus from the combat options interface.
//        Melee:
//        • Aggressive: +3
//        • Controlled: +1
//        Ranged:
//        * Accurate: +3
		AttackStyle attackStyle = this.getAttackStyle();
		effectiveLevel += attackStyle.getMaxHitBonus();

//      e. Add up +8.
		effectiveLevel += 8;

//      f.  Multiply by the void bonus:
//      • Void melee: multiply by 1.10. Round down.
//      • Void ranged: multiply by 1.10. Round down.
//      • Elite void ranged: multiply by 1.125. Round down.
		effectiveLevel = this.applyEquipmentBonus(effectiveLevel, EquipmentBonusConfig.BonusType.VOID_KNIGHT);

//      g. This is the effective (ranged) strength level. Let this equal 'A' in the formula in
		return effectiveLevel;
	}

	//  3.3 Take the melee or ranged strength bonus from the equipment stats interface and let this equal 'B' in the formula in 3.1.
	private double getEquipmentBonus()
	{
		return this.getSkillStrength();
	}

	/*
	 * Damage formula based on:
	 * http://services.runescape.com/m=forum/forums.ws?317,318,712,65587452
	 * Section 3.1
	 * */
	@Override
	public double calculate()
	{

//      a. Max hit = 0.5 + A * (B+64) /640 (A is effective level, B is Equipment bonus)
		double maxHit = 0.5 + this.getEffectiveLevel() * (this.getEquipmentBonus() + 64) / 640;

//      b. Round down the max hit to the nearest integer.
		maxHit = Math.floor(maxHit);

//      3.4 Special attacks (not actually taking weapon special attacks into account)
//      a. Multiply by the bonus of one of the following items (slayer)
		maxHit = this.applyEquipmentBonus(maxHit, EquipmentBonusConfig.BonusType.SLAYER);

//      b. Round down the max hit to the nearest integer.
		maxHit = Math.floor(maxHit);

//      c. Multiply by the bonus of one of the following items
		maxHit = this.applyEquipmentBonus(maxHit, EquipmentBonusConfig.BonusType.SPECIAL);

//		d. Round down to the nearest integer.
		maxHit = Math.floor(maxHit);

		return maxHit;
	}
}


