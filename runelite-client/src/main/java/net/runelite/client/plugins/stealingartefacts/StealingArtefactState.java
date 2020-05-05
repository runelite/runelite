package net.runelite.client.plugins.stealingartefacts;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

import java.awt.Color;
import java.util.Map;

public enum StealingArtefactState
{
	NO_TASK("No Task", Color.WHITE, new WorldPoint(0,0,0)),
	LOCATION_NORTH("North House", Color.YELLOW, new WorldPoint(1767,3751,0)),
	LOCATION_SOUTHEAST("Southeast House", Color.YELLOW, new WorldPoint(1774,3730,1)),
	LOCATION_SOUTH("South House", Color.YELLOW, new WorldPoint(1764,3735,1)),
	LOCATION_SOUTHWEST("Southwest House", Color.YELLOW, new WorldPoint(1749,3735,1)),
	LOCATION_WEST("West House", Color.YELLOW, new WorldPoint(1747,3749,1)),
	LOCATION_NORTHWEST("Northwest House", Color.YELLOW, new WorldPoint(1750,3763,1)),
	FAILURE("Failure", Color.RED, new WorldPoint(0,0,0)),
	DELIVER_ARTEFACT("Deliver Artefact", Color.GREEN, new WorldPoint(0,0,0));

	@Getter(AccessLevel.PACKAGE)
	private final String description;
	@Getter(AccessLevel.PACKAGE)
	private final Color color;
	@Getter(AccessLevel.PACKAGE)
	private WorldPoint worldPoint;

	private static final Map<Integer, StealingArtefactState> stealingArtefactStates;

	static
	{
		ImmutableMap.Builder<Integer, StealingArtefactState> builder = new ImmutableMap.Builder<>();

		for (StealingArtefactState stealingArtefactState : values())
		{
			builder.put(stealingArtefactState.ordinal(), stealingArtefactState);
		}

		stealingArtefactStates = builder.build();
	}

	StealingArtefactState(String description, Color color, WorldPoint worldPoint)
	{
		this.description = description;
		this.color = color;
		this.worldPoint = worldPoint;
	}

	public static StealingArtefactState getStealingArtefactState(int id)
	{
		return stealingArtefactStates.get(id);
	}
}
