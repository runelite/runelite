package net.runelite.rs.api;

import net.runelite.api.WorldMapManager;
import net.runelite.mapping.Import;

public interface RSWorldMapManager extends WorldMapManager
{
	@Import("isLoaded0")
	@Override
	boolean isLoaded();

	@Import("surfaceOffsetX")
	int getSurfaceOffsetX();

	@Import("surfaceOffsetY")
	int getSurfaceOffsetY();

	@Import("getPixelsPerTile")
	float getPixelsPerTile(int graphicsDiff, int worldDiff);
}
