package net.runelite.client.plugins.maxhit.requirements;

import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.plugins.maxhit.equipment.EquipmentHelper;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

public class EquipmentItemRequirement implements Requirement {
    private EquipmentSlotItem item;

    public EquipmentItemRequirement(EquipmentSlotItem item) {
        this.item = item;
    }

    @Override
    public boolean meetsRequirements(Client client) {
        ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
        if(equipmentContainer == null) {
            return false;
        }
        Item[] equipedItems = equipmentContainer.getItems();
        return EquipmentHelper.wearsItem(client, equipedItems, this.item);
    }
}
