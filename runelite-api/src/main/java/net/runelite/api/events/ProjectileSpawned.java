package net.runelite.api.events;

import net.runelite.api.Projectile;
import lombok.Data;

/**
 * An event called whenever a {@link Projectile} has spawned.
 */
@Data
public class ProjectileSpawned
{
    /**
     * The spawned projectile.
     */
    private Projectile projectile;
}
