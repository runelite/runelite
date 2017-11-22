package net.runelite.client.plugins.aoewarnings;

import net.runelite.api.Point;

public class AoeProjectile
{
	private long startTime;
	private Point targetPoint;
	private AoeProjectileInfo aoeProjectileInfo;

	public AoeProjectile(long startTime, Point targetPoint, AoeProjectileInfo aoeProjectileInfo)
	{
		this.startTime = startTime;
		this.targetPoint = targetPoint;
		this.aoeProjectileInfo = aoeProjectileInfo;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	public Point getTargetPoint()
	{
		return targetPoint;
	}

	public void setTargetPoint(Point targetPoint)
	{
		this.targetPoint = targetPoint;
	}

	public AoeProjectileInfo getAoeProjectileInfo()
	{
		return aoeProjectileInfo;
	}

	public void setAoeProjectileInfo(AoeProjectileInfo aoeProjectileInfo)
	{
		this.aoeProjectileInfo = aoeProjectileInfo;
	}
}
