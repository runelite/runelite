package net.runelite.client.plugins.itemprices;

import lombok.Getter;
import net.runelite.api.ItemID;

import java.util.HashMap;
import java.util.Map;

public enum Herbs
{

	GRIMY_GUAM_LEAF_HERB("grimy guam leaf", ItemID.GRIMY_GUAM_LEAF),
	GRIMY_GRIMY_MARRENTILL_HERB("grimy marrentill", ItemID.GRIMY_MARRENTILL),
	GRIMY_GRIMY_TARROMIN_HERB("grimy tarromin", ItemID.GRIMY_TARROMIN),
	GRIMY_GRIMY_HARRALANDER_HERB("grimy harralander", ItemID.GRIMY_HARRALANDER),
	GRIMY_GRIMY_TOADFLAX_HERB("grimy toadflax", ItemID.GRIMY_TOADFLAX),
	GRIMY_RANARR_WEED_HERB("grimy ranarr weed", ItemID.GRIMY_RANARR_WEED),
	GRIMY_IRIT_LEAF_HERB("grimy irit leaf", ItemID.GRIMY_IRIT_LEAF),
	GRIMY_AVANTOE_HERB("grimy avantoe", ItemID.GRIMY_AVANTOE),
	GRIMY_KWUARM_HERB("grimy kwuarm", ItemID.GRIMY_KWUARM),
	GRIMY_SNAPDRAGON_HERB("grimy snapdragon", ItemID.GRIMY_SNAPDRAGON),
	GRIMY_CADANTINE_HERB("grimy cadantine", ItemID.GRIMY_CADANTINE),
	GRIMY_LANTADYME_HERB("grimy lantadyme", ItemID.GRIMY_LANTADYME),
	GRIMY_DWARF_WEED_HERB("grimy dwarf weed", ItemID.GRIMY_DWARF_WEED),
	GRIMY_TORSTOL_HERB("grimy torstol", ItemID.GRIMY_TORSTOL);

	@Getter
	private final int itemId;

	@Getter
	private final String itemName;

	private static final Map<String, Herbs> herbs = new HashMap<>();

	static
	{
		for (Herbs s : values())
		{
			herbs.put(s.getItemName(), s);
		}
	}

	Herbs(String itemName, int itemId)
	{
		this.itemName = itemName;
		this.itemId = itemId;
	}

	public static Herbs getHerbs(String itemName)
	{
		return herbs.get(itemName);
	}

}