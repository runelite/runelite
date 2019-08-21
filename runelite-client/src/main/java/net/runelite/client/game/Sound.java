package net.runelite.client.game;

public enum Sound
{
	FIFTEEN_SECONDS(1, "net/runelite/client/game/sounds/15seconds.wav"),
	FIVE_SECONDS(2, "net/runelite/client/game/sounds/5seconds.wav"),
	ATTACK_WITH_MAGIC(3, "net/runelite/client/game/sounds/attackmagic.wav"),
	ATTACK_WITH_MELEE(4, "net/runelite/client/game/sounds/attackmelee.wav"),
	ATTACK_WITH_RANGED(5, "net/runelite/client/game/sounds/attackranged.wav"),
	INCOMING(6, "net/runelite/client/game/sounds/incoming.wav"),
	MOVE(7, "net/runelite/client/game/sounds/move.wav"),
	PRAY_MAGIC(8, "net/runelite/client/game/sounds/praymagic.wav"),
	PRAY_MELEE(9, "net/runelite/client/game/sounds/praymelee.wav"),
	PRAY_RANGED(10, "net/runelite/client/game/sounds/prayranged.wav"),
	REENABLE_PRAYER(11, "net/runelite/client/game/sounds/reenableprayer.wav"),
	RUNAWAY(12, "net/runelite/client/game/sounds/runaway.wav"),
	LOW_HEATLH(13, "net/runelite/client/game/sounds/lowhealth.wav"),
	LOW_PRAYER(14, "net/runelite/client/game/sounds/lowprayer.wav"),
	OUT_OF_COMBAT(15, "net/runelite/client/game/sounds/outofcombat.wav"),
	RESTORED_SPECIAL_ATTACK(16, "net/runelite/client/game/sounds/restorespec.wav"),
	IDLE(17, "net/runelite/client/game/sounds/idle.wav"),
	BREAK(18, "net/runelite/client/game/sounds/break.wav");

	private final String filePath;
	private final int id;

	Sound(int id, String filePath)
	{
		this.id = id;
		this.filePath = filePath;
	}

	public String getFilePath()
	{
		return this.filePath;
	}

	public int getId()
	{
		return this.id;
	}
}