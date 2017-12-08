package net.runelite.client.ui.tweenengine.equations;

import net.runelite.client.ui.tweenengine.TweenEquation;

/**
 * Easing equation based on Robert Penner's work:
 * http://robertpenner.com/easing/
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class Back extends TweenEquation
{
	public static final Back IN = new Back()
	{
		@Override
		public final float compute(float t)
		{
			float s = param_s;
			return t * t * ((s + 1) * t - s);
		}

		@Override
		public String toString()
		{
			return "Back.IN";
		}
	};

	public static final Back OUT = new Back()
	{
		@Override
		public final float compute(float t)
		{
			float s = param_s;
			return (t -= 1) * t * ((s + 1) * t + s) + 1;
		}

		@Override
		public String toString()
		{
			return "Back.OUT";
		}
	};

	public static final Back INOUT = new Back()
	{
		@Override
		public final float compute(float t)
		{
			float s = param_s;
			if ((t *= 2) < 1) return 0.5f * (t * t * (((s *= (1.525f)) + 1) * t - s));
			return 0.5f * ((t -= 2) * t * (((s *= (1.525f)) + 1) * t + s) + 2);
		}

		@Override
		public String toString()
		{
			return "Back.INOUT";
		}
	};

	// -------------------------------------------------------------------------

	protected float param_s = 1.70158f;

	public Back s(float s)
	{
		param_s = s;
		return this;
	}
}