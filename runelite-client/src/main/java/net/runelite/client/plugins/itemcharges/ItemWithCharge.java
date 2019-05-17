/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.itemcharges;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.ItemID.ABYSSAL_BRACELET1;
import static net.runelite.api.ItemID.ABYSSAL_BRACELET2;
import static net.runelite.api.ItemID.ABYSSAL_BRACELET3;
import static net.runelite.api.ItemID.ABYSSAL_BRACELET4;
import static net.runelite.api.ItemID.ABYSSAL_BRACELET5;
import static net.runelite.api.ItemID.AMULET_OF_GLORY1;
import static net.runelite.api.ItemID.AMULET_OF_GLORY2;
import static net.runelite.api.ItemID.AMULET_OF_GLORY3;
import static net.runelite.api.ItemID.AMULET_OF_GLORY4;
import static net.runelite.api.ItemID.AMULET_OF_GLORY5;
import static net.runelite.api.ItemID.AMULET_OF_GLORY6;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T1;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T2;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T3;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T4;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T5;
import static net.runelite.api.ItemID.AMULET_OF_GLORY_T6;
import static net.runelite.api.ItemID.BURNING_AMULET1;
import static net.runelite.api.ItemID.BURNING_AMULET2;
import static net.runelite.api.ItemID.BURNING_AMULET3;
import static net.runelite.api.ItemID.BURNING_AMULET4;
import static net.runelite.api.ItemID.BURNING_AMULET5;
import static net.runelite.api.ItemID.COMBAT_BRACELET1;
import static net.runelite.api.ItemID.COMBAT_BRACELET2;
import static net.runelite.api.ItemID.COMBAT_BRACELET3;
import static net.runelite.api.ItemID.COMBAT_BRACELET4;
import static net.runelite.api.ItemID.COMBAT_BRACELET5;
import static net.runelite.api.ItemID.COMBAT_BRACELET6;
import static net.runelite.api.ItemID.DIGSITE_PENDANT_1;
import static net.runelite.api.ItemID.DIGSITE_PENDANT_2;
import static net.runelite.api.ItemID.DIGSITE_PENDANT_3;
import static net.runelite.api.ItemID.DIGSITE_PENDANT_4;
import static net.runelite.api.ItemID.DIGSITE_PENDANT_5;
import static net.runelite.api.ItemID.ENCHANTED_LYRE1;
import static net.runelite.api.ItemID.ENCHANTED_LYRE2;
import static net.runelite.api.ItemID.ENCHANTED_LYRE3;
import static net.runelite.api.ItemID.ENCHANTED_LYRE4;
import static net.runelite.api.ItemID.ENCHANTED_LYRE5;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_0;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_1;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_10;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_2;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_3;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_4;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_5;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_6;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_7;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_8;
import static net.runelite.api.ItemID.FUNGICIDE_SPRAY_9;
import static net.runelite.api.ItemID.GAMES_NECKLACE1;
import static net.runelite.api.ItemID.GAMES_NECKLACE2;
import static net.runelite.api.ItemID.GAMES_NECKLACE3;
import static net.runelite.api.ItemID.GAMES_NECKLACE4;
import static net.runelite.api.ItemID.GAMES_NECKLACE5;
import static net.runelite.api.ItemID.GAMES_NECKLACE6;
import static net.runelite.api.ItemID.GAMES_NECKLACE7;
import static net.runelite.api.ItemID.GAMES_NECKLACE8;
import static net.runelite.api.ItemID.IMPINABOX1;
import static net.runelite.api.ItemID.IMPINABOX2;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE1;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE2;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE3;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE4;
import static net.runelite.api.ItemID.NECKLACE_OF_PASSAGE5;
import static net.runelite.api.ItemID.OGRE_BELLOWS;
import static net.runelite.api.ItemID.OGRE_BELLOWS_1;
import static net.runelite.api.ItemID.OGRE_BELLOWS_2;
import static net.runelite.api.ItemID.OGRE_BELLOWS_3;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_1;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_2;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_3;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_4;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_5;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_6;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_7;
import static net.runelite.api.ItemID.PHARAOHS_SCEPTRE_8;
import static net.runelite.api.ItemID.RING_OF_DUELING1;
import static net.runelite.api.ItemID.RING_OF_DUELING2;
import static net.runelite.api.ItemID.RING_OF_DUELING3;
import static net.runelite.api.ItemID.RING_OF_DUELING4;
import static net.runelite.api.ItemID.RING_OF_DUELING5;
import static net.runelite.api.ItemID.RING_OF_DUELING6;
import static net.runelite.api.ItemID.RING_OF_DUELING7;
import static net.runelite.api.ItemID.RING_OF_DUELING8;
import static net.runelite.api.ItemID.RING_OF_RETURNING1;
import static net.runelite.api.ItemID.RING_OF_RETURNING2;
import static net.runelite.api.ItemID.RING_OF_RETURNING3;
import static net.runelite.api.ItemID.RING_OF_RETURNING4;
import static net.runelite.api.ItemID.RING_OF_RETURNING5;
import static net.runelite.api.ItemID.RING_OF_WEALTH_1;
import static net.runelite.api.ItemID.RING_OF_WEALTH_2;
import static net.runelite.api.ItemID.RING_OF_WEALTH_3;
import static net.runelite.api.ItemID.RING_OF_WEALTH_4;
import static net.runelite.api.ItemID.RING_OF_WEALTH_5;
import static net.runelite.api.ItemID.SKILLS_NECKLACE1;
import static net.runelite.api.ItemID.SKILLS_NECKLACE2;
import static net.runelite.api.ItemID.SKILLS_NECKLACE3;
import static net.runelite.api.ItemID.SKILLS_NECKLACE4;
import static net.runelite.api.ItemID.SKILLS_NECKLACE5;
import static net.runelite.api.ItemID.SKILLS_NECKLACE6;
import static net.runelite.api.ItemID.SLAYER_RING_1;
import static net.runelite.api.ItemID.SLAYER_RING_2;
import static net.runelite.api.ItemID.SLAYER_RING_3;
import static net.runelite.api.ItemID.SLAYER_RING_4;
import static net.runelite.api.ItemID.SLAYER_RING_5;
import static net.runelite.api.ItemID.SLAYER_RING_6;
import static net.runelite.api.ItemID.SLAYER_RING_7;
import static net.runelite.api.ItemID.SLAYER_RING_8;
import static net.runelite.api.ItemID.TELEPORT_CRYSTAL_1;
import static net.runelite.api.ItemID.TELEPORT_CRYSTAL_2;
import static net.runelite.api.ItemID.TELEPORT_CRYSTAL_3;
import static net.runelite.api.ItemID.TELEPORT_CRYSTAL_4;
import static net.runelite.api.ItemID.TELEPORT_CRYSTAL_5;
import static net.runelite.api.ItemID.WATERING_CAN;
import static net.runelite.api.ItemID.WATERING_CAN1;
import static net.runelite.api.ItemID.WATERING_CAN2;
import static net.runelite.api.ItemID.WATERING_CAN3;
import static net.runelite.api.ItemID.WATERING_CAN4;
import static net.runelite.api.ItemID.WATERING_CAN5;
import static net.runelite.api.ItemID.WATERING_CAN6;
import static net.runelite.api.ItemID.WATERING_CAN7;
import static net.runelite.api.ItemID.WATERING_CAN8;
import static net.runelite.api.ItemID.WATERSKIN0;
import static net.runelite.api.ItemID.WATERSKIN1;
import static net.runelite.api.ItemID.WATERSKIN2;
import static net.runelite.api.ItemID.WATERSKIN3;
import static net.runelite.api.ItemID.WATERSKIN4;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.ABYSSAL_BRACELET;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.BELLOWS;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.FUNGICIDE_SPRAY;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.IMPBOX;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.TELEPORT;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.WATERCAN;
import static net.runelite.client.plugins.itemcharges.ItemChargeType.WATERSKIN;

@AllArgsConstructor
@Getter
enum ItemWithCharge
{
	ABRACE1(ABYSSAL_BRACELET, ABYSSAL_BRACELET1, 1),
	ABRACE2(ABYSSAL_BRACELET, ABYSSAL_BRACELET2, 2),
	ABRACE3(ABYSSAL_BRACELET, ABYSSAL_BRACELET3, 3),
	ABRACE4(ABYSSAL_BRACELET, ABYSSAL_BRACELET4, 4),
	ABRACE5(ABYSSAL_BRACELET, ABYSSAL_BRACELET5, 5),
	BELLOWS0(BELLOWS, OGRE_BELLOWS, 0),
	BELLOWS1(BELLOWS, OGRE_BELLOWS_1, 1),
	BELLOWS2(BELLOWS, OGRE_BELLOWS_2, 2),
	BELLOWS3(BELLOWS, OGRE_BELLOWS_3, 3),
	BURNING1(TELEPORT, BURNING_AMULET1, 1),
	BURNING2(TELEPORT, BURNING_AMULET2, 2),
	BURNING3(TELEPORT, BURNING_AMULET3, 3),
	BURNING4(TELEPORT, BURNING_AMULET4, 4),
	BURNING5(TELEPORT, BURNING_AMULET5, 5),
	CBRACE1(TELEPORT, COMBAT_BRACELET1, 1),
	CBRACE2(TELEPORT, COMBAT_BRACELET2, 2),
	CBRACE3(TELEPORT, COMBAT_BRACELET3, 3),
	CBRACE4(TELEPORT, COMBAT_BRACELET4, 4),
	CBRACE5(TELEPORT, COMBAT_BRACELET5, 5),
	CBRACE6(TELEPORT, COMBAT_BRACELET6, 6),
	DIGSITE1(TELEPORT, DIGSITE_PENDANT_1, 1),
	DIGSITE2(TELEPORT, DIGSITE_PENDANT_2, 2),
	DIGSITE3(TELEPORT, DIGSITE_PENDANT_3, 3),
	DIGSITE4(TELEPORT, DIGSITE_PENDANT_4, 4),
	DIGSITE5(TELEPORT, DIGSITE_PENDANT_5, 5),
	ELYRE1(TELEPORT, ENCHANTED_LYRE1, 1),
	ELYRE2(TELEPORT, ENCHANTED_LYRE2, 2),
	ELYRE3(TELEPORT, ENCHANTED_LYRE3, 3),
	ELYRE4(TELEPORT, ENCHANTED_LYRE4, 4),
	ELYRE5(TELEPORT, ENCHANTED_LYRE5, 5),
	FUNGICIDE0(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_0, 0),
	FUNGICIDE1(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_1, 1),
	FUNGICIDE2(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_2, 2),
	FUNGICIDE3(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_3, 3),
	FUNGICIDE4(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_4, 4),
	FUNGICIDE5(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_5, 5),
	FUNGICIDE6(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_6, 6),
	FUNGICIDE7(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_7, 7),
	FUNGICIDE8(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_8, 8),
	FUNGICIDE9(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_9, 9),
	FUNGICIDE10(FUNGICIDE_SPRAY, FUNGICIDE_SPRAY_10, 10),
	GAMES1(TELEPORT, GAMES_NECKLACE1, 1),
	GAMES2(TELEPORT, GAMES_NECKLACE2, 2),
	GAMES3(TELEPORT, GAMES_NECKLACE3, 3),
	GAMES4(TELEPORT, GAMES_NECKLACE4, 4),
	GAMES5(TELEPORT, GAMES_NECKLACE5, 5),
	GAMES6(TELEPORT, GAMES_NECKLACE6, 6),
	GAMES7(TELEPORT, GAMES_NECKLACE7, 7),
	GAMES8(TELEPORT, GAMES_NECKLACE8, 8),
	GLORY1(TELEPORT, AMULET_OF_GLORY1, 1),
	GLORY2(TELEPORT, AMULET_OF_GLORY2, 2),
	GLORY3(TELEPORT, AMULET_OF_GLORY3, 3),
	GLORY4(TELEPORT, AMULET_OF_GLORY4, 4),
	GLORY5(TELEPORT, AMULET_OF_GLORY5, 5),
	GLORY6(TELEPORT, AMULET_OF_GLORY6, 6),
	GLORYT1(TELEPORT, AMULET_OF_GLORY_T1, 1),
	GLORYT2(TELEPORT, AMULET_OF_GLORY_T2, 2),
	GLORYT3(TELEPORT, AMULET_OF_GLORY_T3, 3),
	GLORYT4(TELEPORT, AMULET_OF_GLORY_T4, 4),
	GLORYT5(TELEPORT, AMULET_OF_GLORY_T5, 5),
	GLORYT6(TELEPORT, AMULET_OF_GLORY_T6, 6),
	IMP_IN_A_BOX1(IMPBOX, IMPINABOX1, 1),
	IMP_IN_A_BOX2(IMPBOX, IMPINABOX2, 2),
	PASSAGE1(TELEPORT, NECKLACE_OF_PASSAGE1, 1),
	PASSAGE2(TELEPORT, NECKLACE_OF_PASSAGE2, 2),
	PASSAGE3(TELEPORT, NECKLACE_OF_PASSAGE3, 3),
	PASSAGE4(TELEPORT, NECKLACE_OF_PASSAGE4, 4),
	PASSAGE5(TELEPORT, NECKLACE_OF_PASSAGE5, 5),
	PHARAO1(TELEPORT, PHARAOHS_SCEPTRE_1, 1),
	PHARAO2(TELEPORT, PHARAOHS_SCEPTRE_2, 2),
	PHARAO3(TELEPORT, PHARAOHS_SCEPTRE_3, 3),
	PHARAO4(TELEPORT, PHARAOHS_SCEPTRE_4, 4),
	PHARAO5(TELEPORT, PHARAOHS_SCEPTRE_5, 5),
	PHARAO6(TELEPORT, PHARAOHS_SCEPTRE_6, 6),
	PHARAO7(TELEPORT, PHARAOHS_SCEPTRE_7, 7),
	PHARAO8(TELEPORT, PHARAOHS_SCEPTRE_8, 8),
	RETURNING1(TELEPORT, RING_OF_RETURNING1, 1),
	RETURNING2(TELEPORT, RING_OF_RETURNING2, 2),
	RETURNING3(TELEPORT, RING_OF_RETURNING3, 3),
	RETURNING4(TELEPORT, RING_OF_RETURNING4, 4),
	RETURNING5(TELEPORT, RING_OF_RETURNING5, 5),
	ROD1(TELEPORT, RING_OF_DUELING1, 1),
	ROD2(TELEPORT, RING_OF_DUELING2, 2),
	ROD3(TELEPORT, RING_OF_DUELING3, 3),
	ROD4(TELEPORT, RING_OF_DUELING4, 4),
	ROD5(TELEPORT, RING_OF_DUELING5, 5),
	ROD6(TELEPORT, RING_OF_DUELING6, 6),
	ROD7(TELEPORT, RING_OF_DUELING7, 7),
	ROD8(TELEPORT, RING_OF_DUELING8, 8),
	ROS1(TELEPORT, SLAYER_RING_1, 1),
	ROS2(TELEPORT, SLAYER_RING_2, 2),
	ROS3(TELEPORT, SLAYER_RING_3, 3),
	ROS4(TELEPORT, SLAYER_RING_4, 4),
	ROS5(TELEPORT, SLAYER_RING_5, 5),
	ROS6(TELEPORT, SLAYER_RING_6, 6),
	ROS7(TELEPORT, SLAYER_RING_7, 7),
	ROS8(TELEPORT, SLAYER_RING_8, 8),
	ROW1(TELEPORT, RING_OF_WEALTH_1, 1),
	ROW2(TELEPORT, RING_OF_WEALTH_2, 2),
	ROW3(TELEPORT, RING_OF_WEALTH_3, 3),
	ROW4(TELEPORT, RING_OF_WEALTH_4, 4),
	ROW5(TELEPORT, RING_OF_WEALTH_5, 5),
	SKILLS1(TELEPORT, SKILLS_NECKLACE1, 1),
	SKILLS2(TELEPORT, SKILLS_NECKLACE2, 2),
	SKILLS3(TELEPORT, SKILLS_NECKLACE3, 3),
	SKILLS4(TELEPORT, SKILLS_NECKLACE4, 4),
	SKILLS5(TELEPORT, SKILLS_NECKLACE5, 5),
	SKILLS6(TELEPORT, SKILLS_NECKLACE6, 6),
	TCRYSTAL1(TELEPORT, TELEPORT_CRYSTAL_1, 1),
	TCRYSTAL2(TELEPORT, TELEPORT_CRYSTAL_2, 2),
	TCRYSTAL3(TELEPORT, TELEPORT_CRYSTAL_3, 3),
	TCRYSTAL4(TELEPORT, TELEPORT_CRYSTAL_4, 4),
	TCRYSTAL5(TELEPORT, TELEPORT_CRYSTAL_5, 5),
	WCAN0(WATERCAN, WATERING_CAN, 0),
	WCAN1(WATERCAN, WATERING_CAN1, 1),
	WCAN2(WATERCAN, WATERING_CAN2, 2),
	WCAN3(WATERCAN, WATERING_CAN3, 3),
	WCAN4(WATERCAN, WATERING_CAN4, 4),
	WCAN5(WATERCAN, WATERING_CAN5, 5),
	WCAN6(WATERCAN, WATERING_CAN6, 6),
	WCAN7(WATERCAN, WATERING_CAN7, 7),
	WCAN8(WATERCAN, WATERING_CAN8, 8),
	WSKIN0(WATERSKIN, WATERSKIN0, 0),
	WSKIN1(WATERSKIN, WATERSKIN1, 1),
	WSKIN2(WATERSKIN, WATERSKIN2, 2),
	WSKIN3(WATERSKIN, WATERSKIN3, 3),
	WSKIN4(WATERSKIN, WATERSKIN4, 4);

	private final ItemChargeType type;
	private final int id;
	private final int charges;

	private static final Map<Integer, ItemWithCharge> ID_MAP;

	static
	{
		ImmutableMap.Builder<Integer, ItemWithCharge> builder = new ImmutableMap.Builder<>();

		for (ItemWithCharge itemCharge : values())
		{
			builder.put(itemCharge.getId(), itemCharge);
		}

		ID_MAP = builder.build();
	}

	@Nullable
	static ItemWithCharge findItem(int itemId)
	{
		return ID_MAP.get(itemId);
	}

}
