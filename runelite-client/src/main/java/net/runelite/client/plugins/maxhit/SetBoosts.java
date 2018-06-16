package net.runelite.client.plugins.maxhit;

import java.util.HashMap;
import java.util.Map;

enum SetBoosts
{
	DEFAULT(1, 1, 1, 1, 1),
	VOID(2, 1.1, 1.1, 1, 1),
	ELITE_VOID(3, 1.1, 1.125, 1, 1),
	SLAYER_HELM(4, 1, 1, 1.17, 1),
	SLAYER_HELM_i(5, 1, 1, 1.17, 1.15),
	OBSIDIAN(6, 1, 1, 1, 1);

	private static final Map<Integer, SetBoosts> setBoosts = new HashMap<>();

	private final int set;
	private final double voidMelee;
	private final double voidRange;
	private final double slayerMelee;
	private final double slayerRange;

	static
	{
		for (SetBoosts setBoost : values())
		{
			setBoosts.put(setBoost.getSet(), setBoost);
		}
	}

	SetBoosts(int set, double voidMelee, double voidRange, double slayerMelee, double slayerRange)
	{
		this.set = set;
		this.voidMelee = voidMelee;
		this.voidRange = voidRange;
		this.slayerMelee = slayerMelee;
		this.slayerRange = slayerRange;
	}

	public int getSet()
	{
		return set;
	}

	public double getVoidMelee()
	{
		return voidMelee;
	}

	public double getVoidRange()
	{
		return voidRange;
	}

	public double getSlayerMelee()
	{
		return slayerMelee;
	}

	public double getSlayerRange()
	{
		return slayerRange;
	}

	public static SetBoosts find(int set)
	{
		return setBoosts.get(set);
	}
}
