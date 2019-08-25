package net.runelite.mixins;


import net.runelite.api.Constants;
import java.awt.Container;
import java.awt.Dimension;
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
		scalingFactor = 1 + (factor / 100D);
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

				int newWidth = (int) (parentWidth / scalingFactor);
				int newHeight = (int) (parentHeight / scalingFactor);

				if (newWidth < Constants.GAME_FIXED_WIDTH || newHeight < Constants.GAME_FIXED_HEIGHT)
				{
					double scalingFactorW = (double)parentWidth / Constants.GAME_FIXED_WIDTH;
					double scalingFactorH = (double)parentHeight / Constants.GAME_FIXED_HEIGHT;
					double scalingFactor = Math.min(scalingFactorW, scalingFactorH);

					newWidth = (int) (parentWidth / scalingFactor);
					newHeight = (int) (parentHeight / scalingFactor);
				}

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
		cachedRealDimensions = null;
		cachedStretchedDimensions = null;

		if (resize && isResized())
		{
			/*
				Tells the game to run resizeCanvas the next frame.

				This is useful when resizeCanvas wouldn't usually run,
				for example when we've only changed the scaling factor
				and we still want the game's canvas to resize
				with regards to the new maximum bounds.
			 */
			setResizeCanvasNextFrame(true);
		}
	}
}
