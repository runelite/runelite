/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.api;

import lombok.Data;

/**
 * stores information about freezes.
 * queuedTicks can vary depending on whether we assumed we have pid or not. when others get frozen we always assume
 * we have pid, otherwise refreezes could happen whilst it shows immunity and inaccurate information will display
 */
@Data
public class FreezeInfo
{
	public enum FreezeState
	{
		FROZEN,
		IMMUNE,
		QUEUED,

		NONE
	}

	/**
	 * on which tick this freeze gets activated, can vary depending on pid or not.
	 * We assume we always have pid against other players and players never have pid against npcs
	 */
	private int queued;

	/**
	 * the remaining frozen ticks
	 */
	private int frozen;

	/**
	 * the remaining immune
	 */
	private int immune;

	/**
	 * the type of freeze applied. To know which sprite to display
	 * null upon initialisation and when no freeze is activate.
	 * This value will also be null whilst immune and if this type is set during immunity
	 * it's for the queued freeze.
	 * As a result this value should never be null when the State is either QUEUED or FROZEN
	 */
	private FreezeType type;

	/**
	 * Easy method to determine which state this object is currently in
	 * @return the current state of the freeze
	 */
	public FreezeState getState()
	{
		if (queued > 0)
			return FreezeState.QUEUED;
		if (frozen > 0)
			return FreezeState.FROZEN;
		if (immune > 0)
			return FreezeState.IMMUNE;

		return FreezeState.NONE;
	}
}
