package net.runelite.client.plugins.raids3.AttackContainers;

public class UnstableBolt {
  public int waveIndex;
  public GroundAttack groundAttack;

  public UnstableBolt(int waveIndex, GroundAttack groundAttack) {
    this.waveIndex = waveIndex;
    this.groundAttack = groundAttack;
  }
}
