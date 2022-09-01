package net.runelite.client.plugins.nightmare;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;

@Getter(AccessLevel.PACKAGE)
class MemorizedTotem
{
	@Getter(AccessLevel.PACKAGE)
	private NPC npc;

	@Getter(AccessLevel.PACKAGE)
	private TotemPhase currentPhase;

	MemorizedTotem(final NPC npc)
	{
		this.npc = npc;
		updateCurrentPhase(npc.getId());
	}

	public void updateCurrentPhase(int newId)
	{
		this.currentPhase = TotemPhase.valueOf("TOTEM_" + newId);
	}
}
