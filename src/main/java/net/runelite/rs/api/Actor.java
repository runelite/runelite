package net.runelite.rs.api;

public interface Actor extends Renderable
{
	int getInteracting();

	int getInteractingObjects();

	boolean inSequence();

	String getOverhead();

	int getLoopCycle();

	int getHealth();

	int getMaxHealth();

	int getX();

	int getY();

	int getAnimation();
}
