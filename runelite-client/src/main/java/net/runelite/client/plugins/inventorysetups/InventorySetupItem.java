package net.runelite.client.plugins.inventorysetups;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class InventorySetupItem
{
	@Getter
	private final int id;
	@Getter
	private final String name;
	@Getter
	private final int quantity;
}
