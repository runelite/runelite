package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Sequence
{
	@Import("stretches")
	boolean getStretches();

	@Import("maxLoops")
	int getMaxLoops();

	@Import("precedenceAnimating")
	int getPrecedenceAnimating();

	@Import("replyMode")
	int getReplyMode();

	@Import("interleaveLeave")
	int[] getInterleaveLeave();
}
