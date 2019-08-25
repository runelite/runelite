package net.runelite.client.plugins.aoewarnings;

import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;

@Getter(AccessLevel.PACKAGE)
class ProjectileContainer
{
	private Projectile projectile;
	private Instant startTime;
	private AoeProjectileInfo aoeProjectileInfo;
	private int lifetime;
	private int finalTick;
	@Setter(AccessLevel.PACKAGE)
	private LocalPoint targetPoint;

	ProjectileContainer(Projectile projectile, Instant startTime, int lifetime, int finalTick)
	{
		this.projectile = projectile;
		this.startTime = startTime;
		this.targetPoint = null;
		this.aoeProjectileInfo = AoeProjectileInfo.getById(projectile.getId());
		this.lifetime = lifetime;
		this.finalTick = finalTick;
	}
}
