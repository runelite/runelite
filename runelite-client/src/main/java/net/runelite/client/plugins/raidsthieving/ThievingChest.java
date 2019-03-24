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

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;

/**
 * Wrapper class for a GameObject that represents a chest in the thieving room of Chambers of Xeric.
 */
@Getter
public class ThievingChest
{
	/**
	 * If the chest has never been opened, it could have bats.
	 */
	@Setter
	private boolean everOpened;

	/**
	 * If the chest is empty, it could have bats.
	 */
	@Setter
	private boolean empty;

	/**
	 * If the chest contains a poison trap instead.
	 */
	@Setter
	private boolean poison;


	@Setter
	private int chestId;

	private final WorldPoint localPoint;
	private final InstancePoint instancePoint;

	/**
	 * Constructor for a ThievingChest object
	 *
	 * @param gameObject The gameobject thats corresponds with this trap.
	 */
	ThievingChest(GameObject gameObject, InstancePoint instancePoint)
	{
		this.everOpened = false;
		this.poison = false;
		this.empty = false;
		localPoint = gameObject.getWorldLocation();
		this.instancePoint = instancePoint;
		this.chestId = -1;
	}

}
