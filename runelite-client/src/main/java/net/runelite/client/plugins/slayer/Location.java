/*
 * Copyright (c) 2023, Macweese <https://github.com/Macweese>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.slayer;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import java.util.Arrays;
import java.util.Map;

enum Location
{
	ANYWHERE(0, ""),
	CATACOMBS_OF_KOUREND(1, "Catacombs of Kourend", 6556, 6557, 6812, 6813),
	STRONGHOLD_SLAYER_DUNGEON(2, "Stronghold Slayer Dungeon", 9624, 9625, 9880, 9881),
	KARUULM_SLAYER_DUNGEON(3, "Karuulm Slayer Dungeon", 4510, 4511, 4512, 4766, 4767, 4768, 5022, 5023, 5279, 5280, 5535, 5536),
	CHASM_OF_FIRE(4, "Chasm of Fire", 5530, 5531, 5532, 5533),
	BRIMHAVEN_DUNGEON(5, "Brimhaven Dungeon", 10643, 10644, 10645, 10899, 10900, 10901),
	TAVERLEY_DUNGEON(6, "Taverley Dungeon", 11416, 11417, 11671, 11672, 11673),
	WITCHAVEN_DUNGEON(7, "Witchaven Dungeon", 9295, 10903),
	WATERFALL_DUNGEON(8, "Waterfall Dungeon", 10394),
	SLAYER_TOWER(9, "Slayer Tower", 13623),
	GOD_WARS_DUNGEON(10, "God Wars Dungeon", 11344, 11345, 11346, 11347, 11600, 11601, 11602, 11603, 11858),
	KALPHITE_LAIR(11, "Kalphite Lair", 12691, 12692, 12947, 12948),
	KALPHITE_LAIR_TASK_ONLY(12, "Task-only Kalphite Cave", 13460, 13461, 13716, 13717),
	KRAKEN_COVE(13, "Kraken Cove", 9116),
	LIGHTHOUSE(14, "Lighthouse", 10140),
	WATERBIRTH_ISLAND(15, "Waterbirth Island", 7492, 7748, 9886, 10137, 10138, 10139, 10140, 10141, 10142, 10390,
			10391, 10393, 10394, 10395, 10396, 10397, 10646, 10647, 10648, 10649, 10650, 10651, 10902, 10903, 10904, 10905, 10907, 10909, 11588, 11589),
	LIZARDMAN_CANYON(16, "Lizardman Canyon", 5945, 5946, 6201, 6202),
	MOLCH(17, "Molch", 5177, 5276, 5277),
	LIZARDMAN_SETTLEMENT(18, "Lizardman Settlement", 5174, 5175, 5275, 5430, 5431),
	SMOKE_DEVIL_DUNGEON(19, "Smoke Devil Dungeon", 9363, 9619),
	SMOKE_DUNGEON(20, "Smoke Dungeon", 12690, 12946, 13202),
	DEATH_PLATEAU(21, "Death Plateau", 11319, 11320, 11575, 11576),
	TROLL_STRONGHOLD(22, "Troll Stronghold", 11321, 11421, 11577, 11677, 11678, 11934),
	KELDAGRIM(23, "Keldagrim", 11421, 11422),
	MOUNT_QUIDAMORTEM(24, "Mount Quidamortem", 4663, 4919, 4662, 4918),
	// No information on wiki
	FREMENNIK_ISLES(25, "Fremennik Isles", 9275, 9276, 9531, 9532, 9632),
	FREMENNIK_SLAYER_DUNGEON(26, "Fremennik Slayer Dungeon", 10907, 10908, 11164),
	MYTHS_GUILD_DUNGEON(27, "Myths' Guild Dungeon", 7564, 7820, 7821, 8076),
	MOURNER_TUNNELS(28, "Mourner Tunnels", 7752, 8008),
	LITHKREN_VAULT(29, "Lithkren Vault", 6223),
	ANCIENT_CAVERN(30, "Ancient Cavern", 6483, 6995, 7251, 7252),
	STRONGHOLD_OF_SECURITY(31, "Stronghold of Security", 7505, 8017, 8530, 9297),
	FOSSIL_ISLAND(32, "Fossil Island", 14394, 14395, 14396, 14649, 14650, 14651, 14652, 14906, 14907, 14908, 15162, 15163, 15164),
	ASGARNIAN_ICE_DUNGEON(33, "Asgarnian Ice Dungeon", 11925, 12181),
	OGRE_ENCLAVE(34, "Ogre Enclave", 10387),
	BRINE_RAT_CAVERN(35, "Brine Rat Cavern", 10910),
	ZANARIS(36, "Zanaris", 9540, 9541, 9797),
	EVIL_CHICKEN_LAIR(37, "Evil Chicken's Lair", 9796),
	THE_ABYSS(38, "The Abyss", 11850, 11851, 12106, 12107, 12108, 12362, 12363),
	KEBOS_SWAMP(39, "Kebos Swamp", 5176),
	THE_BATTLEFRONT(40, "The Battlefront", 5433, 5434, 5689, 5690),
	FORTHOS_DUNGEON(41, "Forthos Dungeon", 7322, 7323),
	IORWERTH_DUNGEON(42, "Iorwerth Dungeon", 12737, 12738, 12993, 12994),
	JORMUNGANDS_PRISON(43, "Jormungand's Prison", 9634, 9890, 9891),
	DARKMEYER(44, "Darkmeyer", 14388, 14644, 14389),
	SLEPE(45, "Slepe", 14643, 14899, 14900),
	MEIYERDITCH_LABORATORIES(46, "Meiyerditch Laboratories", 14233, 14488, 14489, 14743, 14744),
	ISLE_OF_SOULS(47, "Isle of Souls", 7310),
	GIANTS_DEN(48, "Giants' Den", 5785),

	// Unofficial values
	WILDERNESS(-1, "Wilderness"),
	;

	@Getter
	private final int index;
	@Getter
	private final String name;
	@Getter
	private final int[] regions;

	private static final Map<Integer, Location> locations;
	static
	{
		ImmutableMap.Builder<Integer, Location> mapper = new ImmutableMap.Builder<>();

		Arrays.stream(Location.values())
				.filter(loc -> loc.index != -1)
				.forEach(loc -> mapper.put(loc.index, loc));
		locations = mapper.build();
	}

	Location(int index, String name)
	{
		this.index = index;
		this.name = name;
		this.regions = new int[0];
	}

	Location(int index, String name, int... regions)
	{
		this.index = index;
		this.name = name;
		this.regions = regions;
	}

	static Location getLocationFromVar(Client client)
	{
		return locations.get(client.getVarpValue(VarPlayer.SLAYER_TASK_LOCATION.getId()));
	}

	static Location getTaskLocation(Client client)
	{
		return client.getVarbitValue(Varbits.SLAYER_MASTER) == SlayerMaster.KRYSTILIA.getIndex()
				? Location.WILDERNESS
				: getLocationFromVar(client);
	}
}
