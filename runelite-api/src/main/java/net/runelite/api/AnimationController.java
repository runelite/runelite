/*
 * Copyright (c) 2024, LlemonDuck <napkinorton@gmail.com>
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

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class AnimationController
{
	private final Client client;

	@Getter
	@Nullable
	private Animation animation;

	@Setter
	@NonNull
	private Consumer<AnimationController> onFinished = AnimationController::loop;

	@Getter
	@Setter
	private int frame;

	private int elapsedTicks;

	public AnimationController(Client client, int animationID)
	{
		this(client, client.loadAnimation(animationID));
	}

	public AnimationController(Client client, Animation animation)
	{
		this.client = client;
		setAnimation(animation);
	}

	public void setAnimation(@Nullable Animation animation)
	{
		this.animation = animation;
		reset();
	}

	public void reset()
	{
		frame = 0;
		elapsedTicks = 0;
	}

	public void loop()
	{
		if (animation == null)
		{
			return;
		}

		frame -= animation.getFrameStep();
		if (frame < 0 || frame >= animation.getDuration())
		{
			frame = 0;
		}
	}

	public void tick(int ticks)
	{
		if (animation == null)
		{
			return;
		}

		if (animation.isMayaAnim())
		{
			frame += ticks;
			if (frame >= animation.getDuration())
			{
				onFinished.accept(this);

				if (frame < 0 || animation == null || frame >= animation.getDuration())
				{
					animation = null;
				}
			}
		}
		else
		{
			elapsedTicks += ticks;

			int[] frameLengths = animation.getFrameLengths();
			while (elapsedTicks > frameLengths[frame])
			{
				elapsedTicks -= frameLengths[frame];
				frame++;

				if (frame >= frameLengths.length)
				{
					onFinished.accept(this);

					if (frame < 0 || animation == null || frame >= frameLengths.length)
					{
						animation = null;
						return;
					}
				}
			}
		}
	}

	public Model animate(Model model)
	{
		return animate(model, null);
	}

	public Model animate(Model model, @Nullable AnimationController other)
	{
		if (other != null)
		{
			return client.applyTransformations(model, animation, getPackedFrame(), other.animation, other.getPackedFrame());
		}
		else
		{
			return client.applyTransformations(model, animation, getPackedFrame(), null, 0);
		}
	}

	private int getPackedFrame()
	{
		if (animation == null)
		{
			return 0;
		}

		IntPredicate interpFilter = client.getAnimationInterpolationFilter();
		if (interpFilter == null || !interpFilter.test(animation.getId()))
		{
			return frame;
		}

		return Integer.MIN_VALUE
			| elapsedTicks << 16
			| frame;
	}
}
