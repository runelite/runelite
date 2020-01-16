package net.runelite.client.plugins.inventorysetups;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class InventorySetupOld
{
@Getter(AccessLevel.PUBLIC)
private List<InventorySetupItem> inventory;
@Getter(AccessLevel.PUBLIC)
private List<InventorySetupItem> equipment;
}
