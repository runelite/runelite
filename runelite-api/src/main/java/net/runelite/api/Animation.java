/*
 * Copyright (c) 2021, Trevor <https://github.com/Trevor159>
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

/**
 * Represents an animation of a renderable
 */
public interface Animation
{
	/**
	 * Get the id for this animation
	 * @see AnimationID
	 * @return
	 */
	int getId();

	/**
	 * Is this animation a newer-style "maya" animation
	 */
	boolean isMayaAnim();

	/**
	 * Get how many distinct frames this animation has.
	 *
	 * For animaya animations, this is the duration in client ticks. For classic
	 * animations, this is how many keyframes it has, not it's duration in ticks.
	 */
	int getNumFrames();

	/**
	 * How this animation behaves when its restarted during playback
	 */
	int getRestartMode();

	/**
	 * @see #getRestartMode()
	 */
	void setRestartMode(int restartMode);

	/**
	 * How many frames the animation lasts
	 */
	int getDuration();

	/**
	 * How many frames to go back when looping
	 */
	int getFrameStep();

	/**
	 * How many ticks each frame is.
	 *
	 * {@code null} for {@link #isMayaAnim()} animations
	 */
	int[] getFrameLengths();
}
