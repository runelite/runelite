package net.runelite.client.plugins.StatusBars;

public enum PotionValues
{
	PRAYER_POTION_4("", 2434, 7),
	PRAYER_POTION_3("", 139, 7),
	PRAYER_POTION_2("", 141, 7),
	PRAYER_POTION_1("", 143, 7),

	SUPER_RESTORE_POTION_4("", 3024, 8),
	SUPER_RESTORE_POTION_3("", 3026, 8),
	SUPER_RESTORE_POTION_2("", 3028, 8),
	SUPER_RESTORE_POTION_1("", 3030, 8),

	SANFEW_SERUM_POTION_4("", 10925, 9),
	SANFEW_SERUM_POTION_3("", 10927, 9),
	SANFEW_SERUM_POTION_2("", 10929, 9),
	SANFEW_SERUM_POTION_1("", 10931, 9);

	private int potionId;
	private int value;

	PotionValues(String potionName, int potionId, int value)
	{
		this.potionId = potionId;
		this.value = value;
	}

	public int getPotionValue()
	{
		return value;
	}

	public int getPotionId()
	{
		return potionId;
	}
}
