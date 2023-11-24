package net.runelite.client.plugins.raids3.Akkha;

import net.runelite.api.coords.WorldPoint;

public class UnstableOrb {
  WorldPoint scenePos;
  ORBOrientation npcOrientation;

  public UnstableOrb(WorldPoint scenePos, ORBOrientation npcOrientation) {
    this.scenePos = scenePos;
    this.npcOrientation = npcOrientation;
  }
}