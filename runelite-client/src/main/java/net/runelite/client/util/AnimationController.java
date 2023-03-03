/*
 * Copyright (c) 2023, LlemonDuck <napkinorton@gmail.com>
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

package net.runelite.client.util;

import lombok.Setter;
import net.runelite.api.Animation;
import net.runelite.api.AnimationType;
import net.runelite.api.Client;
import net.runelite.api.Model;

/**
 * Can be used to track and apply animations to models. Useful when handling complex RuneLiteObject animations.
 *
 * @see net.runelite.api.RuneLiteObject
 */
public class AnimationController
{

	private final Animation animation;

	/**
	 * Runs a callback when the animation reaches its end.
	 * For example, can be used to despawn a RuneLiteObject after the animation plays once.
	 * If unset, the animation will loop instead.
	 */
	@Setter
	private Runnable onFinished;

	private int elapsedTicksThisFrame;
	private int frameID;

	public AnimationController(Animation animation)
	{
		this.animation = animation;
	}

	public AnimationController(Client client, int animId)
	{
		this.animation = client.loadAnimation(animId);
	}

	public Model transformModel(Model m)
	{
		return animation.transformModel(m, this.frameID);
	}

	public void tick(int ticks)
	{
		this.elapsedTicksThisFrame += ticks;
		if (this.animation.getType() == AnimationType.VARIABLE_FRAME_LENGTH)
		{
			int[] frameLengths = this.animation.getFrameLengths();
			while (this.elapsedTicksThisFrame > frameLengths[this.frameID])
			{
				this.elapsedTicksThisFrame -= frameLengths[this.frameID];
				++this.frameID;
				if (this.frameID >= this.animation.getTotalFrames())
				{
					checkFinished();
					break;
				}
			}
		}
		else
		{
			this.frameID += ticks;
			if (this.frameID >= this.animation.getTotalFrames())
			{
				checkFinished();
			}
		}
	}

	private void checkFinished()
	{
		if (this.onFinished != null)
		{
			this.onFinished.run();
			return;
		}

		this.frameID = 0;
		this.elapsedTicksThisFrame = 0;
	}

}
