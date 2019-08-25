/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.ui.overlay.arrow;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;

@Data
@Builder
public class ArrowPoint
{
	/**
	 * Can define a point to mark, or be used as a fallback when an object or an NPC is outside of the scene
	 */
	@NonNull
	private WorldPoint worldPoint;

	private Set<Integer> npcIDs;

	private Set<Integer> objectIDs;

	/**
	 * The regions that an NPC or Object has to be in to be marked (eg. Exam Centre locked chest Hard Clue requires
	 * killing a Barbarian in Barbarian Village, or Konar Slayer requires killing monsters in a certain area)
	 */
	private Set<Integer> region;

	private BufferedImage worldImage;
	@Builder.Default
	private Point worldImageOffset = new Point(0, 0);
	@Builder.Default
	private Color tileColor = Color.RED;

	private BufferedImage minimapImage;
	@Builder.Default
	private Point minimapImageOffset = new Point(0, 0);
	/**
	 * Whether the minimap arrow should rotate. Set to false if not using an arrow
	 */
	@Builder.Default
	private boolean minimapImagePointToTarget = true;
	@Builder.Default
	private int visibleRange = 128;
	/**
	 * Whether the minimap arrow should use the fallback point. Useful when there are multiple locations that could be
	 * used as a fallback (eg. Seers' Village locked draw Medium Clue, where you need to kill any chicken for a key)
	 */
	@Builder.Default
	private boolean minimapUseFallback = true;

	/**
	 * A Set of what arrows should be rendered
	 */
	@NonNull
	EnumSet<ArrowType> types;
}
