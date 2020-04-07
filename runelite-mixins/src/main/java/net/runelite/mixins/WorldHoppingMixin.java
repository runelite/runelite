package net.runelite.mixins;

import net.runelite.api.MenuOpcode;
import net.runelite.api.World;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class WorldHoppingMixin implements RSClient
{
	@Inject
	@Override
	public void openWorldHopper()
	{
		// The clicked x & y coordinates (the last arguments) are not processed in the game or sent to Jagex, so they don't have to be real.
		invokeMenuAction("World Switcher", "", 1, MenuOpcode.CC_OP.getId(), -1, WidgetInfo.WORLD_SWITCHER_BUTTON.getId());
	}

	@Inject
	@Override
	public void hopToWorld(World world)
	{
		final int worldId = world.getId();
		invokeMenuAction("Switch", "<col=ff9040>" + (worldId - 300) + "</col>", 1, MenuOpcode.CC_OP.getId(), worldId, WidgetInfo.WORLD_SWITCHER_LIST.getId());
	}
}
