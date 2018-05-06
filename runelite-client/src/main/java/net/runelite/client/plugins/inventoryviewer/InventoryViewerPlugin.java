package net.runelite.client.plugins.inventoryviewer;

import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.QueryRunner;
import javax.inject.Inject;

@PluginDescriptor(
		name = "Inventory Viewer",
		enabledByDefault = false
)
public class InventoryViewerPlugin extends Plugin
{
	@Inject
	private QueryRunner queryRunner;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InventoryViewerOverlay overlay;

	@Override
	public InventoryViewerOverlay getOverlay()
	{
		return overlay;
	}
}