package net.runelite.api.quest;

public enum MiniQuest
{
	ENTER_THE_ABYSS(0),
	ARCHITECTURAL_ALLIANCE(1),
	BEAR_YOUR_SOUL(2),
	ALFRED_GRIMHANDS_BARCRAWL(3),
	CURSE_OF_THE_EMPTY_LORD(4),
	ENCHANTED_KEY(5),
	THE_GENERALS_SHADOW(6),
	SKIPPY_AND_THE_MOGRES(7),
	THE_MAGE_ARENA(8),
	LAIR_OF_TARN_RAZORLOR(9),
	FAMILY_PEST(10),
	THE_MAGE_ARENA_II(11);

	public static final int SCRIPT = 1359;

	private final int id;

	MiniQuest(int id)
	{
		this.id = id;
	}

	public int getID()
	{
		return id;
	}
}
