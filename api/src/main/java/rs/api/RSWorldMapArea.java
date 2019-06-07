package rs.api;

import api.WorldMapData;
import net.runelite.mapping.Import;

public interface RSWorldMapArea extends WorldMapData
{
	@Import("containsPosition")
	boolean surfaceContainsPosition(int x, int y);
}
