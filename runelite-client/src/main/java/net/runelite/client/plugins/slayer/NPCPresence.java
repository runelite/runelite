package net.runelite.client.plugins.slayer;

import lombok.Getter;
import net.runelite.api.NPC;

public class NPCPresence
{

	private static final int FADE_TIMER_START = 20;

	@Getter
	private String name;

	@Getter
	private int combatLevel;

	private int fadeTimer;

	private NPCPresence(String name, int combatLevel)
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

	public boolean shouldExist()
	{
		return fadeTimer > 0;
	}

	public void tickExistence()
	{
		fadeTimer--;
	}

	public static NPCPresence buildPresence(NPC npc)
	{
		return new NPCPresence(npc.getName(), npc.getCombatLevel());
	}

}
