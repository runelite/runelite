/*
 * Copyright (c) 2020, Pratted <https://github.com/Pratted>
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
package net.runelite.client.plugins.agility;

import com.google.common.base.Stopwatch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.GameObject;
import net.runelite.api.Renderable;

import java.time.Duration;

// There is no easy way to determine if a statue is animating so this
// implementation uses the statue's renderable to determine if it is animating.
// When the renderable changes, the statue is assumed to be animating until
// the ANIMATION_TIMEOUT is exceeded.
@RequiredArgsConstructor
class CrossbowmanStatue
{

	// When this timeout is exceeded, we assume the statue stops animating.
	private static final Duration ANIMATION_TIMEOUT = Duration.ofMillis(700);

	// This stopwatch gets reset every time the renderable changes and is
	// used to determine if the statue has timed out.
	private final Stopwatch stopwatch = Stopwatch.createUnstarted();

	@Getter
	private final GameObject gameObject;
	private Renderable renderable;

	public boolean isAnimating()
	{
		// The renderable changing indicates a different frame of the animation is displayed.
		if (renderable != gameObject.getRenderable())
		{
			renderable = gameObject.getRenderable();

			// Restart the stopwatch because something has changed.
			stopwatch.reset();
			stopwatch.start();

			return true;
		}

		// The statue is assumed to be animating as long as it hasn't exceeded the timeout limit.
		return stopwatch.elapsed().toMillis() < ANIMATION_TIMEOUT.toMillis();
	}
}
