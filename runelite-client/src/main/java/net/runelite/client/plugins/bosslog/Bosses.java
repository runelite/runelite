package net.runelite.client.plugins.bosslog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;

@RequiredArgsConstructor
@Getter
public enum Bosses {
    ZULRAH("Zulrah", new int[]{ItemID.TANZANITE_FANG, ItemID.MAGIC_FANG, ItemID.SERPENTINE_VISAGE,
            ItemID.UNCUT_ONYX, ItemID.TANZANITE_MUTAGEN, ItemID.MAGMA_MUTAGEN, ItemID.JAR_OF_SWAMP, ItemID.PET_SNAKELING},
            new int[]{NpcID.ZULRAH, NpcID.ZULRAH_2043, NpcID.ZULRAH_2044},
            Tab.ZULRAH);

    private final String name;
    private final int[] uniques;
    private final int[] ids;
    private final Tab tab;
}
