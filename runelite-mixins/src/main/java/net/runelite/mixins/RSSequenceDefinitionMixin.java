package net.runelite.mixins;

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSSequenceDefinition;

@Mixin(RSSequenceDefinition.class)
public abstract class RSSequenceDefinitionMixin implements RSSequenceDefinition
{
	@Shadow("client")
	private static RSClient client;

	@Copy("animateSequence2")
	public abstract RSModel rs$applyTransformations(RSModel model, int actionFrame, RSSequenceDefinition poseSeq, int poseFrame);

	@Replace("animateSequence2")
	public RSModel rl$applyTransformations(RSModel model, int actionFrame, RSSequenceDefinition poseSeq, int poseFrame)
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

	@Copy("animateSequence")
	public abstract RSModel rs$transformActorModel(RSModel model, int frameIdx);

	@Replace("animateSequence")
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

	@Copy("animateObject")
	public abstract RSModel rs$transformObjectModel(RSModel model, int frame, int rotation);

	@Replace("animateObject")
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

	@Copy("animateSpotAnimation")
	public abstract RSModel rs$transformSpotAnimModel(RSModel model, int frame);

	@Replace("animateSpotAnimation")
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
