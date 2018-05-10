package net.runelite.client.plugins.chatcommands.killsimulator.bosses;

import net.runelite.client.plugins.chatcommands.killsimulator.CounterList;
import net.runelite.client.plugins.chatcommands.killsimulator.WeightedRandom;

public class Boss {

    private final WeightedRandom<String> drops;

    public Boss() {
        drops = new WeightedRandom<String>();
    }

    protected void add(String itemName, double rarity) {
        drops.put(itemName, rarity);
    }

    public WeightedRandom<String> getDrops() {
        return drops;
    }
}
