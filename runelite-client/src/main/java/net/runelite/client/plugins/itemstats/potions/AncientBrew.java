package net.runelite.client.plugins.itemstats.potions;

import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.client.plugins.itemstats.*;
import net.runelite.client.plugins.itemstats.stats.Stat;

import java.util.stream.Stream;

import static net.runelite.client.plugins.itemstats.Builders.perc;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;

@RequiredArgsConstructor
public class AncientBrew implements Effect {

    private static final Stat[] ancientBrewStats = {
            ATTACK, STRENGTH, DEFENCE
    };

    //Prayer
    private final double percR; //percentage restored
    private final int delta;
    //Magic
    private final double percB; //percentage restored
    private final int deltaB; //percentage restored
    //Draining stats ( Attack, Strength, Defence)
    private final double percSD; //percentage stat drain
    private final int deltaR; // Delta reduced

    @Override
    public StatsChanges calculate(Client client) {
        StatsChanges changes = new StatsChanges(0);
        PrayerPotion prayer = new PrayerPotion(delta, percR);
        SimpleStatBoost magic = new SimpleStatBoost(MAGIC, true, perc(percB, deltaB));
        BoostedStatBoost calc = new BoostedStatBoost(null, false, perc(percSD, -deltaR));

        changes.setStatChanges(Stream.concat(
                Stream.of(magic.effect(client)),
                Stream.concat(
                        Stream.of(prayer.effect(client)),
                        Stream.of(ancientBrewStats)
                                .filter(stat -> 1 < stat.getValue(client))
                                .map(stat ->
                                {
                                    calc.setStat(stat);
                                    return calc.effect(client);
                                })
                )
        ).toArray(StatChange[]::new));

        return changes;
    }
}