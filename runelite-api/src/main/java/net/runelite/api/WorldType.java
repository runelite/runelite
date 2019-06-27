package net.runelite.api;

import java.util.Collection;
import java.util.EnumSet;

/**
 * An enumeration of possible world types.
 */
public enum WorldType
{
	/**
	 * Members world type.
	 */
	MEMBERS(1),
	/**
	 * Pvp world type.
	 */
	PVP(1 << 2),
	/**
	 * Bounty world type.
	 */
	BOUNTY(1 << 5),
	/**
	 * Skill total world type.
	 */
	SKILL_TOTAL(1 << 7),
	/**
	 * High risk world type.
	 */
	HIGH_RISK(1 << 10),
	/**
	 * Last man standing world type.
	 */
	LAST_MAN_STANDING(1 << 14),
	/**
	 * Tournament world type.
	 */
	TOURNAMENT(1 << 25),
	/**
	 * Deadman Tournament world type.
	 */
	DEADMAN_TOURNAMENT(1 << 26),
	/**
	 * Deadman world type.
	 */
	DEADMAN(1 << 29),
	/**
	 * Seasonal deadman world type.
	 */
	SEASONAL_DEADMAN(1 << 30);

	private final int mask;

	WorldType(int mask)
	{
		this.mask = mask;
	}

	private static final EnumSet<WorldType> PVP_WORLD_TYPES = EnumSet.of(
		DEADMAN,
		DEADMAN_TOURNAMENT,
		PVP,
		SEASONAL_DEADMAN
	);
	
	private static final EnumSet<WorldType> DEADMAN_WORLD_TYPES = EnumSet.of(
		DEADMAN,
		DEADMAN_TOURNAMENT,
		SEASONAL_DEADMAN
	);

	private static final EnumSet<WorldType> HIGHRISK_WORLD_TYPES = EnumSet.of(
		HIGH_RISK
	);
	
	private static final EnumSet<WorldType> ALL_HIGHRISK_WORLD_TYPES = EnumSet.of(
		HIGH_RISK,
		DEADMAN,
		DEADMAN_TOURNAMENT,
		SEASONAL_DEADMAN
	);

	private static final EnumSet<WorldType> ALL_PVP_WORLD_TYPES = EnumSet.of(
		HIGH_RISK,
		DEADMAN,
		DEADMAN_TOURNAMENT,
		PVP,
		SEASONAL_DEADMAN
	);

	private static final EnumSet<WorldType> ALL_PK_WORLD_TYPES = EnumSet.of(
		HIGH_RISK,
		DEADMAN,
		DEADMAN_TOURNAMENT,
		PVP,
		SEASONAL_DEADMAN,
		BOUNTY
	);	

	/**
	 * Create enum set of world types from mask.
	 *
	 * @param mask the mask
	 * @return the enum set
	 */
	public static EnumSet<WorldType> fromMask(final int mask)
	{
		final EnumSet<WorldType> types = EnumSet.noneOf(WorldType.class);

		for (WorldType type : WorldType.values())
		{
			if ((mask & type.mask) != 0)
			{
				types.add(type);
			}
		}

		return types;
	}

	/**
	 * Create mask from enum set of world types.
	 *
	 * @param types the types
	 * @return the int containing all mask
	 */
	public static int toMask(final EnumSet<WorldType> types)
	{
		int mask = 0;

		for (WorldType type : types)
		{
			mask |= type.mask;
		}

		return mask;
	}

	/**
	 * Checks whether a world having a {@link Collection} of {@link WorldType}s is a PVP/DEADMAN/HIGHRISK world.
	 *
	 * @param worldTypes A {@link Collection} of {@link WorldType}s describing the given world.
	 * @return           True if the given worldtypes of the world are a PVP/DEADMAN/HIGHRISK world, false otherwise.
	 * @see Client#getWorldType()
	 */
	public static boolean isPvpWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(PVP_WORLD_TYPES::contains);
	}

	public static boolean isDeadmanWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(DEADMAN_WORLD_TYPES::contains);
	}

	public static boolean isHighRiskWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(HIGHRISK_WORLD_TYPES::contains);
	}
	
	public static boolean isAllHighRiskWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(ALL_HIGHRISK_WORLD_TYPES::contains);
	}
	
	public static boolean isAllPvpWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(ALL_PVP_WORLD_TYPES::contains);
	}
	
	public static boolean isAllPKWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(ALL_PK_WORLD_TYPES::contains);
	}
}
