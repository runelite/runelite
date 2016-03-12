package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Projectile
{
	@Import("isMoving")
	boolean isMoving();

	@Import("animationSequence")
	Sequence getAnimationSequence();

	@Import("velocityY")
	double getVelocityY();

	@Import("velocityX")
	double getVelocityX();

	@Import("velocityZ")
	double getVelocityZ();

	@Import("scalar")
	double getScalar();
}
