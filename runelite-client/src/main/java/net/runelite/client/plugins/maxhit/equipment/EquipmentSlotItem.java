package net.runelite.client.plugins.maxhit.equipment;

import net.runelite.client.plugins.maxhit.config.EquipmentSlotConfig;

public class EquipmentSlotItem {
    private final EquipmentSlotConfig equipmentSlot;
    private final String item;

    public EquipmentSlotItem(EquipmentSlotConfig equipmentSlot, String item){

        this.equipmentSlot = equipmentSlot;
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public EquipmentSlotConfig getEquipmentSlot() {
        return equipmentSlot;
    }
}
