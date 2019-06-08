package net.runelite.rs.api;

import net.runelite.api.MouseRecorder;
import net.runelite.mapping.Import;

public interface RSMouseRecorder extends MouseRecorder
{
	@Import("xs")
	int[] getXs();

	@Import("ys")
	int[] getYs();

	@Import("millis")
	long[] getMillis();

	@Import("index")
	int getIndex();
}
