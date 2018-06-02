/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.mixins;

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSSequence;

@Mixin(RSSequence.class)
public abstract class RSSequenceMixin implements RSSequence
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Copy("applyTransformations")
	public abstract RSModel rs$applyTransformations(RSModel model, int actionFrame, RSSequence poseSeq, int poseFrame);

	@Replace("applyTransformations")
	public RSModel rl$applyTransformations(RSModel model, int actionFrame, RSSequence poseSeq, int poseFrame)
	{
		// reset frame ids because we're not interpolating this
		if (actionFrame < 0)
		{
			int packed = actionFrame ^ Integer.MIN_VALUE;
			actionFrame = packed & 0xFFFF;
		}
		if (poseFrame < 0)
		{
			int packed = poseFrame ^ Integer.MIN_VALUE;
			poseFrame = packed & 0xFFFF;
		}
		return rs$applyTransformations(model, actionFrame, poseSeq, poseFrame);
	}

	@Copy("transformActorModel")
	public abstract RSModel rs$transformActorModel(RSModel model, int frameIdx);

	@Replace("transformActorModel")
	public RSModel rl$transformActorModel(RSModel model, int frame)
	{
		// check if the frame has been modified
		if (frame < 0)
		{
			// remove flag to check if the frame has been modified
			int packed = frame ^ Integer.MIN_VALUE;
			int interval = packed >> 16;
			frame = packed & 0xFFFF;
			int nextFrame = frame + 1;
			if (nextFrame >= getFrameIDs().length)
			{
				// dont interpolate last frame
				nextFrame = -1;
			}
			int[] frameIds = getFrameIDs();
			int frameId = frameIds[frame];
			RSFrames frames = client.getFrames(frameId >> 16);
			int frameIdx = frameId & 0xFFFF;

			int nextFrameIdx = -1;
			RSFrames nextFrames = null;
			if (nextFrame != -1)
			{
				int nextFrameId = frameIds[nextFrame];
				nextFrames = client.getFrames(nextFrameId >> 16);
				nextFrameIdx = nextFrameId & 0xFFFF;
			}

			if (frames == null)
			{
				// not sure what toSharedModel does but it is needed
				return model.toSharedModel(true);
			}
			else
			{
				RSModel animatedModel = model.toSharedModel(!frames.getFrames()[frameIdx].isShowing());
				animatedModel.interpolateFrames(frames, frameIdx, nextFrames, nextFrameIdx, interval,
						getFrameLenths()[frame]);
				return animatedModel;
			}
		}
		else
		{
			return rs$transformActorModel(model, frame);
		}
	}

	@Copy("transformObjectModel")
	public abstract RSModel rs$transformObjectModel(RSModel model, int frame, int rotation);

	@Replace("transformObjectModel")
	public RSModel rl$transformObjectModel(RSModel model, int frame, int rotation)
	{
		// check if the frame has been modified
		if (frame < 0)
		{
			// remove flag to check if the frame has been modified
			int packed = frame ^ Integer.MIN_VALUE;
			int interval = packed >> 16;
			frame = packed & 0xFFFF;

			int nextFrame = frame + 1;
			if (nextFrame >= getFrameIDs().length)
			{
				// dont interpolate last frame
				nextFrame = -1;
			}
			int[] frameIds = getFrameIDs();
			int frameId = frameIds[frame];
			RSFrames frames = client.getFrames(frameId >> 16);
			int frameIdx = frameId & 0xFFFF;

			int nextFrameIdx = -1;
			RSFrames nextFrames = null;
			if (nextFrame != -1)
			{
				int nextFrameId = frameIds[nextFrame];
				nextFrames = client.getFrames(nextFrameId >> 16);
				nextFrameIdx = nextFrameId & 0xFFFF;
			}

			if (frames == null)
			{
				return model.toSharedModel(true);
			}
			else
			{
				RSModel animatedModel = model.toSharedModel(!frames.getFrames()[frameIdx].isShowing());
				// reset rotation before animating
				rotation &= 3;
				if (rotation == 1)
				{
					animatedModel.rotateY270Ccw();
				}
				else if (rotation == 2)
				{
					animatedModel.rotateY180Ccw();
				}
				else if (rotation == 3)
				{
					animatedModel.rotateY90Ccw();
				}
				animatedModel.interpolateFrames(frames, frameIdx, nextFrames, nextFrameIdx, interval,
						getFrameLenths()[frame]);
				// reapply rotation after animating
				if (rotation == 1)
				{
					animatedModel.rotateY90Ccw();
				}
				else if (rotation == 2)
				{
					animatedModel.rotateY180Ccw();
				}
				else if (rotation == 3)
				{
					animatedModel.rotateY270Ccw();
				}
				return animatedModel;
			}
		}
		else
		{
			return rs$transformObjectModel(model, frame, rotation);
		}
	}

	@Copy("transformSpotAnimModel")
	public abstract RSModel rs$transformSpotAnimModel(RSModel model, int frame);

	@Replace("transformSpotAnimModel")
	public RSModel rl$transformSpotAnimModel(RSModel model, int frame)
	{
		// check if the frame has been modified
		if (frame < 0)
		{
			// remove flag to check if the frame has been modified
			int packed = frame ^ Integer.MIN_VALUE;
			int interval = packed >> 16;
			frame = packed & 0xFFFF;
			int nextFrame = frame + 1;
			if (nextFrame >= getFrameIDs().length)
			{
				// dont interpolate last frame
				nextFrame = -1;
			}
			int[] frameIds = getFrameIDs();
			int frameId = frameIds[frame];
			RSFrames frames = client.getFrames(frameId >> 16);
			int frameIdx = frameId & 0xFFFF;

			int nextFrameIdx = -1;
			RSFrames nextFrames = null;
			if (nextFrame != -1)
			{
				int nextFrameId = frameIds[nextFrame];
				nextFrames = client.getFrames(nextFrameId >> 16);
				nextFrameIdx = nextFrameId & 0xFFFF;
			}

			if (frames == null)
			{
				return model.toSharedSpotAnimModel(true);
			}
			else
			{
				RSModel animatedModel = model.toSharedSpotAnimModel(!frames.getFrames()[frameIdx].isShowing());
				animatedModel.interpolateFrames(frames, frameIdx, nextFrames, nextFrameIdx, interval,
						getFrameLenths()[frame]);
				return animatedModel;
			}
		}
		else
		{
			return rs$transformSpotAnimModel(model, frame);
		}
	}
}
