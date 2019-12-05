/*
 * Copyright (c) 2019, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;

/**
 * Wrapper class for a GameObject that represents a chest in the thieving room of Chambers of Xeric.
 */
@Getter(AccessLevel.PACKAGE)
public class ThievingChest
{
	/**
	 * If the chest has never been opened, it could have bats.
	 */
	@Setter(AccessLevel.PACKAGE)
	private boolean everOpened;

	/**
	 * If the chest is empty, it could have bats.
	 */
	@Setter(AccessLevel.PACKAGE)
	private boolean empty;

	/**
	 * If the chest contains a poison trap instead.
	 */
	@Setter(AccessLevel.PACKAGE)
	private boolean poison;

	@Setter(AccessLevel.PUBLIC)
	private int chestId;

	private final WorldPoint worldPoint;

	@Getter(AccessLevel.PUBLIC)
	private final Point instancePoint;

	/**
	 * Constructor for a ThievingChest object
	 *
	 * @param worldPoint    The world location of the gameobject that corresponds with this trap.
	 * @param instancePoint The world location accounting for instances of the gameobject that corresponds with this trap.
	 */
	ThievingChest(final WorldPoint worldPoint, final Point instancePoint)
	{
		this.everOpened = false;
		this.poison = false;
		this.empty = false;
		this.worldPoint = worldPoint;
		this.instancePoint = instancePoint;
		this.chestId = -1;
	}

}
