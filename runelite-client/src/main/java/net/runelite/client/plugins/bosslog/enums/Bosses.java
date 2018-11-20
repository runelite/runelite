package net.runelite.client.plugins.bosslog.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;

@RequiredArgsConstructor
@Getter
public enum Bosses {
    ZULRAH("Zulrah", new int[]{ItemID.TANZANITE_FANG, ItemID.MAGIC_FANG, ItemID.SERPENTINE_VISAGE,
            ItemID.UNCUT_ONYX, ItemID.TANZANITE_MUTAGEN, ItemID.MAGMA_MUTAGEN, ItemID.JAR_OF_SWAMP},
            new int[]{NpcID.ZULRAH, NpcID.ZULRAH_2043, NpcID.ZULRAH_2044},
            Tab.ZULRAH),

    VORKATH("Vorkath", new int[]{ItemID.SKELETAL_VISAGE, ItemID.DRACONIC_VISAGE, ItemID.DRAGONBONE_NECKLACE},
            new int[]{NpcID.VORKATH, NpcID.VORKATH_8058, NpcID.VORKATH_8060, NpcID.VORKATH_8061},
            Tab.VORKATH),

    BANDOS("Bandos", new int[]{ItemID.BANDOS_CHESTPLATE, ItemID.BANDOS_TASSETS, ItemID.BANDOS_BOOTS, ItemID.BANDOS_HILT},
            new int[]{NpcID.GENERAL_GRAARDOR, NpcID.GENERAL_GRAARDOR_6494},
        Tab.BANDOS),

    ZAMORAK("Zamorak", new int[]{ItemID.ZAMORAKIAN_SPEAR, ItemID.ZAMORAK_HILT, ItemID.STAFF_OF_THE_DEAD, ItemID.STEAM_BATTLESTAFF},
            new int[]{NpcID.KRIL_TSUTSAROTH, NpcID.KRIL_TSUTSAROTH_6495},
            Tab.ZAMORAK),

    SARADOMIN("Saradomin", new int[]{ItemID.SARADOMIN_SWORD, ItemID.SARADOMIN_HILT, ItemID.ARMADYL_CROSSBOW, ItemID.SARADOMINS_LIGHT},
            new int[]{NpcID.COMMANDER_ZILYANA, NpcID.COMMANDER_ZILYANA_6493},
            Tab.SARADOMIN),

    ARMADYL("Armadyl", new int[]{ItemID.ARMADYL_HELMET, ItemID.ARMADYL_CHESTPLATE, ItemID.ARMADYL_CHAINSKIRT, ItemID.ARMADYL_HILT},
            new int[]{NpcID.KREEARRA, NpcID.KREEARRA_6492},
            Tab.ARMADYL),

    DAGANNOTH_KINGS("DKs", new int[]{ItemID.BERSERKER_RING, ItemID.ARCHERS_RING, ItemID.SEERS_RING,
            ItemID.WARRIOR_RING, ItemID.SEERCULL, ItemID.MUD_BATTLESTAFF, ItemID.DRAGON_AXE},
            new int[]{NpcID.DAGANNOTH_PRIME, NpcID.DAGANNOTH_REX, NpcID.DAGANNOTH_SUPREME},
            Tab.DAGANNOTH_KINGS),

    SHAMAN("Shaman", new int[]{ItemID.DRAGON_WARHAMMER},
            new int[]{NpcID.LIZARDMAN_SHAMAN, NpcID.LIZARDMAN_SHAMAN_6767, NpcID.LIZARDMAN_SHAMAN_7573, NpcID.LIZARDMAN_SHAMAN_7574,
                    NpcID.LIZARDMAN_SHAMAN_7744, NpcID.LIZARDMAN_SHAMAN_7745},
            Tab.SHAMAN);

    private final String name;
    private final int[] uniques;
    private final int[] ids;
    private final Tab tab;
}
