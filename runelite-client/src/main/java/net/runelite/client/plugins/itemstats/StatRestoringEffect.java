package net.runelite.client.plugins.itemstats;

import com.google.common.annotations.VisibleForTesting;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.client.plugins.itemstats.stats.Stat;

import java.util.Comparator;
import java.util.stream.Stream;

import static net.runelite.client.plugins.itemstats.Builders.perc;
import static net.runelite.client.plugins.itemstats.stats.Stats.*;

@RequiredArgsConstructor
public class StatRestoringEffect implements Effect 
{

	private static final Stat[] superRestoreStats = {
			ATTACK, DEFENCE, STRENGTH, RANGED, MAGIC, COOKING,
			WOODCUTTING, FLETCHING, FISHING, FIREMAKING, CRAFTING, SMITHING, MINING,
			HERBLORE, AGILITY, THIEVING, SLAYER, FARMING, RUNECRAFT, HUNTER,
			CONSTRUCTION
	};

	@VisibleForTesting
	public final double percR; //percentage restored
	private final int delta;
	private final SingleEffect effect;
	
	@Override
	public final StatsChanges calculate(Client client) 
	{
		StatsChanges changes = new StatsChanges(0);
		SimpleStatBoost calc = new SimpleStatBoost(null, false, perc(percR, delta));
		changes.setStatChanges(Stream.concat(
				Stream.of(effect.effect(client)),
				Stream.of(superRestoreStats)
						.filter(stat -> stat.getValue(client) < stat.getMaximum(client))
						.map(stat ->
						{
							calc.setStat(stat);
							return calc.effect(client);
						})
		).toArray(StatChange[]::new));
		changes.setPositivity(Stream.of(changes.getStatChanges())
				.map(sc -> sc.getPositivity())
				.max(Comparator.naturalOrder()).get());
		return changes;
	}
}
