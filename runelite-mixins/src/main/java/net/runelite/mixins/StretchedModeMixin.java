/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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

import com.google.common.primitives.Ints;
import java.awt.Container;
import java.awt.Dimension;
import net.runelite.api.Constants;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class StretchedModeMixin implements RSClient
{
	@Inject
	private static boolean stretchedEnabled;

	@Inject
	private static boolean stretchedFast;

	@Inject
	private static boolean stretchedIntegerScaling;

	@Inject
	private static boolean stretchedKeepAspectRatio;

	@Inject
	private static double scalingFactor;

	@Inject
	private static Dimension cachedStretchedDimensions;

	@Inject
	private static Dimension cachedRealDimensions;

	@Inject
	@Override
	public boolean isStretchedEnabled()
	{
		return stretchedEnabled;
	}

	@Inject
	@Override
	public void setStretchedEnabled(boolean state)
	{
		stretchedEnabled = state;
	}

	@Inject
	@Override
	public boolean isStretchedFast()
	{
		return stretchedFast;
	}

	@Inject
	@Override
	public void setStretchedFast(boolean state)
	{
		stretchedFast = state;
	}

	@Inject
	@Override
	public void setStretchedIntegerScaling(boolean state)
	{
		stretchedIntegerScaling = state;
	}

	@Inject
	@Override
	public void setStretchedKeepAspectRatio(boolean state)
	{
		stretchedKeepAspectRatio = state;
	}

	@Inject
	@Override
	public void setScalingFactor(int factor)
	{
		factor = Ints.constrainToRange(factor, 0, 100);

		scalingFactor = (100 - factor) / 100D;
	}

	@Inject
	@Override
	public Dimension getRealDimensions()
	{
		if (!isStretchedEnabled())
		{
			return getCanvas().getSize();
		}

		if (cachedRealDimensions == null)
		{
			if (isResized())
			{
				Container canvasParent = getCanvas().getParent();

				int parentWidth = canvasParent.getWidth();
				int parentHeight = canvasParent.getHeight();

				int widthOffset = parentWidth - Constants.GAME_FIXED_WIDTH;
				int heightOffset = parentHeight - Constants.GAME_FIXED_HEIGHT;

				int newWidth = Constants.GAME_FIXED_WIDTH + (int) (widthOffset * scalingFactor);
				int newHeight = Constants.GAME_FIXED_HEIGHT + (int) (heightOffset * scalingFactor);

				cachedRealDimensions = new Dimension(newWidth, newHeight);
			}
			else
			{
				cachedRealDimensions = Constants.GAME_FIXED_SIZE;
			}
		}

		return cachedRealDimensions;
	}

	@Inject
	@Override
	public Dimension getStretchedDimensions()
	{
		if (cachedStretchedDimensions == null)
		{
			Container canvasParent = getCanvas().getParent();

			int parentWidth = canvasParent.getWidth();
			int parentHeight = canvasParent.getHeight();

			Dimension realDimensions = getRealDimensions();

			if (stretchedKeepAspectRatio)
			{
				double aspectRatio = realDimensions.getWidth() / realDimensions.getHeight();

				int tempNewWidth = (int) (parentHeight * aspectRatio);

				if (tempNewWidth > parentWidth)
				{
					parentHeight = (int) (parentWidth / aspectRatio);
				}
				else
				{
					parentWidth = tempNewWidth;
				}
			}

			if (stretchedIntegerScaling)
			{
				if (parentWidth > realDimensions.width)
				{
					parentWidth = parentWidth - (parentWidth % realDimensions.width);
				}
				if (parentHeight > realDimensions.height)
				{
					parentHeight = parentHeight - (parentHeight % realDimensions.height);
				}
			}

			cachedStretchedDimensions = new Dimension(parentWidth, parentHeight);
		}

		return cachedStretchedDimensions;
	}

	@Inject
	@Override
	public void invalidateStretching(boolean resize)
	{
		cachedStretchedDimensions = null;
		cachedRealDimensions = null;

		if (resize && isResized())
		{
			/*
				Tells the game to run resizeCanvas the next frame.

				resizeCanvas in turn calls the method that
				determines the maximum size of the canvas,
				AFTER setting the size of the canvas.

				The frame after that, the game sees that
				the maximum size of the canvas isn't
				the current size, so it runs resizeCanvas again.
				This time it uses our new maximum size
				as the bounds for the canvas size.

				This is useful when resizeCanvas wouldn't usually run,
				for example when we've only changed the scaling factor
				and we still want the game's canvas to resize
				with regards to the new maximum bounds.
			 */
			setResizeCanvasNextFrame(true);
		}
	}
}
