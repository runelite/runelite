/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NpcID;

@Getter(AccessLevel.PACKAGE)
public class PestControlNpc
{
	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> splatterIdSet = ImmutableSet.of(
		NpcID.SPLATTER,
		NpcID.SPLATTER_1690,
		NpcID.SPLATTER_1691,
		NpcID.SPLATTER_1692,
		NpcID.SPLATTER_1693
	);

	@Getter(AccessLevel.PACKAGE)
	public static final Set<Integer> shifterIdSet = ImmutableSet.of(
		NpcID.SHIFTER,
		NpcID.SHIFTER_1695,
		NpcID.SHIFTER_1696,
		NpcID.SHIFTER_1697,
		NpcID.SHIFTER_1698,
		NpcID.SHIFTER_1699,
		NpcID.SHIFTER_1700,
		NpcID.SHIFTER_1701,
		NpcID.SHIFTER_1702,
		NpcID.SHIFTER_1703
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> spinnerIdSet = ImmutableSet.of(
		NpcID.SPINNER,
		NpcID.SPINNER_1710,
		NpcID.SPINNER_1711,
		NpcID.SPINNER_1712,
		NpcID.SPINNER_1713
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> torcherIdSet = ImmutableSet.of(
		NpcID.TORCHER,
		NpcID.TORCHER_1715,
		NpcID.TORCHER_1716,
		NpcID.TORCHER_1717,
		NpcID.TORCHER_1718,
		NpcID.TORCHER_1719,
		NpcID.TORCHER_1720,
		NpcID.TORCHER_1721,
		NpcID.TORCHER_1722,
		NpcID.TORCHER_1723
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> defilerIdSet = ImmutableSet.of(
		NpcID.DEFILER,
		NpcID.DEFILER_1725,
		NpcID.DEFILER_1726,
		NpcID.DEFILER_1727,
		NpcID.DEFILER_1728,
		NpcID.DEFILER_1729,
		NpcID.DEFILER_1730,
		NpcID.DEFILER_1731,
		NpcID.DEFILER_1732,
		NpcID.DEFILER_1733
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> brawlerIdSet = ImmutableSet.of(
		NpcID.BRAWLER,
		NpcID.BRAWLER_1735,
		NpcID.BRAWLER_1736,
		NpcID.BRAWLER_1737,
		NpcID.BRAWLER_1738
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> ravagerIdSet = ImmutableSet.of(
		NpcID.RAVAGER,
		NpcID.RAVAGER_1705,
		NpcID.RAVAGER_1706,
		NpcID.RAVAGER_1707,
		NpcID.RAVAGER_1708
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> activePortalIdSet = ImmutableSet.of(
		NpcID.PORTAL_1747, // Novice Purple Active
		NpcID.PORTAL_1748, // Novice Blue Active
		NpcID.PORTAL_1749, // Novice Yellow Active
		NpcID.PORTAL_1750, // Novice Red Active
		NpcID.PORTAL, // Intermediate Purple Active
		NpcID.PORTAL_1740, // Intermediate Blue Active
		NpcID.PORTAL_1741, // Intermediate Yellow Active
		NpcID.PORTAL_1742 // Intermediate Red Active
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> shieldedPortalIdSet = ImmutableSet.of(
		NpcID.PORTAL_1751, // Novice Purple Shielded
		NpcID.PORTAL_1752, // Novice Blue Shielded
		NpcID.PORTAL_1753, // Novice Yellow Shielded
		NpcID.PORTAL_1754, // Novice Red Shielded
		NpcID.PORTAL_1743, // Intermediate Purple Shielded
		NpcID.PORTAL_1744, // Intermediate Blue Shielded
		NpcID.PORTAL_1745, // Intermediate Yellow Shielded
		NpcID.PORTAL_1746 // Intermediate Red Shielded
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> purplePortalIdSet = ImmutableSet.of(
		NpcID.PORTAL_1747, // Novice Purple Active
		NpcID.PORTAL_1751, // Novice Purple Shielded
		NpcID.PORTAL, // Intermediate Purple Active
		NpcID.PORTAL_1743 // Intermediate Purple Shielded
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> bluePortalIdSet = ImmutableSet.of(
		NpcID.PORTAL_1748, // Novice Blue Active
		NpcID.PORTAL_1752, // Novice Blue Shielded
		NpcID.PORTAL_1740, // Intermediate Blue Active
		NpcID.PORTAL_1744 // Intermediate Blue Shielded
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> yellowPortalIdSet = ImmutableSet.of(
		NpcID.PORTAL_1749, // Novice Yellow Active
		NpcID.PORTAL_1753, // Novice Yellow Shielded
		NpcID.PORTAL_1741, // Intermediate Yellow Active
		NpcID.PORTAL_1745 // Intermediate Yellow Shielded
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> redPortalIdSet = ImmutableSet.of(
		NpcID.PORTAL_1750, // Novice Red Active
		NpcID.PORTAL_1754, // Novice Red Shielded
		NpcID.PORTAL_1742, // Intermediate Red Active
		NpcID.PORTAL_1746 // Intermediate Red Shielded
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> ingameVoidKnightIdSet = ImmutableSet.of(
		NpcID.VOID_KNIGHT_2950,
		NpcID.VOID_KNIGHT_2951,
		NpcID.VOID_KNIGHT_2952,
		NpcID.VOID_KNIGHT_2953
	);

	@Getter(AccessLevel.PACKAGE)
	private static final Integer ingameSquireId = NpcID.SQUIRE_2949;

	static boolean isSplatterId(int npcId)
	{
		return splatterIdSet.contains(npcId);
	}

	static boolean isShifterId(int npcId)
	{
		return shifterIdSet.contains(npcId);
	}

	static boolean isSpinnerId(int npcId)
	{
		return brawlerIdSet.contains(npcId);
	}

	static boolean isTorcherId(int npcId)
	{
		return torcherIdSet.contains(npcId);
	}

	static boolean isDefilerId(int npcId)
	{
		return defilerIdSet.contains(npcId);
	}

	static boolean isBrawlerId(int npcId)
	{
		return brawlerIdSet.contains(npcId);
	}

	static boolean isRavagerId(int npcId)
	{
		return ravagerIdSet.contains(npcId);
	}

	static boolean isIngameVoidKnightId(int npcId)
	{
		return ingameVoidKnightIdSet.contains(npcId);
	}

	static boolean isIngameSquireId(int npcId)
	{
		return ingameSquireId == npcId;
	}

	static boolean isPortalId(int npcId)
	{
		return (isActivePortalId(npcId) || isShieldedPortalId(npcId));
	}

	static boolean isActivePortalId(int npcId)
	{
		return activePortalIdSet.contains(npcId);
	}

	private static boolean isShieldedPortalId(int npcId)
	{
		return shieldedPortalIdSet.contains(npcId);
	}

	static boolean isPurplePortalId(int npcId)
	{
		return purplePortalIdSet.contains(npcId);
	}

	static boolean isBluePortalId(int npcId)
	{
		return bluePortalIdSet.contains(npcId);
	}

	static boolean isYellowPortalId(int npcId)
	{
		return yellowPortalIdSet.contains(npcId);
	}

	static boolean isRedPortalId(int npcId)
	{
		return redPortalIdSet.contains(npcId);
	}
}
