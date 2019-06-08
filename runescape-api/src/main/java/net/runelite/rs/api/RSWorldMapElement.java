package net.runelite.rs.api;

import net.runelite.api.MapElementConfig;
import net.runelite.mapping.Import;

public interface RSWorldMapElement extends RSDualNode, MapElementConfig
{
	@Import("getSprite")
	@Override
	RSSprite getMapIcon(boolean var1);
}
