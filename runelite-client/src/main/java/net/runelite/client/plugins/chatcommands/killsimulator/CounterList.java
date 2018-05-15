package net.runelite.client.plugins.chatcommands.killsimulator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CounterList<T> extends HashMap<T, Integer> implements Serializable {

	private static final long serialVersionUID = -7294770111928971161L;

	public void add(T object) {
		if(containsKey(object)) {
			put(object, get(object) + 1);
		} else {
			put(object, 1);
		}
	}
}
