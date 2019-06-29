package net.runelite.api;

/**
 * An enumeration of skills that a player can level.
 */
public enum Skill
{
	ATTACK("Attack"),
	DEFENCE("Defence"),
	STRENGTH("Strength"),
	HITPOINTS("Hitpoints"),
	RANGED("Ranged"),
	PRAYER("Prayer"),
	MAGIC("Magic"),
	COOKING("Cooking"),
	WOODCUTTING("Woodcutting"),
	FLETCHING("Fletching"),
	FISHING("Fishing"),
	FIREMAKING("Firemaking"),
	CRAFTING("Crafting"),
	SMITHING("Smithing"),
	MINING("Mining"),
	HERBLORE("Herblore"),
	AGILITY("Agility"),
	THIEVING("Thieving"),
	SLAYER("Slayer"),
	FARMING("Farming"),
	RUNECRAFT("Runecraft"),
	HUNTER("Hunter"),
	CONSTRUCTION("Construction"),
	/**
	 * The level of all skills added together.
	 */
	OVERALL("Overall");

	private final String name;

	Skill(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name of the skill.
	 *
	 * @return the skill name
	 */
	public String getName()
	{
		return name;
	}
}
