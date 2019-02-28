package net.runelite.client.plugins.maxhit.bonus.requirements;

import net.runelite.api.*;
import net.runelite.client.plugins.maxhit.config.SpellConfig;
import net.runelite.client.plugins.maxhit.equipment.EquipmentHelper;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

public class EquipmentRequirement implements BonusRequirement {
    private EquipmentSlotItem item;

    public EquipmentRequirement(EquipmentSlotItem item) {
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
