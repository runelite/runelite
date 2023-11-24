package net.runelite.client.plugins.raids3.PuzzleRoom;

import net.runelite.api.NPC;

public class MemoryPillar {
  NPC pillar;
  public MemoryPillarStatus memoryPillarStatus;

  public MemoryPillar() {
    this.memoryPillarStatus = MemoryPillarStatus.NEUTRAL;
    this.pillar = null;
  }
}