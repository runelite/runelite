/*
 * Copyright (c) 2019, honeyhoney <https://github.com/honeyhoney>
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
