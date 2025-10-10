/*
 * Copyright (c) 2021, Trevor <https://github.com/Trevor159>
 * Copyright (c) 2021 Abex
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
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.coords.LocalPoint;

@RequiredArgsConstructor
public class RuneLiteObject extends RuneLiteObjectController
{
	private final Client client;

	@Getter
	private Model baseModel;

	/**
	 * The animation of the RuneLiteObject.
	 * If animation is null then the model will be static.
	 */
	@Getter
	@Nullable
	private AnimationController animationController;

	/**
	 * The optional pose animation of the RuneLiteObject.
	 * If animation is null then the model from {@link RuneLiteObject#animationController} will be used.
	 */
	@Setter
	@Getter
	@Nullable
	private AnimationController poseAnimationController;

	@Getter
	@Setter
	private int startCycle;

	// tri-state for unset, true, false. Legacy option for pre-RuneLiteObjectController.
	private Boolean shouldLoop;

	/**
	 * Sets whether the animation of the RuneLiteObject should loop when the animation ends.
	 * If this is false the object will despawn when the animation ends.
	 * Does nothing if the animation is null.
	 *
	 * @deprecated Use {@link AnimationController#setOnFinished(Consumer)} with {@link AnimationController#loop()} instead.
	 */
	@Deprecated
	public void setShouldLoop(boolean shouldLoop)
	{
		this.shouldLoop = shouldLoop;
		updateAnimationControllerLooping();
	}

	/**
	 * Sets the model to be rendered.
	 * If {@link RuneLiteObject#animationController} is not null, this model will be passed to {@link AnimationController#animate(Model)}.
	 */
	public void setModel(Model baseModel)
	{
		this.baseModel = baseModel;
	}

	/**
	 * Sets the location in the scene for the RuneLiteObject
	 */
	@Override
	public void setLocation(LocalPoint point, int level)
	{
		boolean needReregister = isActive() && point.getWorldView() != getWorldView();
		if (needReregister)
		{
			setActive(false);
		}

		super.setLocation(point, level);
		setZ(Perspective.getTileHeight(client, point, level));

		if (needReregister)
		{
			setActive(true);
		}
	}

	/**
	 * Sets the animation of the RuneLiteObject.
	 * If animation is null, the model will be static.
	 */
	public void setAnimation(Animation animation)
	{
		setAnimationController(new AnimationController(client, animation));
	}

	/**
	 * Sets the animation controller of the RuneLiteObject.
	 * If animationController is null, the model will be static.
	 */
	public void setAnimationController(@Nullable AnimationController animationController)
	{
		this.animationController = animationController;
		updateAnimationControllerLooping();
	}

	/**
	 * Sets the state of the RuneLiteObject.
	 * Set to true to spawn the object.
	 * Set to false to despawn the object.
	 */
	public void setActive(boolean active)
	{
		if (active)
		{
			client.registerRuneLiteObject(this);
		}
		else
		{
			client.removeRuneLiteObject(this);
		}
	}

	/**
	 * Gets the state of the RuneLiteObject
	 *
	 * @return true if the RuneLiteObject is added to the scene
	 */
	public boolean isActive()
	{
		return client.isRuneLiteObjectRegistered(this);
	}

	/**
	 * Called every frame the RuneLiteObject is registered and in the scene
	 *
	 * @param ticksSinceLastFrame The number of client ticks since the last frame
	 */
	@Override
	public void tick(int ticksSinceLastFrame)
	{
		if (animationController != null)
		{
			animationController.tick(ticksSinceLastFrame);
		}
	}

	/**
	 * Called every frame to get a model to render. The returned model is not modified and
	 * can be a shared model.
	 */
	@Override
	public Model getModel()
	{
		if (animationController != null)
		{
			return animationController.animate(this.baseModel, this.poseAnimationController);
		}
		else if (poseAnimationController != null)
		{
			return poseAnimationController.animate(this.baseModel);
		}
		else
		{
			return baseModel;
		}
	}

	/**
	 * @deprecated Use a custom {@link AnimationController} instead.
	 */
	@Deprecated
	public boolean finished()
	{
		return !this.isActive();
	}

	/**
	 * @deprecated Use a custom {@link AnimationController} instead
	 * to despawn the object when it completes its animation.
	 */
	@Deprecated
	public void setFinished(boolean finished)
	{
		if (finished)
		{
			setActive(false);
		}
	}

	/**
	 * @deprecated Use {@link #getAnimationController} or {@link #getPoseAnimationController()}
	 * followed by {@link AnimationController#getFrame()}.
	 */
	public Animation getAnimation()
	{
		if (animationController != null)
		{
			return animationController.getAnimation();
		}

		if (poseAnimationController != null)
		{
			return poseAnimationController.getAnimation();
		}

		return null;
	}

	/**
	 * @deprecated Use {@link #getAnimationController} or {@link #getPoseAnimationController()}
	 * followed by {@link AnimationController#getFrame()}.
	 */
	@Deprecated
	public int getAnimationFrame()
	{
		if (animationController != null)
		{
			return animationController.getFrame();
		}

		if (poseAnimationController != null)
		{
			return poseAnimationController.getFrame();
		}

		return -1;
	}

	private void updateAnimationControllerLooping()
	{
		if (this.shouldLoop != null && this.animationController != null)
		{
			if (this.shouldLoop)
			{
				animationController.setOnFinished(AnimationController::loop);
			}
			else
			{
				animationController.setOnFinished(_ac -> this.setActive(false));
			}
		}
	}
}
