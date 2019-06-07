package rs.api;

import api.MapElementConfig;
import net.runelite.mapping.Import;

public interface RSWorldMapElement extends RSDualNode, MapElementConfig
{
	@Import("getSprite")
	@Override
	RSSprite getMapIcon(boolean var1);
}
