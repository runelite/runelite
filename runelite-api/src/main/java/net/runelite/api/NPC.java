package net.runelite.api;

import net.runelite.rs.api.NPCComposition;

public class NPC extends Actor
{
	private net.runelite.rs.api.NPC npc;

	public NPC(Client client, net.runelite.rs.api.NPC npc)
	{
		super(client, npc);
		this.npc = npc;
	}

	@Override
	public String getName()
	{
		return npc.getComposition().getName();
	}
}
