package net.runelite.client.ui.tweenengine.equations;

import net.runelite.client.ui.tweenengine.TweenEquation;

/**
 * Easing equation based on Robert Penner's work:
 * http://robertpenner.com/easing/
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class Quint extends TweenEquation
{
	public static final Quint IN = new Quint()
	{
		@Override
		public final float compute(float t)
		{
			return t * t * t * t * t;
		}

		@Override
		public String toString()
		{
			return "Quint.IN";
		}
	};

	public static final Quint OUT = new Quint()
	{
		@Override
		public final float compute(float t)
		{
			return (t -= 1) * t * t * t * t + 1;
		}

		@Override
		public String toString()
		{
			return "Quint.OUT";
		}
	};

	public static final Quint INOUT = new Quint()
	{
		@Override
		public final float compute(float t)
		{
			if ((t *= 2) < 1) return 0.5f * t * t * t * t * t;
			return 0.5f * ((t -= 2) * t * t * t * t + 2);
		}

		@Override
		public String toString()
		{
			return "Quint.INOUT";
		}
	};
}