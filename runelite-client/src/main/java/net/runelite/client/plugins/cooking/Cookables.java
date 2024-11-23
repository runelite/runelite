package net.runelite.client.plugins.cooking;

import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum Cookables {

    ANCHOVIES(ItemID.ANCHOVIES, ItemID.RAW_ANCHOVIES, 1, 30, 128, 512, 128, 512),
    COOKED_CHICKEN(ItemID.COOKED_CHICKEN, ItemID.RAW_CHICKEN, 1, 30, 128, 512, 128, 512),
    COOKED_MEAT(ItemID.COOKED_MEAT, ItemID.RAW_BEEF, 1, 30, 128, 512, 128, 512),
    COOKED_RABBIT(ItemID.COOKED_RABBIT, ItemID.RAW_RABBIT, 1, 30, 128, 512, 128, 512),
    SHRIMPS(ItemID.SHRIMPS, ItemID.RAW_SHRIMPS, 1, 30, 128, 512, 128, 512),
    BREAD(ItemID.BREAD, ItemID.BREAD_DOUGH, 1, 40, -1, -1, 118, 492),
    SARDINE(ItemID.SARDINE, ItemID.RAW_SARDINE, 1, 40, 118, 492, 118, 492),
    UGTHANKI_MEAT(ItemID.UGTHANKI_MEAT, ItemID.RAW_UGTHANKI_MEAT, 1, 40, 40, 252, 30, 253),
    POISON_KARAMBWAN(ItemID.POISON_KARAMBWAN, ItemID.RAW_KARAMBWAN, 1, 80, 108, 472, 108, 472),
    HERRING(ItemID.HERRING, ItemID.RAW_HERRING, 5, 50, 108, 472, 108, 472),
    BAKED_POTATO(ItemID.BAKED_POTATO, ItemID.POTATO, 7, 15, -1, -1, 108, 472),
    MACKEREL(ItemID.MACKEREL, ItemID.RAW_MACKEREL, 10, 60, 98, 452, 98, 452),
    REDBERRY_PIE(ItemID.REDBERRY_PIE, ItemID.UNCOOKED_BERRY_PIE, 10, 78, -1, -1, 98, 452),
    ROAST_BIRD_MEAT(ItemID.ROAST_BIRD_MEAT, ItemID.SKEWERED_BIRD_MEAT, 11, 62.5f, 155, 255, -1, -1),
    THIN_SNAIL_MEAT(ItemID.THIN_SNAIL_MEAT, ItemID.THIN_SNAIL, 12, 70, 93, 444, 93, 444),
    SCRAMBLED_EGG(ItemID.SCRAMBLED_EGG, ItemID.EGG, 13, 50, -1, -1, 90, 438),
    TROUT(ItemID.TROUT, ItemID.RAW_TROUT, 15, 70, 88, 432, 88, 432),
    ROAST_RABBIT(ItemID.ROAST_RABBIT, ItemID.SKEWERED_RABBIT, 16, 72.5f, 160, 255, -1, -1),
    // Missing item id?
    // SPIDER_ON_SHAFT(ItemID.SPIDER_ON_SHAFT, ItemID.SPIDER_ON_SHAFT_RAW, 16, 80, -1, -1, -1, -1),
    // SPIDER_ON_STICK(ItemID.SPIDER_ON_STICK, ItemID.SPIDER_ON_STICK_RAW, 16, 80, -1, -1, -1, -1),
    LEAN_SNAIL_MEAT(ItemID.LEAN_SNAIL_MEAT, ItemID.LEAN_SNAIL, 17, 80, 93, 444, 85, 428),
    COD(ItemID.COD, ItemID.RAW_COD, 18, 75, 83, 422, 88, 432),
    PIKE(ItemID.PIKE, ItemID.RAW_PIKE, 20, 80, 78, 412, 78, 412),
    MEAT_PIE(ItemID.MEAT_PIE, ItemID.UNCOOKED_MEAT_PIE, 20, 110, -1, -1, 78, 412),
    ROAST_BEAST_MEAT(ItemID.ROAST_BEAST_MEAT, ItemID.SKEWERED_BEAST, 21, 82.5f, 180, 255, -1, -1),
    COOKED_CRAB_MEAT(ItemID.COOKED_CRAB_MEAT, ItemID.CRAB_MEAT, 21, 100, 57, 377, 57, 377),
    FAT_SNAIL_MEAT(ItemID.FAT_SNAIL_MEAT, ItemID.FAT_SNAIL, 22, 95, 73, 402, 73, 402),
    COOKED_WILD_KEBBIT(ItemID.COOKED_WILD_KEBBIT, ItemID.RAW_WILD_KEBBIT, 23, 73, -1, -1, -1, -1),
    SALMON(ItemID.SALMON, ItemID.RAW_SALMON, 25, 90, 68, 392, 68, 392),
    STEW(ItemID.STEW, ItemID.UNCOOKED_STEW, 25, 117, 68, 392, 68, 392),
    COOKED_SLIMY_EEL(ItemID.COOKED_SLIMY_EEL, ItemID.RAW_SLIMY_EEL, 28, 95, 63, 382, 63, 382),
    SWEETCORN(ItemID.COOKED_SWEETCORN, ItemID.SWEETCORN, 28, 104, 78, 412, 78, 412),
    MUD_PIE(ItemID.MUD_PIE, ItemID.RAW_MUD_PIE, 29, 128, -1, -1, 58, 372),
    COOKED_BREAM(ItemID.COOKED_BREAM, ItemID.RAW_BREAM, 30, 45, 1, 1, 1, 1),
    COOKED_MOSS_LIZARD(ItemID.COOKED_MOSS_LIZARD, ItemID.RAW_MOSS_LIZARD, 30, 60, 1, 1, 1, 1),
    ROASTED_CHOMPY(ItemID.COOKED_CHOMPY, ItemID.SKEWERED_CHOMPY, 30, 100, 200, 255, -1, -1),
    TUNA(ItemID.TUNA, ItemID.RAW_TUNA, 30, 100, 58, 372, 58, 372),
    APPLE_PIE(ItemID.APPLE_PIE, ItemID.UNCOOKED_APPLE_PIE, 30, 130, -1, -1, 58, 372),
    COOKED_KARAMBWAN(ItemID.COOKED_KARAMBWAN, ItemID.RAW_KARAMBWAN, 30, 190, 70, 255, 70, 255),
    COOKED_LARUPIA(ItemID.COOKED_LARUPIA, ItemID.RAW_LARUPIA, 31, 92, 65, 390, 65, 390),
    FISHCAKE(ItemID.COOKED_FISHCAKE, ItemID.RAW_FISHCAKE, 31, 100, 57, 377, 57, 377),
    COOKED_BARBTAILED_KEBBIT(ItemID.COOKED_BARBTAILED_KEBBIT, ItemID.RAW_BARBTAILED_KEBBIT, 32, 106, 56, 370, 56, 370),
    GARDEN_PIE(ItemID.GARDEN_PIE, ItemID.RAW_GARDEN_PIE, 34, 138, -1, -1, 48, 352),
    RAINBOW_FISH(ItemID.RAINBOW_FISH, ItemID.RAW_RAINBOW_FISH, 35, 110, 56, 370, 56, 370),
    PLAIN_PIZZA(ItemID.PLAIN_PIZZA, ItemID.UNCOOKED_PIZZA, 35, 143, -1, -1, 48, 352),
    CAVE_EEL(ItemID.CAVE_EEL, ItemID.RAW_CAVE_EEL, 38, 115, 38, 332, 38, 332),
    LOBSTER(ItemID.LOBSTER, ItemID.RAW_LOBSTER, 40, 120, 38, 332, 38, 332),
    CAKE(ItemID.CAKE, ItemID.UNCOOKED_CAKE, 40, 180, -1, -1, 38, 332),
    // Missing item id?
    // TANGLED_TOADS_LEGS(ItemID.TANGLED_TOADS_LEGS, ItemID.HALF_MADE_BOWL_TANGLED_TOAD_LEGS, 40, 185, 118, 492, 118, 492),
    COOKED_GRAAHK(ItemID.COOKED_GRAAHK, ItemID.RAW_GRAAHK, 41, 124, 32, 328, 32, 328),
    // No rates on wiki
    // COOKED_JUBBLY(ItemID.COOKED_JUBBLY, ItemID.RAW_JUBBLY, 41, 160, -1, -1, -1, -1),
    FRIED_ONIONS(ItemID.FRIED_ONIONS, ItemID.CHOPPED_ONION, 42, 60, 36, 322, 36, 322),
    BASS(ItemID.BASS, ItemID.RAW_BASS, 43, 130, 33, 312, 33, 312),
    SWORDFISH(ItemID.SWORDFISH, ItemID.RAW_SWORDFISH, 45, 140, 18, 292, 30, 310),
    FRIED_MUSHROOMS(ItemID.FRIED_MUSHROOMS, ItemID.SLICED_MUSHROOMS, 46, 60, 16, 282, 16, 282),
    FISH_PIE(ItemID.FISH_PIE, ItemID.RAW_FISH_PIE, 47, 164, -1, -1, 38, 332),
    COOKED_KYATT(ItemID.COOKED_KYATT, ItemID.RAW_KYATT, 51, 143, 18, 292, 30, 310),
    BOTANICAL_PIE(ItemID.BOTANICAL_PIE, ItemID.UNCOOKED_BOTANICAL_PIE, 52, 180, -1, -1, 20, 300),
    LAVA_EEL(ItemID.LAVA_EEL, ItemID.RAW_LAVA_EEL, 53, 30, 1, 1, 1, 1),
    PITTA_BREAD(ItemID.PITTA_BREAD, ItemID.PITTA_DOUGH, 58, 40, -1, -1, 118, 492),
    MUSHROOM_PIE(ItemID.MUSHROOM_PIE, ItemID.UNCOOKED_MUSHROOM_PIE, 60, 200, -1, -1, 17, 285),
    CURRY(ItemID.CURRY, ItemID.UNCOOKED_CURRY, 60, 280, 38, 332, 38, 332),
    MONKFISH(ItemID.MONKFISH, ItemID.RAW_MONKFISH, 62, 150, 11, 275, 13, 280),
    COOKED_SUNLIGHT_ANTELOPE(ItemID.COOKED_SUNLIGHT_ANTELOPE, ItemID.RAW_SUNLIGHT_ANTELOPE, 68, 175, 8, 254, 8, 265),
    ADMIRAL_PIE(ItemID.ADMIRAL_PIE, ItemID.RAW_ADMIRAL_PIE, 70, 210, -1, -1,15, 270),
    DRAGONFRUIT_PIE(ItemID.DRAGONFRUIT_PIE, ItemID.UNCOOKED_DRAGONFRUIT_PIE, 73, 220, -1, -1, 8, 250),
    SHARK(ItemID.SHARK, ItemID.RAW_SHARK, 80, 210, 1, 202, 1, 232),
    SEA_TURTLE(ItemID.SEA_TURTLE, ItemID.RAW_SEA_TURTLE, 82, 211.3f, 1, 202, 1, 222),
    COOKED_DASHING_KEBBIT(ItemID.COOKED_DASHING_KEBBIT, ItemID.RAW_DASHING_KEBBIT, 82, 215, 1, 194, 1, 224),
    ANGLERFISH(ItemID.ANGLERFISH, ItemID.RAW_ANGLERFISH, 84, 230, 1, 200, 1, 220),
    WILD_PIE(ItemID.WILD_PIE, ItemID.RAW_WILD_PIE, 85, 240, -1, -1, 1, 222),
    DARK_CRAB(ItemID.DARK_CRAB, ItemID.RAW_DARK_CRAB, 90, 215, 10, 222, 10, 222),
    MANTA_RAY(ItemID.MANTA_RAY, ItemID.RAW_MANTA_RAY, 91, 216.3f, 1, 202, 1, 222),
    COOKED_MOONLIGHT_ANTELOPE(ItemID.COOKED_MOONLIGHT_ANTELOPE, ItemID.RAW_MOONLIGHT_ANTELOPE, 92, 220, 1, 185, 1, 200),
    SUMMER_PIE(ItemID.SUMMER_PIE, ItemID.RAW_SUMMER_PIE, 95, 260, -1, -1, 1, 212);

    private final int itemId;
    private final int rawItemId;
    private final int level;
    private final float xp;
    private final int fireLow;
    private final int fireHigh;
    private final int rangeLow;
    private final int rangeHigh;

    Cookables(int itemId, int rawItemId, int level, float xp, int fireLow, int fireHigh, int rangeLow, int rangeHigh)
    {
        this.itemId = itemId;
        this.rawItemId = rawItemId;
        this.level = level;
        this.xp = xp;
        this.fireLow = fireLow;
        this.fireHigh = fireHigh;
        this.rangeLow = rangeLow;
        this.rangeHigh = rangeHigh;
    }

    public double calculateFireChance(int level)
    {
        if(fireLow == -1 || fireHigh == -1)
        {
            return 0;
        }
		double value = Math.floor(fireLow * (99 - level) / 98.0) + Math.floor(fireHigh * (level - 1) / 98.0) + 1;
		value = Math.min(Math.max(value / 256.0, 0), 1);
		return value * 100;
    }

    public double calculateRangeChance(int level)
    {
        if(rangeLow == -1 || rangeHigh == -1)
        {
            return 0;
        }
        double value = Math.floor(rangeLow * (99 - level) / 98.0) + Math.floor(rangeHigh * (level - 1) / 98.0) + 1;
        value = Math.min(Math.max(value / 256.0, 0), 1);
        return value * 100;
    }

    public static Cookables fromItemId(int itemId)
    {
        for (Cookables cookable : values())
        {
            if (cookable.getRawItemId() == itemId)
            {
                return cookable;
            }
        }
        return null;
    }

}
