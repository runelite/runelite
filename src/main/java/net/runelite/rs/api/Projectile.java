package net.runelite.rs.api;

public interface Projectile
{
	boolean isMoving();

	Sequence getAnimationSequence();

	double getVelocityY();

	double getVelocityX();

	double getVelocityZ();

	double getScalar();
}
