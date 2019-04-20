package net.runelite.client.plugins.inventorysetups;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
public class InventorySetup
{
	@Getter
	private ArrayList<InventorySetupItem> inventory;
	@Getter
	private ArrayList<InventorySetupItem> equipment;
}
