package net.runelite.client.ui.tweenengine.equations;

import net.runelite.client.ui.tweenengine.TweenEquation;

/**
 * Easing equation based on Robert Penner's work:
 * http://robertpenner.com/easing/
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class Expo extends TweenEquation
{
	public static final Expo IN = new Expo()
	{
		@Override
		public final float compute(float t)
		{
			return (t == 0) ? 0 : (float) Math.pow(2, 10 * (t - 1));
		}

		@Override
		public String toString()
		{
			return "Expo.IN";
		}
	};

	public static final Expo OUT = new Expo()
	{
		@Override
		public final float compute(float t)
		{
			return (t == 1) ? 1 : -(float) Math.pow(2, -10 * t) + 1;
		}

		@Override
		public String toString()
		{
			return "Expo.OUT";
		}
	};

	public static final Expo INOUT = new Expo()
	{
		@Override
		public final float compute(float t)
		{
			if (t == 0) return 0;
			if (t == 1) return 1;
			if ((t *= 2) < 1) return 0.5f * (float) Math.pow(2, 10 * (t - 1));
			return 0.5f * (-(float) Math.pow(2, -10 * --t) + 2);
		}

		@Override
		public String toString()
		{
			return "Expo.INOUT";
		}
	};
}