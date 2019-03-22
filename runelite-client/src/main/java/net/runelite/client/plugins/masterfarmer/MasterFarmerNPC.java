package net.runelite.client.plugins.masterfarmer;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import java.time.Instant;

public class MasterFarmerNPC
{
	@Getter
	private int npcIndex;

	@Getter
	private String npcName;

	@Getter
	@Setter
	private NPC npc;

	@Getter
	@Setter
	private Instant stoppedMovingTick;

	@Getter
	@Setter
	private long timeWithoutMoving;

	@Getter
	@Setter
	private WorldPoint currentLocation;

	MasterFarmerNPC(NPC npc)
	{
		this.npc = npc;
		this.npcName = npc.getName();
		this.npcIndex = npc.getIndex();
		this.stoppedMovingTick = Instant.now();
		this.timeWithoutMoving = 0;
		this.currentLocation = npc.getWorldLocation();
	}
}
