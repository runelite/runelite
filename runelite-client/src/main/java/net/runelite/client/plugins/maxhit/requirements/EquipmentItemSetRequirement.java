package net.runelite.client.plugins.maxhit.requirements;

import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.plugins.maxhit.equipment.EquipmentHelper;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;

public class EquipmentItemSetRequirement implements Requirement {
    private final EquipmentItemset itemSet;

    public EquipmentItemSetRequirement(EquipmentItemset itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    public boolean meetsRequirements(Client client) {
        ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
        if(equipmentContainer == null) {
            return false;
        }
        Item[] equipedItems = equipmentContainer.getItems();

        return EquipmentHelper.wearsItemSet(client, equipedItems, this.itemSet);
    }
}
