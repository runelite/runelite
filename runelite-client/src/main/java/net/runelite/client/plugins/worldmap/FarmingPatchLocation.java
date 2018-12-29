package net.runelite.client.plugins.worldmap;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
enum FarmingPatchLocation
{
	AL_KHARID_CACTUS("Cactus", new WorldPoint(3313, 3201, 0)),
	ARDOUGNE_BUSH("Bush", new WorldPoint(2615, 3224, 0)),
	ARDOUGNE_ALLOTMENT("Allotment/Herb/Flower", new WorldPoint(2663, 3375, 0)),
	BRIMHAVEN_SPIRIT_TREE("Spirit Tree", new WorldPoint(2799, 3205, 0)),
	BRIMHAVEN_FRUIT_TREE("Fruit Tree", new WorldPoint(2765, 3211, 0)),
	CATHERBY_ALLOTMENT("Allotment/Herb/Flower", new WorldPoint(2810, 3462, 0)),
	CATHERBY_FRUIT_TREE("Fruit Tree", new WorldPoint(2858, 3432, 0)),
	CHAMPIONS_GUILD_BUSH("Bush", new WorldPoint(3182, 3356, 0)),
	DRAYNOR_MANOR_BELLADONNA("Belladonna", new WorldPoint(3084, 3356, 0)),
	ENTRANA_HOPS("Hops", new WorldPoint(3812, 3334, 0)),
	ETCETERIA_BUSH("Bush", new WorldPoint(2589, 3862, 0)),
	ETCETERIA_SPIRIT_TREE("Spirit Tree", new WorldPoint(3614, 3856, 0)),
	FALADOR_TREE("Tree", new WorldPoint(3005, 3375, 0)),
	FALADOR_ALLOTMENT("Allotment/Herb/Flower", new WorldPoint(3052, 3309, 0)),
	FOSSIL_ISLAND_HARDWOOD("Hardwood", new WorldPoint(3707, 3838, 0)),
	FOSSIL_ISLAND_SEAWEED("Seaweed", new WorldPoint(3730, 10271, 0)),
	GNOME_STRONGHOLD_TREE("Tree", new WorldPoint(2434, 3418, 0)),
	GNOME_STRONGHOLD_FRUIT_TREE("Fruit Tree", new WorldPoint(2472, 3445, 0)),
	HARMONY_ALLOTMENT("Allotment/Herb/Flower", new WorldPoint(3793, 2836, 0)),
	HARMONY_HERB("Herb", new WorldPoint(3789, 2840, 0)),
	KOUREND_ALLOTMENT("Allotment/Herb/Flower", new WorldPoint(1809, 3490, 0)),
	KOUREND_SPIRIT_TREE("Spirit Tree", new WorldPoint(1690, 3540, 0)),
	KOUREND_GRAPES("Grapes", new WorldPoint(1807, 3555, 0)),
	LLTEYA_FRUIT_TREE("Fruit Tree", new WorldPoint(2343, 3160, 0)),
	LUMBRIDGE_HOPS("Hops", new WorldPoint(3224, 3313, 0)),
	LUMBRIDGE_TREE("Tree", new WorldPoint(3189, 3233, 0)),
	MORYTANIA_MUSHROOM("Mushroom", new WorldPoint(3449, 3471, 0)),
	MORYTANIA_ALLOTMENT("Allotment/Herb/Flower", new WorldPoint(3598, 3524, 0)),
	PORT_SARIM_SPIRIT_TREE("Spirit Tree", new WorldPoint(3056, 3259, 0)),
	RIMMINGTON_BUSH("Bush", new WorldPoint(2938, 3223, 0)),
	SEERS_VILLAGE_HOPS("Hops", new WorldPoint(2661, 3523, 0)),
	TAI_BWO_WANNAI_CALQUAT("Calquat", new WorldPoint(2793, 3099, 0)),
	TAVERLEY_TREE("Tree", new WorldPoint(2933, 3436, 0)),
	TREE_GNOME_VILLAGE_FRUIT_TREE("Fruit tree", new WorldPoint(2487, 3181, 0)),
	TROLL_STRONGHOLD_HERB("Herb", new WorldPoint(2828, 3696, 0)),
	VARROCK_TREE("Tree", new WorldPoint(3226, 3457, 0)),
	YANILLE_HOPS("Hops", new WorldPoint(2572, 3102, 0)),
	WEISS_HERB("Herb", new WorldPoint(2847, 3933, 0));


	private final String tooltip;
	private final WorldPoint location;

	FarmingPatchLocation(String description, WorldPoint location)
	{
		this.tooltip = "Farming patch - " + description;
		this.location = location;
	}
}
