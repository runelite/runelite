package net.runelite.client.plugins.raids.bats;

import lombok.Getter;

public enum RoomType
{
	LEFT(64),
	RIGHT(74),
	STRAIGHT(66);

	@Getter
	private int chestCount;

	RoomType(int chestCount)
	{
		this.chestCount = chestCount;
	}
}
