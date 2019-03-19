package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public class RangeMaxHitCalculator extends MeleeMaxHitCalculator
{

	public RangeMaxHitCalculator(Client client, Item[] equipedItems)
	{
		super(client, CombatMethod.RANGE, equipedItems);
	}

	@Override
	protected String getSkillStrengthText(String equipmentText)
	{
		return equipmentText.replace("Ranged strength: ", "").replace(".", "").replace("%", "");
	}

	@Override
	public Widget equipmentSkillPower()
	{
		return this.client.getWidget(WidgetInfo.EQUIPMENT_RANGED_STRENGTH);
	}

	@Override
	public double getCurrentSkillPower()
	{
		return this.client.getRealSkillLevel(Skill.RANGED);
	}

}
