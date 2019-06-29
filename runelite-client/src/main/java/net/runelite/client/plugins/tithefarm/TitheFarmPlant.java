/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.tithefarm;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;

class TitheFarmPlant
{
	private static final Duration PLANT_TIME = Duration.ofMinutes(1);

	@Getter
	@Setter
	private Instant planted;

	@Getter
	private final TitheFarmPlantState state;

	@Getter
	private final TitheFarmPlantType type;

	@Getter
	private final GameObject gameObject;

	@Getter
	private final WorldPoint worldLocation;

	TitheFarmPlant(TitheFarmPlantState state, TitheFarmPlantType type, GameObject gameObject)
	{
		this.planted = Instant.now();
		this.state = state;
		this.type = type;
		this.gameObject = gameObject;
		this.worldLocation = gameObject.getWorldLocation();
	}

	public double getPlantTimeRelative()
	{
		Duration duration = Duration.between(planted, Instant.now());
		return duration.compareTo(PLANT_TIME) < 0 ? (double) duration.toMillis() / PLANT_TIME.toMillis() : 1;
	}
}
