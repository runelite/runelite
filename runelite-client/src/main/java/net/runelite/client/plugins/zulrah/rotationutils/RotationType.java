package net.runelite.client.plugins.zulrah.rotationutils;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.api.NPC;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.zulrah.constants.StandLocation;
import net.runelite.client.plugins.zulrah.constants.ZulrahLocation;
import net.runelite.client.plugins.zulrah.constants.ZulrahType;

public enum RotationType
{
	ROT_A("Rotation A", ImmutableList.of(add(ZulrahType.RANGE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 21), add(ZulrahType.MAGIC, ZulrahLocation.NORTH, StandLocation.EAST_PILLAR_N, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 18), add(ZulrahType.RANGE, ZulrahLocation.SOUTH, StandLocation.WEST_PILLAR_N, StandLocation.WEST_PILLAR_N2, Prayer.PROTECT_FROM_MISSILES, 39), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.WEST_PILLAR_N, (StandLocation) null, (Prayer) null, 22), add(ZulrahType.MAGIC, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_S, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 20), add(ZulrahType.RANGE, ZulrahLocation.SOUTH, StandLocation.EAST_PILLAR, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.MAGIC, ZulrahLocation.SOUTH, StandLocation.EAST_PILLAR, StandLocation.EAST_PILLAR_N2, Prayer.PROTECT_FROM_MAGIC, 36), addJad(ZulrahType.RANGE, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_S, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MISSILES, 48), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 21))),
	ROT_B("Rotation B", ImmutableList.of(add(ZulrahType.RANGE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 21), add(ZulrahType.MAGIC, ZulrahLocation.NORTH, StandLocation.EAST_PILLAR_N, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 18), add(ZulrahType.RANGE, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_S, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.MAGIC, ZulrahLocation.SOUTH, StandLocation.WEST_PILLAR_N, StandLocation.WEST_PILLAR_N2, Prayer.PROTECT_FROM_MAGIC, 39), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.WEST_PILLAR_N, (StandLocation) null, (Prayer) null, 21), add(ZulrahType.RANGE, ZulrahLocation.EAST, StandLocation.CENTER, StandLocation.WEST_PILLAR_S, Prayer.PROTECT_FROM_MISSILES, 20), add(ZulrahType.MAGIC, ZulrahLocation.SOUTH, StandLocation.WEST_PILLAR_S, StandLocation.WEST_PILLAR_N2, Prayer.PROTECT_FROM_MAGIC, 36), addJad(ZulrahType.RANGE, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_S, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MISSILES, 48), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 21))),
	ROT_C("Rotation C", ImmutableList.of(add(ZulrahType.RANGE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.RANGE, ZulrahLocation.EAST, StandLocation.NORTHEAST_TOP, (StandLocation) null, Prayer.PROTECT_FROM_MISSILES, 30), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.WEST, (StandLocation) null, (Prayer) null, 40), add(ZulrahType.MAGIC, ZulrahLocation.WEST, StandLocation.WEST, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 20), add(ZulrahType.RANGE, ZulrahLocation.SOUTH, StandLocation.EAST_PILLAR_S, StandLocation.EAST_PILLAR_N2, Prayer.PROTECT_FROM_MISSILES, 20), add(ZulrahType.MAGIC, ZulrahLocation.EAST, StandLocation.EAST_PILLAR_S, StandLocation.WEST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 20), add(ZulrahType.RANGE, ZulrahLocation.NORTH, StandLocation.WEST_PILLAR_N, (StandLocation) null, (Prayer) null, 25), add(ZulrahType.RANGE, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_N, (StandLocation) null, Prayer.PROTECT_FROM_MISSILES, 20), add(ZulrahType.MAGIC, ZulrahLocation.NORTH, StandLocation.EAST_PILLAR_N, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 36), addJad(ZulrahType.MAGIC, ZulrahLocation.EAST, StandLocation.EAST_PILLAR_N, (StandLocation) null, Prayer.PROTECT_FROM_MAGIC, 35), add(ZulrahType.MAGIC, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 18))),
	ROT_D("Rotation D", ImmutableList.of(add(ZulrahType.RANGE, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.MAGIC, ZulrahLocation.EAST, StandLocation.NORTHEAST_TOP, (StandLocation) null, Prayer.PROTECT_FROM_MAGIC, 36), add(ZulrahType.RANGE, ZulrahLocation.SOUTH, StandLocation.WEST_PILLAR_N, StandLocation.WEST_PILLAR_N2, Prayer.PROTECT_FROM_MISSILES, 24), add(ZulrahType.MAGIC, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_N, (StandLocation) null, Prayer.PROTECT_FROM_MAGIC, 30), add(ZulrahType.MELEE, ZulrahLocation.NORTH, StandLocation.EAST_PILLAR_N, (StandLocation) null, (Prayer) null, 28), add(ZulrahType.RANGE, ZulrahLocation.EAST, StandLocation.EAST_PILLAR, (StandLocation) null, Prayer.PROTECT_FROM_MISSILES, 17), add(ZulrahType.RANGE, ZulrahLocation.SOUTH, StandLocation.EAST_PILLAR, (StandLocation) null, (Prayer) null, 34), add(ZulrahType.MAGIC, ZulrahLocation.WEST, StandLocation.WEST_PILLAR_S, (StandLocation) null, Prayer.PROTECT_FROM_MAGIC, 33), add(ZulrahType.RANGE, ZulrahLocation.NORTH, StandLocation.EAST_PILLAR_N, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MISSILES, 20), add(ZulrahType.MAGIC, ZulrahLocation.NORTH, StandLocation.EAST_PILLAR_N, StandLocation.EAST_PILLAR_S, Prayer.PROTECT_FROM_MAGIC, 27), addJad(ZulrahType.MAGIC, ZulrahLocation.EAST, StandLocation.EAST_PILLAR_N, (StandLocation) null, Prayer.PROTECT_FROM_MAGIC, 29), add(ZulrahType.MAGIC, ZulrahLocation.NORTH, StandLocation.NORTHEAST_TOP, (StandLocation) null, (Prayer) null, 18)));

	private static final List<RotationType> lookup = new ArrayList<>();

	static
	{
		lookup.addAll(EnumSet.allOf(RotationType.class));
	}

	private final String rotationName;
	private final List<ZulrahPhase> zulrahPhases;

	RotationType(String rotationName, List<ZulrahPhase> zulrahPhases)
	{
		this.rotationName = rotationName;
		this.zulrahPhases = zulrahPhases;
	}

	public static List<RotationType> findPotentialRotations(NPC npc, int stage)
	{
		return lookup.stream().filter(type -> type.getZulrahPhases().get(stage).getZulrahNpc().equals(ZulrahNpc.valueOf(npc, false))).collect(Collectors.toList());
	}

	private static ZulrahPhase add(ZulrahType type, ZulrahLocation zulrahLocation, StandLocation standLocation, StandLocation stallLocation, Prayer prayer, int phaseTicks)
	{
		return new ZulrahPhase(new ZulrahNpc(type, zulrahLocation, false), new ZulrahAttributes(standLocation, stallLocation, prayer, phaseTicks));
	}

	private static ZulrahPhase addJad(ZulrahType type, ZulrahLocation zulrahLocation, StandLocation standLocation, StandLocation stallLocation, Prayer prayer, int phaseTicks)
	{
		return new ZulrahPhase(new ZulrahNpc(type, zulrahLocation, true), new ZulrahAttributes(standLocation, stallLocation, prayer, phaseTicks));
	}

	public String getRotationName()
	{
		return this.rotationName;
	}

	public List<ZulrahPhase> getZulrahPhases()
	{
		return this.zulrahPhases;
	}

	public String toString()
	{
		return this.rotationName;
	}
}
