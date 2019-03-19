package net.runelite.client.plugins.maxhit.calculators;

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

import java.util.ArrayList;
import java.util.function.BiFunction;

public abstract class MaxHitCalculator
{

	final Client client;
	private final CombatMethod combatMethod;
	private final Item[] equipedItems;
	int baseDamage = 0;

	public enum CombatMethod
	{
		MELEE,
		RANGE,
		MAGIC
	}

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
		for (PrayerBonusConfig prayerBonus : PrayerBonusConfig.values())
		{
			boolean prayerActive = client.getVar(prayerBonus.getPrayerVarbit()) == 1;
			boolean sameCombatMethod = prayerBonus.getCombatMethod() == this.combatMethod;
			if (prayerActive && sameCombatMethod)
			{
				return prayerBonus.getStrengthBonus();
			}
		}
		return 1;
	}

	double getEquipmentBonus(EquipmentBonusConfig.BonusType bonusType)
	{
		double bonus = 1;
		ArrayList<EquipmentBonusConfig> equipmentBonuses = EquipmentBonusConfig.getBonusByType(bonusType);

		for (EquipmentBonusConfig equipmentBonus : equipmentBonuses)
		{
			EquipmentItemset itemSet = equipmentBonus.getItemset();
			boolean wearsSet = EquipmentHelper.wearsItemSet(this.client, this.equipedItems, itemSet);
			if (wearsSet && equipmentBonus.meetsRequirements(this.client))
			{
				bonus += equipmentBonus.getBonus(this.combatMethod);
			}
		}
		return bonus;
	}

	public double calculate()
	{
		BiFunction<Client, MaxHitCalculator, Double> customFormula = this.getCustomFormula();
		if (customFormula != null)
		{
			return customFormula.apply(this.client, this);
		}

		return this.calculateDefault();
	}

	private BiFunction<Client, MaxHitCalculator, Double> getCustomFormula()
	{
		for (CustomFormulaConfig customFormula: CustomFormulaConfig.values())
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

	public abstract double calculateDefault();

	public void setBaseDamage(int baseDamage)
	{
		this.baseDamage = baseDamage;
	}

	double getSkillStrength()
	{
		return Double.parseDouble(this.getSkillStrengthText(this.equipmentSkillPower().getText()));
	}
}
