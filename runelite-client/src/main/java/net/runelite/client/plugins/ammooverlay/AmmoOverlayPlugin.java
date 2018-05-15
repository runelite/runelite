package net.runelite.client.plugins.ammooverlay;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import javax.inject.Inject;

@PluginDescriptor(
		name = "Ammo Overlay"
)
public class AmmoOverlayPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private AmmoOverlay overlay;

	@Provides
	private AmmoOverlayConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AmmoOverlayConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public int getEquippedWeaponID()
	{
		return client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.WEAPON);
	}

	public int getAmmoCount()
	{
		final Item[] items = client.getItemContainer(InventoryID.EQUIPMENT).getItems();

		for (Item i: items)
		{
			final ItemComposition item = client.getItemDefinition(i.getId());
			final String itemName = item.getName().toLowerCase();

			if (itemName.contains("arrow") || itemName.contains("bolt"))
			{
				return i.getQuantity();
			}
		}

		return 0;
	}
}
