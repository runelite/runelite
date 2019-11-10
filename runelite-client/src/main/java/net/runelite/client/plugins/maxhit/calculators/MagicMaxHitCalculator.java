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
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;
import net.runelite.client.plugins.maxhit.config.SpellBaseDamageConfig;

public class MagicMaxHitCalculator extends MaxHitCalculator
{

	public MagicMaxHitCalculator(Client client, Item[] equipedItems)
	{
		super(client, CombatMethod.MAGIC, equipedItems);
	}

	@Override
	protected String getSkillStrengthText(String equipmentText)
	{
		return equipmentText.replace("Magic damage: ", "").replace(".", "").replace("%", "");
	}

	@Override
	Widget equipmentSkillPower()
	{
		return this.client.getWidget(WidgetInfo.EQUIPMENT_MAGIC_DAMAGE);
	}

	@Override
	public double getCurrentSkillPower()
	{
		return this.client.getBoostedSkillLevel(Skill.MAGIC);
	}

	/*
	 * Damage formula based on:
	 * http://services.runescape.com/m=forum/forums.ws?317,318,712,65587452
	 * Section 4.
	 * */
	@Override
	public double calculate()
	{
		int spellBaseDamage = this.baseDamage;

		if (spellBaseDamage == 0)
		{
			int autoCastSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
			if (autoCastSpellId == 0)
			{
				return 0.0;
			}

			SpellBaseDamageConfig autoCastSpell = SpellBaseDamageConfig.findSpellById(autoCastSpellId);
			if (autoCastSpell == null)
			{
				return 0.0;
			}
			spellBaseDamage = autoCastSpell.getBaseDamage();
		}

//      a.Find the base maximum damage a spell can deal.
//      See CustomFormulaConfig for spells based on magic lvl
		double maxHit = spellBaseDamage;

//      b. Increase the base damage (Chaos Gauntlets)
		maxHit = this.applyEquipmentBonus(maxHit, EquipmentBonusConfig.BonusType.SPECIAL);

//      c. The following bonuses stack by adding up. (List of bonus items)
		maxHit = this.applyEquipmentBonus(maxHit, EquipmentBonusConfig.BonusType.EQUIPMENT);

//      d. Round down to the nearest integer.
		maxHit = Math.floor(maxHit);

//      e. On a slayer task, multiply by 1.15 (imbued)
		maxHit = this.applyEquipmentBonus(maxHit, EquipmentBonusConfig.BonusType.SLAYER);

//      f. Round down to the nearest integer.
		maxHit = Math.floor(maxHit);

//      g. If a fire spell is used, multiply by 1.5 (Tome of fire)
		maxHit = this.applyEquipmentBonus(maxHit, EquipmentBonusConfig.BonusType.MAGIC_SPECIAL);

//      h. Round down to the nearest integer.
		maxHit = Math.floor(maxHit);

//      i, j. Castle Wars will not be included
		return maxHit;
	}

}
