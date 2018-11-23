package net.runelite.client.plugins.xptracker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;

public enum AttackStyle
{
	ACCURATE("Accurate",
			new SkillAmount(Skill.ATTACK, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	AGGRESSIVE("Aggressive",
			new SkillAmount(Skill.STRENGTH, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	DEFENSIVE("Defensive",
			new SkillAmount(Skill.DEFENCE, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	CONTROLLED("Controlled",
			new SkillAmount(Skill.ATTACK, 4.0 / 3.0),
			new SkillAmount(Skill.STRENGTH, 4.0 / 3.0),
			new SkillAmount(Skill.DEFENCE, 4.0 / 3.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	RANGING("Ranging",
			new SkillAmount(Skill.RANGED, 4.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	LONGRANGE("Longrange",
			new SkillAmount(Skill.RANGED, 2.0),
			new SkillAmount(Skill.DEFENCE, 2.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	CASTING("Casting",
			new SkillAmount(Skill.MAGIC, 4.0), // note that this is estimate
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	DEFENSIVE_CASTING("Defensive Casting",
			new SkillAmount(Skill.MAGIC, 3.0), // also an estimate
			new SkillAmount(Skill.DEFENCE, 1.0),
			new SkillAmount(Skill.HITPOINTS, 4.0 / 3.0)),
	OTHER("Other");

	@Getter
	@AllArgsConstructor
	public static class SkillAmount
	{

		private final Skill skill;
		private final double amount;

	}

	private final String name;
	private final SkillAmount[] skillAmounts;

	AttackStyle(String name, SkillAmount... skillAmounts)
	{
		this.name = name;
		this.skillAmounts = skillAmounts;
	}

	public String getName()
	{
		return name;
	}

	public SkillAmount[] getSkillAmounts()
	{
		return skillAmounts;
	}
}
