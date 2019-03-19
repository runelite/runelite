package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Client;
import net.runelite.client.plugins.maxhit.requirements.Requirement;
import net.runelite.client.plugins.maxhit.requirements.SpellBookRequirement;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlot;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

import java.util.*;


public enum EquipmentBonusConfig {

    /*
    * Slayer bonus items
     */
    BLACKMASK(BonusType.SLAYER, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "black mask")
    )), new EquipmentCombatBonus(((7.0/6.0)-1), 0, 0)),

    SLAYERHELM(BonusType.SLAYER, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "slayer")
    )), new EquipmentCombatBonus(((7.0/6.0)-1), 0, 0)),

    BLACKMASKI(BonusType.SLAYER, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "black mask"),
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "(i)")
    )), new EquipmentCombatBonus(((7.0/6.0)-1), 0.15, 0.15)),

    SLAYERHELMI(BonusType.SLAYER, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "slayer"),
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "(i)")
    )), new EquipmentCombatBonus(((7.0/6.0)-1), 0.15, 0.15)),

    /*
     * Void bonus items
     * */
    MELEEVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "melee"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0.1, 0.1, 0)),

    RANGERVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "ranger"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0.1, 0.1, 0)),

    ELITERANGERVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "ranger"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "elite"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "elite"),
            new EquipmentSlotItem(EquipmentSlot.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0.1, 0.125, 0)),

    /*
    * Special Melee Equipment
    * */
    OBISIDIAN(BonusType.SPECIAL, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "obsidian"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "obsidian"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "obsidian")
    )),new EquipmentCombatBonus( 0.1, 0, 0)),

    BERSERKERTZAAR(BonusType.SPECIAL, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "berserker necklace"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "tzhaar-ket-om")
    )),new EquipmentCombatBonus( 0.2, 0, 0)),

    BERSERKERTOTKZ(BonusType.SPECIAL, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "berserker necklace"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "toktz-xil-ak")
    )),new EquipmentCombatBonus( 0.2, 0, 0)),


    /*
    * Magic Equipment
     */
    ANCESTRAL_HAT(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT ,"Ancestral hat")
    )), new EquipmentCombatBonus(0, 0, 0.02)),
    ANCESTRAL_ROBE_TOP(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT ,"Ancestral robe top")
    )), new EquipmentCombatBonus(0, 0, 0.02)),
    ANCESTRAL_ROBE_BOTTOM(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT ,"Ancestral robe bottom")
    )), new EquipmentCombatBonus(0, 0, 0.02)),
    IMBUED_SARADOMIN_CAPE(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.CAPE_SLOT ,"Imbued saradomin cape")
    )), new EquipmentCombatBonus(0, 0, 0.02)),
    IMBUED_GUTHIX_CAPE(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.CAPE_SLOT ,"Imbued guthix cape")
    )), new EquipmentCombatBonus(0, 0, 0.02)),
    IMBUED_ZAMORAK_CAPE(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.CAPE_SLOT ,"Imbued zamorak cape")
    )), new EquipmentCombatBonus(0, 0, 0.02)),
    KODAI_WAND(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT ,"Kodai wand")
    )), new EquipmentCombatBonus(0, 0, 0.15)),
    OCCULT_NECKLACE(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.NECK_SLOT ,"Occult necklace")
    )), new EquipmentCombatBonus(0, 0, 0.10)),
    SALVE_AMULET_I(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.NECK_SLOT ,"Salve amulet (i)")
    )), new EquipmentCombatBonus(0, 0, 0.15)),
    SALVE_AMULET_EI(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.NECK_SLOT ,"Salve amulet (ei")
    )), new EquipmentCombatBonus(0, 0, 0.20)),
    STAFF_OF_THE_DEAD(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT ,"Staff of the dead")
    )), new EquipmentCombatBonus(0, 0, 0.15)),
    TORMENTED_BRACELET(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.GLOVE_SLOT ,"Tormented bracelet")
    )), new EquipmentCombatBonus(0, 0, 0.05)),
    ELITE_VOID_MAGIC(BonusType.EQUIPMENT, new EquipmentItemset(Arrays.asList(
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "mage"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "elite"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "void"),
            new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "elite"),
            new EquipmentSlotItem(EquipmentSlot.GLOVE_SLOT, "void")
    )), new EquipmentCombatBonus(0, 0, 0.025)),
    SMOKE_STAFF(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
            new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT ,"Smoke Staff")
    )),  new EquipmentCombatBonus(0, 0, 0.10), Collections.singletonList(new SpellBookRequirement(SpellBaseDamageConfig.SpellBook.NORMAL))),


//
//    /*
//    * Special Magic Weapons
//    * */
//    TRIDENT_OF_SEAS(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
//            new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Trident of the seas")
//    )), new EquipmentCombatBonus(0, 0, 4)),
//
//    TRIDENT_OF_SWAMP(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
//            new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Trident of the swamp")
//    )), new EquipmentCombatBonus(0, 0, 1)),
//
//    TOXIC_TRIDENT(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
//            new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Uncharged toxic trident")
//    )), new EquipmentCombatBonus(0, 0, 1))
//


    ;

    public enum BonusType {
        EQUIPMENT,
        SLAYER,
        VOID_KNIGHT,
        SPECIAL
    }

    private static final Map<BonusType, ArrayList<EquipmentBonusConfig>> bonusTypes = new HashMap<>();

    private BonusType bonusType = BonusType.EQUIPMENT;
    private final EquipmentItemset itemset;
    private EquipmentCombatBonus equipmentCombatBonus;
    private List<Requirement> requirements = new ArrayList<>();

    static
    {
        for (EquipmentBonusConfig equipmentBonus : values())
        {
            BonusType bonusType = equipmentBonus.bonusType;
            if(!bonusTypes.containsKey(bonusType)) {
                bonusTypes.put(bonusType, new ArrayList<>());
            }
            ArrayList<EquipmentBonusConfig> list = bonusTypes.get(bonusType);
            list.add(equipmentBonus);
            bonusTypes.put(bonusType, list);
        }
    }

    EquipmentBonusConfig(BonusType bonusType, EquipmentItemset itemset, EquipmentCombatBonus equipmentCombatBonus) {
        this.bonusType = bonusType;
        this.itemset = itemset;
        this.equipmentCombatBonus = equipmentCombatBonus;
    }

    EquipmentBonusConfig(BonusType bonusType, EquipmentItemset itemset, EquipmentCombatBonus equipmentCombatBonus, List<Requirement> requirements) {
        this.bonusType = bonusType;
        this.itemset = itemset;
        this.equipmentCombatBonus = equipmentCombatBonus;
        this.requirements = requirements;
    }

    public EquipmentItemset getItemset() {
        return itemset;
    }

    public double getBonus(MaxHitCalculator.CombatMethod combatMethod) {
        return this.equipmentCombatBonus.getCombatBonus(combatMethod);
    }

    public static ArrayList<EquipmentBonusConfig> getBonusByType(BonusType bonusType) {
        if(!bonusTypes.containsKey(bonusType)) {
            return new ArrayList<>();
        }
        return bonusTypes.get(bonusType);
    }

    public boolean meetsRequirements(Client client) {
        return requirements.stream().allMatch(requirement -> requirement.meetsRequirements(client));
    }
}

