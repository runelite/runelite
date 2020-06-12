package net.runelite.client.plugins.menuentryswapper;

import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.util.Text;

/**
 * A {@link ShiftClickCustomization} provides the ability to change menu entry swap settings that activate on shift click.
 * These changes are persistent.
 *
 * Menu entry swaps are configured per item + widget key pair.
 * For a given item + widget key pair, the list of menu entries should always be the same.
 *
 * For example, an item {@link net.runelite.api.ItemID#SNAKESKIN_SHIELD} can have different menu entries depending
 * on whether the user is viewing the menu in a {@link WidgetInfo#SHOP_INVENTORY_ITEMS_CONTAINER} or a {@link WidgetInfo#INVENTORY}.
 * The options would be something like "Use", "Drop", "Examine", "Cancel",
 * and "Value", "Sell 1", "Sell 5", "Sell 10", "Sell 50", "Examine", "Cancel" respectively.
 *
 * NOTE: Options configured through this swapper do NOT take precedence over the in game shift click drop option!
 *
 */
class ShiftClickCustomization
{

	static final String CONFIG_GROUP = "shiftclick";
	static final String CONFIG_CUSTOMIZATION_ENABLED = "shiftClickCustomization";
	static final String CONFIG_ITEM_PREFIX = "item";
	static final String CONFIG_WIDGET_PREFIX = "widget";
	static final String CONFIGURE = "Configure";
	static final String SAVE = "Save";
	static final String RESET = "Reset";
	static final String MENU_TARGET = "Shift-click";

	// When inside the following widgets there would be item containers of the corresponding InventoryID
	private static final Map<Integer, InventoryID> INVENTORY_FOR_WIDGET = ImmutableMap.of(
		WidgetInfo.SHOP_ITEMS_CONTAINER.getId(), InventoryID.SHOP_INVENTORY,
		WidgetInfo.SHOP_INVENTORY_ITEMS_CONTAINER.getId(), InventoryID.SHOP_INVENTORY,
		WidgetInfo.INVENTORY.getId(), InventoryID.SHOP_INVENTORY
	);

	@Inject
	private ConfigManager configManager;

	@Inject
	private Client client;

	String getSwapConfig(int itemId, int widgetId)
	{
		return configManager.getConfiguration(CONFIG_GROUP, configKey(ItemVariationMapping.map(itemId), widgetId));
	}


	void setSwapConfig(int itemId, int widgetId, String option)
	{
		configManager.setConfiguration(CONFIG_GROUP, configKey(ItemVariationMapping.map(itemId), widgetId), Text.removeTags(option).toLowerCase());

	}
	void unsetSwapConfig(int itemId, int widgetId)
	{
		configManager.unsetConfiguration(CONFIG_GROUP, configKey(ItemVariationMapping.map(itemId), widgetId));
	}

	/**
	 * Given a name of a target item and a widget ID
	 * (ie. {@link net.runelite.api.ItemID#SNAKESKIN_SHIELD} in {@link WidgetInfo#INVENTORY})
	 * return the {@link net.runelite.api.ItemID} corresponding to the target name.
	 *
	 * We need this lookup because when processing certain events
	 * from the {@link net.runelite.client.eventbus.EventBus}, all we have is the name of the item being targeted.
	 *
	 * For example, on a {@link MenuOpened} event, {@link MenuEntry#getIdentifier()}
	 * does not represent the {@link net.runelite.api.ItemID} of the target.
	 * @param targetName
	 * @param widgetId
	 * @return
	 */
	int getItemIdFromTargetName(String targetName, int widgetId)
	{
		return Arrays.stream(client.getItemContainer(INVENTORY_FOR_WIDGET.getOrDefault(widgetId, InventoryID.INVENTORY)).getItems())
			.filter(i -> client
				.getItemDefinition(i.getId())
				.getName()
				.equalsIgnoreCase(Text.removeTags(targetName)))
			.findFirst()
			.map(i -> ItemVariationMapping.map(i.getId())).orElse(-1);
	}

	private String configKey(int itemId, int widgetId)
	{
		return String.join("_",
			CONFIG_ITEM_PREFIX,
			String.valueOf(itemId),
			CONFIG_WIDGET_PREFIX,
			String.valueOf(widgetId));
	}
}