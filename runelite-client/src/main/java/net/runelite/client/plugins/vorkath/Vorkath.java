package net.runelite.client.plugins.vorkath;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;

public class Vorkath
{
	static final int ATTACKS_PER_SWITCH = 6;

	enum AttackStyle
	{
		MAGERANGE,
		ICE,
		ACID,
		SPECIAL
	}

	@Getter
	private NPC npc;

	@Getter
	@Setter
	private int phase;

	@Getter
	@Setter
	private int attacksUntilSwitch;

	@Getter
	@Setter
	private int lastTickAnimation;

	@Getter
	@Setter
	private boolean icePhaseAttack;

	public Vorkath(NPC npc)
	{
		this.npc = npc;
		this.attacksUntilSwitch = ATTACKS_PER_SWITCH;
		this.phase = 0;
	}
}