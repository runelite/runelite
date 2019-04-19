package net.runelite.client.plugins.fightcavejadhelper;

import net.runelite.api.AnimationID;
import net.runelite.api.Prayer;

public enum JadAttack
{
	MAGIC(AnimationID.TZTOK_JAD_MAGIC_ATTACK, Prayer.PROTECT_FROM_MAGIC),
	RANGE(AnimationID.TZTOK_JAD_RANGE_ATTACK, Prayer.PROTECT_FROM_MISSILES);

	private final int animation;
	private final Prayer prayer;

	JadAttack(int animation, Prayer prayer)
	{
		this.animation = animation;
		this.prayer = prayer;
	}

	public int getAnimation()
	{
		return animation;
	}

	public Prayer getPrayer()
	{
		return prayer;
	}
}