package net.runelite.client.plugins.spellbook;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Spellbook
{
	STANDARD(0, "standard"),
	ANCIENT(1, "ancient"),
	LUNAR(2, "lunar"),
	ARCEUUS(3, "arceuus");

	@Getter
	private final int id;

	@Getter
	private final String configKey;

	private static final Map<Integer, Spellbook> map = new HashMap<>();

	static
	{
		for (Spellbook s : values())
		{
			map.put(s.id, s);
		}
	}

	public static Spellbook getByID(int id)
	{
		return map.get(id);
	}
}
