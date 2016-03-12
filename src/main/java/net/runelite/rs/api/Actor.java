package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Actor extends Renderable
{
	@Import("interacting")
	int getInteracting();

	@Import("interactingObjects")
	int getInteractingObjects();

	@Import("inSequence")
	boolean inSequence();

	@Import("overhead")
	String getOverhead();

	@Import("loopCycle")
	int getLoopCycle();

	@Import("health")
	int getHealth();

	@Import("maxHealth")
	int getMaxHealth();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("animation")
	int getAnimation();
}
