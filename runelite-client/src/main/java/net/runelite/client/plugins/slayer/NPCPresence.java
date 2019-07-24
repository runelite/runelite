package net.runelite.client.plugins.slayer;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;

public class NPCPresence
{

	private static final int FADE_TIMER_START = 20;

	@Getter(AccessLevel.PACKAGE)
	private String name;

	@Getter(AccessLevel.PACKAGE)
	private int combatLevel;

	private int fadeTimer;

	private NPCPresence(final String name, final int combatLevel)
	{
		this.name = name;
		this.combatLevel = combatLevel;
		this.fadeTimer = FADE_TIMER_START;
	}

	@Override
	public String toString()
	{
		return name + "[" + combatLevel + "]";
	}

	boolean shouldExist()
	{
		return fadeTimer > 0;
	}

	void tickExistence()
	{
		fadeTimer--;
	}

	static NPCPresence buildPresence(NPC npc)
	{
		return new NPCPresence(npc.getName(), npc.getCombatLevel());
	}

}
