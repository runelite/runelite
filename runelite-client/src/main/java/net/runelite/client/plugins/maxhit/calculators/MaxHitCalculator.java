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

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.maxhit.attackstyle.AttackStyle;
import net.runelite.client.plugins.maxhit.attackstyle.WeaponType;
import net.runelite.client.plugins.maxhit.config.CustomFormulaConfig;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;
import net.runelite.client.plugins.maxhit.config.PrayerBonusConfig;
import net.runelite.client.plugins.maxhit.equipment.EquipmentHelper;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;

public abstract class MaxHitCalculator
{

	final Client client;
	private final CombatMethod combatMethod;
	private final Item[] equipedItems;
	int baseDamage = 0;

	MaxHitCalculator(Client client, CombatMethod combatMethod, Item[] equipedItems)
	{
		this.client = client;
		this.combatMethod = combatMethod;
		this.equipedItems = equipedItems;
	}

	protected abstract String getSkillStrengthText(String equipmentText);

	abstract Widget equipmentSkillPower();

	public abstract double getCurrentSkillPower();

	AttackStyle getAttackStyle()
	{
		int equippedWeaponTypeId = client.getVar(Varbits.EQUIPPED_WEAPON_TYPE);
		int attackStyleId = client.getVar(VarPlayer.ATTACK_STYLE);

		AttackStyle[] attackStyles = WeaponType.getWeaponType(equippedWeaponTypeId).getAttackStyles();

		if (attackStyleId < attackStyles.length)
		{
			AttackStyle attackStyle = attackStyles[attackStyleId];
			if (attackStyle != null)
			{
				return attackStyle;
			}
		}

		return AttackStyle.OTHER;
	}

	double getPrayerBonus()
	{
		double bonus = 1;
		for (PrayerBonusConfig prayerBonus : PrayerBonusConfig.values())
		{
			boolean prayerActive = client.getVar(prayerBonus.getPrayerVarbit()) == 1;
			boolean sameCombatMethod = prayerBonus.getCombatMethod() == this.combatMethod;
			if (prayerActive && sameCombatMethod)
			{
				bonus += prayerBonus.getStrengthBonus();
			}
		}
		return bonus;
	}

	double applyEquipmentBonus(double maxhit, EquipmentBonusConfig.BonusType bonusType)
	{
		double bonus = 1;
		List<Double> addList = new ArrayList<>();

		List<EquipmentBonusConfig> equipmentBonuses = EquipmentBonusConfig.getBonusByType(bonusType);

		for (EquipmentBonusConfig equipmentBonus : equipmentBonuses)
		{
			EquipmentItemset itemSet = equipmentBonus.getItemset();
			boolean wearsSet = EquipmentHelper.wearsItemSet(this.equipedItems, itemSet);
			if (wearsSet && equipmentBonus.meetsRequirements(this.client))
			{
				if (equipmentBonus.getOperation() == EquipmentBonusConfig.Operation.MULTIPLY)
				{
					bonus += equipmentBonus.getBonus(this.combatMethod);
				}
				else if (equipmentBonus.getOperation() == EquipmentBonusConfig.Operation.ADD)
				{
					addList.add(equipmentBonus.getBonus(this.combatMethod));
				}
			}
		}

		maxhit *= bonus;

		maxhit = maxhit + addList.stream().reduce(0.0, Double::sum);

		return maxhit;
	}

	public double getMaxHit()
	{
		BiFunction<Client, MaxHitCalculator, Double> customFormula = this.getCustomFormula();
		if (customFormula != null)
		{
			return customFormula.apply(this.client, this);
		}

		return this.calculate();
	}

	private BiFunction<Client, MaxHitCalculator, Double> getCustomFormula()
	{
		for (CustomFormulaConfig customFormula : CustomFormulaConfig.values())
		{
			if (this.combatMethod != customFormula.getRequiredCombatMethod())
			{
				continue;
			}

			boolean meetsRequirements = customFormula.getRequirements().stream().allMatch(requirement -> requirement.meetsRequirements(this.client));

			if (meetsRequirements)
			{
				return customFormula.getCustomFormula();
			}
		}

		return null;
	}

	public abstract double calculate();

	public void setBaseDamage(int baseDamage)
	{
		this.baseDamage = baseDamage;
	}

	double getSkillStrength()
	{
		return Double.parseDouble(this.getSkillStrengthText(this.equipmentSkillPower().getText()));
	}

	public enum CombatMethod
	{
		MELEE,
		RANGE,
		MAGIC
	}
}
