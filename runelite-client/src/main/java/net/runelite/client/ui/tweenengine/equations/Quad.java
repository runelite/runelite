package net.runelite.client.ui.tweenengine.equations;

import net.runelite.client.ui.tweenengine.TweenEquation;

/**
 * Easing equation based on Robert Penner's work:
 * http://robertpenner.com/easing/
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class Quad extends TweenEquation
{
	public static final Quad IN = new Quad()
	{
		@Override
		public final float compute(float t)
		{
			return t * t;
		}

		@Override
		public String toString()
		{
			return "Quad.IN";
		}
	};

	public static final Quad OUT = new Quad()
	{
		@Override
		public final float compute(float t)
		{
			return -t * (t - 2);
		}

		@Override
		public String toString()
		{
			return "Quad.OUT";
		}
	};

	public static final Quad INOUT = new Quad()
	{
		@Override
		public final float compute(float t)
		{
			if ((t *= 2) < 1) return 0.5f * t * t;
			return -0.5f * ((--t) * (t - 2) - 1);
		}

		@Override
		public String toString()
		{
			return "Quad.INOUT";
		}
	};
}