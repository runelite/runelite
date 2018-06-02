package net.runelite.client.plugins.StatusBars;

public enum FoodValues
{
	BREAD("", 2309, 5),
	TROUT("", 333, 7),
	SALMON("", 329, 9),
	TUNA("", 361, 10),
	JUG_OF_WINE("", 1993, 11),
	STEW("", 2003, 11),
	CAKE_1("", 1891, 4),
	CAKE_2("", 1893, 4),
	CAKE_3("", 1895, 4),
	LOBSTER("", 379, 12),
	BASS("", 365, 13),
	SWORDFISH("", 373, 14),
	CHOCOLATE_CAKE_1("", 1897, 5),
	CHOCOLATE_CAKE_2("", 1899 , 5),
	CHOCOLATE_CAKE_3("", 1901, 5),
	MONK_FISH("", 7946, 16),
	KARAMBWAN("", 3144, 18),
	UGTHANKI_KEBAB("", 1885, 19),
	SHARK("", 385, 20),
	SEA_TURTLE("", 397, 21),
	PINEAPPLE_PIZZA_1("", 2301, 11),
	PINEAPPLE_PIZZA_2("", 2303, 11),
	SUMMER_PIE_1("", 7218, 11),
	SUMMER_PIE_2("", 7220, 11),
	MANTA_RAY("", 391, 22),
	TUNA_POTATO("", 7060, 22),
	ANGLER_FISH("", 13441, 22),
	SARADOMIN_BREW_4("SARA", 6685, 0),
	SARADOMIN_BREW_3("SARA", 6687, 0),
	SARADOMIN_BREW_2("SARA", 6689, 0),
	SARADOMIN_BREW_1("SARA", 6691, 0);

	private int foodId;
	private int value;
	private String foodName;

	FoodValues(String foodName, int foodId, int value)
	{
		this.foodId = foodId;
		this.value = value;
		this.foodName = foodName;
	}

	public int getValue()
	{
		return value;
	}

	public int getFoodId()
	{
		return foodId;
	}

	public String getFoodName()
	{
		return foodName;
	}
}
