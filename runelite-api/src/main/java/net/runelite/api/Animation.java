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
	 * Applies the animation to the model at the specified frame.
	 * {@link Mesh#cloneColors()} and {@link Mesh#cloneTransparencies()}
	 * should be called before using this method.
	 * 
	 * @param m The model to apply the animation to.
	 * @param frameId The frame ID (time step) to use from the animation.
	 *                Must be &lt;= to {@link #getTotalFrames()}.
	 * @return The transformed model, as a different reference. Some 
	 * 		   buffers may be shared with the base model, so cloneX 
	 * 		   should still be called before any mutation.
	 */
	Model transformModel(Model m, int frameId);

	/**
	 * Get the render type for this animation.
	 * @return
	 * 
	 * @see AnimationType
	 */
	AnimationType getType();

	/**
	 * Get the length of each frame in display ticks. Only valid on animations with {@link AnimationType#VARIABLE_FRAME_LENGTH}.
	 * @return An array containing the client ticks per animation frame.
	 */
	int[] getFrameLengths();

	/**
	 * Get the total amount of frames within this animation.
	 * @return
	 */
	int getTotalFrames();
}
