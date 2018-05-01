package net.runelite.client.plugins.kitten;


import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public enum Felines {

    //white/black
    KITTEN_5591("5591", ItemID.PET_KITTEN),
    CAT_1619("1619", ItemID.PET_CAT),

    //white
    KITTEN_5592("5592", ItemID.PET_KITTEN_1556),
    CAT_1620("1620", ItemID.PET_CAT_1562),

    //brown
    KITTEN_5593("5593", ItemID.PET_KITTEN_1557),
    CAT_1621("1621", ItemID.PET_CAT_1563),

    //black
    KITTEN_5594("5594", ItemID.PET_KITTEN_1558),
    CAT_1622("1622", ItemID.PET_CAT_1564),

    //white/brown
    KITTEN_5595("5595", ItemID.PET_KITTEN_1559),
    CAT_1623("1623", ItemID.PET_CAT_1565),

    //white/blue
    KITTEN_5596("5596", ItemID.PET_KITTEN_1560),
    CAT_1624("1624", ItemID.PET_CAT_1566),

    //hell
    HELLKITTEN("5597", ItemID.HELLKITTEN),
    HELL_CAT("1625", ItemID.HELL_CAT);


    private static final Map<String, Felines> felines = new HashMap<>();
    private final String name;
    private final int itemSpriteId;


    static
    {
        for (Felines cat : values())
        {
            felines.put(cat.getName(), cat);
        }
    }

    private Felines(String name, int ItemSpriteId) {
        this.name = name;
        this.itemSpriteId = ItemSpriteId;

    }

    public int getItemSpriteId()
    {
        return itemSpriteId;
    }
    public String getName()
    {
        return name;
    }

    public static Felines find(String id) {return felines.get(id);}
}
