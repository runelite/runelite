package net.runelite.client.plugins.chatcommands;

import java.util.HashMap;
import java.util.Map;

public class BossAbbreviations {
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{

	}
	/**
	 * Takes a string representing the name of a boss, and if abbreviated,
	 * expands it into its full canonical name. Case-insensitive.
	 *
	 * @param abbrev Skill name that may be abbreviated.
	 * @return Full skill name if recognized, else the original string.
	 */
	static String getFullName(String abbrev)
	{
		return MAP.getOrDefault(abbrev.toUpperCase(), abbrev);
	}
}
