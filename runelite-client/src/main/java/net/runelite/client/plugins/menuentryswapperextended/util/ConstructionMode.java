package net.runelite.client.plugins.menuentryswapperextended.util;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

@Getter
public enum ConstructionMode
{
	// Didn't include expensive/marble/obsidian items because I doubt anyone is training construction that way
	// and it's probably best so people don't one click yeet 3m gp on accident
	ATTACK_STONE("Attack Stone",
		new String[]{"build", "remove"},
		new String[]{"clay attack stone", "limestone attack stone", "marble attack stone", "stone space", "attack stone"}),
	BENCH("Benches",
		new String[]{"build", "remove"},
		new String[]{"bench", "seating space", "gnome bench", "teak garden bench", "wooden bench", "oak bench", "carved oak bench",
			"Teak dining bench", "carved teak bench", "mahogany bench"}),
	CHAIR("Chairs",
		new String[]{"build", "remove"},
		new String[]{"chair", "chair space", "crude wooden chair", "wooden chair", "oak chair",
			"rocking chair", "oak armchair", "teak armchair", "mahogany armchair"}),
	DUNGEON("Dungeon doors",
		new String[]{"build", "remove"},
		new String[]{"door", "door space", "marble door", "oak door", "steel-plated door"}),
	LARDER("Larders",
		new String[]{"build", "remove"},
		new String[]{"larder", "larder space", "wooden larder", "oak larder", "teak larder"}),
	MYTH_CAPE("Myth cape",
		new String[]{"build", "remove"},
		new String[]{"cape", "guild trophy space", "mythical cape"}),
	TABLE("Tables",
		new String[]{"build", "remove"},
		new String[]{"table", "kitchen table", "oak kitchen table", "teak kitchen table", "table space", "teak table", "mahogany table",
			"wood dining table", "oak dining table", "carved oak table", "teak dining table", "carved teak table", "opulent table"});

	private final String name;
	private final String[] options;
	private final String[] targets;

	ConstructionMode(String name, String[] options, String[] targets)
	{
		this.name = name;
		this.options = options;
		this.targets = targets;
	}

	@Override
	public String toString()
	{
		return name;
	}

	/**
	 * Get array of strings relating to construction
	 *
	 * @return String[] - returns an array of type String
	 */
	public String[] getOptions()
	{
		return options;
	}

	/**
	 * Get array of strings of targets to build or remove
	 *
	 * @return String[] - returns an array of type String
	 */
	public String[] getTargets()
	{
		return targets;
	}

	/**
	 * Get a list of all targets
	 *
	 * @return List of type String
	 */
	public List<String> getTargetList()
	{
		return Arrays.asList(targets);
	}

	/**
	 * Get a list of all options
	 *
	 * @return List of type String
	 */
	public List<String> getOptionsList()
	{
		return Arrays.asList(options);
	}
}
