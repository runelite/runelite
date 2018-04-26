package net.runelite.client.plugins.maxhit;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;

public class MaxHitCalc extends MaxHitPlugin
{
	public int melee(Client client, Widget meleeStr)
	{
		double equipment_melee_str = Double.parseDouble(meleeStr.getText().replace("Melee strength: ", ""));
		int str = client.getRealSkillLevel(Skill.STRENGTH);
		double effectiveStrength = Math.floor((Math.floor((str + melee_boost) * melee_prayer) + 11) * void_melee_bonus);
		double max_hit = Math.floor(0.5 + effectiveStrength * (equipment_melee_str + 64) / 640);
		return (int)max_hit;
	}

	public int trident(Client client, Widget magicDmg, int i)
	{
		double equipment_magic_dmg = Double.parseDouble(magicDmg.getText().replace("Magic damage: ", "").replace(".", "").replace("%", ""));
		int magic = client.getRealSkillLevel(Skill.MAGIC);
		double max_hit = Math.floor((Math.floor((magic + magic_boost) / 3) - i) * ( 1 + ((equipment_magic_dmg) / 1000)));
		return (int)max_hit;
	}

	public int ranged(Client client, Widget rangedStr)
	{
		double equipment_ranged_str = Double.parseDouble(rangedStr.getText().replace("Ranged strength: ", ""));
		int ranged = client.getRealSkillLevel(Skill.RANGED);
		double effectiveRangedStrength = Math.floor((Math.floor((ranged + ranged_boost) * ranged_prayer) + 8) * void_ranged_bonus);
		double max_hit = Math.floor(0.5 + effectiveRangedStrength * (equipment_ranged_str + 64) / 640);
		return (int)max_hit;
	}

	public int dharok(Client client, Widget meleeStr)
	{
		double equipment_melee_str = Double.parseDouble(meleeStr.getText().replace("Melee strength: ", ""));
		int str = client.getRealSkillLevel(Skill.STRENGTH);
		double effectiveStrength = Math.floor((Math.floor((str + melee_boost) * melee_prayer) + 11) * void_melee_bonus);
		double max_hit = Math.floor(Math.floor(0.5 + effectiveStrength * (equipment_melee_str + 64) / 640) * dh_boost);
		return (int)max_hit;
	}
}
