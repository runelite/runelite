package net.runelite.api;

import lombok.Getter;

public enum HintArrowType
{
	PLAYER(10),
	NPC(1),
	WORLD_POSITION(2);

	@Getter
	private final int value;

	HintArrowType(int value)
	{
		this.value = value;
	}
}
