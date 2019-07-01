package net.runelite.client.plugins.theatre.rooms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;

class Nylos
{
	@Getter
	private NPC npc;
	@Getter
	private int npcIndex;
	@Getter
	@Setter
	private SpawnLocation spawnLocation;

	Nylos(NPC npc, SpawnLocation spawnLocation)
	{
		this.npc = npc;
		this.npcIndex = npc.getIndex();
		this.spawnLocation = spawnLocation;
	}

	@Getter
	@AllArgsConstructor
	enum SpawnLocation
	{
		N1("n1"),
		N2("n2"),
		S1("s1"),
		S2("s2");

		private String name;
	}
}
