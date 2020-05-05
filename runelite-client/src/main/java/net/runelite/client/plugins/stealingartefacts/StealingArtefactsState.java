package net.runelite.client.plugins.stealingartefacts;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.Getter;

import java.awt.Color;
import java.util.Map;

public enum StealingArtefactsState
{
	NO_TASK("No Task", Color.WHITE),
	LOCATION_NORTH("North House", Color.YELLOW),
	LOCATION_SOUTHEAST("Southeast House", Color.YELLOW),
	LOCATION_SOUTH("South House", Color.YELLOW),
	LOCATION_SOUTHWEST("Southwest House", Color.YELLOW),
	LOCATION_WEST("West House", Color.YELLOW),
	LOCATION_NORTHWEST("Northwest House", Color.YELLOW),
	FAILURE("Failure", Color.RED),
	DELIVER_ARTEFACT("Deliver Artefact", Color.GREEN);

	@Getter(AccessLevel.PACKAGE)
	private final String description;
	@Getter(AccessLevel.PACKAGE)
	private final Color color;

	private static final Map<Integer, StealingArtefactsState> stealingArtefactsStates;

	static
	{
		ImmutableMap.Builder<Integer, StealingArtefactsState> builder = new ImmutableMap.Builder<>();

		for (StealingArtefactsState stealingArtefactsState : values())
		{
			builder.put(stealingArtefactsState.ordinal(), stealingArtefactsState);
		}

		stealingArtefactsStates = builder.build();
	}

	StealingArtefactsState(String description, Color color)
	{
		this.description = description;
		this.color = color;
	}

	public static StealingArtefactsState getStealingArtefactsState(int id)
	{
		return stealingArtefactsStates.get(id);
	}
}
