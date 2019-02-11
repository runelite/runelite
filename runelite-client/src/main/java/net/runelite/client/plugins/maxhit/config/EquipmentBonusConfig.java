package net.runelite.client.plugins.maxhit.config;

import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

import java.util.Arrays;


public enum EquipmentBonusConfig {
    /*
    * Equipment bonus items
    * */
    OBISIDIAN( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "obsidian"),
            new EquipmentSlotItem(EquipmentSlotConfig.CHEST_SLOT, "obsidian"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "obsidian")
    )),new EquipmentCombatBonus( 0.1, 0, 0, 0, 0, 0, 0)),

    BERSERKERTZAAR( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "berserker necklace"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "tzhaar-ket")
    )),new EquipmentCombatBonus( 0.2, 0, 0, 0, 0, 0, 0)),

    BERSERKERTOTKZ( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "berserker necklace"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "toktz-xil")
    )),new EquipmentCombatBonus( 0.2, 0, 0, 0, 0, 0, 0)),

    /*
     * Slayer bonus items
     * */
    BLACKMASK( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "black mask")
    )), new EquipmentCombatBonus(0, 0, 0, 0, 0.17, 0, 0)),

    SLAYERHELM( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "slayer")
    )), new EquipmentCombatBonus(0, 0, 0, 0, 0.17, 0, 0)),

    BLACKMASKI( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "black mask"),
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "(i)")
    )), new EquipmentCombatBonus(0, 0, 0, 0, 0.17, 0.15, 0.15)),

    SLAYERHELMI( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "slayer"),
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "(i)")
    )), new EquipmentCombatBonus(0, 0, 0, 0, 0.17, 0.15, 0.15)),

    /*
     * Void bonus items
     * */
    MELEEVOID( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "melee"),
            new EquipmentSlotItem(EquipmentSlotConfig.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0, 0.1, 0.1, 0, 0, 0, 0)),

    RANGERVOID( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "ranger"),
            new EquipmentSlotItem(EquipmentSlotConfig.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0, 0.1, 0.1, 0, 0, 0, 0)),

    ELITERANGERVOID( new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.HELM_SLOT, "ranger"),
            new EquipmentSlotItem(EquipmentSlotConfig.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.CHEST_SLOT, "elite"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlotConfig.LEG_SLOT, "elite"),
            new EquipmentSlotItem(EquipmentSlotConfig.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0, 0.1, 0.125, 0, 0, 0, 0));

    private final EquipmentItemset itemset;
    private EquipmentCombatBonus equipmentCombatBonus;

    EquipmentBonusConfig(EquipmentItemset itemset, EquipmentCombatBonus equipmentCombatBonus) {
        this.itemset = itemset;
        this.equipmentCombatBonus = equipmentCombatBonus;
    }

    public EquipmentItemset getItemset() {
        return itemset;
    }

    public EquipmentCombatBonus getEquipmentCombatBonus() {
        return equipmentCombatBonus;
    }
}

