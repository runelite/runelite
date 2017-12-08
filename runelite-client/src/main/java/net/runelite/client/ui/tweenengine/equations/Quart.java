package net.runelite.client.ui.tweenengine.equations;

import net.runelite.client.ui.tweenengine.TweenEquation;

/**
 * Easing equation based on Robert Penner's work:
 * http://robertpenner.com/easing/
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class Quart extends TweenEquation
{
	public static final Quart IN = new Quart()
	{
		@Override
		public final float compute(float t)
		{
			return t * t * t * t;
		}

		@Override
		public String toString()
		{
			return "Quart.IN";
		}
	};

	public static final Quart OUT = new Quart()
	{
		@Override
		public final float compute(float t)
		{
			return -((t -= 1) * t * t * t - 1);
		}

		@Override
		public String toString()
		{
			return "Quart.OUT";
		}
	};

	public static final Quart INOUT = new Quart()
	{
		@Override
		public final float compute(float t)
		{
			if ((t *= 2) < 1) return 0.5f * t * t * t * t;
			return -0.5f * ((t -= 2) * t * t * t - 2);
		}

		@Override
		public String toString()
		{
			return "Quart.INOUT";
		}
	};
}