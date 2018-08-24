package net.runelite.client.plugins.farmingprofit;

import net.runelite.api.ItemID;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Seeds {

    RANARR(ItemID.GRIMY_RANARR_WEED, ItemID.RANARR_SEED);

    Seeds(int product, int seed)
    {
        this.product = product;
        this.seed = seed;
    }

    private final int product;
    private final int seed;
    private static final Map<Integer, Integer> map = Collections.unmodifiableMap(initializeMapping());

    public static Integer seedOf(int product) {
        if (map.containsKey(product)) {
            return map.get(product);
        }
        return -1;
    }

    private static Map<Integer, Integer> initializeMapping() {
        Map<Integer, Integer> mMap = new HashMap<Integer, Integer>();
        for (Seeds s : Seeds.values()) {
            mMap.put(s.product, s.seed);
        }
        return mMap;
    }

}
