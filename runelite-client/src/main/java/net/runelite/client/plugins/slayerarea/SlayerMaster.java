package net.runelite.client.plugins.slayerarea;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public enum SlayerMaster
{
	TURAEL("Turael", "Banshees", "Bats", "Birds", "Bears", "Cave bugs", "Cave crawlers", "Cave slimes", "Cows", "Crawling Hands", "Lizards", "Dogs", "Dwarves", "Ghosts", "Goblins", "Icefiends", "Kalphites", "Minotaurs", "Monkeys", "Rats", "Scorpions", "Skeletons", "Spiders", "Wolves", "Zombies"),
	KRYSTILIA("Krystilia", "Ankou", "Aviansie", "Bandits", "Bears", "Black demons", "Black dragons", "Chaos druids", "Dark warriors", "Earth warriors", "Ents", "Fire giants", "Greater demons", "Green dragons", "Hellhounds", "Ice giants", "Ice warriors", "Lava dragons", "Lesser demons", "Magic axes", "Mammoths", "Revenants", "Rogues", "Scorpions", "Skeletons", "Spiders", "Spiritual creatures", "Crazy archaeologist", "Scorpia", "Chaos Elemental", "Callisto", "Venenatis", "Vet'ion"),
	MUZCHNA("Mazchna", "Banshees", "Bats", "Bears", "Catablepons", "Cave bugs", "Cave crawlers", "Cave slimes", "Cockatrice", "Crawling Hands", "Lizards", "Dogs", "Earth warriors", "Flesh Crawlers", "Ghosts", "Ghouls", "Hill Giants", "Hobgoblins", "Ice warriors", "Kalphites", "Killerwatts", "Mogres", "Pyrefiends", "Rockslugs", "Scorpions", "Shades", "Skeletons", "Vampyres", "Wall beasts", "Wolves", "Zombies"),
	VANNAKA("Vannaka", "Aberrant spectres", "Abyssal demons", "Ankou", "Banshees", "Basilisks", "Bloodvelds", "Blue dragons", "Brine rats", "Bronze dragons", "Cave bugs", "Cave crawlers", "Cave slimes", "Cockatrice", "Crawling Hands", "Crocodiles", "Dagannoth", "Lizards", "Dust devils", "Earth warriors", "Elves", "Fever spiders", "Fire giants", "Gargoyles", "Ghouls", "Green dragons", "Harpie bug swarms", "Hellhounds", "Hill giants", "Hobgoblins", "Ice giants", "Ice warriors", "Infernal Mages", "Jellies", "Jungle horrors", "Kalphites", "Killerwatts", "Kurask", "Lesser demons", "Mogres", "Molanisk", "Moss giants", "Nechryael", "Ogres", "Otherworldly beings", "Pyrefiends", "Rockslugs", "Shades", "Sea snakes", "Shadow warriors", "Spiritual creatures", "Terror dogs", "Trolls", "Turoth", "Vampyre", "Wall beasts", "Werewolves"),
	CHAELDAR("Chaeldar", "Aberrant spectres", "Abyssal demons", "Aviansies", "Banshees", "Basilisks", "Black demons", "Bloodvelds", "Blue dragons", "Brine rats", "Bronze dragons", "Cave crawlers", "Cave horrors", "Cave kraken", "Cave slimes", "Cockatrice", "Dagannoth", "Dust devils", "Elves", "Fever spiders", "Fire giants", "Fossil Island Wyverns", "Gargoyles", "Greater demons", "Harpie Bug Swarms", "Hellhounds", "Infernal Mages", "Iron dragons", "Jellies", "Jungle horrors", "Kalphites", "Kurask", "Lesser demons", "Lizardmen", "Lizards", "Mogres", "Molanisk", "Mutated zygomites", "Nechryael", "Pyrefiends", "Rockslugs", "Shadow warriors", "Skeletal Wyverns", "Spiritual creatures", "Steel dragons", "Trolls", "Turoth", "TzHaar", "Wall beasts", "Wyrm"),
	KONAR("Konar", "Aberrant spectres", "Abyssal demons", "Adamant dragons", "Ankou", "Aviansie", "Black demons", "Black dragons", "Bloodvelds", "Blue dragons", "Brine rats", "Bronze dragons", "Cave kraken", "Dagannoth", "Dark beasts", "Drakes", "Dust devils", "Fire giants", "Fossil Island Wyverns", "Gargoyles", "Greater demons", "Hellhounds", "Hydras", "Iron dragons", "Jellies", "Kalphites", "Kurasks", "Lizardmen", "Mithril dragons", "Mutated Zygomites", "Nechryael", "Red dragons", "Rune dragons", "Skeletal Wyverns", "Smoke devils", "Steel dragons", "Trolls", "Turoth", "Waterfiends", "Wyrms", "Abyssal Sire", "Barrows Brothers", "Callisto", "Cerberus", "Chaos Elemental", "Chaos Fanatic", "Commander Zilyana", "Crazy archaeologist", "Dagannoth Kings", "General Graardor", "giants Mole", "Grotesque Guardians", "Kalphites Queen", "King Black dragons", "Kraken", "Kree'arra", "K'ril Tsutsaroth", "Scorpia", "Thermonuclear smoke devil", "Venenatis", "Vet'ion", "Vorkath", "Zulrah"),
	NIEVE("Nieve", "Aberrant spectres", "Abyssal demons", "Adamant dragons", "Ankou", "Aviansie", "Black demons", "Black dragons", "Bloodvelds", "Blue dragons", "Brine rats", "Cave horror", "Cave kraken", "Dagannoth", "Dark beasts", "Drakes", "Dust devils", "Elves", "Fire giants", "Fossil Island Wyverns", "Gargoyles", "Greater demons", "Hellhounds", "Iron dragons", "Kalphites", "Kurask", "Lizardmen", "Minions of Scabaras", "Mithril dragons", "Mutated Zygomites", "Nechryael", "Red dragons", "Rune dragons", "Skeletal Wyverns", "Smoke devils", "Spiritual creatures", "Steel dragons", "Suqahs", "Trolls", "Turoth", "TzHaar", "Wyrms", "Abyssal Sire", "Barrows Brothers", "Callisto", "Cerberus", "Chaos Elemental", "Chaos Fanatic", "Commander Zilyana", "Crazy archaeologist", "Dagannoth Kings", "General Graardor", "giants Mole", "Grotesque Guardians", "Kalphites Queen", "King Black dragons", "Kraken", "Kree'arra", "K'ril Tsutsaroth", "Scorpia", "Thermonuclear smoke devil", "Venenatis", "Vet'ion", "Vorkath", "Zulrah"),
	DURADEL("Duradel", "Aberrant spectres", "Abyssal demons", "Adamant dragons", "Ankou", "Aviansie", "Black demons", "Black dragons", "Bloodvelds", "Blue dragons", "Cave horrors", "Cave kraken", "Dagannoth", "Dark beasts", "Drakes", "Dust devils", "Elves", "Fire giants", "Fossil Island Wyverns", "Gargoyles", "Greater demons", "Hellhounds", "Iron dragons", "Kalphites", "Kurask", "Lizardmen", "Mithril dragons", "Mutated Zygomites", "Nechryael", "Red dragons", "Rune dragons", "Skeletal Wyverns", "Smoke devils", "Spiritual creatures", "Steel dragons", "Suqahs", "Trolls", "TzHaar", "Waterfiends", "Wyrms", "Abyssal Sire", "Barrows Brothers", "Callisto", "Cerberus", "Chaos Elemental", "Chaos Fanatic", "Commander Zilyana", "Crazy archaeologist", "Dagannoth Kings", "General Graardor", "giants Mole", "Grotesque Guardians", "Kalphites Queen", "King Black dragons", "Kraken", "Kree'arra", "K'ril Tsutsaroth", "Scorpia", "Thermonuclear smoke devil", "Venenatis", "Vet'ion", "Vorkath", "Zulrah");


	private final String name;
	private final String[] monsters;

	private static final Map<String, SlayerMaster> masters = new HashMap<>();

	static
	{
		for (SlayerMaster master : values())
		{
			masters.put(master.getName().toLowerCase(), master);
		}
	}

	SlayerMaster(String name, String... monsters)
	{
		this.name = name;
		this.monsters = monsters;
	}

	public static SlayerMaster getMaster(String query)
	{
		return masters.get(query.toLowerCase());
	}
}
