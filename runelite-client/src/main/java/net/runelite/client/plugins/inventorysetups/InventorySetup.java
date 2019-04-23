package net.runelite.client.plugins.inventorysetups;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class InventorySetup
{
	@Getter
	private ArrayList<InventorySetupItem> inventory;
	@Getter
	private ArrayList<InventorySetupItem> equipment;
}