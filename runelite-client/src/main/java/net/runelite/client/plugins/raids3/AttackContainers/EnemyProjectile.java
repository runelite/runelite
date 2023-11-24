package net.runelite.client.plugins.raids3.AttackContainers;

import net.runelite.api.Projectile;
import net.runelite.client.plugins.raids3.ProtectivePrayer;

public class EnemyProjectile {
  public Projectile projectile;
  public ProtectivePrayer protectivePrayer;

  public EnemyProjectile(Projectile unOpenedProjectile, ProtectivePrayer protectivePrayer) {
    this.projectile = unOpenedProjectile;
    this.protectivePrayer = protectivePrayer;
  }
}