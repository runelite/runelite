package net.runelite.client.plugins.chatcommands.killsimulator;

import java.util.HashMap;
import java.util.Map;

public class Boss {

    private final String[] names;
    private final WeightedRandom<String> drops;

    public Boss(String... names) {
        this.names = names;
        this.drops = new WeightedRandom<String>();
    }

    protected void add(String itemName, double rarity) {
        drops.put(itemName, rarity);
    }

    protected void addAll(Map<String, Double> map) {
        drops.putAll(map);
    }

    public String[] getNames() {
        return names;
    }

    public WeightedRandom<String> getDrops() {
        return drops;
    }

    public static Boss ZULRAH() {
        return new Boss("zulrah", "snake") {
            {
                add("Tanzanite fang", 1D / 512D);
                add("Magic fang", 1D / 512D);
                add("Serpentine visage", 1D / 512D);
                add("Uncut onyx", 1D / 512D);
                add("Pet snakeling", 1D / 4000D);
                add("Tanzanite mutagen", 1D/6553D);
                add("Magma mutagen", 1D / 6553D);
            }
        };
    }

    public static Boss BANDOS() {
        return new Boss("bandos", "graardor") {
            {
               addAll(GODWARS_ITEMS());
               addAll(RARE_DROP_TABLE());
               add("Bandos chestplate", 1D / 384D);
               add("Bandos tassets", 1D / 384D);
               add("Bandos boots", 1D / 384D);
               add("Bandos hilt", 1D / 508D);
               add("Pet general graardor", 1D / 5000D);
            }
        };
    }

    public static Boss ZAMORAK() {
        return new Boss("zamorak", "zammy", "krill") {
            {
                addAll(GODWARS_ITEMS());add("Bandos chestplate", 1D / 384D);
                add("Zamorakian spear", 1D / 128D);
                add("Staff of the dead", 1D / 508D);
                add("Zamorak hilt", 1D / 508D);
                add("Pet k'ril tsutsaroth", 1D / 5000D);
            }
        };
    }

    public static Boss SARADOMIN() {
        return new Boss("saradomin", "zilyana", "sara") {
            {
                addAll(GODWARS_ITEMS());
                add("Saradomin sword", 1D / 127D);
                add("Armadyl crossbow", 1D / 508D);
                add("Saradomin light", 1D / 254D);
                add("Saradomin hilt", 1D / 508D);
                add("Pet zilyana", 1D / 5000D);
            }
        };
    }

    public static Boss ARMADYL() {
        return new Boss("armadyl", "arma", "kree", "kreearra") {
            {
                addAll(GODWARS_ITEMS());
                addAll(RARE_DROP_TABLE());
                add("Armadyl chestplate", 1D / 384D);
                add("Armadyl chainskirt", 1D / 384D);
                add("Armadyl helmet", 1D / 384D);
                add("Armadyl hilt", 1D / 384D);
                add("Pet kree'arra", 1D / 5000D);
            }
        };
    }

    public static Map<String, Double> GODWARS_ITEMS() {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("Elite cluescroll", 1D / 250D);
        map.put("Godsword shard 1", 1D / 768D);
        map.put("Godsword shard 2", 1D / 768D);
        map.put("Godsword shard 3", 1D / 768D);
        return map;
    }

    public static Map<String, Double> RARE_DROP_TABLE() {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("Long bone", 1D / 400D);
        map.put("Curved bone", 1D / 5000D);
        return map;
    }
}