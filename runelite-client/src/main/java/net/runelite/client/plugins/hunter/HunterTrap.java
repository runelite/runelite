/*
 * Copyright (c) 2017, Robin Weymans <Robin.weymans@gmail.com>
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
package net.runelite.client.plugins.hunter;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;

/**
 * Wrapper class for a GameObject that represents a hunter trap.
 */
class HunterTrap
{
	/**
	 * A hunter trap stays up 1 minute before collapsing.
	 */
	static final Duration TRAP_TIME = Duration.ofMinutes(1);

	/**
	 * The time in milliseconds when the trap was placed.
	 */
	@Getter
	private Instant placedOn;

	/**
	 * The state of the trap.
	 */
	@Getter
	@Setter
	private State state;

	/**
	 * The ID of the game object this is representing
	 */
	@Getter
	private final int objectId;

	@Getter
	private final WorldPoint worldLocation;

	/**
	 * The states a trap can be in.
	 */
	enum State
	{
		/**
		 * A laid out trap.
		 */
		OPEN,
		/**
		 * A trap that is empty.
		 */
		EMPTY,
		/**
		 * A trap that caught something.
		 */
		FULL,
		/**
		 * A trap that is closing.
		 */
		TRANSITION
	}

	/**
	 * Constructor for a HunterTrap object
	 *
	 * @param gameObject The gameobject thats corresponds with this trap.
	 */
	HunterTrap(GameObject gameObject)
	{
		this.state = State.OPEN;
		this.placedOn = Instant.now();
		this.objectId = gameObject.getId();
		this.worldLocation = gameObject.getWorldLocation();
	}

	/**
	 * Calculates how much time is left before the trap is collapsing.
	 *
	 * @return Value between 0 and 1. 0 means the trap was laid moments ago.
	 * 1 is a trap that's about to collapse.
	 */
	public double getTrapTimeRelative()
	{
		Duration duration = Duration.between(placedOn, Instant.now());
		return duration.compareTo(TRAP_TIME) < 0 ? (double) duration.toMillis() / TRAP_TIME.toMillis() : 1;
	}

	/**
	 * Resets the time value when the trap was placed.
	 */
	public void resetTimer()
	{
		placedOn = Instant.now();
	}
}
