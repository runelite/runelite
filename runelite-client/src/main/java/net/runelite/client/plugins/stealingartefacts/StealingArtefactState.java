package net.runelite.client.plugins.stealingartefacts;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.Getter;

import java.awt.Color;
import java.util.Map;

public enum StealingArtefactState
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

	StealingArtefactState(String description, Color color)
	{
		this.description = description;
		this.color = color;
	}

	public static StealingArtefactState getStealingArtefactState(int id)
	{
		return stealingArtefactStates.get(id);
	}
}
