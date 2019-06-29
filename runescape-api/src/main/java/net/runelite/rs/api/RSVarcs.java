package net.runelite.rs.api;

import java.util.Map;
import net.runelite.mapping.Import;

public interface RSVarcs
{
	@Import("map")
	Map<Integer, Object> getVarcMap();
}
