package net.runelite.client.plugins.chatcommands.killsimulator;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WeightedRandom<T> extends HashMap<T, Double> {

	private static final long serialVersionUID = 6305103990515771779L;
	private final Random random;
	
	public WeightedRandom(Random random) {
		this.random = random;
	}
	
	public WeightedRandom() {
		this(new SecureRandom());
	}

	public T getRandom(double chanceMultiplier) {
		double goal = random.nextDouble();
		goal /= chanceMultiplier;
		List<Entry<T, Double>> entries = Collections.list(Collections.enumeration(entrySet()));
		Collections.shuffle(entries);
		for(Entry<T, Double> entry : entries) {
			goal -= entry.getValue();
			if(goal <= 0.0D) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public T getRandom() {
		return getRandom(1D);
	}
}