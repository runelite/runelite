package net.runelite.client.plugins.inferno;

import java.awt.Color;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;

public class InfernoNPC
{
	public enum Attackstyle
	{
		MAGE("Mage", Color.CYAN),
		RANGE("Range", Color.GREEN),
		MELEE("Melee", Color.WHITE),
		RANDOM("Random", Color.ORANGE);

		@Getter
		private String name = "";

		@Getter
		private Color color;

		Attackstyle(String s, Color c)
		{
			this.name = s;
			this.color = c;
		}
	}

	@Getter
	private NPC npc;

	@Getter
	private String name;

	@Getter
	@Setter
	private Attackstyle attackstyle;

	@Getter
	private int attackTicks;

	@Getter
	private int priority;

	@Getter
	@Setter
	private int ticksTillAttack = -1;

	@Getter
	@Setter
	private boolean attacking = false;

	@Getter
	private int attackAnimation;

	@Getter
	private boolean isMidAttack = false;

	@Getter
	@Setter
	private int distanceToPlayer = 0;

	@Getter
	int textLocHeight;

	public InfernoNPC(NPC npc)
	{
		this.npc = npc;
		textLocHeight = npc.getLogicalHeight() + 40;
		switch (npc.getId())
		{
			case NpcID.JALAKREKKET:
				attackTicks = 4;
				name = "lil mel";
				attackAnimation = 7582;
				attackstyle = Attackstyle.MELEE;
				priority = 7;
				break;

			case NpcID.JALAKREKXIL:
				attackTicks = 4;
				name = "lil range";
				attackAnimation = 7583;
				attackstyle = Attackstyle.RANGE;
				priority = 6;
				break;

			case NpcID.JALAKREKMEJ:
				attackTicks = 4;
				name = "lil mage";
				attackAnimation = 7581;
				attackstyle = Attackstyle.MAGE;
				priority = 5;
				break;

			case NpcID.JALMEJRAH:
				attackTicks = 3;
				name = "bat";
				attackAnimation = 7578;
				attackstyle = Attackstyle.RANGE;
				priority = 4;
				break;

			case NpcID.JALAK:
				attackTicks = 6;
				name = "blob";
				attackAnimation = 7583; // also 7581
				attackstyle = Attackstyle.RANDOM;
				priority = 3;
				break;

			case NpcID.JALIMKOT:
				attackTicks = 4;
				name = "meleer";
				attackAnimation = 7597;
				attackstyle = Attackstyle.MELEE;
				priority = 2;
				break;

			case NpcID.JALXIL:
				attackTicks = 4;
				name = "ranger";
				attackAnimation = 7605;
				attackstyle = Attackstyle.RANGE;
				priority = 1;
				break;

			case NpcID.JALZEK:
				attackTicks = 4;
				name = "mager";
				attackAnimation = 7610;
				attackstyle = Attackstyle.MAGE;
				priority = 0;
				break;

			default:
				attackTicks = 0;
		}
	}

	public String info()
	{
		String info = "";

		if (attacking)
		{
			info += ticksTillAttack;
		}
		//info += " D: " + distanceToPlayer;

		return info;
	}

	public void attacked()
	{
		ticksTillAttack = attackTicks;
		attacking = true;
	}
}
