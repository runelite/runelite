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

import java.awt.Canvas;
import java.awt.Dimension;
import net.runelite.api.Constants;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class StretchedFixedModeMixin implements RSClient
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
	private static Dimension cachedStretchedDimensions;

	@Inject
	private static Dimension lastCanvasDimensions;

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
		cachedStretchedDimensions = null;
	}

	@Inject
	@Override
	public void setStretchedKeepAspectRatio(boolean state)
	{
		stretchedKeepAspectRatio = state;
		cachedStretchedDimensions = null;
	}

	@Inject
	@Override
	public Dimension getRealDimensions()
	{
		if (isStretchedEnabled() && !isResized())
		{
			return Constants.GAME_FIXED_SIZE;
		}

		return getCanvas().getSize();
	}

	@Inject
	@Override
	public Dimension getStretchedDimensions()
	{
		Canvas canvas = getCanvas();

		int width = canvas.getParent().getWidth();
		int height = canvas.getParent().getHeight();

		if (cachedStretchedDimensions == null || width != lastCanvasDimensions.width || height != lastCanvasDimensions.height)
		{
			if (stretchedKeepAspectRatio)
			{
				int tempNewWidth = (int) (height * Constants.GAME_FIXED_ASPECT_RATIO);

				if (tempNewWidth > canvas.getWidth())
				{
					height = (int) (width / Constants.GAME_FIXED_ASPECT_RATIO);
				}
				else
				{
					width = tempNewWidth;
				}
			}

			if (stretchedIntegerScaling)
			{
				if (width > Constants.GAME_FIXED_WIDTH)
				{
					width = width - (width % Constants.GAME_FIXED_WIDTH);
				}
				if (height > Constants.GAME_FIXED_HEIGHT)
				{
					height = height - (height % Constants.GAME_FIXED_HEIGHT);
				}
			}

			cachedStretchedDimensions = new Dimension(width, height);
			lastCanvasDimensions = new Dimension(width, height);
		}

		return cachedStretchedDimensions;
	}
}
