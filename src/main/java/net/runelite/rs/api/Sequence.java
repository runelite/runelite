package net.runelite.rs.api;

public interface Sequence
{
	boolean getStretches();

	int getMaxLoops();

	int getPrecedenceAnimating();

	int getReplyMode();

	int[] getInterleaveLeave();
}
