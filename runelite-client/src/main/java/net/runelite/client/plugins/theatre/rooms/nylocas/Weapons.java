package net.runelite.client.plugins.theatre.rooms.nylocas;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.menus.AbstractComparableEntry;
import net.runelite.client.menus.ComparableEntries;

@Getter
@AllArgsConstructor
public enum Weapons
{
	MELEE(ImmutableSet.of(ItemID.ABYSSAL_WHIP, ItemID.ABYSSAL_TENTACLE, ItemID.SCYTHE_OF_VITUR,
		ItemID.SCYTHE_OF_VITUR_22664, ItemID.SCYTHE_OF_VITUR_UNCHARGED, ItemID.HAM_JOINT, ItemID.SWIFT_BLADE,
		ItemID.BANDOS_GODSWORD, ItemID.BANDOS_GODSWORD_20782, ItemID.BANDOS_GODSWORD_21060, ItemID.BANDOS_GODSWORD_OR,
		ItemID.DRAGON_WARHAMMER, ItemID.DRAGON_CLAWS, ItemID.EVENT_RPG, ItemID.GHRAZI_RAPIER, ItemID.GHRAZI_RAPIER_23628,
		ItemID.BLADE_OF_SAELDOR, ItemID.CRYSTAL_HALBERD, ItemID.DRAGON_SCIMITAR, ItemID.RUNE_SCIMITAR, ItemID.BLADE_OF_SAELDOR_23996,
		ItemID.BLADE_OF_SAELDOR_INACTIVE, ItemID.BLADE_OF_SAELDOR_INACTIVE_23999),
		ImmutableSet.of(ComparableEntries.newBaseComparableEntry("Attack", "Nylocas Hagios"),
			ComparableEntries.newBaseComparableEntry("Attack", "Nylocas Toxobolos"))
	),
	MAGE(ImmutableSet.of(ItemID.KODAI_WAND, ItemID.MASTER_WAND, ItemID.TRIDENT_OF_THE_SEAS,
		ItemID.TRIDENT_OF_THE_SWAMP, ItemID.SANGUINESTI_STAFF, ItemID.IBANS_STAFF, ItemID.IBANS_STAFF_1410,
		ItemID.IBANS_STAFF_U, ItemID.TRIDENT_OF_THE_SWAMP_E, ItemID.TRIDENT_OF_THE_SEAS_E),
		ImmutableSet.of(ComparableEntries.newBaseComparableEntry("Attack", "Nylocas Ischyros"),
			ComparableEntries.newBaseComparableEntry("Attack", "Nylocas Toxobolos"))
	),
	RANGE(ImmutableSet.of(ItemID.TOXIC_BLOWPIPE, ItemID.TWISTED_BOW, ItemID.CRAWS_BOW,
		ItemID.RED_CHINCHOMPA, ItemID.CHINCHOMPA, ItemID.BLACK_CHINCHOMPA, ItemID.ARMADYL_CROSSBOW,
		ItemID.DRAGON_CROSSBOW, ItemID.RUNE_CROSSBOW, ItemID.DORGESHUUN_CROSSBOW),
		ImmutableSet.of(ComparableEntries.newBaseComparableEntry("Attack", "Nylocas Hagios"),
			ComparableEntries.newBaseComparableEntry("Attack", "Nylocas Ischyros"))
	);

	private final Set<Integer> ids;
	private final Set<AbstractComparableEntry> entries;
	private static final Map<Set<Integer>, Set<AbstractComparableEntry>> map;

	static
	{
		final ImmutableMap.Builder<Set<Integer>, Set<AbstractComparableEntry>> builder = new ImmutableMap.Builder<>();
		for (Weapons weps : Weapons.values())
		{
			builder.put(weps.getIds(), weps.getEntries());
		}
		map = builder.build();
	}

	@Nullable
	static Set<AbstractComparableEntry> getEntries(int id)
	{
		final Set<AbstractComparableEntry> entries = new HashSet<>();

		for (Map.Entry<Set<Integer>, Set<AbstractComparableEntry>> entry : map.entrySet())
		{
			if (entry.getKey().contains(id))
			{
				entries.addAll(entry.getValue());
				break;
			}
		}

		return entries;
	}
}
